package Randomer;

import java.util.Random;

/**
 * Created by user on 1/18/16.
 */
public class Randomy {
    public static String randomName(int length){
        final String data = "0123456789abcdefghijklnmopqrstuvwyzx";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for( int i = 0; i<length; i++){
            sb.append(data.charAt(random.nextInt(data.length())));

        }
        return sb.toString();
    }
    public static String randomEmail(){
        int length = 5;
        String name = "0123456789abcdefghijklnmopqrstuvwyzx";
        String firstDomain = "0123456789abcdefghijklnmopqrstuvwyzx";
        String secondDomain = "abcdefghijklnmopqrstuvwyzx";
        Random random = new Random();
        String email = new String();

        StringBuilder sb = new StringBuilder(length);

        for( int i = 0; i<length; i++){
            sb.append(name.charAt(random.nextInt(name.length())));
            email += sb;
        }
        for( int i = 0; i<length; i++){
            sb.append(firstDomain.charAt(random.nextInt(firstDomain.length())));
            email += "@" + sb;
        }
        for( int i = 0; i<length; i++){
            sb.append(secondDomain.charAt(random.nextInt(secondDomain.length())));
            email += "." + sb;
        }
        return email;
    }
    public static int randomNumber(int maxValue){
        Random random = new Random();
        return random.nextInt(maxValue);
    }
}
