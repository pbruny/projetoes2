package telas;
import projeto.model.dao.*;
import projeto.model.bean.*;

public class Teste {

	public static void main(String[] args) {

		EntradaDAO dao = new EntradaDAO();
		Entrada entrada = new Entrada();
		
		for(Entrada ent: dao.read()) {
			if(ent.getCodigoProduto() == 15) {
				entrada.setCnpj(ent.getCnpj());
				entrada.setCodigoProduto(ent.getCodigoProduto());
				entrada.setQtd(150);
				entrada.setValor(ent.getValor());
				System.out.println("Entrou nesta porra");
				System.out.println(entrada.getQtd());
			}
		}
		
		dao.Update(entrada);

	}

}
