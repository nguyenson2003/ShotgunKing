package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;

public class HoangHauSatThu extends Card{

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
        Board b=gp.getBoard();
        b.getDataBuff().isHoangHauSatThu=true;
        if(b.getDataBuff().isHoangHauSatThu){
            b.setInitQueen(b.getInitQueen()+1);
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Tăng thêm 1 hậu cho quân trắng";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Hoàng Hậu Sát Thủ";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
