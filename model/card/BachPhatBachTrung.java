package model.card;



import model.BlackKing;
import model.Board;
import model.Gameplay;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;

/**
 * BachPhatBachTrung
 */
public class BachPhatBachTrung extends Card{
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngBachPhatBachTrung;
    }

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        Board b=gp.getBoard();
        BlackKing bk=b.getBlackKing();
        if(b.dataBuff.isBachPhatBachTrung){
            bk.setFirePower(Math.max(1,bk.getFirePower()-2));
            bk.setSpread(0);
        }
    }

    @Override
    public void actionAfterWhiteAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {

    }

    @Override
    public void actionBeforeBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        if(gp.getBoard().dataBuff.isBachPhatBachTrung){
            gp.getBoard().getBlackKing().setSpread(0);
        }
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        gp.getBoard().dataBuff.isBachPhatBachTrung=true;
    }

    @Override
    public String getDescription() {
        return "Độ lệch về 0 nhưng giảm 2 sát thương";
    }
    
    @Override
    public String getName() {
        return "Bách Phát Bách Trúng";
    }

    @Override
    public boolean isBuffCard() {
        return true;
    }

    
}