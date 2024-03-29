package model;

public class Bishop extends WhitePiece{
    int scoreStanding[][]={ {0,0,0,0,0,0,0,0,0},

                            {0, 1,2,2,2,2,2,2,1},
                            {0, 2,4,4,4,4,4,4,2},
                            {0, 2,4,4,6,6,4,4,2},
                            {0, 2,4,4,6,6,4,4,2},
                            {0, 2,4,6,6,6,6,4,2},
                            {0, 2,5,5,5,5,5,5,2},
                            {0, 2,5,3,3,3,3,5,2},
                            {0, 3,2,2,2,2,2,2,3},
                            };
    //nếu tốt là 1 thì tịnh là 3
    int valueOfBishop=3;
    Bishop(Tile t, int maxTurn, int maxHP) {
        super(t, maxTurn, maxHP);
        //TODO Auto-generated constructor stub
    }
    @Override
    boolean isMate(Tile nextCell) {
        if((nextCell.y==standing.y+1 && (nextCell.x==standing.x-1 || nextCell.x==standing.x+1 ))||
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
        (nextCell.y==standing.y-7 && (nextCell.x==standing.x-7 || nextCell.x==standing.x+7)) )
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
        return 'B';
    }
}
