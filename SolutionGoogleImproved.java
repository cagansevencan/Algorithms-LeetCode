public class SolutionGoogleImproved {
    public static int minimumStepsToOne(int num) {
        return minimumStepsToOneHelper(num);
    }
    int count =0;

    public static int minimumStepsToOneHelper(int num) {
        int total;
        if(num == 1){
            return 0;
        }
        //sub1
         total = minimumStepsToOneHelper(num-1);

        //divby2
        if(num % 2 == 0){
            int divby2 = minimumStepsToOneHelper(num/2);
            total = Math.min(total, divby2);
        }

        if(num % 3 == 0){
            int divby3 = minimumStepsToOneHelper(num/3);
            total = Math.min(total, divby3);
        }
        int result = 1 + total;
        return result;
    }


    public static void main(String[] args) {
        int n = minimumStepsToOne(15);
        System.out.println(n);
    }

}
