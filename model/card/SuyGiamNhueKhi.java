package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;

public class SuyGiamNhueKhi extends Card{
    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {
        int numberOfWhitePieces=Board.getWhitePieces().size();
        if(numberOfWhitePieces==0) return;
        Board.getWhitePieces().get(((int) (Math.random()*100)) % numberOfWhitePieces).takeDamage();
    }
    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        
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
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        Board.dataBuff.isSuyGiamNhueKhi=true;
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
