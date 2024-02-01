package model;

import java.util.Scanner;

/**
 * Gameplay
 */
public class Gameplay {
    static Scanner sc = new Scanner(System.in);
    public void testPlay(){
        new Board();
        boolean isplay=true;
        while(isplay){
            //Bàn cờ
            System.out.println(Board.ins.toString());


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
                if(!Board.ins.getBlackKing().canMoveTo(nextMoveOfKing)){
                    System.out.println("Vua khong the di chuyen toi o nay");
                    continue;
                }
                //kiểm tra chiếu hết
                int countMate=0;
                for (WhitePiece piece : Board.ins.getWhitePieces()) {
                    if(piece.isMate(nextMoveOfKing)){
                        countMate++;
                    }
                }
                if(Board.ins.getBlackKing().sheild>0 && countMate>0){
                    System.out.println("Vi tri nay bi "+countMate+" quan co chieu, moi ban di lai");
                    Board.ins.getBlackKing().sheild--;
                } else break;
            }while(true);
            
            //đen di chuyển
            Board.ins.getBlackKing().move(nextMoveOfKing);

            //nếu có chiếu hết, đen thua
            for (WhitePiece piece : Board.ins.getWhitePieces()) {
                if(piece.isMate(nextMoveOfKing)){
                    piece.mate(nextMoveOfKing);
                    System.out.println("Thua!");
                    Board.ins.removePiece(Board.ins.getBlackKing());
                    System.out.println(Board.ins);
                    return;
                }
            }

            //quân trắng di chuyển
            for (WhitePiece piece : Board.ins.getWhitePieces()) {
                piece.move(piece.bestMove());
            }
            Board.ins.getBlackKing().sheild=Board.ins.getBlackKing().maxSheild;

        }
    }
}