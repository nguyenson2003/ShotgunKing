package model;

public abstract class WhitePiece extends Piece{
    

    WhitePiece(Tile t,int maxTurn, int maxHP,Board onBoard_) {
        super(t,onBoard_);
        this.maxTurn=maxTurn;
        this.turn=(int) Math.round(this.maxTurn*Math.random());
        this.hp=this.maxHP=maxHP;
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
    public boolean canMove(){return turn<=1;}

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
        if(onBoard.getPiece(nextMove)!=null && onBoard.getPiece(nextMove)!=this)
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
     * Kiểm tra xem có quân cờ nào nằm giữa Tile start và Tile end theo đường thẳng không. Không tính vua đen
     * @param start Tile vị trí bắt đầu 
     * @param end Tile vị trí kết thúc
     */
    boolean isHasPieceBetweenStraight (Tile start, Tile end){
        if(start.x!=end.x&&start.y!=end.y)
            return true;
        else{
            if(start.x==end.x){
                for(int i=Math.min(start.y,end.y)+1;i<Math.max(start.y,end.y);i++){
                    if(onBoard.getPiece(new Tile(start.x, i))!=null&&
                        onBoard.getPiece(new Tile(start.x, i))!=onBoard.getBlackKing())
                        return true;
                }
                return false;
            }else{
                for(int i=Math.min(start.x,end.x)+1;i<Math.max(start.x,end.x);i++){
                    if(onBoard.getPiece(new Tile(i, start.y))!=null&&
                    onBoard.getPiece(new Tile(i, start.y))!=onBoard.getBlackKing())
                        return true;
                }
                return false;
            }
        }
    }
    /**
     * Kiểm tra xem có quân cờ nào nằm giữa Tile start và Tile end theo đường chéo không. Không tính vua đen
     * @param start Tile vị trí bắt đầu 
     * @param end Tile vị trí kết thúc
     */
    boolean isHasPieceBetweenDiagonal (Tile start, Tile end){
        //kiểm tra xem có cùng đường chéo k
        //nếu không cùng đường chéo sẽ coi như có 1 quân ở giữa và không thể chiếu
        if(start.x-start.y!=end.x-end.y&&start.x+start.y!=end.x+end.y)
            return true;
        else{
            //nếu cùng đường chéo thì
            if(start.x-start.y==end.x-end.y){
                for(int i=Math.min(start.x,end.x)+1;i<Math.max(start.x,end.x);i++){
                    System.out.println("cheo1 "+i+" "+start.x+" "+start.y+" "+end.x+" "+end.y);
                    if(onBoard.getPiece(new Tile(i,i-start.x+start.y))!=null&&
                    onBoard.getPiece(new Tile(i,i-start.x+start.y))!=onBoard.getBlackKing())
                        return true;
                }
                return false;
            }else {
                for(int i=Math.min(start.x,end.x)+1;i<Math.max(start.x,end.x);i++){
                    System.out.println("cheo2 "+i+" "+start.x+" "+start.y+" "+end.x+" "+end.y);
                    if(onBoard.getPiece(new Tile(i,-i+start.x+start.y))!=null&&
                    onBoard.getPiece(new Tile(i,-i+start.x+start.y))!=onBoard.getBlackKing())
                        return true;
                }
                return false;
            }
        }
    }

}
