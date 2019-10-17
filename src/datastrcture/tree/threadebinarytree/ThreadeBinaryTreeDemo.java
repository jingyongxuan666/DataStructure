package datastrcture.tree.threadebinarytree;

/**
 * 线索化二叉树
 * 
 * @author Jingyongxuan
 *
 */
public class ThreadeBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HeroNode root = new HeroNode(1, "Tom");

		HeroNode node2 = new HeroNode(3, "jack");
		HeroNode node3 = new HeroNode(6, "jack");
		HeroNode node4 = new HeroNode(8, "jack");
		HeroNode node5 = new HeroNode(10, "jack");
		HeroNode node6 = new HeroNode(14, "jack");

		// 二叉树创建
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		// 测试线索化
		ThreadeBinaryTree tree = new ThreadeBinaryTree();
		tree.setRoot(root);

		tree.threadedNodes();

		// 测试10号节点
		HeroNode leftNode = node5.getLeft();
		System.out.println(leftNode);

		// 线索化二叉树后，不能用原来的遍历方法
		System.out.println("线索化方式遍历线索化二叉树");
		tree.threadedList();
	}

}

class ThreadeBinaryTree {
	private HeroNode root;

	// 为了线索化，需要创建要给指向当前节点的前驱节点的指针
	// 在递归进行线索化时，pre总是保留前一个节点
	private HeroNode pre = null;

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	public void threadedNodes() {
		this.threadedNodes(root);
	}

	public void threadedList() {
		// 定义一个变量，存储当前遍历的节点，从root开始
		HeroNode node = root;
		// 循环找到leftType == 1的节点，第一个找到的就是8
		// 后面随着遍历而变化，因为当leftType==1时，
		// 说明该节点是按照线索化处理后的有效节点
		while (node != null) {
			while (node.getLeftType() == 0) {
				node = node.getLeft();
			}
			// 打印这个节点
			System.out.println(node);
			// 如果当前节点的右指针是否指向后继节点
			while (node.getRightType() == 1) {
				// 获取到当前节点的后继节点
				node = node.getRight();
				System.out.println(node);
			}

			// 替换遍历的节点
			node = node.getRight();
		}

	}

	// 编写对二叉树进行中序线索化的方法
	/**
	 * @param node 当前需要线索化的节点
	 */
	public void threadedNodes(HeroNode node) {
		// 如果node == null，不能线索化
		if (node == null) {
			return;
		}
		// 1.先线索化左子树
		threadedNodes(node.getLeft());

		// 2.线索化当前节点
		if (node.getLeft() == null) {
			// 让当前节点左指针，指向前驱节点
			node.setLeft(pre);
			// 指向前驱节点
			node.setLeftType(1);
		}
		// 处理后继节点
		if (pre != null && pre.getRight() == null) {
			// 让前驱节点的右指针指向当前节点
			pre.setRight(node);
			// 修改前驱节点右指针类型
			pre.setRightType(1);
		}
		// !!!重要
		pre = node;
		// 3.线索化右子树
		threadedNodes(node.getRight());

	}

	// 前序遍历
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("二叉树为空");
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("二叉树为空");
		}
	}

	// 后序遍历
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("二叉树为空");
		}
	}

	public HeroNode preOrderSearch(int no) {
		if (root != null) {
			return root.preSearch(no);
		}
		return null;
	}

	public void delNo(int no) {
		if (root != null) {
			if (root.getNo() == no) {
				root = null;
			} else {
				root.delNode(no);
			}
		}
	}

}

class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	// 如果leftType==0表示指向的是左子树，如果1指向前驱节点
	// 如果rightTye==0表示指向右子树，1指向后继节点

	private int leftType;
	private int rightType;

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

	// 前序遍历
	public void preOrder() {
		System.out.println(this);
		// 前序遍历左子树
		if (this.left != null) {
			this.left.preOrder();
		}
		// 递归前序遍历右子树
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// 中序遍历
	public void infixOrder() {
		// 递归向左子树中序遍历
		if (this.left != null) {
			this.left.infixOrder();
		}
		// 输出父节点
		System.out.println(this);
		// 右子树中序遍历
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	// 后序遍历
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}

	/**
	 * 前序查找
	 * 
	 * @param no
	 * @return
	 */
	public HeroNode preSearch(int no) {
		if (this.no == no) {
			return this;
		}
		HeroNode node = null;
		if (this.left != null) {
			node = this.left.preSearch(no);
		}

		if (node != null) {
			return node;
		}

		if (this.right != null) {
			node = this.right.preSearch(no);
		}
		return node;
	}

	/**
	 * 中序查找
	 * 
	 * @param no
	 * @return
	 */
	public HeroNode infixSearch(int no) {

		HeroNode node = null;
		if (this.left != null) {
			node = this.left.preSearch(no);
		}

		if (node != null) {
			return node;
		}

		if (this.no == no) {
			return this;
		}

		if (this.right != null) {
			node = this.right.preSearch(no);
		}
		return node;
	}

	/**
	 * 后序查找
	 * 
	 * @param no
	 * @return
	 */
	public HeroNode postSearch(int no) {

		HeroNode node = null;
		if (this.left != null) {
			node = this.left.preSearch(no);
		}

		if (this.no == no) {
			return this;
		}

		if (this.right != null) {
			node = this.right.preSearch(no);
		}

		if (node != null) {
			return node;
		}

		if (this.no == no) {
			return this;
		}

		return node;
	}

	public void delNode(int no) {
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}

		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}

		if (this.left != null) {
			this.left.delNode(no);
		}

		if (this.right != null) {
			this.right.delNode(no);
		}
	}

}