package utils;

// Imports
import javax.swing.ImageIcon;
import org.junit.Test;
import static org.junit.Assert.*;
import residueix.residueixapp.utils.Utils;

/**
 * Classe TestUtils per proves de les funcions de utils.
 * @author Daniel Garcia Ruiz
 * @version 19/04/2023
 */
public class TestUtils {
    
    /**
     * Mètode validarCheckboxTrue per validar l'estat del checkbox i pasar-ho a format text quan està seleccionat
     */
    @Test
    public void validarCheckboxTrue(){
       String res = Utils.validarCheckbox(true);
       String esp = "1";
       assertEquals(esp,res);
    }
    
    /**
     * Mètode validarCheckboxFalse per validar l'estat del checkbox i pasar-ho a format text quan no està seleccionat
     */
    @Test
    public void validarCheckboxFalse(){
       String res = Utils.validarCheckbox(false);
       String esp = "0";
       assertEquals(esp,res);
    }
    
    /**
     * Mètode validarDecimalCorrete per validar si l'string que passem té format de número decimal (double)
     */
    @Test
    public void validarDecimalCorrete(){
        boolean res = Utils.validarDecimal("0.009");
        boolean esp = true;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode validarDecimalIncorrecte per validar si l'string que passem no té format de número decimal (double)
     */
    @Test
    public void validarDecimalIncorrecte(){
        boolean res = Utils.validarDecimal("hola");
        boolean esp = false;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode validarCPCorrecte per validar si l'string que passem té format de CP (5 números fins el 52999)
     */
    @Test
    public void validarCPCorrecte(){
        boolean res = Utils.validarCP("08620");
        boolean esp = true;
        assertEquals(esp,res);   
    }
    
    /**
     * Mètode validarCPIncorrecteMesNumeros per validar si l'string que passem no té format de CP (5 números fins el 52999)
     */
    @Test
    public void validarCPIncorrecteMesNumeros(){
        boolean res = Utils.validarCP("086209");
        boolean esp = false;
        assertEquals(esp,res);   
    }
    
    /**
     * Mètode validarCPIncorrecteNomesNumeros per validar si l'string que passem no té format de CP (5 números fins el 52999)
     */
    @Test
    public void validarCPIncorrecteNomesNumeros(){
        boolean res = Utils.validarCP("hola");
        boolean esp = false;
        assertEquals(esp,res);   
    }
    
    /**
     * Mètode validarCPIncorrecteMes52999 per validar si l'string que passem no té format de CP (5 números fins el 52999)
     */
    @Test
    public void validarCPIncorrecteMes52999(){
        boolean res = Utils.validarCP("53000");
        boolean esp = false;
        assertEquals(esp,res);   
    }
    
    /**
     * Mètode validarSelectorCorrecte per validar si l'item d'un selector és un index vàlid
     */
    @Test
    public void validarSelectorCorrecte(){
        boolean res = Utils.validarSelector(18);
        boolean esp = true;
        assertEquals(esp,res);   
    }
    
    /**
     * Mètode validarSelectorIncorrecte0 per validar si l'item d'un selector és un index no vàlid, amb 0
     */
    @Test
    public void validarSelectorIncorrecte0(){
        boolean res = Utils.validarSelector(0);
        boolean esp = false;
        assertEquals(esp,res);   
    }
    
    /**
     * Mètode validarSelectorIncorrecte per validar si l'item d'un selector és un index no vàlid amb negatiu
     */
    @Test
    public void validarSelectorIncorrecte(){
        boolean res = Utils.validarSelector(-4);
        boolean esp = false;
        assertEquals(esp,res);   
    }
    
    /**
     * Mètode errorCorrecte per retornar un error existent
     */
    @Test
    public void errorCorrecte(){
        String res = Utils.error(9);
        String esp = "No s'ha pogut validar el email i no s'ha enviat cap correu.";
        assertEquals(esp,res);   
    }
    
    /**
     * Mètode errorIncorrecte per retornar un error que no és existent
     */
    @Test
    public void errorIncorrecte(){
        String res = Utils.error(-6);
        String esp = "";
        assertEquals(esp,res);   
    }
    
        /**
     * Mètode formatEmailCorrecte utilitzat per validar que el format de l'email és el correcte.
     */
    @Test
    public void formatEmailCorrecte() {
        boolean res = Utils.validarEmail("danisvh@gmail.com");
        boolean esp = true;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode formatEmailIncorrecte utilitzat per validar que el format de l'email és incorrecte i tractar els errors.
     */
    @Test
    public void formatEmailIncorrecte() {
        boolean res = Utils.validarEmail("malament");
        boolean esp = false;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode validarTextCorrecte per validar si el text que li passem està en un rang de caràcters.
     */
    @Test
    public void validarTextCorrecte(){
        boolean res = Utils.validarText("hola",4, 10);
        boolean esp = true;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode validarTextIncorrectePetit per validar si el text que li passem està per sota d'un rang de caràcters.
     */
    @Test
    public void validarTextIncorrectePetit(){
        boolean res = Utils.validarText("hola",5, 10);
        boolean esp = false;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode validarTextIncorrecteGran per validar si el text que li passem està per damunt d'un rang de caràcters.
     */
    @Test
    public void validarTextIncorrecteGran(){
        boolean res = Utils.validarText("holacaracola",5, 10);
        boolean esp = false;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode carregarImatgeCorrecte per validar la càrrega d'imatges des de el servidor.
     */
    @Test
    public void carregaImatgeCorrecte() {
        String imatge = "prova.png";
        ImageIcon icon = Utils.carregaImatge(3, imatge);
        assertNotNull(icon);
        assertEquals( 200, icon.getIconWidth());
        assertEquals(120, icon.getIconHeight());
    }
    
    /**
     * Mètode carregaImatgeIncorrecte per validar la càrrega d'imatges des de el servidor quan no existeix la imatge.
     */
    @Test
    public void carregaImatgeIncorrecte(){
        ImageIcon imatge = Utils.carregaImatge(3,"no_prova.png");
        ImageIcon esp = null;
        assertEquals(esp,imatge);
    }    
    
}