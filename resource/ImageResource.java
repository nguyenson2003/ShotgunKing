package resource;

import model.*;
import view.gameplay.BoardView;
import view.general.TImage;

import javax.swing.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class ImageResource {
    public static final ImageResource instance = new ImageResource();
    // ../img/piece/....png
    public final ImageIcon pawnImg,rookImg,knightImg,bishopImg,queenImg,kingImg,blackKingImg;
    public final ImageIcon boardImg;

    // ../img/icon/....png
    public final ImageIcon ammo1,ammo2,blank,border,shadow,shield1,shield2,shootCursor;
    // ../img/card/....png
    public final ImageIcon flipBlack,flipWhite;
    private ImageResource(){
        // 1
        pawnImg = createImg("../img/piece/pawn.png");
        rookImg = createImg("../img/piece/rook.png");
        knightImg = createImg("../img/piece/knight.png");
        bishopImg = createImg("../img/piece/bishop.png");
        queenImg = createImg("../img/piece/queen.png");
        kingImg = createImg("../img/piece/king.png");
        blackKingImg = createImg("../img/piece/blackking.png");
        boardImg = createImg("../img/piece/board.png");
        // 2
        ammo1 = createImg("../img/icon/ammo1.png");
        ammo2 = createImg("../img/icon/ammo2.png");
        blank = createImg("../img/icon/blank.png");
        border = createImg("../img/icon/border.png");
        shadow = createImg("../img/icon/shadow.png");
        shield1 = createImg("../img/icon/shield1.png");
        shield2 = createImg("../img/icon/shield2.png");
        shootCursor = createImg("../img/icon/shootCursor.png");
        // 3
        flipBlack =  createImg("../img/card/flipBlack.png");
        flipWhite =  createImg("../img/card/flipWhite.png");

    }
    private static ImageIcon createImg(String relativePath){
        return new ImageIcon(URLDecoder.decode(
                Objects.requireNonNull(ImageResource.class.getResource(relativePath)).getPath(),
                StandardCharsets.UTF_8
        ));
    }
    public ImageIcon getImgOfPiece(Piece piece){
        if(piece instanceof Pawn) return pawnImg;
        if (piece instanceof Knight) return kingImg;
        if (piece instanceof Bishop) return bishopImg;
        if (piece instanceof Rook) return rookImg;
        if (piece instanceof Queen) return queenImg;
        if (piece instanceof King) return kingImg;
        if (piece instanceof BlackKing) return blackKingImg;
        return pawnImg;
    }

}
