package com.china.test.sample.tsmain.mianshi.paixu;

import org.junit.Test;

/**
 * 快速排序是一个知名度极高的排序算法，其对于大数据的优秀排序性能和相同复杂度算法中相对简单的实现使它注定得到比其他算法更多的宠爱。
 * <p>
 * 1.从数列中挑出一个元素，称为"基准"（pivot），
 * <p>
 * 2.重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * <p>
 * 3.递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * <p>
 */
public class KuaiSuPaiXu {
    int[] arr = new int[]{21, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

    @Test
    public void PaiXu() {
        quickSort(arr, 0, arr.length - 1);
        printArr();
    }

    private void quickSort(int[] a, int start, int end) {
        if (start > end) {
            return;
        }

        int pivot = partition(a, start, end);
        quickSort(a, start, pivot - 1);
        quickSort(a, pivot + 1, end);
    }

    private int partition(int[] a, int start, int end) {
        int left = start;
        int right = end;
        int pivot = a[start];
        int index = start;

        while (right >= left) {
            while (right >= left) {
                if (a[right] < pivot) {
                    a[left] = a[right];
                    index = right;
                    left++;
                    break;
                }

                right--;
            }

            while (right >= left) {
                if (a[left] > pivot) {
                    a[right] = a[left];
                    index = left;
                    right--;
                    break;
                }

                left++;
            }
        }

        a[index] = pivot;

        return index;
    }

    public void printArr() {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}