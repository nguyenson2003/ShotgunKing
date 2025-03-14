package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;
public class CanBangSucManh extends Card{

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngCanBangSucManh;
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
        gp.getBoard().dataBuff.isSucManhCanBang=true;
        if(gp.getBoard().dataBuff.isSucManhCanBang){
            Board b=gp.getBoard();
            b.setInitHpQueen(Math.max(1,b.getInitHpQueen()-1));
            b.setInitHpRook(Math.max(1,b.getInitHpRook()-1));
            b.setInitHpBishop(b.getInitHpBishop()+2);
            b.setInitHpKnight(b.getInitHpKnight()+2);
            b.setInitHpPawn(b.getInitHpPawn()+2);
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Xe ,hậu mất 1 máu bù lại tốt, mã, tịnh thêm 2 máu";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Sức Mạnh Cân Bằng";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
