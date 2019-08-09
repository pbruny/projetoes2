package projeto.cadastrar;

public class CadastrarCliente extends Cadastrar {
	
	private String endereco;
	private String telefone;
	private long cpf;
	
	public CadastrarCliente(String nome, String endereco, String telefone, long cpf) {
		this.setNome(nome);
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}	
}
