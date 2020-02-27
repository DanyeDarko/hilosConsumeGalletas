
package comegalleta.ObjetosComegalletas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MamaHilo  extends Thread {

    frascoDeGalletas frascoConGalletas;
    short galletasProducir;
    int numeroHilo;
    
    public MamaHilo(frascoDeGalletas nuevoFrasco,short galletas,int numHilo) {
        
        this.frascoConGalletas = nuevoFrasco;
        this.galletasProducir = galletas;
        this.numeroHilo = numHilo;
    }

public void run(){
        try {
            System.out.println("");
            System.out.println("\t\t°°° MAMA numero " +numeroHilo+ " COCINANDO GALLETAS ");
            frascoConGalletas.prepararGalletas(galletasProducir);
            sleep(8000);
            /*
            System.out.println("°°° AL MOMENTO DE ESTE HILO HAY "+frascoConGalletas.numGalletas);
            
            
            System.out.println("°°° MIENTRAS MAMA COCINA 5 GALLETAS EL FRASCO ESTA "+frascoConGalletas.frascoLleno);
            frascoConGalletas.prepararGalletas(galletasProducir);
            */
        } catch (InterruptedException ex) {
            System.out.println("ocurrio un error durmiendo al hilo MAMA");
        }
        
}

    
}
