package org.ciberfarma.app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FrmUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JTextField txtFecha;
	private JTextField txtTipo;
	private JTextField txtEstado;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsuario frame = new FrmUsuario();
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
	public FrmUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MANTENIMIENTO USUARIO");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 16));
		lblNewLabel.setBounds(104, 12, 197, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnNewButton.setBounds(384, 74, 121, 26);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BUSCAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}

		});
		btnNewButton_1.setBounds(406, 128, 99, 26);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("CODIGO");
		lblNewLabel_1.setBounds(12, 70, 55, 16);
		contentPane.add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(104, 68, 88, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(104, 96, 159, 20);
		contentPane.add(txtNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOMBRE");
		lblNewLabel_1_1.setBounds(12, 98, 55, 16);
		contentPane.add(lblNewLabel_1_1);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(104, 122, 159, 20);
		contentPane.add(txtApellido);
		
		JLabel lblNewLabel_1_2 = new JLabel("APELLIDO");
		lblNewLabel_1_2.setBounds(12, 124, 74, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("usuario");
		lblNewLabel_1_2_1.setBounds(12, 148, 74, 16);
		contentPane.add(lblNewLabel_1_2_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(104, 146, 159, 20);
		contentPane.add(txtUsuario);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("clave");
		lblNewLabel_1_2_1_1.setBounds(12, 178, 74, 16);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(104, 178, 104, 20);
		contentPane.add(txtClave);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("fecha de nacimiento");
		lblNewLabel_1_2_1_2.setBounds(12, 208, 88, 16);
		contentPane.add(lblNewLabel_1_2_1_2);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(104, 206, 159, 20);
		contentPane.add(txtFecha);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("tipo");
		lblNewLabel_1_2_1_3.setBounds(12, 237, 74, 16);
		contentPane.add(lblNewLabel_1_2_1_3);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(104, 235, 104, 20);
		contentPane.add(txtTipo);
		
		JLabel lblNewLabel_1_2_1_4 = new JLabel("estado");
		lblNewLabel_1_2_1_4.setBounds(12, 269, 74, 16);
		contentPane.add(lblNewLabel_1_2_1_4);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(104, 276, 104, 20);
		contentPane.add(txtEstado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 308, 482, 156);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		JButton btnListar = new JButton("listado");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListar.setBounds(406, 264, 99, 26);
		contentPane.add(btnListar);
	}
	
	void registrar() {
		
		
	}

	void listado() {
		// obtener un listado de los Usuarios 
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager(); 
		
		//TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findAll", Usuario.class);
		//List<Usuario> lstUsuarios =	consulta.getResultList();
		
		TypedQuery<Usuario> consulta = em.createNamedQuery("Usuario.findAllWithType", Usuario.class);
		consulta.setParameter("xtipo", 1);
		List<Usuario> lstUsuarios =	consulta.getResultList();
		
		
		em.close();
		//pasar el listado a txt,....
		for (Usuario u : lstUsuarios) {
			txtS.append(u.getCodigo()+"\t"+ u.getNombre()+"\t"+u.getApellido()+ "\n");
		}
	 
		
	}

	private void buscar() {
		// leer el codigo
		int codigo=leerCodigo();
		//buscar en la tabla, para obtener usuario
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear el manejador de entidades
		EntityManager em = fabrica.createEntityManager(); 

		Usuario u=	em.find(Usuario.class, codigo);
		em.close();
		
		if(u==null) {
			aviso("USUARIO " +codigo+ " no existe");
		}else {
			txtNombre.setText(u.getNombre());
			txtApellido.setText(u.getApellido());
			txtUsuario.setText(u.getUsuario());
			txtFecha.setText(u.getFnacim());
			
		}
		
		
	}

	private void aviso(String msg) {
		JOptionPane.showMessageDialog(this, msg, "AVISO DEL SISTEMA ",2);
		
	}

	private int leerCodigo() {
		// TODO Auto-generated method stub
		return Integer.parseInt(txtCodigo.getText());
	}
}
