package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;

public class QuanSu extends Card{

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
        gp.getBoard().dataBuff.isQuanSu=true;
        if(gp.getBoard().dataBuff.isQuanSu){
            b.setInitPawn(b.getInitPawn()-1);
            b.setInitBishop(b.getInitBishop()+1);
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Giảm 1 tốt bù lại sẽ được thêm thêm 1 tịnh và tịnh có thể di chuyển như hậu, nhưng vẫn tấn công như tịnh";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Quân Sư";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
