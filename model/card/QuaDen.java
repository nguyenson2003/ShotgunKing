package model.card;

import model.Gameplay;

public class QuaDen extends Card{

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
        gp.getBoard().getDataBuff().isQuaDen=true;
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
    boolean isBuffCard() {
       return true;
    }
    
}
