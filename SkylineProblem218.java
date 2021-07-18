import java.util.*;
//Time Complexity : O(NlogN)
//Space Complexity : O(N)
public class SkylineProblem218 {


    static class BuildingPoint implements Comparable<BuildingPoint>{
        int x;
        boolean isStart;
        int height;

        @Override
        public int compareTo(BuildingPoint o) {
            // first compare by x
            // if they are same then use this logic
            // if two starts are compared then lower height building should be picked up first
            // if two ends compared then lower height will be picked
            // if one start and end is compared then start should appear before end
            if(this.x != o.x){
                return this.x - o.x;
            }else{
                return (this.isStart ? - this.height : this.height)-
                        (o.isStart? - o.height: o.height);
            }
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        //for all start and end of the buildings put them into list of BuildingPoint
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
        int index = 0;
        for(int building[] : buildings){
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];

            buildingPoints[index+1] = new BuildingPoint();
            buildingPoints[index+1].x = building[1];
            buildingPoints[index+1].isStart = false;
            buildingPoints[index+1].height = building[2];
            index+=2;
        }
        Arrays.sort(buildingPoints);

        //Using TreeMap since it gives log time performance
        //Priority Queue in java does not support remove(object)
        //operation in log time.
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        //PriorityQueue<Integer> queue1 = new PriorityQueue<>(Collections.reverseOrder());
        //priority queue doesnt support remove method in O(logN) time
        queue.put(0,1); //0 occurs 1 time, although  there is no building with 0 height
        //queue1.add(0);
        int prevMaxHeight = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(BuildingPoint buildingPoint : buildingPoints){
            //if it is start of building then add height to map. If height already exist then
            //increment the value
            if(buildingPoint.isStart){
                queue.compute(buildingPoint.height, (key, value) -> {
                    if(value != null){
                        return value+1;
                    }
                    return 1;
                });
                //queue1.add(cp.height)
            }else{ //if it is end of the building then decrement or remove the height from the map.
                queue.compute(buildingPoint.height, (key, value) -> {
                    if(value == 1){
                        return null;
                    }
                    return value -1;
                });
                //queue1.remove(cp.height);
            }
            //peek the current height after addition or removal of building x.
            int currentMaxHeight = queue.lastKey();
            //int currentMaxHeight = queue1.peek();
            //if height changes from previous height then this building x becomes critical x.
            //So add it to the result.
            if(prevMaxHeight != currentMaxHeight){
                result.add(new ArrayList<Integer>() {{add(buildingPoint.x); add(currentMaxHeight);}});
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[][] buildings = {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
        List<List<Integer>> result = getSkyline(buildings);
        System.out.println(result);
    }
}

