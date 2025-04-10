import list.ListaNaoOrdenada;
import list.ListaOrdenada;

public class Application {
    public static void main(String[] args) {
        ListaOrdenada<Aluno> lista_ord = new ListaOrdenada<>(true, new ComparadorAlunoPorMatricula());
        ListaNaoOrdenada<Aluno> lista_n_ord = new ListaNaoOrdenada<>();

        Aluno a1 = new Aluno(1, "Zé", 50);
        Aluno a2 = new Aluno(3, "Mané", 50);
        Aluno a3 = new Aluno(5, "Mano", 50);

        lista_ord.add(a3);
        lista_ord.add(a2);
        lista_ord.add(a1);

        lista_n_ord.add(a1);
        lista_n_ord.add(a3);
        lista_n_ord.add(a2);

        System.out.println(lista_ord.pesquisar(new Aluno(4, "", 0)));
        System.out.println(lista_n_ord.pesquisar(new Aluno(4, "", 0)));

        System.out.println(lista_ord);
        System.out.println(lista_n_ord);
    }
}
