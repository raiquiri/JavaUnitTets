package org.example;

public class Gauss {
    public static double[] methodGauss(double[][] matrix, double[] vector) throws Exception {
        if (matrix.length != vector.length){
            throw new MatrixException("Ошибка размерности");
        }

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

            if (Math.abs(matrix[i][i]) < 1e-9) {
                if (Math.abs(vector[i]) < 1e-9) {
                    throw new MatrixException("Система имеет множество решений");
                }
                throw new MatrixException("Система не имеет решения");
            }
            // прямой ход
            for (int j = i+1; j < len; j++){
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i; k < len; k++){
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
    public static class MatrixException extends Exception {
        public MatrixException(String massege){
            super(massege);
        }
    }
}
