package model.card;

import model.BlackKing;
import model.Gameplay;

public class TinhChinhSung extends Card{

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        BlackKing bk=gp.getBoard().getBlackKing();
        if(gp.getBoard().getDataBuff().isTinhChinhSung){
            bk.setSpread(Math.max(0, bk.getSpread()-40*Math.PI/180));
            bk.setFirePower(bk.getFirePower()+1);
        }
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
        gp.getBoard().getDataBuff().isTinhChinhSung=true;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Độ lệch giảm 40 độ và tăng thêm 1 dame cho vua đen";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Tinh Chỉnh Súng";
    }

    @Override
    boolean isBuffCard() {
        return true;
    }
    
}
