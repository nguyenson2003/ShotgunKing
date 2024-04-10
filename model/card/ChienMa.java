package model.card;

import model.Board;
import model.Gameplay;
import model.Knight;
import model.Tile;
import model.WhitePiece;

public class ChienMa extends Card{

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
        if(gp.getNumberOfTurn()%7==0){
            int indexTile=0,row=0,col=0;
            do{
                row=indexTile/8+1;
                col=indexTile%8+1;
                indexTile++;
            }while(Tile.isOnBoard(col, row) && b.getPiece(new Tile(col, row))!=null);
            indexTile--;
            int random=(int)(Math.random()*100/8);
            while(random>0){
                col=indexTile%8+1;
                indexTile++;
                if(Tile.isOnBoard(col, row) && b.getPiece(new Tile(col, row))==null)
                    random--;
            }
            b.addPiece(new Knight(new Tile(col, row), b.getInitTurnKnight(), b.getInitHpKnight(), b));
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
        Board b=gp.getBoard();
        b.getDataBuff().isChienMa=true;
        if(b.getDataBuff().isChienMa){
            b.setInitPawn(b.getInitPawn()-1);
        }
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Quân trắng bị giảm 1 tốt nhưng được thêm 1 mã mỗi 7 lượt";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Chiến Mã";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
