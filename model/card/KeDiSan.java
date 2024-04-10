package model.card;

import model.BlackKing;
import model.Gameplay;
import model.WhitePiece;

public class KeDiSan extends Card{
    boolean isBuffed=false;
    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        checkAndBuffOrDebuff(gp);  
    }
    private void checkAndBuffOrDebuff(Gameplay gp) {
        BlackKing bk=gp.getBoard().getBlackKing();
        for(WhitePiece wp:gp.getBoard().getWhitePieces()){
            int absx=Math.abs(wp.getStanding().x-bk.getStanding().x);
            int absy=Math.abs(wp.getStanding().y-bk.getStanding().y);
            if(absx<=1&&absy<=1&&!isBuffed){
                isBuffed=true;
                bk.setSpread(Math.max(0,bk.getSpread()-15*Math.PI/180));
                bk.setFirePower(bk.getFirePower()+1);
                break;
            }
            if(isBuffed){
                isBuffed=false;
                bk.setSpread(bk.getSpread()+15*Math.PI/180);
                bk.setFirePower(Math.max(1,bk.getFirePower()-1));
            }
        }
            
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterWhiteAction(Gameplay gp) {
        // TODO Auto-generated method stub
        checkAndBuffOrDebuff(gp);
    }

    @Override
    public void actionBeforeBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        gp.getBoard().getDataBuff().isKeDiSan=true;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Độ lệch giảm 15 và tăng 1 dame nhưng chỉ có tác dụng khi áp sát kẻ địch";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Kẻ Đi Săn";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {
        // TODO Auto-generated method stub
    }
    
}
