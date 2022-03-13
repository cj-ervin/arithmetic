package com.cjervin.arithmetic.arithmetic.array;

/**
 * 二位数组
 *
 * @author ervin
 * @Date 2022/3/13
 */
public class TDArray {


    /**
     * 旋转图像
     * 将图像顺时针旋转 90 度
     * <p>
     * https://leetcode-cn.com/problems/rotate-image/solution/xuan-zhuan-tu-xiang-by-changxiaojie-2alw/
     *
     * @param matrix 源图像
     */
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        //按照左上到右下的对角线进行镜像对称
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //然后反转二维矩阵的每一行
        for (int[] arr : matrix) {
            int i = 0, j = arr.length - 1;
            while (j > i) {
                // swap(arr[i], arr[j]);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }


    }

}
