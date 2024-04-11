package model.card;

import model.Board;
import model.Gameplay;
import model.Pawn;
import model.WhitePiece;

public class AnBinhBatDong extends Card{

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
        if(Board.dataBuff.isAnBinhBatDong&&gp.getNumberOfTurn()<=3){
            for(WhitePiece wp:Board.getWhitePieces()){
                if(wp instanceof Pawn) wp.setTurn(wp.getMaxTurn());
            }
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
        Board.dataBuff.isAnBinhBatDong=true;
        Board b=gp.getBoard();
        b.setInitHpPawn(b.getInitHpPawn()+3);
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Tốt trắng không thể di chuyển trong 3 nước đầu nhưng được tăng 3 máu";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Án Binh Bất Động";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
