package model.card;

import model.Board;
import model.Gameplay;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;
public class NgaiVangBoTrong extends Card{
    
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngNgaiVangBoTrong;
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
        b.dataBuff.isNgaiVangBoTrong=true;
        if(b.dataBuff.isNgaiVangBoTrong){
            b.setInitKing(0);
            b.setInitPawn(b.getInitPawn()+5);
            b.setInitHpPawn(b.getInitHpPawn()+1);
            b.dataBuff.isBecomeKing=false;
        }

    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return " Sẽ không còn vua trắng thay vào đó là 5 tốt và tốt thêm 1 máu quân tốt đầu tiên đi đến cuối bàn cờ sẽ được phong thành vua. Nếu chưa có con tốt nào phong vua thì thắng khi giết hết tốt ";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Ngai Vàng Bỏ Trống";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
