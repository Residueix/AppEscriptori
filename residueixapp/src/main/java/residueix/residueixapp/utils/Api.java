package residueix.residueixapp.utils;

// Imports
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.json.JSONObject;
import residueix.residueixapp.models.Usuari;

/**
 * Classe d'utilitats per conectar amb l'API del servidor.
 * @author Daniel Garcia Ruiz
 * @version 21/04/2023
 */
public class Api {
    
    /**
     * Token public per apis sense credencials
     */
     public static String token = "6e06ad1160adeafe010cebb9";
    
    /**
    * Constructor - Crea una nova instància de la classe App
    */
    public Api(){}
    
    // Mètodes Accés
    // ------------------------------------------------------------------------
    
    /**
     * Mètode per fer el login de l'usari.
     * @param email : email/nom usari
     * @param password :  paraula clau.
     * @return JSONObject: json amb les dades del login o l'error, o buit si hi ha excepció.
     */
    public static JSONObject login(String email, String password){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/login/index.php");
           urlencoded.afegirCamp("usuari", email);
           urlencoded.afegirCamp("password", password);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_login\",\"error\":\"Error en execució al enviar la petició.\"}");    
        }   
    }
    
    /**
     * Mètode per fer fer el logout de l'usuari
     * @param usuari : usuari que fa la petició.
     */
    public static void logout(Usuari usuari){
       try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/logout/index.php");
           urlencoded.afegirCamp("id", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
        } catch (IOException ex){
            System.out.println("Error excepció:" + ex.getMessage());
        } 
    }
        
    /**
     * Mètode per comprovar si existeix un correu/usuari
     * @param correu (String) : correu a cercar
     * @return JSONObject: json amb la resposta.
     */
    public static JSONObject existeixCorreu(String correu){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/existeix/index.php");
           urlencoded.afegirCamp("email", correu);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_existeixCorreu\",\"error\":\"Error en execució al enviar la petició.\"}");    
        } 
    }
    
    // Mètodes Generals
    // ------------------------------------------------------------------------
    
    /**
     * Mètode per recuperar el llistat de poblacions
     * @return JSONArray: json amb el llistat d'usuaris.
    */
    public static JSONObject llistatPoblacions(){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/global/poblacions/index.php");
           urlencoded.afegirCamp("token", Api.token);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_llistatPoblacions\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }        
    }
    
    /**
     * Mètode per eliminar registre de la base de dades completament (per les proves junit)
     * @param seccio (String) secció de la que es vol eliminar el registre
     * @param id (String) id que s vol eliminar
     * @return JSONObject amb la resposta.
     */
    public static JSONObject eliminarRegistre(String seccio, String id){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/global/eliminar/index.php");
           urlencoded.afegirCamp("token", Api.token);
           urlencoded.afegirCamp("seccio", seccio);
           urlencoded.afegirCamp("id", id);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_eliminar\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }      
    }
    
    // Mètodes Usuaris
    // ------------------------------------------------------------------------
    
    /**
     * Mètode per recuperar el llistat d'usaris
     * @param usuari (Usuari): usuari que fa la petició.
     * @param comboTipus (int) : seleccio del combo tipus
     * @param comboActiu (int) : seleccio del combo actiu
     * @return JSONArray json amb el llistat d'usuaris.
     */
    public static JSONObject llistatUsuaris(Usuari usuari,int comboTipus, int comboActiu){
        try{
            // Validem les opcions
            String filtreTipus; 
            String filtreActiu;
            switch(comboTipus){
                case 1 -> { filtreTipus = "1"; }
                case 2 -> { filtreTipus = "2"; }
                case 3 -> { filtreTipus = "3"; }
                case 4 -> { filtreTipus = "4"; }
                default ->{ filtreTipus = ""; }
            }
            switch(comboActiu){
                case 1 -> { filtreActiu = "1"; }
                case 2 -> { filtreActiu = "0"; }
                default ->{ filtreActiu = ""; }
            }
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/llistat/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("tipus", filtreTipus);
           urlencoded.afegirCamp("actiu", filtreActiu);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_llistatUsuaris\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        } 
    }
    
    /**
     * Mètode per recuperar el llistat de tipus d'usaris
     * @param usuari : usuari que fa la petició.
     * @return JSONArray: json amb el llistat d'usuaris.
     */
    public static JSONObject llistatTipusUsuari(Usuari usuari){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/tipus/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_llistatTipusUsuari\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }          
    }
    
    /**
     * Mètode per recuperar el llistat de tipus d'adherit
     * @param usuari : usuari que fa la petició.
     * @return JSONArray: json amb el llistat de tipus d'adherits
     */
    public static JSONObject llistatTipusAdherit(Usuari usuari){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/global/tipusadherit/index.php");
           
           urlencoded.afegirCamp("token", Api.token);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_llistatTipusAdherit\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }        
    }
    
    /**
     * Mètode per donar d'alta un usuari administrador.
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param email (String) : email de l'usuari
     * @param password (String) : password de l'usuari
     * @param tipus (String) : tipus d'usuari
     * @param nom (String) : nom d'usaris
     * @param cognom1 (String) : cognom1 de l'usari
     * @param cognom2 (String) : cognom2  de l'usuari
     * @param telefon (String) : telèfon de l'usuari
     * @param actiu (String) : usuari actiu
     * @return JSONArray: json amb el llistat d'usuaris.
     */
    public static JSONObject crearUsuariAdministrador(Usuari usuari, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/alta/administrador/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("email", email);
           urlencoded.afegirCamp("password", password);
           urlencoded.afegirCamp("tipus", tipus);
           urlencoded.afegirCamp("nom", nom);
           urlencoded.afegirCamp("cognom1", cognom1);
           urlencoded.afegirCamp("cognom2", cognom2);
           urlencoded.afegirCamp("telefon", telefon);
           urlencoded.afegirCamp("actiu", actiu);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_crearUsuariAdministrador\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }  
    }
    
    /**
     * Mètode per donar d'alta un usuari treballdor.
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param email (String) : email de l'usuari
     * @param password (String) : password de l'usuari
     * @param tipus (String) : tipus d'usuari
     * @param nom (String) : nom d'usaris
     * @param cognom1 (String) : cognom1 de l'usari
     * @param cognom2 (String) : cognom2  de l'usuari
     * @param telefon (String) : telèfon de l'usuari
     * @param actiu (String) : usuari actiu
     * @return JSONArray: json amb el llistat d'usuaris.
     */
    public static JSONObject crearUsuariTreballador(Usuari usuari, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/alta/treballador/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("email", email);
           urlencoded.afegirCamp("password", password);
           urlencoded.afegirCamp("tipus", tipus);
           urlencoded.afegirCamp("nom", nom);
           urlencoded.afegirCamp("cognom1", cognom1);
           urlencoded.afegirCamp("cognom2", cognom2);
           urlencoded.afegirCamp("telefon", telefon);
           urlencoded.afegirCamp("actiu", actiu);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_crearUsuariTreballador\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        } 
    }
    
    /**
     * Mètode per donar d'alta un usuari residuent.
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param email (String) : email de l'usuari
     * @param password (String) : password de l'usuari
     * @param tipus (String) : tipus d'usuari
     * @param nom (String) : nom d'usaris
     * @param cognom1 (String) : cognom1 de l'usari
     * @param cognom2 (String) : cognom2  de l'usuari
     * @param telefon (String) : telèfon de l'usuari
     * @param actiu (String) : usuari actiu
     * @param carrer (String) : carrer de l'usuari
     * @param cp (String) : Codi postal de l'usuari
     * @param poblacio (String) : població de l'usuari (en codi)
     * @return JSONArray: json amb el llistat d'usuaris.
     */
    public static JSONObject crearUsuariResiduent(Usuari usuari, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu, String carrer, String cp, String poblacio){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/alta/residuent/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("email", email);
           urlencoded.afegirCamp("password", password);
           urlencoded.afegirCamp("tipus", tipus);
           urlencoded.afegirCamp("nom", nom);
           urlencoded.afegirCamp("cognom1", cognom1);
           urlencoded.afegirCamp("cognom2", cognom2);
           urlencoded.afegirCamp("telefon", telefon);
           urlencoded.afegirCamp("actiu", actiu);
           urlencoded.afegirCamp("carrer", carrer);
           urlencoded.afegirCamp("cp", cp);
           urlencoded.afegirCamp("poblacio", poblacio);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_crearUsuariResiduent\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        } 
    }

    /**
     * Mètode per donar d'alta un usuari residuent.
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param email (String) : email de l'usuari
     * @param password (String) : password de l'usuari
     * @param tipus (String) : tipus d'usuari
     * @param nom (String) : nom d'usaris
     * @param cognom1 (String) : cognom1 de l'usari
     * @param cognom2 (String) : cognom2  de l'usuari
     * @param telefon (String) : telèfon de l'usuari
     * @param actiu (String) : usuari actiu
     * @param carrer (String) : carrer de l'usuari
     * @param cp (String) : Codi postal de l'usuari
     * @param poblacio (String) : població de l'usuari (en codi)
     * @param nomAdherit (String) : nom de l'adherit
     * @param horaris (String) : horaris del comerç
     * @param tipusAdherit (String) : tipus adherit
     * @return JSONArray: json amb el llistat d'usuaris.
     */
    public static JSONObject crearUsuariAdherit(Usuari usuari, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu, String carrer, String cp, String poblacio, String nomAdherit, String horaris, String tipusAdherit){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/alta/residuent/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("email", email);
           urlencoded.afegirCamp("password", password);
           urlencoded.afegirCamp("tipus", tipus);
           urlencoded.afegirCamp("nom", nom);
           urlencoded.afegirCamp("cognom1", cognom1);
           urlencoded.afegirCamp("cognom2", cognom2);
           urlencoded.afegirCamp("telefon", telefon);
           urlencoded.afegirCamp("actiu", actiu);
           urlencoded.afegirCamp("carrer", carrer);
           urlencoded.afegirCamp("cp", cp);
           urlencoded.afegirCamp("poblacio", poblacio);
           urlencoded.afegirCamp("nom_adherit", nomAdherit);
           urlencoded.afegirCamp("horari", horaris);
           urlencoded.afegirCamp("tipus_adherit", tipusAdherit);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_crearUsuariAdherit\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        } 
    }
    
    /**
     * Mètode per consultar un usuari
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param id (int) : id l'usuari
     * @return JSONObject: json amb el llistat d'usuaris.
     */
    public static JSONObject consultaUsuari(Usuari usuari,int id){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/consulta/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("id", String.valueOf(id));
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_consultaUsuari\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }
    }
        
     /**
     * Mètode per donar de baixa un usuari.
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param id (int) : id l'usuari
     * @return JSONArray: json amb el llistat d'usuaris.
     */
    public static JSONObject eliminarUsuari(Usuari usuari,int id){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/baixa/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("id", String.valueOf(id));
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_eliminarUsuari\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }
    }
        
    /**
     * Mètode per modificar un usuari administrador.
     * @param id (String) : id de l'usuari
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param email (String) : email de l'usuari
     * @param password (String) : password de l'usuari
     * @param tipus (String) : tipus d'usuari
     * @param nom (String) : nom d'usaris
     * @param cognom1 (String) : cognom1 de l'usari
     * @param cognom2 (String) : cognom2  de l'usuari
     * @param telefon (String) : telèfon de l'usuari
     * @param actiu (String) : usuari actiu
     * @return JSONArray: json amb el resultat de l'operació.
     */
    public static JSONObject modificarUsuariAdministrador(Usuari usuari, String id, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/modificacio/administrador/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("id", String.valueOf(id));
           urlencoded.afegirCamp("email",email);
           urlencoded.afegirCamp("password",password);
           urlencoded.afegirCamp("tipus",tipus);
           urlencoded.afegirCamp("nom",nom);
           urlencoded.afegirCamp("cognom1",cognom1);
           urlencoded.afegirCamp("cognom2",cognom2);
           urlencoded.afegirCamp("telefon",telefon);
           urlencoded.afegirCamp("actiu",actiu);
           urlencoded.afegirCamp("id",id);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_modificarUsuariAdministrador\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }
    }
       
    /**
     * Mètode per modificar un usuari treballador.
     * @param id (String) : id de l'usuari
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param email (String) : email de l'usuari
     * @param password (String) : password de l'usuari
     * @param tipus (String) : tipus d'usuari
     * @param nom (String) : nom d'usaris
     * @param cognom1 (String) : cognom1 de l'usari
     * @param cognom2 (String) : cognom2  de l'usuari
     * @param telefon (String) : telèfon de l'usuari
     * @param actiu (String) : usuari actiu
     * @return JSONArray: json amb el resultat de l'operació.
     */
    public static JSONObject modificarUsuariTreballador(Usuari usuari, String id, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/modificacio/treballador/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("id", String.valueOf(id));
           urlencoded.afegirCamp("email",email);
           urlencoded.afegirCamp("password",password);
           urlencoded.afegirCamp("tipus",tipus);
           urlencoded.afegirCamp("nom",nom);
           urlencoded.afegirCamp("cognom1",cognom1);
           urlencoded.afegirCamp("cognom2",cognom2);
           urlencoded.afegirCamp("telefon",telefon);
           urlencoded.afegirCamp("actiu",actiu);
           urlencoded.afegirCamp("id",id);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_modificarUsuariTreballador\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }
    }
      
    /**
     * Mètode per modificar un usuari residuent.
     * @param id (String) : id de l'usuari
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param email (String) : email de l'usuari
     * @param password (String) : password de l'usuari
     * @param tipus (String) : tipus d'usuari
     * @param nom (String) : nom d'usaris
     * @param cognom1 (String) : cognom1 de l'usari
     * @param cognom2 (String) : cognom2  de l'usuari
     * @param telefon (String) : telèfon de l'usuari
     * @param actiu (String) : usuari actiu
     * @param carrer (String) : carrer de l'usuari
     * @param cp (String) : codi postal de l'usuari
     * @param poblacio (String) : codi de la població
     * @return JSONArray: json amb el resultat de l'operació.
     */
    public static JSONObject modificarUsuariResiduent(Usuari usuari, String id, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu, String carrer, String cp, String poblacio){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/modificacio/residuent/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("id", String.valueOf(id));
           urlencoded.afegirCamp("email",email);
           urlencoded.afegirCamp("password",password);
           urlencoded.afegirCamp("tipus",tipus);
           urlencoded.afegirCamp("nom",nom);
           urlencoded.afegirCamp("cognom1",cognom1);
           urlencoded.afegirCamp("cognom2",cognom2);
           urlencoded.afegirCamp("telefon",telefon);
           urlencoded.afegirCamp("actiu",actiu);
           urlencoded.afegirCamp("id",id);
           urlencoded.afegirCamp("carrer",carrer);
           urlencoded.afegirCamp("cp",cp);
           urlencoded.afegirCamp("poblacio",poblacio);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_modificarUsuariResiduent\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }
    }
    
    /**
     * Mètode per modificar un usuari adherit.
     * @param id (String) : id de l'usuari
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param email (String) : email de l'usuari
     * @param password (String) : password de l'usuari
     * @param tipus (String) : tipus d'usuari
     * @param nom (String) : nom d'usaris
     * @param cognom1 (String) : cognom1 de l'usari
     * @param cognom2 (String) : cognom2  de l'usuari
     * @param telefon (String) : telèfon de l'usuari
     * @param actiu (String) : usuari actiu
     * @param carrer (String) : carrer de l'usuari
     * @param cp (String) : codi postal de l'usuari
     * @param poblacio (String) : codi de la població
     * @param tipusAdherit (String) : tipus adherit
     * @param nomAdherit (String) : nom adherit
     * @param horari (String) : horari adherit
     * @return JSONArray: json amb el resultat de l'operació.
     */
    public static JSONObject modificarUsuariAdherit(Usuari usuari, String id, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu, String carrer, String cp, String poblacio, String tipusAdherit, String nomAdherit, String horari){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/usuaris/modificacio/adherit/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("id", String.valueOf(id));
           urlencoded.afegirCamp("email",email);
           urlencoded.afegirCamp("password",password);
           urlencoded.afegirCamp("tipus",tipus);
           urlencoded.afegirCamp("nom",nom);
           urlencoded.afegirCamp("cognom1",cognom1);
           urlencoded.afegirCamp("cognom2",cognom2);
           urlencoded.afegirCamp("telefon",telefon);
           urlencoded.afegirCamp("actiu",actiu);
           urlencoded.afegirCamp("id",id);
           urlencoded.afegirCamp("carrer",carrer);
           urlencoded.afegirCamp("cp",cp);
           urlencoded.afegirCamp("poblacio",poblacio);
           urlencoded.afegirCamp("tipus_adherit",tipusAdherit);
           urlencoded.afegirCamp("nom_adherit",nomAdherit);
           urlencoded.afegirCamp("horari",horari);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_modificarUsuariAdherit\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }
    }
  
    // Mètodes Residus
    // ------------------------------------------------------------------------
    
    /**
     * Mètode per donar d'alta un residu.
     * @param usuari (Usuari) usuari que fa la petició
     * @param tipus (String) tipus de residu
     * @param nom (String) nom residu
     * @param descripcio (String) descripció residu
     * @param valor (String) valor residu
     * @param imatge (File) imatge residu
     * @param actiu (String) actiu residu
     * @return JSONObject amb la resposta de l'api.
     */
    public static JSONObject altaResidu(Usuari usuari,String tipus, String nom, String descripcio, String valor, File imatge, String actiu){
        
        try{
            EnviamentPostMultipart multipart = new EnviamentPostMultipart("http://169.254.142.250/residueix/api/residus/alta/index.php");
            
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
            multipart.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
            multipart.afegirCamp("permis", String.valueOf(usuari.getTipus()));
            multipart.afegirCamp("token", usuari.getToken());
            multipart.afegirCamp("nom", nom);
            multipart.afegirCamp("tipus", tipus);
            multipart.afegirCamp("descripcio", descripcio);
            multipart.afegirCamp("valor", valor);
            multipart.afegirCamp("actiu", actiu);
            multipart.afegirArxiu("imatge", imatge);
            
            List<String> response = multipart.finish();
            
           System.out.println("-"+response.toString()+"-");
            
           return new JSONObject(response.get(0));
           
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio\",\"error\":\"Error en execució al enviar el formulari.\"}");
        }
        
    }
    
    /**
     * Mètode per modifciar un residu
     * @param usuari (Usuari) usuari que fa la petició
     * @param idResidu (int) id residu
     * @param tipus (String) tipus residu
     * @param nom (String) nom residu
     * @param descripcio (String) descripció residu
     * @param valor (String) valor residu
     * @param imatge (File) imatge residu
     * @param actiu (String) actiu residu
     * @return JSONObject amb la resposta de l'api
     */
    public static JSONObject modificacioResidu(Usuari usuari,int idResidu, String tipus, String nom, String descripcio, String valor, File imatge, String actiu){
        try{
            EnviamentPostMultipart multipart = new EnviamentPostMultipart("http://169.254.142.250/residueix/api/residus/modificacio/index.php");
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
            multipart.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
            multipart.afegirCamp("permis", String.valueOf(usuari.getTipus()));
            multipart.afegirCamp("token", usuari.getToken());
            multipart.afegirCamp("id", String.valueOf(idResidu));
            multipart.afegirCamp("nom", nom);
            multipart.afegirCamp("tipus", tipus);
            multipart.afegirCamp("descripcio", descripcio);
            multipart.afegirCamp("valor", valor);
            multipart.afegirCamp("actiu", actiu);
            if(imatge != null){
                multipart.afegirArxiu("imatge", imatge);
            }
            List<String> response = multipart.finish();
           System.out.println("-"+response.toString()+"-");
           return new JSONObject(response.get(0));
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_modificacioResidu\",\"error\":\"Error en execució al enviar el formulari.\"}");
        }
        
    }
    
    /**
     * Mètode per donar d'alta un tipus de residu
     * @param usuari (Usuari) usuari que fa la petició
     * @param nom (String) nom del tipus residu
     * @param imatge (File) imatge tipus residu
     * @return JSONObject resposta de l'api.
     */
    public static JSONObject altaTipusResidu(Usuari usuari, String nom, File imatge){
        try{
            // Instaciem la classe per enviar formularis multipart i configurem camps
            EnviamentPostMultipart multipart = new EnviamentPostMultipart("http://169.254.142.250/residueix/api/residus/tipus/alta/index.php");
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
            multipart.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
            multipart.afegirCamp("permis", String.valueOf(usuari.getTipus()));
            multipart.afegirCamp("token", usuari.getToken());
            multipart.afegirCamp("nom", nom);
            multipart.afegirArxiu("imatge", imatge);
            List<String> response = multipart.finish();
            System.out.println("-"+response.toString()+"-");           
            return new JSONObject(response.get(0));
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio\",\"error\":\""+ex.getMessage()+"\"}");
        } 
    }
    
    /**
     * Mètode per recuperar el llistat de tipus de residu
     * @param usuari (Usuari) usuari que fa la petició
     * @return  JSONObject resposta de l'api
     */
    public static JSONObject llistatTipusResidu(Usuari usuari){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/residus/tipus/llistat/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("token", usuari.getToken());
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_llistatTipusResidu\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }
    }
    
    /**
     * Mètode per consultar un tipus de residu concret
     * @param usuari (Usuari) usuari que fa la petició
     * @param idTipusResidu (int) id tipus residu
     * @return JSONObject resposta de l'api
     */
    public static JSONObject consultaTipusResidu(Usuari usuari, int idTipusResidu){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/residus/tipus/consulta/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("id", String.valueOf(idTipusResidu));
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_consultaTipusResidu\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }
    }
    
    /**
     * Mètode per consultar un residu en concret
     * @param usuari (Usuari) usuari que fa la petició
     * @param idResidu (int) id residu
     * @return JSONObject resposta de l'api
     */
    public static JSONObject consultaResidu(Usuari usuari, int idResidu){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/residus/consulta/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("id", String.valueOf(idResidu));
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_consultaResidu\",\"error\":\"Error en execució al enviar el formulari.\"}");    
        }
    }
    
    /**
     * Mètode per donar de baixa un tipus de residu
     * @param usuari (Usuari) usuari que fa la petició
     * @param idTipusResidu (int) id tipus residu
     * @return JSONObject resposta de l'api
     */
    public static JSONObject baixaTipusResidu(Usuari usuari, int idTipusResidu){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/residus/tipus/baixa/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("id", String.valueOf(idTipusResidu));
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_baixaTipusResidu\",\"error\":\"Error en execució al enviar la petició.\"}");    
        }
    }
    
    /**
     * Mètode per donar de baixa un residu
     * @param usuari (Usuari) usuari que fa la petició
     * @param idTipusResidu (int) id tipus residu
     * @return JSONObject resposta de l'api
     */
    public static JSONObject baixaResidu(Usuari usuari, int idTipusResidu){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/residus/baixa/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("id", String.valueOf(idTipusResidu));
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_baixaResidu\",\"error\":\"Error en execució al enviar la petició.\"}");    
        }
    }
    
    /**
     * Mètode per modificar un tipus de residu
     * @param usuari (Usuari) usuari que fa la petició
     * @param id (String) id tipus residu
     * @param nom (String) nom tipus residu
     * @param imatge (File) imatge tipus residu
     * @return JSONObject resposta de l'api
     */
    public static JSONObject modificacioTipuResidu(Usuari usuari, String id, String nom, File imatge){
         try{
            // Instaciem la classe per enviar formularis multipart i configurem camps
            EnviamentPostMultipart multipart = new EnviamentPostMultipart("http://169.254.142.250/residueix/api/residus/tipus/modificacio/index.php");
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
            multipart.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
            multipart.afegirCamp("permis", String.valueOf(usuari.getTipus()));
            multipart.afegirCamp("token", usuari.getToken());            
            multipart.afegirCamp("id", id);
            multipart.afegirCamp("nom", nom);
            if(imatge != null){
                multipart.afegirArxiu("imatge", imatge);
            }
            List<String> response = multipart.finish();
            return new JSONObject(response.get(0));
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_modificacioTipusResidu\",\"error\":\"Error en execució al enviar el formulari.\"}");
        }       
    }
    
    /**
     * Mètode per recuperar el llistat de residus
     * @param usuari (Usuari) usuari que fa la petició
     * @return JSONObject resposta de l'api
     */
    public static JSONObject llistatResidus(Usuari usuari){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/residus/llistat/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("token", usuari.getToken());
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_llistatResidus\",\"error\":\"Error en execució al enviar la petició.\"}");    
        }
    }    
    
    // Mètodes Punts de recollida
    // ------------------------------------------------------------------------
    
    /**
     * Mètode per recuperar el llistat de punts de recollida
     * @param token (string) token públic
     * @param actiu (String) si es un punt actiu o no.
     * @return JSONObject resposta de l'api
     */
    public static JSONObject llistatPunts(String token, String actiu){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/puntsrecollida/llistat/index.php");
           urlencoded.afegirCamp("token", token);
           urlencoded.afegirCamp("actiu", actiu);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_llistatPuntsRecollida\",\"error\":\"Error en execució al enviar la petició.\"}");    
        }
    }  
    
    /**
     * Mètode per donar d'alta un punt de recollida.
     * @param usuari (Usuari) usuari que fa la petició
     * @param nom (String) nom del punt
     * @param descripcio (String) descripció del punt
     * @param latitud (String) latitud del punt
     * @param longitud (String) longitud del punt
     * @param carrer (String) carrer del punt
     * @param cp (String) cp del punt
     * @param poblacio (String) població del punt (id)
     * @param horari (String) horari del punt
     * @param imatge (File) imatge del punt
     * @param actiu (String) actiu del punt
     * @return JSONObject amb la resposta
     */
    public static JSONObject altaPunt(Usuari usuari, String nom, String descripcio, String latitud, String longitud, String carrer, String cp, String poblacio, String horari, File imatge, String actiu){
        try{
            // Instaciem la classe per enviar formularis multipart i configurem camps
            EnviamentPostMultipart multipart = new EnviamentPostMultipart("http://169.254.142.250/residueix/api/puntsrecollida/alta/index.php");
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
            multipart.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
            multipart.afegirCamp("permis", String.valueOf(usuari.getTipus()));
            multipart.afegirCamp("token", usuari.getToken());
            multipart.afegirCamp("nom", nom);
            multipart.afegirCamp("descripcio", descripcio);
            multipart.afegirCamp("latitud", latitud);
            multipart.afegirCamp("longitud", longitud);
            multipart.afegirCamp("carrer", carrer);
            multipart.afegirCamp("poblacio", poblacio);
            multipart.afegirCamp("cp", cp);
            multipart.afegirCamp("horari", horari);
            multipart.afegirArxiu("imatge", imatge);
            multipart.afegirCamp("actiu", actiu);
            List<String> response = multipart.finish();
            System.out.println("-"+response.toString()+"-");           
            return new JSONObject(response.get(0));
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_altaPunt\",\"error\":\"Error en execució al enviar el formulari.\"}");
        }      
    }
    
    /**
     * Mètode per consultar un punt de recollida
     * @param idPunt (int) id del punt
     * @return JSONObject amb la resposta
     */
    public static JSONObject consultaPunt(int idPunt){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/puntsrecollida/consulta/index.php");
           urlencoded.afegirCamp("token", Api.token);
           urlencoded.afegirCamp("id", String.valueOf(idPunt));
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_consultaPuntRecollida\",\"error\":\"Error en execució al enviar la petició.\"}");    
        }   
    }
    
    /**
     * Mètode per modificar un punt de recollida
     * @param usuari (Usuari) usuari que fa la petició
     * @param id (int) id del punt de recollida
     * @param nom (String) nom del punt
     * @param descripcio (String) descripció del punt
     * @param latitud (String) latitud del punt
     * @param longitud (String) longitud del punt
     * @param carrer (String) carrer del punt
     * @param cp (String) cp del punt
     * @param poblacio (String) població del punt
     * @param horari (String) horari del punt
     * @param imatge (File) image del punt
     * @param actiu (String) actiu del punt
     * @return JSONObject amb la resposta
     */
    public static JSONObject modificacioPunt(Usuari usuari, int id, String nom, String descripcio, String latitud, String longitud, String carrer, String cp, String poblacio, String horari, File imatge, String actiu){
        try{
            // Instaciem la classe per enviar formularis multipart i configurem camps
            EnviamentPostMultipart multipart = new EnviamentPostMultipart("http://169.254.142.250/residueix/api/puntsrecollida/modificacio/index.php");
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
            multipart.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
            multipart.afegirCamp("id", String.valueOf(id));
            multipart.afegirCamp("permis", String.valueOf(usuari.getTipus()));
            multipart.afegirCamp("token", usuari.getToken());
            multipart.afegirCamp("nom", nom);
            multipart.afegirCamp("descripcio", descripcio);
            multipart.afegirCamp("latitud", latitud);
            multipart.afegirCamp("longitud", longitud);
            multipart.afegirCamp("carrer", carrer);
            multipart.afegirCamp("poblacio", poblacio);
            multipart.afegirCamp("cp", cp);
            multipart.afegirCamp("horari", horari);
            if(imatge != null){
                multipart.afegirArxiu("imatge", imatge);
            }
            multipart.afegirCamp("actiu", actiu);
            List<String> response = multipart.finish();
            System.out.println("-"+response.toString()+"-");           
            return new JSONObject(response.get(0));
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_modificarPunt\",\"error\":\"Error en execució al enviar el formulari.\"}");
        }      
    }
    
    /**
     * Mètode per donar de baixa un punt de recollida
     * @param usuari (Usuari) usuari que fa la petició
     * @param idPunt (int) id del punt de recollida
     * @return JSONObject amb la resposta
     */
    public static JSONObject baixaPunt(Usuari usuari, int idPunt){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/puntsrecollida/baixa/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("id", String.valueOf(idPunt));
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_baixaPunt\",\"error\":\"Error en execució al enviar la petició.\"}");    
        }     
    }
    
    /**
     * Mètode per guardar la recollida d'un residuent per part d'un treballador.
     * @param usuari (Usuari) usuari loginat
     * @param carreto (String) json amb el carretó de la recollida.
     * @return JSONObject amb la resposta
     */
    public static JSONObject recollida(Usuari usuari, String carreto){
     try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/puntsrecollida/recollida/index.php");
           urlencoded.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
           urlencoded.afegirCamp("permis", String.valueOf(usuari.getTipus()));
           urlencoded.afegirCamp("token", usuari.getToken());
           urlencoded.afegirCamp("recollida", String.valueOf(carreto));
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_enviamentCarreto\",\"error\":\"Error en execució al enviar la petició.\"}");    
        }       
    }
     
    // Mètodes Esdeveniments
    // ------------------------------------------------------------------------
    
    /**
     * Mètode per recuperar el llistat d'esdeveniments
     * @return JSONObject resposta de l'api
     */
    public static JSONObject llistatEsdeveniments(){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/esdeveniments/llistat/index.php");
           urlencoded.afegirCamp("token", Api.token);
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_llistatEsdeveniments\",\"error\":\"Error en execució al enviar la petició.\"}");    
        }
    }  
    
    /**
     * Mètode per donar d'alta un esdeveniment
     * @param usuari (Usuari) usuari que fa la petició
     * @param nom (String) nom esdeveniment
     * @param descripcio (String) descripcio esdeveniment
     * @param data (String) data esdeveniment
     * @param hora (String) hora esdeveniment
     * @param poblacio (String) poblacio esdeveniment
     * @param valor (String) valor esdeveniment
     * @param aforament (String) aforament esdeveniment
     * @param imatge (String) imatge esdeveniment
     * @param actiu (String) actiu esdeveniment
     * @return JSONObject amb el retorn de l'api.
     */
    public static JSONObject altaEsdeveniment(Usuari usuari, String nom, String descripcio, String data, String hora, String poblacio, String valor, String aforament, File imatge, String actiu){
        try{
            // Instaciem la classe per enviar formularis multipart i configurem camps
            EnviamentPostMultipart multipart = new EnviamentPostMultipart("http://169.254.142.250/residueix/api/esdeveniments/alta/index.php");
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
            multipart.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
            multipart.afegirCamp("permis", String.valueOf(usuari.getTipus()));
            multipart.afegirCamp("token", usuari.getToken());
            multipart.afegirCamp("nom", nom);
            multipart.afegirCamp("descripcio", descripcio);
            multipart.afegirCamp("valor", valor);
            multipart.afegirCamp("aforament", aforament);
            multipart.afegirCamp("data", data);
            multipart.afegirCamp("hora", hora);
            multipart.afegirCamp("poblacio", poblacio);
            multipart.afegirArxiu("imatge", imatge);
            multipart.afegirCamp("actiu", actiu);
            List<String> response = multipart.finish();
            System.out.println("---"+response.toString()+"---");           
            return new JSONObject(response.get(0));
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_altaEsdeveniment\",\"error\":\"Error en execució al enviar el formulari.\"}");
        }      
    }
    
    /**
     * Mètode per consultar un esdeveniment
     * @param idEsdeveniment (int) id de l'esdeveniment
     * @return JSONObject amb la resposta
     */
    public static JSONObject consultaEsdeveniment(int idEsdeveniment){
        try{
           // Instanciem la classe per enviar formularis x-www-form-urlencoded i configurem els camps
           EnviamentPostUrlEncoded urlencoded = new EnviamentPostUrlEncoded("http://169.254.142.250/residueix/api/esdeveniments/consulta/index.php");
           urlencoded.afegirCamp("token", Api.token);
           urlencoded.afegirCamp("id", String.valueOf(idEsdeveniment));
           return urlencoded.resposta();
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_consultaEsdeveniment\",\"error\":\"Error en execució al enviar la petició.\"}");    
        }   
    }
    
       public static JSONObject modificarEsdeveniment(Usuari usuari,int idEsdeveniment, String nom, String descripcio, String data, String hora, String poblacio, String valor, String aforament, File imatge, String actiu){
        try{
            // Instaciem la classe per enviar formularis multipart i configurem camps
            EnviamentPostMultipart multipart = new EnviamentPostMultipart("http://169.254.142.250/residueix/api/esdeveniments/modificacio/index.php");
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
            multipart.afegirCamp("id_usuari", String.valueOf(usuari.getId()));
            multipart.afegirCamp("permis", String.valueOf(usuari.getTipus()));
            multipart.afegirCamp("token", usuari.getToken());
            multipart.afegirCamp("id", String.valueOf(idEsdeveniment));
            multipart.afegirCamp("nom", nom);
            multipart.afegirCamp("descripcio", descripcio);
            multipart.afegirCamp("valor", valor);
            multipart.afegirCamp("aforament", aforament);
            multipart.afegirCamp("data", data);
            multipart.afegirCamp("hora", hora);
            multipart.afegirCamp("poblacio", poblacio);
            multipart.afegirArxiu("imatge", imatge);
            multipart.afegirCamp("actiu", actiu);
            List<String> response = multipart.finish(); 
            return new JSONObject(response.get(0));
        } catch (IOException ex){
            return new JSONObject("{\"codi_error\":\"excepcio_api_altaEsdeveniment\",\"error\":\"Error en execució al enviar el formulari.\"}");
        }      
    }
    
    
}