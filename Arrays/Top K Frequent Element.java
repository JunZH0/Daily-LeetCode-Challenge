/* 
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 
Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 
Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size. 

*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int num : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            if (buckets[i] != null) {
                result.addAll(buckets[i]);
            }
        }
        
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = result.get(i);
        }
        
        return topK;
    }
}

/* Time and Space complexity
TC: O(n)
The code iterates through the input array 'nums' to create a frequency map, which takes O(n) time. Then, it iterates through the frequency map to create buckets, 
which also takes O(n) time. Finally, it iterates through the buckets to create the result list, which takes O(n) time. Therefore, the overall time complexity is O(n).

SC: O(n + k)


Aproach

Create a Frequency Map:
Iterate through the input array nums and create a HashMap named frequencyMap.
For each element num in nums, increment its frequency count in the frequencyMap.
After this step, frequencyMap contains each unique element from nums as keys and their corresponding frequencies as values.

Bucket Sort Based on Frequency:
Create an array of ArrayLists named buckets to store elements based on their frequencies.
Iterate through the keys of the frequencyMap.
For each key (element) in frequencyMap, retrieve its frequency.
Use the frequency as an index in the buckets array and add the element to the corresponding ArrayList.
After this step, buckets[i] contains all elements with frequency i.

Find Top K Frequent Elements:
Iterate through the buckets array from the end (highest frequency) towards the start.
While iterating, keep adding elements from each non-null ArrayList in buckets to a result List until the size of the result List reaches K or all elements are exhausted.
This step ensures that elements with higher frequencies are added to the result List first.

Create and Return Result Array:
Create an array topK of size K to store the top K frequent elements.
Copy the first K elements from the result List into the topK array.
Return the topK array containing the top K frequent elements.

*/

/* 

Priority Queue approach

*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer, Integer> map = new HashMap();

       for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
       }

       PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(Map.Entry entry : map.entrySet()) {
            pq.add(entry);
        }

        int[] output = new int[k];
        for(int i = 0; i < k; i++) {
            output[i] = pq.poll().getKey();
        }
        return output;
    }    
}

/* Time and Space complexity
TC: O(n log k)
The time complexity is O(n) for building the frequency map, and O(k log k) for adding elements to the priority queue and retrieving the top k elements. 
Therefore, the overall time complexity is O(n log k).

SC: O(n)


Aproach

Count Frequencies:
The code starts by iterating through the input array nums and counts the frequency of each element using a HashMap named map.
In the HashMap map, each key represents a unique element from nums, and its corresponding value represents the frequency of that element.

Building the MaxHeap (PriorityQueue):
After counting frequencies, the code initializes a PriorityQueue (pq) to store entries from the HashMap map.
The PriorityQueue is configured as a maxHeap, where entries with higher frequencies are prioritized.
The maxHeap comparator is defined such that entries with higher values (frequencies) come before entries with lower values.
As we iterate through the entries of the map, each entry (key-value pair) is added to the maxHeap.

Extracting Top K Frequent Elements:
Once all entries are added to the maxHeap, we retrieve the top k frequent elements.
We create an array output of size k to store the top K frequent elements.
We repeatedly extract the top element (entry with the highest frequency) from the maxHeap using pq.poll() and store its key (element) in the output array.
Since we have a maxHeap, the top element (entry with the highest frequency) is always the one with the maximum frequency among the top k elements.
Finally, we return the output array containing the top K frequent elements.

*/
