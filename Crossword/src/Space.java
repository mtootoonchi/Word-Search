public class Space
{
    private int length;
    private String a;
    
public Space(String a)
{
    this.a=a;
    length=a.length();
}
public void changeSpace(String a)
{
    this.a=a;
    length=a.length();
}
public int size()
{
    return length;
}
public String toString()
{
    return a;
}
}
