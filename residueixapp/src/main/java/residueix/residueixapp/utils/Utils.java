package residueix.residueixapp.utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Classe amb utiitats per poder utilitzar durant el codi.
 * @author Daniel Garcia Ruiz
 * @version 03/04/2023
 */
public class Utils {
   
    /**
    * Constructor - Crea una nova instància de la classe Utils
    */
    public Utils(){}

    /**
     * Mètode per validar els checbox i pasar-ho a text
     * @param estat (boolean) estat del checkbox
     * @return 1/0 en format String
     */
    public static String validarCheckbox(boolean estat){
        if(estat){
            return "1";
        }else{
            return "0";
        }
    }
 
    /**
     * Mètode per validar el format del decimal
     * @param valor (String) decimal a comprovar.
     * @return true/false
     */
    public static boolean validarDecimal(String valor){
        try{
            Double.valueOf(valor);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
    
    /**
     * Mètode per validar el format del Codi postal
     * @param valor (String) codi postal a comprobar.
     * @return true/false
     */
    public static boolean validarCP(String valor){
        
        // Comprovem que el codi tingui exactament 5 caràcters.
        if (valor.length() != 5) { return false; }
        
        // Comprovem que tots els caràcters siguin digits
        for (int i = 0; i < valor.length(); i++) { if (!Character.isDigit(valor.charAt(i))) { return false; } }

        // Convertim el cp a integer
        int cp = Integer.parseInt(valor);

        // Comprovem que el cp (integuer) sigui vàlid en el rang.
        if (cp < 0 || cp > 52999) { return false; }
           
        // Si hem passat totes les validacions retornem true.
        return true;
    }
    
    /**
     * Mètode per validar el selector
     * @param index (int) Index seleccionat
     * @return true/false
     */
    public static boolean validarSelector(int index){
        return index != 0;
    }
    
    /**
     * Mètode per obenir un missatge d'error
     * @param codi (int) : codi númeric de l'error

     * @return missatge (String) : Missatge amb l'error.
     */
    public static String error(int codi){
        switch(codi){
            case 1 -> { return "Error: app_1 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema."; }
            case 2 -> { return "Error: app_2 - No té permís per accedir a l'aplicació."; }
            case 3 -> { return "Error: app_3 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema. El llistat d'usuaris està buit."; }
            case 4 -> { return "Error: app_4 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema. L'usuari no s'ha creat.";}
            case 5 -> { return "Error: app_5 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema. L'usuari no es pot consultar.";}
            case 6 -> { return "Error: app_6 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema. L'usuari no s'ha eliminat.";}
            case 7 -> { return "Error: app_7 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema. El tipus d'usuari no correspon amb cap tipus controlat.";}
            case 8 -> { return "Has de seleccionar una fila de la taula d'usuaris."; }
            case 9 -> { return "No s'ha pogut validar el email i no s'ha enviat cap correu."; }
            case 10 -> { return "No s'ha pogut enviar e correu. Posi's en contacte amb Residueix."; }
            case 11 -> { return "Correu enviat! comprovi-ho i canvii la paraula clau el més aviat possible."; }
            case 12 -> { return "S'ha modificat el perfil"; }
            case 13 -> { return "Format d'email incorrecte."; }
            case 14 -> { return "Has de seleccionar una fila de la taula de tipus de residu."; }
            case 15 -> { return "Has de seleccionar una fila de la taula de punts de recollida."; }
            default -> { return ""; }
        }
    }
    
    /**
     * Mètode per validar el format de un email
     * @param email (String) : email a validar
     * @return true / false (boolean)s
     */
    public static boolean validarEmail(String email){
        // Patró
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
    
    /**
     * Mètode per validar el format text.
     * @param text (String) text a comprovar.
     * @param minCaracters (int) mínim de caràcters permessos.
     * @param maxCaracters (int) màxim de caràcters permessos.
     * @return true/false
     */
    public static boolean validarText(String text,int minCaracters, int maxCaracters){
        return (text.length()>minCaracters) && (text.length()<=maxCaracters);
    }
   
    
    /**
     * Mètode per recuperar imatges del servidor
     * @param seccio (int) secció de l'aplicació per determinar la url on està la imatge
     * @param imatge (String) nom de la imatge
     * @return ImageIcon amb la imatge o null
     */
    public static ImageIcon carregaImatge(int seccio,String imatge){
        String url1 = "";
        int width = 75;
        int height = 75;
        try {
            
            // En funció de la secció determinem la url on està la imatge
            switch(seccio){
                case 1 -> { url1 = "http://169.254.142.250/residueix/img/residus/tipus/" + imatge;}
                case 2 -> { url1 = "http://169.254.142.250/residueix/img/residus/" + imatge;}
                case 3 -> {
                    url1 = "http://169.254.142.250/residueix/img/punts/" + imatge;
                    width=200;  height=120;
                }
            }
            
            // Creem la url 
            URL url = new URL(url1);
            
            // Fem un buffered amb el retorn de la imatge
            BufferedImage imagen = ImageIO.read(url);
            
            // Comprovem que sigui correcte
            if(imagen!=null){
                // Retornem el ImageIcon<
                ImageIcon icono = new ImageIcon(imagen);
                Icon ico = new ImageIcon(icono.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                return (ImageIcon) ico;
            }else{
                return null;
            }
        } catch (MalformedURLException ex) {
            // Excepció url mal formada
            return null;
        } catch (IOException ex) {
            // Excepció entrada/sortida dades
            return null;
        }
    }
    
}


    
    
  
    

    

    



