import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class CardTable extends JFrame
{
   static final int MAX_CARDS_PER_HAND = 57;
   static final int MAX_PLAYERS = 2;  // for now, we only allow 2 person games
   
   private int numCardsPerHand;
   private int numPlayers;
   
   public JPanel ComputerHand;
   public JPanel PlayingArea;
   public JPanel YourHand;
   
   CardTable(String title, int numCardsPerHand, int numPlayers)
   {
      super(title);
      
      if(numCardsPerHand <= MAX_CARDS_PER_HAND)
         this.numCardsPerHand = numCardsPerHand;
      else this.numCardsPerHand = 0;
      
      if(numPlayers <= MAX_PLAYERS)
         this.numPlayers = numPlayers;
      else this.numPlayers = 0;
      
      ComputerHand = new JPanel(new FlowLayout(numCardsPerHand,20,0));
      PlayingArea = new JPanel(new GridLayout(numPlayers,numPlayers,0,0)); 
      YourHand = new JPanel(new FlowLayout(numCardsPerHand,20,0));
      
      add(ComputerHand,BorderLayout.NORTH);
      add(PlayingArea,BorderLayout.CENTER);
      add(YourHand,BorderLayout.SOUTH);
      
      ComputerHand.setBorder(new TitledBorder("Computer Hand"));
      PlayingArea.setBorder(new TitledBorder("Playing Area"));
      YourHand.setBorder(new TitledBorder("Your Hand"));
      
   }
   
   public int getnumCardsPerHand()
   {
      return numCardsPerHand;
   }
   
   public int getnumPlayers()
   {
      return numPlayers;
   }
}
