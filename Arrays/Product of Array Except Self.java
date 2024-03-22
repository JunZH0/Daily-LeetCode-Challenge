/* 
Difficulty: Medium

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 
Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 
Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Calculate products of elements to the left of each element and store in the answer array
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Calculate products of elements to the right of each element and multiply with answer array
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        return answer;
    }
}

/* Time and Space complexity
TC: O(n)
Forward Pass (Calculating leftProducts and storing in answer array): This pass iterates through the input array once, performing constant time operations for each element. So, it has a time complexity of O(n), where n is the number of elements in the input array.
Backward Pass (Calculating products of elements to the right and updating answer array): Similarly, this pass iterates through the input array once, performing constant time operations for each element. So, it also has a time complexity of O(n).
SC:0(1)


Aproach

* Forward Pass (Calculating leftProducts and storing in answer array): *

Initialize the answer array with the same size as the input array nums.
Start with answer[0] = 1, as there are no elements to the left of the first element.
Iterate through the input array from index 1 to n-1.
For each index i, calculate the product of all elements to the left of nums[i] and store it in answer[i]. This can be done by multiplying answer[i-1] with nums[i-1].
After this pass, the answer array will contain products of all elements to the left of each element.

* Backward Pass (Calculating products of elements to the right and updating answer array): *

Initialize a variable rightProduct = 1.
Iterate through the input array from index n-1 to 0.
For each index i, calculate the product of all elements to the right of nums[i] by multiplying rightProduct with nums[i].
Multiply the calculated product with answer[i] and update answer[i] with the result.
Update rightProduct by multiplying it with nums[i] for the next iteration.
After this pass, the answer array will contain the final result, where each element is the product of all elements in nums except nums[i].


*/
