package telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import projeto.model.bean.Cliente;
import projeto.model.dao.ClienteDAO;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ClienteTela {

	private JFrame frame;
	private JTextField nome;
	private JTextField cpf;
	private JTextField endereco;
	private JTextField telefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteTela window = new ClienteTela();
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
	public ClienteTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 568, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastrarCliente = new JLabel("Cadastrar Cliente");
		lblCadastrarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarCliente.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		lblCadastrarCliente.setBounds(110, 13, 321, 61);
		frame.getContentPane().add(lblCadastrarCliente);
		
		nome = new JTextField();
		nome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				/*if(nome.getText().equals("Nome Completo")) {
					nome.setText("");
				}*/
			}
			@Override
			public void focusLost(FocusEvent e) {
				nome.setText("Nome Completo");
			}
		});
		nome.setForeground(Color.LIGHT_GRAY);
		nome.setText("Nome Completo");
		nome.setBounds(189, 87, 153, 31);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setHorizontalAlignment(SwingConstants.LEFT);
		cpf.setForeground(Color.LIGHT_GRAY);
		cpf.setText("CPF");
		cpf.setBounds(189, 131, 153, 31);
		frame.getContentPane().add(cpf);
		cpf.setColumns(10);
		
		endereco = new JTextField();
		endereco.setForeground(Color.LIGHT_GRAY);
		endereco.setText("Endere\u00E7o");
		endereco.setBounds(189, 176, 153, 31);
		frame.getContentPane().add(endereco);
		endereco.setColumns(10);
		
		telefone = new JTextField();
		telefone.setForeground(Color.LIGHT_GRAY);
		telefone.setText("Telefone");
		telefone.setBounds(189, 227, 153, 31);
		frame.getContentPane().add(telefone);
		telefone.setColumns(10);
		
		JButton btnFinCadCli = new JButton("Finalizar");
		btnFinCadCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				
				cliente.setNome(nome.getText());
				cliente.setCpf(Long.parseLong(cpf.getText()));
				cliente.setEndereco(endereco.getText());
				cliente.setTelefone(Long.parseLong(telefone.getText()));
				
				dao.Create(cliente);
				
			}
		});
		btnFinCadCli.setBackground(Color.DARK_GRAY);
		btnFinCadCli.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnFinCadCli.setForeground(Color.WHITE);
		btnFinCadCli.setBounds(221, 275, 97, 25);
		frame.getContentPane().add(btnFinCadCli);
		
		JButton btnVoltarCadCli = new JButton("Voltar");
		btnVoltarCadCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnVoltarCadCli.setForeground(Color.WHITE);
		btnVoltarCadCli.setBackground(Color.DARK_GRAY);
		btnVoltarCadCli.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVoltarCadCli.setBounds(53, 321, 97, 25);
		frame.getContentPane().add(btnVoltarCadCli);
	}
}
