import java.util.Scanner;

public class TP1 {
    private static final int TAMANHO = 2;
    private static String[] alunos;
    private static float[]  notaAv1;
    private static float[]  notaAv2;

    public static void varInicializa() {
        alunos  = new String[TAMANHO];
        notaAv1 = new float[TAMANHO];
        notaAv2 = new float[TAMANHO];
    }

    public static void menu() {
        Scanner in = new Scanner(System.in);
        String opcao;

        do {
			System.out.println("[1] Registrar as notas de um novo aluno");
			System.out.println("[2] Consultar boletim de um aluno");
			System.out.println("[3] Consultar notas da turma");
			System.out.println("[4] Sair");
			
			System.out.print("Informe a opcao desejada: ");						
			opcao = in.next();
        } while (!"4".equalsIgnoreCase(opcao));   

        in.close();
    } 

    public static void main(String[] args) {
        varInicializa();
        menu();
        System.out.println("Processamento finalizado!!!"); 
    }
}