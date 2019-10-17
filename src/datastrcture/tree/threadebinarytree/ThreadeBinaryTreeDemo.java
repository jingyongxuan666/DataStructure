package datastrcture.tree.threadebinarytree;

/**
 * ������������
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

		// ����������
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		// ����������
		ThreadeBinaryTree tree = new ThreadeBinaryTree();
		tree.setRoot(root);

		tree.threadedNodes();

		// ����10�Žڵ�
		HeroNode leftNode = node5.getLeft();
		System.out.println(leftNode);

		// �������������󣬲�����ԭ���ı�������
		System.out.println("��������ʽ����������������");
		tree.threadedList();
	}

}

class ThreadeBinaryTree {
	private HeroNode root;

	// Ϊ������������Ҫ����Ҫ��ָ��ǰ�ڵ��ǰ���ڵ��ָ��
	// �ڵݹ����������ʱ��pre���Ǳ���ǰһ���ڵ�
	private HeroNode pre = null;

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	public void threadedNodes() {
		this.threadedNodes(root);
	}

	public void threadedList() {
		// ����һ���������洢��ǰ�����Ľڵ㣬��root��ʼ
		HeroNode node = root;
		// ѭ���ҵ�leftType == 1�Ľڵ㣬��һ���ҵ��ľ���8
		// �������ű������仯����Ϊ��leftType==1ʱ��
		// ˵���ýڵ��ǰ�����������������Ч�ڵ�
		while (node != null) {
			while (node.getLeftType() == 0) {
				node = node.getLeft();
			}
			// ��ӡ����ڵ�
			System.out.println(node);
			// �����ǰ�ڵ����ָ���Ƿ�ָ���̽ڵ�
			while (node.getRightType() == 1) {
				// ��ȡ����ǰ�ڵ�ĺ�̽ڵ�
				node = node.getRight();
				System.out.println(node);
			}

			// �滻�����Ľڵ�
			node = node.getRight();
		}

	}

	// ��д�Զ��������������������ķ���
	/**
	 * @param node ��ǰ��Ҫ�������Ľڵ�
	 */
	public void threadedNodes(HeroNode node) {
		// ���node == null������������
		if (node == null) {
			return;
		}
		// 1.��������������
		threadedNodes(node.getLeft());

		// 2.��������ǰ�ڵ�
		if (node.getLeft() == null) {
			// �õ�ǰ�ڵ���ָ�룬ָ��ǰ���ڵ�
			node.setLeft(pre);
			// ָ��ǰ���ڵ�
			node.setLeftType(1);
		}
		// �����̽ڵ�
		if (pre != null && pre.getRight() == null) {
			// ��ǰ���ڵ����ָ��ָ��ǰ�ڵ�
			pre.setRight(node);
			// �޸�ǰ���ڵ���ָ������
			pre.setRightType(1);
		}
		// !!!��Ҫ
		pre = node;
		// 3.������������
		threadedNodes(node.getRight());

	}

	// ǰ�����
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("������Ϊ��");
		}
	}

	// �������
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("������Ϊ��");
		}
	}

	// �������
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("������Ϊ��");
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
	// ���leftType==0��ʾָ����������������1ָ��ǰ���ڵ�
	// ���rightTye==0��ʾָ����������1ָ���̽ڵ�

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

	// ǰ�����
	public void preOrder() {
		System.out.println(this);
		// ǰ�����������
		if (this.left != null) {
			this.left.preOrder();
		}
		// �ݹ�ǰ�����������
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// �������
	public void infixOrder() {
		// �ݹ����������������
		if (this.left != null) {
			this.left.infixOrder();
		}
		// ������ڵ�
		System.out.println(this);
		// �������������
		if (this.right != null) {
			this.right.infixOrder();
		}
	}

	// �������
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
	 * ǰ�����
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
	 * �������
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
	 * �������
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