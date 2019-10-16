package com.jyx.linkedList;

public class LindedList {
	public static void main(String[] args) {
		Students student = new Students();
		Node<String> s1 = new Node<String>("张三");
		Node<String> s2 = new Node<String>("李四");
		Node<String> s3 = new Node<String>("王五");
		student.addStudent(s1);
		student.addStudent(s2);
		student.addStudent(s3);
		student.reversePrint(student.getHead());
//		student.printfList();
	}
	
	
	
	
}
class Node<T>{
	T data;
	Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
}
class Students{
	private Node<String> head = new Node<String>("");
	
	public Node<String> getHead() {
		return head;
	}
	
	public void addStudent(Node<String> student) {
		Node<String> temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = student;
	}
	
	public void printfList() {
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		Node<String> node = head.next;
		while(node != null) {
			System.out.printf("%s ",node.data);
			node = node.next;
		}
	}
	
	public void reverseList(Node<String> head) {
		if(head.next == null || head.next.next == null) {
			return;
		}
		
		Node<String> cur = head.next;
		Node<String> next = null;
		Node<String> reverseHead = new Node<String>("");
		while(cur != null) {
			next = cur.next;
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;
		}
		head.next = reverseHead.next;
	}
	
	/**
	 * 倒叙打印
	 * @param head
	 */
	public void reversePrint(Node<String> head) {
		Node<String> node = head.next;
		if(node.next != null) {
			reversePrint(node);
		}
		System.out.printf("%s ",node.data);
	}
}
