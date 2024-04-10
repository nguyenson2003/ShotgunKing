package view;

import model.*;
import view.general.ComponentAnimation;
import view.general.TImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class BoardView extends TImage implements MouseMotionListener,MouseListener,ComponentListener {
    Gameplay gp;
    ArrayList<PieceView> whitePieceViewList = new ArrayList<>();
    PieceView blackPieceView;
    TImage borderHover;
    boolean canClickMouse = false;
    public BoardView() {
        super(new ImageIcon(URLDecoder.decode(
                Objects.requireNonNull(BoardView.class.getResource("../img/board.png")).getPath(),
                StandardCharsets.UTF_8
        )));
        setLayout(null);

        this.gp = new Gameplay();

        for(Piece p : this.gp.getBoard().getWhitePieces()){
            whitePieceViewList.add(new PieceView(p));
        }
        for(PieceView pv : whitePieceViewList){
            this.add(pv);
        }

        blackPieceView = new PieceView(this.gp.getBoard().getBlackKing());
        GameplayRoom.getIns().showInfoBlackPiece((BlackKing) blackPieceView.getModel());
        this.add(blackPieceView);

        borderHover = new TImage(
                new ImageIcon(URLDecoder.decode(
                        Objects.requireNonNull(BoardView.class.getResource("../img/border.png")).getPath(),
                        StandardCharsets.UTF_8
                ))
        );
        this.add(borderHover);

        canClickMouse=true;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addComponentListener(this);
    }

    private Tile pixelToTile(int x, int y){
        int tileX = (int) Math.floor ((x - (getWidth() - getCloneIcon().getIconWidth()) / 2.0) /getCloneIcon().getIconWidth()*8);
        int tileY = (int) Math.floor ((y - (getHeight() - getCloneIcon().getIconHeight()) / 2.0) /getCloneIcon().getIconHeight()*8);
        tileX++;tileY++;
        if(tileX<1 || tileY<1 || tileX>8 || tileY>8) return null;
        else return new Tile(tileX,tileY);
    }
    public Point tileToPixel(Tile t){
        return tileToPixel(t.x,t.y);
    }
    public Point tileToPixel(int tileX, int tileY){
        int x = (int)((tileX-1)*(getCloneIcon().getIconWidth()/8.0)+(getWidth() - getCloneIcon().getIconWidth())/2.0);
        int y = (int)((tileY-1)*(getCloneIcon().getIconHeight()/8.0)+(getHeight() - getCloneIcon().getIconHeight())/2.0);
        return new Point(x,y);
    }
    public Point tileDoubleToPixel(double tileX, double tileY){
        int x = (int)((tileX-1)*(getCloneIcon().getIconWidth()/8.0)+(getWidth() - getCloneIcon().getIconWidth())/2.0);
        int y = (int)((tileY-1)*(getCloneIcon().getIconHeight()/8.0)+(getHeight() - getCloneIcon().getIconHeight())/2.0);
        return new Point(x,y);
    }
    public void drawABullet(double startBulletX, double startBulletY,double endBulletX, double endBulletY){
        Point p1 = tileDoubleToPixel(startBulletX,startBulletY);
        Point p12= tileDoubleToPixel((startBulletX+endBulletX)/2,(startBulletY+endBulletY)/2);
        Point p2 = tileDoubleToPixel(endBulletX,endBulletY);
        new Thread(() -> {
            Graphics g = getGraphics();
            int count = 0;
//            do {
//                count++;
            g.setColor(Color.red);
            g.drawLine(p1.x,p1.y,p12.x,p12.y);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            BoardView.this.repaint();
            g.drawLine(p12.x,p12.y,p2.x,p2.y);
//            } while (count < 2);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            BoardView.this.repaint();
        }).start();
    }
    public void updatePositionWhitePiece(){
        Iterator<PieceView> it= whitePieceViewList.iterator();
        while(it.hasNext()){
            PieceView pv = it.next();
            if(((WhitePiece)pv.getModel()).isDied()){
                this.remove(pv);
                it.remove();
            }
        }
        loopAddPieceView:
        for(WhitePiece whitePiece:gp.getBoard().getWhitePieces()){
            for(PieceView pieceView:whitePieceViewList){
                if(whitePiece==pieceView.getModel())continue loopAddPieceView;
            }
            PieceView pv = new PieceView(whitePiece);
            whitePieceViewList.add(pv);
            this.add(pv);
            Tile t = pv.getModel().getStanding();
            Point temp = tileToPixel(t.x,t.y);
            pv.setBounds(
                    temp.x+3,
                    temp.y+1,
                    getCloneIcon().getIconWidth()/8-6,
                    getCloneIcon().getIconHeight()/8-6
            );
            ComponentAnimation.twink(pv,200);
        }
        for(PieceView pv : whitePieceViewList){
            WhitePiece model = (WhitePiece)pv.getModel();
            Tile t = model.getStanding();
            Point temp = tileToPixel(t.x,t.y);
            // ComponentAnimation.shakeStop(pv);

            ComponentAnimation.setLocation(pv,temp.x+3,temp.y+1,200);
            ComponentAnimation.shakeStop(pv);
            if(model.canMove() && gp.isPlaying()){
                ComponentAnimation.shakeInfinity(pv,5,0);
            }
            if((model.isMateFlag() || model.isTakeDamageFlag()) && gp.isPlaying()){
                ComponentAnimation.twink(pv,100);
            }
            pv.setVisible(false);
            pv.setVisible(true);
        }
        GameplayRoom.getIns().reloadInfoWhitePiece();
        this.setVisible(false);
        this.setVisible(true);
    }

    public void updatePositionBlackPiece(){
        Tile t = blackPieceView.getModel().getStanding();
        Point temp = tileToPixel(t.x,t.y);
        ComponentAnimation.setLocation(blackPieceView,temp.x+3,temp.y+1,200);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Tile t = pixelToTile(e.getX(),e.getY());
        if(t!=null) {
            GameplayRoom.getIns().showMsg(t.toString());
            borderHover.setSize(
                    tileToPixel(2,2).x-tileToPixel(1,1).x,
                    tileToPixel(2,2).y-tileToPixel(1,1).y
            );
            borderHover.setLocation(tileToPixel(t));
            Piece p = gp.getBoard().getPiece(t);
            if(p instanceof WhitePiece wp){
                GameplayRoom.getIns().showInfoWhitePiece(wp);
            }else{
                GameplayRoom.getIns().hideInfoWhitePiece();
            }
        }else{
            borderHover.setSize(0,0);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!canClickMouse)return;
        new Thread(() -> {

            Tile t = pixelToTile(e.getX(),e.getY());
            Point blackKingPoint = blackPieceView.getLocation();
            blackKingPoint.x+=blackPieceView.getWidth()/2;
            blackKingPoint.y+=blackPieceView.getHeight()/2;
            Point mousePoint = e.getPoint();
            double distance = Math.sqrt(Math.pow(blackKingPoint.x-mousePoint.x,2)+Math.pow(blackKingPoint.y-mousePoint.y,2));
            double angleCos = Math.acos((mousePoint.x-blackKingPoint.x)/distance);
            double angleSin = Math.asin((mousePoint.y-blackKingPoint.y)/distance);
            double angle = angleCos;
            if(angleSin<0)angle=-angle;
            if(t!=null) {
    //            ((BlackKing) (blackPieceView.model)).move(t);
                gp.blackMoveAction(t,angle);

            }
            updatePositionBlackPiece();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            updatePositionWhitePiece();
            GameplayRoom.getIns().reloadInfoBlackPiece();
            canClickMouse=true;
        }).start();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void componentResized(ComponentEvent e) {
        super.componentResized(e);
        for(PieceView pv : whitePieceViewList){
            ComponentAnimation.shakeStop(pv);
            Tile t = pv.getModel().getStanding();
            Point temp = tileToPixel(t.x,t.y);
            pv.setBounds(
                    temp.x+3,
                    temp.y+1,
                    getCloneIcon().getIconWidth()/8-6,
                    getCloneIcon().getIconHeight()/8-6
            );


            if(((WhitePiece)pv.getModel()).canMove() && gp.isPlaying())
                ComponentAnimation.shakeInfinity(pv,5,0);
            pv.setVisible(false);
            pv.setVisible(true);
        }

        Tile t = blackPieceView.getModel().getStanding();
        Point temp = tileToPixel(t.x,t.y);
        blackPieceView.setBounds(
                temp.x+3,
                temp.y+1,
                getCloneIcon().getIconWidth()/8-6,
                getCloneIcon().getIconHeight()/8-6
        );
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
