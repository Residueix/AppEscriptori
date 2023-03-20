package residueix.residueixapp;

/**
 * Classe principal del nostre projecte que obre PantallaLogin.
 * @author Daniel Garcia Ruiz
 * @version 12/03/2023
 */
public class Residueixapp {
    
   /**
    * Crea una nova instància de la classe Residueixapp
    */
    public Residueixapp(){
    }
    
    /**
     * Mètode principal de l'aplicació.
     * @param args els arguments de la linia d'ordres.
     */
    public static void main (String [ ] args) {
        // Obrim la pantalla de Login.
        PantallaLogin pantallaLogin = new PantallaLogin();
        pantallaLogin.setVisible(true);
    }
    
}
