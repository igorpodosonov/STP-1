import java.util.Arrays;

public class MySortLib {
    private long timeStart;
    private long memoryStart;
    private long timeEnd;
    private long memoryEnd;

    public int[] bubbleSort(int[] array) {
        measureStart();

        int loops = 0;
        for (int i = 0; i < array.length; i++) {
            int swaps = 0;
            for (int j = 1; j < array.length - loops; j++) {
                if(array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    swaps++;
                }
            }
            loops++;

            if(swaps == 0)
                break;
        }

        measuresEnd();
        System.out.println("Bubble sort run time: " + getTime() + " ms, memory usage: " + getMemory());

        return array;
    }

    public int[] oddEvenSort(int[] array) {
        measureStart();

        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for (int i = 1; i < array.length - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }

            for (int i = 0; i < array.length - 1; i += 2) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }

        measuresEnd();
        System.out.println("Odd-even sort run time: " + getTime() + " ms, memory usage: " + getMemory());

        return array;
    }

    public int[] cycleSort(int[] array) {
        measureStart();

        for (int i = 0; i < array.length; i++) {
            int val = array[i];

            int pos = i;
            for (int j = pos + 1; j < array.length; j++) {
                if(array[j] < val) {
                    pos++;
                }
            }

            if(pos == i)
                continue;

            while (val == array[pos])
                pos++;

            int tmp = array[pos];
            array[pos] = val;
            val = tmp;

            while (pos != i) {
                pos = i;
                for (int j = i + 1; j < array.length; j++) {
                    if(array[j] < val)
                        pos++;
                }

                while (val == array[pos])
                    pos++;

                tmp = array[pos];
                array[pos] = val;
                val = tmp;
            }
        }

        measuresEnd();
        System.out.println("Cycle sort run time: " + getTime() + " ms, memory usage: " + getMemory());

        return array;
    }

    private int[] quickSortArray;

    public int[] quickSort(int[] array) {
        measureStart();

        if (array == null || array.length == 0) {
            return array;
        }

        this.quickSortArray = array;
        quickSortOperation(0, quickSortArray.length - 1);

        measuresEnd();
        System.out.println("Quick sort run time: " + getTime() + " ms, memory usage: " + getMemory());

        return this.quickSortArray;
    }

    private void quickSortOperation(int low, int high) {
        int i = low, j = high;
        int middleElement = quickSortArray[low + (high-low)/2];

        while (i <= j) {
            while (quickSortArray[i] < middleElement) {
                i++;
            }

            while (quickSortArray[j] > middleElement) {
                j--;
            }

            if (i <= j) {
                int temp = quickSortArray[i];
                quickSortArray[i] = quickSortArray[j];
                quickSortArray[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSortOperation(low, j);
        if (i < high)
            quickSortOperation(i, high);
    }

    public int[] standartSorter(int[] array) {
        measureStart();

        Arrays.sort(array);

        measuresEnd();
        System.out.println("Standart sort run time: " + getTime() + " ms, memory usage: " + getMemory());
        return array;
    }

    private void measureStart() {
        timeStart = System.nanoTime();
        memoryStart = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    private void measuresEnd() {
        timeEnd = System.nanoTime();
        memoryEnd = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    private long getTime() {
        return timeEnd - timeStart;
    }

    private long getMemory() {
        return memoryEnd - memoryStart;
    }
}