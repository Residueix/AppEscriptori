/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package residueix.residueixapp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Classe amb utiitats per poder utilitzar durant el codi.
 * @author Daniel Garcia Ruiz
 * @version 26/03/2023
 */
public class Utils {
    
    /**
    * Constructor - Crea una nova instància de la classe Utils
    */
    public Utils(){}
    
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
     * Mètode per validar el selector
     * @param index (int) Index seleccionat
     * @return true/false
     */
    public static boolean validarSelector(int index){
        return index != 0;
    }
    
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
    
}
