package model.card;

import model.Gameplay;

/**
 * BachPhatBachTrung
 */
public class BachPhatBachTrung extends Card{

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
        gp.getBoard().getDataBuff().isBachPhatBachTrung=true;
    }

    @Override
    public String getDescription() {
        return "Bách Phát Bách Trúng";
    }

    @Override
    public String getName() {
        return "Độ lệch về 0 nhưng giảm 2 Dame";
    }

    @Override
    boolean isBuffCard() {
        return true;
    }

    
}