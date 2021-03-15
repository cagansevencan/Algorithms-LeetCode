import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> sol = new ArrayList<>(); //Storing it in a new list

        if(matrix.length == 0) return sol;

        int bottom = matrix.length - 1;
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;

        int dir = 0; //right
        //1 - down, 2 - left, 3 - top

        while(top <= bottom && left <= right){
            if(dir==0){ //Need to traverse top most row left to right
                for(int i = left; i <= right; i++){
                    sol.add(matrix[top][i]);
                }
                top++;
                dir = 1; //Top to bottom
            }else if(dir == 1){
                for(int i = top; i <= bottom; i++){
                    sol.add(matrix[i][right]);
                }
                right--;
                dir=2;
            }else if(dir==2){
                for(int i = right; i >= left; i--){
                    sol.add(matrix[bottom][i]);
                }
                bottom--;
                dir=3;
            }else if(dir==3){
                for(int i = bottom; i >= top; i--){
                    sol.add(matrix[i][left]);
                }
                left++;
                dir=0;
            }
            //dir = (dir+1)%4;
        }

        return sol;
    }

    public static void main(String[] args) {
       int [] [] matrix = {{2,4,6,8}, {5,9,12,16}, {2,11,5,9}, {3,2,1,8}};
        List<Integer> sol = new ArrayList<>();
        sol = spiralOrder(matrix);
        System.out.println(sol);
    }
}
