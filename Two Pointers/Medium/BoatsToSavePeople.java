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

Sort the Array: First, sort the array of people's weights in non-decreasing order. Sorting will help in pairing up the heaviest and lightest people efficiently.

Use Two Pointers (Greedy Approach): Initialize two pointers, one at the beginning (left) and one at the end (right) of the sorted array. These pointers 
represent the two people being considered for boarding the boat.

Iterate While Both Pointers Don't Overlap: While the left pointer is less than or equal to the right pointer, do the following:

Check if the weight of the person at the left pointer and the weight of the person at the right pointer can fit into a single boat
(i.e., their sum is less than or equal to the weight limit). If so, increment the left pointer to consider the next lightest person.
Decrement the right pointer to consider the next heaviest person.
Increment the count of boats required.

Return the Count of Boats: After the while loop terminates (when left and right pointers overlap), return the count of boats required to rescue all people.
*/

