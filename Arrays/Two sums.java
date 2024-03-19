/*
Difficulty: Easy

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            Integer complementIndex = complements.get(nums[i]);
            if(complementIndex != null) {
                return new int[] {i, complementIndex};
            }

            complements.put(target - nums[i], i);
        }

        return new int[0];
    }
}

/* Time and Space complexity
TC: O(n)
The code uses a HashMap to store the complements of the current element. The loop iterates through the array once, and for each element, 
it performs constant time operations (get and put in the HashMap). Therefore, the overall time complexity is O(n)
SC:0(n)


Aproach

Initialize a HashMap named complements. This HashMap is used to store the complement of each element encountered so far along with its index.

Iterate through the input array nums.

For each element nums[i], check if its complement (i.e., target - nums[i]) exists in the complements HashMap. If it does, it means you've found the two numbers that add up to the target. Return an array containing their indices: [i, complementIndex].

If the complement doesn't exist in the complements HashMap, add the current element's complement along with its index to the HashMap. The complement is calculated as target - nums[i].

If the loop completes without finding a pair of numbers that sum up to the target, return an empty array new int[0]


*/
