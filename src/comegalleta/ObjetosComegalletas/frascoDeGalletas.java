package comegalleta.ObjetosComegalletas;

//<editor-fold defaultstate="collapsed" desc="LIBRERIAS Y IMPORTACIONES">
import javax.swing.JOptionPane;
import comegalleta.Interfaz.interfazComegalletas;
//</editor-fold>

public class frascoDeGalletas implements interfazComegalletas {

    //<editor-fold defaultstate="collapsed" desc="VARIABLES GLOBALES">
    protected boolean frascoLleno;
    public boolean agregandoGalletas;
    public short numGalletas;
    protected short capacidadMaxima;
    protected boolean frascoDisponible;
//</editor-fold>     

    public frascoDeGalletas(short maxGalletas) {
        this.frascoLleno = false;  // EL FRASCO NO ESTA LLENO AL INICIO SE ENCUENTRA VACIO
        this.numGalletas = 0; // HAY 0 GALLETAS EN EL FRASCO AL INICIO DEL PROGRAMA    
        this.capacidadMaxima = maxGalletas; // valor 15 
        this.frascoDisponible = false; // EL FRASCO AUN NO ESTA DISPONIBLE SI ESTA VACIO
    }

    //<editor-fold defaultstate="collapsed" desc="METODOS IMPLEMENTADOS DE 'InterfazComeGalletas'">
    @Override
    public synchronized void consumirGalletas() {

        VerificarEstatusFrasco(); // ANTES DE COMER VERIFICAMOS QUE EL FRASCO ESTE LLENO O DISPONIBLE

        //<editor-fold defaultstate="collapsed" desc="MIENTRAS SE ENCUENTRE VACIO Y NO ESTE DISPONIBLE">
        while (!frascoLleno && !frascoDisponible) {
            try { // DETIENE EL HILO
                System.out.println("\t-------HILO HIJO  DETENIDO RECURSO OCUPADO  SIN GALLETAS ------ \n"
                        + "\t-------Frasc lleno ; " + frascoLleno + " FRASCO DISPONIBLE :" + frascoDisponible + "\n");
                wait(); // EL HILO DE ESCRITURA SE DETIENE POR QUE ESTA IMPRIMIENDO O ESTA LLENO 

            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio Un error al detener el Hilo MAMA");
            }
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="MIENTRAS **NO SE ENCUENTRE VACIO **O ESTE DISPONIBLE">
        frascoDisponible = false; //MIENTRAS EL FRASCO ESTE LLENO O DISPONIBLE ---- COLOCA EL FRASCO SIN DISPONIBILIDAD
        numGalletas = (short) (numGalletas - 3); // EL FRASCO NO ESTA DISPONIBLE POR QUE AGARRA GALLETAS 
        System.out.println("\t------- ALGUIEN  COMIO 3 GALLETAS !!!!!!! \n ");
        //</editor-fold>

        VerificarEstatusFrasco(); // VERIFICAMOS EL FRASCO NUEVAMENTE PARA CONTINUAR CONSUMIENDO O RELLENAR EGUN STATUS

        notify(); // NOTIFICAMOS EL NUEVO VALOR DE VARIABLES Y DESPERTAMOS HILOS

    }

    @Override
    public synchronized void prepararGalletas(short galletasProducidas) {

        VerificarEstatusFrasco();

        //<editor-fold defaultstate="collapsed" desc="MIENTRAS  EL FRASCO ESTE LLENO ">
        while (frascoLleno) {
            try { // DETIENE EL HILO DE PRODUCCION
                System.out.println("°°°MAMA DETENIDO RECURSO OCUPADO ,Frasco " + frascoLleno + "..................");
                wait(); // EL HILO DE ESCRITURA SE DETIENE POR QUE ESTA IMPRIMIENDO O ESTA LLENO 

            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Ocurrio Un error al detener el Hilo MAMA");
            }
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="MIENTRAS  EL FRASCO AUN NO ESTE LLENO Y ESTE DISPONIBLE ">
        numGalletas = (short) (numGalletas + 5);
        System.out.println("°°° MAMA COLOCO 5 GALLETAS !!!!!!! \n ");

        //</editor-fold>
        
        VerificarEstatusFrasco();

        notify();
    }

    @Override
    public void VerificarEstatusFrasco() {

        //<editor-fold defaultstate="collapsed" desc="VERIFICACION DE FRASCO LLENO ">
        if (numGalletas > 10) { // MAYOR QUE 10 POR QUE AL AGREGAR 5 MAS SE DESBORDA MAYOR QUE 15
            frascoLleno = true; // BANDERA DE FRASCO LLENO VERDADERA 
            System.out.print("**FRASCO LLENO  --------------" + numGalletas + " gALLETAS\n");

        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="VERIFICACION DE MAS DE 3 GALLETAS Y VACIO PARA DISPONIBILIDAD">
        if (numGalletas >= 3 && numGalletas < 15) { // SI EL NUMERO DE GALLETAS ES MAYOR QUE TRES Y MENOR QUE
            System.out.println("**YA PUEDEN AGARRAR GALLETAS FRASCO DISPONOBLE Y FRASCOLLENO FALSO------------------ ");
            frascoDisponible = true; // EL FRASCO ESTARA DISPONIBLE 
            frascoLleno = false; // Y NO ESTARA LLENO AUN
        }
        //</editor-fold>

    }

    //</editor-fold>
}
