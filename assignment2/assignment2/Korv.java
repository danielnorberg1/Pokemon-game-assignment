package assignment2;

import javax.sound.sampled.SourceDataLine;

public class Korv {
public static void main(String[] args) {
    double[][] A = {{1.00,1.00},{9.00,2.00}};
    double[][] B = {{-2.00,-3.00},{-3.00,-2.00}};
    double[][] C = matrix(A, B);

    //for (int i = 0; i < 10; i++){
    //    System.out.println(C[0][i] + " "+ C[1][i]);
    //}
}


public static double[][] matrix(double[][] A, double[][] B) {
int aRows = A.length;
int aColumns = A[0].length;
int bRows = B. length;
int bColumns = B [0].length;
if (aColumns != bRows) {
    throw new IllegalArgumentException ("A: Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
}

double [][] C = new double[aRows][bColumns];
for (int i = 0; i < 2; i++) {
   for (int j = 0; j < 2; j++) {
      C[i][j] = 0.00000;
   }
}

for (int i = 0; i < aRows; i++) { // aRow
    for (int j = 0; j < bColumns; j++) { // bColumn
        for (int k = 0; k < aColumns; k++) { // aColumn
            C[i][j] += A[i][k] * B[k][j];
        }
    }
}
for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 2; j++) {
        System.out.println(C[i][j]);
    }
}
return C;
}
}
