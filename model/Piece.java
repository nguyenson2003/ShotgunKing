package model;

abstract public class Piece {
    
    /**
     * Quân cờ đang đứng ở ô nào
     */
    Tile standing;

    Piece(Tile standing_){
        standing=standing_;
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

    public Tile getStanding() {
        return standing;
    }
}
