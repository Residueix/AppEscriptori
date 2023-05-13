package esdeveniments;

// Imports
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.json.JSONObject;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.esdeveniments.PantallaModificarEsdeveniment;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestModificarEsdeveniment per proves en la pantalla de modificacio esdeveniments
 * @author Daniel Garcia Ruiz
 * @version 13/05/2023
 */
public class TestModificarEsdeveniment {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaModificarEsdeveniment pme;
    
    /**
     * Instància d'usuari
     */
    static Usuari usuari;
    /**
     * File per les proves d'alta d'imatges
     */
    static File imatge;
    /**
     * Id del tipus creat.
     */
    String id = null;
    
    /**
     * Métode Beforeclass per inicialitzar les classes necessàries per les proves
     * @throws java.lang.InterruptedException
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException, Exception{
        JSONObject jsonUser = Api.login("danisvh@gmail.com", xifratParaulaClau.encrypt("danisvh1"));
        TestModificarEsdeveniment.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
    }
    
    /**
     * Mètode before per executar abans de cada test
     * @throws IOException 
     */
    @Before
    public void before() throws IOException{
       JSONObject jsonObject = Api.altaEsdeveniment(usuari,"Nom prova esdeveniment","Descripció prova esdeveniment","2023-12-01","10:02", "105", "0.5000", "100",carregarImatge(),"1");
       id = jsonObject.getString("id");
    }
    
    /**
     * Mètode after per executar desrpés de cada test
     * @throws IOException 
     */
    @After
    public void after() throws IOException{
        if(id!=null){
            JSONObject jsonObject = (JSONObject) Api.eliminarRegistre("esdeveniment",id);
            id = null;
        }
    }
    
    /**
     * Mètode per carregar imatge per fer les crides a l'api
     * @return File
     * @throws IOException 
     */
    public File carregarImatge() throws IOException{
        ImageIcon img = new javax.swing.ImageIcon(getClass().getResource("/images/test.png"));   
        Image imagen = img.getImage();
        File arxiu = File.createTempFile("imagen", ".png");
        try (OutputStream out = new FileOutputStream(arxiu)) {
            BufferedImage bi = new BufferedImage(imagen.getWidth(null), imagen.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics g = bi.createGraphics();
            g.drawImage(imagen, 0, 0, null);
            g.dispose();
            ImageIO.write(bi, "png", out);
            return arxiu;
        } catch (IOException e) {
            return null;
        }
    }
    
    /**
     * Mètode llistatPoblacions per carregar les poblacions al combobox
     * @throws IOException
     */
    @Test
    public void llistatPoblacions() throws IOException{
        JSONObject jsonObject = (JSONObject) Api.llistatPoblacions();
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per consultar un esdevenimentcorrecte.
     * @throws IOException 
     */
    @Test
    public void consultaEsdevenimentCorrecte() throws IOException{
        JSONObject jsonObject = Api.consultaEsdeveniment(Integer.parseInt(id));
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode per consultar un esdeveniment però incorrecte.
     * @throws IOException 
     */
    @Test
    public void consultaEsdevenimentIncorrecte() throws IOException{
        JSONObject jsonObject = Api.consultaEsdeveniment(2000);
        String esp = "esdeveniments_6";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    
    /**
     * Mètode modificarEsdevenimentCorrecte quan modifiquem un esdeveniment correcte
     * @throws IOException
     */
    @Test
    public void modificarEsdevenimentCorrecte() throws IOException{
        JSONObject jsonObject = Api.modificarEsdeveniment(usuari, Integer.parseInt(id), "Nom prova jUnit", "Descripció prova jUnit", "2023-10-20", "10:00", "200", "0.5000", "100",imatge, "1");
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode modificarEsdevenimentCorrecteSenseImatge quan modifiquem un esdeveniment correcte sense imatge
     * @throws IOException
     */
    @Test
    public void modificarEsdevenimentCorrecteSenseImatge() throws IOException{
        JSONObject jsonObject = Api.modificarEsdeveniment(usuari, Integer.parseInt(id), "Nom prova jUnit", "Descripció prova jUnit", "2023-10-20", "10:00", "200", "0.5000", "100",null, "1");
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
     /**
     * Mètode modificarEsdevenimentIncorrecteSenseParametres quan modifiquem un esdeveniment sense parametres
     * @throws IOException
     */
    @Test
    public void modificarEsdevenimentIncorrecteSenseParametres() throws IOException{
        JSONObject jsonObject = Api.modificarEsdeveniment(usuari, Integer.parseInt(id), "", "Descripció prova jUnit", "2023-10-20", "10:00", "200", "0.5000", "100",null, "1");
        String esp = "esdeveniments_15";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }  
    
}