package java_dsa_leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {30,40,50,60};

        var res = DaysToWait.dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(res));
    }
}

class DaysToWait {
    public static int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> mds = new Stack<>();
        int[] days = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];

            // if the stack is not empty then get the stored index and compare it to the temp
            while(!mds.isEmpty() && temp > temperatures[mds.peek()]) {
                int index = mds.pop();
                days[index] = i - index;
            }
            mds.push(i); // store the index of the temperature in the stack

            // System.out.println(mds);
        }

        return days; 
    }
}
// TIME: O(N)
// SPACE: 0(N) 