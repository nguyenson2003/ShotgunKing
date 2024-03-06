package view;

import model.BlackKing;
import model.Pawn;
import model.Piece;
import view.general.TImage;

import javax.swing.*;
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
