package java_dsa_leetcode.array_string_hashing;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElement {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        int[] res = TopK.topKFrequent(nums, k);

        System.out.println(Arrays.toString(res));
    }
}

class TopK {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            }
            map.putIfAbsent(n, 1);
        }


        // Sort the counts of the nums element in the hashmap
        Map<Integer, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        int[] topK = sortedMap.keySet().stream()
                .mapToInt(Integer::intValue)
                .limit(k) // get the top k since it sorted to desc
                .toArray();

        return topK;
    }
}