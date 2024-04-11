package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;

public class DongCamCongKho extends Card{

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
    }

    @Override
    public void actionAfterWhiteAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionBeforeBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        Board.dataBuff.isDongCamCongKho=true;
        Board b=gp.getBoard();
        if(Board.dataBuff.isDongCamCongKho){
            b.setInitHpQueen(b.getInitHpQueen()+1);
            b.setInitHpPawn(b.getInitHpPawn()+1);
            b.setInitHpBishop(b.getInitHpBishop()+1);
            b.setInitHpKnight(b.getInitHpKnight()+1);
            b.setInitHpRook(b.getInitHpRook()+1);
            b.setInitHpKing(b.getInitHpKing()+1);
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Quân trắng được thêm 1 máu";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Đồng Cam Cộng Khổ";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
