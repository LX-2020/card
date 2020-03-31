
class SevenSegmentImage implements Cloneable
{

   public static final int MIN_HEIGHT = 5;
   public static final int MIN_WIDTH = 5;
   public static final int MAX_HEIGHT = 65;
   public static final int MAX_WIDTH = 41;
   public static final String DRAW_CHAR = "*";
   public static final String BLANK_CHAR = " ";

   private boolean[][] data;
   private int topRow, midRow, bottomRow, leftCol, rightCol;

   public SevenSegmentImage()
   {
      setSize(MIN_WIDTH, MIN_HEIGHT);
      topRow = midRow = bottomRow = MIN_WIDTH;
      leftCol = rightCol = MIN_HEIGHT;
   }

   public SevenSegmentImage(int width, int height)
   {
      setSize(width, height);
      topRow = midRow = bottomRow = width;
      leftCol = rightCol = height;
   }

   public void clearImage()
   {
      for(int row = 0; row < leftCol; row++)
      {
         for(int col = 0; col < topRow; col++)
         {
            data[row][col] = false;
            System.out.print(BLANK_CHAR);
         }
         System.out.println("");
      }
   }
   
   private void allocateCleanArray(int width, int height)
   {
      topRow = midRow = bottomRow = width;
      leftCol = rightCol = height;
      data = new boolean[leftCol][topRow];
      clearImage();
   }
   
   public boolean setSize(int width, int height)
   {
      if(validateSize(width,height))
      {
         allocateCleanArray(width,height);        
         return true;
      }
      else return false;   
   }

   public boolean turnOnCellsForSegment(char segment)
   {
       char seg = Character.toLowerCase(segment);
       switch(seg)
       {
          case 'a':
             drawHorizontal(0, topRow);              
             break;
             
          case 'b':
             drawVertical(topRow-1,0,rightCol/2);
             break;
             
          case 'c':
             drawVertical(topRow-1,(rightCol/2)+1,rightCol);
             break;
             
          case 'd':
             drawHorizontal(leftCol-1, bottomRow);              
             break;
             
          case 'e':
             drawVertical(0,(leftCol/2)+1,leftCol);
             break;
             
          case 'f':
             drawVertical(0,0,leftCol/2);
             break;
             
          case 'g':
             drawHorizontal(leftCol/2, midRow); 
             break;
             
          default:
             System.out.println("invalid segment");
             break;  
       }
      return true;       
   }

   public void display()
   {
      for(int row = 0; row < leftCol; row++)
      {
         for(int col = 0; col < topRow; col++)
         {
            if(!data[row][col])           
               System.out.print(BLANK_CHAR);
            
            else 
               System.out.print(DRAW_CHAR);           
         }
         System.out.println("");
      }
   }

   // deep copy required
   public Object clone() throws CloneNotSupportedException
   {
      SevenSegmentImage newObject = (SevenSegmentImage)super.clone();
      
      for(int i=0;i<this.leftCol;i++)
      {
         for(int k=0;k<this.topRow;k++)
         {
            newObject.data[i][k] = this.data[i][k];
         }
      }     
      return newObject; 
   }

   private boolean validateSize(int width, int height)
   {
      if((width > MIN_WIDTH) && (width <MAX_WIDTH) && ((width % 2)!= 0) &&
      (height > MIN_HEIGHT && height < MAX_HEIGHT) && ((height % 2)!= 0) )
         return true;
      else return false;
   }   

   // helpers
   void drawHorizontal(int startRow, int row)
   {
      for(int col = 0; col < row; col++)
      {
         data[startRow][col] = true;
      }           
   }

   void drawVertical(int col, int startRow, int stopRow)
   {
      for(int row = startRow; row < stopRow ; row++)
      {
         data[row][col] = true;
      }
   }
}
