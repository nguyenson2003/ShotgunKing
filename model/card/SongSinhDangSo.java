package model.card;

import model.BlackKing;
import model.Board;
import model.Gameplay;
import model.WhitePiece;

public class SongSinhDangSo extends Card{

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        BlackKing bk=gp.getBoard().getBlackKing();
        if(gp.getBoard().dataBuff.isSongSinhDangSo){
            bk.setFirePower(bk.getFirePower()+1);
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
        gp.getBoard().dataBuff.isSongSinhDangSo=true;
        if(gp.getBoard().dataBuff.isSongSinhDangSo){
            b.setInitQueen(b.getInitQueen()+2);
            b.setInitHpQueen(b.getInitHpQueen()+1);
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Trắng thêm 2 hậu và hậu tăng 1 máu nhưng vua đen được tăng 1 dame";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Song Sinh Đáng Sợ";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
