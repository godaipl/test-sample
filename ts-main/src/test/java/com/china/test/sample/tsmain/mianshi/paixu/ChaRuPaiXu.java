package com.china.test.sample.tsmain.mianshi.paixu;

import org.junit.Test;

/**
 * 插入排序是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 * <p>
 * 1. 把待排序的数组分成已排序和未排序两部分，初始的时候把第一个元素认为是已排好序的。
 * <p>
 * 2. 从第二个元素开始，在已排好序的子数组中寻找到该元素合适的位置并插入该位置。
 * <p>
 * 3. 重复上述过程直到最后一个元素被插入有序子数组中。
 */
public class ChaRuPaiXu {
    int[] arr = new int[] { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };

    @Test
    public void PaiXu() {
        ChaRu();
        // ChaRu2();
        printArr();
    }

    private void ChaRu() {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int position = i;

            while(position > 0 && arr[position - 1] > value) {
                arr[position] = arr[position - 1];
                position --;
            }

            arr[position] = value;
        }
    }

    private void ChaRu2() {
        for (int i = 0, j = i; i < arr.length - 1; j = ++i) {
            int ai = arr[i + 1];

            while (ai < arr[j]) {
                arr[j + 1] = arr[j];

                if (j-- == 0) {
                    break;
                }
            }

            arr[j + 1] = ai;
        }
    }

    public void printArr() {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
