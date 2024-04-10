package model.card;

import model.BlackKing;
import model.Gameplay;
import model.Pawn;
import model.WhitePiece;

public class BatTotQuaDuong extends Card{

    int numberPawnBef=0;
    int numberPawnAft=0;
    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        BlackKing bk=gp.getBoard().getBlackKing();
        numberPawnAft=0;
        for(WhitePiece wp:gp.getBoard().getWhitePieces()) 
            if(wp instanceof Pawn)
                numberPawnAft++;
        while(numberPawnAft<numberPawnBef--)
            bk.setSpareAmmo(Math.min(bk.getMaxSpareAmmo(),bk.getSpareAmmo()+1));
        
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        if(gp.getBoard().getDataBuff().isBatTotQuaDuong){
             
        }
    }

    @Override
    public void actionAfterWhiteAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionBeforeBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        numberPawnBef=0;
        for(WhitePiece wp:gp.getBoard().getWhitePieces()) 
            if(wp instanceof Pawn)
                numberPawnBef++;
        
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        gp.getBoard().getDataBuff().isBatTotQuaDuong=true;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Giết một quân tốt sẽ được nạp lại 1 đạn dự phòng";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Bắt Tốt Qua Đường";
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
