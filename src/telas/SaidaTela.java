package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
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

	private JFrame frame;
	private JTextField cpf;
	private JTextField codigo;
	private JTextField qtd;
	private JTextField formapag;
	private JTextField valor;

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
		cpf.setText("CPF do Cliente");
		cpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cpf.setBounds(191, 76, 153, 31);
		frame.getContentPane().add(cpf);
		cpf.setColumns(10);
		
		codigo = new JTextField();
		codigo.setForeground(Color.LIGHT_GRAY);
		codigo.setText("C\u00F3digo da Pe\u00E7a");
		codigo.setBounds(191, 118, 153, 31);
		frame.getContentPane().add(codigo);
		codigo.setColumns(10);
		
		qtd = new JTextField();
		qtd.setForeground(Color.LIGHT_GRAY);
		qtd.setText("Quantidade");
		qtd.setBounds(191, 160, 153, 31);
		frame.getContentPane().add(qtd);
		qtd.setColumns(10);
		
		valor = new JTextField();
		valor.setText("Valor");
		valor.setForeground(Color.LIGHT_GRAY);
		valor.setColumns(10);
		valor.setBounds(191, 202, 153, 31);
		frame.getContentPane().add(valor);
		
		formapag = new JTextField();
		formapag.setForeground(Color.LIGHT_GRAY);
		formapag.setText("Op\u00E7\u00E3o de Pagamento");
		formapag.setBounds(191, 244, 153, 31);
		frame.getContentPane().add(formapag);
		formapag.setColumns(10);
		
		JLabel lblTotalText = new JLabel("Total a Pagar");
		lblTotalText.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalText.setBounds(204, 286, 129, 16);
		frame.getContentPane().add(lblTotalText);
		
		JLabel valorTotal = new JLabel("R$ 00,00");
		valorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		valorTotal.setBounds(238, 307, 56, 16);
		frame.getContentPane().add(valorTotal);
		
		JButton btnFinRegSaída = new JButton("Finalizar");
		btnFinRegSaída.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Saida saida = new Saida();
				SaidaDAO dao = new SaidaDAO();
				
				saida.setCpf(Long.parseLong(cpf.getText()));
				saida.setCodigoProduto(Integer.parseInt(codigo.getText()));
				saida.setQtd(Integer.parseInt(qtd.getText()));
				saida.setValorTotal(Integer.parseInt(qtd.getText()), Double.parseDouble(valor.getText()));
				saida.setFormaPag(Integer.parseInt(formapag.getText()));
				
				Double total = saida.getValorTotal();
				
				valorTotal.setText("RS "+total);
				
				dao.Create(saida);
				
			}
		});
		
		btnFinRegSaída.setBackground(Color.DARK_GRAY);
		btnFinRegSaída.setForeground(Color.WHITE);
		btnFinRegSaída.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnFinRegSaída.setBounds(225, 336, 97, 25);
		frame.getContentPane().add(btnFinRegSaída);
		
		JButton btnVoltarRegSaída = new JButton("Voltar");
		btnVoltarRegSaída.setForeground(Color.WHITE);
		btnVoltarRegSaída.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVoltarRegSaída.setBackground(Color.DARK_GRAY);
		btnVoltarRegSaída.setBounds(52, 354, 97, 25);
		frame.getContentPane().add(btnVoltarRegSaída);
	}
}
