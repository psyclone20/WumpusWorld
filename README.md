# WumpusWorld
A solution to the renowned Wumpus World problem from Artificial Intelligence.

**Note:** The number of moves has been restricted to nxn, where n is the size of the maze, to avoid infinite looping.

# Sample input
![](http://courses.washington.edu/css482/hw60x.png)

(Image credits: University of Washington, Bothell)
```
Enter the order of the maze: 4

Enter the number of pits: 3
Enter the location of pit 1: 1 3
Enter the location of pit 2: 3 3
Enter the location of pit 3: 4 4

Enter the location of wumpus: 3 1

Enter the location of gold: 3 2

Enter the starting location: 1 1
```

# Sample output
```
Initial state:
-	-	-	O	
X	$	O	-	
-	-	-	-	
*	-	O	-	


Move 1:
-	-	-	O	
X	$	O	-	
*	-	-	-	
-	-	O	-	


Move 2:
-	-	-	O	
X	$	O	-	
-	-	-	-	
*	-	O	-	


Move 3:
-	-	-	O	
X	$	O	-	
-	-	-	-	
-	*	O	-	


Move 4:
-	-	-	O	
X	$	O	-	
-	*	-	-	
-	-	O	-	


Move 5:
-	-	-	O	
X	*	O	-	
-	-	-	-	
-	-	O	-	

Found gold in 5 moves.
```

# Symbols
**\*** - Player's current position

**O** - Pit

**X** - Wumpus

**$** - Gold
