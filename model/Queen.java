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
    Queen(Tile t, int maxTurn, int maxHP) {
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
                ||nextCell.x==standing.x-6||nextCell.x==standing.x+6 ||nextCell.x==standing.x-7 ||nextCell.x==standing.x+7 ))
        ||
        (nextCell.y==standing.y+1 && (nextCell.x==standing.x-1 || nextCell.x==standing.x+1 ))||
        (nextCell.y==standing.y-1 && (nextCell.x==standing.x-1 || nextCell.x==standing.x+1))||
        (nextCell.y==standing.y+2 && (nextCell.x==standing.x-2 || nextCell.x==standing.x+2 ))||
        (nextCell.y==standing.y-2 && (nextCell.x==standing.x-2 || nextCell.x==standing.x+2))||
        (nextCell.y==standing.y+3 && (nextCell.x==standing.x-3 || nextCell.x==standing.x+3 ))||
        (nextCell.y==standing.y-3 && (nextCell.x==standing.x-3 || nextCell.x==standing.x+3))||
        (nextCell.y==standing.y+4 && (nextCell.x==standing.x-4 || nextCell.x==standing.x+4 ))||
        (nextCell.y==standing.y-4 && (nextCell.x==standing.x-4 || nextCell.x==standing.x+4))||
        (nextCell.y==standing.y+5 && (nextCell.x==standing.x-5 || nextCell.x==standing.x+5 ))||
        (nextCell.y==standing.y-5 && (nextCell.x==standing.x-5 || nextCell.x==standing.x+5))||
        (nextCell.y==standing.y+6 && (nextCell.x==standing.x-6 || nextCell.x==standing.x+6 ))||
        (nextCell.y==standing.y-6 && (nextCell.x==standing.x-6 || nextCell.x==standing.x+6))||
        (nextCell.y==standing.y+7 && (nextCell.x==standing.x-7 || nextCell.x==standing.x+7 ))||
        (nextCell.y==standing.y-7 && (nextCell.x==standing.x-7 || nextCell.x==standing.x+7)))
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
        return 'Q';
    }
}
