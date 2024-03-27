/*
Difficulty: Medium

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(word);
        }
        return new ArrayList<>(map.values());
    }
}

/* Time and Space complexity

TC: O(n * k log k)
The code iterates through each word in the input array of length n. For each word, it sorts the characters which takes O(k log k) time complexity, 
where k is the length of the word. Therefore, the overall time complexity is O(n * k log k).
SC: O(n * k)


Aproach

Initialize a HashMap:
The code begins by initializing a HashMap named map. This HashMap will store sorted strings as keys and corresponding lists of anagrams as values. The key idea here is to group anagrams together based on their sorted representation.

Iterate Through the Input Array:
The code then iterates through each word in the input array strs. This array contains strings representing various words.

Sort Each Word:
For each word, the code converts it into a character array using toCharArray() method.
It then sorts the character array using Arrays.sort() method. Sorting the characters of a word ensures that anagrams of the word will have the same sorted representation.

Add Word to HashMap:
After sorting the characters, the code creates a new string sorted from the sorted character array.
It checks if the HashMap map already contains the sorted string sorted as a key.
If the sorted string is not present as a key, it adds a new entry to the HashMap with the sorted string as the key and a new ArrayList as the value.
If the sorted string is already present as a key, it retrieves the corresponding list of anagrams from the HashMap.

Group Anagrams:\
Finally, the code adds the original word to the list of anagrams associated with the sorted string in the HashMap.
This process continues for each word in the input array, effectively grouping anagrams together in the HashMap.

Return Grouped Anagrams:
Once all words have been processed, the code constructs a new ArrayList containing all the values (lists of anagrams) from the HashMap.
This ArrayList contains groups of anagrams, where each group is represented by a list of words.

*/
