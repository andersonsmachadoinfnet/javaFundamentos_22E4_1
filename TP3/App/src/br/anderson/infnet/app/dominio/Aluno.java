package br.anderson.infnet.app.dominio;

import java.util.Scanner;

import br.anderson.infnet.app.auxiliar.Constantes;
import br.anderson.infnet.app.exceptions.*;

public class Aluno extends Pessoa {
	private float notaTP[];
	private float notaAT;
	
	public Aluno() {
		setNotaTP(new float[Constantes.TPs]);
        setNotaAT(0);
	}

	@Override
	public String consultarSituacao() {
		return String.format("Aluno(s) %s está %s", super.getNomeCompleto(), this.alunoSituacao(this.alunoCalculaMedia()));
	}
	
	private float alunoCalculaMedia() {
		int idx;
		float mediaTp=0;
		for (idx=0;idx<Constantes.TPs;idx++) {
			mediaTp = mediaTp + this.notaTP[idx];
		}
		mediaTp = mediaTp / Constantes.TPs; 
		return ((mediaTp + this.notaAT) / 2);
    }
	
	private String alunoSituacao(float pMedia) {
        if (pMedia<4) {
            return "Reprovado";
        } else if (pMedia < 7) {
            return "Prova Final";
        } else {
            return "Aprovado";
        }
    }
	
	@Override
	public Pessoa entradaDados() throws PessoaNomeException {
		super.entradaDados();
		Scanner in = new Scanner(System.in);
		int idx;
		for (idx=0;idx<Constantes.TPs;idx++) {
			System.out.print(String.format("Informe nota do TP%d: ", idx+1));	
			this.notaTP[idx] = in.nextFloat();
		}
		
		System.out.print("Informe nota do AT: ");	
		this.notaAT = in.nextFloat();
		
		return this;
	}

	public float[] getNotaTP() {
		return notaTP;
	}

	public void setNotaTP(float notaTP[]) {
		this.notaTP = notaTP;
	}

	public float getNotaAT() {
		return notaAT;
	}

	public void setNotaAT(float notaAT) {
		this.notaAT = notaAT;
	}

}
