package leetcode;

public class FlattenAMultiLevelDoublyLinkedList {

	public Node flatten(Node head) {
		Node temp = head;
		while (temp != null) {

			if (temp.child != null) {
				Node childHead = this.getHeadOfChild(temp);
				Node childTail = this.getTailOfChild(temp);

				Node nextElem = temp.next;
				temp.next = childHead;
				childHead.prev = temp;
				childTail.next = nextElem;
				if (nextElem != null) {
					nextElem.prev = childTail;
				}
				temp.child = null;
			}

			temp = temp.next;
		}
		return head;
	}

	private Node getHeadOfChild(Node node) {
		return node.child;
	}

	private Node getTailOfChild(Node node) {
		Node temp = node.child;
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}

	public static void main(String[] args) {

	}

}
