package projeto.model.bean;

public class Saida {
	
	private long cpf;
	private int codigoProduto;
	private long qtd;
	private Double valorTotal;
	private String formaPag;
	
	public long getCpf() {
		return cpf;
	}
	
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	public int getCodigoProduto() {
		return codigoProduto;
	}
	
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public long getQtd() {
		return qtd;
	}
	
	public void setQtd(long qtd) {
		this.qtd = qtd;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(int quantidade, Double valor) {
		this.valorTotal = quantidade * valor;
	}
	
	public void setValorTotal(Double valor ) {
		this.valorTotal = valor;
	}
	
	public String getFormaPag() {
		return formaPag;
	}
	
	public void setFormaPag(String formaPag) {
		this.formaPag = formaPag;
	}
	
	
}
