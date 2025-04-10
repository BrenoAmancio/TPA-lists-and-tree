package list;

public class LinkedList<T extends Comparable<T>> {
    private ListNode<T> first, last;
    private int length;
    private final boolean order;

    public LinkedList(boolean isOrdered) {
        this.first = this.last = null;
        this.length = 0;
        this.order = isOrdered;
    }

    private void addOrdered(T value) {
        ListNode<T> newNode = new ListNode<>(value);
        ListNode<T> currNode, prevNode;

        currNode = this.first;
        prevNode = null;

        if (this.first == null) {
            this.first = this.last = newNode;

        } else {
            while (currNode != null && currNode.getValue().compareTo(value) < 0) {
                prevNode = currNode;
                currNode = currNode.getNext();
            }

            if (prevNode == null) {
                newNode.setNext(this.first);
                this.first = newNode;

            } else if (currNode == null) {
                this.last.setNext(newNode);
                this.last = newNode;

            } else {
                prevNode.setNext(newNode);
                newNode.setNext(currNode);
            }
        }

        this.length++;
    }

    private void addNotOrdered(T value) {
        ListNode<T> newNode = new ListNode<>(value);

        if (this.first == null) {
            this.first = this.last = newNode;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }

        this.length++;
    }

    public void add(T value) {
        if (this.order) {
            addOrdered(value);
        } else {
            addNotOrdered(value);
        }
    }

    public boolean has(T value) {
        ListNode<T> auxNode = this.first;
        while (auxNode != null) {
            if (auxNode.getValue().equals(value)) {
                return true;
            }

            auxNode = auxNode.getNext();
        }

        return false;
    }

    public boolean remove(int idx) {
        if (idx < 0 || idx > this.length) {
            return false;
        }

        ListNode<T> auxNode = this.first;
        ListNode<T> prevNode = null;
        for (int i = 0; i < idx; i++) {
            prevNode = auxNode;
            auxNode = auxNode.getNext();
        }

        if (auxNode == this.first) {
            this.first = this.first.getNext();

            if (auxNode == this.last) {
                this.last = null;
            }

        } else {
            prevNode.setNext(auxNode.getNext());

            if (auxNode == this.last) {
                this.last = prevNode;
            }
        }

        this.length--;
        return true;
    }

    public boolean remove(T value) {
        ListNode<T> auxNode = this.first;
        ListNode<T> prevNode = null;

        while (auxNode != null) {

            if (auxNode.getValue().equals(value)) {

                if (auxNode == this.first) {
                    this.first = this.first.getNext();

                    if (auxNode == this.last) {
                        this.last = null;
                    }

                } else {
                    prevNode.setNext(auxNode.getNext());

                    if (auxNode == this.last) {
                        this.last = prevNode;
                    }
                }

                this.length--;
                return true;
            }

            prevNode = auxNode;
            auxNode = auxNode.getNext();
        }

        return false;
    }

    @Override
    public String toString() {
        ListNode<T> auxNode = this.first;
        StringBuilder s = new StringBuilder("[");

        while (auxNode != null) {
            s.append(auxNode.getValue());
            if (auxNode != this.last)
                s.append(", ");
            auxNode = auxNode.getNext();
        }

        s.append("]");
        return s.toString();
    }

    public int getLength() {
        return this.length;
    }
}
