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
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField pswSenha;
	private JTextField txtUsuario;
	private JLabel lblUsuario;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
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
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(130, 195, 130, 20);
		panel.add(pswSenha);
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(130, 170, 130, 14);
		panel.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(130, 139, 130, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsuario.setBounds(130, 114, 130, 14);
		panel.add(lblUsuario);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/user64x.png")));
		lblNewLabel_1.setBounds(130, 11, 130, 92);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String senha = pswSenha.getText();
				
				if (usuario.equals("admin") & senha.equals("1234")) {
					Menu tela = new Menu();
					dispose();
					tela.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto, tente novamente.");
				}
			}
		});
		btnNewButton.setBounds(130, 240, 130, 32);
		panel.add(btnNewButton);
	}
}
