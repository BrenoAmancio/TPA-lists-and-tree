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

    // Funcao que adiciona um aluno na lista ordenada
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

    // Funcao que pesquisa se uma matricula esta na lista ordenada
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

        return null;  // Não encontrou o valor
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

}