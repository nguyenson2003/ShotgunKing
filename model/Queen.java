package model;

public class Queen extends WhitePiece{
    int scoreStanding[][]={ {0,0,0,0,0,0,0,0,0},

                            {0, 1,2,2,3,3,2,2,1},
                            {0, 2,4,4,4,4,4,4,2},
                            {0, 2,4,6,6,6,6,4,2},
                            {0, 3,4,6,6,6,6,4,3},
                            {0, 3,4,6,6,6,6,4,3},
                            {0, 2,4,6,6,6,6,4,2},
                            {0, 2,4,6,6,6,6,4,2},
                            {0, 1,2,2,3,3,2,2,1},
                            };
    //nếu tốt là 1 thì queen là 9
    int valueOfQueen=9;
    Queen(Tile t, int maxTurn, int maxHP,Board onBoard) {
        super(t, maxTurn, maxHP,onBoard);
        //TODO Auto-generated constructor stub
    }
    @Override
    boolean isMate(Tile nextCell) {
        return !isHasPieceBetweenDiagonal(nextCell, this.standing)||
            !isHasPieceBetweenStraight(this.standing, nextCell);
    }

    @Override
    int cacl(Tile c) {
        BlackKing bk=onBoard.getBlackKing();//black king
        int result=0;
        //chiếu tướng
        if(!isHasPieceBetweenDiagonal(bk.standing, c)
            ||!isHasPieceBetweenStraight(bk.standing, c))
            result+=500;
        //tọa độ xung quanh quân vua
        //thay vì kiểm tra xem quân tịnh soi đến vua không thì 
        //mình kiểm tra xem 8 ô quanh vua có bị soi không với mỗi ô bị soi +20
        int tempx[]={-1,0,1,-1,1,-1,0,1};
        int tempy[]={-1,-1,-1,0,0,1,1,1};
        //duyệt trong 8 ô
        for(int i=0;i<8;i++){
            //tọa độ temp là tọa độ xung quanh quân vua
            if(!Tile.isOnBoard(bk.standing.x+tempx[i],bk.standing.y+tempy[i])) continue;
            Tile temp=new Tile(bk.standing.x+tempx[i],bk.standing.y+tempy[i]);
            //mỗi nước ở xung quanh +20
            if(!isHasPieceBetweenDiagonal(temp, c)
                ||!isHasPieceBetweenStraight(temp, c)){
                if(temp.equals(c)&&bk.firePower>=this.hp&&bk.isCanShoot()){
                    result-=20;
                    System.out.println("\t\t-20 "+temp.x+' '+temp.y);
                }
                result+=20;
            }
        }
        // chắn chiếu tướng
        //TODO: chắn chiếu tướng

        //vị trí quân cờ trên bàn cờ, giá trị quân cờ, hp quân cờ *2
        result+=scoreStanding[c.x][c.y];
        result+=valueOfQueen;
        result+=this.hp*2;

        return result;
    }

    @Override
    Tile bestMove() {
        int bestScore=0;
        Tile resTile=new Tile(this.standing.x, this.standing.y);
        //4 hướng, 2 phần tử là 1 hướng
        int di[]={1,1,-1,1,1,-1,-1,-1,1,0,-1,0,0,1,0,-1};
        int x=this.standing.x;
        int y=this.standing.y;
        //8 hướng
        for(int j=1;j<=8;j++)
            //khoảng cách từ 1 -> 7
            for(int i=1;i<=7;i++){
                if(Tile.isOnBoard(x+i*di[j*2-2], y+i*di[j*2-1])){
                    Tile tempTile=new Tile(x+i*di[j*2-2], y+i*di[j*2-1]);
                    if(onBoard.getPiece(tempTile)==null){
                        int tempScore=cacl(tempTile);
                        if(bestScore<tempScore){
                            bestScore=tempScore;
                            resTile=tempTile;
                        }
                    }else
                        break;
                    
                }else
                    break;
            }

        return resTile;
    }
    @Override
    char getSymbol() {
        return 'Q';
    }
}
