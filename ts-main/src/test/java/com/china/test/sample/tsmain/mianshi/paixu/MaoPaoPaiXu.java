package com.china.test.sample.tsmain.mianshi.paixu;

import org.junit.Test;

/**
 * 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
 * <p>
 * 算法描述
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3. 针对所有的元素重复以上的步骤，除了最后一个；
 * 4. 重复步骤1~3，直到排序完成。
 */
public class MaoPaoPaiXu {

    int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    @Test
    public void TestMaoPaoPaiXu() {
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        printArr();
    }

    /**
     * 优化版本
     */
    @Test
    public void TestMaoPaoPaiXu2() {
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            boolean isSwap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwap = true;
                }
            }

            if (!isSwap) {
                break;
            }
        }

        printArr();
    }

    public void printArr() {
        int temp = 0;
        for (int i : arr) {
            System.out.print(i);
            if (temp < arr.length - 2) {
                System.out.print(",");
            }
        }
    }
}
