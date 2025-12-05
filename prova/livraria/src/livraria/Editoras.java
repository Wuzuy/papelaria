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

public class Editoras extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdEditora;
	private JTextField txtNomeContato;
	private JTextField txtTelefone;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtNomeEditora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editoras frame = new Editoras();
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
	public Editoras() {
		setTitle("Cadastrar Editora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 295);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(63, 103, 99));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(200, 221, 219));
		panel.setBounds(10, 11, 399, 234);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("CADASTRO EDITORA");
		lblNewLabel_7.setBounds(10, 11, 379, 22);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("Id Editora");
		lblNewLabel.setBounds(10, 64, 118, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Nome Contato");
		lblNewLabel_1.setBounds(10, 163, 118, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(152, 163, 118, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Endereço");
		lblNewLabel_3.setBounds(152, 64, 118, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(152, 112, 118, 14);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtIdEditora = new JTextField();
		txtIdEditora.setBounds(10, 82, 105, 20);
		panel.add(txtIdEditora);
		txtIdEditora.setColumns(10);
		
		txtNomeContato = new JTextField();
		txtNomeContato.setBounds(10, 188, 105, 20);
		panel.add(txtNomeContato);
		txtNomeContato.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(152, 188, 105, 20);
		panel.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(152, 81, 105, 20);
		panel.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(152, 132, 105, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria", "root", "123456789");
				
				String inserir = "INSERT INTO editoras (idEditora, nomeEditora, nomeContato, telefone, endereco, email) VALUES (?,?,?,?,?,?)";
				PreparedStatement statement = conexao.prepareStatement(inserir);

				int idEditora = Integer.parseInt(txtIdEditora.getText());
				String nomeEditora = txtNomeContato.getText();
				String nomeContato = txtNomeEditora.getText();
				String telefone = txtTelefone.getText();
				String endereco = txtEndereco.getText();
				String email = txtEmail.getText();
				
				statement.setInt(1 , idEditora);
				statement.setString(2, nomeContato);
				statement.setString(3, nomeEditora);
				statement.setString(4, telefone);
				statement.setString(5, endereco);
				statement.setString(6, email);

				int resultado;
				
				resultado = statement.executeUpdate();

				if (resultado > 0) {

					JOptionPane.showMessageDialog(null, "EDITORA CADASTRADA COM SUCESSO!");

				}else{
						JOptionPane.showMessageDialog(null, "ERRO DE CADASTRO, CONFIRA OS DADOS E TENTE NOVAMENTE!");
					}
				} catch (Exception erro) {
					erro.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
				}
			}
		});
		btnCadastrar.setBounds(284, 154, 105, 23);
		panel.add(btnCadastrar);
		btnCadastrar.setBackground(new Color(6, 185, 47));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdEditora.setText("");
				txtNomeContato.setText("");
				txtTelefone.setText("");
				txtEndereco.setText("");
				txtEmail.setText("");
			}
		});
		btnLimpar.setBounds(284, 185, 105, 23);
		panel.add(btnLimpar);
		btnLimpar.setBackground(new Color(6, 185, 149));
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(325, 49, 64, 64);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(Editoras.class.getResource("/images/cadastro64x.png")));
		
		JLabel lblNewLabel_4_1 = new JLabel("Nome Editora");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4_1.setBounds(10, 112, 118, 14);
		panel.add(lblNewLabel_4_1);
		
		txtNomeEditora = new JTextField();
		txtNomeEditora.setColumns(10);
		txtNomeEditora.setBounds(10, 132, 105, 20);
		panel.add(txtNomeEditora);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu tela = new Menu();
				tela.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 10, 45, 23);
		panel.add(btnNewButton);
	}
}
