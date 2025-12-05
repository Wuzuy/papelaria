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

public class Autores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtPais;
	private JTextField txtNota;
	private JTextField txtNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autores frame = new Autores();
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
	public Autores() {
		setTitle("Cadastrar Autor");
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
		
		JLabel lblNewLabel_7 = new JLabel("CADASTRO AUTOR");
		lblNewLabel_7.setBounds(88, 11, 182, 22);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(34, 70, 118, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("País");
		lblNewLabel_1.setBounds(34, 119, 118, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Nota Biográfica");
		lblNewLabel_2.setBounds(166, 70, 155, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Nascimento ");
		lblNewLabel_3.setBounds(34, 169, 144, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtNome = new JTextField();
		txtNome.setBounds(34, 92, 105, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtPais = new JTextField();
		txtPais.setBounds(34, 138, 105, 20);
		panel.add(txtPais);
		txtPais.setColumns(10);
		
		txtNota = new JTextField();
		txtNota.setHorizontalAlignment(SwingConstants.LEFT);
		txtNota.setBounds(166, 89, 155, 117);
		panel.add(txtNota);
		txtNota.setColumns(10);
		
		txtNascimento = new JTextField();
		txtNascimento.setBounds(34, 186, 105, 20);
		panel.add(txtNascimento);
		txtNascimento.setColumns(10);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livraria", "root", "123456789");
				
				String inserir = "INSERT INTO autores (nome, pais, nascimento, nota) VALUES (?,?,?,?)";
				PreparedStatement statement = conexao.prepareStatement(inserir);

				String nome = txtNome.getText();
				String pais = txtPais.getText();
				String nota = txtNota.getText();
				String nascimento = txtNascimento.getText();
				
				statement.setString(1 ,nome);
				statement.setString(2, pais);
				statement.setString(3, nascimento);
				statement.setString(4, nota);

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
		btnCadastrar.setBounds(34, 217, 105, 23);
		panel.add(btnCadastrar);
		btnCadastrar.setBackground(new Color(6, 185, 47));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtPais.setText("");
				txtNota.setText("");
				txtNascimento.setText("");
			}
		});
		btnLimpar.setBounds(34, 248, 105, 23);
		panel.add(btnLimpar);
		btnLimpar.setBackground(new Color(6, 185, 149));
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(325, 20, 64, 64);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(Autores.class.getResource("/images/add64x.png")));
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu tela = new Menu();
				tela.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 10, 47, 22);
		panel.add(btnNewButton);
	}
}
