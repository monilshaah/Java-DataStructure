package test.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*public static void main(String[] args) {
    	long low = 1, high = 1000000;
    	long sqr=0L;
    	boolean checkFlag = true, foundFlag = false;
    	String iSqrFirst = "", iSqrSecond = "", iStr = "", iSqr = "";
    	if (low == 1) {
    		System.out.println(1+" ");
    		low += 1;
    	}
    	for (long i=low; i< high; i++) {
    		sqr = i*i;
    		iStr = Long.toString(i);
    		iSqr = Long.toString(sqr);
    		checkFlag = true;
    		if (checkFlag) {
    			iSqrFirst = iSqr.substring(0, iStr.length());
    			iSqrSecond = iSqr.substring(iStr.length(), iSqr.length());
    			if (iSqrSecond.length() == 0) continue;
    			else if (Long.parseLong(iSqrSecond) > 0) {
    				long additionInt = Long.parseLong(iSqrFirst) + Long.parseLong(iSqrSecond);
    				if (additionInt == i) {
    					System.out.println(i+" ");
    					checkFlag = false;
    					foundFlag = true;
    				}
    			}
    		} 
    		if (checkFlag && iSqrSecond.length() == iStr.length()-1) {
    			iSqrFirst = iSqr.substring(0, iStr.length()-1);
    			iSqrSecond = iSqr.substring(iStr.length()-1, iSqr.length());
    			if (iSqrSecond.length() == 0) continue;
    			else if (Long.parseLong(iSqrSecond) > 0) {
    				long additionInt = Long.parseLong(iSqrFirst) + Long.parseLong(iSqrSecond);
    				if (additionInt == i) {
    					System.out.println(i+" ");
    					foundFlag = true;
    				}
    			}
    		}
    	}
    }*/
	
	public static void main(String[] args) {
    	long sqr=0L;
    	boolean notFoundFlag = true;
    	String iSqrFirst = "", iSqrSecond = "", iStr = "", iSqr = "";
    	/*Scanner scanner = new Scanner(System.in);
    	long p = scanner.nextInt();
    	long q = scanner.nextInt();*/
    	long p = 1, q = 1000000;
    	if (p == 1) {
    		System.out.println(1+" ");
    		p += 1;
    	}
    	for (long i=p; i< q; i++) {
    		sqr = i*i;
    		iStr = Long.toString(i);
    		iSqr = Long.toString(sqr);
    		iSqrFirst = iSqr.substring(0, iStr.length());
    		iSqrSecond = iSqr.substring(iStr.length(), iSqr.length());
    		/*if (i == 4879) {
    			System.out.println(iStr+" "+iSqr+" "+iSqrFirst+" "+iSqrFirst.charAt(iSqrFirst.length()-1));
    		}*/
    			
    		if (Long.parseLong(iSqrFirst) < i || iSqrSecond.length() == 0) {
    			if (iSqrSecond.length() == 0) continue;
    			else if (Long.parseLong(iSqrSecond) > 0) {
    				long additionInt = Long.parseLong(iSqrFirst) + Long.parseLong(iSqrSecond);
    				if (additionInt == i) {
    					System.out.println(i+" ");
    					notFoundFlag = false;
    				} else if (iSqrFirst.charAt(iSqrFirst.length()-1) == '0') {
    					iSqrFirst = iSqr.substring(0, iStr.length()-1);
    	    			iSqrSecond = iSqr.substring(iStr.length()-1, iSqr.length());
    	    			if (Long.parseLong(iSqrSecond) > 0) {
    	    				additionInt = Long.parseLong(iSqrFirst) + Long.parseLong(iSqrSecond);
    	    				if (additionInt == i) {
    	    					System.out.println(i+" ");
    	    					notFoundFlag = false;
    	    				}
    	    			}
    				}
    			}
    		} else {
    			iSqrFirst = iSqr.substring(0, iStr.length()-1);
    			iSqrSecond = iSqr.substring(iStr.length()-1, iSqr.length());
    			if (iSqrSecond.length() == 0) continue;
    			else if (Long.parseLong(iSqrSecond) > 0) {
    				long additionInt = Long.parseLong(iSqrFirst) + Long.parseLong(iSqrSecond);
    				if (additionInt == i) {
    					System.out.println(i+" ");
    					notFoundFlag = false;
    				}
    			}
    		}
    	}
    	if(notFoundFlag)
    		System.out.println("INVALID RANGE");
    }
}
