package projeto.movimento;

public class Entrada extends Movimentacao {
	
	private long cnpj;
	
	public Entrada(int codigo, int qtd, Double valor, long cnpj) {
		this.setCodigo(codigo);
		this.setQtd(qtd);
		this.setValor(valor);
		this.cnpj = cnpj;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
}
