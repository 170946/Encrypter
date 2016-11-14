import java.util.Scanner;
public class EnigmaTest{
    public static void main(String[] args){
       String answer = "";
        
        while (!answer.equals("exit")){
          System.out.println("Hello. Enter 1 to encrypt, 2 to decrypt");
          Scanner kb = new Scanner(System.in);
          answer = kb.next();
          
          if(answer.equals("1")){
              System.out.println("Enter 1 for Caesar Shift, 2 for RSA");
              String cOrR = kb.next();
              
              if (cOrR.equals("1")){
                  System.out.println("Enter the text you would like to encrypt");
                  String s = kb.next();
                  System.out.println(Enigma.encryptCaesarShift(s));
              }
              else if (cOrR.equals("2")){
                  System.out.println("Enter the text you would like to encrypt");
                  String s = kb.next();
                  System.out.println(Enigma.encryptRSA(s));
              }
              else {
                  System.out.println("Sorry, you must have entered something incorrectly.");
                }
              
          }
          
          else if(answer.equals("2")){
              System.out.println("Enter 1 for Caesar Shift, 2 for RSA");
              String cOrR = kb.next();
              
              if (cOrR.equals("1")){
                  System.out.println("Enter the text you would like to decrypt");
                  String s = kb.next();
                  System.out.println(Enigma.decryptCaesarShift(s));
              }
              else if (cOrR.equals("2")){
                  System.out.println("Enter the int you would like to encrypt, a space, followed by the length of the String encrypted");
                  long s = kb.nextLong();
                  int t = kb.nextInt();
                  System.out.println(Enigma.decryptRSA(s, t));
              }
              else {
                  System.out.println("Sorry, you must have entered something incorrectly.");
                }
              
            }
       }
    }
}
