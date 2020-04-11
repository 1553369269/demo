package algorithmAndDataStructure.binaryTree;


import java.util.LinkedList;

/**
 * @Description 二叉树的一些操作
 * Author caihaojie
 * @Date 2020-04-07 9:29
 **/
public class BinaryTree {

    /**
     * 构建二叉树
     * @param inputList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList){
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst(); // 根节点
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

}
