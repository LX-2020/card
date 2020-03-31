package A1;



public class Foothill     
{
   public static void main(String[] args)
   {
      //phase 1:
      Card card1, card2, card3;
      
      card1 = new Card();
      card2 = new Card('7', Card.Suit.clubs);
      card3 = new Card('9', Card.Suit.hearts);
      
      System.out.println(card1 + "\n" + card2 + "\n" + card3 + "\n--------\n");
     
      //phase 2: 
      Hand hand1 = new Hand();
      
      for(int i = 0 ; i < hand1.MAX_CARDS;)
      {
         hand1.takeCard(card1);
         i++;
         hand1.takeCard(card2);
         i++;
         hand1.takeCard(card3);
         i++;
      }
      
      hand1.inspectCard(4);
      hand1.inspectCard(53);
      
      System.out.println("\n" + hand1 + "\n");
      
      for(int i = hand1.getNum() ; i > 0; i--)
      
         hand1.playCard();
        
      if(hand1.getNum() == 0)
         
         System.out.println("Hand is empty!");
      

 
   }

}
