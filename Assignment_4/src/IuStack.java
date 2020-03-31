
class IuStack extends Stack
{
   public static final InternetUser STACK_EMPTY = null;

   //push a node into the stack
   public void pushIu(InternetUser x)
   {
      if (x == STACK_EMPTY)
         return;    
      IuNode Iu = new IuNode(x);
     
      super.push(Iu);
   }

   //pop a node off the stack
   public InternetUser popIu()
   {
      IuNode Iu = (IuNode)pop();
      if (Iu == null)
         return STACK_EMPTY;
      else
         return Iu.getItu();
    }
   
   public String toString()
   {
      return super.toString();
   }
}
