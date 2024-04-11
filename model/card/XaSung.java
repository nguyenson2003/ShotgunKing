package model.card;

import model.BlackKing;
import model.Board;
import model.Gameplay;
import model.Tile;
import model.WhitePiece;

public class XaSung extends Card {
    Tile bkStandingBef=new Tile(1, 1);
    Tile bkStandingAft=new Tile(1, 1);
    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        BlackKing bk=gp.getBoard().getBlackKing();
        bkStandingAft=bk.getStanding();
        if(bkStandingAft.equals(bkStandingBef))
            while(bk.getShellAmmo()>0) 
                bk.shoot(bk.getOldAngle());
        
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
        bkStandingBef=gp.getBoard().getBlackKing().getStanding();
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        gp.getBoard().dataBuff.isXaSung=true;
    }

    @Override
    public String getDescription() {
        return "Bắn 1 phát sẽ bắn hết tất cả đạn còn lại trong súng";
    }

    @Override
    public String getName() {
        return "Xả súng";
    }

    @Override
    boolean isBuffCard() {
        return true;
    }

    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {
        // TODO Auto-generated method stub
    }
    
}
