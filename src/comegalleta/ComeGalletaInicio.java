package comegalleta;

 //<editor-fold defaultstate="collapsed" desc="LIBRERIAS E IMPORTACIONES">
import comegalleta.ObjetosComegalletas.MamaHilo;
import comegalleta.ObjetosComegalletas.frascoDeGalletas;
import comegalleta.ObjetosComegalletas.niñoHilo;
import javax.swing.JOptionPane;        
//</editor-fold>

public class ComeGalletaInicio {

    public static void main(String[] args) {
        
        //<editor-fold defaultstate="collapsed" desc="VARIABLES GLOBALES">
        short galletasMaximas = 15;
        short galletasPorNiño = 3;
        short galletasPorMama = 5;
        

        frascoDeGalletas nuevoFrascoGalletas = new frascoDeGalletas(galletasMaximas);  // RECIBE CAPACIDAD FRASCO COMO PARAMETRO
        niñoHilo[] niñosHilos = new niñoHilo[150]; // LARGO DEL ARREGLO DE HILOS DE TIPO niñoHilo :: 150 
        MamaHilo[] MamaHilosGalletas = new MamaHilo[90]; // LARGO DEL ARREGLO DE HILOS DE TIPO mama :: 90
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="DESPLIEGE DE HILOS">
        

        for (int numHilos = 0; numHilos < 150; numHilos++) { // DEL 0 AL 150 COMO NUMERO MAXIMO DE HILOS 
            
            //<editor-fold defaultstate="collapsed" desc="CREACION AMBOS HILOS MIENTRAS 'numHilos' SEA MENOR QUE 90">
            if (numHilos < 90) {
                System.out.println("\t->>>>CREANDO HILO MAMA [" + numHilos + " ] , \n¸\t->>>>CREANDO HILO HIJO [" + numHilos+" ] \n");
                niñosHilos[numHilos] = new niñoHilo(nuevoFrascoGalletas, galletasPorNiño, numHilos);
                MamaHilosGalletas[numHilos] = new MamaHilo(nuevoFrascoGalletas, galletasPorMama, numHilos);
                niñosHilos[numHilos].start();
                MamaHilosGalletas[numHilos].start();
            }
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="CREACION HILOS NIÑO MIENTRAS 'numHilos' SEA MENOR QUE 150">
            else {
                System.out.println("\t->>>> CREANDO SOLO  HILO  NIÑO NUMERO " + numHilos + "\n");
                niñosHilos[numHilos] = new niñoHilo(nuevoFrascoGalletas, galletasPorNiño, numHilos);
                niñosHilos[numHilos].start();
            }
            //</editor-fold>
        }
        //</editor-fold>
        
     
     
      
        System.out.println("\nNUMERO DE HILOS NIÑO " + niñosHilos.length);
        System.out.println("NUMERO DE HILOS MAMA " + MamaHilosGalletas.length);
        System.out.println("Galletas totales " + nuevoFrascoGalletas.numGalletas);

    }
}
