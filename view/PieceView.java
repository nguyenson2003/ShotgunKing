package view;

import model.*;
import view.general.TImage;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class PieceView extends JLabel {
    TImage img;
    Piece model;
    public PieceView(Piece piece) {
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
        } else if (piece instanceof WhiteKing) {
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
    }

    public Piece getModel() {
        return model;
    }
}
