package acces;

// Imports
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.principal.PantallaPerfil;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestPerfil per proves en la pantalla perfil.
 * @author Daniel Garcia Ruiz
 * @version 19/04/2023
 */
public class TestPerfil {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaPerfil pp;
    
    /**
     * Instància d'usuari
     */
    static Usuari usuari;
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException{
        JSONObject jsonUser = Api.login("danisvh@gmail.com", "danisvh1");
        TestPerfil.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
        pp = new PantallaPerfil(usuari,usuari.getId());   
    }
    
    
    /**
     * Mètode inicialitzacioPrincipial utilitzat per entrar en la pantalla Principal.
     */
    @Test
    public void inicialitzacioPrincipal() {
        int esp = 2;
        int res = usuari.getId();
        assertEquals(esp,res);
    }
    
    /**
     * Mètode carregarPoblacions per fer la càrrega de les poblacions al combobox
     */
    @Test
    public void carregarPoblacions(){
        JSONObject jsonPoblacions = Api.llistatPoblacions();  
        String esp = "0";
        String res = jsonPoblacions.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode carregarTipusAdherits per fer la càrrega dels tipus d'adherits  al combobox
     */
    @Test
    public void carregarTipusAdherits(){
        JSONObject jsonTipusAdherits = Api.llistatTipusAdherit(usuari); 
        String esp = "0";
        String res = jsonTipusAdherits.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode consultaUsuari per fer la càrrega de les dades del usuari del perfil
     */
    @Test
    public void consultaUsuari(){
        JSONObject jsonUsuari = Api.consultaUsuari(usuari,usuari.getId());
        String esp = "0";
        String res = jsonUsuari.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per modificarUsuariAdministrador per canviar les dades d'usuaris administradors
     */
    @Test
    public void modificarUsuariAdministrador(){
        JSONObject jsonRetorn = Api.modificarUsuariAdministrador(usuari,String.valueOf(usuari.getId()),usuari.getEmail(),usuari.getPassword(),String.valueOf(usuari.getTipus()),usuari.getNom(),usuari.getCognom1(),usuari.getCognom2(),usuari.getTelefon(),"1");
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per modificarUsuariAdministradorNoExisteix per canviar les dades d'usuaris administradors pero comprovem que no existeixi
     */
    @Test
    public void modificarUsuariAdministradorNoExisteix(){
        JSONObject jsonRetorn = Api.modificarUsuariAdministrador(usuari,"9999",usuari.getEmail(),usuari.getPassword(),String.valueOf(usuari.getTipus()),usuari.getNom(),usuari.getCognom1(),usuari.getCognom2(),usuari.getTelefon(),"1");
        String esp = "usuaris_15";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per modificarUsuariTreballador per canviar les dades d'usuaris treballadors
     */
    @Test
    public void modificarUsuariTreballador(){
        JSONObject jsonRetorn = Api.modificarUsuariTreballador(usuari,"5","treballador1@gmail.com","treballador1","2","treballador","treballador","treballador","666666666","1");
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per modificarUsuariTreballadorNoExisteix per canviar les dades d'usuaris treballadors pero comprovem que no existeixi
     */
    @Test
    public void modificarUsuariTreballadorNoExisteix(){
        JSONObject jsonRetorn = Api.modificarUsuariTreballador(usuari,"999999","treballador1@gmail.com","treballador1","2","treballador","treballador","treballador","666666666","1");
        String esp = "usuaris_19";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per modificarUsuariResiduent per canviar les dades d'usuaris residuent
     */
    @Test
    public void modificarUsuariResiduent(){
        JSONObject jsonRetorn = Api.modificarUsuariResiduent(usuari,"24","residuent1@gmail.com","residuent1","3","residuent","residuent","residuent","666666666","1","carrer","08000","21");
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per modificarUsuariResiduentNoExisteix per canviar les dades d'usuaris residuent pero comprovem que no existeixi
     */
    @Test
    public void modificarUsuariResiduentNoExisteix(){
        JSONObject jsonRetorn = Api.modificarUsuariResiduent(usuari,"999","residuent1@gmail.com","residuent","3","residuent","residuent","treballador","666666666","1","carrer","08000","21");
        String esp = "usuaris_16";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
    
        /**
     * Mètode per modificarUsuariAdherit per canviar les dades d'usuaris adherits
     */
    @Test
    public void modificarUsuariAdherit(){
        JSONObject jsonRetorn = Api.modificarUsuariAdherit(usuari,"15","adherit1@gmail.com","adherit1","4","adherit","adherit","adherit","666666666","1","carrer","08000","21","5","nom adherit","horari adherit");
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per modificarUsuariAdheritNoExisteix per canviar les dades d'usuaris adherits pero comprovem que no existeixi
     */
    @Test
    public void modificarUsuariAdheritNoExisteix(){
        JSONObject jsonRetorn = Api.modificarUsuariAdherit(usuari,"999","adherit1@gmail.com","adherit","4","adherit","adherit","adherit","666666666","1","carrer","08000","21","5","nom adherit","horari adherit");
        String esp = "usuaris_22";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
    
    
       
}