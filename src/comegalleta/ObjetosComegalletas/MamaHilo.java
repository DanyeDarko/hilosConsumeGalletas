package comegalleta.ObjetosComegalletas;



public class MamaHilo extends Thread {
    
    //<editor-fold defaultstate="collapsed" desc="VARIABLES GLOBALES HILO">
    frascoDeGalletas frascoConGalletas;
    int numeroHilo;
   //</editor-fold>
    
    
    public MamaHilo(frascoDeGalletas nuevoFrasco, int numHilo) {
        this.frascoConGalletas = nuevoFrasco;
        this.numeroHilo = numHilo;
    }

    public void run() {
        
            System.out.println("\n\t\t°°° MAMA numero " + numeroHilo + " COCINANDO GALLETAS ");
            frascoConGalletas.prepararGalletas(); 

        

   

}
}
