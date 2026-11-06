/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cieloslimpios;

/**
 * Simulación en la Consola Central: Gestionaremos a las unidades agrupándolas estrictamente por su tipo, sin mezclar modelos
 * diferentes en una sola estructura. Se crearán dos arreglos independientes: un Escuadrón Táctico con 3 drones de reconocimiento
 * y un Escuadrón Pesado con 2 drones de carga ambiental. La torre de control ejecutará dos ciclos separados: uno para ordenar 
 * mapeo y análisis de amenazas, y otro para intentar recolección de desechos y vaciado de contenedores. Finalmente, se aplicará
 * un desgaste de energía post-misión y se solicitará la telemetría final a todas las unidades.
 *
 * @author SHERLYGISSELLPEREZFE
 */
public class CielosLimpios {

   
    public static void main(String[] args) {
        // Metodo
        
        System.out.println("================================================");
        System.out.println("   OPERACION CIELOS LIMPIOS - CONSOLA CENTRAL   ");
        System.out.println("================================================\n");
        
        System.out.println("=====================================");
        System.out.println(" FASE 1 - DESPLIEGUES DE UNIDADES");
        System.out.println("=====================================");
        
        DronReconocimientoTactico[]escuadronTactico = new DronReconocimientoTactico[3];
        escuadronTactico[0] = new DronReconocimientoTactico("     DRON-T-001     ",100);
        escuadronTactico[1] = new DronReconocimientoTactico("     DRON-T-002     ",95);
        escuadronTactico[2] = new DronReconocimientoTactico("     DRON-T-003     ",88);
        
        DronCargaAmbiental[] escuadronPesado = new DronCargaAmbiental[2];
        escuadronPesado[0] = new DronCargaAmbiental("     DRON-C-001     ",100,50.0);
        escuadronPesado[1] = new DronCargaAmbiental("     DRON-C-002     ",92,65.0);
        
        System.out.println("Escuadron Tactico: 3 Unidades activas");
        System.out.println("Escuadron Pesado: 2 Unidades activas");
        System.out.println("\n");
        
        System.out.println("==============================================");
        System.out.println(" FASE 2 - PATRULLAJE Y DETECCION DE AMENAZAS");
        System.out.println("==============================================");
        
        for(int i = 0; i < escuadronTactico.length; i++){
            System.out.println("\n   " + escuadronTactico[i].getCodigoSerie() + "   ");
            escuadronTactico[i].generarMapaEstocastico();
            escuadronTactico[i].analizarAmenazas();
        }
        
        System.out.println("===================================");
        System.out.println(" FASE 3 - RECOLECCION DE DESECHOS");
        System.out.println("===================================");
        
        double[] pesos = {15.5, 42.0, 8.3};
        
        for(int i = 0; i < escuadronPesado.length; i++){
            System.out.println("\n   " + escuadronPesado[i].getCodigoSerie() + "   ");
            escuadronPesado[i].engancharDesecho(pesos[i]);
            escuadronPesado[i].descargarContenedorBase();
        }
        
        System.out.println("===================================================");
        System.out.println(" FASE 4 - DESGASTE DE ENERGIA POST-MISION");
        System.out.println("===================================================");
        
        for(int i = 0; i < escuadronTactico.length; i++){
            int energiaActual = escuadronTactico[i].getNivelEnergia();
            escuadronTactico[i].setNivelEnergia(energiaActual - 15);
        }
        
        for(int i = 0; i < escuadronPesado.length; i++){
            int energiaActual = escuadronPesado[i].getNivelEnergia();
            escuadronPesado[i].setNivelEnergia(energiaActual - 10);
        }
        
        System.out.println("===================================================");
        System.out.println(" FASE 5 - REPORTE FINAL DE TELEMETRIA");
        System.out.println("=======================================");
        
        System.out.println("\n       ESCUADRON TACTICO   ");
        for (int i = 0; i < escuadronTactico.length; i++) {
            escuadronTactico[i].transmitirEstadoRed();
        }
        
        System.out.println("\n        ESCUADRON PESADO   ");
        for (int i = 0; i < escuadronPesado.length; i++) {
            escuadronPesado[i].transmitirEstadoRed();
        }
        
        System.out.println("\n=======================================");
        System.out.println("    MISION COMPLETADA - CIELOS LIMPIOS   ");
        System.out.println("=======================================");
    }//Fin de Main
    
}//Fin Class CielosLimpios
