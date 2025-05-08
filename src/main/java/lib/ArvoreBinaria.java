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

            if (comp == 0) {
                return noAtual.getValor(); // Valor encontrado
            } else if (comp < 0) {
                noAtual = noAtual.getFilhoEsquerda();

            } else if (comp > 0) {
                noAtual = noAtual.getFilhoDireita();
            }
        }

        return null;

    }


    public T pesquisar(T valor, Comparator comparador2) {

        NoArvore<T> noAtual = this.raiz;

        if (comparador.equals(comparador2)) {

            //System.out.println("comps iguais");

            while (noAtual != null) {
                int comp = comparador2.compare(valor, noAtual.getValor());

                if (comp == 0) {
                    return noAtual.getValor();

                } else if (comp < 0) {
                    noAtual = noAtual.getFilhoEsquerda();

                } else {
                    noAtual = noAtual.getFilhoDireita();

                }
            }

            return null;

        } else {

            //System.out.println("comps diferentes");

            return buscarCompletoPorNomeOuMatricula(this.raiz, valor, comparador2);
        }
    }

    public T buscarCompletoPorNomeOuMatricula(NoArvore<T> no, T valor, Comparator comparador2) {

        if (no == null) {
            return null;
        }

        if (comparador2.compare(valor, no.getValor()) == 0) {
            return no.getValor();
        }

        // Busca na esquerda
        T resultado = buscarCompletoPorNomeOuMatricula(no.getFilhoEsquerda(), valor, comparador2);
        if (resultado != null){
            return resultado;
        }

        return buscarCompletoPorNomeOuMatricula(no.getFilhoDireita(), valor, comparador2);
    }

    @Override
    public T remover(T valor) {
        Remocao<T> resultado = removerRec(raiz, valor);
        raiz = resultado.novoNo;
        return resultado.valorRemovido;
    }

    private Remocao<T> removerRec(NoArvore<T> no, T valor) {
        if (no == null) {
            return new Remocao<>(null, null); // Valor não encontrado
        }

        int comp = comparador.compare(valor, no.getValor());

        if (comp < 0) {
            Remocao<T> res = removerRec(no.getFilhoEsquerda(), valor);
            no.setFilhoEsquerda(res.novoNo);
            return new Remocao<>(no, res.valorRemovido);

        } else if (comp > 0) {
            Remocao<T> res = removerRec(no.getFilhoDireita(), valor);
            no.setFilhoDireita(res.novoNo);
            return new Remocao<>(no, res.valorRemovido);

        } else {

            //sem filhos
            if (no.getFilhoEsquerda() == null && no.getFilhoDireita() == null) {
                return new Remocao<>(null, no.getValor());
            }

            //um filho
            if (no.getFilhoEsquerda() == null) {
                return new Remocao<>(no.getFilhoDireita(), no.getValor());
            }

            if (no.getFilhoDireita() == null) {
                return new Remocao<>(no.getFilhoEsquerda(), no.getValor());
            }

            //dois filhos
            NoArvore<T> sucessor = encontrarMinimo(no.getFilhoDireita());
            T valorSucessor = sucessor.getValor();
            Remocao<T> res = removerRec(no.getFilhoDireita(), valorSucessor);
            no.setValor(valorSucessor);
            no.setFilhoDireita(res.novoNo);
            return new Remocao<>(no, valor);
        }
    }

    private NoArvore<T> encontrarMinimo(NoArvore<T> no) {
        while (no.getFilhoEsquerda() != null) {
            no = no.getFilhoEsquerda();
        }
        return no;
    }

    private static class Remocao<T> {
        NoArvore<T> novoNo;
        T valorRemovido;

        Remocao(NoArvore<T> novoNo, T valorRemovido) {
            this.novoNo = novoNo;
            this.valorRemovido = valorRemovido;
        }
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
        StringBuilder sb = new StringBuilder();
        caminharEmOrdem(this.raiz, sb);

        return sb.toString();
    }

    private void caminharEmOrdem(NoArvore<T> no, StringBuilder sb) {
        if (no != null) {
            caminharEmOrdem(no.getFilhoEsquerda(), sb);
            sb.append(no.getValor()).append("\n");
            caminharEmOrdem(no.getFilhoDireita(), sb);
        }
    }

}
