/**
 * Created by Monil on 4/18/16.
 *
 * http://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/
 *
 *
 * Algorithm:

 1) If lengths of str1 and str2 are not same, return false.
 2) Do following for every character in str1 and str2
 a) If this character is seen first time in str1,
 then current of str2 must have not appeared before.
 (i) If current character of str2 is seen, return false.
 Mark current character of str2 as visited.
 (ii) Store mapping of current characters.
 b) Else check if previous occurrence of str1[i] mapped
 to same character.

 Time complexity: O(n)
 */

package strings;

import java.util.HashMap;
import java.util.Map;


// can be improved to use array of 26 size instead of hashmap and above algo.

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("egg", "xyz"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s==null || t==null)
            return false;

        if(s.length() != t.length())
            return false;

        if(s.length()==0 && t.length()==0)
            return true;

        HashMap<Character, Character> map = new HashMap<Character,Character>();
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            Character c = getKey(map, c2);
            if(c != null && c!=c1){
                return false;
            }else if(map.containsKey(c1)){
                if(c2 != map.get(c1))
                    return false;
            }else{
                map.put(c1,c2);
            }
        }

        return true;
    }

    // a method for getting key of a target value
    private static Character getKey(HashMap<Character, Character> map, Character target){
        for (Map.Entry<Character,Character> entry : map.entrySet()) {
            if (entry.getValue().equals(target)) {
                return entry.getKey();
            }
        }

        return null;
    }
}
