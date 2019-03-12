package com.lu.linkedlist;

public class SingleLinkedList<T> {

	private Link<T> first;

	public SingleLinkedList() {

	}

	public boolean isEmpty() {
		return first == null;
	}

	public void insertFirst(T data) {
		Link<T> newLink = new Link<T>(data);
		newLink.next = first;
		first = newLink;
	}

	public Link<T> deleteFirst() {
		Link<T> temp = first;
		first = first.next;
		return temp;
	}

	public Link<T> find(T t) {
		Link<T> find = first;
		while (find != null) {
			if (!find.data.equals(t)) {
				find = find.next;
			} else {
				break;
			}
		}
		return find;
	}

	public Link<T> delete(T t) {
		if (isEmpty()) {
			return null;
		} else {
			if (first.data.equals(t)) {
				Link<T> temp = first;
				first = first.next;
				// 变更首结点，为下一结点 return temp;
			}
		}
		Link<T> p = first;
		Link<T> q = first;
		while (!p.data.equals(t)) {
			if (p.next == null) {// 表示到链尾还没找到
				return null;
			} else {
				q = p;
				p = p.next;
			}
		}
		q.next = p.next;
		return p;
	}

	public void displayList() {
		// 遍历
		System.out.println("List (first-->last):");
		Link<T> current = first;
		while (current != null) {
			current.displayLink();
			current = current.next;
		}
	}

	public void displayListReverse() {
		// 反序遍历
		Link<T> p = first, q = first.next, t;
		while (q != null) {
			// 指针反向，遍历的数据顺序向后
			t = q.next; // no3
			if (p == first) {
				// 当为原来的头时，头的.next应该置空
				p.next = null;
			}
			q.next = p;// no3 -> no1 pointer reverse
			p = q; // start is reverse
			q = t; // no3 start
		}
		// 上面循环中的if里，把first.next 置空了, 而当q为null不执行循环时，p就为原来的最且一个数据项，反转后把p赋给first
		first = p;
		displayList();
	}

	public static void main(String[] args) {
		SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
		list.insertFirst(33);
		list.insertFirst(78);
		list.insertFirst(24);
		list.insertFirst(22);
		list.insertFirst(56);
		list.displayList();
		list.deleteFirst();
		list.displayList();
		System.out.println("find:" + list.find(56));
		System.out.println("find:" + list.find(33));
		System.out.println("delete find:" + list.delete(99));
		System.out.println("delete find:" + list.delete(24));
		list.displayList();
		System.out.println("----reverse----");
		list.displayListReverse();
	}
}
