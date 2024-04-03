package model;

public class WhiteKing extends WhitePiece{
    int scoreStanding[][]={ {0,0,0,0,0,0,0,0,0},

                            {0, 3,2,2,1,1,2,2,3},
                            {0, 3,2,2,1,1,2,2,3},
                            {0, 4,2,2,1,1,2,2,4},
                            {0, 4,2,2,1,1,2,2,4},
                            {0, 5,4,4,3,3,4,4,5},
                            {0, 5,4,4,4,4,4,4,5},
                            {0, 6,5,4,4,4,4,5,6},
                            {0, 6,6,5,5,5,5,6,6},
                            };
    //nếu tốt là 1 thì king là 3
    int valueOfKing=3;
    WhiteKing(Tile t, int maxTurn, int maxHP,Board onBoard_) {
        super(t, maxTurn, maxHP,onBoard_);
        //TODO Auto-generated constructor stub
    }
    @Override
    boolean isMate(Tile nextCell) {
        if((nextCell.y==standing.y+1 && (nextCell.x==standing.x-1 || nextCell.x==standing.x+1 ||nextCell.x==standing.x ))||
        (nextCell.y==standing.y-1 && (nextCell.x==standing.x-1 || nextCell.x==standing.x+1||nextCell.x==standing.x ))||
        (nextCell.x==standing.x+1 && nextCell.y==standing.y )||
        (nextCell.x==standing.x-1 && nextCell.y==standing.y ))
            return true;
        return false;
    }

    @Override
    int cacl(Tile c) {
        int res=0;
        BlackKing blackKing=onBoard.getBlackKing();
//      500: chiếu tướng trực tiếp
        if(Math.abs(c.x-blackKing.standing.x)<=1 &&
            Math.abs(c.y-blackKing.standing.y)<=1)
            res+=500;
// 250: chiếu tướng gián tiếp //k có
// -250: chắn chiếu tướng (chưa cần làm vội)
// 20: mỗi 1 ô xung quanh ô tướng
        if(Math.abs(c.x-blackKing.standing.x)<=1 &&
            Math.abs(c.y-blackKing.standing.y)<=1)
            res+=20*2;
// a (1 -> 10): vị trí quân cờ trên bàn cờ (tùy thuộc vào loại quân cờ và vị trí tương đối với quân vua sẽ có 1 cách tính khác nhau)
// b (1 -> 10): giá trị của quân cờ (ví dụ tốt 1đ, hậu 9đ)
// 2: với mỗi 1 hp của quân cờ
        res+=scoreStanding[c.x][c.y]+valueOfKing+2*this.hp;
        return res;
    }

    @Override
    Tile bestMove() {
        int bestScore=0;
        Tile resTile=new Tile(this.standing.x, this.standing.y);
        int tempx[]={-1,0,1,-1,1,-1,0,1};
        int tempy[]={-1,-1,-1,0,0,1,1,1};
        for(int i=0;i<8;i++){
            if(!Tile.isOnBoard(this.standing.x+tempx[i], this.standing.y+tempy[i])) continue;
            Tile tempTile=new Tile(this.standing.x+tempx[i], this.standing.y+tempy[i]);
            int tempScore=cacl(tempTile);
            if(bestScore<tempScore){
                bestScore=tempScore;
                resTile=tempTile;
            }
        }
        return resTile;
    }
    @Override
    char getSymbol() {
        return 'W';
    }
}
