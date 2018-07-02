import java.util.*;
import java.io.IOException;


class Pattern
{
    int[] balls = new int[5];
    int sum=0;
    boolean onlyone=true;
    SystemChance sc =new SystemChance();
    void prin()
    {
           if(onlyone)
           {
               Random r= new Random();

               for(int i=0;i<5;i++)
               {
                   balls[i] = Math.abs(r.nextInt() % 7);
                   sum+=balls[i];
               }
               onlyone=false;
           }


            for(int i=0;i<5;i++)
            {
                System.out.printf("   || %d ||",balls[i]);
            }
            System.out.printf("\n");
            for(int i=0;i<5;i++)
            {
                System.out.printf("   ||___||");
            }
            System.out.printf("\n\n");


    }

}

class SystemChance
{
    int ans=0;
    int dif=0;
    int po;
    int i;
    int box;
    boolean fla , flag ;

    Random r= new Random();
    void paly(Pattern a)
    {
        ans=0;
        for( i=0;i<5;i++)
        {
            ans = ans ^ a.balls[i];

        }

        for( i=0;i<5;i++)
        {
            if((ans^a.balls[i])<a.balls[i])
            {
                dif=a.balls[i]-(ans^a.balls[i]);
                po=i+1;
                a.balls[i]-=dif;
		        a.sum-=dif;
                a.prin();
                System.out.printf("\nSYSTEM CHOSEN BOX = %d\n",po);
                System.out.printf("AND TOOK FRUIT = %d\n\n",dif);
                break;
            }
        }
        //////////////////////////////////////////////////////////////////////////
        if(i==5)
        {
            do
            {
                box=Math.abs(r.nextInt()) % 5;
                if(a.balls[box]==0)
                    fla=true;

                else
                    fla=false;
            }while(fla);

                do
                {
                    dif=Math.abs(r.nextInt()%(a.balls[box]+1));
                    if(dif==0)
                        flag=true;
                    else
                        flag=false;
                }while(flag);

                // box=i;
                a.balls[box]-=dif;
		        a.sum-=dif;
                a.prin();
                System.out.printf("SYSTEM CHOSES BOX = %d\n",box+1);
                System.out.printf("AND TOOK FRUIT = %d\n\n",dif);
                //break;

        }
    }
}


public class Start {
    public static void main(String[] args) throws IOException{
        System.out.println("\n\nTHERE ARE 5 BOX WHICH ARE CONTAINING SOME BOLLS ");
        System.out.println("RULES OF THIS GAME :\n");
        System.out.println("\t1:=> TWO PEOPLE PLAY 1) - SYSTEM  2) - YOU :");
        System.out.println("\t2:=>EACH PLAYER CAN PICK UP AS MANY BALLS AS HE LIKES BUT ONLY FROM THE ONE BUCCKET EACH TIME :");
        System.out.println("\t3:=>THE PLAYER WHO PICKES UP THE LAST BALL IS THE WINNER\n\n");


        Pattern draw= new Pattern();
        SystemChance sychance = new SystemChance();
        draw.prin();

        System.out.println("LETES START");
        System.out.println("CHOUSE YOUR CHANCE");
        System.out.println("\t 1) 1st CHANCE");
        System.out.println("\t 2) 2nd CHANCE");

        Scanner sc= new Scanner(System.in);
        int chance = sc.nextInt();
        int position , ball;
        boolean flag = false;

        while(draw.sum!=0)
        {
            if(chance%2==1)
            {
                //Runtime.getRuntime().exec("clear");
                do
                {
                    System.out.println("______________________________________________________________");
                    System.out.printf("YOUR CHANCE : \n\n");
                    System.out.printf("CHOSE A BUCCKET : ");
                    position=sc.nextInt();
                    System.out.printf("CHOSE NO OF BALLS : ");
                    ball=sc.nextInt();

                    if(position >5 || position < 0 || ball==0 || ball> draw.balls[position-1] )
                    {
                        flag=true;
                        System.out.println("\nERROR: PLAY AGAIN\n");
                    }
                    else
                    {
                       flag=false;
                        draw.balls[position-1]-=ball;
                        draw.sum-=ball;
                        draw.prin();
                    }
                }while(flag);
            }
            else
            {
                System.out.println("______________________________________________________________");
                System.out.printf("SYSTEMS CHANCE : \n\n");
                for (int c = 1; c <= 32767; c++)
                    for (int d = 1; d <= 32767; d++)
                    {}

                    sychance.paly(draw);

            }
            chance++;
            if(draw.sum==0)
            {
                if(chance%2==0)
                    System.out.printf("\n\n*****YOU WON THE GAME*****\n\n");
                else
                    System.out.printf("\n\n*****YOU LOSE THE GAME*****\n\n");
            }
        }

    }
}
