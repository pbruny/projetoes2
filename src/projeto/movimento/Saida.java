package projeto.movimento;

public class Saida extends Movimentacao {
	
	private long cpf;
	
	public Saida(int codigo, int qtd, Double valor, long cpf) {
		this.setCodigo(codigo);
		this.setQtd(qtd);
		this.setValor(valor);
		this.cpf = cpf;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public Double getValorTotal() {
		return this.getQtd() * this.getValor();
	}
	
}
