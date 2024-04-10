package model;

import model.card.Card;
import model.card.ChienMa;
import model.card.BachPhatBachTrung;
import model.card.BuocNhayVanNang;
import model.card.Card;
import model.card.DichBenh;
import model.card.DiemBanHoanHao;
import model.card.DongCamCongKho;
import model.card.KeDiSan;
import model.card.KheUocQuyDu;
import model.card.LaChanThep;
import model.card.NgamNhinConMoi;
import model.card.QuaDen;
import model.card.QuanSu;
import model.card.SongSinhDangSo;
import model.card.SucManhVoHan;
import model.card.SungVinhQuang;
import model.card.SuyGiamNhueKhi;
import model.card.UyQuyenQuanVuong;
import model.card.XaSung;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gameplay
 */
public class Gameplay {
    Board b;
    boolean isPlaying=true;
    /**
     * biến ktra buff: phải giết tất cả tốt để chiến thắng
     */
    private boolean killAllPawnToWin = false;
    private int numberOfTurn = 1;
    ArrayList<Card> buffCards = new ArrayList<>();
    ArrayList<Card> debuffCards = new ArrayList<>();
    public Gameplay(){
        this.b=new Board(){
            @Override
            public void removePiece(Piece p) {
                super.removePiece(p);
                WhitePiece wp = (WhitePiece) p;
                for(Card c:buffCards){
                    if(c.isFlip())continue;
                    c.actionAfterWhiteDieAction(Gameplay.this,wp);
                }
                for(Card c:debuffCards){
                    if(c.isFlip())continue;
                    c.actionAfterWhiteDieAction(Gameplay.this,wp);
                }
            }
        };
        debugAddCards();
        for(Card c:buffCards){
            if(c.isFlip())continue;
            c.actionBeforeInitBoard(this);
        }
        for(Card c:debuffCards){
            if(c.isFlip())continue;
            c.actionBeforeInitBoard(this);
        }
        b.init();
        for(Card c:buffCards){
            if(c.isFlip())continue;
            c.actionAfterInitBoard(this);
        }
        for(Card c:debuffCards){
            if(c.isFlip())continue;
            c.actionAfterInitBoard(this);
        }
    }


    /**
     * Khi muốn tạo lại 1 màn chơi, nên xài hàm này
     * @return trả về 1 gameplay mới, các thẻ bài vẫn sẽ được giữ nguyên
     */
    protected Gameplay clone() {
        Gameplay willClone = new Gameplay();
        willClone.buffCards=this.buffCards;
        willClone.debuffCards=this.debuffCards;
        return willClone;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public Board getBoard() {
        return b;
    }

    public int getNumberOfTurn() {
        return numberOfTurn;
    }

    public void blackMoveAction(Tile nextMove, double shootAngle){
        if(checkBlackWinGame())return;//check black is win game
        //calculator move or shoot (before black action)
        boolean willShoot = false;
        if(b.getBlackKing().standing.equals(nextMove))return;
        if(!b.getBlackKing().canMoveTo(nextMove)){
            nextMove=b.getBlackKing().standing;
            willShoot=true;
            if(!b.getBlackKing().isCanShoot())return;
        }
        //check all piece checkmate (before black action)
        int countMate=0;
        for (WhitePiece piece : b.getWhitePieces()) {
            if(piece.isMate(nextMove)){
                piece.mateFlag=true;
                countMate++;
            }
        }
        if(b.getBlackKing().shield >0 && countMate>0){
            System.out.println("Vi tri nay bi "+countMate+" quan co chieu, moi ban di lai");
            b.getBlackKing().shield--;
            return;
        }

        for(Card c:buffCards){
            if(c.isFlip())continue;
            c.actionBeforeBlackAction(this);
        }
        for(Card c:debuffCards){
            if(c.isFlip())continue;
            c.actionBeforeBlackAction(this);
        }
        //black action
        if(!willShoot)b.getBlackKing().move(nextMove);
        else b.getBlackKing().shoot(shootAngle);
        //end black action
        for(Card c:buffCards){
            if(c.isFlip())continue;
            c.actionAfterBlackAction(this);
        }
        for(Card c:debuffCards){
            if(c.isFlip())continue;
            c.actionAfterBlackAction(this);
        }
        if(checkBlackWinGame())return;// check black is win game?
        //start white action
        whiteAction();
        numberOfTurn++;
        for(Card c:buffCards){
            if(c.isFlip())continue;
            c.actionAfterWhiteAction(this);
        }
        for(Card c:debuffCards){
            if(c.isFlip())continue;
            c.actionAfterWhiteAction(this);
        }
    }
    public void whiteAction(){
        //nếu có chiếu hết, đen thua
        for (WhitePiece piece : b.getWhitePieces()) {
            if(piece.isMate(b.getBlackKing().getStanding())){
                piece.mate(b.getBlackKing().getStanding());
                System.out.println("Thua!");
                b.removePiece(b.getBlackKing());
                System.out.println(b);
                isPlaying=false;
                return;
            }
        }

        //quân trắng di chuyển
        for (WhitePiece piece : b.getWhitePieces()) {
            piece.move(piece.bestMove());
        }
        b.getBlackKing().shield =b.getBlackKing().maxShield;
    }

    /**
     * @return true nếu black thắng, false nếu black chưa thắng
     */
    public boolean checkBlackWinGame(){
        //có buff: phải giết hết tốt mới thắng
        if(killAllPawnToWin){
            int countPawn = 0;
            for(WhitePiece p : b.getWhitePieces()){
                if(p instanceof Pawn)countPawn++;
            }
            return countPawn==0;
        }
        //Cơ bản:
        int countKing = 0;
        for(WhitePiece p : b.getWhitePieces()){
            if(p instanceof King)countKing++;
        }
        return countKing==0;
    }
    public void debugAddCards(){
        buffCards.add(new LaChanThep());
    }
}