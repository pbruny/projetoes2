package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

	JFrame frame;
	private JTextField cnpj;
	private JTextField codigo;
	private JTextField qtd;
	private JTextField preco;
	private JLabel lblCnpjDoFornecedor;
	private JLabel label;
	private JLabel lblCdigoDaPea;
	private JLabel lblQuantidade;
	private JLabel lblPreo;

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
		cnpj.setBounds(189, 85, 153, 31);
		frame.getContentPane().add(cnpj);
		cnpj.setColumns(10);
		
		codigo = new JTextField();
		codigo.setForeground(Color.LIGHT_GRAY);
		codigo.setBounds(189, 144, 153, 31);
		frame.getContentPane().add(codigo);
		codigo.setColumns(10);
		
		qtd = new JTextField();
		qtd.setForeground(Color.LIGHT_GRAY);
		qtd.setBounds(189, 200, 153, 31);
		frame.getContentPane().add(qtd);
		qtd.setColumns(10);
		
		preco = new JTextField();
		preco.setForeground(Color.LIGHT_GRAY);
		preco.setBounds(189, 254, 153, 31);
		frame.getContentPane().add(preco);
		preco.setColumns(10);
		
		JButton btnFinRegEnt = new JButton("Finalizar");
		btnFinRegEnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entrada entrada = new Entrada();
				Entrada entradaAux = new Entrada();
				EntradaDAO dao = new EntradaDAO();
				
				if(cnpj.getText().isEmpty() || codigo.getText().isEmpty() || qtd.getText().isEmpty() || preco.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "É necessário o preenchimento de todos os campos");
				} else {
						if(dao.read().isEmpty()) {
							entrada.setCnpj(Long.parseLong(cnpj.getText()));
							entrada.setCodigoProduto(Integer.parseInt(codigo.getText()));
							entrada.setQtd(Integer.parseInt(qtd.getText()));
							entrada.setValor(Double.parseDouble(preco.getText()));
							dao.Create(entrada);
							//JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
						}
						else {
						for(Entrada ent: dao.read()) {
							entradaAux.setCnpj(ent.getCnpj());
							entradaAux.setCodigoProduto(ent.getCodigoProduto());
							entradaAux.setQtd(ent.getQtd());
							entradaAux.setValor(ent.getValor());
							
							if(Integer.parseInt(codigo.getText()) == entradaAux.getCodigoProduto()) {
								entrada.setCnpj(Long.parseLong(cnpj.getText()));
								entrada.setCodigoProduto(Integer.parseInt(codigo.getText()));
								entrada.setQtd(Integer.parseInt(qtd.getText()) + entradaAux.getQtd());
								entrada.setValor(Double.parseDouble(preco.getText()));
								dao.Update(entrada);
								JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
								System.out.println("caiu aqui");
								break;
							} else {
								entrada.setCnpj(Long.parseLong(cnpj.getText()));
								entrada.setCodigoProduto(Integer.parseInt(codigo.getText()));
								entrada.setQtd(Integer.parseInt(qtd.getText()));
								entrada.setValor(Double.parseDouble(preco.getText()));
								dao.Create(entrada);
								//JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
								break;
							}
							
						}
					}
				}
					
				frame.dispose();
			}
				
				
				
			});
		btnFinRegEnt.setForeground(Color.WHITE);
		btnFinRegEnt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnFinRegEnt.setBackground(Color.DARK_GRAY);
		btnFinRegEnt.setBounds(221, 321, 97, 25);
		frame.getContentPane().add(btnFinRegEnt);
		
		JButton btnVoltarRegEnt = new JButton("Voltar");
		btnVoltarRegEnt.setForeground(Color.WHITE);
		btnVoltarRegEnt.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnVoltarRegEnt.setBackground(Color.DARK_GRAY);
		btnVoltarRegEnt.setBounds(53, 321, 97, 25);
		btnVoltarRegEnt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				
			}
		});
		frame.getContentPane().add(btnVoltarRegEnt);
		
		lblCnpjDoFornecedor = new JLabel("CNPJ do Fornecedor");
		lblCnpjDoFornecedor.setBounds(189, 72, 129, 14);
		frame.getContentPane().add(lblCnpjDoFornecedor);
		
		label = new JLabel("");
		label.setBounds(189, 136, 46, 14);
		frame.getContentPane().add(label);
		
		lblCdigoDaPea = new JLabel("C\u00F3digo da pe\u00E7a");
		lblCdigoDaPea.setBounds(189, 127, 97, 14);
		frame.getContentPane().add(lblCdigoDaPea);
		
		lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(189, 186, 129, 14);
		frame.getContentPane().add(lblQuantidade);
		
		lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setBounds(189, 239, 46, 14);
		frame.getContentPane().add(lblPreo);
	}

}
