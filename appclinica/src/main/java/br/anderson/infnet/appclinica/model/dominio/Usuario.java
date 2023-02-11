package br.anderson.infnet.appclinica.model.dominio;

public class Usuario {
	private    int userId;
	private String nome;
	private String senha;
	private String email;
	
	public Usuario(String nome, String senha) {
		this.setUserId(-1);
		this.setNome(nome);
		this.setSenha(senha);
	}
	
	public String toString() {
		return String.format("Usuário: %s (%s) [%s]", nome, email, getUserIdLabel());
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUserIdLabel( ) {
		if (this.userId==-1) {
			return "Sem identificador!";
		}
		else {
			return String.valueOf(this.userId);
		}
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
