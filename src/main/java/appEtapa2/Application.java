package appEtapa2;

import lib.ArvoreBinaria;
import lib.IArvoreBinaria;
import java.util.Scanner;

import lib.*;
import app.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Application {

    private static final String NOME_ARQUIVO1 = "alunosOrdenados.txt";
    private static final String NOME_ARQUIVO2 = "alunosBalanceados.txt";
    public static void main(String[] args) {

        Boolean continuar = true;

        Scanner s = new Scanner(System.in);

        //Instancio um comparador de alunos por matricula e nome
        ComparadorAlunoPorMatricula compPorMatricula = new ComparadorAlunoPorMatricula();
        ComparadorAlunoPorNome compPorNome = new ComparadorAlunoPorNome();
        IArvoreBinaria<Aluno> arv1Degenerada, arv1Balanceada, arv2Degenerada, arv2Balanceada;

        arv1Degenerada = new ArvoreBinaria(compPorMatricula);
        arv1Balanceada = new ArvoreBinaria(compPorMatricula);
        arv2Degenerada = new ArvoreBinaria(compPorNome);
        arv2Balanceada = new ArvoreBinaria(compPorNome);

        //Faz o try-catch para a leitura do txt, se funcionando adiciona as informações em aluno e depois na arvore degenerada
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO1))) {

            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);

            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int matricula = Integer.parseInt(partes[0]);
                String nome = partes[1];
                float nota = Float.parseFloat(partes[2]);

                arv1Degenerada.adicionar(new Aluno(matricula,nome));
                arv2Degenerada.adicionar(new Aluno(matricula,nome));
            }


        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }

        //Faz o try-catch para a leitura do txt, se funcionando adiciona as informações em aluno e depois na arvore degenerada
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO2))) {

            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);

            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int matricula = Integer.parseInt(partes[0]);
                String nome = partes[1];
                float nota = Float.parseFloat(partes[2]);

                arv1Balanceada.adicionar(new Aluno(matricula,nome));
                arv2Balanceada.adicionar(new Aluno(matricula,nome));
            }


        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }

        /*System.out.println("Arvore degenerada por matricula \n " + arv1Degenerada.caminharEmOrdem());
        System.out.println("Arvore degenerada por nome \n " + arv2Degenerada.caminharEmOrdem());
        System.out.println(arv1Balanceada.caminharEmOrdem());
        System.out.println(arv2Balanceada.caminharEmOrdem());*/

    }

}