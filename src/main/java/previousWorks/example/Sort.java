package previousWorks.example;

public class Sort {

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