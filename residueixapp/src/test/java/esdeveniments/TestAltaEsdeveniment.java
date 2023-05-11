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
import org.junit.BeforeClass;
import org.junit.Test;
import residueix.residueixapp.esdeveniments.PantallaAltaEsdeveniment;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.xifratParaulaClau;

/**
 * Classe TestAltaEsdeveniment per proves en la pantalla de alta esdeveniments
 * @author Daniel Garcia Ruiz
 * @version 09/05/2023
 */
public class TestAltaEsdeveniment {
    
    /**
     * Instància de la classe PantallaPrincipal
     */
    static PantallaAltaEsdeveniment pae;
    
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
        System.out.println("JSON USER" + jsonUser.toString());
        TestAltaEsdeveniment.usuari = new Usuari(jsonUser.getInt("id"),jsonUser.getInt("tipus"),jsonUser.getString("tipus_nom"),jsonUser.getString("email"),jsonUser.getString("password"),jsonUser.getString("nom"),jsonUser.getString("cognom1"),jsonUser.getString("cognom2"),jsonUser.getString("telefon"),jsonUser.getString("token")); 
        Thread.sleep(1000);
        pae = new PantallaAltaEsdeveniment(usuari);
    }
    
    /**
     * Mètode before per executar desrpés de cada test
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
     */
    @Test
    public void llistatPoblacions() throws IOException{
        JSONObject jsonObject = (JSONObject) Api.llistatPoblacions();
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
    }
    
    
    /**
     * Mètode altaEsdevenimentCorrecte quan donem d'alta un esdeveniment correcte
     */
    @Test
    public void altaEsdevenimentCorrecte() throws IOException{
        JSONObject jsonObject = Api.altaEsdeveniment(usuari,"Nom prova esdeveniment","Descripció prova esdeveniment","2023-12-01","10:02", "105", "0.5000", "100",carregarImatge(),"1");
        String esp = "0";
        String res = jsonObject.getString("codi_error");
        id = jsonObject.getString("id");
        assertEquals(esp,res);
    }
    
    /**
     * Mètode altaEsdevenimentIncorrecte quan donem d'alta un esdeveniment incorrecte
     */
    @Test
    public void altaEsdevenimentIncorrecte() throws IOException{
        
        JSONObject jsonObject = Api.altaEsdeveniment(usuari,"Nom prova esdeveniment","Descripció prova esdeveniment","","", "105", "0.5000", "100",carregarImatge(),"1");
        String esp = "esdeveniments_2";
        String res = jsonObject.getString("codi_error");
        assertEquals(esp,res);
        
    }    
    
}