package residueix.residueixapp.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que proporciona una capa d'abstracció per enviar http post amb multipart
 * @author Daniel Garcia Ruiz
 * @version 26/03/2023
 */
public class EnviamentPostMultipart {
    
    private final String boundary;
    private static final String SALT_LINIA = "\r\n";
    private HttpURLConnection httpConn;
    private OutputStream outputStream;
    private PrintWriter writer;
 
    /**
     * Constructor per inicialitzar un nou HTTP POST amb el multipart/form-data
     * @param url (String) : url de l'api
     * @throws IOException
     */
    public EnviamentPostMultipart(String url) throws IOException {
        
        // Creem un boundary amb el temps actual.
        boundary = "===" + System.currentTimeMillis() + "===";
         
        // Creem la HttpURLcONNECTION
        URL urlCreated = new URL(url);
        httpConn = (HttpURLConnection) urlCreated.openConnection();
        httpConn.setUseCaches(false);
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        httpConn.setRequestProperty("Content-Type","multipart/form-data; boundary=" + boundary);
        httpConn.setRequestProperty("User-Agent", "CodeJava Agent");
        httpConn.setRequestProperty("Test", "Bonjour");
        outputStream = httpConn.getOutputStream();
        writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"),true);
        
    }
 
    /**
     * Mètode per afegir nous camps a enviar
     * @param nom (String) Nom del camp
     * @param valor (String) valor del camp
     */
    public void afegirCamp(String nom, String valor) {
        writer.append("--" + boundary).append(SALT_LINIA);
        writer.append("Content-Disposition: form-data; name=\"" + nom + "\"").append(SALT_LINIA);
        writer.append("Content-Type: text/plain; charset=" + "UTF-8").append(SALT_LINIA);
        writer.append(SALT_LINIA);
        writer.append(valor).append(SALT_LINIA);
        writer.flush();
    }
 
    /**
     * Mètode per afegeix l'arxiu seleccionat a l'enviament
     * @param nom (String)
     * @param arxiu (File)
     * @throws IOException
     */
    public void afegirArxiu(String nom, File arxiu)
            throws IOException {
        String fileName = arxiu.getName();
        writer.append("--" + boundary).append(SALT_LINIA);
        writer.append("Content-Disposition: form-data; name=\"" + nom + "\"; filename=\"" + nom + "\"").append(SALT_LINIA);
        writer.append( "Content-Type: " + URLConnection.guessContentTypeFromName(nom)).append(SALT_LINIA);
        writer.append("Content-Transfer-Encoding: binary").append(SALT_LINIA);
        writer.append(SALT_LINIA);
        writer.flush();
        FileInputStream inputStream = new FileInputStream(arxiu);
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.flush();
        inputStream.close();
        writer.append(SALT_LINIA);
        writer.flush();    
    }
 
    /**
     * Mètode per afegir capçalera a la consulta
     * @param nom (String) nom del camp de capçalera
     * @param valor (String) valor del camp de capçalera
     */
    public void addHeaderField(String nom, String valor) {
        writer.append(nom + ": " + valor).append(SALT_LINIA);
        writer.flush();
    }
     
    /**
     * Mètode que fa la sol·licitud i rep la resposta del servidor.
     * @return List<String> amb la resposta del servidora
     * @throws IOException
     */
    public List<String> finish() throws IOException {
        
        List<String> response = new ArrayList<String>();
        writer.append(SALT_LINIA).flush();
        writer.append("--" + boundary + "--").append(SALT_LINIA);
        writer.close();
 
        // Comprovació del estat del servidor.
        int status = httpConn.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                response.add(line);
            }
            reader.close();
            httpConn.disconnect();
        } else {
            throw new IOException("Server returned non-OK status: " + status);
        }
        return response;
    }
}
