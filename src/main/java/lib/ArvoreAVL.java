package lib;

import java.util.Comparator;

public class ArvoreAVL <T extends Comparable> extends ArvoreBinaria<T>{

    public ArvoreAVL(Comparator<T> comp) {
        super(comp);

    }

    @Override
    protected NoArvore<T> adicionarRecursivo(NoArvore<T> raiz, NoArvore<T> novoFilho) {
        raiz = super.adicionarRecursivo(raiz, novoFilho);

        if (fatorBalanceamento(raiz) > 1) {
            if(fatorBalanceamento(raiz.getFilhoDireita())>0){
                raiz = this.rotacaoEsquerda(raiz);

            }
            else {
                raiz = this.rotacaoDireitaEsquerda(raiz);

            }
        } else if (fatorBalanceamento(raiz) < -1) {
            if (fatorBalanceamento(raiz.getFilhoEsquerda()) < 0){
                raiz = this.rotacaoDireita(raiz);

            } else {
                raiz = this.rotacaoEsquerdaDireita(raiz);

            }
        }
        return raiz;
    }

    private NoArvore<T> rotacaoEsquerda(NoArvore<T> r) {
        NoArvore<T> f = r.getFilhoDireita();
        r.setFilhoDireita(f.getFilhoEsquerda());
        f.setFilhoEsquerda(r);

        return f;
    }

    private NoArvore<T> rotacaoDireita(NoArvore<T> r) {
        NoArvore<T> f = r.getFilhoEsquerda();
        r.setFilhoEsquerda(f.getFilhoDireita());
        f.setFilhoDireita(r);

        return f;
    }

    private NoArvore<T> rotacaoEsquerdaDireita(NoArvore<T> r) {
        r.setFilhoEsquerda(rotacaoEsquerda(r.getFilhoEsquerda()));

        return rotacaoDireita(r);
    }

    private NoArvore<T> rotacaoDireitaEsquerda(NoArvore<T> r) {
        r.setFilhoDireita(rotacaoDireita(r.getFilhoDireita()));

        return rotacaoEsquerda(r);
    }

    private int fatorBalanceamento(NoArvore<T> raiz) {
        int alturaDireita = calcularAltura(raiz.getFilhoDireita());
        int alturaEsquerda = calcularAltura(raiz.getFilhoEsquerda());

        return alturaDireita - alturaEsquerda;
    }
}
