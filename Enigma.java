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
            sequence[i] = (char)((sequence[i] - 65 - shift)%26 + 65);
        }
        
        String result = "";
        for(int i = 0; i < sequence.length; i++){
            result = result + sequence[i];
        }
        
        return result;
    }
    
    /** RSA ENCRYPTION **/
        
    private static long prime1 = 1913L;
    private static long prime2 = 2027L;
    private static int exponent = 5;
        
    public static long encryptRSA(String input){
        String upper = input.toUpperCase();
        upper = upper.replaceAll("\\s*", ""); //gets rid of spaces
        
        
        long intString = 0L;
        
        for(int i = 0; i < upper.length(); i++){
            int digit = upper.charAt(i) - 65;
            intString *= 26;
            intString += digit;
        }
        
        long intStringEncrypted = 1L;
        for (int i = 1; i <= exponent; i++){
            intStringEncrypted = (intStringEncrypted * intString) % (prime1 * prime2);
        }
        
        return intStringEncrypted;
    }
    
    public static String decryptRSA(long input, int length){
        String result = "";
        
        long intStringDecrypted = 1L;
        
        int privateKey = inverse(exponent, (prime1 - 1) * (prime2 - 1));
        
        for(int i = 1; i <= privateKey; i++){
            intStringDecrypted = (intStringDecrypted * input) % (prime1 * prime2);
        }
        
        for(int i = 1; i <= length; i++){
            long digit = intStringDecrypted % 26;
            intStringDecrypted = intStringDecrypted / 26;
            
            result = (char)(digit + 65) + result;
        }
        
        return result;
    }
    
    private static int inverse(int n, long mod){
        int result = 0;
        for(int k = 1; k < mod; k++){
            if(n * k % mod == 1){
                result = k;
                break;
            }
        }
        
        return result;
    }
    
}