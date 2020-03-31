
public class LinkedList<E>
{
   protected Node<E> head;
   private Node<E> current;
   
   LinkedList()
   {
      head = new Node<E>();
      current = null;
   }
   
   protected void insertAfterHead(E data)
   {   
      head.insertAfter(data);
   }  
   
   protected E removeAfterHead()
   {
     return head.removeAfter();     
   }

   public String toString()
   {
      Node<E> n;
      String ret="";
      
      for( n = head.next; n != null; n = n.next )
      {         
         ret += n.toString();         
      }
      return ret;
   }

   protected Node<E> getCurrent()
   {
      return current;
   }

   protected void resetCurrent()
   {
      current = head;
   }

   protected Node<E> iterate()
   {
      if (current != null)
         current = current.next;
      return current;
   }

}
