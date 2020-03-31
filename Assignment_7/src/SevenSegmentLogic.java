//derived class
public class SevenSegmentLogic extends MultiSegmentLogic
{
   SevenSegmentLogic()
   {
     super(7);
     loadFunc();
   }
   
   public boolean getValOfSeg(int seg) 
   {
      if(seg >= 0 && seg < 7)
         return segs[seg].getState();
      return false;              
   }
   
   //helper method to set boolean functions for segments
   private void loadFunc()
   {
     
      int a[] = {1,4,11,13};
      int b[] = {5,6,11,12,14,15};
      int c[] = {2,12,14,15};
      int d[] = {1,4,7,9,10,15};
      int e[] = {1,3,4,5,7,9};
      int f[] = {1,2,3,13};
      int g[] = {0,1,7};
      int Ffunc[][] = {a, b, c, d, e, f, g};
      
      for(int i = 0; i < numSegs; i++)
      {
         BooleanFunc bFunc = new BooleanFunc();
         bFunc.setTruthTableUsingFalse(Ffunc[i]);
         setSegment(i, bFunc);
      }
   }
}
