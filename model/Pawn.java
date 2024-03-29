package model;

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

    Pawn(Tile t,int maxTurn,int maxHP) {
        super(t,maxTurn,maxHP);
    }

    @Override
    boolean isMate(Tile nextCell) {
        if(nextCell.y==standing.y+1 && (nextCell.x==standing.x-1 || nextCell.x==standing.x+1))
            return true;
        return false;
        
    }

    @Override
    Tile bestMove() {
        Tile temp = new Tile(standing.x, standing.y+1);
        if(Board.ins.getPiece(temp)==null && temp.y<=8)
            return temp;
        else return standing;
    }

    @Override
    public void move(Tile nextMove) {
        super.move(nextMove);
        if(nextMove.y==8){
            //TODO: Phong hậu
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
