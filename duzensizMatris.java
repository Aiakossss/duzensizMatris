package odev;

import java.util.Arrays;
import java.util.Random;

public class duzensizMatris {
    public static void main(String[] args) {
       
        int[] sizes = new int[2]; 
        int[][][] arrays = new int[2][][]; 
        Random random = new Random();

      
        for (int i = 0; i < 2; i++) {
            sizes[i] = random.nextInt(6); 
            arrays[i] = new int[sizes[i]][];

            System.out.println("Dizi " + (i + 1) + " oluşturuldu, boyut: " + sizes[i]);

            for (int j = 0; j < sizes[i]; j++) {
                arrays[i][j] = new int[random.nextInt(6)]; 
               
                System.out.print("Dizi " + (i + 1) + ", İç Dizi " + (j + 1) + ": ");
                for (int k = 0; k < arrays[i][j].length; k++) {
                    arrays[i][j][k] = random.nextInt(101); 
                    System.out.print(arrays[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        
        int sum = multiplyAndSum(arrays[0], arrays[1]);
        System.out.println("İki dizinin çarpılarak toplanmış sonucu: " + sum);
    }

 
    public static int multiplyAndSum(int[][] array1, int[][] array2) {
        int sum = 0;
       
        for (int[] row1 : array1) {
            for (int[] row2 : array2) {
                Arrays.sort(row1);
                Arrays.sort(row2);
                int product = multiplyArrays(row1, row2);
                sum += product;
            }
        }
        return sum;
    }

  
    public static int multiplyArrays(int[] array1, int[] array2) {
        int product = 0;
        int minLength = Math.min(array1.length, array2.length);
        for (int i = 0; i < minLength; i++) {
            product += array1[i] * array2[i];
        }
        return product;
    }
}
