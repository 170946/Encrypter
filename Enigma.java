import java.math.*;
public class Enigma{
    /** CAESAR SHIFT **/
    
    static int shift = 3;
    
    public static String encryptCaesarShift(String s){
        /* converting the string to uppercase */
        String s1 = s.toUpperCase();
        
        /* Converting the string to a character sequence */
        char[] sequence = new char[s1.length()];
        for(int i = 0; i < sequence.length; i++){
            sequence[i] = s1.charAt(i);
        }
        
        for(int i = 0; i < sequence.length; i++){
            if(sequence[i] == ' ') continue;
            sequence[i] = (char)((sequence[i] - 65 + shift)%26 + 65);
        }
        
        String result = "";
        for(int i = 0; i < sequence.length; i++){
            result = result + sequence[i];
        }
        
        return result;
    }
    
    public static String decryptCaesarShift(String s){
        /* converting the string to uppercase */
        String s1 = s.toUpperCase();
        
        /* Converting the string to a character sequence */
        char[] sequence = new char[s1.length()];
        for(int i = 0; i < sequence.length; i++){
            sequence[i] = s1.charAt(i);
        }
        
        for(int i = 0; i < sequence.length; i++){
            if(sequence[i] == ' ') continue;
            sequence[i] = (char)((sequence[i] - 65 - shift + 26)%26 + 65);
        }
        
        String result = "";
        for(int i = 0; i < sequence.length; i++){
            result = result + sequence[i];
        }
        
        return result;
    }
    
    /** RSA ENCRYPTION **/
        
    private static long prime1 = 11087L;
    private static long prime2 = 16417L;
    private static long publicKey = 5L;
        
    public static long encryptRSA(String input){
        String upper = input.toUpperCase();
        upper = upper.replaceAll("\\s*", ""); //gets rid of spaces
        
        
        long longString = 0L;
        for(int i = 0; i < upper.length(); i++){
            int digit = upper.charAt(i) - 65;
            longString *= 26;
            longString += digit;
        }
        
        long longStringEncrypted = 1L;
        for (int i = 1; i <= publicKey; i++){
            if((longStringEncrypted * longString) % (prime1 * prime2) < 0){
                longStringEncrypted = ((longStringEncrypted * longString) % (prime1 * prime2)) + prime1 * prime2;
            }
            else{
                longStringEncrypted = (longStringEncrypted * longString) % (prime1 * prime2);
            }
        }
        
        return longStringEncrypted;
    }
    
    
    public static String decryptRSA(long input, int length){
        String result = "";
        
        long longStringDecrypted = 1L;
        
        long privateKey = inverse(publicKey, (prime1 - 1) * (prime2 - 1));
        for(long i = 1L; i <= privateKey; i++){
            if((longStringDecrypted * input) % (prime1 * prime2) < 0){
                longStringDecrypted = ((longStringDecrypted * input) % (prime1 * prime2)) + prime1 * prime2;
            }
            else{
                longStringDecrypted = (longStringDecrypted * input) % (prime1 * prime2);
            }
        }
        
        
        for(int i = 1; i <= length; i++){
            long digit = longStringDecrypted % 26;
            longStringDecrypted = longStringDecrypted / 26;
            
            result = (char)(digit + 65) + result;
        }
        
        return result;
    }
    
    
    public static long inverse(long n, long mod){
        long result = 0;
        for(long k = 1L; k < mod; k++){
            if(n * k % mod == 1){
                result = k;
                break;
            }
        }
        
        return result;
    }
    
}