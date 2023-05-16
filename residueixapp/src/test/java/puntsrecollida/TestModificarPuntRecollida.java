package puntsrecollida;

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
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestModificarPuntRecollida per proves en la pantalla de modificació punt de recollida
 * @author Daniel Garcia Ruiz
 * @version 16/05/2023
 */
public class TestModificarPuntRecollida {
    
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
        TestModificarPuntRecollida.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
    }
    
    /**
     * Mètode before per executar abans de cada test
     * @throws IOException 
     */
    @Before
    public void before() throws IOException{
       JSONObject jsonObject = Api.altaPunt(usuari, "jUnit prova", "jUnit prova", "42.0001", "2.891", "jUnit prova", "08080", "18", "jUnit prova",carregarImatge(), "1");
        id = jsonObject.getString("id");
    }
    
    /**
     * Mètode before per executar després de cada test
     * @throws IOException 
     */
    @After
    public void after() throws IOException{
        if(id!=null){
            JSONObject jsonObject = (JSONObject) Api.eliminarRegistre("punt",id);
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
     * Mètode consultaPuntRecollida quan consultem les dades d'un punt de recollida específic
     * @throws IOException
     */
    @Test
    public void consultaPuntRecollida() throws IOException{
        JSONObject jsonObject = Api.consultaPunt(Integer.parseInt(id));
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode modificarPuntCorrecte quan modifiquem un punt de recollida correcte
     * @throws IOException
     */
    @Test
    public void modificarPuntCorrecte() throws IOException{
        JSONObject jsonObject = Api.modificacioPunt(usuari, Integer.parseInt(id), "jUnit prova", "jUnit prova", "42.0001", "2.891", "jUnit prova", "08080", "18", "jUnit prova",carregarImatge(), "1");
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode modificarPuntCorrecteSenseImatge quan modifiquem un punt de recollida correcte sense Imatge
     * @throws IOException
     */
    @Test
    public void modificarPuntCorrecteSenseImatge() throws IOException{
        JSONObject jsonObject = Api.modificacioPunt(usuari, Integer.parseInt(id), "jUnit prova", "jUnit prova", "42.0001", "2.891", "jUnit prova", "08080", "18", "jUnit prova",null, "1");
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode modificaPuntIncorrecteSenseParametres quan modifiquem un punt de recollida incorrecte sense algun paràmetre
     * @throws IOException
     */
    @Test
    public void modificaPuntIncorrecteSenseParametres() throws IOException{
        JSONObject jsonObject = Api.modificacioPunt(usuari, Integer.parseInt(id), "", "jUnit prova", "42.0001", "2.891", "jUnit prova", "08080", "18", "jUnit prova",carregarImatge(), "1");
        String esp = "0"; // perquè si no es passa algun paràmetre obligatori, es queda com està.
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
  
}