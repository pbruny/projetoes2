package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import projeto.model.bean.Entrada;
import projeto.model.dao.EntradaDAO;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EntradaTela {

	private JFrame frame;
	private JTextField cnpj;
	private JTextField codigo;
	private JTextField qtd;
	private JTextField preco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntradaTela window = new EntradaTela();
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
	public EntradaTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 580, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistrarEntrada = new JLabel("Registrar Entrada");
		lblRegistrarEntrada.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarEntrada.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		lblRegistrarEntrada.setBounds(110, 13, 361, 61);
		frame.getContentPane().add(lblRegistrarEntrada);
		
		cnpj = new JTextField();
		cnpj.setForeground(Color.LIGHT_GRAY);
		cnpj.setText("CNPJ do Fornecedor");
		cnpj.setBounds(189, 87, 153, 31);
		frame.getContentPane().add(cnpj);
		cnpj.setColumns(10);
		
		codigo = new JTextField();
		codigo.setForeground(Color.LIGHT_GRAY);
		codigo.setText("C\u00F3digo da Pe\u00E7a");
		codigo.setBounds(189, 131, 153, 31);
		frame.getContentPane().add(codigo);
		codigo.setColumns(10);
		
		qtd = new JTextField();
		qtd.setForeground(Color.LIGHT_GRAY);
		qtd.setText("Quantidade");
		qtd.setBounds(189, 176, 153, 31);
		frame.getContentPane().add(qtd);
		qtd.setColumns(10);
		
		preco = new JTextField();
		preco.setForeground(Color.LIGHT_GRAY);
		preco.setText("Pre\u00E7o");
		preco.setBounds(189, 227, 153, 31);
		frame.getContentPane().add(preco);
		preco.setColumns(10);
		
		JButton btnFinRegEnt = new JButton("Finalizar");
		btnFinRegEnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrada entrada = new Entrada();
				EntradaDAO dao = new EntradaDAO();
				
				entrada.setCnpj(Long.parseLong(cnpj.getText()));
				entrada.setCodigoProduto(Integer.parseInt(codigo.getText()));
				entrada.setQtd(Integer.parseInt(qtd.getText()));
				entrada.setValor(Double.parseDouble(preco.getText()));
				
				dao.Create(entrada);
				
			}
		});
		btnFinRegEnt.setForeground(Color.WHITE);
		btnFinRegEnt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnFinRegEnt.setBackground(Color.DARK_GRAY);
		btnFinRegEnt.setBounds(221, 275, 97, 25);
		frame.getContentPane().add(btnFinRegEnt);
		
		JButton btnVoltarRegEnt = new JButton("Voltar");
		btnVoltarRegEnt.setForeground(Color.WHITE);
		btnVoltarRegEnt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVoltarRegEnt.setBackground(Color.DARK_GRAY);
		btnVoltarRegEnt.setBounds(53, 321, 97, 25);
		frame.getContentPane().add(btnVoltarRegEnt);
	}

}
