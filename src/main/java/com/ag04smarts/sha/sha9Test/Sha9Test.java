package com.ag04smarts.sha.sha9Test;

import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class Sha9Test {

    public static void test() {
        double[][] matrica = {{1d, 2d, 3d}, {2d, 5d, 3d}, {5d, 6d, 21d}};

        RealMatrix m = MatrixUtils.createRealMatrix(matrica);

        System.out.println(m);
        System.out.println(new LUDecomposition(m).getSolver().getInverse());
    }
}
