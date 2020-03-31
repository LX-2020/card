
public class Node<E>
{
   protected Node<E> next;
   private E data;
   
   public Node()
   {
      next = null;
   }

   public Node(E data)
   {
      setData(data);
   }
   
   public boolean setData(E data)
   {
      if (data == null)
         return false;
      this.data = data;
      return true;
   }
   
   public E getData()
   {
      return data;
   }
   
   public String toString()
   {
      return data.toString();
   }

   // insert after
   public void insertAfter(E data)
   {
      if (data == null)
         return;
      Node<E> newNode = new Node<E>(data);
      newNode.next = next;
      next = newNode;
   }

   // remove after
   public E removeAfter()
   {
      Node<E> temp = next;

      if (temp != null)
         next = temp.next;
      return temp.getData();
   }

   // returning the next member
   public E getNext()
   {
      return next.getData();
   }
}
