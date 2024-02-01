package model;

public class BlackKing extends Piece {
    int sheild,maxSheild;
    int shellAmmo,maxShellAmmo,ammo,maxAmmo;
    BlackKing(Tile t) {
        super(t);
        sheild=maxSheild=2;
        shellAmmo=maxShellAmmo=2;
        ammo=maxAmmo=8;
    }
    public void reloadAmmo(){
        if(shellAmmo<maxShellAmmo && ammo>0){
            int waitAmmo=Math.min(ammo,maxShellAmmo-shellAmmo);
            shellAmmo+=waitAmmo;
            ammo-=waitAmmo;
        }else{
            ammo++;
        }
    }

    public boolean canMoveTo(Tile nextMove){
        if(Board.ins.getPiece(nextMove)!=null)return false;
        if(Math.abs(nextMove.x-standing.x)<=1 && Math.abs(nextMove.y-standing.y)<=1)
            return true;
        return false;
    }

    /**
     * 
     * @param nextMove
     */
    public void move(Tile nextMove){
        if(Board.ins.getPiece(nextMove)!=null)
            throw new IllegalArgumentException(
                String.format("o %d,%d da co quan co", nextMove.x,nextMove.y)
            );
        standing = nextMove;
    }
    @Override
    char getSymbol() {
        return 'k';
    }
    
}
