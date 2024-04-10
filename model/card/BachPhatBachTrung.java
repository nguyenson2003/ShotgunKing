package model.card;

import model.BlackKing;
import model.Gameplay;
import model.WhitePiece;

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
        BlackKing bk=gp.getBoard().getBlackKing();
        if(gp.getBoard().getDataBuff().isBachPhatBachTrung){
            bk.setFirePower(Math.max(1,bk.getFirePower()-2));
            bk.setSpread(0);
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