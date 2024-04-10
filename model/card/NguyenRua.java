package model.card;

import model.Gameplay;
import model.King;
import model.WhitePiece;

public class NguyenRua extends Card {

    @Override
    public void actionAfterBlackAction(Gameplay gp) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionAfterInitBoard(Gameplay gp) {
        // TODO Auto-generated method stub
        int sizeWhitePieces=gp.getBoard().getWhitePieces().size();
        if(gp.getBoard().getDataBuff().isNguyenRua){
            if(sizeWhitePieces>1){
                int random=((int)(Math.random()*100))%sizeWhitePieces;
                while(gp.getBoard().getWhitePieces().get(random) instanceof King)
                    random=((int)(Math.random()*100))%sizeWhitePieces;
                WhitePiece wp= gp.getBoard().getWhitePieces().get(random);
                while(!wp.isDied())
                    wp.takeDamage();
            }
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
        gp.getBoard().getDataBuff().isNguyenRua=true;
    }

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return "Tiêu diệt 1 quân trắng ngẫu nhiên (ngoại trừ vua trắng)";
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "Nguyền Rủa";
    }

    @Override
    boolean isBuffCard() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void actionAfterWhiteDieAction(Gameplay gp, WhitePiece whitePiece) {
        // TODO Auto-generated method stub
    }
    
}
