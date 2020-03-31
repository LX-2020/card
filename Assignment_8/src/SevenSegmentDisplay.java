
class SevenSegmentDisplay  implements Cloneable
{
   private SevenSegmentImage theImage;
   private SevenSegmentLogic theDisplay;

   public SevenSegmentDisplay()
   {
      theImage = new SevenSegmentImage();
      theDisplay = new SevenSegmentLogic();
   }
   
   public SevenSegmentDisplay( int width, int height )
   {
      theImage = new SevenSegmentImage(width, height);
      theDisplay = new SevenSegmentLogic();
   }
   
   public boolean setSize( int width, int height )
   {
      if(theImage.setSize(width, height))
         return true;
      else return false;
   }
   
   public void loadConsoleImage()
   {
      theImage.clearImage();
      for(int i = 0; i <7; i++)
      {
         if(theDisplay.getValOfSeg(i))
         {
            char seg = (char)(i+65);
            theImage.turnOnCellsForSegment(seg);
         }
      }
   }
   
   public void consoleDisplay()
   {
      theImage.display();
   }
   
   public void eval( int input )
   {
      theDisplay.eval(input);
   }

   public Object clone() throws CloneNotSupportedException
   {
      SevenSegmentDisplay newObject = (SevenSegmentDisplay)super.clone();
      return newObject;
   }
}
