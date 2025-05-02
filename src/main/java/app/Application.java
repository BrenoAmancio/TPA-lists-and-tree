package app;

import lib.ArvoreBinaria;
import lib.IArvoreBinaria;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        //Instancio o meu gerador de árvores (que também foi fornecido)
        GeradorDeArvores gerador = new GeradorDeArvores();
        //Instancio um comparador de alunos por matricula (também fornecido)
        ComparadorAlunoPorMatricula compPorMatricula = new ComparadorAlunoPorMatricula();
        ComparadorAlunoPorNome compPorNome = new ComparadorAlunoPorNome();
        IArvoreBinaria<Aluno> arv1, arv2;

        arv1 = new ArvoreBinaria<>(compPorMatricula);
        gerador.geraArvoreDegenerada(3, arv1);
        System.out.println(arv1.caminharEmOrdem());

        arv2 = new ArvoreBinaria<>(compPorNome);
        gerador.geraArvorePerfeitamenteBalanceada(1, 3, arv2);
        System.out.println(arv2.caminharEmOrdem());

        // Busca por matrícula (binária)
        String nome1 = s.nextLine();
        System.out.println(arv1.pesquisar(new Aluno(2000000009, nome1)));



        // Busca por nome (varredura total)
        //System.out.println(arv2.pesquisar(new Aluno(0, nome2), compPorNome));




    }

}