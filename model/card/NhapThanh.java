package model.card;

import java.util.ArrayList;

import model.Board;
import model.Gameplay;
import model.King;
import model.Rook;
import model.Tile;
import model.WhitePiece;
import javax.swing.ImageIcon;
import resource.ImageResource;
/**
 * NhapThanh
 */
public class NhapThanh extends Card{
    @Override
    public ImageIcon getImageIcon() {
        // TODO Auto-generated method stub
        return ImageResource.instance.pngNhapThanh;
    }
    int hpWhiteKingBef=0;
    King whiteKing=null;
    Rook rook=null;
    boolean isCanSwap=false;
    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        Board b=gp.getBoard();
        if(b.isHasKingOnBoard&&whiteKing.getHp()!=hpWhiteKingBef){
            int detalHp=hpWhiteKingBef-whiteKing.getHp();
            int random=(int)(Math.random()*100);
            ArrayList<Rook>listRook=new ArrayList<>();
            for(WhitePiece wp:gp.getBoard().getWhitePieces()){
                if(wp instanceof Rook){
                    listRook.add((Rook)wp);
                }
            }
            if(listRook.size()>0){
                rook=listRook.get(random%listRook.size());
                rook.setTurn(rook.getTurn()+1);
                whiteKing.setTurn(whiteKing.getTurn()+1);
                isCanSwap=true;
                while(detalHp-->0){
                    rook.takeDamage();
                }
                if(whiteKing.getHp()<=0){
                    b.addPiece(whiteKing);
                }
                whiteKing.setHp(hpWhiteKingBef);
            }
        }
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
    }

    @Override
    public void actionAfterWhiteAction(Gameplay gp) {
        // TODO Auto-generated method stub
        Board b=gp.getBoard();
        if(b.dataBuff.isNhapThanh)
            if(gp.getNumberOfTurn()%10==0){
                b.addPiece(new Rook(b.getRandomTileEmpty(),b.getInitTurnRook(),b.getInitHpRook(),b));
            }
        if(isCanSwap){
            isCanSwap=false;
            Tile tempStd=whiteKing.getStanding();
            whiteKing.setStanding(rook.getStanding());
            rook.setStanding(tempStd);
        }
    }

    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionBeforeBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        Board b=gp.getBoard();
        if(whiteKing==null&&b.isHasKingOnBoard){
            for(WhitePiece wp:b.getWhitePieces())
                if(wp instanceof King){
                    whiteKing=(King)wp;
                    break;
                }
            
        }
        if(whiteKing!=null)
            hpWhiteKingBef=whiteKing.getHp();
    }

    @Override
    public void actionBeforeInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        gp.getBoard().dataBuff.isNhapThanh=true;

    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Nếu vua đen bắn vua trắng mất máu, tổng lượng máu mất đó sẽ truyền cho một quân xe ngẫu nhiên, hoán đổi vị trí với quân xe đó và thêm 1 xe mỗi 10 lượt";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Nhập Thành";
    }

    @Override
    public boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }

    
}