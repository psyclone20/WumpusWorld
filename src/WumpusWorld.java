import java.util.Scanner;

class WumpusWorld {
    static Block[][] maze;
    static int n;
    
    public static void main(String[] args) {
   	 Scanner sc = new Scanner(System.in);
   	 
   	 System.out.print("Enter the order of the maze: ");
   	 n = sc.nextInt();
   	 
   	 maze = new Block[n][n];
   	 for(int i=0; i<n; i++) {
   		 maze[i] = new Block[n];
   		 for(int j=0; j<n; j++)
   			 maze[i][j] = new Block();
   	 }
   	 
   	 System.out.print("\nEnter the number of pits: ");
   	 int pits = sc.nextInt();
   	 
   	 for(int i=0; i<pits; i++) {
   		 System.out.print("Enter the location of pit " + (i+1) + ": ");
   		 addPit(n-sc.nextInt(), sc.nextInt()-1);
   	 }
   	 
   	 System.out.print("\nEnter the location of wumpus: ");
   	 addWumpus(n-sc.nextInt(), sc.nextInt()-1);
   	 
   	 System.out.print("\nEnter the location of gold: ");
   	 addGold(n-sc.nextInt(), sc.nextInt()-1);
   	 
   	 System.out.print("\nEnter the starting location: ");
   	 int r = n - sc.nextInt();
   	 int c = sc.nextInt() - 1;
   	 int rPrev = -1, cPrev = -1;
   	 
   	 int moves = 0;
   	 System.out.println("\nInitial state:");
   	 printMaze(r, c);
   	 
   	 while(!maze[r][c].hasGold) {
   		 maze[r][c].isVisited = true;
   		 maze[r][c].pitStatus = Block.NOT_PRESENT;
   		 maze[r][c].wumpusStatus = Block.NOT_PRESENT;
   		 
   		 if(!maze[r][c].hasBreeze) {
   			 if(r >= 1 && maze[r-1][c].pitStatus == Block.UNSURE)
   				 maze[r-1][c].pitStatus = Block.NOT_PRESENT;
   			 if(r <= (n-2) && maze[r+1][c].pitStatus == Block.UNSURE)
   				 maze[r+1][c].pitStatus = Block.NOT_PRESENT;
   			 if(c >= 1 && maze[r][c-1].pitStatus == Block.UNSURE)
   				 maze[r][c-1].pitStatus = Block.NOT_PRESENT;
   			 if(c <= (n-2) && maze[r][c+1].pitStatus == Block.UNSURE)
   				 maze[r][c+1].pitStatus = Block.NOT_PRESENT;
   		 }
   		 
   		 if(!maze[r][c].hasStench) {
   			 if(r >= 1 && maze[r-1][c].wumpusStatus == Block.UNSURE)
   				 maze[r-1][c].wumpusStatus = Block.NOT_PRESENT;
   			 if(r <= (n-2) && maze[r+1][c].wumpusStatus == Block.UNSURE)
   				 maze[r+1][c].wumpusStatus = Block.NOT_PRESENT;
   			 if(c >= 1 && maze[r][c-1].wumpusStatus == Block.UNSURE)
   				 maze[r][c-1].wumpusStatus = Block.NOT_PRESENT;
   			 if(c <= (n-2) && maze[r][c+1].wumpusStatus == Block.UNSURE)
   				 maze[r][c+1].wumpusStatus = Block.NOT_PRESENT;
   		 }
 
   		 boolean foundNewPath = false;
   		 
   		 if(r >= 1 && !((r-1) == rPrev && c == cPrev) && maze[r-1][c].isVisited == false && maze[r-1][c].pitStatus == Block.NOT_PRESENT && maze[r-1][c].wumpusStatus == Block.NOT_PRESENT) {
   			 rPrev = r;
   			 cPrev = c;
   			 
   			 r--;
   			 foundNewPath = true;
   		 }
   		 else if(r <= (n-2) && !((r+1) == rPrev && c == cPrev) && maze[r+1][c].isVisited == false && maze[r+1][c].pitStatus == Block.NOT_PRESENT && maze[r+1][c].wumpusStatus == Block.NOT_PRESENT) {
   			 rPrev = r;
   			 cPrev = c;
   			 
   			 r++;
   			 foundNewPath = true;
   		 }
   		 else if(c >= 1 && !(r == rPrev && (c-1) == cPrev) && maze[r][c-1].isVisited == false && maze[r][c-1].pitStatus == Block.NOT_PRESENT && maze[r][c-1].wumpusStatus == Block.NOT_PRESENT) {
   			 rPrev = r;
   			 cPrev = c;
   			 
   			 c--;
   			 foundNewPath = true;
   		 }
   		 else if(c <= (n-2) && !(r == rPrev && (c+1) == cPrev) && maze[r][c+1].isVisited == false && maze[r][c+1].pitStatus == Block.NOT_PRESENT && maze[r][c+1].wumpusStatus == Block.NOT_PRESENT) {
   			 rPrev = r;
   			 cPrev = c;
   			 
   			 c++;
   			 foundNewPath = true;
   		 }
   		 
   		 if(!foundNewPath) {
   			 int temp1 = rPrev;
   			 int temp2 = cPrev;
   			 
   			 rPrev = r;
   			 cPrev = c;
   			 
   			 r = temp1;
   			 c = temp2;
   		 }
   		 
   		 moves++;
 
   		 System.out.println("\n\nMove " + moves + ":");
   		 printMaze(r, c);
 
   		 if(moves > n*n) {
   			 System.out.println("\nNo solution found!");
   			 break;
   		 }
   	 }
   	 
   	 if(moves <= n*n)
   		 System.out.println("\nFound gold in " + moves + " moves.");
   	 
   	 sc.close();
    }
    
    static void addPit(int r, int c) {
   	 maze[r][c].hasPit = true;
   	 
   	 if(r >= 1)
   		 maze[r-1][c].hasBreeze = true;
   	 if(r <= (n-2))
   		 maze[r+1][c].hasBreeze = true;
   	 if(c >= 1)
   		 maze[r][c-1].hasBreeze = true;
   	 if(c <= (n-2))
   		 maze[r][c+1].hasBreeze = true;
    }
    
    static void addWumpus(int r, int c) {
   	 maze[r][c].hasWumpus = true;
   	 
   	 if(r >= 1)
   		 maze[r-1][c].hasStench = true;
   	 if(r <= (n-2))
   		 maze[r+1][c].hasStench = true;
   	 if(c >= 1)
   		 maze[r][c-1].hasStench = true;
   	 if(c <= (n-2))
   		 maze[r][c+1].hasStench = true;
    }
    
    static void addGold(int r, int c) {
   	 maze[r][c].hasGold = true;
    }
    
    static void printMaze(int r, int c) {
   	 for(int i=0; i<n; i++) {
   		 for(int j=0; j<n; j++) {
   			 char charToPrint = '-';
   			 if(r == i && c == j)
   				 charToPrint = '*';
   			 else if(maze[i][j].hasPit)
   				 charToPrint = 'O';
   			 else if(maze[i][j].hasWumpus)
   				 charToPrint = 'X';
   			 else if(maze[i][j].hasGold)
   				 charToPrint = '$';
   			 
   			 System.out.print(charToPrint + "\t");
   		 }
   		 System.out.println();
   	 }
    }
}
