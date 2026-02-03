// LEETCODE: 165 Compare Version
public class CompareVersion {
    public static void main(String[] a) {
        String version1 = "1.2", version2 = "1.10";

        int res = Version.compareVersion(version1, version2);

        System.out.println("Res: " + res);
    }
}

class Version {
    public static int compareVersion(String version1, String version2) {
        while (version1.length() > 0 || version2.length() > 0) {

            int idx1 = version1.indexOf("."); // Get the index of the . to extract it
            int idx2 = version2.indexOf("."); 

            int v1 = convertInt(idx1, version1); // Invoke the helper to convert to int based on substr of the index of the dot
            int v2 = convertInt(idx2, version2);

            version1 = modifyTheVersion(idx1, version1); // Invoke the helper to cut the string if there is still a dot if idx is -1 then empty the string to stop the loop
            version2 = modifyTheVersion(idx2, version2);

            // Compare based on the requirements of the problem
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }
        return 0; // If its equals
    }

    // Helper function
    private static int convertInt(int idx, String version) {
        if (idx != -1) { // if there is a dot found then parse the string before the dot then return it the compare them, if they are == then return the 0 on main func
            return Integer.parseInt(version.substring(0, idx));
        } else if (!version.isEmpty()) { // no dot found parse the whole integer
            return Integer.parseInt(version);
        }

        return 0;
    }
    
    private static String modifyTheVersion(int idx, String version) {
        // If there is still a dot found return everything after the dot index
        if (idx != -1) {
            return version.substring(idx + 1);
        } else if (!version.isEmpty()) { // if dont have a dot left the empty the string to stop the loop
            return "";
        }

        // String is already empty then return empty string.
        return version;
    }
}

// TIME: O(N + M) WHERE N IS THE LENGTH OF VER1 AND M IS THE LENGHT OF VER2
// SPACE: 0(N + M)







/**
 * UNMODIFIED SOLUTION
 */

// class Solution {
//     public int compareVersion(String version1, String version2) {
//         while(version1.length() > 0 || version2.length() > 0) {
//             int v1 = 0;
//             int v2 = 0;

//             int idx1 = version1.indexOf("."); // Get the index of the . to extract it
//             int idx2 = version2.indexOf(".");

//             if(idx1 != -1) {
//                 v1 = Integer.parseInt(version1.substring(0, idx1)); // get the number before the .

//                 version1 = version1.substring(idx1 + 1); // remove the number before the .
//             }else{
//                 // if the version1 does not have a . then 
//                 if(!version1.isEmpty()) {
//                     v1 = Integer.parseInt(version1);
//                 }
                
//                 version1 = ""; // empty the string since it dont have a . anymore then end the loop
//             }

//             if(idx2 != -1) {
//                 v2 = Integer.parseInt(version2.substring(0, idx2)); // get the number before the .

//                 version2 = version2.substring(idx2 + 1); // remove the number before the .
//             }else{
//                 // if the version1 does not have a . then 
//                 if(!version2.isEmpty()) {
//                     v2 = Integer.parseInt(version2);
//                 }
                
//                 version2 = ""; // empty the string since it dont have a . anymore then end the loop
//             }

//             if(v1 < v2) {
//                 return -1;
//             }else if(v1 > v2) {
//                 return 1;
//             }
//         }
//         return 0;
//     }
// }