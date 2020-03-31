
public class Foothill
{
   public static void main(String[] args)
   {
      int k;
      
     /* Card first = new Card('A', Card.Suit.spades);
      Card second = new Card('4', Card.Suit.hearts);
      Card third = new Card('T', Card.Suit.clubs);
      
      System.out.println( "should all be 0:\n"); 
      System.out.println( first.compareTo( first ) );
      System.out.println( second.compareTo( second ) );
      System.out.println( third.compareTo( third ) );
      
      System.out.println( "\nshould all be < 0:\n"); 
      System.out.println( second.compareTo( first ) );
      System.out.println( second.compareTo( third ) );
      System.out.println( third.compareTo( first ) );
      
      System.out.println( "\nshould all be > 0:\n"); 
      System.out.println( first.compareTo( second ) );
      System.out.println( third.compareTo( second ) );
      System.out.println( first.compareTo( third ) );
      
      System.out.println( "\nSome random cards:\n");
      for ( k = 0; k < 50; k++ )
      {
         System.out.print( generateRandomCard().toString() + "  ");
      }
      System.out.println();*/
      
      //cardlist
      LinkedList<Card> myList = new LinkedList<Card>();
      
      // build list of 10 cards, 2 at a time 
      for (k = 0; k < 5; k++)
      {
         Card ncard = new Card(generateRandomCard());
         insertCard(myList,ncard);
         insertCard(myList,ncard);
        
      }      
      System.out.println(myList.toString());

      Node dn1 = myList.getCurrent();
      Card dcard1 = (Card) dn1.getData();      
      //remove same nodes one by one     
      while(removeCard(myList,dcard1))
         removeCard(myList,dcard1);
      
      System.out.println("\n" + dcard1 + " removed");         
      System.out.println("\n" + myList.toString());
      
      
      Node dn2 = myList.getCurrent();
      Card dcard2 = (Card) dn2.getData();
      //remove same cards all at once
      removeAll(myList,dcard2);
      
      System.out.println("\n" + dcard2 + " removed");         
      System.out.println("\n" + myList.toString());
      
      Card card = new Card('A',Card.Suit.clubs);
      if(removeAll(myList,card))
         System.out.println("\n" + card + " removed"); 
      else System.out.println("\n" + card +" was not in the list"); 
      
   }

   static void insertCard(LinkedList<Card> my_List, Card card)
   {  
      Node np,fp;
              
      for (my_List.resetCurrent(); (np = my_List.getCurrent()) != null; 
            my_List.iterate() )
      {
         if (np.next == null)
            break;
            
         fp = np.next;
         if(card.compareTo((Card) fp.getData()) <= 0)
            break;   
      }
      np.insertAfter(card);      
   }
      
   static boolean removeCard(LinkedList<Card> my_List, Card card) 
   {      
      Node np,fp;
                 
      for(my_List.resetCurrent(); (np = my_List.getCurrent())!= null;
            my_List.iterate() )
      {
         if(np.next == null)
            return false;
            
         fp = np.next;
         if(card.compareTo((Card) fp.getData()) == 0)
         {
            np.removeAfter();
            return true;
         }            
       }
      return false;
   }
         
   static Card generateRandomCard()
   {
      // if firstTime = true, use clock to seed, else fixed seed for debugging
      Card.Suit suit;
      char val;

      int suitSelector, valSelector;

      // get random suit and value
      suitSelector = (int) (Math.random() * 4);
      valSelector = (int) (Math.random() * 13);

      // pick suit
      suit = Card.Suit.values()[suitSelector];
      val = turnIntIntoVal(valSelector);

      return new Card(val, suit);
   }
  
   static char turnIntIntoVal(int k)
   {
      String legalVals = "23456789TJQKA";
      
      if (k < 0 | k >= legalVals.length())
         return '?';
      return legalVals.charAt(k);
   }
      
   static boolean removeAll(LinkedList<Card> my_List, Card card)
   {
      Node np,fp;
      
      for(my_List.resetCurrent(); (np = my_List.getCurrent())!= null;  )
      {
            if(np.next == null)
               return false;
         
            fp = np.next;
            if(card.compareTo((Card) fp.getData()) == 0)
            {
               np.removeAfter();           
            }
            else
               my_List.iterate();
         }      
      return false;     
   }
}

 
