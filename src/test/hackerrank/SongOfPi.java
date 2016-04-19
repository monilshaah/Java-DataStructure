package test.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SongOfPi {

    public static void main(String[] args) {
    	final String PI = "31415926535897932384626433833";
    	Scanner scanner = new Scanner(System.in);
    	int testCases = Integer.parseInt(scanner.nextLine());
    	StringBuilder piValue= new StringBuilder();
    	for (int i=0; i < testCases; i++) {
    		String str = scanner.nextLine();    		
    		//String str = "Can I have a large container of coffee right now";
    		String[] strArray = str.split(" ");
			piValue = new StringBuilder();
    		for (String s: strArray) {
    			piValue.append(SongOfPi.lengthWithoutWhitespace(s));
    		}
    		String pi = PI.substring(0, piValue.length());
    		if (piValue.toString().equals(pi))
    			System.out.println("It's a pi song.");
    		else
    			System.out.println("It's not a pi song.");
    	}
    }
    
    public static int lengthWithoutWhitespace(String source) {
    	StringBuilder target = new StringBuilder(source.toLowerCase()); 
    	int len = 0;
    	while (len < target.length()) {
    		if (target.charAt(len) < 'a' || target.charAt(len) > 'z') {
    			System.out.println("in if...");
    			target.deleteCharAt(len);
    		} else
    			len++;
    	}
    	return target.length();
    }
}

