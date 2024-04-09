package model;

import java.util.*;

public class Board {

    @Deprecated
    public static Board ins;
    private ArrayList<WhitePiece> whitePieces = new ArrayList<>();
    private BlackKing blackKing;
    private DataBuff dataBuff = new DataBuff();
    public DataBuff getDataBuff() {
        return dataBuff;
    }
    public Board() {
        ins = this;
//        init();
    }
    private int initPawn = 0,initTurnPawn=5,initHpPawn=3;
    private int initKnight = 0,initTurnKnight=3,initHpKnight = 3;
    private int initBishop = 0,initTurnBishop=5,initHpBishop=4;
    private int initKing = 1,initTurnKing=4,initHpKing=8;
    private int initRook = 0,initTurnRook=4,initHpRook=5;
    private int initQueen = 0,initTurnQueen=4,initHpQueen=5;
    
    public void init() {
        addPiece(new BlackKing(new Tile(4, 8), this, 2, 2, 8,
            4, 5, 40));
        if(this.getDataBuff().isKheUocQuyDuAction){
            blackKing.firePower+=2;
            blackKing.maxSpareAmmo=Math.max(1,blackKing.maxSpareAmmo-3);
        }
        if(this.getDataBuff().isQuaDen){
            blackKing.fireRange+=2;
        }
        if(this.getDataBuff().isBachPhatBachTrung){
            blackKing.firePower=Math.max(1,blackKing.firePower-2);
            blackKing.spread=0;
        }
        int numberOfPieceWithoutPawn=initBishop+initKing+initQueen+initKnight+initRook;
        int colList[]={4,5,3,6,2,7,1,8};
        int row=1,indexCol=0,col=0;
        int cntPawn=0,cntKnight=0,cntBishop=0,cntKing=0,cntRook=0,cntQueen=0;
        while(numberOfPieceWithoutPawn>0){
            col=colList[indexCol%colList.length];
            row=indexCol/colList.length+1;
            if(cntKing<initKing){
                cntKing++;
                if(this.getDataBuff().isGiapCot){
                    addPiece(new King(new Tile(col, row), initTurnKing, initHpKing+1, this));
                }else
                    addPiece(new King(new Tile(col, row), initTurnKing, initHpKing, this));
                numberOfPieceWithoutPawn--;
            }else if(cntQueen<initQueen){
                cntQueen++;
                addPiece(new Queen(new Tile(col, row), initTurnQueen, initHpQueen, this));
                numberOfPieceWithoutPawn--;
            }else if(cntBishop<initBishop){
                cntBishop++;
                addPiece(new Bishop(new Tile(col, row), initTurnBishop, initHpBishop, this));
                numberOfPieceWithoutPawn--;
            }else if(cntKnight<initKnight){
                cntKnight++;
                addPiece(new Knight(new Tile(col, row), initTurnKnight, initHpKnight, this));
                numberOfPieceWithoutPawn--;
            }else if(cntRook<initRook){
                cntRook++;
                addPiece(new Rook(new Tile(col, row), initTurnRook, initHpRook, this));
                numberOfPieceWithoutPawn--;
            }
            indexCol++;
        }
        indexCol=((initBishop+initKing+initQueen+initKnight+initRook)/colList.length)*colList.length;
        while(cntPawn++<initPawn){
            col=colList[indexCol%colList.length];
            row=indexCol/colList.length+1;
            if(this.getPiece(new Tile(col,row))!=null)
                row+=1;
            addPiece(new Pawn(new Tile(col, row), initTurnPawn, initHpPawn, this));
            
            indexCol++;
            // System.out.println(col+" "+row);
        }
        if(this.getDataBuff().isGiapCot){
            blackKing.maxShield=blackKing.shield=blackKing.maxShield+4;
        }
    }
    public void debugInit() {
        addPiece(new BlackKing(new Tile(4, 7), this, 2, 2, 8,
                4, 5, 40));
        addPiece(new King(new Tile(5, 1), 3, 10, this));
        addPiece(new Rook(new Tile(1, 1), 3, 5, this));
        addPiece(new Knight(new Tile(2, 1), 3, 3, this));
        addPiece(new Bishop(new Tile(3, 1), 3, 3, this));
        addPiece(new Queen(new Tile(4, 1), 3, 3, this));
        addPiece(new Bishop(new Tile(6, 1), 3, 3, this));
        addPiece(new Pawn(new Tile(4, 2), 3, 3, this));
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
        if (p instanceof WhitePiece) {
            if(this.getDataBuff().isDichBenh)
                ((WhitePiece)p).hp=((WhitePiece)p).maxHP=Math.max(1, ((WhitePiece)p).maxHP-1);
            // System.out.println("con lai "+((WhitePiece)p).maxHP);
            whitePieces.add((WhitePiece) p);
        }
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
    public Piece getPiece(Tile c) {
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
