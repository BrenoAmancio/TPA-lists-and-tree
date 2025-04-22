package list;

public class ListaNaoOrdenada<T> {
    private ListNode<T> first, last;
    private int length;

    public ListaNaoOrdenada() {
        this.first = this.last = null;
        this.length = 0;
    }

    // Funcao que adiciona um aluno na lista nao ordenada
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

    // Funcao que pesquisa se uma matricula esta na lista nao ordenada
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