/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        postOrder(res, root);
        return res;
    }
    public void postOrder(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        postOrder(res,root.left);
        postOrder(res,root.right);
        res.add(root.val);
    }
}


//后序非递归-两个栈
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        postOrder(res, root);
        return res;
    }
    public void postOrder(List<Integer> res, TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode cur = stack1.pop();
            stack2.push(cur);
            if(cur.left != null) stack1.push(cur.left);
            if(cur.right != null) stack1.push(cur.right);
        }
        while(!stack2.isEmpty()){
            res.add(stack2.pop().val);
        }
    }
}

//后序非递归-一个栈
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        postOrder(res, root);
        return res;
    }
    public void postOrder(List<Integer> res, TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null, h = root;
        stack.push(root);
        while(!stack.isEmpty()){
            cur = stack.peek();
            if(cur.left != null && h != cur.left && h != cur.right){
                stack.push(cur.left);
            }else if(cur.right != null && h != cur.right){
                stack.push(cur.right);
            }else{
                h = stack.pop();
                res.add(h.val);
            }
        }
    }
}

//后序非递归-模仿先序非递归
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, LinkedList<Integer> res){
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                res.addFirst(cur.val); // 每次放到第一个位置 //Reverse the process of preorder 
                cur = cur.right; //Reverse the process of preorder
            }else{
                TreeNode temp = stack.pop();
                cur = temp.left;  //Reverse the process of preorder
            }
        }
    }
}



//concise method postOrder
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, LinkedList<Integer> res){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.addFirst(cur.val);
            if(cur.left != null) stack.push(cur.left);
            if(cur.right != null) stack.push(cur.right);
        }
    }
}











