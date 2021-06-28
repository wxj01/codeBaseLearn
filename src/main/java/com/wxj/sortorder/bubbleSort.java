package com.wxj.sortorder;

import java.util.Arrays;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO 冒泡排序
 * @date 2021/6/22 0022 14:03
 */
public class bubbleSort {

    public static void main(String[] args) {
        int[] arr = {67,9,22,34,94,25,58};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] bubbleSort(int[] arr){
        if(arr.length == 0){
            return arr;
        }

        int temp ;
        for (int i = 0 ; i < arr.length; i++){
            for (int j = i;j < arr.length -1 -i;j++){

                if(arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}