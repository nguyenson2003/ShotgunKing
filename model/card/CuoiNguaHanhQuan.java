package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;

public class CuoiNguaHanhQuan extends Card{
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngCuoiNguaHanhQuan;
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
        gp.getBoard().dataBuff.isCuoiNguaHanhQuan=true;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Tất cả quân trắng có thể di chuyển và tấn công xuyên qua các quân khác tốt và thẻ chỉ có hiệu lực khi còn mã trên bàn cờ";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Cưỡi Ngựa Hành Quân";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
