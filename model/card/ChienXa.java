package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;

public class ChienXa extends Card{
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngChienXa;
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
        gp.getBoard().dataBuff.isChienXa=true;
        if(gp.getBoard().dataBuff.isChienXa){
            if(b.getInitPawn()>=2){
                b.setInitPawn(b.getInitPawn()-2);
                b.setInitRook(b.getInitRook()+1);
            }
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Quân trắng hiến tế 2 tốt để nhận được 1 xe điều kiện là phải có 2 tốt";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Chiến Xa";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
