
public class Stack
{
   // pointer to first node in stack
   private StackNode top;
   
   // constructor
   public Stack()
   {
      top = null;
   }
   
   public void push(StackNode newNode)
   {   
      if (newNode == null) 
         return;   
      newNode.next = top;
      top = newNode;
   }  
   
   public StackNode pop()
   {
      StackNode temp;
     
      temp = top;
      if (top != null)
      {
         top = top.next; 
         temp.next = null; 
      }
      return temp;      
   }

   // console display
   public String toString()
   {
      StackNode p;
      String ret="";
      
      // Display all the nodes in the stack
      for( p = top; p != null; p = p.next )
         ret += p.toString();
      
      return ret;
   }
}