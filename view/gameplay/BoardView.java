package view.gameplay;

import model.*;
import resource.ImageResource;
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
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image shootCursorImage = ImageResource.instance.shootCursor.getImage();
    Cursor c = toolkit.createCustomCursor(shootCursorImage, new Point(20,20), "img");
    public BoardView(Gameplay gp) {
        super(ImageResource.instance.boardImg);
        setLayout(null);

        this.gp = gp;

        for(Piece p : this.gp.getBoard().getWhitePieces()){
            whitePieceViewList.add(new PieceView(p,this));
        }
        for(PieceView pv : whitePieceViewList){
            this.add(pv);
        }

        blackPieceView = new PieceView(this.gp.getBoard().getBlackKing(),this);
        GameplayRoom.getIns().showInfoBlackPiece((BlackKing) blackPieceView.getModel());
        this.add(blackPieceView);

        borderHover = new TImage(ImageResource.instance.border);
        this.add(borderHover);

        GameplayRoom.getIns().showMsg("Lượt: "+gp.getNumberOfTurn());
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
        ComponentAnimation.shake(GameplayRoom.getIns(),5,5,200,200/4);
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


    public void updatePositionBlackPiece(){
        Tile t = blackPieceView.getModel().getStanding();
        Point temp = tileToPixel(t.x,t.y);
        ComponentAnimation.setLocation(blackPieceView,temp.x+3,temp.y+1,200);
    }
    public void updateBeforeMoveWhitePiece(){
        Iterator<PieceView> it= whitePieceViewList.iterator();
        while(it.hasNext()){
            PieceView pv = it.next();
            if(((WhitePiece)pv.getModel()).isDied()){
//                this.remove(pv);
                pv.beDestroyed();
                it.remove();
            }
        }
        for(PieceView pv : whitePieceViewList){
            WhitePiece model = (WhitePiece)pv.getModel();
            ComponentAnimation.shakeStop(pv);
            if(model.isMateFlag() && gp.isPlaying()){
                ComponentAnimation.twink(pv,500,1000/60*3);
            }
            if(model.isTakeDamageFlag() && gp.isPlaying()){
                ComponentAnimation.shake(pv,5,5,200,200/4);
                ComponentAnimation.twink(pv,200,200/4);
            }
        }
    }
    public void updateMoveWhitePiece(){
        Iterator<PieceView> it= whitePieceViewList.iterator();
        while(it.hasNext()){
            PieceView pv = it.next();
            if(((WhitePiece)pv.getModel()).isDied()){
                this.remove(pv);
                it.remove();
            }
        }
        for(int i=whitePieceViewList.size();i<gp.getBoard().getWhitePieces().size();i++){
            PieceView pv = new PieceView(gp.getBoard().getWhitePieces().get(i),this);
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
            ComponentAnimation.twink(pv,200,1000/60*5);
        }
        for(PieceView pv : whitePieceViewList){
            WhitePiece model = (WhitePiece)pv.getModel();
            Tile t = model.getStanding();
            Point temp = tileToPixel(t.x,t.y);
            ComponentAnimation.shakeStop(pv);
            ComponentAnimation.setLocation(pv,temp.x+3,temp.y+1,200);
        }
        GameplayRoom.getIns().reloadInfoWhitePiece();
//        this.setVisible(false);
//        this.setVisible(true);
    }
    public void  updateAfterMoveWhitePiece(){
        for(PieceView pv : whitePieceViewList){
            WhitePiece model = (WhitePiece)pv.getModel();
            if(model.canMove() && gp.isPlaying()){
                ComponentAnimation.shakeInfinity(pv,1,0,1000/60*5);
            }
        }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Tile t = pixelToTile(e.getX(),e.getY());
        if(t!=null ) {
            if(((BlackKing)blackPieceView.getModel()).canMoveTo(t)) {
                borderHover.setSize(
                        tileToPixel(2, 2).x - tileToPixel(1, 1).x,
                        tileToPixel(2, 2).y - tileToPixel(1, 1).y
                );
                borderHover.setLocation(tileToPixel(t));
                this.setCursor(Cursor.getDefaultCursor());
            }else {
                borderHover.setSize(0,0);
                this.setCursor(c);
            }
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
            assert t != null;
            if(t.equals(blackPieceView.getModel().getStanding()))return;
            Point blackKingPoint = blackPieceView.getLocation();
            blackKingPoint.x+=blackPieceView.getWidth()/2;
            blackKingPoint.y+=blackPieceView.getHeight()/2;
            Point mousePoint = e.getPoint();
            double distance = Math.sqrt(Math.pow(blackKingPoint.x-mousePoint.x,2)+Math.pow(blackKingPoint.y-mousePoint.y,2));
            double angleCos = Math.acos((mousePoint.x-blackKingPoint.x)/distance);
            double angleSin = Math.asin((mousePoint.y-blackKingPoint.y)/distance);
            double angle = angleCos;
            if(angleSin<0)angle=-angle;
            gp.blackMoveAction(t, angle, this);
            updatePositionBlackPiece();
            updateBeforeMoveWhitePiece();
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            updateMoveWhitePiece();
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            if(!gp.isPlaying()){
                GameplayRoom.getIns().endOneFloor();
                return;
            }
            updateAfterMoveWhitePiece();
            GameplayRoom.getIns().reloadInfoBlackPiece();
            GameplayRoom.getIns().showMsg("Lượt: "+gp.getNumberOfTurn());
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
        borderHover.setSize(0,0);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        super.componentResized(e);
        borderHover.setSize(0,0);
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
                ComponentAnimation.shakeInfinity(pv,2,0,1000/60*5);
//            pv.setVisible(false);
//            pv.setVisible(true);
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
