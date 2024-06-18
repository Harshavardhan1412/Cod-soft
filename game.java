import java.util.*;
public class NewMain{
    public int game()
    {
        Random random=new Random();
        int x=random.nextInt(100);
        return x;
    }
    public static void main(String[] args) {
        int count=0,q=0,c1=0;
        Scanner sc=new Scanner(System.in);
        NewMain n=new NewMain();
        while(true)
        {
            System.out.println("your" +q+ " game has started");
            q++;
            System.out.println("You have 3 chances to guess the number");
            int z=n.game();
            for(int i=0;i<3;i++)
            {
            System.out.println("guess the number");
            int y=sc.nextInt();
            if(z==y)
            {
                System.out.println("Correct Guess");
                count++;
            }
            else if(z>y)
            {
                System.out.println("too low!!");
            }
            else
            {
                System.out.println("too high!!");
            }
            }
            System.out.println("Your score is"+count);
            System.out.println("The Magical number is!!"+z);
            System.out.println("do you want to continue or not(1/0)");
            int c=sc.nextInt();
            if(c!=1)
            {
                break;
            }
            else
            {
                continue;
            }
        }
    }
}
