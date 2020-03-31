import java.util.Scanner;

public class Foothill
{
   public static void main (String[] args)
   {
      /*//phase 1 Base class:
      InternetUser user1, user2, user3, user4;
      user1 = new InternetUser();
      user2 = new InternetUser("John", "3.2.5.6");
      user3 = new InternetUser("", "1.3.7"); //invalid name
      user4 = new InternetUser("Mary", "1.4.2"); //invalid ip
      
      System.out.println(user1.toString() + user2 + user3 + user4);
      
      //test mutator
      user1.setIp("3.1.6.4");
      user1.setName("Ben");
      user3.setName("Lily");
      user3.setIp("2.5.1.3");
      user4.setIp("1.4.2.5");
            
      System.out.println("After set correct name and Ip address: \n"
            + user1 + user2 + user3 + user4);
     
      //test accessor
      System.out.println("Get the second user's name:\n" + user2.getName());
            
      //phase 2 Derived class:
      long p, q; 
      String strUserIn;
      Communicator num1, num2, num3, num4;
      num1 = new Communicator();
      System.out.println("\n" + num1);
      
      Scanner inputStream = new Scanner(System.in);      
      System.out.println("\nEnter two prime numbers: ");
      strUserIn = inputStream.nextLine();
      p = Long.parseLong(strUserIn);       
      strUserIn = inputStream.nextLine();
      q = Long.parseLong(strUserIn);
      
      num2 = new Communicator(p,q);
      System.out.println(num2);
      
      num3 = new Communicator( "John","2.1.4.2" );
      System.out.println(num3);
            
      System.out.println("\nEnter two prime numbers: ");
      strUserIn = inputStream.nextLine();
      p = Long.parseLong(strUserIn);
      strUserIn = inputStream.nextLine();
      q = Long.parseLong(strUserIn);
      num4 = new Communicator( "Mary","1.4.2.6",p,q );
      System.out.println(num4);
      
      //test Derived class mutator and accessor
      if(num1.getPublicKey() == null || num1.getPrivateKey() == null)
      System.out.println("\nEnter two prime numbers: " );
      strUserIn = inputStream.nextLine();
      p = Long.parseLong(strUserIn);
      strUserIn = inputStream.nextLine();
      q = Long.parseLong(strUserIn);
      
      num1.setPrime(p, q);
      System.out.println(num1);
      */
      
      
      
      
      
      
      
      
      
      
      
      IuStack iustk = new IuStack();
      InternetUser iu, iu1, iu2, iu3, iu4;
      iu1 = new InternetUser();
      iu2 = new InternetUser("John", "3.2.5.6");
      iu3 = new InternetUser("Mary", "1.4.2.5");
      iu4 = new InternetUser("Ben", "1.4.2.7");

      iustk.pushIu(iu1);
      iustk.pushIu(iu2);
      iustk.pushIu(iu3);
      iustk.pushIu(iu4);
      
      System.out.print("The Internet user stack: " + "\n" + iustk);
      
      for (int k = 0; k < 5; k++)
         if ( (iu = iustk.popIu()) != IuStack.STACK_EMPTY)
            System.out.print("#" + k + "Internet user\n" + iu);    
         else
            System.out.print("(empty stack) ");
      System.out.println();
   
   
      
      
      
      
      
      
   }
}
      
      
      
 /*----------------- console output-------------
Base class test
  
Name: undefined
Ip Address: 0.0.0.0

Name: John
Ip Address: 3.2.5.6

Name: undefined
Ip Address: 0.0.0.0

Name: Mary
Ip Address: 0.0.0.0


After set correct name and Ip address: 
Name: Ben
Ip Address: 3.1.6.4

Name: John
Ip Address: 3.2.5.6

Name: Lily
Ip Address: 2.5.1.3

Name: Mary
Ip Address: 1.4.2.5


Get the second user's name:
John

//Derived class test
Name: undefined
Ip Address: 0.0.0.0

(p, q)  n, phi, e, d: (0,0) 0,0,0,0
public keynull
private keynull



Enter two prime numbers: 
3789
37
Name: undefined
Ip Address: 0.0.0.0

(p, q)  n, phi, e, d: (0,0) 0,0,0,0
public keynull
private keynull


Name: John
Ip Address: 2.1.4.2

(p, q)  n, phi, e, d: (0,0) 0,0,0,0
public keynull
private keynull



Enter two prime numbers: 
37
79
Name: Mary
Ip Address: 1.4.2.6

(p, q)  n, phi, e, d: (37,79) 2923,2808,461,875
public key(461, 2923)
private key(875, 2923)



Enter two prime numbers: 
67
67
Name: undefined
Ip Address: 0.0.0.0

(p, q)  n, phi, e, d: (0,0) 0,0,0,0
public keynull
private keynull



 */
      
      
      
      
      
      
      
      
      


