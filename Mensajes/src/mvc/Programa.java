package mvc;

public class Programa {
    Modelo modelo = new Modelo();
    Vista vista1 = new Vista(modelo);
    Controlador con1 = new Controlador(modelo, vista1);
    Vista vista2 = new Vista(modelo);
    Controlador con2 = new Controlador(modelo, vista2);
    
    public static void main(String args[]){
        System.out.println("Programa de MVC : main()");
        new Programa();
    }
}
