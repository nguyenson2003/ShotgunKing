package model.card;

import model.BlackKing;
import model.Board;
import model.Gameplay;
import model.WhitePiece;

public class QuaDen extends Card{

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        BlackKing bk=gp.getBoard().getBlackKing();
        if(gp.getBoard().dataBuff.isQuaDen){
            bk.setFireRange(bk.getFireRange()+2);
        }
        
    }

    @Override
    public void actionAfterWhiteAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {

    }

    @Override
    public void actionBeforeBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        gp.getBoard().dataBuff.isQuaDen=true;
    }

    @Override
    public String getDescription() {
        return "Tăng 2 tầm bắn cho vua đen";
    }

    @Override
    public String getName() {
        return "Quạ Đen";
    }

    @Override
    public boolean isBuffCard() {
       return true;
    }
    
}
