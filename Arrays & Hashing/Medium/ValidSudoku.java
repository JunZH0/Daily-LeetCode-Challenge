/*

Difficulty: Medium

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in column " + j) ||
                        !seen.add(number + " in block " + i / 3 + "-" + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


/*
Time and space complexity

TC: O(1)
The code iterates through each cell in a 9x9 Sudoku board, performing constant time operations for each cell. Therefore, the time complexity is O(1)
SC: 0(1)

Aproach

Initialize a HashSet named seen to keep track of seen elements.

Iterate through each cell of the Sudoku board using two nested loops.

For each cell, retrieve the current digit (number) from the board.

If the current digit is not '.', indicating an empty cell:
Check if the current digit is already present in the HashSet for the respective row, column, or 3x3 block.

If the digit is already in the HashSet, it indicates a duplicate, and the Sudoku board is invalid, so return false.
Otherwise, add the current digit to the HashSet for the row, column, and 3x3 block.

If all cells have been iterated over without finding any duplicates, return true, indicating that the Sudoku board is valid.
*/
