
public class Card
{
      public final static int clubs = 0, 
                              diamonds = 1,
                              hearts = 2,
                              spades = 3;
      
      private int suit;
      private char value;
      private boolean cardError;
      
     
      Card()
      {
         this('A', clubs);
      }
      
      Card(char value, int suit)
      {
         set(value, suit);
      }
      
      Card(Card card)
      {
         this.value = card.value;
         this.suit = card.suit;
      }
      
      private boolean isValid(char value, int suit)
      {
         char upVal;  
         upVal = Character.toUpperCase(value);
         
         if(upVal == 'A' || upVal == 'K'
            || upVal == 'Q' || upVal == 'J'
            || upVal == 'T'
            || (upVal >= '2' && upVal <= '9'))
            
            return true;
         
         else 
            return false;
            
      }
     
      public boolean set(char value, int suit)
      {
         
         if ( isValid(value,suit) )
         { 
            this.value = Character.toUpperCase(value);
            this.suit = suit;
            this.cardError = false;
         }
         else
            this.cardError = true;
           
         return !cardError;     
       
      }
      

      public char getValue()
      {
         return this.value;
      }
      
      public int getSuit()
      {
         return this.suit;
      }
      
      public String sSuit()
      {
         switch(suit)
         {
         case 0: 
            return "Clubs"; 
         case 1: 
            return "Diamonds";
         case 2: 
            return "Hearts";
         case 3: 
            return "Spades";
         default: 
            return "??";
         }
      }
      public String toString()
      {
         String retVal;
         retVal =  String.valueOf(value);
         
         if (!set(value,suit))
            return "This card value " + retVal + "is invalid.";
         else 
            return " " + retVal + " of " + sSuit() + " / ";
      }
      
     
      boolean equals(Card card)
      {
         if(this.value == card.value && this.suit == card.suit)
            return cardError = false;
         
         else return cardError = true;
         
      }  
}
