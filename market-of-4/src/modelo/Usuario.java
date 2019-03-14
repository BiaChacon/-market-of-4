package modelo;

public class Usuario {
	
	int id;
	String nome;
	String email;
	String senha;
	boolean tipo;
	
	public Usuario() {}
	
	public Usuario(int id, String nome, String email, String senha, boolean tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Usuario(String nome, String email, String senha, boolean tipo) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	
	public Usuario(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
}
