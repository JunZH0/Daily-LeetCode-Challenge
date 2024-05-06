
/*

Difficulty: Medium

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
*/

class Solution {
   public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
          int total = numbers[left] + numbers[right];

          if (total == target) {
            return new int[]{left + 1, right + 1};
          } else if (total > target) {
            right--;
          } else {
            left++;
          }
        }
     return new int[]{-1, -1};
    }  
}



/*

/* Time and Space complexity
TC: O(n)
 The loop iterates through all elements of the array (n times) until it finds the target sum or reaches the end.
SC:0(1)


Aproach

Initialiaze left and right pointer


Iterate While Both Pointers Don't Overlap: While the left pointer is less to the right pointer, do the following:

Initialize a int total which will be the sum of the values numbers[left] + numbers[right] which are the values at those 2 indexes.

If the value equals to the target, return an array with the left and right index plus 1 as the problem states its a 1-indexed array.

If total is greater that target the move the rigth pointer to the left, as its a sorted array, we check with a smaller value

If total is smaller than target, move the left index to the rigth.

If no solution is found, then return an array with value -1;
*/
