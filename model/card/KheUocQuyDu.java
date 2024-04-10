package model.card;

import model.BlackKing;
import model.Gameplay;
import model.WhitePiece;

public class KheUocQuyDu extends Card{

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Khế ước Quỷ Dữ";
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Vua Đen thêm 2 dame,đạn dự phòng giảm 3";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        gp.getBoard().getDataBuff().isKheUocQuyDuAction=true;
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        BlackKing bk=gp.getBoard().getBlackKing();
        if(gp.getBoard().getDataBuff().isKheUocQuyDuAction){
            bk.setFirePower(bk.getFirePower()+2);
            bk.setMaxSpareAmmo(Math.max(1,bk.getMaxSpareAmmo()-3));
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
