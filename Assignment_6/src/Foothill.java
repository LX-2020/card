
public class Foothill
{
   public static void main(String[] args)
   {
      CardQueue cq = new CardQueue();
      Card card1, card2, card3, card4;
      card1 = new Card('j',2);
      card2 = new Card('a', 5);
      card3 = new Card('2', 1);
      card4 = new Card('k', 3);

      cq.addCard(card1);      
      cq.addCard(card2);
      cq.addCard(card3);
      cq.addCard(card4);      
      System.out.print("The Card queue: " + "\n" + cq + "\n");
      
      for (int k = 0; k < 5; k++)
         try
         {
            Card temp = cq.removeCard();
            System.out.print("\n#" + k + "card\n" + temp);    
         } 
         catch (QueueEmptyException e)
         {
            System.out.print("\n(empty queue) ");
         }
       System.out.println();
   
   
      
   }
}
