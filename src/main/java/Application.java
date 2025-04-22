import list.ListaNaoOrdenada;
import list.ListaOrdenada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    private static final String NOME_ARQUIVO = "alunosOrdenados.txt";
    public static void main(String[] args) {

        Boolean continuar = true;
        Scanner s = new Scanner(System.in);

        //Cria as listas
        ListaOrdenada<Aluno> lista_ord = new ListaOrdenada<Aluno>(true, new ComparadorAlunoPorMatricula());
        ListaNaoOrdenada<Aluno> lista_n_ord = new ListaNaoOrdenada<>();


        //Faz o try-catch para a leitura do txt, se funcionando adiciona as informações em aluno e depois na lista não ordenada
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {

            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);

            String linha;

            // iniciando o tempo de processamento
            long inicio = System.nanoTime();

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int matricula = Integer.parseInt(partes[0]);
                String nome = partes[1];
                float nota = Float.parseFloat(partes[2]);

                Aluno a1 = new Aluno(matricula, nome, nota);
                lista_n_ord.adicionar(a1);
            }

            // Fechando o tempo de processamento
            long fim = System.nanoTime();

            System.out.println("Tempo de execução para adicionar na lista nao ordenada: " + (fim - inicio) + " ns");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }

        //Faz o try-catch para a leitura do txt, se funcionando adiciona as informações em aluno e depois na lista ordenada
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {

            int numRegistros = Integer.parseInt(reader.readLine().trim());
            //System.out.println("Número de registros: " + numRegistros);

            String linha;

            // iniciando o tempo de processamento
            long inicio = System.nanoTime();

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int matricula = Integer.parseInt(partes[0]);
                String nome = partes[1];
                float nota = Float.parseFloat(partes[2]);

                Aluno a1 = new Aluno(matricula, nome, nota);
                lista_ord.adicionar(a1);

            }

            // Fechando o tempo de processamento
            long fim = System.nanoTime();

            System.out.println("Tempo de execução para adicionar na lista ordenada: " + (fim - inicio) + " ns");


        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }

        // Exibe o menu enquanto a opção 0 não for escolhida
        while (continuar.equals(true)) {

            System.out.println("Escolha uma opção:");
            System.out.println("1 para pesquisar na lista não ordenada");
            System.out.println("2 para pesquisar na lista ordenada");
            System.out.println("0 para sair");

            String opcao = s.nextLine();

            // Sai do menu se escolhida
            if (opcao.equals("0")){

                continuar = false;
            }

            // Faz a busca na lista não ordenada
            if (opcao.equals("1")){

                System.out.println("Digite uma matricula a ser pesquisa na lista não ordenada:");
                int mat = s.nextInt();
                s.nextLine();

                // Calculando o tempo de processamento
                long inicio = System.nanoTime();
                Aluno resultado = lista_n_ord.pesquisar(new Aluno(mat, "", 0));
                long fim = System.nanoTime();

                System.out.println("Tempo de execução: " + (fim - inicio) + " ns");

                // Checa se matricula não esta na lista
                if (resultado == null){

                    System.out.println("Erro, nenhum aluno com essa matricula");
                }

                // Printa informações do aluno da matricula encontrada
                else {

                    System.out.println("Aluno Encontrado: " + resultado);
                }
            }

            // Faz a busca na lista ordenada
            if (opcao.equals("2")){

                System.out.println("Digite uma matricula a ser pesquisa na lista ordenada:");
                int mat = s.nextInt();
                s.nextLine();

                long inicio = System.nanoTime();
                Aluno resultado = lista_ord.pesquisar(new Aluno(mat, "", 0));
                long fim = System.nanoTime();

                System.out.println("Tempo de execução: " + (fim - inicio) + " ns");


                // Checa se matricula não esta na lista
                if (resultado == null){

                    System.out.println("Erro, nenhum aluno com essa matricula");
                }


                // Printa informações do aluno da matricula encontrada
                else {

                    System.out.println("Aluno Encontrado: " + resultado);
                }
            }
        }

        s.close();
    }
}