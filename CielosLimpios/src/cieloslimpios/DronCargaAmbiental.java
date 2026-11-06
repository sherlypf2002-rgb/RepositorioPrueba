/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cieloslimpios;

/**El Dron de carga Ambiental
 * Diseñado para recolectar desechos físicos, cuenta con atributos de carga máxima permitida y carga actual. Sus rutinas 
 * mecánicas son las siguientes:
 * 1. Sensor de Sobrecarga: Llamado "evaluarPesoObjeto". El dron calcula la física antes de actuar. Toma el peso del nuevo objeto
 * que se intenta subir y retorna un valor lógico (true/false) determinando si al sumar ese peso a la carga actual, los motores
 * colapsarían por superar el límite.
 * 2. Grúa de Recolección: Llamado "engancharDesecho". Ejecuta la acción física. Usando el Sensor de Sobrecarga, decide si toma
 * el objeto (sumándolo a su carga actual e imprimiendo éxito) o si debe abortar la maniobra y notificar a la base que el objeto
 * es demasiado pesado.
 * 3. Protocolo de Vaciado: Llamado "descargarContenedorBase". Al regresar a las instalaciones, la compuerta se abre, liberando 
 * todos los desechos. La carga actual del dron se reinicia a cero de manera segura.
 *
 * @author SHERLYGISSELLPEREZFE
 */
public class DronCargaAmbiental extends DronBase{
    
    //Atributos
    private double cargaMaxima;
    private double cargaActual;
    
    //Constructor
    public DronCargaAmbiental(String codigoSerie, int nivelEnergia, double cargaMaxima){
        super(codigoSerie, nivelEnergia);
        this.cargaMaxima = cargaMaxima;
        this.cargaActual = 0.0;
    }//Fin del Constructor
    
    
    //Getter y Setter
    public double getCargaMaxima() {
        return cargaMaxima;
    }//Fin getCargaMaxima
    
    public double getCargaActual(){
        return cargaActual;
    }//Fin getCargaActual
    
    //Metodos
    public boolean evaluarPesoObjeto(double pesoNuevo){
        if(cargaActual + pesoNuevo <= cargaMaxima) {
            return true;
        } else {
            return false;
        }
    }
    
    public void engancharDesecho(double pesoNuevo){
        System.out.println("Intentando recoger objeto de " + cargaActual + "kg..");
        
        if(evaluarPesoObjeto(pesoNuevo)){
            cargaActual = cargaActual + pesoNuevo;
            System.out.println("Objeto asegurado. Carga actual: " + cargaActual + "kg");
        }else {
            System.out.println("\n------------------------------------------------------");
            System.out.println("MANIOBRA ABORTADA. El objeto excede la capacidad maxima.");
            System.out.println("------------------------------------------------------");
            System.out.println("Capacidad disponible: " + (cargaMaxima - cargaActual) + "kg");
        }
    } 
    
    public void descargarContenedorBase(){
        System.out.println("Descargando contenedor en la base...");
        cargaActual = 0.0;
        System.out.println("Contenedor vacio. Listo para nueva recoleccion.");
    }
}// Fin Class DronCargaAmbiental
