
package comegalleta.ObjetosComegalletas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class frascoDeGalletas {
    //<editor-fold defaultstate="collapsed" desc="VARIABLES GLOBALES">
    protected boolean frascoLleno;
    public boolean agregandoGalletas;
    public short numGalletas;
    protected short capacidadMaxima;
    protected boolean frascoDisponible;
//</editor-fold>     
    
    public frascoDeGalletas(short maxGalletas){
        this.frascoLleno = false;  // EL FRASCO NO ESTA LLENO AL INICIO SE ENCUENTRA VACIO
        this.numGalletas = 0; // HAY 0 GALLETAS EN EL FRASCO AL INICIO DEL PROGRAMA    
        this.capacidadMaxima = maxGalletas; // valor 15 
        this.frascoDisponible = false;
        this.agregandoGalletas = false;        
    }

    
    public  synchronized void consumirGalletas(){
     
      VerificarFrascoAlDesborde();
             

      while(!frascoLleno  && !frascoDisponible){
           try {
                System.out.println("\t-------HILO HIJO  DETENIDO RECURSO OCUPADO  SIN GALLETAS ------ \n"
                        + "\t-------Frasc lleno ; " +frascoLleno+" FRASCO DISPONIBLE :"+frascoDisponible +"\n");
                wait(); // EL HILO DE ESCRITURA SE DETIENE POR QUE ESTA IMPRIMIENDO O ESTA LLENO 
                  
            } catch( InterruptedException e ) {
                JOptionPane.showMessageDialog(null,"Ocurrio Un error al detener el Hilo MAMA");
                }
            }
      frascoDisponible = false;
       numGalletas = (short)(numGalletas-3);
       System.out.println("\t------- ALGUIEN  COMIO 3 GALLETAS !!!!!!! ");
       
       
       VerificarFrascoAlDesborde();
        //System.out.println("\t***NOTIFICANDO DESDE HILO NIÑO y HACIENDO FALSE LA DISPONIBILIDAD DE FRASCO");
        notify();
       
            System.out.println("");
      }
        
    
    
    public synchronized void prepararGalletas(short galletasProducidas){
       //MIENTRAS EL BUFFER PRINCIPAL ESTE LLENO 
      VerificarFrascoAlDesborde();
        while( frascoLleno )
            {
            try {
                System.out.println("°°°MAMA DETENIDO RECURSO OCUPADO ,Frasco " +frascoLleno+"..................");
                wait(); // EL HILO DE ESCRITURA SE DETIENE POR QUE ESTA IMPRIMIENDO O ESTA LLENO 
                  
            } catch( InterruptedException e ) {
               JOptionPane.showMessageDialog(null,"Ocurrio Un error al detener el Hilo MAMA");
                }
            }
      
       numGalletas = (short) (numGalletas + 5); 
        
       VerificarFrascoAlDesborde();
        
        System.out.println("");
        notify();
 }
    
        
       public void VerificarFrascoAlDesborde(){
           //System.out.println("\t*******VERIFICANDDO CON "+numGalletas +" GALLETAS  \n");
        if(numGalletas > 11){
            frascoLleno = true;
          System.out.print("**FRASCO LLENO  --------------"+numGalletas+" gALLETAS\n");
          
            }
        if(numGalletas >= 3 && numGalletas < 12){
            System.out.println("**YA PUEDEN AGARRAR GALLETAS FRASCO DISPONOBLE Y FRASCOLLENO FALSO------------------ ");
            frascoDisponible = true;
            frascoLleno = false;
           }  
        
               
    } 
    } 
       
            
   
        
    
    

   
    
    
    