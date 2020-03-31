import javax.swing.*;

public class Foothill 
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
   
   public static void main(String[] args)
   {
      int k;
      Icon tempIcon;

      CardTable myCardTable 
         = new CardTable("CS 1B CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // CREATE LABELS ---------------------------------------------------- 
      //get random cards from Deck class
      Deck deck = new Deck(1);
      deck.shuffle();
      for(k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
         computerLabels[k] = new JLabel(GUICard.getBackCardIcon());
      }      
      for(k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
         //get random cards
         Card card = deck.dealCard();
         tempIcon = GUICard.getIcon(card);
         humanLabels[k] = new JLabel(tempIcon);
      }      
      
      // ADD LABELS TO PANELS -----------------------------------------       
      for(k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
         myCardTable.ComputerHand.add(computerLabels[k]);
      }      
      for(k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
         myCardTable.YourHand.add(humanLabels[k]);
      }
            
      //two random cards in the play region (simulating a computer/hum ply)
      for(k = 0; k < NUM_PLAYERS; k++)
      {
         Card card = deck.dealCard();         
         tempIcon = GUICard.getIcon(card);
         playedCardLabels[k] = new JLabel(tempIcon);
      }
      //create and add text for played card
      playLabelText[0] = new JLabel("Computer",JLabel.CENTER);
      playLabelText[1] = new JLabel("You",JLabel.CENTER);
      for(k = 0; k < NUM_PLAYERS; k++)
      {
         myCardTable.PlayingArea.add(playedCardLabels[k]);
      }
      myCardTable.PlayingArea.add(playLabelText[0]);
      myCardTable.PlayingArea.add(playLabelText[1]);
      

      // show everything to the user
      myCardTable.setVisible(true);
   }
}


      
   
