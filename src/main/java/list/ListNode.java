package list;

public class ListNode<T> {
    private T value;
    private ListNode next;

    public ListNode(T value) {
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return this.value;
    }

    public ListNode<T> getNext() {
        return this.next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
