package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;

public class TuDo extends Card{

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
        gp.getBoard().dataBuff.isTuDo=true;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Tốt trắng có thể di chuyển và tấn công như vua trắng trong khi đó vẫn có thể phong quân như bình thường";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Tự Do";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
