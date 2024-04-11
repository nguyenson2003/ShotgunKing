package view;

import model.*;
import view.general.TImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class PieceView extends JLabel {
    TImage img;
    Piece model;
    BoardView boardView;
    public PieceView(Piece piece, BoardView boardView) {
        String relativePath;
        if(piece instanceof Pawn){
            relativePath = "../img/pawn.png";
        } else if (piece instanceof Knight) {
            relativePath = "../img/knight.png";
        } else if (piece instanceof Bishop) {
            relativePath = "../img/bishop.png";
        } else if (piece instanceof Rook) {
            relativePath = "../img/rook.png";
        } else if (piece instanceof Queen) {
            relativePath = "../img/queen.png";
        } else if (piece instanceof King) {
            relativePath = "../img/king.png";
        } else if (piece instanceof BlackKing) {
            relativePath = "../img/blackking.png";
        } else{
            relativePath = "../img/pawn.png";
        }
        img=new TImage(new ImageIcon(URLDecoder.decode(
                Objects.requireNonNull(BoardView.class.getResource(relativePath)).getPath(),
                StandardCharsets.UTF_8
        )));
        this.setLayout(new BorderLayout());
        this.add(img);
        this.model=piece;
        this.boardView=boardView;
//        this.addMouseListener(this);
    }

    public Piece getModel() {
        return model;
    }

//    @Override
//    public void mouseClicked(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//        if(model instanceof WhitePiece p)
//            GameplayRoom.getIns().showInfoWhitePiece(p);
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//        GameplayRoom.getIns().hideInfoWhitePiece();
//    }
}
