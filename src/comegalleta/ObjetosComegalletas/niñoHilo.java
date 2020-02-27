
package comegalleta.ObjetosComegalletas;


public class niñoHilo extends Thread {

    frascoDeGalletas frascoConGalletas;
    short cantidadGalletasPermitidas;
    int numeroHilo;
    public niñoHilo(frascoDeGalletas nuevoFrasco,short galletasPermitidas,int numHilo) {
        this.frascoConGalletas = nuevoFrasco;
        this.cantidadGalletasPermitidas = galletasPermitidas;
        this.numeroHilo = numHilo;
    }

    
    
    public void run(){
       
        try {
             System.out.println("\t------- SE LANZA HILO HIJO "+numeroHilo +" HAY " +frascoConGalletas.numGalletas + "GALLETAS " );  
        frascoConGalletas.consumirGalletas();
            sleep(50000);
//System.out.println("\t***SE LANSA HILO HIJO::: "+numeroHilo+" \n\t HAY " +frascoConGalletas.numGalletas + " GALLETAS EN EL FRASCO");
/*
System.out.println("\t***EL FRASCO ESTA LLENO (TRUE) ? ::: "+frascoConGalletas.frascoLleno+"");
System.out.println("\t***EL FRASCO ESTA DISPONIBLE (TRUE) ? ::: "+frascoConGalletas.frascoDisponible+"");
frascoConGalletas.consumirGalletas();
System.out.println("\t***HILO HIJO "+numeroHilo+" CONSUMI 3 GALLETAS :::");
*/
        } catch (InterruptedException ex) {
            System.out.println("ocurrio un error durmiendo al hilo HIJO");
        }
    }
    
}
