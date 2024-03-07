package model;

import java.util.*;

public class Board {
    public static Board ins;
    private ArrayList<WhitePiece> whitePieces = new ArrayList<>();
    private BlackKing blackKing;
    
    public Board(){
        ins = this;
        init();
    }

    void init(){
        addPiece(new BlackKing(new Tile(4, 7)));
        addPiece(new Pawn(new Tile(4, 1),3,3));
        addPiece(new Knight(new Tile(1,1),3,3));
    }
    
    /**
     * Lấy ra quân vua đen của bàn cờ
     * @return trả về quân vua đen
     */
    public BlackKing getBlackKing(){
        return blackKing;
    }

    /**
     * Thêm 1 quân cờ vào trong bàn cờ
     * @param p quân cờ được thêm vào bàn cờ
     */
    public void addPiece(Piece p){
        if(getPiece(p.standing)!=null) throw new IllegalArgumentException("Ô này đã có quân cờ");
        if(p instanceof WhitePiece)whitePieces.add((WhitePiece) p);
        else blackKing=(BlackKing) p;
    }
    
    /**
     * Xóa 1 quân cờ ra khỏi bàn cờ
     * @param p quân cờ sẽ xóa khỏi bàn cờ
     */
    public void removePiece(Piece p){
        if(p instanceof BlackKing)blackKing = null;
        else whitePieces.remove((WhitePiece)p);
    }
    
    /**
     * Xóa quân cờ ở 1 ô ra khỏi bàn cờ
     * @param c vị trí quân cờ được xóa
     */
    public void removePiece(Tile c){
        removePiece(getPiece(c));
    }

    /**
     * Tìm quân cờ của 1 ô cờ
     * @param c ô cờ
     * @return Trả về quân cờ ở vị trí c
     */
    Piece getPiece(Tile c){
        if(blackKing!=null && blackKing.standing.equals(c))return blackKing;
        for(WhitePiece p : whitePieces){
            if(p.standing.equals(c))return p;
        }
        return null;
    }

    public ArrayList<WhitePiece> getWhitePieces(){
        return whitePieces;
    }

    @Override
    public String toString() {
        char board[][] = new char[8][8];
        for(int i=0;i<8;i++){
            Arrays.fill(board[i],'.');
        }
        for (Piece p : whitePieces) {
            board[p.standing.y-1][p.standing.x-1]=p.getSymbol();
        }
        if(blackKing!=null)
            board[blackKing.standing.y-1][blackKing.standing.x-1]=blackKing.getSymbol();

        String res = "";
        for(int i=0;i<8;i++){
            res+=String.valueOf(board[i])+'\n';
        }
        return res;
    }
}
