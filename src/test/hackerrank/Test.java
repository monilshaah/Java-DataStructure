package test.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Test {
static int lonelyinteger(int[] a) {
    bubbleSort(a, a.length);
    int i=0;
    for (i=0; i< a.length-1;i=i+2) {
        if (a[i] != a[i+1])
            break;
    }
    return a[i];
}

public static void bubbleSort(int[] array, int nElem) {
        for (int upperBound=nElem-1; upperBound > 0; upperBound--) {
            for (int index=0; index < upperBound; index++) {
                if (array[index] == array[index+1])
                    continue;
                else if (array[index] < array[index+1])
                    continue;
                else {
                    int temp = array[index];
                    array[index] = array[index+1];
                    array[index+1] = temp;
                }
            }
        }
    }
    
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
//        String next = in.nextLine();
        _a_item = in.nextInt();
        System.out.println(_a_item);
        System.out.println(in.nextInt());
        System.out.println(in.nextLine());
        /*String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        if (_a.length == 1)
            res = _a[0];
        else 
            res = lonelyinteger(_a);
        System.out.println(res);*/
        
    }
}


/*InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);
String s = br.readLine();*/