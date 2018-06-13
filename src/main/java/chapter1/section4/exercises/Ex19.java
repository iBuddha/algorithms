package chapter1.section4.exercises;

import std.StdOut;

/**
 * 矩阵的局部最小元素。NxN数组。运行时间最坏情况下和N成正比。
 */
public class Ex19 {
    private static class Position{
        int row;
        int col;
        public Position(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString(){
            return "{row: " + row + " col: " + col + "}";
        }
    }
    public static Position matrixLocalMinimum(int[][] a, int rowLo, int rowHi, int columnLo, int columnHi){
        if(rowHi - rowLo + 1 <= 3 || columnHi - columnLo + 1 <= 3){
            //遍历这个子矩阵，找到其中的最小值，即是全局最小值
            int min = Integer.MAX_VALUE;
            int row = -1;
            int col = -1;
            for(int i = rowLo; i <= rowHi; i++){
                for(int j = columnLo; j <= columnHi; j++){
                    if(a[i][j] <= min){
                        min = a[i][j];
                        row = i;
                        col = j;
                    }
                }
            }
            return new Position(row, col);
        }

        int midRow = rowLo + (rowHi - rowLo) / 2;
        int midCol = columnLo + (columnHi - columnLo) / 2;

        int rowMin = -1;//window的最小元素所在的行
        int colMin = -1;//window的最小元素所有在列

        int min = Integer.MAX_VALUE;
        for(int i = columnLo; i <= columnHi; i++){
            // for upper edge
            if(a[rowLo][i] <= min){
                min = a[rowLo][i];
                rowMin = rowLo;
                colMin = i;
            }
            //for middle edge
            if(a[midRow][i] <= min){
                min = a[midRow][i];
                rowMin = midRow;
                colMin = i;
            }

            // for lower edge

            if(a[rowHi][i] <= min){
                min = a[rowHi][i];
                rowMin = rowHi;
                colMin = i;
            }
        }

        //这样遍历对于缓存很不友好，应该按行遍历
        for(int i = rowLo; i <= rowHi; i++){
            //for left col
             if(a[i][columnLo] <= min){
                 min = a[i][columnLo];
                 rowMin = i;
                 colMin = columnLo;
             }
            //for mid col
            if(a[i][midCol] <= min){
                 min = a[i][midCol];
                 rowMin = i;
                 colMin = midCol;
            }

            //for right col
            if(a[i][columnHi] <= min){
                min = a[i][columnHi];
                rowMin = i;
                colMin = columnHi;
            }
        }

        //so we get the minimum of the window
        //search it's left and right
        int newRowLo;
        int newRowHi;
        int newColLo;
        int newColHi;
        int innerMinRow;//找到的位于1/4区域内部的小于window最小值的元素所在的row
        int innerMinCol;//找到的位于1/4区域内部的小于window最小值的元素所在的column
        if(rowMin - 1 >= rowLo && a[rowMin - 1][colMin] < min){
            innerMinRow= rowMin - 1;
            innerMinCol = rowMin;
        } else if(rowMin + 1 <= rowHi && a[rowMin + 1][colMin] < min){
            innerMinRow = rowMin + 1;
            innerMinCol = colMin;
        } else if(colMin - 1 >= columnLo && a[rowMin][colMin - 1] < min){
            innerMinRow = rowMin;
            innerMinCol = colMin -1;
        } else if(colMin + 1 <= columnHi && a[rowMin][colMin + 1] < min){
            innerMinRow = rowMin;
            innerMinCol = colMin + 1;
        } else
            return new Position(rowMin, colMin);

        if(innerMinRow > midCol){
            if(innerMinCol > midCol)
                return matrixLocalMinimum(a, midRow, rowHi, midCol, columnHi);
            else
                return matrixLocalMinimum(a, midRow, rowHi, columnLo, midCol);
        } else {
            if(innerMinCol > midCol)
                return matrixLocalMinimum(a, rowLo, midRow, midCol, columnHi);
            else
                return matrixLocalMinimum(a, rowLo, midRow, columnLo, midCol);
        }


    }

    public static Position matrixLocalMinimum(int[][] a){
        return matrixLocalMinimum(a, 0, a.length - 1, 0, a[0].length - 1);
    }

    // this test copy from https://github.com/reneargento/algorithms-sedgewick-wayne
    public static void main(String[] args) {
        int matrix1[][] = {{1}};
        int matrix2[][] = {{4, 1},
                {3, -2}};
        int matrix3[][] = {{5, 2, 3},
                {4, 6, 1},
                {7, 8, 9}};
        int matrix4[][] = {{5, 90, 3, 10},
                {4, -9, 1, 15},
                {7, -1, 9, 19},
                {12, 8, 13, 99}};
        int matrix5[][] = {{5, 90, 3, 10},
                {4,  1, -7, 15},
                {7, -1, -8, 19},
                {12, 8, 13, 99}};

        Position localMinimum1 = matrixLocalMinimum(matrix1);
        Position localMinimum2 = matrixLocalMinimum(matrix2);
        Position localMinimum3 = matrixLocalMinimum(matrix3);
        Position localMinimum4 = matrixLocalMinimum(matrix4);
        Position localMinimum5 = matrixLocalMinimum(matrix5);

        StdOut.println("Local Minimum Matrix: " + matrix1[localMinimum1.row][localMinimum1.col] + " Expected: 1");
        StdOut.println("Local Minimum Matrix: " + matrix2[localMinimum2.row][localMinimum2.col] + " Expected: -2");
        StdOut.println("Local Minimum Matrix: " + matrix3[localMinimum3.row][localMinimum3.col] + " Expected: 1"); //2 and 4 would also be valid
        StdOut.println("Local Minimum Matrix: " + matrix4[localMinimum4.row][localMinimum4.col] + " Expected: -9");
        StdOut.println("Local Minimum Matrix: " + matrix5[localMinimum5.row][localMinimum5.col] + " Expected: -8");
    }
}
