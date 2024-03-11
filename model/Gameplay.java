package model;

import java.util.Scanner;

/**
 * Gameplay
 */
public class Gameplay {
    static Scanner sc = new Scanner(System.in);
    Board b;
    public Gameplay(){
        this(new Board());
    }
    public Gameplay(Board b){
        this.b=b;
    }
    public void testPlay(){
        boolean isplay=true;
        while(isplay){
            //Bàn cờ
            System.out.println(b.toString());

            //vua đen di chuyển
            Tile nextMoveOfKing;
            do{
                System.out.print("Moi ban nhap x de vua di chuyen: ");
                int x = sc.nextInt();
                System.out.print("Moi ban nhap y de vua di chuyen: ");
                int y = sc.nextInt();
                try {
                    nextMoveOfKing=new Tile(x, y);
                } catch (Exception e) {
                    System.out.println(e);
                    continue;
                }
                if(!b.getBlackKing().canMoveTo(nextMoveOfKing)){
                    System.out.println("Vua khong the di chuyen toi o nay");
                    continue;
                }
                //kiểm tra chiếu hết
                int countMate=0;
                for (WhitePiece piece : b.getWhitePieces()) {
                    if(piece.isMate(nextMoveOfKing)){
                        countMate++;
                    }
                }
                if(b.getBlackKing().sheild>0 && countMate>0){
                    System.out.println("Vi tri nay bi "+countMate+" quan co chieu, moi ban di lai");
                    b.getBlackKing().sheild--;
                } else break;
            }while(true);
            
            //đen di chuyển
            b.getBlackKing().move(nextMoveOfKing);

            whiteAction();
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
                return;
            }
        }

        //quân trắng di chuyển
        for (WhitePiece piece : b.getWhitePieces()) {
            piece.move(piece.bestMove());
        }
        b.getBlackKing().sheild=b.getBlackKing().maxSheild;
    }
}