package model.card;

import model.BlackKing;
import model.Board;
import model.Gameplay;
import model.King;
import model.WhitePiece;

public class CanXung extends Card{

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        if(gp.getBoard().getDataBuff().isCanXung){
            BlackKing bk=gp.getBoard().getBlackKing();
            bk.setFirePower(bk.getFirePower()+1);
            bk.setSpread(bk.getSpread()+15*Math.PI/180);
        }
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
        b.getDataBuff().isCanXung=true;
        if(b.getDataBuff().isCanXung){
            b.setInitHpKing(b.getInitHpKing()+2);
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Vua Trắng thêm 2 máu trong khi Vua Đen sẽ thêm 1 dame và tăng 15 độ lệch";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Cân Xứng";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
