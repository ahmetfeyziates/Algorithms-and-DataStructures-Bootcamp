import java.util.ArrayList;

public class LinkedTree implements ITree {
    private TreeNode root;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public TreeNode root() {
        return root; // null if the tree is empty
    }

    @Override
    public ArrayList<TreeNode> nodes() {
        ArrayList<TreeNode> result = new ArrayList<>();
        collectNodes(root, result);
        return result;
    }

    private void collectNodes(TreeNode node, ArrayList<TreeNode> result) {
        if (node == null) {
            return;
        }

        result.add(node);
        if (node.children != null) {
            for (TreeNode child : node.children) {
                collectNodes(child, result);
            }
        }
    }

    public TreeNode addRoot(String element) {
        if (root != null) {
            throw new IllegalStateException("Tree already has a root");
        }

        root = new TreeNode();
        root.element = element;
        root.children = new ArrayList<>();
        size = 1;
        return root;
    }

    public TreeNode addChild(TreeNode parent, String element) {
        if (parent == null || !nodes().contains(parent)) {
            throw new IllegalArgumentException("Parent is not in this tree");
        }

        TreeNode child = new TreeNode();
        child.element = element;
        child.parent = parent;
        child.children = new ArrayList<>();

        if (parent.children == null) {
            parent.children = new ArrayList<>();
        }
        parent.children.add(child);
        size++;
        return child;
    }
}
