package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;

public class ChienXa extends Card{

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
        b.getDataBuff().isChienXa=true;
        if(b.getDataBuff().isChienXa){
            if(b.getInitPawn()>=2){
                b.setInitPawn(b.getInitPawn()-2);
                b.setInitRook(b.getInitRook()+1);
            }
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Quân trắng hiến tế 2 tốt để nhận được 1 xe điều kiện là phải có 2 tốt";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Chiến Xa";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
