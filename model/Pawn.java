package model;

import model.card.NgaiVangBoTrong;

public class Pawn extends WhitePiece{
    int scoreStanding[][]={ {0,0,0,0,0,0,0,0,0},

                            {0, 2,2,2,2,2,2,2,2},
                            {0, 6,6,6,6,6,6,6,6},
                            {0, 2,2,3,4,4,3,2,2},
                            {0, 2,2,3,4,4,3,2,2},
                            {0, 2,2,3,4,4,3,2,2},
                            {0, 2,1,1,2,2,1,1,2},
                            {0, 3,3,3,1,1,3,3,3},
                            {0, 2,2,2,2,2,2,2,2},
                            };
    //tốt là 1
    int valueOfPawn=1;

    public Pawn(Tile t,int maxTurn,int maxHP,Board onBoard) {
        super(t,maxTurn,maxHP,onBoard);
    }

    @Override
    boolean isMate(Tile nextCell) {
        if(nextCell.y==standing.y+1 && (nextCell.x==standing.x-1 || nextCell.x==standing.x+1))
            return true;
        return false;
        
    }

    @Override
    Tile bestMove() {
        BlackKing bk=onBoard.getBlackKing();
        if(standing.y == 8){
            return standing;
        }
        Tile temp = new Tile(standing.x, standing.y+1);
        if(onBoard.getPiece(temp)==null && standing.y<8){
                //ủy quyền quân vương
            if(Board.dataBuff.isUyQuyenQuanVuong){
                if(Math.abs(bk.standing.x-temp.x)<=1&&Math.abs(bk.standing.y-temp.y)<=1){
                    return standing;
                }
            }
            return temp;
        }else return standing;
    }

    @Override
    public void move(Tile nextMove) {
        super.move(nextMove);
        if(standing.y==8){
            onBoard.removePiece(this);
            hp=0;
            // Ngai vàng bỏ trống -> phong vua
            if(Board.dataBuff.isNgaiVangBoTrong && NgaiVangBoTrong.isBecomeKing==false){
                NgaiVangBoTrong.isBecomeKing=true;
                onBoard.addPiece(new King(standing, onBoard.getInitTurnKing(), onBoard.getInitHpKing(), onBoard));
                Board.checkIsOnBoardOfPiece();
                return;
            }
            //khác nhau mỗi chỗ này m biết bug gì k
            //phong ngẫu nhiên tịnh mã xe hậu
            int choice = (int) (Math.random()*4);

            // choice=0;
            if(choice==0)onBoard.addPiece(new Queen(standing,onBoard.getInitTurnQueen(),onBoard.getInitHpQueen(),onBoard));
            else if(choice==1)onBoard.addPiece(new Rook(standing,onBoard.getInitTurnRook(),onBoard.getInitHpRook(),onBoard));
            else if(choice==2)onBoard.addPiece(new Knight(standing,onBoard.getInitTurnKnight(),onBoard.getInitHpKnight(),onBoard));
            else onBoard.addPiece(new Bishop(standing,onBoard.getInitTurnBishop(),onBoard.getInitHpBishop(),onBoard));
            
        }
    }

    @Override
    char getSymbol() {
        return 'P';
    }

    @Override
    int cacl(Tile c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cacl'");
    }
    
}
