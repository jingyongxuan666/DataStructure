package datastrcture;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// ����������
		BinaryTree binaryTree = new BinaryTree();
		// �����ڵ�
		HeroNode root = new HeroNode(1, "�ν�");
		HeroNode node2 = new HeroNode(2, "¬����");
		HeroNode node3 = new HeroNode(3, "����");
		HeroNode node4 = new HeroNode(4, "�ֳ�");
		HeroNode node5 = new HeroNode(5, "��ʤ");

		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		binaryTree.setRoot(root);

		// ǰ�����
		binaryTree.preOrder();// 1,2,3,4
//		System.out.println();
//		// �������
//		binaryTree.infixOrder();// 2,1,3,4
//		System.out.println();
//		// �������
//		binaryTree.postOrder();// 2,4,3,1
		binaryTree.delNo(3);
		System.out.println();
		binaryTree.preOrder();

	}

}

class BinaryTree {
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
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
		if(root != null) {
			return root.preSearch(no);
		}
		return null;
	}
	
	public void delNo(int no) {
		if(root != null) {
			if(root.getNo() == no) {
				root = null;
			}else {
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
		if(this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		
		if(this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		
		if(this.left != null) {
			this.left.delNode(no);
		}
		
		if(this.right != null) {
			this.right.delNode(no);
		}
	}

}
//
