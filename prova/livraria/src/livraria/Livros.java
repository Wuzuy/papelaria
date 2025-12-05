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

public class Livros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdLivro;
	private JTextField txtTitulo;
	private JTextField txtCategoria;
	private JTextField txtQtdPag;
	private JTextField txtEditora;
	private JTextField txtIsbn;
	private JTextField txtPreco;
	private JTextField txtIssn;
	private JTextField txtAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Livros frame = new Livros();
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
	public Livros() {
		setTitle("Cadastrar Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 396);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(63, 103, 99));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(200, 221, 219));
		panel.setBounds(10, 11, 399, 335);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("CADASTRO LIVROS");
		lblNewLabel_7.setBounds(88, 11, 182, 22);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("Id Livro");
		lblNewLabel.setBounds(34, 70, 118, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Título");
		lblNewLabel_1.setBounds(34, 119, 118, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setBounds(34, 161, 118, 22);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Qtd. Paginas");
		lblNewLabel_3.setBounds(186, 70, 118, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_4 = new JLabel("Editora");
		lblNewLabel_4.setBounds(186, 118, 118, 14);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_5 = new JLabel("ISBN");
		lblNewLabel_5.setBounds(186, 169, 118, 14);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_6 = new JLabel("Preço");
		lblNewLabel_6.setBounds(34, 219, 118, 14);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtIdLivro = new JTextField();
		txtIdLivro.setBounds(34, 87, 105, 20);
		panel.add(txtIdLivro);
		txtIdLivro.setColumns(10);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(34, 138, 105, 20);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(34, 188, 105, 20);
		panel.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtQtdPag = new JTextField();
		txtQtdPag.setBounds(186, 87, 105, 20);
		panel.add(txtQtdPag);
		txtQtdPag.setColumns(10);
		
		txtEditora = new JTextField();
		txtEditora.setBounds(186, 138, 105, 20);
		panel.add(txtEditora);
		txtEditora.setColumns(10);
		
		txtIsbn = new JTextField();
		txtIsbn.setBounds(186, 189, 105, 20);
		panel.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(34, 242, 105, 20);
		panel.add(txtPreco);
		txtPreco.setColumns(10);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria", "root", "123456789");
				
				String inserir = "INSERT INTO livros (idLivro, titulo, categoria, qtdPag, editora, preco, ano, isbn, issn) VALUES (?,?,?,?,?,?,?,?,?)";
				PreparedStatement statement = conexao.prepareStatement(inserir);

				int idLivro = Integer.parseInt(txtIdLivro.getText());
				String titulo = txtTitulo.getText();
				String categoria = txtCategoria.getText();
				int qtdPag = Integer.parseInt(txtQtdPag.getText());
				String editora = txtEditora.getText();
				Float preco = Float.parseFloat(txtPreco.getText());
				int Ano = Integer.parseInt(txtAno.getText());
				 int isbn = Integer.parseInt(txtIsbn.getText());
				int issn = Integer.parseInt(txtIssn.getText());
				
				statement.setInt(1 , idLivro);
				statement.setString(2, titulo);
				statement.setString(3, categoria);
				statement.setInt(4, qtdPag);
				statement.setString(5, editora);
				statement.setFloat(6, preco);
				statement.setInt(7, Ano);
				statement.setInt(8, isbn);
				statement.setInt(9, issn);

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
		btnCadastrar.setBounds(186, 273, 105, 23);
		panel.add(btnCadastrar);
		btnCadastrar.setBackground(new Color(6, 185, 47));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdLivro.setText("");
				txtTitulo.setText("");
				txtCategoria.setText("");
				txtQtdPag.setText("");
				txtEditora.setText("");
				txtIsbn.setText("");
				txtPreco.setText("");
				txtIssn.setText("");
				txtAno.setText("");
			}
		});
		btnLimpar.setBounds(186, 304, 105, 23);
		panel.add(btnLimpar);
		btnLimpar.setBackground(new Color(6, 185, 149));
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_6_1 = new JLabel("ISSN");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_1.setBounds(186, 219, 118, 14);
		panel.add(lblNewLabel_6_1);
		
		txtIssn = new JTextField();
		txtIssn.setColumns(10);
		txtIssn.setBounds(186, 242, 105, 20);
		panel.add(txtIssn);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Ano");
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6_1_1.setBounds(34, 275, 118, 14);
		panel.add(lblNewLabel_6_1_1);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(34, 305, 105, 20);
		panel.add(txtAno);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Livros.class.getResource("/images/stackBook64x.png")));
		lblNewLabel_8.setBounds(322, 18, 64, 64);
		panel.add(lblNewLabel_8);
		
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
