package test.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FlipBits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t, a;
		t = in.nextInt();
		for(int i=0; i<t; i++) {
			a = in.nextInt();
			reverseBitsInt(a);
		}
		
	}

	public static int reverseBitsInt(int x) {
		  int intSize = 32;
		  int y=0;
		  for(int position=intSize-1; position>0; position--){
		    y+=((x&1)<<position);
		    x >>= 1;
		  }
		  System.out.println(y);
		  return y;
	}
}