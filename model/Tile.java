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
        if(x<1 || y<1 || x>8 || y>8)throw new IllegalArgumentException("ko fai o ban co");
        this.x=x;this.y=y;
    }
    @Override
    public boolean equals(Object obj) {
        Tile that = (Tile)obj;
        return this.x==that.x && this.y==that.y;
    }
}
