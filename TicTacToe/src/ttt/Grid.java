package ttt;

import java.util.*;

public class Grid 
{	
	Element grid[][];
	int elementsFilled; 
	
	Grid()
	{
		grid = new Element[3][3];
		
		//makes the grid empty. 
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				grid[i][j] = new Element(0); 
			}
		}
		
	}
	
	public boolean positionIsEmpty(Position p)
	{
		if(grid[p.x][p.y].isEqual(new Element(0)))
		{
			return true; 
		}
		
		return false; 
	}
	
	public void printOut()
	{
		for(int i = 0; i < 3; i++)
		{
			System.out.println();
			for(int j = 0; j < 3; j++)
			{
				System.out.print(grid[i][j]); 
			}
		}
	}
	
	public boolean win(int XorO)
	{
		//we dont need loops here. 
		//there are 4 lines we need to check, then 2 diagnols. 
		//false, until proven right?
		
		//rows and columns. 
		for(int i = 0; i < 3; i++)
		{
			if((grid[0][i].isEqual(new Element(XorO)) && grid[1][i].isEqual(new Element(XorO)) && grid[2][i].isEqual(new Element(XorO))))
			{
				return true; 
			}
			if((grid[i][0].isEqual(new Element(XorO)) && grid[i][1].isEqual(new Element(XorO)) && grid[i][2].isEqual(new Element(XorO))))
			{
				return true; 
			}
		}
		
		//now check the diagonal
		if(grid[0][0].isEqual(new Element(XorO)) && grid[1][1].isEqual(new Element(XorO)) && grid[2][2].isEqual(new Element(XorO)))
		{
			return true; 
		}
		if(grid[0][2].isEqual(new Element(XorO)) && grid[1][1].isEqual(new Element(XorO)) && grid[2][0].isEqual(new Element(XorO)))
		{
			return true; 
		}
		
		return false; 
	}
	
	public static Position getPosition(int input)
	{
		Position p; 
		switch(input)
		{
			case 00:
				p = new Position(0,0); 
			case 11:
				p = new Position(0,0);
				break;
			case 12:
				p = new Position(0,1);
				break;
			case 13:
				p = new Position(0,2);
				break;
			case 21:
				p = new Position(1,0);
				break;
			case 22:
				p = new Position(1,1);
				break;
			case 23:
				p = new Position(1,2);
				break;
			case 31:
				p = new Position(2,0);
				break;
			case 32:
				p = new Position(2,1);
				break;
			case 33:
				p = new Position(2,2);
				break;
			default: 
				p = null;
				break; 
		}
		
		return p; 
	}

	public boolean addVal(Position x, int XorO)
	{
		if(x == null)
		{
			System.out.println("w");
			return false; 
		}
		
		if(!(grid[x.x][x.y].isEqual(new Element(0))))
		{
			if(grid[x.x][x.y].isEqual(new Element(1)))
			{
				System.out.println("This element has X. ");
			}
			else
			{
				System.out.println("This element has O. ");
			}
			 
			return false; 
		}
		
		//now we add the value into the grid. 
		grid[x.x][x.y] = new Element(XorO); 
		
		elementsFilled++;
		
		return true; 
	}
	
	public boolean isEmpty()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(!grid[i][j].isEqual(new Element(0)))
				{
					return false; 
				}
			}
		}
		
		return true; 
	}
	
	public Position ai()
	{
		//this is going to act as player 2. 
		
		//to make this, first defensive
		
		//first step, put in a point a random middle point. 
		
		//then see if there is a line, then try and break it. 
		
		//first move is going to be a corner. 
		
		//11, 13, 31, 33
		Position p; 
		Random random = new Random();
		int ran = random.nextInt((3 - 1) + 1) + 1; 
		if(ran == 1)
		{
			Random r = new Random(); 
			int rand = r.nextInt((4 - 1) + 1) + 1; 
			System.out.println();
			System.out.println(rand + " is the random number. ");  
			switch(rand)
			{
				case 1: 
					p = new Position(0,0);
					break; 
				case 2: 
					p = new Position(0,2);
					break;
				case 3: 
					p = new Position(2,0);
					break;
				case 4: 
					p = new Position(2,2);
					break;
				default: 
					p = null; 
					break; 
			}
		}
		else if(ran == 2)
		{
			//this is going to have all the middle pieces.
			
			//12, 21, 23, 32
			
			Random r = new Random(); 
			int rand = r.nextInt((4 - 1) + 1) + 1; 
			System.out.println();
			System.out.println(rand + " is the random number. ");  
			switch(rand)
			{
				case 1: 
					p = new Position(0,1);
					break; 
				case 2: 
					p = new Position(1,0);
					break;
				case 3: 
					p = new Position(1,2);
					break;
				case 4: 
					p = new Position(2,1);
					break;
				default: 
					p = null; 
					break; 
			}
		}
		else
		{
			//this is the center. 
			
			p = new Position(1,1); 
		}
		

		return p; 
		
		
		
		//1 - 4
		
		//rand.nextInt((max - min) + 1) + min;
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);  
		
		System.out.println("One or two player(s)? ");
		int players = scanner.nextInt(); 
		
		Grid grid = new Grid(); 
		
		System.out.println();
		
		System.out.println("The coordinate system is below. ");
		
		System.out.println("	1 2 3");
		System.out.println("1 	x x x");
		System.out.println("2 	x x x");
		System.out.println("3 	x x x");
		
		int input; 
		do {
			if(grid.elementsFilled == 9)
			{
				System.out.println("End of Game. ");
				System.exit(0);
			}
			
			System.out.println("Enter position for player 1. ");
			input = scanner.nextInt(); 
			Position x = getPosition(input); 
			while(grid.addVal(x, 1) == false)
			{
				System.out.println("Wrong input. Try again. ");
				input = scanner.nextInt(); 
				x = getPosition(input);
			}
			grid.addVal(x, 1); 
			grid.printOut(); System.out.println();
			if(grid.win(1) == true)
			{
				System.out.println("Player 1 (X) WINS!!!"); 
				
				System.exit(0);
			}
			
			if(grid.elementsFilled == 9)
			{
				System.out.println("End of Game. ");
				System.exit(0);
			}
			
			//Player 2 / AI
			
			Position y; 
			
			if(players == 1)
			{
				y = grid.ai();
				
				//y == null ||
				
				while(grid.positionIsEmpty(y) == false)
				{
					y = grid.ai();
				}
			}
			else {
				System.out.println("Enter position for player 2. ");
				input = scanner.nextInt(); 
				y = getPosition(input); 
				while(grid.addVal(y, 2) == false)
				{
					System.out.println("Wrong input. Try again. ");
					input = scanner.nextInt(); 
					y = getPosition(input);
				}
			}
			
			
			grid.addVal(y, 2); 
			grid.printOut();System.out.println();
			if(grid.win(2) == true)
			{
				System.out.println("Player 2 (O) WINS!!!"); 
				
				System.exit(0);
			}
			
		}while(input != 00); 
		
		scanner.close();
		
		
	}
}
