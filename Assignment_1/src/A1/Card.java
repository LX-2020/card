package A1;

public class Card
{
   public static enum Suit 
   { 
      clubs, diamonds, hearts, spades 
   };
   private Suit suit;
   private char value;
   private boolean cardError;
   
  
   Card()
   {
      this('A', Suit.spades);
   }
   
   Card(char value, Suit suit)
   {
      set(value, suit);
   }
   
   
   private boolean isValid(char value, Suit suit)
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
  
   public boolean set(char value, Suit suit)
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
   
   public Suit getSuit()
   {
      return this.suit;
   }
   

   public String toString()
   {
      String retVal;
      retVal =  String.valueOf(value);

      if (!set(value,suit))
         return "This card value " + retVal + "is invalid.";
      else 
         return retVal + " of " + suit + ",";
   }
   
  
   boolean equals(Card card)
   {
      if(this.value == card.value && this.suit == card.suit)
         return cardError = false;
      
      else return cardError = true;
      
   }
  

}
