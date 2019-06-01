package ttt;

import java.util.*;
import java.io.*;

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
	
	//public 
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);  
		
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
			grid.printOut(); 
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
			
			System.out.println("Enter position for player 2. ");
			input = scanner.nextInt(); 
			Position y = getPosition(input); 
			while(grid.addVal(y, 2) == false)
			{
				System.out.println("Wrong input. Try again. ");
				input = scanner.nextInt(); 
				y = getPosition(input);
			}
			grid.addVal(y, 2); 
			grid.printOut();
			if(grid.win(2) == true)
			{
				System.out.println("Player 2 (O) WINS!!!"); 
				
				System.exit(0);
			}
			
		}while(input != 00); 
		
		scanner.close();
		
		
	}
}
