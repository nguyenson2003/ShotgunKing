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
    /**
     * tính toán nước đi như vua trắng
     */
    int caclAsWhiteKing(Tile c){
        int res=0;
        BlackKing bk=onBoard.getBlackKing();
        //ưu tiên tiếp cận vua trắng
        int sumAbs=Math.abs(c.x-bk.standing.x)+Math.abs(c.y-bk.standing.y);
        res+=1000-sumAbs;
        //khi có thể bị tiêu diệt thì sẽ giữ khoảng cách
        if(bk.isCanShoot()&&this.hp<=bk.firePower)
            res+=sumAbs;
        //ưu tiên phong quân
        res+=1000-(8-c.y);
        return res;
    }

    @Override
    Tile bestMove() {
        BlackKing bk=onBoard.getBlackKing();
        if(standing.y == 8){
            return standing;
        }
        //áp dụng thẻ tự do
        if(onBoard.dataBuff.isTuDo){
            int bestScore=caclAsWhiteKing(standing);
            Tile resTile=new Tile(this.standing.x, this.standing.y);
            int tempx[]=bk.aroundX.clone();
            int tempy[]=bk.aroundY.clone();   
            for(int i=0;i<8;i++){
                //nếu nó k trên bàn cờ thì continue
                int x=this.standing.x+tempx[i], y=this.standing.y+tempy[i];
                if(!Tile.isOnBoard(x,y )) continue;
                Tile tempTile=new Tile(x, y);
                //nếu vị trí này có quân cờ rồi thì continue
                if(onBoard.getPiece(tempTile)!=null) continue;
                int tempScore=caclAsWhiteKing(tempTile);
                //ủy quyền quân vương
                if(onBoard.dataBuff.isUyQuyenQuanVuong &&
                    bk.checkUyQuyenQuanVuong(tempTile))
                    tempScore=Integer.MIN_VALUE;
                if(bestScore<tempScore){
                    bestScore=tempScore;
                    resTile=tempTile;
                }
            }
            //áp dụng xung phong
            if(onBoard.dataBuff.isXungPhong&&onBoard.dataBuff.isMovedTwoTile){
                onBoard.dataBuff.isMovedTwoTile=false;
                Tile tempTile=new Tile(standing.x,standing.y+2);
                int tempScore=caclAsWhiteKing(tempTile);
                //ủy quyền quân vương
                if(onBoard.dataBuff.isUyQuyenQuanVuong &&
                    bk.checkUyQuyenQuanVuong(tempTile))
                    tempScore=Integer.MIN_VALUE;
                if(bestScore<tempScore){
                    bestScore=tempScore;
                    resTile=tempTile;
                }
            }
            return resTile;
        }
        Tile temp = new Tile(standing.x, standing.y+1);
        //áp dụng xung phong -> đương nhiêu ưu tiên đi 2 nước
        if(onBoard.dataBuff.isXungPhong&&!onBoard.dataBuff.isMovedTwoTile){
            onBoard.dataBuff.isMovedTwoTile=true;
            temp.y++;
        }
        if(onBoard.getPiece(temp)==null && standing.y<8){
            //ủy quyền quân vương
            if(onBoard.dataBuff.isUyQuyenQuanVuong &&
                bk.checkUyQuyenQuanVuong(temp))
                return standing;
            return temp;
        }else return standing;
        
    }

    @Override
    public void move(Tile nextMove) {
        super.move(nextMove);
        if(standing.y==8){
//            onBoard.removePiece(this);
            hp=0;
            // Ngai vàng bỏ trống -> phong vua
            if(onBoard.dataBuff.isNgaiVangBoTrong && onBoard.dataBuff.isBecomeKing==false){
                onBoard.dataBuff.isBecomeKing=true;
                onBoard.addPiece(new King(standing, onBoard.getInitTurnKing(), onBoard.getInitHpKing(), onBoard));
                onBoard.checkIsOnBoardOfPiece();
                return;
            }
           
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
