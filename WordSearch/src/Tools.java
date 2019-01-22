import java.util.Scanner;
public class Tools
{
    private static Scanner scan=new Scanner(System.in);
    
public Tools()
{
   
}
public static void prt(String prt)
{
    System.out.print(prt);
}
public static void prt(int prt)
{
    System.out.print(prt);
}
public static void prt(double prt)
{
    System.out.print(prt);
}
public static void prt(boolean prt)
{
    System.out.print(prt);
}
public static void prt()
{
    System.out.print("");
}
public static void prtln(String prt)
{
    System.out.println(prt);
}
public static void prtln(int prt)
{
    System.out.println(prt);
}
public static void prtln(double prt)
{
    System.out.println(prt);
}
public static void prtln(boolean prt)
{
    System.out.println(prt);
}
public static void prtln()
{
    System.out.println();
}
public static int askInt(String str)
{
    scan.reset();
    prtln(str);
    prt("Choice: ");
    return scan.nextInt();
}
public static double askDouble(String str)
{
    scan.reset();
    prtln(str);
    prt("Choice: ");
    return scan.nextDouble();
}
public static String askString(String str)
{
    scan.reset();
    prtln(str);
    prt("Choice: ");
    return scan.next();
}
public static boolean askBoolean(String str)
{
    scan.reset();
    prtln(str);
    prt("Choice: ");
    return isTrue(scan.next());
}
public static boolean isTrue(String command)
{
    if(command.equalsIgnoreCase("True")||command.equalsIgnoreCase("Yes")||command.equalsIgnoreCase("Y")||command.equalsIgnoreCase("Stop"))
    return true;
    else if(command.equalsIgnoreCase("False")||command.equalsIgnoreCase("No")||command.equalsIgnoreCase("N")||command.equalsIgnoreCase("Go"))
    return false;
    else
    return false;
}
public String toString()
{
    return null;
}
}


