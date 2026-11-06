/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cieloslimpios;

import java.util.Random;

/**El Dron de Reconocimiento Tactico
 * Esta variante táctica patrullará 7 cuadrantes forestales. Además de heredar la estructura base, posee un arreglo de 7 espacios
 * enteros para almacenar lecturas de cada zona. Cuenta con los siguientes tres sistemas exclusivos:
 * 1. Motor de Escaneo: Llamado "generarMapaEstocastico". Utiliza una librería de aleatoriedad (Random) para simular los sensores
 * del dron, generando valores de amenaza térmica (de 0 a 50) y guardándolos uno por uno mediante un ciclo de repetición en los 7
 * bloques de memoria del arreglo del dron.
 * 2. Analizador de Riesgos: Llamado "analizarAmenazas". El procesador del dron debe recorrer su arreglo de lecturas y evaluar 
 * con estructuras de selección. Si detecta al menos un cuadrante con una lectura mayor a 35, el sistema se detiene y llama 
 * internamente al protocolo de emergencia.
 * 3. Sirena de Emergencia: Llamado "emitirAlertaIncendio". Un mecanismo de respuesta que imprime en consola el mensaje de 
 * advertencia. Solo se desencadena si el analizador de riesgos encuentra un peligro inminente.
 *
 * @author SHERLYGISSELLPEREZFE
 */
public class DronReconocimientoTactico extends DronBase {
    
    //Atributos
    private int [] lecturaCuadrantes;
    private Random aleatorio;
    
    //Constructor
    public DronReconocimientoTactico(String codigoSerie, int nivelEnergia){
        super(codigoSerie, nivelEnergia);
        lecturaCuadrantes = new int[7];
        aleatorio = new Random();
    }// Fin de constructor
    
    //Metodos
    public void generarMapaEstocastico(){
        
        System.out.println("    Generando mapa de amenazas....");
        for(int i = 0; i < 7; i++) {
            lecturaCuadrantes[i] = aleatorio.nextInt(51);
            System.out.println("Cuadrante " + (i + 1) + ":Amenaza termica = " + lecturaCuadrantes[i]);
        }
        System.out.println("Mapa Completo generado");
    }
    
    public void analizarAmenazas(){
        
        System.out.println("Analizando niveles de riesgos...");
        for (int i = 0; i < lecturaCuadrantes.length; i++){
            if(lecturaCuadrantes[i] > 35){
                
                System.out.println("PELIGRO detectado en cuadrante " + (i +1));
                emitirAlertaIncendio();
                return;
            }
        }
        
        System.out.println("Todos los cuadrantes seguros..Sin amenazas.");
    }
    
    public void emitirAlertaIncendio(){
        
        System.out.println("ALERTA ROJA!!Posible incendio en el sector");
    }// Fin de Metodos
    
}//Fin Class DronReconocimientoTactico.
