
public class CardNode extends Node
{
   Card card;
   
   CardNode(Card c)
   {
      super();
      card = new Card(c);
   }
   
   public Card getCardNode()
   {
      return card;
   }
   
   public String toString()
   {
      return card.toString();
   }
}
