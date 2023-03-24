package residueix.residueixapp.utils;

// Imports
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.models.Usuari;

/**
 * Classe d'utilitats per conectar amb l'API del servidor.
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */
public class Api {
    
    /**
    * Constructor - Crea una nova instància de la classe Residueixapp
    */
    public Api(){}
    
    /**
     * Mètode per obenir un missatge d'error
     * @param codi (int) : codi númeric de l'error

     * @return missatge (String) : Missatge amb l'error.
     */
    public String error(int codi){
        switch(codi){
            case 1 -> { return "Error: app_1 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema."; }
            case 2 -> { return "Error: app_2 - No té permís per accedir a l'aplicació."; }
            case 3 -> { return "Error: app_3 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema. El llistat d'usuaris està buit."; }
            case 4 -> { return "Error: app_4 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema. L'usuari no s'ha creat.";}
            case 5 -> { return "Error: app_5 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema. L'usuari no es pot consultar.";}
            case 6 -> { return "Error: app_6 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema. L'usuari no s'ha eliminat.";}
            case 7 -> { return "Error: app_7 - Hi ha hagut un error al fer la petició. Posi's en contacte amb l'administrador del sistema. El tipus d'usuari no correspon amb cap tipus controlat.";}
            case 8 -> { return "Has de seleccionar una fila de la taula d'usuaris."; }
            case 9 -> { return "No s'ha pogut validar el email i no s'ha enviat cap correu."; }
            case 10 -> { return "No s'ha pogut enviar e correu. Posi's en contacte amb Residueix."; }
            case 11 -> { return "Correu enviat! comprovi-ho i canvii la paraula clau el més aviat possible."; }
            case 12 -> { return "S'ha modificat el perfil"; }
            case 13 -> { return "Format d'email incorrecte."; }
            default -> { return ""; }
        }
    }
  
    /**
     * Mètode per validar el format de un email
     * @param email (String) : email a validar
     * @return true / false (boolean)s
     */
    public boolean validarEmail(String email){
        // Patró
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }
    
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
            
            // Paràmetres
            params.put("usuari", email);
            params.put("password", password);
            
            // Cridem l'api per recuperar el json
            String json = this.cridaApi(url,params);
                      
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
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
            
            // Paràmetres
            params.put("id", usuari.getId());
            params.put("token", usuari.getToken());
            
            // Cridem l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            JSONObject jsonObject = new JSONObject(json);
            
        } catch (IOException e){
            System.out.println("Error excepció:" + e.getMessage());
        }
        
    }
    
    /**
     * Mètode per fer la crida a l'api
     * @param url (URL) : Url de l'api.
     * @param params (Map) : Mapeig clau-valor dels paràmetres a passar a l'api.
     * @return json (String) : json amb el resultat de l'api.
     * @throws UnsupportedEncodingException Si hi ha una excepció de codificació errònea.
     * @throws IOException Si hi ha una excepció d'entrada o sortida
     */
    public String cridaApi(URL url, Map<String,Object> params) throws UnsupportedEncodingException, IOException{
        try{
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
            
            return json;
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return "";
        }
    }
    
    /**
     * Mètode per comprovar si existeix un correu/usuari
     * @param correu (String) : correu a cercar
     * @return JSONObject: json amb la resposta.
     */
    public JSONObject existeixCorreu(String correu){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/existeix/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres 
            params.put("email", correu);
             
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
        }
        
    }
    
    /**
     * Mètode per recuperar el llistat d'usaris
     * @param usuari (Usuari): usuari que fa la petició.
     * @param comboTipus (int) : seleccio del combo tipus
     * @param comboActiu (int) : seleccio del combo actiu
     * @return JSONArray json amb el llistat d'usuaris.
     */
    public JSONObject llistatUsuaris(Usuari usuari,int comboTipus, int comboActiu){
        
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
            
            
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/llistat/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            params.put("tipus", filtreTipus);
            params.put("actiu", filtreActiu);
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url,params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
        }
        
    }
    
    /**
     * Mètode per recuperar el llistat de tipus d'usaris
     * @param usuari : usuari que fa la petició.
     * @return JSONArray: json amb el llistat d'usuaris.
     */
    public JSONObject llistatTipusUsuari(Usuari usuari){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/tipus/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres 
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
             
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
        }
        
    }
    
    /**
     * Mètode per recuperar el llistat de tipus d'adherit
     * @param usuari : usuari que fa la petició.
     * @return JSONArray: json amb el llistat de tipus d'adherits
     */
    public JSONObject llistatTipusAdherit(Usuari usuari){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/global/tipusadherit/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
        }
        
    }
    
    /**
     * Mètode per recuperar el llistat de poblacions
     * @param usuari : usuari que fa la petició.
     * @return JSONArray: json amb el llistat d'usuaris.
     */
    public JSONObject llistatPoblacions(Usuari usuari){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/global/poblacions/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            //Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
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
    public JSONObject crearUsuariAdministrador(Usuari usuari, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/alta/administrador/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            params.put("email",email);
            params.put("password",password);
            params.put("tipus",tipus);
            params.put("nom",nom);
            params.put("cognom1",cognom1);
            params.put("cognom2",cognom2);
            params.put("telefon",telefon);
            params.put("actiu",actiu);
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
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
    public JSONObject crearUsuariTreballador(Usuari usuari, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/alta/treballador/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            params.put("email",email);
            params.put("password",password);
            params.put("tipus",tipus);
            params.put("nom",nom);
            params.put("cognom1",cognom1);
            params.put("cognom2",cognom2);
            params.put("telefon",telefon);
            params.put("actiu",actiu);
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
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
    public JSONObject crearUsuariResiduent(Usuari usuari, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu, String carrer, String cp, String poblacio){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/alta/residuent/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            params.put("email",email);
            params.put("password",password);
            params.put("tipus",tipus);
            params.put("nom",nom);
            params.put("cognom1",cognom1);
            params.put("cognom2",cognom2);
            params.put("telefon",telefon);
            params.put("actiu",actiu);
            params.put("carrer",carrer);
            params.put("cp",cp);
            params.put("poblacio",poblacio);
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
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
    public JSONObject crearUsuariAdherit(Usuari usuari, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu, String carrer, String cp, String poblacio, String nomAdherit, String horaris, String tipusAdherit){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/alta/adherit/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            params.put("email",email);
            params.put("password",password);
            params.put("tipus",tipus);
            params.put("nom",nom);
            params.put("cognom1",cognom1);
            params.put("cognom2",cognom2);
            params.put("telefon",telefon);
            params.put("actiu",actiu);
            params.put("carrer",carrer);
            params.put("cp",cp);
            params.put("poblacio",poblacio);
            params.put("nom_adherit",nomAdherit);
            params.put("horari",horaris);
            params.put("tipus_adherit",tipusAdherit);
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
        }
        
    }
    
    /**
     * Mètode per consultar un usuari
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param id (int) : id l'usuari
     * @return JSONObject: json amb el llistat d'usuaris.
     */
    public JSONObject consultaUsuari(Usuari usuari,int id){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/consulta/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            params.put("id",id);
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
        }
    }
        
     /**
     * Mètode per donar de baixa un usuari.
     * @param usuari (Usuari) : usuari que fa la petició.
     * @param id (int) : id l'usuari
     * @return JSONArray: json amb el llistat d'usuaris.
     */
    public JSONObject eliminarUsuari(Usuari usuari,int id){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/baixa/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            params.put("id",id);
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                System.out.print(json);
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
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
    public JSONObject modificarUsuariAdministrador(Usuari usuari, String id, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/modificacio/administrador/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            params.put("email",email);
            params.put("password",password);
            params.put("tipus",tipus);
            params.put("nom",nom);
            params.put("cognom1",cognom1);
            params.put("cognom2",cognom2);
            params.put("telefon",telefon);
            params.put("actiu",actiu);
            params.put("id",id);
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
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
    public JSONObject modificarUsuariTreballador(Usuari usuari, String id, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/modificacio/treballador/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            params.put("email",email);
            params.put("password",password);
            params.put("tipus",tipus);
            params.put("nom",nom);
            params.put("cognom1",cognom1);
            params.put("cognom2",cognom2);
            params.put("telefon",telefon);
            params.put("actiu",actiu);
            params.put("id",id);
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
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
    public JSONObject modificarUsuariResiduent(Usuari usuari, String id, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu, String carrer, String cp, String poblacio){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/modificacio/residuent/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            params.put("email",email);
            params.put("password",password);
            params.put("tipus",tipus);
            params.put("nom",nom);
            params.put("cognom1",cognom1);
            params.put("cognom2",cognom2);
            params.put("telefon",telefon);
            params.put("actiu",actiu);
            params.put("id",id);
            params.put("carrer",carrer);
            params.put("cp",cp);
            params.put("poblacio",poblacio);
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
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
    public JSONObject modificarUsuariAdherit(Usuari usuari, String id, String email, String password, String tipus, String nom, String cognom1, String cognom2, String telefon, String actiu, String carrer, String cp, String poblacio, String tipusAdherit, String nomAdherit, String horari){
        
        try{
            
            URL url = new URL("http://169.254.142.250/residueix/api/usuaris/modificacio/adherit/index.php");
            Map<String,Object> params = new LinkedHashMap<>();
            
            // Paràmetres
            params.put("id_usuari", String.valueOf(usuari.getId()));
            params.put("token", usuari.getToken());
            params.put("permis", String.valueOf(usuari.getTipus()));
            params.put("email",email);
            params.put("password",password);
            params.put("tipus",tipus);
            params.put("nom",nom);
            params.put("cognom1",cognom1);
            params.put("cognom2",cognom2);
            params.put("telefon",telefon);
            params.put("actiu",actiu);
            params.put("id",id);
            params.put("carrer",carrer);
            params.put("cp",cp);
            params.put("poblacio",poblacio);
            params.put("tipus_adherit",tipusAdherit);
            params.put("nom_adherit",nomAdherit);
            params.put("horari",horari);
            
            // Cridem a l'api per recuperar el json
            String json = this.cridaApi(url, params);
            
            // Llegim el Json.
            if(!json.equals("")){
                JSONObject jsonO = new JSONObject(json);
                return jsonO;
            }else{
                return new JSONObject();
            }
            
        } catch (IOException e){
            System.out.println("Error excepció: " + e.getMessage());
            return new JSONObject();
        }
        
    }
       
    
}