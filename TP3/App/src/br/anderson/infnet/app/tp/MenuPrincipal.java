package br.anderson.infnet.app.tp;

import java.util.Scanner;
import br.anderson.infnet.app.exceptions.*;
import br.anderson.infnet.app.dominio.*;
import br.anderson.infnet.app.auxiliar.*;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal {
	private List<Pessoa> pessoas;
	
	public MenuPrincipal() {
		pessoas = new ArrayList<Pessoa>();
	}
	
	private void cadastraPeloTipo(int doTipo) throws LimiteRegistroException {
		if (pessoas.size()>=Constantes.TAMANHO) {
			throw new LimiteRegistroException(String.format("\nLimite de registros foi alcançado! Não é possível cadastrar mais de %d docente/discente", Constantes.TAMANHO));
		}
		
		Pessoa pessoa;
		try {
			pessoa = new FabricaPessoa().criar(doTipo);
			pessoas.add( pessoa );
			System.out.println("Código gerado: "+pessoas.size());
		} catch (PessoaTipoException | PessoaNomeException e) {
			e.printStackTrace();
		}
	}
	
	public void apresenta() {
        Scanner in = new Scanner(System.in);
        String opcao;

        do {
			System.out.println("[1] Cadastrar professor");
			System.out.println("[2] Cadastrar aluno");
			System.out.println("[3] Consultar situação de um docente/discente");
			System.out.println("[4] Sair");
			
			System.out.print("Informe a opcao desejada: ");						
			opcao = in.next();

            switch (opcao) {
                case "1":
					try {
						cadastraPeloTipo(Constantes.PROFESSOR_TP);
					} catch (LimiteRegistroException e) {
						e.printStackTrace();
					}
                    break;
                 
                case "2":
					try {
						cadastraPeloTipo(Constantes.ALUNO_TP);
					} catch (LimiteRegistroException e) {
						e.printStackTrace();
					}
                    break;
                    
                case "3":
					try {
						menuOpConsulta();
					} catch (IndiceInvalidoException e) {
						e.printStackTrace();
					}
                    break;
                                
                default:
                    break;
            }

        } while (!"4".equalsIgnoreCase(opcao));   

        in.close();
    }
	
	public void menuOpConsulta() throws IndiceInvalidoException {
		Scanner in = new Scanner(System.in);
		int lIdx;
		
        System.out.print("Informe o código da pessoa: ");
        lIdx = in.nextInt();
        if ((lIdx<1) || (lIdx>pessoas.size())) {
        	throw new IndiceInvalidoException("\nCódigo informado é inexistente ou inválido!");
        }
        System.out.println(pessoas.get(lIdx-1).consultarSituacao());
    }

}
