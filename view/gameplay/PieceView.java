package view.gameplay;

import model.*;
import resource.ImageResource;
import view.general.TImage;

import javax.swing.*;
import java.awt.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class PieceView extends JLabel {
    TImage img;
    Piece model;
    BoardView boardView;
    public PieceView(Piece piece, BoardView boardView) {
        img = new TImage(ImageResource.instance.getImgOfPiece(piece));
        this.setLayout(new BorderLayout());
        this.add(img);
        this.model=piece;
        this.boardView=boardView;
//        this.addMouseListener(this);
    }

    public Piece getModel() {
        return model;
    }


}
