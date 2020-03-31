

public class Card
{
   public static enum Suit 
   { 
      clubs, diamonds, hearts, spades 
   };
   private Suit suit;
   private char value;
   private boolean cardError;
   protected static char[] valueRanks = { '2', '3', '4', '5', '6', '7', '8', '9', 
         'T', 'J', 'Q', 'K', 'A'};
      protected static Suit[] suitRanks = {Suit.clubs, Suit.diamonds, Suit.hearts, 
         Suit.spades};
      protected static final int NUM_VALS = 13; 
     
   Card()
   {
      this('A', Suit.spades);
   }
   
   Card(char value, Suit suit)
   {
      set(value, suit);
   }
   
   Card(Card card)
   {
      this.value = card.value;
      this.suit = card.suit;
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
   
   // sort member methods
   public int compareTo(Card other)
   {
      if (this.value == other.value)
         return ( getSuitRank(this.suit) - getSuitRank(other.suit) );

      return ( 
            getValueRank(this.value) 
            - getValueRank(other.value) 
            );
   }

   public static int getSuitRank(Suit st)
   {
      int k;
      for (k = 0; k < 4; k++) 
         if (suitRanks[k] == st)
            return k;
      
      // should not happen
      return 0;
   }

   public  static int getValueRank(char val)
   {
      int k;
      for (k = 0; k < NUM_VALS; k++) 
         if (valueRanks[k] == val)
            return k;

      // should not happen
      return 0;
   }
}





