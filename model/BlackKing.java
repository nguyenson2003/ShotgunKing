package model;

public class BlackKing extends Piece {
    //shield: khiên
    int shield, maxShield;
    //shellAmmo: đạn trong súng, spareAmmo: đạn dự phòng
    int shellAmmo,maxShellAmmo,spareAmmo,maxSpareAmmo;
    //firePower: hỏa lực|số sát thương trong 1 lần bắn (chia đều các con trong vùng)
    //fireRange: tầm bắn +-1
    //spread: góc lệch
    int firePower,fireRange,spread;
    BlackKing(Tile standing,Board onBoard) {
        super(standing,onBoard);
        shield = maxShield =2;
        shellAmmo=maxShellAmmo=2;
        spareAmmo=maxSpareAmmo=8;
    }
    public void reloadAmmo(){
        if(shellAmmo<maxShellAmmo && spareAmmo>0){
            int waitAmmo=Math.min(spareAmmo,maxShellAmmo-shellAmmo);
            shellAmmo+=waitAmmo;
            spareAmmo-=waitAmmo;
        }else if(spareAmmo<maxSpareAmmo){
            spareAmmo++;
        }
    }

    public boolean canMoveTo(Tile nextMove){
        if(onBoard.getPiece(nextMove)!=null)return false;
        if(Math.abs(nextMove.x-standing.x)<=1 && Math.abs(nextMove.y-standing.y)<=1)
            return true;
        else
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
        if(!canMoveTo(nextMove))
            throw new IllegalArgumentException("quan co ko the di den o nay");
        standing = nextMove;

        reloadAmmo();
    }

    /**
     *
     * @param angle
     */
    public void shoot(int angle){
        if(shellAmmo<0)return;
        shellAmmo--;
        //TODO: hàm bắn nhau
    }
    


    @Override
    char getSymbol() {
        return 'k';
    }
    
}
