import java.util.Scanner;

public class Foothill
{
   public static void main(String[] args)
   {
      int Urule, k;
      String strUserIn;
      
      Scanner inputStream = new Scanner(System.in);
      Automaton aut;

      // get rule from user
      do
      {
         System.out.print("Enter Rule ("  
               + Automaton.MIN_RULE + " - " +  Automaton.MAX_RULE + "): ");
 
         strUserIn = inputStream.nextLine();
         Urule = Integer.parseInt(strUserIn);

      } while (Urule < Automaton.MIN_RULE || Urule > Automaton.MAX_RULE);

      // create automaton with this rule and single central dot
      aut = new Automaton(Urule); 
      
      // display
      System.out.println("   start");
      for (k = 0; k < 100; k++)
      {
         System.out.println( aut.toStringCurrentGen() ); 
         aut.propagateNewGeneration();
   
      }
      inputStream.close();
      System.out.println("   end");
   }
}