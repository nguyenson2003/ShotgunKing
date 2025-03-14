package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;
public class LaChanThep extends Card{
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngLaChanThep;
    }
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
        gp.getBoard().dataBuff.isLaChanThep=true;
        if(gp.getBoard().dataBuff.isLaChanThep){
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
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
