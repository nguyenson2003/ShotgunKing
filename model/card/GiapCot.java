package model.card;

import model.Gameplay;

public class GiapCot extends Card{

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
        gp.getBoard().getDataBuff().isGiapCot=true;
    }

    @Override
    public String getDescription() {
        return "Vua đen tăng 4 giáp trong khi vua trắng được tăng 1 máu";
    }

    @Override
    public String getName() {
        return "Giáp cốt";
    }

    @Override
    boolean isBuffCard() {
        return true;
    }
    
}
