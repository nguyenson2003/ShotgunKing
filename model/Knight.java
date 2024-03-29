package model;

public class Knight extends WhitePiece{
    //đánh giá vị trí đứng trên bàn cờ dựa vào video sơn gửi
    //theo như quan sát có 6 mức độ màu do đó số điểm sẽ từ 1-6
    //do tile theo tọa độ từ 1-8 nên mảng này cũng vậy
    int scoreStanding[][]={ {0,0,0,0,0,0,0,0,0},

                            {0, 1,2,3,3,3,3,2,1},
                            {0, 2,3,4,4,4,4,3,2},
                            {0, 3,4,5,5,5,5,4,3},
                            {0, 3,4,5,6,6,5,4,3},
                            {0, 3,4,5,6,6,5,4,3},
                            {0, 3,4,5,5,5,5,4,3},
                            {0, 2,3,4,4,4,4,3,2},
                            {0, 1,2,3,3,3,3,2,1},
                            };
    //nếu tốt là 1 thì mã tầm 3
    int valueOfKnight=3;
    Knight(Tile t, int maxTurn, int maxHP,Board onBoard) {
        super(t, maxTurn, maxHP,onBoard);
        //TODO Auto-generated constructor stub
    }

    @Override
    boolean isMate(Tile nextCell) {
        if((nextCell.y==standing.y+2 && (nextCell.x==standing.x-1 || nextCell.x==standing.x+1))||
        (nextCell.y==standing.y-2 && (nextCell.x==standing.x-1 || nextCell.x==standing.x+1))||
        (nextCell.x==standing.x+2 && (nextCell.y==standing.y-1 || nextCell.y==standing.y+1))||
        (nextCell.x==standing.x-2 && (nextCell.y==standing.y-1 || nextCell.y==standing.y+1)))
            return true;
        return false;
    }

    @Override
    int cacl(Tile c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cacl'");
    }

    @Override
    Tile bestMove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bestMove'");
    }

    @Override
    char getSymbol() {
        return 'K';
    }

}
