import java.util.Random;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.PantallaAltaUsuari;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;

/**
 * Classe TestPerfil per proves en la pantalla perfil.
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */
public class TestAltaUsuari {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaAltaUsuari pau;
    
    /**
     * Instància d'usuari
     */
    static Usuari usuari;
    
    /**
     * Instància d'Api
     */
    static Api api;
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException{
        TestAltaUsuari.api = new Api();
        JSONObject jsonUser = api.login("danisvh@gmail.com", "danisvh1");
        TestAltaUsuari.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
        pau = new PantallaAltaUsuari(usuari);   
    }
    
    
    /**
     * Mètode carrearTipusUsuari per fer la càrrega dels tipus d'usuari al combobox
     */
    @Test
    public void carrearTipusUsuari(){
        JSONObject jsonTipusUsuaris = api.llistatTipusUsuari(usuari);  
        String esp = "0";
        String res = jsonTipusUsuaris.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode carregarPoblacions per fer la càrrega de les poblacions al combobox
     */
    @Test
    public void carregarPoblacions(){
        JSONObject jsonPoblacions = api.llistatPoblacions(usuari);  
        String esp = "0";
        String res = jsonPoblacions.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode carregarTipusAdherits per fer la càrrega dels tipus d'adherits  al combobox
     */
    @Test
    public void carregarTipusAdherits(){
        JSONObject jsonTipusAdherits = api.llistatTipusAdherit(usuari); 
        String esp = "0";
        String res = jsonTipusAdherits.getString("codi_error");
        assertEquals(esp,res);
    }
    
     /**
     * Mètode formatEmailCorrecte utilitzat per validar que el format de l'email és el correcte.
     */
    @Test
    public void formatEmailCorrecte() {
        boolean res = api.validarEmail("danisvh@gmail.com");
        boolean esp = true;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode formatEmailIncorrecte utilitzat per validar que el format de l'email és incorrecte i tractar els errors.
     */
    @Test
    public void formatEmailIncorrecte() {
        boolean res = api.validarEmail("malament");
        boolean esp = false;
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per donar d'alta un administrador
     */
    @Test
    public void altaAdministrador(){
        int randomNumber = new Random().nextInt(1000000000);
        JSONObject jsonRetorn = api.crearUsuariAdministrador(usuari,randomNumber+"@gmail.com","provajunit","1","prova","prova","prova","999999999","1");
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per donar d'alta un treballador
     */  
    @Test
    public void altaTreballador(){
        int randomNumber = new Random().nextInt(1000000000);
        JSONObject jsonRetorn = api.crearUsuariTreballador(usuari,randomNumber+"@gmail.com","provajunit","2","prova","prova","prova","999999999","1");
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per donar d'alta un residuent
     */
    @Test
    public void altaResiduent(){
        int randomNumber = new Random().nextInt(1000000000);
        JSONObject jsonRetorn = api.crearUsuariResiduent(usuari,randomNumber+"@gmail.com","provajunit","3","prova","prova","prova","999999999","1","carrer","08000","28");
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per donar d'alta un adherit
     */
    @Test
    public void altaAdherit(){
        int randomNumber = new Random().nextInt(1000000000);
        JSONObject jsonRetorn = api.crearUsuariAdherit(usuari,randomNumber+"@gmail.com","provajunit","4","prova","prova","prova","999999999","1","carrer","08000","28","nom empresa","horaris","8");
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        assertEquals(esp,res);
    }
       
}