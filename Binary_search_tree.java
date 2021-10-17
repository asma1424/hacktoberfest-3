import java.util.*;

public class Binary_search_tree {
    public static class Node {
        Node left;
        Node right;
        long data;

        Node() {
            this.left = null;
            this.right = null;
        }

        Node(long d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    public static void pre_order(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        pre_order(root.left);
        pre_order(root.right);
    }

    public static void in_order(Node root) {
        if (root == null)
            return;
        in_order(root.left);
        System.out.print(root.data + " ");
        in_order(root.right);
    }

    public static void post_order(Node root) {
        if (root == null)
            return;
        post_order(root.left);
        post_order(root.right);
        System.out.print(root.data + " ");
    }

    public static void level_order(Node root) {

        if (root == null)
            return;

        Queue<Node> Q = new LinkedList<Node>();

        System.out.print(root.data + " ");
        Q.add(root);

        while (Q.size() > 0) {
            Node temp = Q.remove();

            if (temp.left != null) {
                System.out.print(temp.left.data + " ");
                Q.add(temp.left);
            }
            if (temp.right != null) {
                System.out.print(temp.right.data + " ");
                Q.add(temp.right);
            }

        }

    }

    public static int node_count(Node root) {
        if (root == null)
            return 0;
        return node_count(root.left) + node_count(root.right) + 1;
    }

    public static long node_sum(Node root) {
        if (root == null)
            return 0;
        return node_sum(root.left) + node_sum(root.right) + root.data;
    }

    public static int height(Node root) {
        if (root == null)
            return 0;

        int left_height = 0, right_height = 0;

        left_height = height(root.left);
        right_height = height(root.right);

        if (left_height > right_height)
            return left_height + 1;
        else
            return right_height + 1;
    }

    public static int deg2_count(Node root) {
        if (root == null)
            return 0;

        if (root.left != null && root.right != null)
            return deg2_count(root.left) + deg2_count(root.right) + 1;
        else
            return deg2_count(root.left) + deg2_count(root.right);
    }

    public static int leaf_count(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return leaf_count(root.left) + leaf_count(root.right) + 1;
        else
            return leaf_count(root.left) + leaf_count(root.right);
    }

    public static int deg1_count(Node root) {
        if (root == null)
            return 0;

        // if ((root.left != null && root.right == null)||(root.left == null &&
        // root.right != null))
        if (root.left == null ^ root.right == null)
            return deg1_count(root.left) + deg1_count(root.right) + 1;
        else
            return deg1_count(root.left) + deg1_count(root.right);
    }

    public static int deg12_count(Node root) {
        if (root == null)
            return 0;

        if (root.left != null || root.right != null)
            return deg12_count(root.left) + deg12_count(root.right) + 1;
        else
            return deg12_count(root.left) + deg12_count(root.right);
    }

    // acc to order of insertion in array
    public static Node insert(long d, Node root) {

        if (root == null)
            return new Node(d);

        if (root.data > d)
            // Dulipcates not allowed if allowed then sign changes to more-than equals
            // instead of more-than
            root.left = insert(d, root.left);
        else
            root.right = insert(d, root.right);

        return root;

    }

    public static void pre_order_iterative(Node root) {
        LinkedList<Node> Q = new LinkedList<Node>();

        Q.addFirst(root);

        while (Q.size() > 0) {
            Node temp = Q.removeFirst();
            System.out.print(temp.data + " ");

            if (temp.right != null)
                Q.addFirst(temp.right);
            if (temp.left != null)
                Q.addFirst(temp.left);
        }

    }

    public static void in_order_iterative(Node root) {
        Stack<Node> S = new Stack<Node>();

        Node temp = root;

        while (temp != null || S.size() > 0) {

            while (temp != null) {
                S.push(temp);
                temp = temp.left;
            }

            temp = S.pop();
            System.out.print(temp.data + " ");
            temp = temp.right;

        }

    }

    public static void post_order_iterative(Node root) {
        LinkedList<Node> Q = new LinkedList<Node>();
        LinkedList<Node> ans = new LinkedList<Node>();

        Q.addFirst(root);

        while (Q.size() > 0) {
            Node temp = Q.removeFirst();

            ans.add(temp);

            if (temp.left != null)
                Q.addFirst(temp.left);
            if (temp.right != null)
                Q.addFirst(temp.right);

        }

        while (ans.size() > 0) {
            System.out.print(ans.removeLast().data + " ");
        }

    }

    public static Node successor(long d, Node root) {
        if (root == null || root.left == null)
            return null;

        Node temp = root.left;

        while (temp.right != null) {
            temp = temp.right;
        }

        return temp;

    }

    public static Node predecessor(long d, Node root) {
        if (root == null || root.right == null)
            return null;

        Node temp = root.right;

        while (temp.left != null) {
            temp = temp.left;
        }

        return temp;

    }

    public static Node delete(long d, Node root) {
        if (root == null)
            return null;

        if (root.data == d) {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null ^ root.right != null) {
                if (root.left != null) {
                    root.data = root.left.data;
                    root.left = null;
                } else {
                    root.data = root.right.data;
                    root.right = null;
                }
            } else {
                Node temp = successor(d, root);
                root.data = temp.data;
                root.left = delete(temp.data, root.left);
            }
            return root;
        } else if (root.data > d) {
            root.left = delete(d, root.left);
        } else {
            root.right = delete(d, root.right);
        }

        return root;
    }

    public static void main(String[] args) {

        long arr[] = { 4, 2, 3, 1, 6, 7, 5 };

        Node bst_root = new Node(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            insert(arr[i], bst_root);
        }

        System.out.print("pre_order : ");
        pre_order(bst_root);
        System.out.println();
        System.out.print("pre_order_iterative : ");
        pre_order_iterative(bst_root);
        System.out.println();
        System.out.print("in_order : ");
        in_order(bst_root);
        System.out.println();
        System.out.print("in_order_iterative : ");
        in_order_iterative(bst_root);
        System.out.println();
        System.out.print("post_order : ");
        post_order(bst_root);
        System.out.println();
        System.out.print("post_order_iterative : ");
        post_order_iterative(bst_root);
        System.out.println();
        System.out.print("level_order : ");
        level_order(bst_root);
        System.out.println();
        System.out.println("node_count : " + node_count(bst_root));
        System.out.println("node_sum : " + node_sum(bst_root));
        System.out.println("deg1_count : " + deg1_count(bst_root));
        System.out.println("deg2_count : " + deg2_count(bst_root));
        System.out.println("deg12_count : " + deg12_count(bst_root));
        System.out.println("leaf_count : " + leaf_count(bst_root));
        System.out.println("height : " + height(bst_root));
        System.out.println(successor(4, bst_root).data);

        bst_root = delete(4, bst_root);
        bst_root = delete(1, bst_root);
        bst_root = delete(6, bst_root);
        bst_root = delete(5, bst_root);

    }

}
