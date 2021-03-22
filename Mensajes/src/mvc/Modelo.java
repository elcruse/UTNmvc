package mvc;

//Deberá agregar 3 líneas de código en cada uno de los lugares indicados
//Los podrá reconocer porque se encuentran indicaciones 
//en líneas de comentarios

import java.util.*;
public class Modelo {
    // Modelar los datos
    private String mensaje = "Bienvenido a mvc";
    private String clima = "Soleado";
    // Estructuras de datos para gestionar los oyentes del modelo
    private ArrayList<Vista> oyentes = new ArrayList<Vista>(10);
    
    public Modelo() {
        System.out.println("Modelo : Modelo()");
    }
    
    // Métodos para consulta del estado
    public String getMensaje() {
        System.out.println("Modelo: getMensaje() ");
        return mensaje;
    }
    public String getClima() {
        System.out.println("Modelo: getClima() ");
        return clima;
    }
    
    // Métodos para el cambio de estado
    public void setMensaje(String mensaje) {
        System.out.println("Modelo: setMensaje() ");
        this.mensaje = mensaje;
		// ** 1 Acción Requerida: falta una línea de código
		// ** Pista 1: debe informar a todas las vistas que 
		// ** el modelo hacambiado
		// ** Pista 2: Llamar al método disparaEventoDeCambioEnElModelo()
		// ** pasarle el atributo mensaje
        disparaEventoDeCambioEnElModelo(this.mensaje);
    }
    
    public void setClima(String clima) {
        System.out.println("Modelo: setClima() ");
        this.clima = clima;
		// ** 2 Acción Requerida: falta una línea de código
		// ** Pista 1: debe informar a todas las vistas que 
		// ** el modelo ha cambiado
		// ** Pista 2: Llamar al método disparaEventoDeCambioEnElModelo()
		// ** pasarle el atributo clima
        disparaEventoDeCambioEnElModelo(this.clima);
    }
    
    // Método para registrar los oyentes
    public void agregrarOyenteDeCambiosEnElModelo(Vista vista) {
        System.out.println("Modelo: agregrarOyenteDeCambiosEnElModelo(vista) ");
        oyentes.add(vista);
    }
    
    private void disparaEventoDeCambioEnElModelo(Object o) {
        for (Vista v: oyentes) {
            System.out.println("Modelo: disparaEventoDeCambioEnElModelo() - Ciclo for para informar a los oyentes");
			// ** 3 Acción Requerida: falta una línea de código
			// ** Pista 1: debe informar al objeto vista v que
			// ** el modelo ha cambiado
			// ** Pista 2: Llamar al método procesarCambioEnElModelo()
			// ** del objeto vista v pasarle el atributo o
           v.procesarCambioEnElModelo(o);
        }
    }
}
