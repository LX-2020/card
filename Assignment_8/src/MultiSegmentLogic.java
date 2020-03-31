//base class
public class MultiSegmentLogic implements Cloneable
{
   protected int numSegs;
   protected BooleanFunc[] segs;
   
   
   MultiSegmentLogic()
   {
      numSegs = 0;
      setNumSegs(numSegs);
   }
   
   MultiSegmentLogic(int numSegs)
   {
      this.numSegs = numSegs;
      setNumSegs(numSegs);
   }
   
   public boolean setNumSegs( int numSegs ) 
   {
      if(numSegs >= 0)
      {
         this.numSegs = numSegs;
         segs = new BooleanFunc[numSegs];
      }
      return true;
   }
   
   public boolean setSegment( int segNum, BooleanFunc funcForThisSeg) 
   {
      if(segNum >= 0 && segNum <= numSegs - 1)
      {
         try
         {
            segs[segNum] = (BooleanFunc)funcForThisSeg.clone();
            return true;
            
         } catch (CloneNotSupportedException e)
         {
            System.out.println("** Clone Unsuccessful **");
         }
         
      }
      return false;
   }
   
   public void eval(int input)
   {
      for(int i = 0; i < numSegs; i++)
      {
         segs[i].eval(input);
      }
   }
   
   public Object clone() throws CloneNotSupportedException
   {
      MultiSegmentLogic newObject = (MultiSegmentLogic)super.clone();
      
      newObject.numSegs = this.numSegs;
      for(int i=0;i<this.numSegs;i++)
      {
         newObject.segs[i] = this.segs[i];
      }
      
      return newObject;
   }
   
   
}
