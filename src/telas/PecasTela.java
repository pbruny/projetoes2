package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import projeto.model.bean.Pecas;
import projeto.model.dao.PecasDAO;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PecasTela {

	private JFrame frame;
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
		
		JLabel lblCadastrarPeça = new JLabel("Cadastrar Pe\u00E7a");
		lblCadastrarPeça.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		lblCadastrarPeça.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastrarPeça.setBounds(110, 13, 321, 61);
		frame.getContentPane().add(lblCadastrarPeça);
		
		nome = new JTextField();
		nome.setForeground(Color.LIGHT_GRAY);
		nome.setText("Nome da Pe\u00E7a");
		nome.setBounds(189, 87, 153, 31);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		codigo = new JTextField();
		codigo.setForeground(Color.LIGHT_GRAY);
		codigo.setText("C\u00F3digo da Pe\u00E7a");
		codigo.setBounds(189, 131, 153, 31);
		frame.getContentPane().add(codigo);
		codigo.setColumns(10);
		
		JButton btnFinCadPeça = new JButton("Finalizar");
		btnFinCadPeça.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pecas peca = new Pecas();
				PecasDAO dao = new PecasDAO();
				
				peca.setCodigoPeca(Integer.parseInt(codigo.getText()));
				peca.setNome(nome.getText());
				
				dao.Create(peca);
			}
		});
		btnFinCadPeça.setForeground(Color.WHITE);
		btnFinCadPeça.setBackground(Color.DARK_GRAY);
		btnFinCadPeça.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnFinCadPeça.setBounds(212, 182, 97, 25);
		frame.getContentPane().add(btnFinCadPeça);
		
		JButton btnVoltarCadPeça = new JButton("Voltar");
		btnVoltarCadPeça.setBackground(Color.DARK_GRAY);
		btnVoltarCadPeça.setForeground(Color.WHITE);
		btnVoltarCadPeça.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVoltarCadPeça.setBounds(52, 264, 97, 25);
		frame.getContentPane().add(btnVoltarCadPeça);
	}

}
