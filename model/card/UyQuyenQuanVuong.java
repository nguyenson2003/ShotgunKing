package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;
public class UyQuyenQuanVuong extends Card{

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngUyQuyenQuanVuong;
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
        gp.getBoard().dataBuff.isUyQuyenQuanVuong=true;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Quân trắng không thể lại gần các ô xung quanh bạn";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Ủy Quyền Quân Vương";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return true;
    }
    
    
}
