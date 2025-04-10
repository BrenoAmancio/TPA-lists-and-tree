public class Aluno implements Comparable<Aluno> {
    private int matricula, nota;
    private String nome;

    public Aluno(int matricula, String nome, int nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return matricula + " - " + nome;
    }

    @Override
    public int compareTo(Aluno a) {
        return this.nome.compareTo(a.nome);
    }

    @Override
    public boolean equals(Object a) {
        if (a instanceof Aluno) {
            return this.matricula == ((Aluno) a).matricula;

        } else {
            return false;
        }
    }
}
