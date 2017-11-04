import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] mainArray = initRandomArray(30000);

        MySortLib sort = new MySortLib();

        for (int i = 0; i < 3; i++) {
            sort.bubbleSort(mainArray);
        }

        for (int i = 0; i < 3; i++) {
            sort.cycleSort(mainArray);

        }

        for (int i = 0; i < 3; i++) {
            sort.oddEvenSort(mainArray);

        }

        for (int i = 0; i < 3; i++) {
            sort.quickSort(mainArray);
        }

        for (int i = 0; i < 3; i++) {
            sort.standartSorter(mainArray);
        }
    }

    private static int[] initRandomArray(int size) {
        int[] array = new int[size];

        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt();
        }

        return array;
    }
}