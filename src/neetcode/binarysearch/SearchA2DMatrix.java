package neetcode.binarysearch;

/**
 * 문제 : Search a 2D Matrix
 * https://neetcode.io/problems/search-2d-matrix?list=neetcode150
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {

        boolean result = new SearchA2DMatrix().searchMatrix(new int[][]{new int[]{1, 2, 4, 8}, new int[]{10, 11, 12, 13}, new int[]{14, 20, 30, 40}}, 25);
        System.out.println("result = " + result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int row = 0;
        int col = colCount - 1;

        while (row < rowCount && col >= 0) {
            int currentValue = matrix[row][col];

            if (currentValue == target)
                return true;

            else if (currentValue > target)
                col--;

            else
                row++;
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {

        int startIndex = 0;
        int endIndex = matrix.length - 1;

        while (true) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            int[] row = matrix[midIndex];


            if (target < row[0]) {
                endIndex = midIndex - 1;
                continue;
            } else if (target > row[row.length - 1]) {
                startIndex = midIndex + 1;
                continue;
            }

            return (search(row, target));
        }
    }

    private boolean search(int[] row, int target) {

        int startIndex = 0;
        int endIndex = row.length - 1;

        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;

            if (row[midIndex] == target) {
                return true;
            } else if (row[midIndex] < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }
        }

        return false;
    }
}
