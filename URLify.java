public class URLify {
        public static void replaceSpaces(String s, int trueLength){
            char[] str = s.toCharArray();
            int numberOfSpaces = countOfChar(str, 0 , trueLength, ' ');
            int newIndex = trueLength - 1 + numberOfSpaces * 2;


            /* If there are excess spaces, add a null char. This indicates that the
            spaces after that point have not been replaced with %20. */

            if(newIndex + 1 < str.length) str[newIndex + 1] = '\0';
            for(int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1){
                if(str[oldIndex] == ' '){ //Insert %20
                 str[newIndex] = '0';
                 str[newIndex-1] = '2';
                 str[newIndex-2] = '%';
                 newIndex -= 3;
                }else{
                    str[newIndex] = str[oldIndex];
                    newIndex -= 1;
                }
            }
        }


        static int countOfChar(char[] str, int start, int end, int target){
            int count = 0;
            for(int i = start; i < end; i++){
                if(str[i] == target){
                    count++;
                }
            }
            return count;
        }

    public static void main(String[] args) {

        replaceSpaces("Mr John Smith    ", 13);
    }
}
