/*
Difficulty: Easy

Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

Example 1:

Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]
Example 2:

Input: nums = [1,3,2,1]
Output: [1,3,2,1,1,3,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
- ans = [1,3,2,1,1,3,2,1]
 

Constraints:

n == nums.length
1 <= n <= 1000
1 <= nums[i] <= 1000
*/


class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int [2 * nums.length];

        for(int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }
        return ans;    
    }
}

/* Time and Space complexity
TC: O(n)
 The time complexity is O(n), where n is the number of elements in the input array nums, as the algorithm iterates through the array once. 
 The space complexity is also O(n), as the size of the ans array is proportional to the size of the input array.
SC:0(n)


Aproach

Initialization:
Initialize a new integer array ans with a length of 2 * nums.length. This array will hold the concatenated elements.

Concatenation:
Iterate through the elements of the input array nums.
For each element at index i, copy its value to the corresponding position in the ans array.
Additionally, copy the same element to the position i + nums.length in the ans array. This effectively places a copy of each element after the original array elements.

Returning the Concatenation:
After the loop finishes, the ans array contains the concatenation of the original array nums with itself.
Return the ans array as the result.


A more generic solution, for when asked to do more concatenations would be :
*/

class Solution {
    public int[] getConcatenation(int[] nums, int times) {
        int totalLength = nums.length * times;
        int[] ans = new int[totalLength];

        for (int i = 0; i < times; i++) {
            for (int j = 0; j < nums.length; j++) {
                ans[i * nums.length + j] = nums[j];
            }
        }
        return ans;
    }
}
