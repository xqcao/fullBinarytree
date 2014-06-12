import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
//stack<Node>printout
public class Mybinarytree {

	class Node {
		int value;
		Node left;
		Node right;

		Node(int val) {
			this.value = val;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}

	Node root;

	public Mybinarytree() {
		this.root = null;
	}

	public void insert(int value) {
		Node node = new Node(value);
		if (root == null) {
			root = node;
		} else {
			Node current = root;
			Node parent;
			while (node != null) {
				parent = current;
				if (value < root.value) {
					if (value < parent.value) {
						current = current.left;
						if (current == null) {
							parent.left = node;
							return;
						}
					} else {
						current = current.right;
						if (current == null) {
							parent.right = node;
							return;
						}
					}
				} else {
					if (value < parent.value) {

						current = current.left;
						if (current == null) {
							parent.left = node;
							return;
						}
					} else {
						current = current.right;
						if (current == null) {
							parent.right = node;
							return;
						}
					}
				}
			}
		}
	}

	public void inordertraversetree(Node node) {
		if (node != null) {
			inordertraversetree(node.left);
			System.out.println(node);
			inordertraversetree(node.right);
		}
	}

	public void preordertraversetree(Node node) {
		if (node != null) {
			System.out.println(node);
			inordertraversetree(node.left);
			inordertraversetree(node.right);
		}
	}

	public void postordertraversetree(Node node) {
		if (node != null) {
			inordertraversetree(node.left);
			inordertraversetree(node.right);
			System.out.println(node);
		}
	}

	public void traverseByLevelFromTop(Node node) {
		if (node == null) {
			return;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(node);
		int inCount = 1;
		int outCount = 0;
		while (!queue.isEmpty()) {
			Node curNode = queue.pollFirst();
			System.out.print(curNode.value + " ");
			outCount++;
			if (curNode.left != null) {
				queue.addLast(curNode.left);
			}
			if (curNode.right != null) {
				queue.addLast(curNode.right);
			}
			if (outCount == inCount) {
				System.out.println();
				inCount = queue.size();
				outCount = 0;
			}
		}
	}

	
	public void traverseByLevelFromTop2(Node node) {
		if (node == null) {
			return;
		}
		//Stack<Node> queue = new Stack<Node>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		int inCount = 1;
		int outCount = 0;
		while (!queue.isEmpty()) {
			Node curNode = queue.remove();
			System.out.print(curNode.value + " ");
			outCount++;
			if (curNode.left != null) {
				queue.add(curNode.left);
			}
			if (curNode.right != null) {
				queue.add(curNode.right);
			}
			if (outCount == inCount) {
				System.out.println();
				inCount = queue.size();
				outCount = 0;
			}
		}
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		Mybinarytree alist = new Mybinarytree();

		alist.insert(30);
		alist.insert(23);
		alist.insert(40);
		alist.insert(20);
		alist.insert(26);
		alist.insert(35);
		alist.insert(50);
		alist.insert(15);
		alist.insert(22);
		alist.insert(24);
		alist.insert(27);
		alist.insert(32);
		alist.insert(36);
		alist.insert(45);
		alist.insert(55);
		alist.insert(80);
		/*
		 * System.out.println("----------preorder--------------");
		 * alist.preordertraversetree(alist.root); Thread.sleep(1000);
		 */

	/*	System.out.println("----------ineorder--------------");
		alist.inordertraversetree(alist.root);
		Thread.sleep(1000);*/

		/*
		 * System.out.println("----------postorder--------------");
		 * alist.postordertraversetree(alist.root); Thread.sleep(1000);
		 */
		alist.traverseByLevelFromTop2(alist.root);
	}
}
