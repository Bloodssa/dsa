// LEETCODE: 125. Valid Palindrome
public class ValidPalindrome {
    public static void main(String[] a){
        String s = "A man, a plan, a canal: Panama";

        boolean res = Palindrome.isPalindrome(s);

        System.out.print(res);
    }
}


class Palindrome
{
    public static boolean isPalindrome(String s)
    {
        int l = 0;
        int r = s.length() - 1;

        while (l < r){
            
            /**
             * Character.isLetterOrDigit();
             * @param char 
             * accepts a char then check if it a letter or a digit
             * return boolean if its a letter or a digit|numbers return true
             * return false if its a white space, ?!@##$$%........
             */

            //Skip the part the of the string if its not a letter or digit
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) l++; //increment leftpointer if encounter a special chars 
            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) r--; //decrement rightpointer if encounter a special chars
            
            // If pointer left and right is not equal then its not a palindrome
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;

            l++;
            r--;
        }
        return true;
    }
}

// TIME: 0(N)
// SPACE: 0(1)