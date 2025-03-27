class Node {
    int data;
    Node right;
    Node left;
    
    public Node(int data) {
        this.data = data;
    }
}

class BinaryTree {
    
    Node root;
    
    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    public Node insertRec(Node root, int data) {
        if(root == null) {
            root = new Node(data);
        } else if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        
        return root;
    }
    
    public void inorder() {
        inorderRec(root);
    }
    
    public void inorderRec(Node root) {
        
        if(root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    
    public void preorder() {
        preorderRec(root);
    }
    
    public void preorderRec(Node root) {
        
        if(root != null) {
            System.out.print(root.data+" ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    
    public void postorder() {
        postorderRec(root);
    }
    
    public void postorderRec(Node root) {
        
        if(root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data+" ");
        }
    }
}

public class BinarySearchTree {
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(2);
        tree.insert(5);
        
        System.out.println("Inorder traversal Result : ");
        tree.inorder();
        System.out.println();
        
        System.out.println("Preorder traversal Result : ");
        tree.preorder();
        System.out.println();
        
        System.out.println("Postorder traversal Result : ");
        tree.postorder();
        System.out.println();
    }
}
