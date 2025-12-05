package livraria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Clientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdCliente;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtRG;
	private JTextField txtCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Clientes() {
		setTitle("Cadastrar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 344);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(63, 103, 99));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(200, 221, 219));
		panel.setBounds(10, 11, 399, 283);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("CADASTRO CLIENTE");
		lblNewLabel_7.setBounds(88, 11, 182, 22);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("Id Cliente");
		lblNewLabel.setBounds(34, 70, 118, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(34, 119, 118, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(34, 169, 118, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Endereço");
		lblNewLabel_3.setBounds(186, 70, 118, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(186, 118, 118, 14);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_5 = new JLabel("RG");
		lblNewLabel_5.setBounds(186, 169, 118, 14);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_6 = new JLabel("CPF");
		lblNewLabel_6.setBounds(34, 229, 118, 14);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtIdCliente = new JTextField();
		txtIdCliente.setBounds(34, 92, 105, 20);
		panel.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(34, 138, 105, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(34, 188, 105, 20);
		panel.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(186, 87, 105, 20);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(186, 138, 105, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtRG = new JTextField();
		txtRG.setBounds(186, 189, 105, 20);
		panel.add(txtRG);
		txtRG.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(34, 252, 105, 20);
		panel.add(txtCPF);
		txtCPF.setColumns(10);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria", "root", "123456789");
				
				String inserir = "INSERT INTO CLIENTES (idCliente, nome, telefone, endereco, email, rg, cpf) VALUES (?,?,?,?,?,?,?)";
				PreparedStatement statement = conexao.prepareStatement(inserir);

				int idCliente = Integer.parseInt(txtIdCliente.getText());
				String nome = txtNome.getText();
				String telefone = txtTelefone.getText();
				String endereco = txtEndereco.getText();
				String email = txtEmail.getText();
				String rg = txtRG.getText();
				String cpf = txtCPF.getText();
				
				statement.setInt(1 , idCliente);
				statement.setString(2, nome);
				statement.setString(3, telefone);
				statement.setString(4, endereco);
				statement.setString(5, email);
				statement.setString(6, rg);
				statement.setString(7, cpf);

				int resultado;
				
				resultado = statement.executeUpdate();

				if (resultado > 0) {

					JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO COM SUCESSO!");

				}else{
						JOptionPane.showMessageDialog(null, "ERRO DE CADASTRO, CONFIRA OS DADOS E TENTE NOVAMENTE!");
					}
				} catch (Exception erro) {
					erro.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
				}
			}
		});
		btnCadastrar.setBounds(186, 220, 105, 23);
		panel.add(btnCadastrar);
		btnCadastrar.setBackground(new Color(6, 185, 47));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdCliente.setText("");
				txtNome.setText("");
				txtTelefone.setText("");
				txtEndereco.setText("");
				txtEmail.setText("");
				txtRG.setText("");
				txtCPF.setText("");
			}
		});
		btnLimpar.setBounds(186, 251, 105, 23);
		panel.add(btnLimpar);
		btnLimpar.setBackground(new Color(6, 185, 149));
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(325, 49, 64, 64);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(Clientes.class.getResource("/images/cadastro64x.png")));
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu tela = new Menu();
				tela.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 10, 44, 23);
		panel.add(btnNewButton);
	}
}
