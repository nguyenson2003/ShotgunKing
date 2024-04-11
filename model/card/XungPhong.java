package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;

public class XungPhong extends Card{
    public static boolean isMovedTwoTile=false;
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
        Board.dataBuff.isXungPhong=true;
        isMovedTwoTile=false;

    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Nước đầu tiên tốt trắng có thể tiến 1 hoặc 2 ô";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Xung Phong";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
