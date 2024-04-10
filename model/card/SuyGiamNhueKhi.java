package model.card;

import model.Gameplay;
import model.WhitePiece;

public class SuyGiamNhueKhi extends Card{
    int numberOfWhitePieceBefore=0;
    int numberOfWhitePieceAfter=0;
    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        numberOfWhitePieceAfter=gp.getBoard().getWhitePieces().size();
        if(numberOfWhitePieceAfter!=numberOfWhitePieceBefore){
            int random=((int) (Math.random()*100))%numberOfWhitePieceAfter;
            WhitePiece wp=gp.getBoard().getWhitePieces().get(random);
            // System.out.println(wp.getStanding().x+" "+wp.getStanding().y);
            wp.takeDamage();
            if(wp.isDied())
                actionAfterBlackAction(gp);
        }
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

    }

    @Override
    public void actionBeforeBlackAction(Gameplay gp) {
        numberOfWhitePieceBefore=gp.getBoard().getWhitePieces().size();
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        gp.getBoard().getDataBuff().isSuyGiamNhueKhi=true;
    }

    @Override
    public String getDescription() {
        return "Khi một quân trắng bị tiêu diệt, 1 quân trắng bất kì khác mất 1 máu";
    }

    @Override
    public String getName() {
        return "Suy giảm nhuệ khí";
    }

    @Override
    boolean isBuffCard() {
       return true;
    }
    
}
