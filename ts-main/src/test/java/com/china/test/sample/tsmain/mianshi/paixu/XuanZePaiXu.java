package com.china.test.sample.tsmain.mianshi.paixu;

import org.junit.Test;

/**
 * 选择排序是一种简单直观的排序算法，它也是一种交换排序算法，和冒泡排序有一定的相似度，可以认为选择排序是冒泡排序的一种改进。
 * <p>
 * 算法描述
 * 1. 在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
 * 2. 从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * 3. 重复第二步，直到所有元素均排序完毕。
 */
public class XuanZePaiXu {
    int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    @Test
    public void PaiXu() {
        XuanZe();
        printArr();
    }

    private void XuanZe() {
        int temp, min = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            if (min != i) {
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }

        }
    }

    public void printArr() {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
    }
}
