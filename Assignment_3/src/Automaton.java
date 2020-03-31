
public class Automaton
{  
   // class constants
   public final static int RULES_SIZE = 8;
   public final static int BITS_IN_RULE_SIZE 
      = (int)(Math.log(RULES_SIZE) / Math.log(2));
   public final static int MIN_DISPLAY_WIDTH = 21;
   public final static int MAX_DISPLAY_WIDTH = 111;
   public final static int DFLT_DISPLAY_WIDTH = 79;
   public final static int MIN_RULE = 0;
   public final static int MAX_RULE = (int)Math.pow(2,RULES_SIZE) - 1;
   public final static int DFLT_RULE = 1;
   public final static String ON_STR = "*";
   public final static String OFF_STR = " ";
   
   // private members
   private boolean rule[];   
   private String thisGen;   
   String extremeBit; 
   int displayWidth;  
   
   
   Automaton(int newRule)
   {
      thisGen = new String(ON_STR); 
      extremeBit = new String(OFF_STR);
      setDisplayWidth(DFLT_DISPLAY_WIDTH);
      setRule(newRule);
      
   }
   
   public void resetFirstGen()
   {
      thisGen = ON_STR;
      extremeBit = OFF_STR; 
   }
   
   public boolean[] setRule(int newRule)
   {
      rule = new boolean[RULES_SIZE];
      if(newRule > MIN_RULE && newRule < MAX_RULE)
      {
         for(int i = 0; i < RULES_SIZE; i++)
         {
            int index = (int)Math.pow(2, i);
            if((newRule & index) != 0 )
            {  
               rule[i] = true;
            }
            else rule[i] = false; 
         }      
      }      
      return rule;
   }
   
   public boolean setDisplayWidth(int width)
   {
      if(width % 2 != 0 && width >= MIN_DISPLAY_WIDTH 
            && width <= MAX_DISPLAY_WIDTH)
      {
         displayWidth = width;
         return true;
      }
      return false;
   }
   
   public String toStringCurrentGen()
   {
 
     String currentGen = " ";
      if(thisGen.length() < displayWidth)
      {
         currentGen = extremeBit.repeat((displayWidth - thisGen.length())/2)
             + thisGen + extremeBit.repeat((displayWidth - thisGen.length())/2);
      }
      return currentGen;
   }
   
   public void propagateNewGeneration()
   {
      String nextGen = " ";     
      thisGen = extremeBit.repeat(2) + thisGen + extremeBit.repeat(2);      
      thisGen = thisGen.replace('*','1');
      thisGen = thisGen.replace(' ','0');
           
      int endIndex = 0;
      for(int i = 0; i < thisGen.length()-2; i++)
      {  
         int pth = 0;
         String subString = thisGen.substring(i, endIndex+3);
         
         for(int j = 0; j < BITS_IN_RULE_SIZE;j++)
         {
            
            if(subString.charAt(j) == '1')
              pth += Math.pow(2, 2-j);            
         }
         endIndex++;
         //apply rule
         if(rule[pth] == true)
           nextGen += ON_STR;
         
         else nextGen += OFF_STR;
      }
      
      thisGen = nextGen;
      
      //test extremebit
      String extremebit = extremeBit.repeat(3);
      extremebit = extremebit.replace('*','1');
      extremebit = extremebit.replace(' ','0');
      
      if(extremebit == "111")
      {
         if(rule[7] = true)
            extremeBit = OFF_STR;
               
      }
      
      if(extremebit == "000")
      {
         if(rule[0] = true)
            extremeBit = OFF_STR;
                     
      } 
   }
}
