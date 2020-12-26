public class SolutionGoogle {
    public static int minimumStepsToOne(int num) {
        return minimumStepsToOneHelper(num, 0);
    }

    public static int minimumStepsToOneHelper(int num, int operations) {
        int total;
        if(num == 1){
            return operations;
        }
        if(iSDivisibleByThree(num)){
            total = Math.min(minimumStepsToOneHelper(num/3, operations+1), minimumStepsToOneHelper(num/2, operations+1));
        }
        else if (iSDivisibleByTwo(num)){
            total = Math.min(minimumStepsToOneHelper(num/2, operations+1), minimumStepsToOneHelper(num-1, operations+1));
        }
        else{
            total = minimumStepsToOneHelper(num-1, operations+1);
        }
        return total;
    }

    public static boolean iSDivisibleByThree(int num)
    {
        return num % 3 == 0;
    }
    public static boolean iSDivisibleByTwo(int num)
    {
        return num % 2 == 0;
    }


    public static void main(String[] args) {
       int n = minimumStepsToOne(5678);
        System.out.println(n);
    }

}
