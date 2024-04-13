package model.card;

import model.Board;
import model.Gameplay;
import model.Pawn;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;
public class HieuTrieuBinhDoan extends Card{
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngHieuTrieuBinhDoan;
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
        if(gp.getNumberOfTurn()%5==0){
            b.addPiece(new Pawn(b.getRandomTileEmpty(), b.getInitTurnPawn(), b.getInitHpPawn(), b));
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
        gp.getBoard().dataBuff.isHieuTrieuBinhDoan=true;
        
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Thêm 1 tốt trắng mỗi 5 lượt";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Hiệu Triệu Binh Đoàn";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
