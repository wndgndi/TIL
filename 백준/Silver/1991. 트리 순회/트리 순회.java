import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Node head = new Node('A', null, null);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }

        preorder(head);
        System.out.println();
        inorder(head);
        System.out.println();
        postorder(head);
        System.out.println();
    }

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node tmp, char root, char left, char right) {
        if(tmp.data == root) {
            tmp.left = (left=='.' ? null:new Node(left, null, null));
            tmp.right = (right=='.' ? null:new Node(right,null,null));
        } else {
            if(tmp.left != null) {
                insertNode(tmp.left, root, left, right);
            }
            if(tmp.right != null) {
                insertNode(tmp.right, root, left, right);
            }
        }
    }

    public static void preorder(Node node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if(node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data);
    }
}