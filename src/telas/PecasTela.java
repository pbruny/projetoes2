package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import projeto.model.bean.Pecas;
import projeto.model.dao.PecasDAO;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PecasTela {

	JFrame frame;
	private JTextField codigo;
	private JTextField nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PecasTela window = new PecasTela();
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
	public PecasTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 555, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCadastrarPeša = new JLabel("Cadastrar Pe\u00E7a");
		lblCadastrarPeša.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		lblCadastrarPeša.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarPeša.setBounds(110, 13, 321, 61);
		frame.getContentPane().add(lblCadastrarPeša);
		
		nome = new JTextField();
		nome.setForeground(Color.LIGHT_GRAY);
		nome.setBounds(189, 111, 153, 31);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		codigo = new JTextField();
		codigo.setForeground(Color.LIGHT_GRAY);
		codigo.setBounds(189, 168, 153, 31);
		frame.getContentPane().add(codigo);
		codigo.setColumns(10);
		
		JButton btnFinCadPeša = new JButton("Finalizar");
		btnFinCadPeša.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pecas peca = new Pecas();
				PecasDAO dao = new PecasDAO();
				
				if(codigo.getText().isEmpty() || nome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "╔ necessßrio o preenchimento de todos os campos");
				} else {
					peca.setCodigoPeca(Integer.parseInt(codigo.getText()));
					peca.setNome(nome.getText());
					
					dao.Create(peca);
					frame.dispose();
				}
				
			}
		});
		btnFinCadPeša.setForeground(Color.WHITE);
		btnFinCadPeša.setBackground(Color.DARK_GRAY);
		btnFinCadPeša.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnFinCadPeša.setBounds(212, 216, 97, 25);
		frame.getContentPane().add(btnFinCadPeša);
		
		JButton btnVoltarCadPeša = new JButton("Voltar");
		btnVoltarCadPeša.setBackground(Color.DARK_GRAY);
		btnVoltarCadPeša.setForeground(Color.WHITE);
		btnVoltarCadPeša.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVoltarCadPeša.setBounds(52, 264, 97, 25);
		btnVoltarCadPeša.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(btnVoltarCadPeša);
		
		JLabel lblNomeDaPea = new JLabel("Nome da pe\u00E7a");
		lblNomeDaPea.setBounds(189, 96, 120, 14);
		frame.getContentPane().add(lblNomeDaPea);
		
		JLabel lblCdigoDaPea = new JLabel("C\u00F3digo da pe\u00E7a");
		lblCdigoDaPea.setBounds(189, 154, 97, 14);
		frame.getContentPane().add(lblCdigoDaPea);
	}

}
