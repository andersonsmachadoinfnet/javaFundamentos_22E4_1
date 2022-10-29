import java.util.Scanner;

public class TP1 {

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
        menu();
        System.out.println("Processamento finalizado!!!"); 
    }
}