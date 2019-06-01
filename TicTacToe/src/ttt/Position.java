package ttt;

public class Position 
{
	int x; 
	int y; 
	
	Position(int x, int y)
	{
		this.x = x; 
		this.y = y; 
	}
	
	public boolean isEqual(Position z)
	{
		return ((z.x == this.x) && (z.y == this.y)); 
	}
	
	public String toString()
	{
		return x + ", " + y; 
	}
}
