package view;

import model.BlackKing;
import model.Board;
import model.Piece;
import model.Tile;
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
    ArrayList<PieceView> whitePieceViewList = new ArrayList<>();
    PieceView blackPieceView;
    TImage borderHover;
    public BoardView(Board board_) {
        super(new ImageIcon(URLDecoder.decode(
                Objects.requireNonNull(BoardView.class.getResource("../img/board.png")).getPath(),
                StandardCharsets.UTF_8
        )));
        setLayout(null);

        this.board=board_;
        for(Piece p : board.getWhitePieces()){
            whitePieceViewList.add(new PieceView(p));
        }
        for(PieceView pv : whitePieceViewList){
            this.add(pv);
        }

        blackPieceView = new PieceView(board.getBlackKing());
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
            pv.setBounds(
                    temp.x+3,
                    temp.y+1,
                    getCloneIcon().getIconWidth()/8-6,
                    getCloneIcon().getIconHeight()/8-6
            );
            pv.setVisible(false);
            pv.setVisible(true);
        }
    }
    public void updatePositionBlackPiece(){
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
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Tile t = pixelToTile(e.getX(),e.getY());
        if(t!=null) {
            rm_Gameplay.getIns().showMsg(t.toString());
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
        if(t!=null)
            ((BlackKing)(blackPieceView.model)).move(t);
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
