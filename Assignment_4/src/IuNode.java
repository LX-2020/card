

class IuNode extends StackNode
{
   // additional data for subclass
   InternetUser Iu;
   
   // constructor
   public IuNode(InternetUser x)
   {
      super();  
      Iu = x;
   }
   
   // accessor
   public InternetUser getItu()
   {
      return Iu;
   }

  
   public String toString()
   {
      return Iu.toString();
   }
}
