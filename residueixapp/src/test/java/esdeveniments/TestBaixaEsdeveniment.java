package esdeveniments;

// Imports
import static esdeveniments.TestModificarEsdeveniment.usuari;
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
import residueix.residueixapp.esdeveniments.PantallaBaixaEsdeveniment;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestBaixaEsdeveniment per proves en la pantalla de baixa d'esdeveniments
 * @author Daniel Garcia Ruiz
 * @version 13/05/2023
 */
public class TestBaixaEsdeveniment {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaBaixaEsdeveniment pbe;
    
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
     * @throws IOException
     * @throws Exception
     */
    @BeforeClass
    public static void beforeClass() throws InterruptedException, IOException, Exception{
        JSONObject jsonUser = Api.login("danisvh@gmail.com", xifratParaulaClau.encrypt("danisvh1"));
        TestBaixaEsdeveniment.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
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
     * Mètode baixaEsdevenimentCorrecte quan donem de baixa un tipus residu correcte
     */
    @Test
    public void baixaEsdevenimentCorrecte() throws IOException{
        pbe = new PantallaBaixaEsdeveniment(usuari,Integer.parseInt(id));
        JSONObject jsonObject = (JSONObject) Api.baixaEsdeveniment(usuari, Integer.parseInt(id));
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        System.out.println(jsonObject.getString("codi_error"));
        assertEquals(esp,res);
    }
    
    /**
     * Mètode baixaEsdevenimentIncorrecte quan donem de baixa un punt de recollida incorrecte
     */
    @Test
    public void baixaEsdevenimentIncorrecte() throws IOException{
        pbe = new PantallaBaixaEsdeveniment(usuari,Integer.parseInt(id));
        JSONObject jsonObject = (JSONObject) Api.baixaEsdeveniment(usuari, -1);
        String esp = "esdeveniments_7";
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
    
  
}