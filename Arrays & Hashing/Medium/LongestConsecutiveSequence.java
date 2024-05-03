 /* Difficulty: Medium

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

*/

class Solution {
     public int longestConsecutive(int[] nums) {
      HashSet<Integer> numSet = new HashSet<>();

      for (int num : nums) {
        numSet.add(num);
      }

      int longestStreak = 0;
      for (int num : numSet) {
        if (!num.contains(num - 1)) {
            int currentNum = num;
            int currentStreak = 1;

          while (numSet.contain(currentNum + 1)) {
            currentNum++;
            currentStreak++;
          }

          longeStreak = Math.max(longestStreak, currentStreak);
        }
      }
        return longestStreak;
    }
}

/* Time and Space complexity
TC: O(n)
The code iterates through the 'nums' array to add elements to a HashSet, which has an average time complexity of O(1) for insertion. 
Then, it iterates through the elements in the HashSet to find the longest consecutive sequence, which also has a time complexity of O(n) 
where n is the number of elements in the HashSet.

SC: O(n)


Aproach

We first add all elements of the array to a HashSet to allow O(1) lookup for each element.

For each number in the array, we check if it's the start of a sequence by seeing if the HashSet does not contain its predecessor (num - 1). This ensures that we are only considering sequences that start at the lowest number of the sequence.

If the current number is the start of a sequence, we increment it to find the consecutive sequence and update the longest streak accordingly.

Finally, we return the longest streak found. The time complexity of this solution is O(n) because both the insertion into the HashSet and the iteration through the array are O(n).
*/
