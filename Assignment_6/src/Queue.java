
public class Queue
{
   private Node head, tail;
   
   public Queue()
   {
      head = null;
      tail = null;
   }
   
   public void add(Node node)
   {
      if(head == null && tail == null)
      {
         head = node;
         tail = node;
      }
      else 
      {
        tail.next = node;  
        tail = node;
      }
      
   }

   public Node remove()
    throws QueueEmptyException
    {
      Node temp;
      temp = head;
      if (head != null)
      {
         head = head.next; 
         temp.next = null; 
      }
      return temp; 
      
    }
   
   public String toString()
   {
      Node n;
      String ret="";
      
      for( n = head; n != null; n = n.next )
      {         
         ret += n.toString();
      }
      return ret;
   }
}
