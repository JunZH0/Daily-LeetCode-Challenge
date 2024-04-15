package Easy;/*

Difficulty: Easy

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.

*/



class Solution {
    public int removeDuplicates(int[] nums) {
         int uniqueIndex = 0; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        return uniqueIndex + 1;

    }
}





/* Time and Space complexity

TC: O(n)
The algorithm iterates through the input array nums once in a single pass.
Within each iteration, it performs constant-time operations such as comparisons and assignments.
SC: O(1)


Aproach

Initialization:

uniqueIndex variable is initialized to 0. This variable will keep track of the index where the next unique element should be placed.
Iterating through the Array:

The loop iterates through the array nums starting from the second element (index 1) to the last element.
Checking for Duplicates:

For each element at index i, it compares the element at index i with the element at uniqueIndex.
If the element at index i is different from the element at uniqueIndex, it means a new unique element is found. Therefore, uniqueIndex is incremented by 1, and the element at index i is copied to the position indicated by uniqueIndex. This effectively replaces any duplicate elements with the new unique element.
If the element at index i is equal to the element at uniqueIndex, it indicates a duplicate, so it is skipped.
Returning the Length:

After the loop finishes, uniqueIndex holds the index of the last unique element in the modified array.
Since array indices are zero-based, the length of the resulting array without duplicates is uniqueIndex + 1. Therefore, uniqueIndex + 1 is returned as the final result.

*/