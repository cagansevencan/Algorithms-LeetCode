import java.util.Arrays;

public class EveryThird {
    public static void PrintThird(int[] array, int i) {
        if(i >= array.length){
            return;
        }
        System.out.println(array[i+2]);
        PrintThird(array, i+3);
    }

    public static void main(String[] args) {
    int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    PrintThird(array, 0);
    }
}
