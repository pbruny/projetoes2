package projeto.cadastrar;

public class CadastrarFornecedor extends Cadastrar {
	
	private long cnpj;
	
	public CadastrarFornecedor(String nome, long cnpj) {
		this.setNome(nome);
		this.cnpj = cnpj;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
