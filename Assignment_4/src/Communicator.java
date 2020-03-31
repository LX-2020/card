
public class Communicator extends InternetUser
{
   public final static int ERROR_FLAG_NUM = 0;
   private final static int MAX_PQ = (int
         )Math.sqrt(Long.MAX_VALUE);
   
   private long firstPrime;
   private long secondPrime;
   private long n, phi, e, d;
   private IntPair publicKey;
   private IntPair privateKey;
   
   //constructors
   Communicator()
   {
      super();
      firstPrime = ERROR_FLAG_NUM;
      secondPrime = ERROR_FLAG_NUM;
   }
   
   Communicator(long p, long q)
   {
      super();
      if( !setPrime(p, q) )
      {
         firstPrime = ERROR_FLAG_NUM;
         secondPrime = ERROR_FLAG_NUM;
      }
         
   }
   
   Communicator(String name,String ip)
   {
      super(name,ip);
      firstPrime = ERROR_FLAG_NUM;
      secondPrime = ERROR_FLAG_NUM;
   }
   
   Communicator(String name,String ip, long p, long q)
   {
      super(name,ip);
      
      if( !setPrime(p, q) )
      {
         firstPrime = ERROR_FLAG_NUM;
         secondPrime = ERROR_FLAG_NUM;
      }       
   }
   
   //mutators
   public boolean setPrime(long p, long q)
   {
      if( !EncryptionSupport.isPrime(p) || !EncryptionSupport.isPrime(q)
            || p > MAX_PQ || q > MAX_PQ || p == q )         
         return false;
       
      firstPrime = p;
      secondPrime = q;
      computeBothEncrKeys(p,q);
      return true;         
   }
   
   //accessors
   public IntPair getPublicKey()
   { 
      return publicKey;     
   }
   
   public IntPair getPrivateKey()
   {
      return privateKey;
   }
   
   public String toString()
   {
      return super.toString() + "(p, q)  n, phi, e, d: " + "(" + firstPrime + 
            "," + secondPrime + ") " + n + "," + phi + "," + e + "," + d +
            "\npublic key" + publicKey 
              + "\nprivate key" + privateKey + "\n\n";
   }
   
   private boolean computeBothEncrKeys(long p,long q)
   {
      n = p * q;
      phi = (p - 1) * (q - 1);
      do
      {
         e = EncryptionSupport.getSmallRandomPrime();          
      }while(e > phi && phi % e == 0);
       
      d = EncryptionSupport.inverseModN(e, n);
      
      publicKey = new IntPair(e, n);
      privateKey = new IntPair(d, n); 
      
      return true;      
   }
   
}
