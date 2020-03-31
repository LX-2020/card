
public class CardQueue extends Queue
{
   public static final Card QUEUE_EMPTY = null;
   
   CardQueue()
   {
      super();
   }
   
   public void addCard(Card card)
   {  
      CardNode cnode = new CardNode(card);    
      super.add(cnode);
   }
   
   public Card removeCard() 
         throws QueueEmptyException
   {      
      CardNode cnode = (CardNode)remove();
      if(cnode == null)
         throw new QueueEmptyException();
      return cnode.getCardNode();    
   }
   
   public String toString()
   {
      return super.toString();
   }
}
