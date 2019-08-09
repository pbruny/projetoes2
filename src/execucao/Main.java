package execucao;
import projeto.cadastrar.*;
import projeto.movimento.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CadastrarCliente cliente = new CadastrarCliente("Paulo Lima", "Rua dom tomaz 215 cohab 6 Petrolina", "988336917", 10322835488L);
		CadastrarPeca peca1 = new CadastrarPeca("Bobina", 1);
		CadastrarFornecedor f1 = new CadastrarFornecedor("Autovale Peças", 1654231543);
		Entrada m1 = new Entrada(1, 30, 29.99, 1654231543);
		Saida m2 = new Saida(m1.getCodigo(), 2, m1.getValor(), 10322835488L);
		
		if(m1.getCodigo() == peca1.getCodigo()) {
			System.out.printf("A peça de codigo %d foi fornecida pelo fornecedor %s com cnpj %d a um valor de %.2f\n", peca1.getCodigo(), f1.getNome(), f1.getCnpj(), m1.getValor());
		}
		
		if(cliente.getCpf() == m2.getCpf()) {
			System.out.printf("O cliente %s comprou a(s) peça(s) anterior por %.2f", cliente.getNome(), m2.getValorTotal());			
		}
		
	}

}
