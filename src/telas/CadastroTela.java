package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroTela {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroTela window = new CadastroTela();
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
	public CadastroTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 671, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastrar = new JLabel("Cadastrar");
		lblCadastrar.setBackground(Color.WHITE);
		lblCadastrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrar.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		lblCadastrar.setBounds(109, 84, 404, 61);
		frame.getContentPane().add(lblCadastrar);
		
		JButton btnCadastrarCliente = new JButton("Cliente");
		btnCadastrarCliente.setForeground(Color.WHITE);
		btnCadastrarCliente.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCadastrarCliente.setBackground(Color.DARK_GRAY);
		btnCadastrarCliente.setToolTipText("");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteTela cliente = new ClienteTela();
				cliente.frame.setVisible(true);
			}
		});
		btnCadastrarCliente.setBounds(50, 218, 131, 61);
		frame.getContentPane().add(btnCadastrarCliente);
		
		JButton btnCadastrarPeca = new JButton("Pe\u00E7a");
		btnCadastrarPeca.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCadastrarPeca.setForeground(Color.WHITE);
		btnCadastrarPeca.setBackground(Color.DARK_GRAY);
		btnCadastrarPeca.setBounds(262, 218, 131, 60);
		btnCadastrarPeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PecasTela pecas = new PecasTela();
				pecas.frame.setVisible(true);
			}
		});
		frame.getContentPane().add(btnCadastrarPeca);
		
		JButton btnCadastrarFornecedor = new JButton("Fornecedor");
		btnCadastrarFornecedor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCadastrarFornecedor.setForeground(Color.WHITE);
		btnCadastrarFornecedor.setBackground(Color.DARK_GRAY);
		btnCadastrarFornecedor.setBounds(475, 218, 131, 60);
		btnCadastrarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FornecedorTela fornecedor = new FornecedorTela();
				fornecedor.frame.setVisible(true);
				
			}
		});
		frame.getContentPane().add(btnCadastrarFornecedor);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBackground(Color.DARK_GRAY);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVoltar.setBounds(39, 340, 97, 25);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		frame.getContentPane().add(btnVoltar);
	}
}
