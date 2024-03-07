package model;

public class Knight extends WhitePiece{

    Knight(Tile t, int maxTurn, int maxHP) {
        super(t, maxTurn, maxHP);
        //TODO Auto-generated constructor stub
    }

    @Override
    boolean isMate(Tile nextCell) {
        if(nextCell.y==standing.y+1 && (nextCell.x==standing.x-1 || nextCell.x==standing.x+1))
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSymbol'");
    }

}
