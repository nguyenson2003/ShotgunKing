package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;

public class BuocNhayVanNang extends Card{
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngBuocNhayVanNang;
    }
    @Override
    public String getName() {
        return "Bước Nhẩy Vạn Năng";
    }

    @Override
    public String getDescription() {
        return "Vua đen được phép có 1 nước đi với khoảng cách là 2 trong 1 trận";
    }

    @Override
    public boolean isBuffCard() {
        return true;
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        gp.getBoard().dataBuff.isBuocNhayVanNang=true;
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        
    }

    @Override
    public void actionBeforeBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
    }

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
    }

    @Override
    public void actionAfterWhiteAction(Gameplay gp) {
        // TODO Auto-generated method stub
    }

    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {

    }
}
