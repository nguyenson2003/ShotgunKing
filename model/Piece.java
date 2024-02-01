package model;

abstract class Piece {
    
    /**
     * Quân cờ đang đứng ở ô nào
     */
    Tile standing; 

    Piece(Tile t){
        standing=t;
    }
    
    /**
     * Trả về ký từ quân cờ, ví dụ quân xe:R
     * @param null
     * @return trả về ký tự quân cờ
     */
    abstract char getSymbol();
    

    @Override
    public String toString() {
        return getSymbol()+"";
    }
}
