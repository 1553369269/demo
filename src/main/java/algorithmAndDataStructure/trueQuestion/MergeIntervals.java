package algorithmAndDataStructure.trueQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-04-09 19:36
 **/
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] test = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(test);
        for (int i = 0;i < result.length; i++) {
            for (int j = 0;j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public static int[][] merge(int[][] intervals){
        // 先将数组用list代替
        List<int[]> list = new ArrayList<int[]>();
        for (int[] ints : intervals) {
            list.add(ints);
        }
        int i = 1;
        while( i < list.size() ) {
            // 如果intervals[i][0] > intervals[i+1][0] 则合并
            if (list.get(i-1)[1] >= list.get(i)[0]) {
                list.get(i-1)[1] = list.get(i-1)[1] < list.get(i)[1] ? list.get(i)[1] : list.get(i-1)[1];
                // 合并后移除后一个数组
                list.remove(i);
            } else {
                // 如果没合并则往后比较
                i++;
            }
        }
        return list.toArray(new int[0][]);
    }
}
