import java.util.ArrayList;
public class Solver
{
    private Space[][] crossword=null;
    private ArrayList<Words> words=null;
    private Space[][] solved=null;
    private Space[][] LeftChecked=null;
    private Space[][] RightChecked=null;
    private Space[][] UpChecked=null;
    private Space[][] DownChecked=null;
    private Space[][] LeftUpChecked=null;
    private Space[][] RightUpChecked=null;
    private Space[][] LeftDownChecked=null;
    private Space[][] RightDownChecked=null;
    
public Solver(Space[][] crossword, ArrayList<Words> words)
{
    this.crossword=crossword;
    this.words=words;
    solved=new Space[crossword.length][crossword[0].length];
    LeftChecked=new Space[crossword.length][crossword[0].length];
    RightChecked=new Space[crossword.length][crossword[0].length];
    UpChecked=new Space[crossword.length][crossword[0].length];
    DownChecked=new Space[crossword.length][crossword[0].length];
    LeftUpChecked=new Space[crossword.length][crossword[0].length];
    RightUpChecked=new Space[crossword.length][crossword[0].length];
    LeftDownChecked=new Space[crossword.length][crossword[0].length];
    RightDownChecked=new Space[crossword.length][crossword[0].length];
    for(int i=0;i<crossword.length;i++)
    {
        for(int j=0;j<crossword[i].length;j++)
        {
            solved[i][j]=new Space("-");
            LeftChecked[i][j]=new Space("-");
            RightChecked[i][j]=new Space("-");
            UpChecked[i][j]=new Space("-");
            DownChecked[i][j]=new Space("-");
            LeftUpChecked[i][j]=new Space("-");
            RightUpChecked[i][j]=new Space("-");
            LeftDownChecked[i][j]=new Space("-");
            RightDownChecked[i][j]=new Space("-");
        }
    }
}
public void Solve()
{
    for(int i=0;i<words.size();i++)
    {
        for(int j=0;j<crossword.length;j++)
        {
            for(int k=0;k<crossword[j].length;k++)
            {
                Check(j,k,words.get(i));
            }
        }
    }
}
private void Check(int a, int b, Words c)
{
	if(crossword[a][b].toString().equals(c.toString().substring(0,crossword[a][b].size())))
	{
		LeftChecked[a][b]=new Space(c.toString().substring(0,crossword[a][b].size()));
		RightChecked[a][b]=new Space(c.toString().substring(0,crossword[a][b].size()));
		UpChecked[a][b]=new Space(c.toString().substring(0,crossword[a][b].size()));
		DownChecked[a][b]=new Space(c.toString().substring(0,crossword[a][b].size()));
		LeftUpChecked[a][b]=new Space(c.toString().substring(0,crossword[a][b].size()));
		RightUpChecked[a][b]=new Space(c.toString().substring(0,crossword[a][b].size()));
		LeftDownChecked[a][b]=new Space(c.toString().substring(0,crossword[a][b].size()));
		RightDownChecked[a][b]=new Space(c.toString().substring(0,crossword[a][b].size()));
		LeftCheck(a,b-1, c, crossword[a][b].size());
		RightCheck(a,b+1,c,crossword[a][b].size());
		UpCheck(a+1,b,c,crossword[a][b].size());
		DownCheck(a-1,b,c,crossword[a][b].size());
		LeftUpCheck(a-1,b+1,c,crossword[a][b].size());
		RightUpCheck(a+1,b+1,c,crossword[a][b].size());
		LeftDownCheck(a-1,b-1,c,crossword[a][b].size());
		RightDownCheck(a+1,b-1,c,crossword[a][b].size());
	}
	
}
private void LeftCheck(int a, int b, Words c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].toString().equals("-"))
	        	{
	        		solved[i][j]=new Space(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new Space("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].toString().equals(c.toString().substring(d,d+crossword[a][b].size())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new Space("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new Space(c.toString().substring(d,d+crossword[a][b].size()));
		LeftCheck(a,b-1, c, d+crossword[a][b].size());
	}
}
private void RightCheck(int a, int b, Words c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].toString().equals("-"))
	        	{
	        		solved[i][j]=new Space(RightChecked[i][j].toString());
	        	}
	            RightChecked[i][j]=new Space("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].toString().equals(c.toString().substring(d,d+crossword[a][b].size())))
	{
		for(int i=0;i<RightChecked.length;i++)
	    {
	        for(int j=0;j<RightChecked[i].length;j++)
	        {
	            RightChecked[i][j]=new Space("-");
	        }
	    }
	}
	else
	{
		RightChecked[a][b]=new Space(c.toString().substring(d,d+crossword[a][b].size()));
		RightCheck(a,b+1, c, d+crossword[a][b].size());
	}
}
private void UpCheck(int a, int b, Words c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].toString().equals("-"))
	        	{
	        		solved[i][j]=new Space(UpChecked[i][j].toString());
	        	}
	            UpChecked[i][j]=new Space("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].toString().equals(c.toString().substring(d,d+crossword[a][b].size())))
	{
		for(int i=0;i<UpChecked.length;i++)
	    {
	        for(int j=0;j<UpChecked[i].length;j++)
	        {
	            UpChecked[i][j]=new Space("-");
	        }
	    }
	}
	else
	{
		UpChecked[a][b]=new Space(c.toString().substring(d,d+crossword[a][b].size()));
		UpCheck(a+1,b, c, d+crossword[a][b].size());
	}
}
private void DownCheck(int a, int b, Words c, int d)

{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].toString().equals("-"))
	        	{
	        		solved[i][j]=new Space(DownChecked[i][j].toString());
	        	}
	            DownChecked[i][j]=new Space("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].toString().equals(c.toString().substring(d,d+crossword[a][b].size())))
	{
		for(int i=0;i<DownChecked.length;i++)
	    {
	        for(int j=0;j<DownChecked[i].length;j++)
	        {
	            DownChecked[i][j]=new Space("-");
	        }
	    }
	}
	else
	{
		DownChecked[a][b]=new Space(c.toString().substring(d,d+crossword[a][b].size()));
		DownCheck(a-1,b, c, d+crossword[a][b].size());
	}
}
private void LeftUpCheck(int a, int b, Words c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].toString().equals("-"))
	        	{
	        		solved[i][j]=new Space(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new Space("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].toString().equals(c.toString().substring(d,d+crossword[a][b].size())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new Space("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new Space(c.toString().substring(d,d+crossword[a][b].size()));
		LeftCheck(a-1,b+1, c, d+crossword[a][b].size());
	}
}
private void RightUpCheck(int a, int b, Words c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].toString().equals("-"))
	        	{
	        		solved[i][j]=new Space(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new Space("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].toString().equals(c.toString().substring(d,d+crossword[a][b].size())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new Space("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new Space(c.toString().substring(d,d+crossword[a][b].size()));
		LeftCheck(a+1,b+1, c, d+crossword[a][b].size());
	}
}
private void LeftDownCheck(int a, int b, Words c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].toString().equals("-"))
	        	{
	        		solved[i][j]=new Space(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new Space("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].toString().equals(c.toString().substring(d,d+crossword[a][b].size())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new Space("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new Space(c.toString().substring(d,d+crossword[a][b].size()));
		LeftCheck(a-1,b-1, c, d+crossword[a][b].size());
	}
}
private void RightDownCheck(int a, int b, Words c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].toString().equals("-"))
	        	{
	        		solved[i][j]=new Space(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new Space("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].toString().equals(c.toString().substring(d,d+crossword[a][b].size())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new Space("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new Space(c.toString().substring(d,d+crossword[a][b].size()));
		LeftCheck(a+1,b-1, c, d+crossword[a][b].size());
	}
}
public void solved()
{
    for(int i=0;i<solved.length;i++)
    {
        Tools.prt("|");
        for(int j=0;j<solved[i].length;j++)
        {
            Tools.prt(""+solved[i][j]);
        }
        Tools.prtln("|");
    }
}
public String toString()
{
    return "";
}
}
