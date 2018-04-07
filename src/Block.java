public class Block {
    public static final int NOT_PRESENT = 0;
    public static final int UNSURE = 1;
    
    public boolean hasBreeze, hasPit;
    public int pitStatus = UNSURE;
    
    public boolean hasStench, hasWumpus;
    public int wumpusStatus = UNSURE;
    
    public boolean hasGold;
    
    public boolean isVisited;
}
