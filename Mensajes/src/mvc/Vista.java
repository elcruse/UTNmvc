package mvc;

//Deber� agregar 5 l�neas de c�digo en cada uno de los lugares 
//indicados. Los podr� reconocer porque se encuentran 
//indicaciones en l�neas de comentarios

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Vista{
    private Modelo modelo;
    private static int nroDeVista=0;
    private int idVista;
    // Componentes de la Interfaz Gr�fica del Usuario
    private JFrame frCliente;
    private Container panelContenedor;
    private JPanel panelDeMensajes = new JPanel();
    private JPanel panelDeClimas = new JPanel();
    private JTextField textoMensaje = new JTextField(30);
    private JTextField textoClima = new JTextField(30);
    private JLabel lblMensaje = new JLabel("P�gina para mostrar mensajes");
    private JLabel lblClima = new JLabel("P�gina para mostrar el clima");
    private JButton btActualizarMensaje = new JButton("Actualizar Mensaje");
    private JButton btObtenerClima = new JButton("Obtener Clima");
    private JButton btActualizarClima = new JButton("Actualizar Clima");
    private JButton btObtenerMensaje = new JButton("Obtener Mensaje");
    private CardLayout carta = new CardLayout();
    
	// Estructura de datos para el manejo de listeners (oyentes)
	// que act�an sobre las acciones del usuario
    private ArrayList<Controlador> oyentes = new ArrayList<Controlador>(10);
    
    public Vista(Modelo modelo) {
        this.modelo = modelo;
        idVista = ++nroDeVista;
        System.out.println("Vista " + idVista +
                ": Vista(modelo) ");
        construirLaPantallaDeSalida();
		// ** 1 Acci�n Requerida: falta una l�nea de c�digo
		// ** Pista 1: La vista debe registrarse a s� misma 
		// ** como listener (oyente) de los de los cambios de
		// ** informaci�n almacenada en el modelo
		// ** Pista 2: Llamar al m�todo agregrarOyenteDeCambiosEnElModelo() 
		// ** del objeto modelo y pasarle la referencia de ESTE objeto vista
        modelo.agregrarOyenteDeCambiosEnElModelo(this);
    }
    
    public void procesarCambioEnElModelo(Object evento){
        System.out.println("Vista " + idVista +
                ": procesarCambioEnElModelo() ");
        refrescar();
    }
    
    public void agregarOyenteDeAccionDelUsuario(Controlador con){
        System.out.println("Vista " + idVista +
                ": agregarOyenteDeAccionDelUsuario(controlador) ");
        oyentes.add(con);
    }
    
    
    public void mostrarPantalla(String pantalla){
        System.out.println("Vista " + idVista +
                ": mostrarPantalla() ");
        carta.show(panelContenedor, pantalla);
    }
    
    
    private void refrescar() {
        System.out.println("Vista " + idVista +
                ": refrescar() ");
        textoMensaje.setText(modelo.getMensaje());
        textoClima.setText(modelo.getClima());
    }
    private void construirLaPantallaDeSalida(){
        frCliente = new JFrame("Cliente del MVC " + idVista);
        panelContenedor = frCliente.getContentPane();
        // Construir el panel para los Mensajes
        panelDeMensajes.setLayout(new BorderLayout());
        panelDeMensajes.add(lblMensaje, BorderLayout.NORTH);
        panelDeMensajes.add(textoMensaje, BorderLayout.CENTER);
        panelDeMensajes.add(btActualizarMensaje, BorderLayout.EAST);
        panelDeMensajes.add(btObtenerClima, BorderLayout.WEST);
        // Constuir el panel para los Climas
        panelDeClimas.setLayout(new BorderLayout());
        panelDeClimas.add(lblClima, BorderLayout.NORTH);
        panelDeClimas.add(textoClima, BorderLayout.CENTER);
        panelDeClimas.add(btActualizarClima, BorderLayout.EAST);
        panelDeClimas.add(btObtenerMensaje, BorderLayout.WEST);
        // Agregar los paneles al marco de la ventana y mostrarlos
        panelContenedor.setLayout(carta);
        panelContenedor.add(panelDeMensajes, "mensaje");
        panelContenedor.add(panelDeClimas, "clima");
        frCliente.pack();
        frCliente.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frCliente.setVisible( true );
        frCliente.setLocation(0, (idVista-1)*100);
        refrescar();
        // registrar los oyentes de los eventos en los controles 
        // de la Intefaz Gr�fica del Usuario
        btActualizarMensaje.addActionListener(manejadorDeActualizacionDeMensajes);
        btObtenerClima.addActionListener(manejadorDeObtencionDeClima);
        btActualizarClima.addActionListener(manejadorDeActualizacionDeClima);
        btObtenerMensaje.addActionListener(manejadorDeObtencionDeMensajes);
    }

	// C�digo para procesar los requerimientos del usuario
    // M�todos manejadores de eventos dentro de clases an�nimas
    ActionListener manejadorDeActualizacionDeMensajes =
            new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	// Disparar el evento -- informar a todos los controladores registrados
            for (Controlador con: oyentes) {
                System.out.println("Vista " + idVista +
                        ": disparar el evento procesarActualizarMensaje");
				// ** Preguntarse: �qu� deber�a hacer este m�todo?
				// ** 2 Acci�n Requerida: falta una l�nea de c�digo
				// ** Pista 1: Informar al objeto controlador con que el usuario
				// ** ha presionado el bot�n "Actualizar Mensaje"
				// ** Pista 2: Llamar al m�todo procesarActualizarMensaje()
				// ** del objetocontrolador con y pasarle el texto ingresado 
				// ** en el textfield textoMensaje.(Ej: textoMensaje.getText())
                con.procesarActualizarMensaje(textoMensaje.getText());
            }
        }
    };
    
    ActionListener manejadorDeObtencionDeMensajes =
            new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	// Disparar el evento -- informar a todos los controladores registrados
            for (Controlador con: oyentes) {
                System.out.println("Vista " + idVista +
                        ": disparar el evento procesarObtenerMensaje");
				// ** Preguntarse: �qu� deber�a hacer este m�todo?
				// ** 3 Acci�n Requerida: falta una l�nea de c�digo
				// ** Pista 1: Informar al objeto controlador con que el usuario
				// ** ha presionado el bot�n "Obtener mensaje"
				// ** Pista 2: Llamar al m�todo procesarObtenerMensaje() 
				// ** del objeto controlador con
                con.procesarObtenerMensaje();
            }
        }
    };
    
    ActionListener manejadorDeActualizacionDeClima =
            new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	// Disparar el evento -- informar a todos los controladores registrados
            for (Controlador con: oyentes) {
                System.out.println("Vista " + idVista +
                        ": disparar el evento procesarActualizarClima");
				// ** 4 Acci�n Requerida: falta una l�nea de c�digo
				// ** Pista 1: Informar al objeto controlador con que el usuario
				// ** ha presionado el bot�n "Actualizar Clima"
				// ** Pista 2: Llamar al m�todo procesarActualizarClima()
				// ** del objeto controlador con 
				// ** y pasarle el texto ingresado en el
				// ** textfield textoClima.(Ej: textoClima.getText())
                con.procesarActualizarClima(textoClima.getText());
            }
        }
    };
    
    ActionListener manejadorDeObtencionDeClima =
            new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	// Disparar el evento -- informar a todos los controladores registrados
            for (Controlador con: oyentes) {
                System.out.println("Vista " + idVista +
                        ": disparar el evento procesarObtenerClima");
				// ** 5 Acci�n Requerida: falta una l�nea de c�digo
				// ** Pista 1: Informar al objeto controlador con que el usuario
				// ** ha presionado el bot�n "Obtener Clima"
				// ** Pista 2: Llamar al m�todo procesarObtenerClima() 
				// ** del objeto controlador con
               con.procesarObtenerClima();
            }
        }
    };
}