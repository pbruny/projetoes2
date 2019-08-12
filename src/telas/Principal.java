package telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal implements ActionListener{

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 694, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNomeSistema = new JLabel("MMPP System");
		lblNomeSistema.setBounds(109, 84, 404, 61);
		lblNomeSistema.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeSistema.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));
		frame.getContentPane().add(lblNomeSistema);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(50, 218, 131, 60);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCadastrar.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(btnCadastrar);
		btnCadastrar.addActionListener(this);
		
		JButton btnEntrada = new JButton("Entrada");
		btnEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntradaTela entrada = new EntradaTela();
				entrada.frame.setVisible(true);
			}
		});
		btnEntrada.setBounds(262, 218, 131, 60);
		btnEntrada.setForeground(Color.WHITE);
		btnEntrada.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEntrada.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(btnEntrada);
		
		JButton btnSaída = new JButton("Sa\u00EDda");
		btnSaída.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaidaTela saida = new SaidaTela();
				saida.frame.setVisible(true);
			}
		});
		btnSaída.setBounds(475, 218, 131, 60);
		btnSaída.setForeground(Color.WHITE);
		btnSaída.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSaída.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(btnSaída);
	}


	public void actionPerformed(ActionEvent e) {
		//if(e.getSource() == btnCadastrar){
		CadastroTela cadastro = new CadastroTela();
		
		cadastro.frame.setVisible(true);
		
	}
	}
//}
