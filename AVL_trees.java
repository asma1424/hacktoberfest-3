import java.util.*;

public class AVL_trees {
    public static class Node {
        Node left;
        Node right;
        int balfac;
        int height;
        long data;



        Node() {
            this.left = null;
            this.right = null;
            this.balfac = 0;
            this.height = 1;
        }

        Node(long d) {
            this.data = d;
            this.balfac = 0;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    static int count = 0;
    static long ele = 0;

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

    public static void kth_smallest(Node root, int k) {
        if (root == null)
            return;

        kth_smallest(root.left, k);

        if (k > count) {
            count++;
            ele = root.data;
        } else
            return;

        kth_smallest(root.right, k);

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

    public static void calc_avl_heights(Node root) {
        if (root == null)
            return;

        calc_avl_heights(root.left);
        calc_avl_heights(root.right);
        root.height = node_height(root);
    }

    public static void calc_avl_balfacts(Node root) {
        if (root == null)
            return;

        calc_avl_balfacts(root.left);
        calc_avl_balfacts(root.right);
        root.balfac = node_balfac(root);

    }

    public static int node_balfac(Node root) {
        if (root == null)
            return 0;

        int balfac_left = 0, balfac_right = 0;

        if (root.left == null && root.right == null)
            return 0;
        else {
            if (root.left != null)
                balfac_left = root.left.height;

            if (root.right != null)
                balfac_right = root.right.height;

            return balfac_left - balfac_right;
        }

    }

    public static int node_height(Node root) {
        if (root == null)
            return 0;

        int left_height = 0, right_height = 0;

        if (root.left != null)
            left_height = root.left.height;
        else
            left_height = 0;
        if (root.right != null)
            right_height = root.right.height;
        else
            right_height = 0;

        return left_height > right_height ? left_height + 1 : right_height + 1;

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

    public static Node ll_rotation(Node root) {
        if (root == null)
            return null;

        Node temp2 = root.left;
        Node temp1 = temp2.right;

        root.left = null;
        temp2.right = null;

        root.left = temp1;
        temp2.right = root;

        root.height = node_height(root);
        temp2.height = node_height(temp2);

        root.balfac = node_balfac(root);
        temp2.balfac = node_balfac(temp2);

        root = temp2;
        return root;

    }

    public static Node rr_rotation(Node root) {
        if (root == null)
            return null;

        Node temp2 = root.right;
        Node temp1 = temp2.left;

        root.right = null;
        temp2.left = null;

        root.right = temp1;
        temp2.left = root;

        root.height = node_height(root);
        temp2.height = node_height(temp2);

        root.balfac = node_balfac(root);
        temp2.balfac = node_balfac(temp2);

        root = temp2;
        return root;

    }

    public static Node lr_rotation(Node root) {
        if (root == null)
            return null;

        root.left = rr_rotation(root.left);
        root = ll_rotation(root);
        return root;
    }

    public static Node rl_rotation(Node root) {
        if (root == null)
            return null;

        root.right = ll_rotation(root.right);
        root = rr_rotation(root);
        return root;
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

        root.height = node_height(root);
        root.balfac = node_balfac(root);

        if (root.balfac == 2 && root.left.balfac == 1)
            root = ll_rotation(root);
        else if (root.balfac == 2 && root.left.balfac == -1)
            root = lr_rotation(root);
        else if (root.balfac == -2 && root.right.balfac == -1)
            root = rr_rotation(root);
        else if (root.balfac == -2 && root.right.balfac == 1)
            root = rl_rotation(root);

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

        root.height = node_height(root);
        root.balfac = node_balfac(root);

        if (root.balfac == 2 && root.left.balfac == 1)
            root = ll_rotation(root);
        else if (root.balfac > 1 && root.left.balfac < 0)
            root = lr_rotation(root);
        else if (root.balfac == -2 && root.right.balfac == -1)
            root = rr_rotation(root);
        else if (root.balfac < -1 && root.right.balfac > 0)
            root = rl_rotation(root);

        return root;
    }

    
    
    
    public static void main(String[] args) {

        long arr[] = { 10, 20, 30, 25, 28, 27, 5 };

        Node bst_root = new Node(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            bst_root = insert(arr[i], bst_root);
        }

        // calc_avl_heights(bst_root);

        // calc_avl_balfacts(bst_root);

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
        System.out.println("height : " + bst_root.height);

        for(int i = 1;i<8 ;i++){
            kth_smallest(bst_root, i);
            System.out.println(i+"th smallest : " + ele);
            ele = 0;
            count = 0;
        }
        
        System.out.println(successor(4, bst_root).data);

    }
}
