public class BooleanFunc implements Cloneable
{
   public static int MAX_TABLE_FOR_CLASS = 65536; 
   public static int DEFAULT_TABLE_SIZE = 16;
   
   private int tableSize;
   private boolean[] truthTable;
   private boolean evalReturnIfError = false;
   private boolean state;

   BooleanFunc()
   {
      tableSize = DEFAULT_TABLE_SIZE;
      truthTable = new boolean[tableSize]; 
   }
   
   BooleanFunc(int tableSize)
   {
      this.tableSize = tableSize;
      truthTable = new boolean[tableSize]; 
         
   }
   
   BooleanFunc(int tableSize, boolean evalReturnIfError)
   {
      this.evalReturnIfError = evalReturnIfError;
      this.tableSize = tableSize;
      truthTable = new boolean[tableSize];  
   }
  
   public boolean setTruthTableUsingTrue(int[] inputsThatProduceTrue) 
   {
      //if there are more false booleans, set all array members to false
      for(int i = 0; i < tableSize; i++)
      {
         truthTable[i] = false;
      }
      //set true according to passed in index array
      for(int i = 0; i  < inputsThatProduceTrue.length; i++)
      {   
         if(inputsThatProduceTrue[i] >= 0 && inputsThatProduceTrue[i] < tableSize)
         {
            truthTable[inputsThatProduceTrue[i]] = true;
         }
      }
      
      if(inputsThatProduceTrue.length <= tableSize)
         return true; 
      else return false;
   }

   public boolean setTruthTableUsingFalse(int[] inputsThatProduceFalse) 
   {
      for(int i = 0; i < tableSize; i++)
      {
         truthTable[i] = true;
      }
      
      for(int i = 0; i < inputsThatProduceFalse.length; i++)
      { 
         if(inputsThatProduceFalse[i] >= 0 && inputsThatProduceFalse[i] < tableSize)
         truthTable[inputsThatProduceFalse[i]] = false; 
      }
      
      if(inputsThatProduceFalse.length <= tableSize)
         return true; 
      else return false;
   }
   
   public boolean eval(int input) 
   {
      if(input >= 0 && input < tableSize - 1)
         state = truthTable[input];
      else state = evalReturnIfError;
     
      return state;
   }

   public boolean getState()
   {
      return state;
   }
   
   public Object clone() throws CloneNotSupportedException
   {
      BooleanFunc newObject = (BooleanFunc)super.clone();
      
      newObject.tableSize = this.tableSize;
      for(int i=0;i<this.tableSize;i++)
         newObject.truthTable[i] = this.truthTable[i];
      
      return newObject;
   }
   

}
