package telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

	JFrame frame;
	private JTextField nome;
	private JTextField cpf;
	private JTextField endereco;
	private JTextField telefone;
	private JLabel lblNomeCompleto;
	private JLabel lblCpf;
	private JLabel lblEndereo;
	private JLabel lblTelefone;

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
		nome.setForeground(Color.LIGHT_GRAY);
		nome.setBounds(189, 85, 153, 31);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		cpf = new JTextField();
		cpf.setHorizontalAlignment(SwingConstants.LEFT);
		cpf.setForeground(Color.LIGHT_GRAY);
		cpf.setBounds(189, 140, 153, 31);
		frame.getContentPane().add(cpf);
		cpf.setColumns(10);
		
		endereco = new JTextField();
		endereco.setForeground(Color.LIGHT_GRAY);
		endereco.setBounds(189, 194, 153, 31);
		frame.getContentPane().add(endereco);
		endereco.setColumns(10);
		
		telefone = new JTextField();
		telefone.setForeground(Color.LIGHT_GRAY);
		telefone.setBounds(189, 249, 153, 31);
		frame.getContentPane().add(telefone);
		telefone.setColumns(10);
		
		JButton btnFinCadCli = new JButton("Finalizar");
		btnFinCadCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cliente cliente = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				
				if(nome.getText().isEmpty() || cpf.getText().isEmpty() || endereco.getText().isEmpty() || telefone.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "É necessário o preenchimento de todos os campos");
				} else {
					cliente.setNome(nome.getText());
					cliente.setCpf(Long.parseLong(cpf.getText()));
					cliente.setEndereco(endereco.getText());
					cliente.setTelefone(Long.parseLong(telefone.getText()));
					
					dao.Create(cliente);
					frame.dispose();
				}
			}
		});
		btnFinCadCli.setBackground(Color.DARK_GRAY);
		btnFinCadCli.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnFinCadCli.setForeground(Color.WHITE);
		btnFinCadCli.setBounds(223, 321, 97, 25);
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
		btnVoltarCadCli.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent argo0) {
				frame.dispose();
				
			}
		});
		frame.getContentPane().add(btnVoltarCadCli);
		
		lblNomeCompleto = new JLabel("Nome completo");
		lblNomeCompleto.setBounds(189, 72, 116, 14);
		frame.getContentPane().add(lblNomeCompleto);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(189, 127, 46, 14);
		frame.getContentPane().add(lblCpf);
		
		lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(189, 182, 116, 14);
		frame.getContentPane().add(lblEndereo);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(189, 236, 153, 14);
		frame.getContentPane().add(lblTelefone);
	}
}
