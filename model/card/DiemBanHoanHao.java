package model.card;

import model.BlackKing;
import model.Gameplay;
import model.WhitePiece;

public class DiemBanHoanHao extends Card{
    boolean isBuffed=false;
    int oldFireRange=0;
    private void checkAndBuffOrDebuff(Gameplay gp){
        BlackKing bk=gp.getBoard().getBlackKing();
        if(bk.getStanding().x==1||bk.getStanding().x==8||bk.getStanding().y==1||bk.getStanding().y==8){
            if(!isBuffed){
                isBuffed=true;
                oldFireRange=bk.getFireRange();
                bk.setFireRange(999);
            }
        }else{
            if(isBuffed){
                isBuffed=false;
                bk.setFireRange(oldFireRange);
            }
        }
    }
    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        checkAndBuffOrDebuff(gp);
    }
    
    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        checkAndBuffOrDebuff(gp);
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
        
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Tầm bắn 999 nhưng chỉ có tác dụng khi vua đen ở rìa bàn cờ";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Điểm Bắn Hoàn Hảo";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return true;
    }
    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {
        // TODO Auto-generated method stub
    }
    
}
