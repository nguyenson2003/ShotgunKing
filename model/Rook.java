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
    Rook(Tile t, int maxTurn, int maxHP,Board onBoard) {
        super(t, maxTurn, maxHP,onBoard);
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
        return 'W';
    }
}
