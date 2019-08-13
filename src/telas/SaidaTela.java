package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import projeto.model.bean.Saida;
import projeto.model.dao.SaidaDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SaidaTela {

	JFrame frame;
	private JTextField cpf;
	private JTextField codigo;
	private JTextField qtd;
	private JTextField formapag;
	private JTextField valor;
	private JLabel lblCpfDoCliente;
	private JLabel lblCdigoDaPea;
	private JLabel lblQuantidade;
	private JLabel lblValor;
	private JLabel lblOpoDePagamento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaidaTela window = new SaidaTela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SaidaTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 565, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegSaída = new JLabel("Registrar Sa\u00EDda");
		lblRegSaída.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegSaída.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		lblRegSaída.setBounds(105, 11, 361, 61);
		frame.getContentPane().add(lblRegSaída);
		
		cpf = new JTextField();
		cpf.setForeground(Color.LIGHT_GRAY);
		cpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cpf.setBounds(191, 83, 153, 31);
		frame.getContentPane().add(cpf);
		cpf.setColumns(10);
		
		codigo = new JTextField();
		codigo.setForeground(Color.LIGHT_GRAY);
		codigo.setBounds(191, 133, 153, 31);
		frame.getContentPane().add(codigo);
		codigo.setColumns(10);
		
		qtd = new JTextField();
		qtd.setForeground(Color.LIGHT_GRAY);
		qtd.setBounds(191, 182, 153, 31);
		frame.getContentPane().add(qtd);
		qtd.setColumns(10);
		
		valor = new JTextField();
		valor.setForeground(Color.LIGHT_GRAY);
		valor.setColumns(10);
		valor.setBounds(191, 235, 153, 31);
		frame.getContentPane().add(valor);
		
		formapag = new JTextField();
		formapag.setForeground(Color.LIGHT_GRAY);
		formapag.setBounds(191, 285, 153, 31);
		frame.getContentPane().add(formapag);
		formapag.setColumns(10);
		
		JLabel lblTotalText = new JLabel("Total a Pagar");
		lblTotalText.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalText.setBounds(204, 317, 129, 16);
		frame.getContentPane().add(lblTotalText);
		
		JLabel valorTotal = new JLabel("R$ 00,00");
		valorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		valorTotal.setBounds(226, 337, 83, 16);
		frame.getContentPane().add(valorTotal);
		
		JButton btnFinRegSaída = new JButton("Finalizar");
		btnFinRegSaída.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Saida saida = new Saida();
				SaidaDAO dao = new SaidaDAO();
				
				if(cpf.getText().isEmpty() || codigo.getText().isEmpty() || qtd.getText().isEmpty() || valor.getText().isEmpty() || formapag.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "É necessário o preenchimento de todos os campos");
				} else {
					saida.setValorTotal(Integer.parseInt(qtd.getText()), Double.parseDouble(valor.getText()));
					
					Double total = saida.getValorTotal();
					int option;
					option = JOptionPane.showConfirmDialog(null, "O valor total da sua compra é R$ " + total + "?");
					if(option == JOptionPane.YES_OPTION) {
						saida.setCpf(Long.parseLong(cpf.getText()));
						saida.setCodigoProduto(Integer.parseInt(codigo.getText()));
						saida.setQtd(Integer.parseInt(qtd.getText()));
						saida.setValorTotal(Integer.parseInt(qtd.getText()), Double.parseDouble(valor.getText()));
						saida.setFormaPag(formapag.getText());
						JOptionPane.showMessageDialog(null, "Compra Confirmada!");
						
						valorTotal.setText("RS "+total);
						
						dao.Create(saida);
						
						//frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Revise os campos de quantidade e valor");
					}
				}
				
				
			}
		});
		
		btnFinRegSaída.setBackground(Color.DARK_GRAY);
		btnFinRegSaída.setForeground(Color.WHITE);
		btnFinRegSaída.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnFinRegSaída.setBounds(224, 354, 97, 25);
		frame.getContentPane().add(btnFinRegSaída);
		
		JButton btnVoltarRegSaída = new JButton("Voltar");
		btnVoltarRegSaída.setForeground(Color.WHITE);
		btnVoltarRegSaída.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVoltarRegSaída.setBackground(Color.DARK_GRAY);
		btnVoltarRegSaída.setBounds(52, 354, 97, 25);
		btnVoltarRegSaída.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				
			}
		});
		frame.getContentPane().add(btnVoltarRegSaída);
		
		lblCpfDoCliente = new JLabel("CPF do Cliente");
		lblCpfDoCliente.setBounds(191, 71, 130, 14);
		frame.getContentPane().add(lblCpfDoCliente);
		
		lblCdigoDaPea = new JLabel("C\u00F3digo da pe\u00E7a");
		lblCdigoDaPea.setBounds(191, 118, 165, 14);
		frame.getContentPane().add(lblCdigoDaPea);
		
		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(191, 168, 103, 14);
		frame.getContentPane().add(lblQuantidade);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(191, 220, 46, 14);
		frame.getContentPane().add(lblValor);
		
		lblOpoDePagamento = new JLabel("Op\u00E7\u00E3o de pagamento");
		lblOpoDePagamento.setBounds(191, 270, 153, 14);
		frame.getContentPane().add(lblOpoDePagamento);
	}
}
