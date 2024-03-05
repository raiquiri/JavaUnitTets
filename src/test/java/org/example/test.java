package org.example;

import static org.example.Calculator.*;

public class test {
    public static void main(String[] args) {
        int[] array = new int[] {4,5,1,2,3,9,7,10,8,6};
        sortChoose(array);
        for (int i =0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
