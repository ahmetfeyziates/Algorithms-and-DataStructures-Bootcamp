import java.util.ArrayList;

public class TreeNode {
    public String element;
    public TreeNode parent;
    public ArrayList<TreeNode> children;

    public boolean isRoot() {
        return (parent == null);
    }

    public boolean isExternal() {
        return children == null || children.isEmpty();
    }
}

