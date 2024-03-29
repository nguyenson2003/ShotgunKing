package model;

public class Rook extends WhitePiece{
    int scoreStanding[][]={ {0,0,0,0,0,0,0,0,0},

                            {0, 4,4,4,4,4,4,4,4},
                            {0, 5,6,6,6,6,6,6,5},
                            {0, 1,3,3,3,3,3,3,1},
                            {0, 1,3,3,3,3,3,3,1},
                            {0, 1,3,3,3,3,3,3,1},
                            {0, 1,3,3,3,3,3,3,1},
                            {0, 1,3,3,3,3,3,3,1},
                            {0, 3,3,4,5,5,4,3,3},
                            };
    //nếu tốt là 1 thì xe là 4
    int valueOfRook=5;
    Rook(Tile t, int maxTurn, int maxHP) {
        super(t, maxTurn, maxHP);
        //TODO Auto-generated constructor stub
    }
    @Override
    boolean isMate(Tile nextCell) {
        if((nextCell.x==standing.x && (nextCell.y==standing.y-1 || nextCell.y==standing.y+1 ||nextCell.y==standing.y-2
                        ||nextCell.y==standing.y+2 ||nextCell.y==standing.y-3 ||nextCell.y==standing.y+3
                        ||nextCell.y==standing.y-4 ||nextCell.y==standing.y+4 ||nextCell.y==standing.y-5 ||nextCell.y==standing.y+5
                        ||nextCell.y==standing.y-6||nextCell.y==standing.y+6 ||nextCell.y==standing.y-7 ||nextCell.y==standing.y+7 ))
            ||
            (nextCell.y==standing.y && (nextCell.x==standing.x-1 || nextCell.x==standing.x+1 ||nextCell.x==standing.x-2
                        ||nextCell.x==standing.x+2 ||nextCell.x==standing.x-3 ||nextCell.x==standing.x+3
                        ||nextCell.x==standing.x-4 ||nextCell.x==standing.x+4 ||nextCell.x==standing.x-5 ||nextCell.x==standing.x+5
                        ||nextCell.x==standing.x-6||nextCell.x==standing.x+6 ||nextCell.x==standing.x-7 ||nextCell.x==standing.x+7 )))
            return true;
        return false;
    }
    

    @Override
    int cacl(Tile c) {
        int res=0;
        BlackKing blackKing=Board.ins.getBlackKing();
//      500: chiếu tướng trực tiếp
        if(c.x==blackKing.standing.x)
            for(int i=c.y;i!=blackKing.standing.y;)
        if(c.y==blackKing.standing.y)

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
        //res+=scoreStanding[c.x][c.y]+valueOfKing+2*this.hp;
        return res;
    }

    @Override
    Tile bestMove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bestMove'");
    }
    @Override
    char getSymbol() {
        return 'W';
    }
}
