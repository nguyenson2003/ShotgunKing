package model;

public class Queen extends WhitePiece{
    Queen(Tile t, int maxTurn, int maxHP,Board onBoard) {
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
