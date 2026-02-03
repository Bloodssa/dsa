package java_dsa_leetcode.sliding_window;

public class MinimumRecolors 
{
    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW"; int k = 7;
        int res = Recolors.minimumRecolors(blocks, k);

        System.out.println(res);
    }
}

class Recolors 
{
    // Sliding Window
    public static int minimumRecolors(String blocks, int k) {
        int recolor = 0;

        for(int i = 0; i < k; i++){
            if(blocks.charAt(i) == 'W') {
                recolor++;
            }
        }

        int res = recolor;

        for(int i =k; i < blocks.length(); i++){
            if(blocks.charAt(i - k) == 'W') recolor--;
            if(blocks.charAt(i) == 'W') recolor++;
            
            res = Math.min(res, recolor);
        }

        return res;
    }

    public static int bruteForce(String blocks, int k) {
        int minCount = k;  

        // reduce the length of blocks based on k length
        for(int i = 0; i <= blocks.length()-k; i++) {
            int addBlack = 0;

            for(int j = i; j < k+i; j++){
                if(blocks.charAt(j) == 'W') { // if found a W char then increment the count to change to Black
                    addBlack++;
                }
            }
            minCount = Math.min(minCount, addBlack);
        }

        return minCount;
    }

    //TIME: O(n * k)
    //SPACE: 0(1)
}