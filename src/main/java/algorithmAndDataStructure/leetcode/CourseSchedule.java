package algorithmAndDataStructure.leetcode;

/**
 * @Description 知识点:拓扑序
 * Author caihaojie
 * @Date 2020-03-27 13:30
 **/

/** 题目描述
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 */

import java.util.LinkedList;

/**
 *
 * 拓扑序
 * 如果图中从v到w有一条有向路径，则v一定排在w的前面。满足此条件的顶点序列称为拓扑序。
 * 获得一个拓扑序的过程称为拓扑排序。
 * 如果有合理的拓扑序，则必定是有向无环图（DAG）
 *
 * 该题的解题思路
 * 入度为0（表示学习该课程之前没有其他课程要学习）的顶点先抹去，该顶点的后继顶点的入度同样也要减一，
 * 然后判断后继顶点的入度是否为0，为0则抹去。最后顶点能够全部抹去则表示不存在环，返回true。
 */
public class CourseSchedule {

    public static void main(String[] args) {
      int nuCourses = 2;
      int[][] prerequisites = {{1,0}};
      System.out.println(canFinish(nuCourses,prerequisites));
    }

    /**
     *
     * @param numCourses 课程数
     * @param prerequisites 课程之间的关系
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 首先创建一个数组用来表示每个顶点的入度次数，下标表示顶点
        int[] indegress = new int [numCourses];
        for (int [] cp : prerequisites) { // 循环得到顶点的入度次数
            indegress[cp[0]]++;
        }
        // 创建一个队列，入度次数为0的顶点入队
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegress[i] == 0) {
                queue.addLast(i);
            }
        }
        // 当队列不为空时，顶点依次出列，当顶点出列时，课程数减一，该课程的后继节点的入度减一，当入度为0时顶点入队
        while(!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for (int[] cp : prerequisites) {
                if(cp[1] != pre ) {
                    continue;
                }
                if (--indegress[cp[0]] == 0) {
                    queue.add(cp[0]);
                }
            }
        }
        // 如果存在节点没有被抹去，则存在环
        return numCourses == 0;
    }
}
