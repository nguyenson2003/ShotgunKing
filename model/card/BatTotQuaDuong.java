package model.card;

import model.BlackKing;
import model.Board;
import model.Gameplay;
import model.Pawn;
import model.WhitePiece;

public class BatTotQuaDuong extends Card{
    
    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {
        // TODO Auto-generated method stub
        if(whitePiece instanceof Pawn){
            BlackKing bk=gp.getBoard().getBlackKing();
            bk.setSpareAmmo(Math.min(bk.getMaxSpareAmmo(),bk.getSpareAmmo()+1));
        }
    }
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
    public void actionBeforeBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        gp.getBoard().dataBuff.isBatTotQuaDuong=true;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Giết một quân tốt sẽ được nạp lại 1 đạn dự phòng";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Bắt Tốt Qua Đường";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return true;
    }

    
}
