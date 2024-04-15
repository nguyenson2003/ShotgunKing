package model.card;

import model.Board;
import model.Gameplay;
import model.Knight;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;

public class ChienMa extends Card{
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngChienMa;
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
        Board b=gp.getBoard();
        if(gp.getNumberOfTurn()%7==0&&gp.getBoard().dataBuff.isChienMa==true){
            b.addPiece(new Knight(b.getRandomTileEmpty(), b.getInitTurnKnight(), b.getInitHpKnight(), b));
        }
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
        gp.getBoard().dataBuff.isChienMa=true;
        if(gp.getBoard().dataBuff.isChienMa){
            if(b.getInitPawn()>=1)
                b.setInitPawn(b.getInitPawn()-1);
            else
                gp.getBoard().dataBuff.isChienMa=false;
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Quân trắng bị giảm 1 tốt nhưng được thêm 1 mã mỗi 7 lượt điều kiện phải có ít nhất 1 tốt";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Chiến Mã";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
