package projeto.cadastrar;

public class CadastrarPeca extends Cadastrar {
	private int codigo;
	
	public CadastrarPeca(String nome, int codigo) {
		this.setNome(nome);
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
}
