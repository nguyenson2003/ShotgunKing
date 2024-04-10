package model.card;

import model.BlackKing;
import model.Gameplay;

public class DanDuTru extends Card{

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        BlackKing bk=gp.getBoard().getBlackKing();
        if(gp.getBoard().getDataBuff().isDanDuTru){
            
            bk.setMaxShellAmmo(bk.getMaxShellAmmo()+1);
            bk.setMaxSpareAmmo(Math.max(1, bk.getMaxSpareAmmo()-1));
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
        gp.getBoard().getDataBuff().isDanDuTru=true;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Đạn trong băng tăng thêm 1 nhưng đạn dự phòng giảm đi 1";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Đạn Dự Trữ";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
