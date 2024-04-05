package model;

import java.util.*;

public class Board {

    @Deprecated
    public static Board ins;
    private ArrayList<WhitePiece> whitePieces = new ArrayList<>();
    private static BlackKing blackKing;

    public Board() {
        ins = this;
        init();
    }

    void init() {
        addPiece(new BlackKing(new Tile(4, 7), this, 2, 2, 8,
                4, 5, 40));
        addPiece(new WhiteKing(new Tile(5, 1), 3, 10, this));
        // addPiece(new Rook(new Tile(1, 1), 3, 3, this));
        // addPiece(new Knight(new Tile(2, 1), 3, 3, this));
        // addPiece(new Bishop(new Tile(3, 1), 3, 3, this));
        // addPiece(new Queen(new Tile(4, 1), 3, 3, this));
        // addPiece(new Bishop(new Tile(6, 1), 3, 3, this));
        // addPiece(new Pawn(new Tile(4, 2), 3, 3, this));
    }

    /**
     * Lấy ra quân vua đen của bàn cờ
     *
     * @return trả về quân vua đen
     */
    public BlackKing getBlackKing() {
        return blackKing;
    }

    /**
     * Thêm 1 quân cờ vào trong bàn cờ
     *
     * @param p quân cờ được thêm vào bàn cờ
     */
    public void addPiece(Piece p) {
        if (getPiece(p.standing) != null) throw new IllegalArgumentException("Ô này đã có quân cờ");
        if (p instanceof WhitePiece) whitePieces.add((WhitePiece) p);
        else blackKing = (BlackKing) p;
    }

    /**
     * Xóa 1 quân cờ ra khỏi bàn cờ
     *
     * @param p quân cờ sẽ xóa khỏi bàn cờ
     */
    public void removePiece(Piece p) {
        if (p instanceof BlackKing) blackKing = null;
        else whitePieces.remove((WhitePiece) p);
    }

    /**
     * Xóa quân cờ ở 1 ô ra khỏi bàn cờ
     *
     * @param c vị trí quân cờ được xóa
     */
    public void removePiece(Tile c) {
        removePiece(getPiece(c));
    }

    /**
     * Tìm quân cờ của 1 ô cờ
     *
     * @param c ô cờ
     * @return Trả về quân cờ ở vị trí c
     */
    Piece getPiece(Tile c) {
        if (blackKing != null && blackKing.standing.equals(c)) return blackKing;
        for (WhitePiece p : whitePieces) {
            if (p.standing.equals(c)) return p;
        }
        return null;
    }

    /**
     * @return Trả về list các quân trắng
     */
    public List<WhitePiece> getWhitePieces() {
        return whitePieces;
    }

    @Override
    public String toString() {
        char board[][] = new char[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(board[i], '.');
        }
        for (Piece p : whitePieces) {
            board[p.standing.y - 1][p.standing.x - 1] = p.getSymbol();
        }
        if (blackKing != null)
            board[blackKing.standing.y - 1][blackKing.standing.x - 1] = blackKing.getSymbol();

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            res.append(String.valueOf(board[i])).append('\n');
        }
        return res.toString();
    }
}
