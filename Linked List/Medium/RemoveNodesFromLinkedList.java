/*

Difficulty: Medium

You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.

Example 1:

Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.

Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.

*/

class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        current = stack.pop();
        int maximun = current.val;
        ListNode resultList = new ListNode(maximun);

        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current.val < maximun) {
                continue;
            } else {
            ListNode newNode = new ListNode(current.val);
            newNode.next = resultList;
            resultList = newNode;
            maximun = current.val;
            
            }
        }
         return resultList;
    }
}


/*

/* Time and Space complexity
TC: O(n)
The code iterates through the linked list once to push all nodes onto a stack, then iterates through the stack once
to create a new linked list with nodes in non-decreasing order. Both iterations have a time complexity of O(n), resulting 
in an overall time complexity of O(n).
SC:0(n)

Aproach 1 Using Stack 

- The list we are given is a singly linked list, so we can't easily traverse it in reverse from tail to head.

- Whenever a problem requires reversing a sequence, it is worth considering using a stack.

- Stacks are a First-In-Last-Out (FILO) data structure, meaning that the first items added to the stack are the last ones removed. Consequently, 
if you push a sequence of items into a stack and then remove them, the sequence will be reversed.
- We start by adding all of the nodes to a stack.

- Next, we create a new linked list to store the result. We keep track of the maximum node value encountered so far using the variable maximum.

- Then, we pop each node from the stack. If the node's value is not smaller than the maximum, we create a new node with that value and add it to the resultList. 
Since the linked list is reversed, we build the resultList from back to front, continuously adding new nodes to the beginning.

*/

class Solution {
    private ListNode reverseList(ListNode head) {
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
    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);

        int maximum = 0;
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            maximum = Math.max(maximum, current.val);

            if (current.val < maximum) {
                prev.next = current.next;
                ListNode deleted = current;
                current = current.next;
                deleted.next = null;

            } else  {
                prev = current;
                current = current.next;
            }
        }
        return reverseList(head);
    }
}

/*

Aproach 2 Reversing twice the List without using Stack

- The first approach used a stack to reverse the linked list, resulting in linear auxiliary space. However, instead of using a stack, we can 
write a function to reverse the nodes in place, avoiding the need for auxiliary space.

- The basic idea is to set each node's next field to point to the previous node.

- After reversing the linked list, the node values will be in increasing order, allowing us to delete any nodes whose values are smaller than the nodes preceding them.

- To facilitate this process, we maintain the maximum node value found so far using the variable maximum.

- We traverse each node, current, in the reversed linked list and update the maximum value accordingly. If the value of the current node is smaller than the maximum, we 
delete current. Deleting nodes in place requires us to track the previous node so that we can correctly link it to the next node if we delete the current node.

- Once we have traversed the linked list to delete the nodes, we have a linked list that is in increasing order.

- However, since the desired result should be in decreasing order, we reverse the modified linked list and then return it.


*/
