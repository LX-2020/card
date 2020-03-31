import java.util.Random;

public class Deck
{
   private static final int MAX_PACKS = 6;
   private static final int NUM_CARDS_PER_PACK = 52;
   private static final int MAX_CARDS_PER_DECK = MAX_PACKS * NUM_CARDS_PER_PACK;
   
   private static Card[] masterPack;
   
   private static Card[] cards;
   private int numPacks;
   private int topCard;
    
   Deck()
   {
      allocateMasterPack();   
   }
   
   Deck(int numpacks)
   {
      numPacks = numpacks;
      topCard = numPacks * NUM_CARDS_PER_PACK;
      allocateMasterPack(); 
      initializePack(numPacks);
   }
   
   private static void allocateMasterPack()
   {
      int i, k, j, st=0;
      char val;
      if(masterPack != null)
         return;
      masterPack = new Card[NUM_CARDS_PER_PACK];
      
      for (i = 0; i < NUM_CARDS_PER_PACK; i++)
         masterPack[i] = new Card();
      
      for (k = 0; k < 4; k++)
      {
         switch(k)
         {
         case 0: 
            st = Card.clubs; break;
         case 1: 
            st = Card.diamonds; break;
         case 2: 
            st = Card.hearts; break;
         case 3: 
            st = Card.spades; break;  
         }
         
         masterPack[13 * k].set('A', st);
         for (val = '2', j = 1; val <= '9'; val++, j++)
            masterPack[13 * k + j].set(val, st);
         masterPack[13 * k + 9].set('T', st);
         masterPack[13 * k + 10].set('J', st);
         masterPack[13 * k + 11].set('Q', st);
         masterPack[13 * k + 12].set('K', st);
      }
            
   }
   
   public static boolean initializePack(int numPacks)
   { 
      int i, j;
      cards = new Card[numPacks * NUM_CARDS_PER_PACK];
      for (i = 0;i < numPacks;i++)
         for (j=0;j < NUM_CARDS_PER_PACK;j++)
            cards[i * NUM_CARDS_PER_PACK + j] = masterPack[j];
      
      return true;     
   }
   
   
   public void shuffle()
   {
      Random random = new Random();
      for (int i = 0; i < topCard; i++)
      {
         int randIndex = random.nextInt(topCard);
         Card temp = cards[randIndex];
         cards[randIndex] = cards[i];
         cards[i] = temp;
      }
   }
   
   
   public Card dealCard()
   {
      if(topCard > 0)
      {
         Card temp = new Card(cards[topCard - 1]);
         topCard --;
         return temp;
      }
      
      return null;      
   }
   
   
   public int topcard()
   {
      return topCard;
   }
   
   
   public Card inspectCard(int k)
   { 
      if(k >= 0 && k < (numPacks * NUM_CARDS_PER_PACK))
      { 
         Card temp = new Card(cards[numPacks * NUM_CARDS_PER_PACK - 1]);
         return temp;
      }
      else
         return new Card('S', Card.spades);     
        
   }
 }
   
   
   

