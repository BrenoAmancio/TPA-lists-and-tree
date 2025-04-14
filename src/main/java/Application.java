import list.ListaNaoOrdenada;
import list.ListaOrdenada;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Boolean continuar = true;
        Scanner s = new Scanner(System.in);

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

        while (continuar.equals(true)) {

            System.out.println("Escolha uma opção:");
            System.out.println("1 para pesquisar na lista não ordenada");
            System.out.println("2 para pesquisar na lista ordenada");
            System.out.println("0 para sair");

            String opcao = s.nextLine();

            if (opcao.equals("0")){

                continuar = false;
            }

            if (opcao.equals("1")){

                System.out.println("Digite uma matricula a ser pesquisa na lista não ordenada:");
                int mat = s.nextInt();
                s.nextLine();

                long inicio = System.nanoTime();
                Aluno resultado = lista_n_ord.pesquisar(new Aluno(mat, "", 0));
                long fim = System.nanoTime();

                System.out.println("Tempo de execução: " + (fim - inicio) + " ns");

                if (resultado == null){

                    System.out.println("Erro, nenhum aluno com essa matricula");
                }

                else {

                    System.out.println("Aluno Encontrado: " + resultado);
                }
            }

            if (opcao.equals("2")){

                System.out.println("Digite uma matricula a ser pesquisa na lista ordenada:");
                int mat = s.nextInt();
                s.nextLine();

                long inicio = System.nanoTime();
                Aluno resultado = lista_ord.pesquisar(new Aluno(mat, "", 0));
                long fim = System.nanoTime();

                System.out.println("Tempo de execução: " + (fim - inicio) + " ns");

                if (resultado == null){

                    System.out.println("Erro, nenhum aluno com essa matricula");
                }

                else {

                    System.out.println("Aluno Encontrado: " + resultado);
                }
            }
        }

        //System.out.println(lista_ord.pesquisar(new Aluno(4, "", 0)));
        //System.out.println(lista_n_ord.pesquisar(new Aluno(4, "", 0)));

        //System.out.println(lista_ord);
        //System.out.println(lista_n_ord);

        s.close();
    }
}
