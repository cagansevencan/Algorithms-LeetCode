import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrickWall554 {
    public static int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //Iterate thru each row within the wall
        for(List <Integer> row : wall){
            int sum = 0;
            for(int i = 0; i < row.size()-1; i++){
                sum+= row.get(i);
                if(map.containsKey(sum)){
                    map.put(sum, map.get(sum) + 1);
                }else{
                    map.put(sum, 1);
                }
            }
        }
        int res = wall.size();
        for(int key : map.keySet()){
            res = Math.min(res, wall.size() - map.get(key));
        }
        return res;

    }

    public static void main(String[] args) {
        List<List<Integer>> wall =  new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(2);
        l1.add(1);
        wall.add(l1);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(1);
        l2.add(2);
        wall.add(l2);

        List<Integer> l6 = new ArrayList<>();
        l6.add(1);
        l6.add(3);
        l6.add(2);
        wall.add(l6);

        List<Integer> l4 = new ArrayList<>();
        l4.add(3);
        l4.add(1);
        l4.add(2);
        wall.add(l4);

        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(4);
        wall.add(l3);

        List<Integer> l5 = new ArrayList<>();
        l5.add(1);
        l5.add(3);
        l5.add(1);
        l5.add(1);
        wall.add(l5);


        leastBricks(wall);
    }
}
