public class PermuteString {
    //Recursive Algo
    //Produces all permutations by swapping one element per iteration
    public static <T> void printAllRecursive(T[] elements, char delimiter){
        printAllRecursive(elements.length, elements, delimiter);
    }


    public static <T> void printAllRecursive(int n, T[] elements, char delimiter){
        if(n == 1){
            printArray(elements, delimiter);
        }else{
            for(int i =0; i < n -1; i++){
                printAllRecursive(n-1, elements, delimiter);
                if(n % 2 == 0){
                    swap(elements, i , n -1);
                }else{
                    swap(elements, 0 , n-1);
                }
            }
            printAllRecursive(n-1, elements, delimiter);
        }
    }

    private static  <T> void printArray(T[] elements, char delimiter){
        String delimiterSpace = delimiter + " ";
        for(int i =0; i< elements.length; i++){
            System.out.print(elements[i] + delimiterSpace);
        }
        System.out.print('\n');
    }

    private static <T> void swap(T[] elements, int a, int b){
        T tmp = elements[a];
        elements[a] = elements[b];
        elements[b] = tmp;
    }

    //Function to print all the permutations of str
    static void printPermute(String str, String ans){
        if(str.length() == 0){
            System.out.println(ans + " ");
            return;
        }

        for(int i = 0; i < str.length(); i++){
            //ith character of the string
            char ch = str.charAt(i);

            //Rest of the string after excluding the ith character
            String ros = str.substring(0, i) + str.substring(i+1);

            //Recursive call
            printPermute(ros, ans + ch);
        }
    }

    

    public static void main(String[] args) {
        Integer[] elements = {1,2,3,4};

        System.out.println("Recursive: ");
        printAllRecursive(elements, ';');

        String s = "boat";
        printPermute(s, "");
    }
}
