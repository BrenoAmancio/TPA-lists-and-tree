package list;

import java.util.Comparator;

public class ListaOrdenada<T> {
    private ListNode<T> first, last;
    private int length;
    private final boolean order;
    private Comparator<T> comparador;

    public ListaOrdenada(boolean isOrdered, Comparator<T> comparador) {
        this.first = this.last = null;
        this.length = 0;
        this.order = isOrdered;
        this.comparador = comparador;
    }

    public void adicionar(T value) {
        ListNode<T> newNode = new ListNode<>(value);
        ListNode<T> currNode, prevNode;

        currNode = this.first;
        prevNode = null;

        if (this.first == null) {
            this.first = this.last = newNode;

        } else {
            while (currNode != null && comparador.compare(currNode.getValue(), value)< 0) {
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

    public T pesquisar(T value) {
        ListNode<T> currNode = this.first;

        while (currNode != null) {
            T currValue = currNode.getValue();

            if (this.comparador.compare(currValue, value) == 0) {
                return currNode.getValue();  // Retorna o valor encontrado

            } else if (comparador.compare(currValue, value) > 0) {
                return null;
            }

            currNode = currNode.getNext();  // Avança para o próximo nó
        }

        System.out.println("Erro, Nenhum Aluno Com Essa Matricula");
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