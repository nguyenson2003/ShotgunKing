package model;

public abstract class WhitePiece extends Piece{
    

    WhitePiece(Tile t,int maxTurn, int maxHP,Board onBoard_) {
        super(t,onBoard_);
        this.maxTurn=3;
        this.turn=(int) Math.round(this.maxTurn*Math.random());
        this.hp=this.maxHP=3;
    }


    int maxTurn,turn;
    int maxHP,hp;
    /**
     * kiểm tra có chiếu ô x, y hay ko
     * @param nextCell nước đi tiếp theo của vua đen
     * @return nước đi tiếp theo của vua đen có bị chiếu bởi quân cờ này hay ko
     */
    abstract boolean isMate(Tile nextCell);

    /**
     * quân trắng giết quân vua
     */
    public void mate(Tile nextMove){
        if(!isMate(nextMove))throw new IllegalArgumentException("Ô này không chiếu hết");
        standing=nextMove;
    }

    /**
     * kiểm tra đến lượt di chuyển chưa
     */
    public boolean canMove(){return turn<=0;}

    /**
     * <div> Tính điểm của quân cờ khi ở ô c </div>
     * Quy tắc tính điểm:
     * <ul>
     *      <li>500: chiếu tướng trực tiếp</li>
     *      <li>250: chiếu tướng gián tiếp</li>
     *      <li>-250: chắn chiếu tướng (chưa cần làm vội)</li>
     *      <li>20: mỗi 1 ô xung quanh ô tướng</li>
     *      <li>a (1 -> 10): vị trí quân cờ trên bàn cờ (tùy thuộc vào loại quân cờ và vị trí tương đối với quân vua sẽ có 1 cách tính khác nhau)</li>
     *      <li>b (1 -> 10): giá trị của quân cờ (ví dụ tốt 1đ, hậu 9đ)
     *      <li>2: với mỗi 1 hp của quân cờ</li>
     * </ul>
     * @return Trả về giá trị của quân cờ khi ở ô c
     */
    abstract int cacl(Tile c);

    /**
     * Trả về nước đi tốt nhất
     */
    abstract Tile bestMove();

    public void move(Tile nextMove){
        turn--;
        if(turn>0){
            return;
        }
        if(Board.ins.getPiece(nextMove)!=null && Board.ins.getPiece(nextMove)!=this)
            throw new IllegalArgumentException(
                String.format("Ô %d,%d đã có quân cờ", nextMove.x,nextMove.y)
            );
        standing = nextMove;
        turn=maxTurn;
    }

    public void takeDamage(){
        hp--;
        if(isDied())onBoard.removePiece(this);
    }
    public boolean isDied(){
        return hp<=0;
    }

    /**
     * Kiểm tra xem có quân cờ nào nằm giữa Tile start và Tile end
     * @param start Tile vị trí bắt đầu 
     * @param end Tile vị trí kết thúc
     * @param direction = -1 hướng ngang dọc
     * @param direction = 0 hướng cả ngang dọc và chéo
     * @param direction = 1 hướng chéo 
     * @return trả về true false
     */
    boolean isHasPieceBetween(Tile start, Tile end,int direction){
        if(start.x>end.x){
            Tile temp=new Tile(direction, direction);
            start=end;
            end=temp;
            return false;
        }
            
        if(direction==-1)//ngang dọc
            if(start.x==end.x)
        return false;
        return false;
    }

}
