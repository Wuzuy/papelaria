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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu");
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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 399, 22);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Clientes tela = new Clientes();
				tela.setVisible(true);
			}
		});
		mnNewMenu.add(mntmClientes);
		
		JMenuItem mntmAutores = new JMenuItem("Autores");
		mntmAutores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Autores tela = new Autores();
				tela.setVisible(true);
			}
		});
		mnNewMenu.add(mntmAutores);
		
		JMenuItem mntmEditoras = new JMenuItem("Editoras");
		mntmEditoras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Editoras tela = new Editoras();
				tela.setVisible(true);
			}
		});
		mnNewMenu.add(mntmEditoras);
		
		JMenuItem mntmLivros = new JMenuItem("Livros");
		mntmLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Livros tela = new Livros();
				tela.setVisible(true);
			}
		});
		mnNewMenu.add(mntmLivros);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/images/Menu64x.png")));
		lblNewLabel.setBounds(0, 22, 399, 261);
		panel.add(lblNewLabel);
	}
}
