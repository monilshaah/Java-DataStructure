package strings;

import java.util.*;

/**
 * Created by Monil on 4/18/16.
 *
 * http://www.programcreek.com/2012/12/leetcode-word-ladder/
 *
 * http://www.programcreek.com/2014/06/leetcode-word-ladder-ii-java/
 */
class WordNode{
    String word;
    int numSteps;
    WordNode pre;

    //use for shortestLadderLength()
    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
        this.pre = null;
    }

    // use for findLadders()
    public WordNode(String word, int numSteps, WordNode pre){
        this.word = word;
        this.numSteps = numSteps;
        this.pre = pre;
    }
}

public class WordLadder {
    public static void main(String[] args) {
        String[] dictArr = {"hot","dot","dog","lot","log"};

        Set<String> dict1 = new HashSet<>(Arrays.asList(dictArr));
        System.out.println(shortestLadderLength("hit", "cog", dict1));

        Set<String> dict2 = new HashSet<>(Arrays.asList(dictArr));
        System.out.println(findLadders("hit", "cog", dict2));
    }

    /**
     * http://www.programcreek.com/2012/12/leetcode-word-ladder/
     *
     * this is a search problem, and breath-first search guarantees the optimal solution.
     */
    public static int shortestLadderLength(String beginWord, String endWord, Set<String> wordDict) {
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord, 1));

        wordDict.add(endWord);

        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;

            if(word.equals(endWord)){
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        wordDict.remove(newWord);
                    }

                    arr[i]=temp;
                }
            }
        }

        return 0;
    }


    /**
     * http://www.programcreek.com/2014/06/leetcode-word-ladder-ii-java/
     *
     * The idea is the same. To track the actual ladder, we need to add a pointer that points to the previous node in the WordNode class.

     In addition, the used word can not directly removed from the dictionary. The used word is only removed when steps change.
     */
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();

        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(start, 1, null));

        dict.add(end);

        int minStep = 0;

        HashSet<String> visited = new HashSet<String>();
        HashSet<String> unvisited = new HashSet<String>();
        unvisited.addAll(dict);

        int preNumSteps = 0;

        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
            int currNumSteps = top.numSteps;

            if(word.equals(end)){
                if(minStep == 0){
                    minStep = top.numSteps;
                }

                if(top.numSteps == minStep && minStep !=0){
                    //nothing
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while(top.pre !=null){
                        t.add(0, top.pre.word);
                        top = top.pre;
                    }
                    result.add(t);
                    continue;
                }

            }

            if(preNumSteps < currNumSteps){
                unvisited.removeAll(visited);
            }

            preNumSteps = currNumSteps;

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(unvisited.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1, top));
                        visited.add(newWord);
                    }

                    arr[i]=temp;
                }
            }


        }

        return result;
    }
}

