import javax.swing.*;

public class GUICard
{
   private static Icon[][] iconCards = new ImageIcon[14][4]; 
   private static Icon iconBack;
   private static boolean iconsLoaded = false;
   private static String cardlValsConvertAssist = "23456789TJQKAX";
   private static String suitValsConvertAssist  = "CDHS";
  /* private static Card.Suit suitConvertAssist[] =
   {
      Card.Suit.clubs,
      Card.Suit.diamonds,
      Card.Suit.hearts,
      Card.Suit.spades
   };*/
                                                                                 
   static void loadCardIcons()
   {
      if(iconsLoaded == false)
      {
         String imageFileName;
         int intSuit, intVal;

         for (intSuit = 0; intSuit < 4; intSuit++ )
         {
            for (intVal = 0; intVal < 14; intVal++ )
            {
               imageFileName = "images/" + turnIntIntoCardValueChar(intVal) +
                     turnIntIntoCardSuitChar(intSuit) + ".gif";
               iconCards[intVal][intSuit] = new ImageIcon(imageFileName);
            }
         }        
         iconBack = new ImageIcon("images/BK.gif");
         iconsLoaded = true;    
      }
   }
   
   static char turnIntIntoCardValueChar(int k)
   {
   
      if ( k < 0 || k > 13)
         return '?'; 
      return cardlValsConvertAssist.charAt(k);
   }
   
   static char turnIntIntoCardSuitChar(int k)
   {
      if ( k < 0 || k > 3)
         return '?'; 
      return suitValsConvertAssist.charAt(k);
   }
   
   static public Icon getIcon(Card card)
   {
      loadCardIcons(); 
      return iconCards[valueAsInt(card)][suitAsInt(card)];
   }
   
   static public Icon getBackCardIcon() 
   {
      if(iconsLoaded == false)
      {
         loadCardIcons();
         return iconBack;
      }
      return iconBack;
   }
   
   //get index according to passed card value
   static public int valueAsInt(Card card)
   {
      char val = card.getValue();
      int Val = cardlValsConvertAssist.indexOf(val);
      return Val;
   }
   
   static public int suitAsInt(Card card)
   {
      return card.getSuit();
   
   }
}
