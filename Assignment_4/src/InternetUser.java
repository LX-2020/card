
public class InternetUser
{
   public final static int MAX_NAME_LENGTH = 50;
   public final static int MIN_NAME_LENGTH = 2;
   public final static int MAX_IP_LENGTH = 15;
   public final static int MIN_IP_LENGTH = 7;
   public final static String DEFAULT_NAME = "undefined";
   public final static String DEFAULT_IP = "0.0.0.0";
   
   private String name;
   private String ip;
   
   //two constructors
   InternetUser()
   {
      name = DEFAULT_NAME;
      ip = DEFAULT_IP;
   }
   
   InternetUser(String name, String ip)
   {
      setName(name);
      setIp(ip);
   }
   
   //mutators
   public void setName(String name)
   {
      if( validName(name) )
         this.name = name;
      else this.name = DEFAULT_NAME;
   }
   
   public void setIp(String ip)
   {
      if( validIp(ip) )
         this.ip = ip;
      else this.ip = DEFAULT_IP;
   }
   
   //accessors
   public String getName()
   {
      return name;
   }
   
   public String getIp()
   {
      return ip;
   }
   
   public String toString()
   {  
      return  "Name: " + name + "\nIp Address: " + ip + "\n\n";      
   }
   
   //validation helpers
   private boolean validName(String name)
   {
      if ( name.length() < MIN_NAME_LENGTH 
            || name.length() > MAX_NAME_LENGTH )         
         return false;
      
      return true;
   }
   
   private boolean validIp(String ip)
   {
      if ( ip.length() < MIN_IP_LENGTH 
            || ip.length() > MAX_IP_LENGTH )         
         return false;
      
      return true;
   }

}
