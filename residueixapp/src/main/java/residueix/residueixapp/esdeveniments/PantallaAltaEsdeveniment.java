package residueix.residueixapp.esdeveniments;

// Imports
import residueix.residueixapp.principal.PantallaAdvertencia;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.Utils;
import residueix.residueixapp.utils.SelectorImatge;

/**
 * Classe per obrir la pantalla per donar d'alta un esdeveniment
 * @author Daniel Garcia Ruiz
 * @version 07/05/2023
 */
public class PantallaAltaEsdeveniment extends javax.swing.JFrame {
    
    
    // Atributs
    /**
     * Uusari loginat.
    */
    private static Usuari usuari;
    /**
     * Posició x del ratolí.
     */
    private int xMouse;
    /**
     * Posició y del ratolí.
     */
    private int yMouse;  
    /**
     * Llistat de tipus d'usuari.
     */
    private ArrayList<String[]> llistatPoblacions = new ArrayList<String[]>();
    /**
     * Imatge del residu.
     */
    private File imatge;
    
    /**
     * Crea una nova instància de la classe PantallaPrincipal.
     * @param usuari: Usuari loginat a l'aplicació.
     */
    public PantallaAltaEsdeveniment(Usuari usuari) {
        // Assignació de l'usuari
        this.usuari = usuari;
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();
        // Càrrega inicial del formulari.
        carregaFormulari();
    }

     /**
     * Mètode critad per el constructor per inicialitzar el formulari.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelContingut = new javax.swing.JPanel();
        panelBar = new javax.swing.JPanel();
        labelUsuari = new javax.swing.JLabel();
        panelTitol = new javax.swing.JPanel();
        labelTitol = new javax.swing.JLabel();
        labelPathImatge = new javax.swing.JLabel();
        labelHoraFormat = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        labelActiu = new javax.swing.JLabel();
        checkBoxActiu = new javax.swing.JCheckBox();
        labelDescripcio = new javax.swing.JLabel();
        buttonSeleccionarImatge = new javax.swing.JButton();
        buttonAlta = new javax.swing.JButton();
        labelImatge = new javax.swing.JLabel();
        scrollPaneDescripcio = new javax.swing.JScrollPane();
        textAreaDescripcio = new javax.swing.JTextArea();
        labelNom = new javax.swing.JLabel();
        textFieldNom = new javax.swing.JTextField();
        labelImatgeSeleccionada = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        textFieldHora = new javax.swing.JTextField();
        textFieldValor = new javax.swing.JTextField();
        comboBoxPoblacions = new javax.swing.JComboBox<>();
        labelAforament = new javax.swing.JLabel();
        textFieldAforament = new javax.swing.JTextField();
        dateChooserData = new com.toedter.calendar.JDateChooser();
        panelOpcions = new javax.swing.JPanel();
        buttonLogOut = new javax.swing.JButton();
        buttonEsdeveniments = new javax.swing.JButton();
        labelPrincipal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(200, 100));
        setName("framePrincipal"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 750));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 2));
        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContingut.setOpaque(false);
        panelContingut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBar.setOpaque(false);

        labelUsuari.setFont(new java.awt.Font("Sansation", 0, 12)); // NOI18N
        labelUsuari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuari.setPreferredSize(new java.awt.Dimension(600, 30));
        panelBar.add(labelUsuari);

        panelContingut.add(panelBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        panelTitol.setOpaque(false);
        panelTitol.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelTitol.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        labelTitol.setText("Alta Esdeveniment");
        labelTitol.setToolTipText("");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));

        labelPathImatge.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelPathImatge.setToolTipText("Imatge del residu");
        panelContingut.add(labelPathImatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 470, 30));

        labelHoraFormat.setFont(new java.awt.Font("Sansation", 0, 12)); // NOI18N
        labelHoraFormat.setText("Format: hh:mm");
        labelHoraFormat.setToolTipText("");
        panelContingut.add(labelHoraFormat, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 100, 30));

        labelHora.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelHora.setText("Hora");
        labelHora.setToolTipText("");
        panelContingut.add(labelHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 100, 30));

        labelData.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelData.setText("Data");
        labelData.setToolTipText("");
        panelContingut.add(labelData, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 30));

        labelActiu.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelActiu.setText("Actiu");
        labelActiu.setToolTipText("");
        panelContingut.add(labelActiu, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 50, 30));

        checkBoxActiu.setBackground(new java.awt.Color(255, 255, 255));
        checkBoxActiu.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        checkBoxActiu.setToolTipText("Actiu");
        checkBoxActiu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContingut.add(checkBoxActiu, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 20, 30));

        labelDescripcio.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelDescripcio.setText("Descripció");
        labelDescripcio.setToolTipText("Descripció del residu");
        panelContingut.add(labelDescripcio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 30));

        buttonSeleccionarImatge.setBackground(new java.awt.Color(51, 102, 255));
        buttonSeleccionarImatge.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonSeleccionarImatge.setForeground(new java.awt.Color(255, 255, 255));
        buttonSeleccionarImatge.setText("Seleccionar...");
        buttonSeleccionarImatge.setToolTipText("Seleccionar imatge");
        buttonSeleccionarImatge.setBorderPainted(false);
        buttonSeleccionarImatge.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSeleccionarImatge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSeleccionarImatgeActionPerformed(evt);
            }
        });
        panelContingut.add(buttonSeleccionarImatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 150, 30));

        buttonAlta.setBackground(new java.awt.Color(51, 204, 0));
        buttonAlta.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonAlta.setForeground(new java.awt.Color(255, 255, 255));
        buttonAlta.setText("Donar d'Alta");
        buttonAlta.setToolTipText("Donar d'Alta Esdeveniment");
        buttonAlta.setBorderPainted(false);
        buttonAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAltaActionPerformed(evt);
            }
        });
        panelContingut.add(buttonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 690, 150, 30));

        labelImatge.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelImatge.setText("Imatge");
        labelImatge.setToolTipText("Imatge del residu");
        panelContingut.add(labelImatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 100, 30));

        scrollPaneDescripcio.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneDescripcio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        textAreaDescripcio.setColumns(20);
        textAreaDescripcio.setRows(5);
        textAreaDescripcio.setToolTipText("Descriptió del residu");
        scrollPaneDescripcio.setViewportView(textAreaDescripcio);

        panelContingut.add(scrollPaneDescripcio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 530, 90));

        labelNom.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelNom.setText("Nom");
        labelNom.setToolTipText("Nom del residu");
        panelContingut.add(labelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 100, 30));

        textFieldNom.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldNom.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldNom.setToolTipText("Email");
        textFieldNom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContingut.add(textFieldNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 530, 30));

        labelImatgeSeleccionada.setToolTipText("Imatge seleccionada");
        panelContingut.add(labelImatgeSeleccionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 200, 120));

        labelValor.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelValor.setText("Valor");
        labelValor.setToolTipText("Carrer del punt de recollida");
        panelContingut.add(labelValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 100, 30));

        textFieldHora.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldHora.setToolTipText("Email");
        textFieldHora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldHoraKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 90, 30));

        textFieldValor.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldValor.setToolTipText("Email");
        textFieldValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldValorKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 190, 30));

        comboBoxPoblacions.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        comboBoxPoblacions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tria població" }));
        comboBoxPoblacions.setToolTipText("Filtrar per tipus d'usuari");
        comboBoxPoblacions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboBoxPoblacions.setPreferredSize(new java.awt.Dimension(200, 30));
        panelContingut.add(comboBoxPoblacions, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 320, -1));

        labelAforament.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelAforament.setText("Aforament");
        labelAforament.setToolTipText("Horari del punt de recollida");
        panelContingut.add(labelAforament, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 90, 30));

        textFieldAforament.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldAforament.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldAforament.setToolTipText("Email");
        textFieldAforament.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldAforament.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldAforamentKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldAforament, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 190, 30));
        panelContingut.add(dateChooserData, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 190, 30));

        panelPrincipal.add(panelContingut, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 798, 746));

        panelOpcions.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcions.setOpaque(false);
        panelOpcions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonLogOut.setBackground(new java.awt.Color(153, 0, 0));
        buttonLogOut.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonLogOut.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogOut.setText("Sortir");
        buttonLogOut.setToolTipText("Sortir de l'aplicació");
        buttonLogOut.setBorderPainted(false);
        buttonLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 150, 30));

        buttonEsdeveniments.setBackground(new java.awt.Color(255, 204, 0));
        buttonEsdeveniments.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonEsdeveniments.setText("Esdeveniments");
        buttonEsdeveniments.setToolTipText("Tornar al llistat d'esdeveniments");
        buttonEsdeveniments.setBorderPainted(false);
        buttonEsdeveniments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonEsdeveniments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEsdevenimentsActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonEsdeveniments, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        panelPrincipal.add(panelOpcions, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 2, 200, 746));

        labelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\fons_general.png")); // NOI18N
        labelPrincipal.setOpaque(true);
        panelPrincipal.add(labelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 996, 746));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Mètode per carregar dades necesàries del formulari
     */
    private void carregaFormulari(){
       
        String problemes = "";
        
        // Json array amb les poblacions per al combobox
        JSONObject jsonPoblacions = Api.llistatPoblacions();
        
        // Control del jsonPoblacions
        if(jsonPoblacions.getString("codi_error").equals("0")){
            JSONArray arrayLlistatPoblacions = jsonPoblacions.getJSONArray("llistat");
            if(!arrayLlistatPoblacions.isEmpty()){
                for(int i = 0; i < arrayLlistatPoblacions.length(); i++){
                    JSONObject jsonTipus = arrayLlistatPoblacions.getJSONObject(i);
                    comboBoxPoblacions.addItem(jsonTipus.get("nom").toString());
                    llistatPoblacions.add(new String[]{jsonTipus.get("id").toString(),jsonTipus.get("nom").toString()});
                }
            }else{
                problemes += "Llistat de poblacions buit. ";
                System.out.println(problemes);
            }
        }else{
            problemes += "Hi ha problemes amb el llistat de poblacions:  " + jsonPoblacions.get("codi_error").toString() + " - " + jsonPoblacions.get("error").toString() ;    
            System.out.println(problemes);
        }
        comboBoxPoblacions.setBackground(new Color(255,255,255,255));
        
    }
    
    /**
     * Mètode per gestionar accions en funció de l'usuari
     */
    private void gestioUsuari(){
        // Posem el nom de l'usuari a la part superior
        labelUsuari.setText( usuari.getNom() + " " + usuari.getCognom1() + " " + usuari.getCognom2() );   
    }
    
    /**
     * Mètode per centrar la pantalla
     */
    private void centrarPantalla(){
        // Centrar pantalla.
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((pantalla.width)-this.getWidth())/2,((pantalla.height)-this.getHeight())/2);
    }
    
    /**
     * Mètode per resetejar el formulari
     */
    private void resetFormulari(){
        comboBoxPoblacions.setSelectedIndex(0);
        checkBoxActiu.setSelected(false);
        textFieldNom.setText("");
        textAreaDescripcio.setText("");
        textFieldHora.setText("");
        dateChooserData.setDate(null);
        textFieldValor.setText("");
        textFieldAforament.setText("");
        labelPathImatge.setText("");
        labelImatgeSeleccionada.setIcon(null);
        imatge.delete();
    }
    
    /**
     * Mètode per capturar la x i y del mouse quan el deixem pulsat sobre el frame principal.
     * @param evt MouseEvent: event de deixar pulsat el botó del ratolí.
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    /**
     * Mètode executat quan movem el mouse amb el formulari pulsat. 
     * @param evt MouseEvent: event quan arroseguem amb el ratolí.
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    /**
     * Mètode utilitzat quan es prem el botó de donar d'alta un esdeveniment
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAltaActionPerformed
         
        // Variables de control
        boolean enviament = true;
        String missatge = "Error: - ";
        String id_poblacio = "0";
        
        // Comprovem les dades del nom
        if(!Utils.validarText(textFieldNom.getText(),3,255)){
            enviament = false;
            missatge += "El nom ha de tenir com a mínim 3 i com a màxim 255 caràcters.";
        }
        
        // Comprovem les dades de la descripció
        if(!Utils.validarText(textAreaDescripcio.getText(),10,1024)){
            enviament = false;
            missatge += "La descripció ha de contemir com a mínim  10 i com a màxim 1024 caràcters.";
        }
        
        // Comprovem el selector de poblacio
        if(Utils.validarSelector(comboBoxPoblacions.getSelectedIndex())){
            String poblacio = comboBoxPoblacions.getSelectedItem().toString();
            for (String[] e : llistatPoblacions) {
                if (e[1].equals(poblacio)) {
                    id_poblacio = e[0];
                    break;
                }
            }
        }else{
            missatge += "No hi ha una població vàlida.";   
        }
        
        // Comprovem la data
        if(dateChooserData.getDate() == null){
            enviament = false;
            missatge += "No hi ha una data vàlida.";   
        }
        
        // Comrpovem la hora
        if(!Utils.validarHora(textFieldHora.getText())){
            enviament = false;
            missatge += "No hi ha una hora vàlida.";
        }
        
        // Comprovem el valor
        if(!Utils.validarDecimal(textFieldValor.getText())){
            enviament = false;
            missatge += "No hi ha un valor vàlid.";
        }
        
        // Comprovem el aforament
        if(!Utils.validarInteger(textFieldAforament.getText())){
            enviament = false;
            missatge += "No hi ha un aforament vàlid.";
        }
        
        // Comprovem la imatge
        if(!Utils.validarText(labelPathImatge.getText(),8,255)){
            if(imatge == null){
                enviament = false;
                missatge += "No hi ha una imatge vàlida seleccionada.";
            }else{
                if(!imatge.isFile()){
                    enviament = false;
                    missatge += "No hi ha una imatge vàlida seleccionada.";
                }
            }
        }
        
        // Si no hi ha problemes enviem, si no mostrem errors
        if(enviament){
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateChooserData.getDate());
            String data = String.valueOf(cal.get(Calendar.YEAR)) + '-' + String.valueOf(cal.get(Calendar.MONTH)) + '-' + String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
            
            JSONObject jsonRetorn = Api.altaEsdeveniment(usuari, textFieldNom.getText(), textAreaDescripcio.getText(), data, textFieldHora.getText(), id_poblacio, textFieldValor.getText(), textFieldAforament.getText(),imatge, Utils.validarCheckbox(checkBoxActiu.isSelected()));
            
            if(jsonRetorn.getString("codi_error").equals("0")){
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("descripcio").toString());
                pantallaAdvertencia.setVisible(true);
                resetFormulari();
            }else{
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("codi_error").toString() + " - " +jsonRetorn.get("error").toString());
                pantallaAdvertencia.setVisible(true);
            }
            
        }else{
             PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(missatge);
             pantallaAdvertencia.setVisible(true);
         }
         
    }//GEN-LAST:event_buttonAltaActionPerformed
    
    /**
     * Mètode utilitzat quan es prem el botó de logout per tancar la sessió.
     * @param evt (ActionEvent) : event al pulsar el botó.
     */
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        // Fem el logout
        Api.logout(usuari);
        System.exit( 0);
    }//GEN-LAST:event_buttonLogOutActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de Tornar per tornar al llistat d'usuaris
     * @param evt (ActionEvent) : event al pulsar el botó.
     */
    private void buttonEsdevenimentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEsdevenimentsActionPerformed
        PantallaLlistatEsdeveniments pantallaLlistatEsdeveniments = new PantallaLlistatEsdeveniments(usuari);
        pantallaLlistatEsdeveniments.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonEsdevenimentsActionPerformed
   
    /** 
     * Mètode utilitzar quan es vol seleccionar una imatge
     * @param evt (ActionEvent) Pulsar botó.
     */
    private void buttonSeleccionarImatgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSeleccionarImatgeActionPerformed
        
        // Per controlar el resultat
        int resultat;
        
        // Determinem les extensions permitides
        FileNameExtensionFilter format = new FileNameExtensionFilter("JPG,PNG y GIF", "jpg","png","gif");
        
        // Instanciem el selector
        SelectorImatge selector = new SelectorImatge();
        
        // Asignem el format al selector
        selector.selectorImatge.setFileFilter(format);
        
        // Obrim el selector i recuperem el resultat
        resultat = selector.selectorImatge.showOpenDialog(null);
        
        // Comprovem el resultat
        if(JFileChooser.APPROVE_OPTION == resultat){
            
            // Triem la imatge que s'ha seleccionat i la guardem en l'atribut imatge.
            imatge = SelectorImatge.selectorImatge.getSelectedFile();
            
            // Posem la ruta en el label.
            labelPathImatge.setText(imatge.getAbsolutePath());
            
            // Posem la imatge en el label
            try{
                ImageIcon imatgeSeleccionada = new ImageIcon(imatge.toString());
                Icon icona = new ImageIcon(imatgeSeleccionada.getImage().getScaledInstance(200, 120, Image.SCALE_DEFAULT));
                labelImatgeSeleccionada.setIcon(icona);
            } catch (Exception ex){
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia("Error: " + ex.getMessage());
                pantallaAdvertencia.setVisible(true);
            }
           
        }
        
    }//GEN-LAST:event_buttonSeleccionarImatgeActionPerformed
    
    /**
     * Mètode per validar el que es posa al textfield de valor
     * @param evt (KeyEvent) pulsar el teclat.
     */
    private void textFieldValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldValorKeyTyped
        if(textFieldValor.getText().length() >= 15){
            evt.consume();
        }else{
            int key = evt.getKeyChar();
            boolean num = (((key >=48) && (key <= 57)) || (key == 46));
            if(!num){ evt.consume(); }
        }
    }//GEN-LAST:event_textFieldValorKeyTyped
    
    /**
     * Mètode per validar el que es posa al textfield de aforament
     * @param evt (KeyEvent) pulsar el teclat.
     */
    private void textFieldAforamentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldAforamentKeyTyped
        if(textFieldValor.getText().length() >= 15){
            evt.consume();
        }else{
            int key = evt.getKeyChar();
            boolean num = (((key >=48) && (key <= 57)));
            if(!num){ evt.consume(); }
        }
    }//GEN-LAST:event_textFieldAforamentKeyTyped

     /**
     * Mètode per validar el que es posa al textfield de hora
     * @param evt (KeyEvent) pulsar el teclat.
     */
    private void textFieldHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldHoraKeyTyped
        if(textFieldValor.getText().length() >= 15){
            evt.consume();
        }else{
            int key = evt.getKeyChar();
            boolean num = (((key >=48) && (key <= 57)) || (key == 58));
            if(!num){ evt.consume(); }
        }
    }//GEN-LAST:event_textFieldHoraKeyTyped

   
    /**
     * Mètode principal de la classe.
     * @param args arguments de la linia de comandament
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaAltaEsdeveniment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaAltaEsdeveniment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaAltaEsdeveniment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAltaEsdeveniment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaAltaEsdeveniment(usuari).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per donar d'alta punt de recollida
    */
    private javax.swing.JButton buttonAlta;
    /**
    * Botó per tornar a la pantalla de punts de recollida.
    */
    private javax.swing.JButton buttonEsdeveniments;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per seleccionar imatge
    */
    private javax.swing.JButton buttonSeleccionarImatge;
    /**
    * Checkbox actiu
    */
    private javax.swing.JCheckBox checkBoxActiu;
    /**
    * Combo box poblacions
    */
    private javax.swing.JComboBox<String> comboBoxPoblacions;
    /**
    * DateChooser data
    */
    private com.toedter.calendar.JDateChooser dateChooserData;
    /**
    * Label actiu
    */
    private javax.swing.JLabel labelActiu;
    /**
    * label aforament
    */
    private javax.swing.JLabel labelAforament;
    /**
    * label data
    */
    private javax.swing.JLabel labelData;
    /**
    * label descripció
    */
    private javax.swing.JLabel labelDescripcio;
    /**
    * label hora
    */
    private javax.swing.JLabel labelHora;
    /**
    * label hora format
    */
    private javax.swing.JLabel labelHoraFormat;
    /**
    * label imatge
    */
    private javax.swing.JLabel labelImatge;
    /**
    * Label per contenir la imatge seleccionada
    */
    private javax.swing.JLabel labelImatgeSeleccionada;
    /**
    * label nom
    */
    private javax.swing.JLabel labelNom;
    /**
    * label imatge seleccionada path
    */
    private javax.swing.JLabel labelPathImatge;
    /**
    * Label per contenir el logo de l'aplicació.
    */
    private javax.swing.JLabel labelPrincipal;
    /**
    * Label per el títol de la pantalla.
    */
    private javax.swing.JLabel labelTitol;
    /**
    * Label per tenir les dades de l'usuari loginat
    */
    private javax.swing.JLabel labelUsuari;
    /**
    * label valor
    */
    private javax.swing.JLabel labelValor;
    /**
    * Panel per contenir la informació de l'usuari loginat
    */
    private javax.swing.JPanel panelBar;
    /**
    * Panel per tenir el contingut de la pantalla.
    */
    private javax.swing.JPanel panelContingut;
    /**
    * Panel per tenir les opcions.
    */
    private javax.swing.JPanel panelOpcions;
    /**
    * Panel principal per contenir la distribució de la pantalla.
    */
    private javax.swing.JPanel panelPrincipal;
    /**
    * Panel per contenir el títol de la pantalla
    */
    private javax.swing.JPanel panelTitol;
    /**
    * Scroll panel de la descripcio
    */
    private javax.swing.JScrollPane scrollPaneDescripcio;
    /**
    * Test area per la descripció
    */
    private javax.swing.JTextArea textAreaDescripcio;
    /**
    * Text Field horari
    */
    private javax.swing.JTextField textFieldAforament;
    /**
    * Text Field hora
    */
    private javax.swing.JTextField textFieldHora;
    /**
    * Text Field nom punt de recollida
    */
    private javax.swing.JTextField textFieldNom;
    /**
    * Text Field carrer
    */
    private javax.swing.JTextField textFieldValor;
    // End of variables declaration//GEN-END:variables
}