package comegalleta.ObjetosComegalletas;



public class MamaHilo extends Thread {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES GLOBALES HILO">
    frascoDeGalletas frascoConGalletas;
    short galletasProducir;
    int numeroHilo;
   //</editor-fold>
    
    
    public MamaHilo(frascoDeGalletas nuevoFrasco, short galletas, int numHilo) {

        this.frascoConGalletas = nuevoFrasco;
        this.galletasProducir = galletas;
        this.numeroHilo = numHilo;
    }

    public void run() {
        try {
           
            System.out.println("\n\t\t°°° MAMA numero " + numeroHilo + " COCINANDO GALLETAS ");
            frascoConGalletas.prepararGalletas(galletasProducir); 
            sleep(8000);

        } catch (InterruptedException ex) {
            System.out.println("ocurrio un error durmiendo al hilo MAMA");
        }

    }

}
