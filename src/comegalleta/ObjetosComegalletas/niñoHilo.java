
package comegalleta.ObjetosComegalletas;


public class niñoHilo extends Thread {

    frascoDeGalletas frascoConGalletas;
    int numeroHilo;
    public niñoHilo(frascoDeGalletas nuevoFrasco,int numHilo) {
        this.frascoConGalletas = nuevoFrasco;
        this.numeroHilo = numHilo;
    }

    
    
    public void run(){
       
       
        System.out.println("\t------- SE LANZA HILO HIJO "+numeroHilo +" HAY " +frascoConGalletas.pila.size() + " GALLETAS " );  
        frascoConGalletas.consumirGalletas();
           
//System.out.println("\t***SE LANSA HILO HIJO::: "+numeroHilo+" \n\t HAY " +frascoConGalletas.numGalletas + " GALLETAS EN EL FRASCO");
/*
System.out.println("\t***EL FRASCO ESTA LLENO (TRUE) ? ::: "+frascoConGalletas.frascoLleno+"");
System.out.println("\t***EL FRASCO ESTA DISPONIBLE (TRUE) ? ::: "+frascoConGalletas.frascoDisponible+"");
frascoConGalletas.consumirGalletas();
System.out.println("\t***HILO HIJO "+numeroHilo+" CONSUMI 3 GALLETAS :::");
*/
      
    
    
}
}
