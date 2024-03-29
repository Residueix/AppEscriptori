package usuaris;

// Imports
import java.io.IOException;
import java.util.Random;
import org.json.JSONObject;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.Utils;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestAltaUsuari per proves en la pantalla Alta usuari.
 * @author Daniel Garcia Ruiz
 * @version 16/05/2023
 */
public class TestAltaUsuari {
    
    /**
     * Instància d'usuari
     */
    static Usuari usuari;
    /**
     * Id del tipus creat.
     */
    String id = null;
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     * @throws Exception
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException, Exception{
        JSONObject jsonUser = Api.login("danisvh@gmail.com", xifratParaulaClau.encrypt("danisvh1"));
        TestAltaUsuari.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000); 
    }

    /**
     * Mètode before per executar desrpés de cada test
     * @throws IOException 
     */
    @After
    public void after() throws IOException{
        if(id!=null){
            JSONObject jsonObject = (JSONObject) Api.eliminarRegistre("usuari",id);
            id = null;
        }
    }    
    
    /**
     * Mètode carrearTipusUsuari per fer la càrrega dels tipus d'usuari al combobox
     */
    @Test
    public void carrearTipusUsuari(){
        JSONObject jsonTipusUsuaris = Api.llistatTipusUsuari(usuari);  
        String esp = "0";
        String res = jsonTipusUsuaris.getString("codi_error");
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
     * Mètode per donar d'alta un administrador
     */
    @Test
    public void altaAdministrador(){
        int randomNumber = new Random().nextInt(1000000000);
        JSONObject jsonRetorn = Api.crearUsuariAdministrador(usuari,randomNumber+"@gmail.com","provajunit","1","prova","prova","prova","999999999","1");
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        id = jsonRetorn.getString("id");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per donar d'alta un treballador
     */  
    @Test
    public void altaTreballador(){
        int randomNumber = new Random().nextInt(1000000000);
        JSONObject jsonRetorn = Api.crearUsuariTreballador(usuari,randomNumber+"@gmail.com","provajunit","2","prova","prova","prova","999999999","1");
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        id = jsonRetorn.getString("id");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per donar d'alta un residuent
     */
    @Test
    public void altaResiduent(){
        int randomNumber = new Random().nextInt(1000000000);
        JSONObject jsonRetorn = Api.crearUsuariResiduent(usuari,randomNumber+"@gmail.com","provajunit","3","prova","prova","prova","999999999","1","carrer","08000","28");
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        id = jsonRetorn.getString("id");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per donar d'alta un adherit
     */
    @Test
    public void altaAdherit(){
        int randomNumber = new Random().nextInt(1000000000);
        JSONObject jsonRetorn = Api.crearUsuariAdherit(usuari,randomNumber+"@gmail.com","provajunit","4","prova","prova","prova","999999999","1","carrer","08000","28","nom empresa","horaris","8");
        System.out.println(jsonRetorn.toString());
        String esp = "0";
        String res = jsonRetorn.getString("codi_error");
        id = jsonRetorn.getString("id");
        assertEquals(esp,res);
    }
       
}