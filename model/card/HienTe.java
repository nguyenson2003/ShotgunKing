package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;

public class HienTe extends Card{

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
        Board.dataBuff.isHienTe=true;
        if(Board.dataBuff.isHienTe){
            if(b.getInitBishop()>=1){
                b.setInitPawn(b.getInitPawn()+6);
                b.setInitBishop(b.getInitBishop()-1);
            }
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Quân trắng hiến tế 1 tịnh để nhận được 6 tốt điều kiện là phải có 1 tịnh";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Hiến Tế";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
