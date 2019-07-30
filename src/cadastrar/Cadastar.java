package cadastrar;

public abstract class Cadastar {
	
	private String nome;
	private String endereco;
	private String telefone;
	private int cpf;
	private int cnpj;
	private int codigo;
	
	
	public abstract String getNome();

	public abstract void setNome();

	public abstract String getEndereco();

	public abstract void setEndereco();
	
	public abstract String getTelefone();

	public abstract void setTelefone();
	
	public abstract String getCpf();

	public abstract void setCpf();
	
	public abstract String getCnpj();

	public abstract void setCnpj();

	public abstract String getCodigo();

	public abstract void setCodigo();
	
	
	
	
	
	
	
}
