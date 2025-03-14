package model.card;

import model.BlackKing;
import model.Board;
import model.Gameplay;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;
public class KheUocQuyDu extends Card{
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngKheUocQuyDu;
    }
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Khế ước Quỷ Dữ";
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Vua Đen thêm 2 sát thương,đạn dự phòng giảm 3";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        gp.getBoard().dataBuff.isKheUocQuyDu=true;
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        BlackKing bk=gp.getBoard().getBlackKing();
        if(gp.getBoard().dataBuff.isKheUocQuyDu){
            bk.setFirePower(bk.getFirePower()+2);
            bk.setMaxSpareAmmo(bk.getMaxSpareAmmo()-3);
            bk.setSpareAmmo(bk.getMaxSpareAmmo());
        }
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
