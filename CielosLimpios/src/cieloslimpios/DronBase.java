/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cieloslimpios;

/**La Arquitectura del sistema Base(CLase Padre)
 * Todos los dispositivos de la flota comparten un chasis de construcción fundamental. Cada unidad física posee atributos
 * esenciales encapsulados: un código de serie único, un nivel de energía porcentual y un estado de vinculación a la red central.
 * Además de sus protocolos de lectura y escritura (getters y setters) con las validaciones de energía mencionadas, el manual 
 * técnico del fabricante exige el diseño de dos rutinarias operativas fundamentales:
 * 1. Protocolo de Calibración: Llamado "calibrarGiroscopioInterno". La estabilidad del vuelo es un secreto industrial sumamente
 * delicado. Este protocolo consiste en un reajuste de los sensores internos y solo puede ser activado internamente por el propio
 * dron al actualizar su energía o encenderse. Ningún operador externo ni clase derivada tiene autorización para ejecutar esta 
 * rutina de seguridad.
 * 2. Transmisión de Telemetría: Llamado "transmitirEstadoRed". Una señal abierta que el centro de mando puede solicitar en
 * cualquier momento. Este método permite que la unidad destelle sus balizas virtuales e imprima en la consola de la base un
 * reporte general que indica su código de serie, su batería actual y si está lista para recibir órdenes.
 *
 * @author SHERLYGISSELLPEREZFE
 */
public class DronBase {
    //Atributos
    private String codigoSerie;
    private int nivelEnergia;
    private boolean vinculadoRed;
    
    //Constructor
    public DronBase(String codigoSerie, int nivelEnergia){
        this.codigoSerie = codigoSerie;
        if(nivelEnergia >100) {
            this.nivelEnergia = 100;
        } else if(nivelEnergia <0){
            this.nivelEnergia = 0;
        }else {
            this.nivelEnergia = nivelEnergia;
        }
        this.vinculadoRed = false;
    }// Fin del constructor
    
    //Getter y Setter
    public String getCodigoSerie(){
        return codigoSerie;
    }// Fin de getCodigoSerie
    
    public int getNivelEnergia(){
        return nivelEnergia;
    }// Fin de getNivelEnergia
    
    public void setNivelEnergia(int nivelEnergia){
        if (nivelEnergia >=0 && nivelEnergia <= 100) {
            this.nivelEnergia = nivelEnergia;
            calibrarGiroscopioInterno();
        } else {
            System.out.println("Valor de Energia Incorrecto...");
        }
    } // Fin setNivelEnergia
    
    public boolean isVinculadoRed(){
        return vinculadoRed;
    }
    
    public void setVinculadoRed(boolean vinculadoRed){
        this.vinculadoRed = vinculadoRed;
    }
    
    //Metodos
    
    private void calibrarGiroscopioInterno(){
        System.out.println("Giroscopio interno calibrado. Sistema es estable.");
    }
    
    public void transmitirEstadoRed(){
        System.out.println("\n=====================================");
        System.out.println("     REPORTE DE TELEMETRIA     ");
        System.out.println("Codigo de serie: " + codigoSerie);
        System.out.println("Nivel de bateria: " + nivelEnergia + "%");
        if (nivelEnergia >0 && vinculadoRed){
            System.out.println("Estado: Listo para recibir ordenes");
        } else if (nivelEnergia > 0 && !vinculadoRed) {
        System.out.println("Estado: Sin conexion a la red Central");
        } else {
            System.out.println("-------------------");
            System.out.println("Estado: SIN ENERGIA");
            System.out.println("-------------------");
        }
       System.out.println("======================================");
    } //Fin metodos
}// Fin Class DronBase
