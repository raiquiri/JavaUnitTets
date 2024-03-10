package org.example;

import static org.example.Sort.*;
import static org.example.Gauss.methodGauss;
public class test {
    public static void main(String[] args) throws Exception {
        final double[][] array = new double[][] {{3,2,-5}, {2,-1,3}, {1,2,-1}};
        final double[] vector = new double[] {-1,13,9};
        double[] result = methodGauss(array,vector);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
