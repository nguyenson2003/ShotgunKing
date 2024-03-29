package model;

/**
 * Ô của bàn cờ
 * giá trị x và y tính từ 1 đến 8
 */
public class Tile {
    public int x, y;
    /**
     * Tạo ra 1 ô bàn cờ trong khoảng từ 1 đến 8
     * @param x cột của ô cờ
     * @param y hàng của ô cờ
     */
    public Tile(int x,int y){
        if(!isOnBoard(x, y))throw new IllegalArgumentException("ko fai o ban co");
        this.x=x;this.y=y;
    }
    public static boolean isOnBoard(int x, int y){
        return x>0 && y>0 && x<9 && y<9;
    }
    @Override
    public boolean equals(Object obj) {
        Tile that = (Tile)obj;
        return this.x==that.x && this.y==that.y;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
