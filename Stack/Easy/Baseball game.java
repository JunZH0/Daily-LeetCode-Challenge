/*
Difficulty: Easy

You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.

You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:

An integer x.
Record a new score of x.
'+'.
Record a new score that is the sum of the previous two scores.
'D'.
Record a new score that is the double of the previous score.
'C'.
Invalidate the previous score, removing it from the record.
Return the sum of all the scores on the record after applying all the operations.

The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.

Example 1:

Input: ops = ["5","2","C","D","+"]
Output: 30
Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.
Example 2:

Input: ops = ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation:
"5" - Add 5 to the record, record is now [5].
"-2" - Add -2 to the record, record is now [5, -2].
"4" - Add 4 to the record, record is now [5, -2, 4].
"C" - Invalidate and remove the previous score, record is now [5, -2].
"D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
"9" - Add 9 to the record, record is now [5, -2, -4, 9].
"+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
"+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.

Example 3:
Input: ops = ["1","C"]
Output: 0
Explanation:
"1" - Add 1 to the record, record is now [1].
"C" - Invalidate and remove the previous score, record is now [].
Since the record is empty, the total sum is 0.
 
Constraints:

1 <= operations.length <= 1000
operations[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
For operation "+", there will always be at least two previous scores on the record.
For operations "C" and "D", there will always be at least one previous score on the record.
*/


class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(String op : operations) {
            if(op.equals("+") ) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if(op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
/* Time and Space complexity
TC: O(n)
The algorithm iterates through each operation in the given list. The time complexity of this step is O(n), where n is the number of operations in the list.
The algorithm uses a stack to store scores. In the worst case, the stack can hold all the scores from the operations. 
Therefore, the overall space complexity of the algorithm is O(n), where n is the total number of scores stored in the stack.
SC:0(n)


Aproach

To solve this problem, we can use a stack to keep track of the scores. We'll iterate through the given list of operations and perform the corresponding actions:

Initialize Stack:
We start by initializing an empty stack, which will be used to keep track of the scores as we process the given operations.

Iterate through Operations:
We iterate through each operation provided in the list.

For each operation:
If the operation is an integer, it represents a new score, so we push the integer value onto the stack.
If the operation is '+', it indicates that we need to calculate the sum of the previous two scores and record it as a new score. We pop the top score from the stack, calculate the sum of the popped score and the current top score on the stack, and push the sum back onto the stack.
If the operation is 'D', it indicates that we need to double the previous score and record it as a new score. We pop the top score from the stack, double its value, and push the doubled value back onto the stack.
If the operation is 'C', it indicates that we need to invalidate the previous score, removing it from the record. We simply pop the top score from the stack.
Calculate Sum: After processing all operations, we iterate through the remaining scores on the stack and calculate their sum. This sum represents the total score recorded in the game.

Return Total Score: We return the total score calculated in step 3 as the final result.

*/
