import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: System_ID
 * Date: 2017-12-09
 * Time: 18:16
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> collect = new ArrayList<List<Integer>>();

        queue.offer(root);
        while (queue.size() > 0) {
            LinkedList<Integer> element = new LinkedList<>();
            Queue<TreeNode> store = new LinkedList<TreeNode>();

            while (queue.size() > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    store.offer(node.left);
                    store.offer(node.right);
                    if (collect.size() % 2 == 0)
                        element.offerLast(node.val);
                    else
                        element.offerFirst(node.val);
                }
            }

            if (element.size() > 0)
                collect.add((List<Integer>) element.clone());
            queue = store;
        }

        return collect;
    }
}
