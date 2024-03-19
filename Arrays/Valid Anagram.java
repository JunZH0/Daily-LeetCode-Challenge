/*
Difficulty: Easy

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

 
Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.

 
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
*/


class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}

/* Time and Space complexity
TC: O(n log n)
This approach has a time complexity of O(n log n), where n is the length of the longer of the two input strings s and t. 
This is because sorting the character arrays takes O(n log n) time complexity, where n is the length of the arrays.
SC:0(n)


Aproach

Convert the input strings s and t into character arrays sArray and tArray respectively using the toCharArray method. This allows you to work with individual characters of the strings.

Sort both character arrays sArray and tArray using Arrays.sort method. Sorting the arrays ensures that if the strings are anagrams, they will have the same characters in the same order after sorting.

Compare the sorted arrays using Arrays.equals method. If the sorted arrays are equal, it means that the original strings s and t are anagrams of each other, so return true. Otherwise, they are not anagrams, so return false.

** Faster approach below **
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] arr = new int[26];
        for(char c: s.toCharArray()) {
            arr[c-'a']++;
        }
        for(char c: t.toCharArray()) {
            if(arr[c-'a'] <= 0) return false;
            arr[c-'a']--;
        }
        for(int i=0; i<26; i++) {
            if(arr[i] != 0) return false;
        }
        return true;
    }
}

/* Time and Space complexity
TC: O(n)
This approach also has a time complexity of O(n), where n is the length of the input strings s and t, as it only requires traversing each string once and updating the character frequencies in the array. 
SC:0(n)


* Aproach *

If the lengths of the two input strings s and t are not equal, return false, as strings of different lengths cannot be anagrams.

Create an integer array arr of size 26 to store the frequency of characters. We assume that the strings only contain lowercase English letters.

Traverse string s and increment the frequency of each character in the array arr.

Traverse string t and decrement the frequency of each character in the array arr. If any character frequency becomes negative during this process, it means that the character occurs more times in string t than in string s, so return false.

After traversing both strings, check if all character frequencies in the array arr are zero. If any frequency is non-zero, return false, indicating that the strings are not anagrams.

If all character frequencies are zero, return true, indicating that the strings are anagrams.


*/

