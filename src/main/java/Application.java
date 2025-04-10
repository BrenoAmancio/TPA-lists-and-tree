import list.LinkedList;

public class Application {
    public static void main(String[] args) {
        LinkedList<Aluno> l = new LinkedList<>(true);

        Aluno a1 = new Aluno(1, "Zé", 50);
        Aluno a2 = new Aluno(2, "Mané", 50);

        l.add(a1);
        l.add(a2);
        System.out.println(l);
    }
}
