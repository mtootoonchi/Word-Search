import java.util.ArrayList;
public class Solver
{
    private String[][] crossword=null;
    private ArrayList<String> words=null;
    private String[][] solved=null;
    private String[][] LeftChecked=null;
    private String[][] RightChecked=null;
    private String[][] UpChecked=null;
    private String[][] DownChecked=null;
    private String[][] LeftUpChecked=null;
    private String[][] RightUpChecked=null;
    private String[][] LeftDownChecked=null;
    private String[][] RightDownChecked=null;
    
public Solver(String[][] crossword, ArrayList<String> words)
{
    this.crossword=crossword;
    this.words=words;
    solved=new String[crossword.length][crossword[0].length];
    LeftChecked=new String[crossword.length][crossword[0].length];
    RightChecked=new String[crossword.length][crossword[0].length];
    UpChecked=new String[crossword.length][crossword[0].length];
    DownChecked=new String[crossword.length][crossword[0].length];
    LeftUpChecked=new String[crossword.length][crossword[0].length];
    RightUpChecked=new String[crossword.length][crossword[0].length];
    LeftDownChecked=new String[crossword.length][crossword[0].length];
    RightDownChecked=new String[crossword.length][crossword[0].length];
    for(int i=0;i<crossword.length;i++)
    {
        for(int j=0;j<crossword[i].length;j++)
        {
            solved[i][j]="-";
            LeftChecked[i][j]="-";
            RightChecked[i][j]="-";
            UpChecked[i][j]="-";
            DownChecked[i][j]="-";
            LeftUpChecked[i][j]="-";
            RightUpChecked[i][j]="-";
            LeftDownChecked[i][j]="-";
            RightDownChecked[i][j]="-";
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
private void Check(int a, int b, String c)
{
	if(crossword[a][b].equals(c.substring(0,crossword[a][b].length())))
	{
		LeftChecked[a][b]=new String(c.substring(0,crossword[a][b].length()));
		RightChecked[a][b]=new String(c.substring(0,crossword[a][b].length()));
		UpChecked[a][b]=new String(c.substring(0,crossword[a][b].length()));
		DownChecked[a][b]=new String(c.substring(0,crossword[a][b].length()));
		LeftUpChecked[a][b]=new String(c.substring(0,crossword[a][b].length()));
		RightUpChecked[a][b]=new String(c.substring(0,crossword[a][b].length()));
		LeftDownChecked[a][b]=new String(c.substring(0,crossword[a][b].length()));
		RightDownChecked[a][b]=new String(c.substring(0,crossword[a][b].length()));
		LeftCheck(a,b-1, c, crossword[a][b].length());
		RightCheck(a,b+1,c,crossword[a][b].length());
		UpCheck(a+1,b,c,crossword[a][b].length());
		DownCheck(a-1,b,c,crossword[a][b].length());
		LeftUpCheck(a-1,b+1,c,crossword[a][b].length());
		RightUpCheck(a+1,b+1,c,crossword[a][b].length());
		LeftDownCheck(a-1,b-1,c,crossword[a][b].length());
		RightDownCheck(a+1,b-1,c,crossword[a][b].length());
	}
	
}
private void LeftCheck(int a, int b, String c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].equals("-"))
	        	{
	        		solved[i][j]=new String(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].equals(c.substring(d,d+crossword[a][b].length())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new String(c.substring(d,d+crossword[a][b].length()));
		LeftCheck(a,b-1, c, d+crossword[a][b].length());
	}
}
private void RightCheck(int a, int b, String c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].equals("-"))
	        	{
	        		solved[i][j]=new String(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].equals(c.substring(d,d+crossword[a][b].length())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new String(c.substring(d,d+crossword[a][b].length()));
		LeftCheck(a,b+1, c, d+crossword[a][b].length());
	}
}
private void UpCheck(int a, int b, String c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].equals("-"))
	        	{
	        		solved[i][j]=new String(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].equals(c.substring(d,d+crossword[a][b].length())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new String(c.substring(d,d+crossword[a][b].length()));
		LeftCheck(a+1,b, c, d+crossword[a][b].length());
	}
}
private void DownCheck(int a, int b, String c, int d)

{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].equals("-"))
	        	{
	        		solved[i][j]=new String(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].equals(c.substring(d,d+crossword[a][b].length())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new String(c.substring(d,d+crossword[a][b].length()));
		LeftCheck(a-1,b, c, d+crossword[a][b].length());
	}
}
private void LeftUpCheck(int a, int b, String c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].equals("-"))
	        	{
	        		solved[i][j]=new String(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].equals(c.substring(d,d+crossword[a][b].length())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new String(c.substring(d,d+crossword[a][b].length()));
		LeftCheck(a-1,b+1, c, d+crossword[a][b].length());
	}
}
private void RightUpCheck(int a, int b, String c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].equals("-"))
	        	{
	        		solved[i][j]=new String(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].equals(c.substring(d,d+crossword[a][b].length())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new String(c.substring(d,d+crossword[a][b].length()));
		LeftCheck(a+1,b+1, c, d+crossword[a][b].length());
	}
}
private void LeftDownCheck(int a, int b, String c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].equals("-"))
	        	{
	        		solved[i][j]=new String(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].equals(c.substring(d,d+crossword[a][b].length())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new String(c.substring(d,d+crossword[a][b].length()));
		LeftCheck(a-1,b-1, c, d+crossword[a][b].length());
	}
}
private void RightDownCheck(int a, int b, String c, int d)
{
	if(c.length()<=d)
	{
		for(int i=0;i<solved.length;i++)
	    {
	        for(int j=0;j<solved[i].length;j++)
	        {
	        	if(solved[i][j].equals("-"))
	        	{
	        		solved[i][j]=new String(LeftChecked[i][j].toString());
	        	}
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else if(a<0||b<0||a>crossword.length-1||b>crossword[a].length-1||!crossword[a][b].equals(c.substring(d,d+crossword[a][b].length())))
	{
		for(int i=0;i<LeftChecked.length;i++)
	    {
	        for(int j=0;j<LeftChecked[i].length;j++)
	        {
	            LeftChecked[i][j]=new String("-");
	        }
	    }
	}
	else
	{
		LeftChecked[a][b]=new String(c.substring(d,d+crossword[a][b].length()));
		LeftCheck(a+1,b-1, c, d+crossword[a][b].length());
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
