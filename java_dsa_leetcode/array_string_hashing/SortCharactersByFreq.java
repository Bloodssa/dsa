package java_dsa_leetcode.array_string_hashing;
import java.util.*;
import java.util.stream.Collectors;

public class SortCharactersByFreq {
    public static void main(String[] args){
        String s = "raaeaedere";

        var res = SortCharFreq.frequencySort(s);

        System.out.println(res);
    }
}

class SortCharFreq
{
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sort = new StringBuilder();

        // count frequency of every chars
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }

            map.putIfAbsent(s.charAt(i), 1);
        }

        // sort in decreasing order
        Map<Character, Integer> decreaseSort = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        
        // System.out.println(decreaseSort);

        decreaseSort.forEach((key, value) -> { // modify with repeat
            sort.append(String.valueOf(key).repeat(value));
        });
        
        // loop with foreach and lambda function
        // decreaseSort.forEach((key, value) -> {
        //     for(int i = 0; i < value; i++) {
        //         sort.append(key);
        //     }
        // });

        return sort.toString();
    }
}

// TIME COMP: O(n + k log k) k is the length of the map, decreaseSort
// SPACE COMP: O(n + k) where n is stringbuilder length and k is the hashmap
// NOTE: MODIFY IN THE FUTURE