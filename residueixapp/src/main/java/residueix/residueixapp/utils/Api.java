package residueix.residueixapp.utils;

// Imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.models.Usuari;

/**
 * Classe d'utilitats per conectar amb l'API del servidor.
 * @author Daniel Garcia Ruiz
 * @version 19/03/2023
 */
public class Api {
    
    /**
     * Mètode per fer el login de l'usari.
     * @param email : email/nom usari
     * @param password :  paraula clau.
     * @return JSONObject: json amb les dades del login o l'error, o buit si hi ha excepció.
     */
    public JSONObject login(String email, String password){
        
        try{
            URL url = new URL("http://169.254.142.250/residueix/api/login/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            params.put("usuari", email);
            params.put("password", password);
            
            StringBuilder postData = new StringBuilder();
            for(Map.Entry<String,Object> param : params.entrySet()){
               if(postData.length() != 0){
                   postData.append('&');
               } 
               postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
               postData.append('=');
               postData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
            }
            byte[] postBytes = postData.toString().getBytes("UTF-8");
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length",String.valueOf(postBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytes);
            
            // Construim el JSON.
            String json = "";
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            for(int c = in.read(); c != -1; c = in.read()){ json += (char) c; }
            
            /*StringBuilder infoString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                infoString.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println(infoString);
            */
            
            // Llegim el Json.
            JSONObject jsonObject = new JSONObject(json);
            return jsonObject;
            
        } catch (IOException e){
            System.out.println("Error excepció:" + e.getMessage());
            return new JSONObject();
        }
        
    }
    
    /**
     * Mètode per fer fer el logout de l'usuari
     * @param usuari : usuari que fa la petició.
     */
    public void logout(Usuari usuari){
        try{
            URL url = new URL("http://169.254.142.250/residueix/api/logout/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            params.put("id", usuari.getId());
            params.put("token", usuari.getToken());
            
            StringBuilder postData = new StringBuilder();
            for(Map.Entry<String,Object> param : params.entrySet()){
               if(postData.length() != 0){
                   postData.append('&');
               } 
               postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
               postData.append('=');
               postData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
            }
            byte[] postBytes = postData.toString().getBytes("UTF-8");
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length",String.valueOf(postBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytes);
            
            // Construim el JSON.
            String json = "";
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            for(int c = in.read(); c != -1; c = in.read()){ json += (char) c; }
            
            /*StringBuilder infoString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                infoString.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println(infoString);
            */
            
            // Llegim el Json.
            JSONObject jsonObject = new JSONObject(json);
            
        } catch (IOException e){
            System.out.println("Error excepció:" + e.getMessage());
        }
        
    }
    
    /**
     * Mètode per recuperar el llistat d'usaris
     * @param usuari : usuari que fa la petició.
     * @return JSONObject: json amb el llistat d'usuaris.
     */
    public JSONArray llistatUsuaris(Usuari usuari,int opcio){
        
        try{
            String filtre = "";
            String parametre_filtre ="";
            switch(opcio){
                case 1 -> {
                    filtre = "tipus";
                    parametre_filtre = "1";
                }
                 case 2 -> {
                    filtre = "tipus";
                    parametre_filtre = "2";
                }
                  case 3 -> {
                    filtre = "tipus";
                    parametre_filtre = "3";
                }
                   case 4 -> {
                    filtre = "tipus";
                    parametre_filtre = "4";
                }
                   default ->{
                   }
            }
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/llistat/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            
            if(filtre != ""){ params.put("filtre", filtre); }
            if(parametre_filtre != ""){ params.put("parametre_filtre", parametre_filtre); }
             
            StringBuilder postData = new StringBuilder();
            for(Map.Entry<String,Object> param : params.entrySet()){
               if(postData.length() != 0){
                   postData.append('&');
               } 
               postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
               postData.append('=');
               postData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
            }
            byte[] postBytes = postData.toString().getBytes("UTF-8");
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length",String.valueOf(postBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBytes);
            
            // Construim el JSON.
            String json = "";
            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            for(int c = in.read(); c != -1; c = in.read()){ json += (char) c; }
            
            /*StringBuilder infoString = new StringBuilder();
            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                infoString.append(scanner.nextLine());
            }
            scanner.close();
            System.out.println(infoString);
            */
            
            // Llegim el Json.
            if(json != ""){
                JSONArray jsonArray = new JSONArray(json);
                return jsonArray;
            }else{
                return new JSONArray();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONArray();
        }
        
    }
}