/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node == null) {
                sb.append("#,");
                continue;
            }

            sb.append(node.val).append(",");

            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == null || data.length() == 0) {
            return null;
        }

        String[] arr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.length) {

            TreeNode current = q.poll();

            // Left Child
            if (!arr[i].equals("#")) {
                TreeNode leftNode =
                        new TreeNode(Integer.parseInt(arr[i]));
                current.left = leftNode;
                q.offer(leftNode);
            }
            i++;

            // Right Child
            if (i < arr.length && !arr[i].equals("#")) {
                TreeNode rightNode =
                        new TreeNode(Integer.parseInt(arr[i]));
                current.right = rightNode;
                q.offer(rightNode);
            }
            i++;
        }

        return root;
    }
}