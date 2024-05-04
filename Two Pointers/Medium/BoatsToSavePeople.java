/*

Difficulty: Medium

You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 1:

Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
Example 2:

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)
Example 3:

Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 

Constraints:

1 <= people.length <= 5 * 104
1 <= people[i] <= limit <= 3 * 104

*/

class Solution {
   public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0;
        int rigth = people.length - 1;

        while (left <= rigth) {
            if (people[left] + people[rigth] <= limit) {
                left++;
            }
            rigth--;
            boats++;
        }

        return boats;
    }  
}


/*

/* Time and Space complexity
TC: O(n log n)
 The time complexity is O(n log n), where n is the number of people. 
 This complexity arises primarily from the sorting operation performed using Arrays.sort(people)
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

*/

