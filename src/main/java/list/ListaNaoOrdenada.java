package list;

public class ListaNaoOrdenada<T> {
    private ListNode<T> first, last;
    private int length;

    public ListaNaoOrdenada() {
        this.first = this.last = null;
        this.length = 0;
    }

    public void adicionar(T value) {
        ListNode<T> newNode = new ListNode<>(value);

        if (this.first == null) {
            this.first = this.last = newNode;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }

        this.length++;
    }

    public T pesquisar(T value) {

        ListNode<T> currNode = this.first;

        while (currNode != null) {
            T currValue = currNode.getValue();

            if (currValue.equals(value)) {
                return currValue;  // Retorna o valor encontrado

            }
            currNode = currNode.getNext();  // Avança para o próximo nó
        }

        return null;  // Não encontrou o valor
    }

    // public boolean remover(int idx) {
    //     if (idx < 0 || idx > this.length) {
    //         return false;
    //     }

    //     ListNode<T> auxNode = this.first;
    //     ListNode<T> prevNode = null;
    //     for (int i = 0; i < idx; i++) {
    //         prevNode = auxNode;
    //         auxNode = auxNode.getNext();
    //     }

    //     if (auxNode == this.first) {
    //         this.first = this.first.getNext();

    //         if (auxNode == this.last) {
    //             this.last = null;
    //         }

    //     } else {
    //         prevNode.setNext(auxNode.getNext());

    //         if (auxNode == this.last) {
    //             this.last = prevNode;
    //         }
    //     }

    //     this.length--;
    //     return true;
    // }

    // public boolean remover(T value) {
    //     ListNode<T> auxNode = this.first;
    //     ListNode<T> prevNode = null;

    //     while (auxNode != null) {

    //         if (auxNode.getValue().equals(value)) {

    //             if (auxNode == this.first) {
    //                 this.first = this.first.getNext();

    //                 if (auxNode == this.last) {
    //                     this.last = null;
    //                 }

    //             } else {
    //                 prevNode.setNext(auxNode.getNext());

    //                 if (auxNode == this.last) {
    //                     this.last = prevNode;
    //                 }
    //             }

    //             this.length--;
    //             return true;
    //         }

    //         prevNode = auxNode;
    //         auxNode = auxNode.getNext();
    //     }

    //     return false;
    // }

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