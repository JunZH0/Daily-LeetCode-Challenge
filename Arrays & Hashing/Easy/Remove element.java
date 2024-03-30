package Easy;/*

Difficulty: Easy

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100


*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i< nums.length; i++) {
            if(nums[i] != val) {
                nums[k] = nums[i];
                k += 1;
            }
            
        }
        return k;
     }
}

/*

/* Time and Space complexity
TC: O(n)
It runs in O(n) time complexity, where n is the number of elements in the input array nums, as it iterates through the array only once.
SC: O(1)


Aproach

Initialization:
Initialize a variable k to 0. This variable will be used to track the position where the next non-val element should be placed.

Iterating through the Array:
Iterate through the array nums using a for loop.

Removing the Element:
For each element at index i, check if it is equal to the specified value val.
If the element is not equal to val, it means it should be kept in the modified array.
Copy the element to the position indicated by k in the array nums.
Increment k by 1 to move to the next position where the next non-val element should be placed.

Returning the Length:
After the loop finishes, k holds the index where the next non-val element should be placed.
Since array indices are zero-based, the length of the resulting array after removal of val occurrences is k. Therefore, k is returned as the final result.


*/
