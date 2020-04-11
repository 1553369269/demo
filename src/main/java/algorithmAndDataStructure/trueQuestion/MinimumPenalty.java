package algorithmAndDataStructure.trueQuestion;


/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-04-10 10:08
 **/
public class MinimumPenalty {

    public static void main(String[] args) {
        int[][] edges =  {{1,2,1},{2,3,3},{1,3,100}};
        int minPath = minPath(3, edges, 1, 3);
        System.out.println(minPath);
    }

    public static int minPath(int n, int[][] edges, int start, int end){
        int c = 0;
        for (int i = 0;i < edges.length;i++){
            if (edges[i][0] == start && edges[i][1] == end) {
                // 开始和结束在一条边上的情况
                c = c > edges[i][2] ? edges[i][2] : c;
            } else if (edges[i][0] == start){
                // 不在一条边上，则依次遍历取出做运算，这里用递归实现
                int result = dfs(i,edges,edges[i][2],end);
                if (result == 0){
                    // 表示已经走不通了，直接退出这次循环
                    continue;
                }
                c = c > (c |= result) ? (c |= result) : c;
            }
        }
        return c;
    }
    public static int dfs(int i,int[][] edges,int c,int end){
        for (int j = 0; j < edges.length;j++) {
            if (edges[i][1] == edges[j][0]) {
                c |= edges[j][2];
                if ( edges[j][1] == end) {
                    return c;
                } else {
                    return dfs(j,edges,c,end);
                }
            }
        }
        return 0;
    }
}
