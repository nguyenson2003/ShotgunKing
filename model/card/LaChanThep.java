package model.card;

import model.Bishop;
import model.Board;
import model.Gameplay;
import model.King;
import model.Tile;
import model.WhitePiece;

public class LaChanThep extends Card{
    public static boolean isHasBishop=false;
    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        for(WhitePiece wp:gp.getBoard().getWhitePieces()){
            if(wp instanceof Bishop && !wp.isDied()){
                isHasBishop=true;
                return;
            }
        }
        isHasBishop=false;
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
        b.getDataBuff().isLaChanThep=true;
        if(b.getDataBuff().isLaChanThep){
            b.setInitHpBishop(b.getInitHpBishop()+1);
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Vua trắng sẽ không thể chết nếu còn tịnh trên bàn cờ và tịnh sẽ được thêm 1 máu";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Lá Chắn Thép";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
