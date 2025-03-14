package model.card;

import model.BlackKing;
import model.Board;
import model.Gameplay;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;
public class NgamNhinConMoi extends Card{
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngNgamNhinConMoi;
    }
    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        BlackKing bk=gp.getBoard().getBlackKing();
        if(gp.getBoard().dataBuff.isNgamNhinConMoi){
            bk.setFireRange(bk.getFireRange()+2);
            bk.setSpread(bk.getSpread()+20*Math.PI/180);
        }
    }

    @Override
    public void actionAfterWhiteAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionBeforeBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        gp.getBoard().dataBuff.isNgamNhinConMoi=true;
    }

    @Override
    public String getDescription() {
        return "Thêm 2 tầm bắn nhưng độ lệch tăng 20 độ";
    }

    @Override
    public String getName() {
        return "Ngắm Nhìn Con Mồi";
    }

    @Override
    public boolean isBuffCard() {
        return true;
    }

    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {
        // TODO Auto-generated method stub
    }
    
}
