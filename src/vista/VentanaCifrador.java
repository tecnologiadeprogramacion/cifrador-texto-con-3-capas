package vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.LogicaCifrador;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaCifrador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private LogicaCifrador miLogica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCifrador frame = new VentanaCifrador();
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
	public VentanaCifrador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("TdP :: Cifrador de texto CON modelo de 3 capas");
		
		miLogica = new LogicaCifrador();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.WEST);
		panelBotones.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton botonCifrar = new JButton("Cifrar texto");
		botonCifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cifrarTextArea();
			}
		});
		panelBotones.add(botonCifrar);
		
		JButton botonGuardar = new JButton("Guardar texto");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarTextoTextArea();
			}
		});
		
		panelBotones.add(botonGuardar);
		
		JButton botonCargar = new JButton("Cargar último texto");
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leerUltimoTextoCifrado();
			}
		});
		panelBotones.add(botonCargar);
		
		JPanel panelTexto = new JPanel();
		contentPane.add(panelTexto, BorderLayout.CENTER);
		
		textArea = new JTextArea(15,25);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		panelTexto.add(textArea);
		
	}
	
	public void cifrarTextArea() {
		String aCifrar = textArea.getText();
		String cifrado = miLogica.cifrar(aCifrar);
		textArea.setText(cifrado);
	}
	
	protected void guardarTextoTextArea() {
		String textoAGuardar = textArea.getText();
		try {
			miLogica.guardarTexto(textoAGuardar);
		} catch (IOException e) {
			// to do
		}
	}
	
	protected void leerUltimoTextoCifrado() {
		String textoLeido;
		try {
			textoLeido = miLogica.leerTexto();
		} catch (IOException e) {
			textoLeido = "No existe último texto cifrado";
		}
		textArea.setText(textoLeido);
	}
}
