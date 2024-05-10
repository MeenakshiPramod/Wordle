// Wordle (In the Terminal)
// Java
// Topics: Scanner, substring, loops, ANSI color codes


import java.util.Scanner;


public class Wordle 
{
    public static void main(String st[])
    {
        final String BG_GREEN = "\u001b[42m";
        final String BG_YELLOW = "\u001b[43m";
        final String RESET = "\u001b[0m";
        final String TXT_RED="\u001b[31m";
        final String TXT_GREEN="\u001b[32m";
        final String TXT_BLUE="\u001b[34m";
        System.out.println("WORDLE!");
        
        String[] words={"ARRAY","DEBUG","SCRIPT","CLASS","FLOAT","ERROR","INDEX","QUEUE"};
        
        int wIndex=(int)(Math.random()*words.length);
        String correct=words[wIndex];
        String guess="";
       
        Scanner sc=new Scanner(System.in);
        
        for(int round=0;round<6;round++)
        {
            System.out.print("Please guess:");
            guess=sc.nextLine().toUpperCase();

            //Create a loop to iterate through each letter
            for(int i=0;i<5;i++)
            {
                if(guess.substring(i,i+1).equals(correct.substring(i,i+1)))
                {
                    //Letter matches
                    System.out.print(BG_GREEN+guess.substring(i,i+1)+RESET);
                }
                else if(correct.indexOf(guess.substring(i, i+1))>-1)
                {
                    //Letter is in word, but different location
                    System.out.print(BG_YELLOW+guess.substring(i,i+1)+RESET);
                }
                else
                {
                    //Letter not in word
                    System.out.print(guess.substring(i, i+1));
                }
            }
            System.out.println("");

            //If the guess is correct
            if(guess.equals(correct))
            {
                System.out.println(TXT_GREEN+"Correct! You win!"+RESET);
                break;
            }
        }

        //Print correct answer if player loses
        if(!guess.equals(correct))
        {
          System.out.println(TXT_RED+"You lose! No more guesses."+RESET);
          System.out.println(TXT_BLUE+"The correct word is "+correct+"."+RESET);
          return;
        }

        System.out.println(BG_GREEN+"GAME OVER!!"+RESET);
    }

    
}
