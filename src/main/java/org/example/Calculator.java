package org.example;

public class Calculator {
    public static double[] methodGauss(double[][] matrix, double[] vector){
        int len = matrix.length;

        for (int i = 0; i < len; i++){
            int maxIndex = i;
            // определение главного элемента
            for (int j = i+1; j < len; j++){
                if (Math.abs(matrix[j][i]) > Math.abs(matrix[maxIndex][i])){
                    maxIndex = j;
                }
            }
            // перестанвка строк и элементов
            double[] tempMatrix = matrix[i];
            matrix[i] = matrix[maxIndex];
            matrix[maxIndex] = tempMatrix;
            double tempVector = vector[i];
            vector[i] = vector[maxIndex];
            vector[maxIndex] = tempVector;

            // прямой ход
            for (int j = i+1; j < len; j++){
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i; i < len; k++){
                    matrix[j][k] -= factor * matrix[i][k];
                }
                vector[j] -= factor * vector[i];
            }
        }
        double[] x = new double[len];
        for (int i = 0; i < len; i++){
            x[i] = 0;
        }
        // обратный ход
        for (int i = len - 1; i > -1; i--){
            x[i] = vector[i] / matrix[i][i];
            for (int j = i - 1; j > -1; j--){
                vector[j] -= matrix[j][i] * x[i];
            }
        }
        return x;
    }

    public static int[] sortShaker(int[] array){
        int left = 0, right = array.length - 1, temp;
        while(left < right) {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i-1] > array[i]) {
                    temp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = temp;
                }
            }
            left++;
        }

        return array;
    }

    public static double[] sortShaker(double[] array) {
        int left = 0, right = array.length - 1;
        double temp;
        while (left < right) {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i - 1] > array[i]) {
                    temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                }
            }
            left++;
        }

        return array;
    }

    public static int[] sortComb(int[] array) {
        int step = array.length;
        boolean check = true;

        while (step > 1 || check) {
            if (step > 1) {
                step = (int) (step/1.247);
            }
            check = false;
            for (int i = step; i < array.length; i++) {
                if (array[i-step] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i-step];
                    array[i-step] = temp;
                    check = true;
                }
            }
        }

        return array;
    }

    public static double[] sortComb(double[] array) {
        int step = array.length;
        boolean check = true;

        while (step > 1 || check) {
            if (step > 1) {
                step = (int) (step/1.247);
            }
            check = false;
            for (int i = step; i < array.length; i++) {
                if (array[i-step] > array[i]) {
                    double temp = array[i];
                    array[i] = array[i-step];
                    array[i-step] = temp;
                    check = true;
                }
            }
        }

        return array;
    }

    public static int[] sortInsert(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            int j = i;
            while (j > 0 && array[j-1] > num) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = num;
        }

        return array;
    }

    public static double[] sortInsert(double[] array) {
        for (int i = 1; i < array.length; i++) {
            double num = array[i];
            int j = i;
            while (j > 0 && array[j-1] > num) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = num;
        }

        return array;
    }

    public static int[] sortChoose(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }

    public static double[] sortChoose(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            double temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }
}