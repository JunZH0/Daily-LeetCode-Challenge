/*
Difficulty: Easy

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true

Example 2:

Input: nums = [1,2,3,4]
Output: false

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:

    1 <= nums.length <= 105
    -109 <= nums[i] <= 109

*/



class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> duplicateSet = new HashSet();

        for(int i = 0; i < nums.length; i++) {
            if(duplicateSet.contains(nums[i])) {
                return true;
            }
            duplicateSet.add(nums[i]);
        }
        return false;
    }
}

/* Time and Space complexity
TC: O(n)
The code iterates through the 'nums' array once, checking if each element is already in the 'duplicateSet' HashSet. 
The HashSet operations (add and contains) have an average time complexity of O(1), so the overall time complexity of the code is O(n)


SC: O(n)


Aproach

Initialize a HashSet named duplicateSet. HashSet is chosen as its store only unique values and have constant-time complexity for basic operations like add and contains..

Iterate through the input array nums.

For each element nums[i], check if it already exists in the duplicateSet. If it does, return true, indicating that a duplicate has been found.

If the element doesn't exist in the duplicateSet, add it to the set.

If the loop completes without finding any duplicates, return false, indicating that there are no duplicates in the array.

*/
