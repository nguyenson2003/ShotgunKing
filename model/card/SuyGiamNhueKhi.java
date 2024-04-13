package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;
public class SuyGiamNhueKhi extends Card{
    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {
        int numberOfWhitePieces=gp.getBoard().getWhitePieces().size();
        if(numberOfWhitePieces==0) return;
        gp.getBoard().getWhitePieces().get(((int) (Math.random()*100)) % numberOfWhitePieces).takeDamage();
    }
    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        
    }
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngSuyGiamNhueKhi;
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
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        gp.getBoard().dataBuff.isSuyGiamNhueKhi=true;
    }

    @Override
    public String getDescription() {
        return "Khi một quân trắng bị tiêu diệt, 1 quân trắng bất kì khác mất 1 máu";
    }

    @Override
    public String getName() {
        return "Suy giảm nhuệ khí";
    }

    @Override
    public boolean isBuffCard() {
       return true;
    }
    
}
