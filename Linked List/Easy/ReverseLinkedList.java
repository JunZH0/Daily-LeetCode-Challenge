/*

Difficulty: Easy

Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:

Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []


*/

class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    ListNode nextTemp = null;

    while (current != null) {
      nextTemp = current.next;
      current.next = prev;
      prev = current;
      current = nextTemp;
    }
    return prev;
  }
}

/*

TC: O(n)
The code snippet uses a while loop to iterate through each node in the linked list once, resulting in a linear time complexity of O(n),
where n is the number of nodes in the linked list.
SC: O(1)

Aproach

- Initialize three pointers:
    - prev: This pointer will initially be set to null and will eventually hold the pointer to the previous node in the reversed list.
    - current: This pointer will initially point to the head of the original list and will be used to traverse the list.
    - nextTemp: This pointer will temporarily hold the next node in the original list before we change the current.next pointer.

- Traverse the original list using a while loop:
    - Inside the loop, we first store the current.next pointer in nextTemp to prevent losing the reference to the next node.
    - Then, we change the current.next pointer to point to the previous node (prev). This effectively reverses the direction of the pointer.
    - After reversing the pointer, we move the prev, current, and nextTemp pointers one step forward.

- Repeat this process until we reach the end of the original list (i.e., current becomes null).

- Once the loop exits, prev will be pointing to the new head of the reversed list. Return prev.


*/
