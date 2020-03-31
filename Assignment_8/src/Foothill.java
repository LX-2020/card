
public class Foothill
{
   public static void main(String[] args)
   {
      /*
      SevenSegmentImage ssi = new SevenSegmentImage();

      System.out.println(
         "Testing SevenSegmentImage ===================================");

      ssi.setSize( 7, 9 );
      ssi.turnOnCellsForSegment( 'a' );
      ssi.display();
      ssi.turnOnCellsForSegment( 'b' );
      ssi.display();
      ssi.turnOnCellsForSegment( 'c' );
      ssi.display();
      ssi.turnOnCellsForSegment( 'd' );
      ssi.display();

      ssi.clearImage();
      ssi.turnOnCellsForSegment( 'e' );
      ssi.display();
      ssi.turnOnCellsForSegment( 'f' );
      ssi.display();
      ssi.turnOnCellsForSegment( 'g' );
      ssi.display();

      ssi.clearImage();
      ssi.turnOnCellsForSegment( 'x' );
      ssi.display();
      ssi.turnOnCellsForSegment( '3' );
      ssi.display();
      */
      SevenSegmentDisplay  my7SegForCon = new SevenSegmentDisplay( 15, 13 );
      int j;
      
      System.out.println(
         "Testing SevenSegmentDisplay ===================================");

      my7SegForCon.setSize( 7, 9 );
      for ( j = 0; j < 16; j++ )
      {
         my7SegForCon.eval( j );
         my7SegForCon.loadConsoleImage();
         my7SegForCon.consoleDisplay();
      }

      for ( j = 5; j < 21; j += 4)
      {
         my7SegForCon.setSize( j, 2*j + 1 );
         my7SegForCon.eval( 5 );
         my7SegForCon.loadConsoleImage();
         my7SegForCon.consoleDisplay();
      }
   }
   
}
