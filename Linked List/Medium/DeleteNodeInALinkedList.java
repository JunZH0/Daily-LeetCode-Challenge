/*

Difficulty: Medium

There is a singly-linked list head and we want to delete a node node in it.

You are given the node to be deleted node. You will not be given access to the first node of head.

All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

The value of the given node should not exist in the linked list.
The number of nodes in the linked list should decrease by one.
All the values before node should be in the same order.
All the values after node should be in the same order.
Custom testing:

For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
We will build the linked list and pass the node to your function.
The output will be the entire list after calling your function.
 
Example 1:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

*/

class Solution {
   public void deleteNode(ListNode node) {
     node.val = node.next.val;
     node.next.val = node.next.next;
   }
}


/*

/* Time and Space complexity
TC: O(1)
The code only performs a constant number of operations regardless of the size of the input, as it simply updates the values of the current node and its next node without iterating through a list.
SC:0(1)

Aproach

To delete the given node, we copy the value of the next node to the current node and adjust the next pointer to skip the next node.

Copy the value of the next node to the current node.
Adjust the next pointer to skip the next node.

Note: We are not actually removing/deleting given node, as question might imply. To actually delete the node, we need to change the reference of the previous node's next pointer to skip over the given node. However, we do not have access to the previous node.
*/
