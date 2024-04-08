package model;

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
    public Gameplay(){
        this(new Board());
    }
    public Gameplay(Board b){
        this.b=b;
    }

    public boolean isPlaying() {
        return isPlaying;
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
        //black action
        if(!willShoot)b.getBlackKing().move(nextMove);
        else b.getBlackKing().shoot(shootAngle);
        //end black action
        if(checkBlackWinGame())return;// check black is win game?
        //start white action
        whiteAction();
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
}