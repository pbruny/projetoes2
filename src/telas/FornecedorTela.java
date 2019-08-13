package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

import projeto.model.bean.Fornecedor;
import projeto.model.dao.FornecedorDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FornecedorTela {

	JFrame frame;
	private JTextField nome;
	private JTextField cnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FornecedorTela window = new FornecedorTela();
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
	public FornecedorTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 556, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastroFornecedor = new JLabel("Cadastrar Fornecedor");
		lblCadastroFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastroFornecedor.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		lblCadastroFornecedor.setBounds(110, 13, 361, 61);
		frame.getContentPane().add(lblCadastroFornecedor);
		
		nome = new JTextField();
		nome.setForeground(Color.LIGHT_GRAY);
		nome.setBounds(189, 102, 153, 31);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		cnpj = new JTextField();
		cnpj.setForeground(Color.LIGHT_GRAY);
		cnpj.setBounds(189, 161, 153, 31);
		frame.getContentPane().add(cnpj);
		cnpj.setColumns(10);
		
		JButton btnFinCadForn = new JButton("Finalizar");
		btnFinCadForn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fornecedor fornecedor = new Fornecedor();
				FornecedorDAO dao = new FornecedorDAO();
				
				if(cnpj.getText().isEmpty() || nome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "É necessário o preenchimento de todos os campos");
				} else {
					fornecedor.setCnpj(Long.parseLong(cnpj.getText()));
					fornecedor.setNome(nome.getText());
					
					dao.Create(fornecedor);
					frame.dispose();
				}
				
			}
		});
		btnFinCadForn.setBackground(Color.DARK_GRAY);
		btnFinCadForn.setForeground(Color.WHITE);
		btnFinCadForn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnFinCadForn.setBounds(209, 217, 97, 25);
		frame.getContentPane().add(btnFinCadForn);
		
		JButton btnVoltarCadForn = new JButton("Voltar");
		btnVoltarCadForn.setBackground(Color.DARK_GRAY);
		btnVoltarCadForn.setForeground(Color.WHITE);
		btnVoltarCadForn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVoltarCadForn.setBounds(52, 264, 97, 25);
		btnVoltarCadForn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent argo0) {
				frame.dispose();
				
			}
		});
		frame.getContentPane().add(btnVoltarCadForn);
		
		JLabel lblNomeDoFornecedor = new JLabel("Nome do Fornecedor");
		lblNomeDoFornecedor.setBounds(189, 85, 181, 14);
		frame.getContentPane().add(lblNomeDoFornecedor);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setBounds(189, 144, 46, 14);
		frame.getContentPane().add(lblCnpj);
	}

}
