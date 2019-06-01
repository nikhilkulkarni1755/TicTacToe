package ttt;

public class Element 
{
	int XorO; //if 0, the thing is empty, if 1, then X, if 2, then O. 
	
	Element(int x)
	{
		XorO = x; 
	}
	
	public boolean isEqual(Element e)
	{
		return (e.XorO == this.XorO); 
	}
	
	public String toString()
	{
		if(XorO == 0)
		{
			return "- "; 
		}
		else if(XorO == 1)
		{
			return "X "; 
		}
		else
		{
			return "O ";
		}
	}
}
