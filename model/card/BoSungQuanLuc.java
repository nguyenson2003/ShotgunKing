package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;

public class BoSungQuanLuc extends Card{

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
        b.getDataBuff().isBoSungQuanLuc=true;
        if(b.getDataBuff().isBoSungQuanLuc){
            b.setInitPawn(b.getInitPawn()+3);
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Quân trắng được bổ sung thêm 3 tốt";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Bổ Sung Quân Lực";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
