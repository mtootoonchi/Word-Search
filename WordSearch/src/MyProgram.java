import java.util.Scanner;
import java.util.ArrayList;
public class MyProgram
{
    @SuppressWarnings("resource")
	public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        Tools.prtln("Rules of the Crossword.");
        Tools.prtln("Capital letters are letters with accent marks.");
        Tools.prtln();
        String[][] crossword=null;
        ArrayList<String> words=null;
        String choice="null";
        String word="";
        while(true)
        {
            crossword=null;
            choice="null";
            words=null;
            Tools.prtln("What do you want to do?");
            Tools.prtln("Type \"1\" for Crossword Maker.");
            Tools.prtln("Type \"2\" for Crossword Solver.");
            Tools.prtln("Type \"stop\" to stop.");
            Tools.prtln();
            Tools.prt("Choice: ");
            choice=scan.next();
            scan.reset();
            Tools.prtln();
            if(choice.equals("1")) // Crossword Maker
            {
                crossword=new String[Tools.askInt("How many rows do you want in your crossword?")][Tools.askInt("How many columns do you want in your crossword?")];
                words=new ArrayList<>();
                for(int i=1;i!=0;i++)
                {
                    word="";
                    word=Tools.askString("What do you want your "+i+" word to be?\nEnter 0 to stop.");
                    if(word.equals("0"))
                    {
                        i=-1;
                    }
                    else
                    {
                        words.add(new String(word));
                    }
                    Tools.prtln();
                }
                
            }
            else if(choice.equals("2")) // Crossword Solver
            {
                crossword=new String[Tools.askInt("How many rows are in your crossword?")][Tools.askInt("How many columns are in your crossword?")];
                words=new ArrayList<>();
                for(int i=0;i<crossword.length;i++)
                {
                    for(int j=0;j<crossword[i].length;j++)
                    {
                        crossword[i][j]=new String(Tools.askString("What is your space for row "+(i+1)+" column "+(j+1)+" in your crossword?"));
                    }
                }
                for(int i=1;i!=0;i++)
                {
                    word="";
                    word=Tools.askString("What is your "+i+" word?\nEnter \"0\" to stop.");
                    if(word.equals("0"))
                    {
                        i=-1;
                    }
                    else
                    {
                        words.add(new String(word));
                    }
                    Tools.prtln();
                }
                Solver solved=new Solver(crossword, words);
                solved.Solve();
                solved.solved();
            }
            else
            {
                Tools.prtln("You had stopped the program.");
                break;
            }
            Tools.prtln();
        }
    }
}
