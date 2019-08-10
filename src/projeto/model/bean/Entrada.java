package projeto.model.bean;

public class Entrada {

	private int id;
	private int codigoProduto;
	private long cnpj;
	private int qtd;
	private Double valor;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCodigoProduto() {
		return codigoProduto;
	}
	
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public long getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
	public int getQtd() {
		return qtd;
	}
	
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
