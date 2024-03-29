package view;

import model.*;
import view.general.General;
import view.general.TImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

public class BoardView extends TImage implements MouseMotionListener,MouseListener, ComponentListener {
    Board board;
    Gameplay gp;
    ArrayList<PieceView> whitePieceViewList = new ArrayList<>();
    PieceView blackPieceView;
    TImage borderHover;
    public BoardView(Board board) {
        super(new ImageIcon(URLDecoder.decode(
                Objects.requireNonNull(BoardView.class.getResource("../img/board.png")).getPath(),
                StandardCharsets.UTF_8
        )));
        setLayout(null);

        this.board=board;
        this.gp = new Gameplay(this.board);

        for(Piece p : this.board.getWhitePieces()){
            whitePieceViewList.add(new PieceView(p));
        }
        for(PieceView pv : whitePieceViewList){
            this.add(pv);
        }

        blackPieceView = new PieceView(this.board.getBlackKing());
        this.add(blackPieceView);

        borderHover = new TImage(
                new ImageIcon(URLDecoder.decode(
                        Objects.requireNonNull(BoardView.class.getResource("../img/border.png")).getPath(),
                        StandardCharsets.UTF_8
                ))
        );
        this.add(borderHover);

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
    public void updatePositionWhitePiece(){
        for(PieceView pv : whitePieceViewList){
            Tile t = pv.getModel().getStanding();
            Point temp = tileToPixel(t.x,t.y);

            General.ComponentAnimation.setLocation(pv,temp.x+3,temp.y+1,200);
            General.ComponentAnimation.setSize(pv,getCloneIcon().getIconWidth()/8-6,getCloneIcon().getIconHeight()/8-6,100);
//            pv.setBounds(
//                    temp.x+3,
//                    temp.y+1,
//                    getCloneIcon().getIconWidth()/8-6,
//                    getCloneIcon().getIconHeight()/8-6
//            );
            pv.setVisible(false);
            pv.setVisible(true);
        }
    }
    public void updatePositionBlackPiece(){
        Tile t = blackPieceView.getModel().getStanding();
        Point temp = tileToPixel(t.x,t.y);
        General.ComponentAnimation.setLocation(blackPieceView,temp.x+3,temp.y+1,200);
        General.ComponentAnimation.setSize(blackPieceView,getCloneIcon().getIconWidth()/8-6,getCloneIcon().getIconHeight()/8-6,100);
//        blackPieceView.setBounds(
//                temp.x+3,
//                temp.y+1,
//                getCloneIcon().getIconWidth()/8-6,
//                getCloneIcon().getIconHeight()/8-6
//        );
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
        }else{
            borderHover.setSize(0,0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
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

        System.out.println(angle);
        if(t!=null) {
//            ((BlackKing) (blackPieceView.model)).move(t);
            gp.blackMoveAction(t,angle);

        }
        updatePositionBlackPiece();
        updatePositionWhitePiece();
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

        for(PieceView pv : whitePieceViewList){
            Tile t = pv.getModel().getStanding();
            Point temp = tileToPixel(t.x,t.y);
            pv.setBounds(
                    temp.x+3,
                    temp.y+1,
                    getCloneIcon().getIconWidth()/8-6,
                    getCloneIcon().getIconHeight()/8-6
            );
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
