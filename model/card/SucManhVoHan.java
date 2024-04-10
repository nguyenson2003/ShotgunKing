package model.card;

import model.BlackKing;
import model.Gameplay;
import model.WhitePiece;

public class SucManhVoHan extends Card{
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
    public void actionBeforeBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        BlackKing bk=gp.getBoard().getBlackKing();
        if(gp.getNumberOfTurn()%10==0){
            bk.setFirePower(bk.getFirePower()+1);
        }
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        gp.getBoard().getDataBuff().isSucManhVoHan=true;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Tăng 1 hỏa lực sau mỗi 10 lượt";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Sức Mạnh Vô Hạn";
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
