package model.card;

import model.Board;
import model.Gameplay;
import model.Knight;
import model.WhitePiece;

public class ChienMa extends Card{

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
        Board b=gp.getBoard();
        if(gp.getNumberOfTurn()%7==0){
            b.addPiece(new Knight(b.getRandomTileEmpty(), b.getInitTurnKnight(), b.getInitHpKnight(), b));
        }
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
        gp.getBoard().dataBuff.isChienMa=true;
        if(gp.getBoard().dataBuff.isChienMa){
            b.setInitPawn(b.getInitPawn()-1);
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Quân trắng bị giảm 1 tốt nhưng được thêm 1 mã mỗi 7 lượt";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Chiến Mã";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
