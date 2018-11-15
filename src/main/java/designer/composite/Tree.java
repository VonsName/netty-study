package designer.composite;

/**
 * @author ： fjl
 * @date ： 2018/11/15/015 10:35
 * 组合模式 多用于表示树形结构 关系
 */
public class Tree {

    private TreeNode root;

    public Tree(String name) {
        root = new TreeNode(name);
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }

    public static void main(String[] args) {
        Tree root = new Tree("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        b.add(c);
        root.getRoot().add(b);
        System.out.println(root);
    }
}
