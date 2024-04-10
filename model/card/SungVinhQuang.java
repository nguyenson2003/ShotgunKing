package model.card;

import model.BlackKing;
import model.Gameplay;

public class SungVinhQuang extends Card{

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        BlackKing bk=gp.getBoard().getBlackKing();
        if(gp.getBoard().getDataBuff().isSungVinhQuang){
            bk.setSpread(bk.getSpread()+30*Math.PI/180);
            bk.setFirePower(bk.getFirePower()+1);
            bk.setFireRange(bk.getFireRange()+1);
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
        gp.getBoard().getDataBuff().isSungVinhQuang=true;
        
    }

    @Override
    public String getDescription() {
        return "Độ lệch tăng thêm 30 bù lại sẽ tăng thêm 1 dame và 1 tầm bắn";
    }

    @Override
    public String getName() {
        return "Súng Vinh Quang";
    }

    @Override
    boolean isBuffCard() {
        return true;
    }
    
}
