/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lib;

import java.util.Comparator;

/**
 *
 * @author victoriocarvalho
 */
public class ArvoreBinaria<T> implements IArvoreBinaria<T> {

    protected NoArvore<T> raiz = null;
    protected Comparator<T> comparador;

    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }

    @Override
    public void adicionar(T novoValor) {

        NoArvore<T> noAtual, noAntigo;

        NoArvore<T> novoFilho = new NoArvore<>(novoValor);
        noAtual = raiz;

        if (this.raiz == null) {
            raiz = novoFilho;

        } else {
            while (noAtual != null) {
                if (comparador.compare(novoValor, noAtual.getValor()) <= 0) {
                    noAntigo = noAtual;
                    noAtual = noAntigo.getFilhoEsquerda();

                    if (noAtual == null) {
                        noAntigo.setFilhoEsquerda(novoFilho);

                    }

                } else {
                    noAntigo = noAtual;
                    noAtual = noAntigo.getFilhoDireita();

                    if (noAtual == null) {
                        noAntigo.setFilhoDireita(novoFilho);

                    }
                }
            }
        }

    }

    @Override
    public T pesquisar(T valor) {

        int comp;
        NoArvore<T> noAtual = this.raiz;

        while (noAtual != null) {
            comp = comparador.compare(valor, noAtual.getValor());

            if (comp > 0) {
                noAtual = noAtual.getFilhoEsquerda();

            } else if (comp < 0) {
                noAtual = noAtual.getFilhoDireita();
            }
        }

        return noAtual.getValor();

    }

    @Override
    public T pesquisar(T valor, Comparator comparador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        return calcularAltura(raiz);
    }

    public int calcularAltura(NoArvore no){
        if (no == null) {
            return -1; // Altura de uma árvore vazia é -1
        } else {
            int alturaEsquerda = calcularAltura(no.getFilhoEsquerda());
            int alturaDireita = calcularAltura(no.getFilhoDireita());
            return Math.max(alturaEsquerda, alturaDireita) + 1;
        }
    }

    @Override
    public int quantidadeNos() {
        return contarNos(raiz);
    }

    private int contarNos(NoArvore no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNos(no.getFilhoEsquerda()) + contarNos(no.getFilhoDireita());
    }

    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }

    @Override
    public String caminharEmOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
    }

}
