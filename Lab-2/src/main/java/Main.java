import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = reader.nextInt();

        int[] mainArray = new int[n];

        //Fill array with user numbers
        for (int i = 0; i < n; i++) {
            System.out.print("Enter next number in array: ");
            mainArray[i] = reader.nextInt();
        }

        System.out.println("Geometric mean of paired array elements: " + geometricMeanOfPairedEl(mainArray));
        System.out.println("Largest number by module: " + largestNumberByModule(mainArray));
        System.out.println("Maximum paired item: " + maximumPairedItem(mainArray));
        System.out.println("Module-minimized element: " + moduleMinimizedElement(mainArray));
        System.out.println("Sum of in the interval [0; 10]: " + sumOfFirstTenItems(mainArray));

        System.out.print("Enter matrix size: ");
        n = reader.nextInt();
        reader.close();

        int[][] mainMatrix = new int[n][n];

        //Fill matrix with random numbers and output it on a screen
        Random rnd = new Random();
        for (int i = 0; i < mainMatrix.length; i++) {
            for (int j = 0; j < mainMatrix[i].length; j++) {
                mainMatrix[i][j] = rnd.nextInt();
            }
        }
        System.out.println("Your generated matrix: ");
        for (int i = 0; i < mainMatrix.length; i++) {
            for (int j = 0; j < mainMatrix[i].length; j++) {
                String divider = " ";
                if(j == mainMatrix[i].length - 1) {
                    divider = "\n";
                }
                System.out.print(mainMatrix[i][j] + divider);
            }
        }

        if(n == 9) {
            int[][] transformdedMatrix = transformMatrix(mainMatrix);

            System.out.println("Your transformed matrix: ");
            for (int i = 0; i < transformdedMatrix.length; i++) {
                for (int j = 0; j < transformdedMatrix[i].length; j++) {
                    String divider = " ";
                    if(j == transformdedMatrix[i].length - 1) {
                        divider = "\n";
                    }
                    System.out.print(transformdedMatrix[i][j] + divider);
                }
            }
        } else {
            System.out.println("Sum of elements witch located below main diagonal and their row starts with negative element: " + matrixSumBelow(mainMatrix));
            System.out.println("Sum of elements witch located above main diagonal and their row starts with negative element: " + matrixSumAbove(mainMatrix));
        }
    }

    public static int[][] transformMatrix(int[][] matrix) {
        int[][] transformedMatrix = new int[matrix.length][matrix[0].length];

        //Transform matrix by the rules
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int currentElement = matrix[i][j];
                int mainDiagElement = matrix[i][i];
                if(currentElement > mainDiagElement) {
                    transformedMatrix[i][j] = 1;
                } else {
                    transformedMatrix[i][j] = 0;
                }
            }
        }

        return transformedMatrix;
    }

    public static int matrixSumAbove(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] < 0) {
                for (int j = matrix[i].length - 1; j > i; j--) {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }

    public static int matrixSumBelow(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] < 0) {
                for (int j = 0; j < i; j++) {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }
    
    public static int sumOfFirstTenItems(int[] array) {
        int sum = 0;
        int count = 0;

        if (array.length > 10) {
            count = 10;
        } else {
            count = array.length;
        }

        for (int i = 0; i < count; i++) {
            sum += array[i];
        }

        return sum;
    }

    public static int moduleMinimizedElement(int[] array) {
        int moduleMinimizedElement = array[0];

        for (int i = 0; i < array.length; i++) {
            if(moduleMinimizedElement > Math.abs(array[i])) {
              moduleMinimizedElement = Math.abs(array[i]);
            }
        }

        return moduleMinimizedElement;
    }

    public static int maximumPairedItem(int[] array) {
        int maxPairedItem = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 0 && array[i] > maxPairedItem) {
               maxPairedItem = array[i];
            }
        }

        return maxPairedItem;
    }

    public static int largestNumberByModule(int[] array) {
        int largestNum = 0;

        for (int i = 0; i < array.length; i++) {
            if(Math.abs(array[i]) > largestNum) {
                largestNum = Math.abs(array[i]);
            }
        }

        return largestNum;
    }

    public static double geometricMeanOfPairedEl(int[] array){
        double count = 0; //count of paired elements
        double multiply = 1; //multiply of all paired elements

        for (int i = 0; i < array.length; i++) {
            if((array[i] % 2) == 0){
                multiply *= array[i];
                count += 1;
            }
        }

        return Math.pow(multiply, (1/count));
    }
}