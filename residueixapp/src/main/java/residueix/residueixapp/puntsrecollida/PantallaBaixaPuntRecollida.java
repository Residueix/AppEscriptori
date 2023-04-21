package residueix.residueixapp.puntsrecollida;

// Imports
import residueix.residueixapp.principal.PantallaAdvertencia;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
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
 * Classe per obrir la pantalla per donar d'alta un punt de recollida
 * @author Daniel Garcia Ruiz
 * @version 07/04/2023
 */
public class PantallaBaixaPuntRecollida extends javax.swing.JFrame {
    
    
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
     * Punt de recollida id
     */
    private static int idPuntRecollida;   
    
    /**
     * Crea una nova instància de la classe PantallaPrincipal.
     * @param usuari: Usuari loginat a l'aplicació.
     * @param idPunt: id del punt de recollida.
     */
    public PantallaBaixaPuntRecollida(Usuari usuari, int idPunt) {
        // Assignació de l'usuari
        this.usuari = usuari;
        // Assignem el punt de recollida id
        this.idPuntRecollida = idPunt;
        // imatge a null
        this.imatge = null;
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();
        // Càrrega inicial del formulari.
        carregaFormulari();
        // Fer el formulari de solament lectura, sense posibilitat d'editar-ho.
        formulariDeLectura();
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
        labelLatitud = new javax.swing.JLabel();
        labelActiu = new javax.swing.JLabel();
        checkBoxActiu = new javax.swing.JCheckBox();
        labelDescripcio = new javax.swing.JLabel();
        buttonBaixa = new javax.swing.JButton();
        textFieldLatitud = new javax.swing.JTextField();
        labelImatge = new javax.swing.JLabel();
        scrollPaneDescripcio = new javax.swing.JScrollPane();
        textAreaDescripcio = new javax.swing.JTextArea();
        labelNom = new javax.swing.JLabel();
        textFieldNom = new javax.swing.JTextField();
        labelImatgeSeleccionada = new javax.swing.JLabel();
        labelLongitud = new javax.swing.JLabel();
        textFieldLongitud = new javax.swing.JTextField();
        labelCarrer = new javax.swing.JLabel();
        textFieldCarrer = new javax.swing.JTextField();
        labelCP = new javax.swing.JLabel();
        textFieldCP = new javax.swing.JTextField();
        labelHorari = new javax.swing.JLabel();
        textFieldPoblacio = new javax.swing.JTextField();
        textFieldHorari = new javax.swing.JTextField();
        panelOpcions = new javax.swing.JPanel();
        buttonLogOut = new javax.swing.JButton();
        buttonPunts = new javax.swing.JButton();
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
        labelTitol.setText("Baixa Punt de recollida");
        labelTitol.setToolTipText("");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));

        labelPathImatge.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelPathImatge.setToolTipText("Imatge del residu");
        panelContingut.add(labelPathImatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 470, 30));

        labelLatitud.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelLatitud.setText("Latitud");
        labelLatitud.setToolTipText("Latitud del punt de recollida");
        panelContingut.add(labelLatitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 30));

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

        buttonBaixa.setBackground(new java.awt.Color(51, 204, 0));
        buttonBaixa.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonBaixa.setForeground(new java.awt.Color(255, 255, 255));
        buttonBaixa.setText("Baixa punt");
        buttonBaixa.setToolTipText("Donar de baixa punt de recollida");
        buttonBaixa.setBorderPainted(false);
        buttonBaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBaixaActionPerformed(evt);
            }
        });
        panelContingut.add(buttonBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 690, 150, 30));

        textFieldLatitud.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldLatitud.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldLatitud.setToolTipText("Email");
        textFieldLatitud.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldLatitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldLatitudKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldLatitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 200, 30));

        labelImatge.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelImatge.setText("Imatge");
        labelImatge.setToolTipText("Imatge del residu");
        panelContingut.add(labelImatge, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 100, 30));

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
        panelContingut.add(labelImatgeSeleccionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 200, 120));

        labelLongitud.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelLongitud.setText("Longitud");
        labelLongitud.setToolTipText("Longitud del punt de recollida");
        panelContingut.add(labelLongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 100, 30));

        textFieldLongitud.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldLongitud.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldLongitud.setToolTipText("Email");
        textFieldLongitud.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldLongitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldLongitudKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldLongitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 190, 30));

        labelCarrer.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelCarrer.setText("Carrer");
        labelCarrer.setToolTipText("Carrer del punt de recollida");
        panelContingut.add(labelCarrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 100, 30));

        textFieldCarrer.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldCarrer.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldCarrer.setToolTipText("Email");
        textFieldCarrer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContingut.add(textFieldCarrer, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 530, 30));

        labelCP.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelCP.setText("Codi postal");
        labelCP.setToolTipText("Codi postal punt de recollida");
        panelContingut.add(labelCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 100, 30));

        textFieldCP.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldCP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldCP.setToolTipText("Email");
        textFieldCP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldCPKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 150, 30));

        labelHorari.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelHorari.setText("Horari");
        labelHorari.setToolTipText("Horari del punt de recollida");
        panelContingut.add(labelHorari, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 60, 30));

        textFieldPoblacio.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldPoblacio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldPoblacio.setToolTipText("Email");
        textFieldPoblacio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContingut.add(textFieldPoblacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 340, 30));

        textFieldHorari.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldHorari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldHorari.setToolTipText("Email");
        textFieldHorari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelContingut.add(textFieldHorari, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 530, 30));

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

        buttonPunts.setBackground(new java.awt.Color(255, 204, 0));
        buttonPunts.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonPunts.setText("Punts de recollida");
        buttonPunts.setToolTipText("Tornar al llistat de punts de recollida");
        buttonPunts.setBorderPainted(false);
        buttonPunts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonPunts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPuntsActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonPunts, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        panelPrincipal.add(panelOpcions, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 2, 200, 746));

        labelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\fons_general.png")); // NOI18N
        labelPrincipal.setOpaque(true);
        panelPrincipal.add(labelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 996, 746));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Mètode per deixar els elements del formulari com a solament lectura.
     */
    private void formulariDeLectura(){
        textFieldNom.setEditable(false);
        checkBoxActiu.setEnabled(false);
        textAreaDescripcio.setEditable(false);
        textAreaDescripcio.setBackground(new Color(238,238,238,255));
        textFieldLatitud.setEditable(false);
        textFieldLongitud.setEditable(false);
        textFieldCarrer.setEditable(false);
        textFieldCP.setEditable(false);
        textFieldPoblacio.setEditable(false);
        textFieldHorari.setEditable(false);
        
    }
    
    /**
     * Mètode per carregar dades necesàries del formulari
     */
    private void carregaFormulari(){
       
        String problemes = "";
        
        // Seleccionem les dades del punt de recolida.
        JSONObject jsonPunt = Api.consultaPunt(idPuntRecollida);
        if(jsonPunt.getString("codi_error").equals("0")){
            textFieldNom.setText(jsonPunt.getString("nom_punt"));
            // Actiu
            if(jsonPunt.getString("actiu").equals("1")){
                checkBoxActiu.setSelected(true);
            }else{
                checkBoxActiu.setSelected(false);   
            }
            textAreaDescripcio.setText(jsonPunt.getString("descripcio"));
            textFieldLatitud.setText(jsonPunt.getString("latitud"));
            textFieldLongitud.setText(jsonPunt.getString("longitud"));
            textFieldCarrer.setText(jsonPunt.getString("carrer"));
            textFieldCP.setText(jsonPunt.getString("cp"));
            textFieldPoblacio.setText(jsonPunt.getString("nom_poblacio"));
            textFieldHorari.setText(jsonPunt.getString("horari"));
            // Imatge
            labelPathImatge.setText(jsonPunt.getString("imatge"));
            ImageIcon imatgeTipusResidu = Utils.carregaImatge(3,jsonPunt.getString("imatge"));
            labelImatgeSeleccionada.setIcon(imatgeTipusResidu);
        }else{
            problemes += "Hi ha problemes amb el llistat de poblacions:  " + jsonPunt.get("codi_error").toString() + " - " + jsonPunt.get("error").toString() ;    
               
        }
        
        // Mostrem per consola els probemes que hi han hagut en la càrrega del formulari.
        System.out.println(problemes);
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
        buttonBaixa.setVisible(false);
        textFieldPoblacio.setText("");
        checkBoxActiu.setSelected(false);
        textFieldNom.setText("");
        textAreaDescripcio.setText("");
        textFieldLatitud.setText("");
        textFieldLongitud.setText("");
        textFieldCarrer.setText("");
        textFieldCP.setText("");
        textFieldHorari.setText("");
        labelPathImatge.setText("");
        labelImatgeSeleccionada.setIcon(null);
        if(imatge!=null){ imatge.delete(); }
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
     * Mètode utilitzat quan es prem el botó de donar d'alta un residu
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBaixaActionPerformed
        
        JSONObject jsonRetorn = Api.baixaPunt(usuari, idPuntRecollida);
        if(jsonRetorn.getString("codi_error").equals("0")){
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("descripcio").toString());
            pantallaAdvertencia.setVisible(true);
            resetFormulari();
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonRetorn.get("codi_error").toString() + " - " +jsonRetorn.get("error").toString());
            pantallaAdvertencia.setVisible(true);
        }
         
    }//GEN-LAST:event_buttonBaixaActionPerformed
    
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
    private void buttonPuntsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPuntsActionPerformed
        PantallaLlistatPuntsRecollida pantallaLlistatPuntsRecollida = new PantallaLlistatPuntsRecollida(usuari);
        pantallaLlistatPuntsRecollida.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonPuntsActionPerformed
   
    /**
     * Mètode per controlar el que es posa per teclat al camp latitud
     * @param evt (KeyEvent) pulsar teclat.
     */
    private void textFieldLatitudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldLatitudKeyTyped
        if(textFieldLatitud.getText().length() >= 10){
            evt.consume();
        }else{
            int key = evt.getKeyChar();
            boolean num = (((key >=48) && (key <= 57)) || (key == 46));
            if(!num){ evt.consume(); }
        }
    }//GEN-LAST:event_textFieldLatitudKeyTyped

    /**
     * Mètode per controlar el que es posa per teclat al camp longitud
     * @param evt (KeyEvent) pulsar teclat.
     */
    private void textFieldLongitudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldLongitudKeyTyped
        if(textFieldLongitud.getText().length() >= 10){
            evt.consume();
        }else{
            int key = evt.getKeyChar();
            boolean num = (((key >=48) && (key <= 57)) || (key == 46));
            if(!num){ evt.consume(); }
        }
    }//GEN-LAST:event_textFieldLongitudKeyTyped

    /**
     * Mètode per controlar el que es posa per teclat al camp cp
     * @param evt (KeyEvent) pulsar teclat.
     */
    private void textFieldCPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldCPKeyTyped
        if(textFieldLatitud.getText().length() >= 5){
            evt.consume();
        }else{
            int key = evt.getKeyChar();
            boolean num = (key >=48) && (key <= 57);
            if(!num){ evt.consume(); }
        }
    }//GEN-LAST:event_textFieldCPKeyTyped

   
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
            java.util.logging.Logger.getLogger(PantallaBaixaPuntRecollida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaBaixaPuntRecollida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaBaixaPuntRecollida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaBaixaPuntRecollida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PantallaBaixaPuntRecollida(usuari,idPuntRecollida).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per donar d'alta punt de recollida
    */
    private javax.swing.JButton buttonBaixa;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per tornar a la pantalla de punts de recollida.
    */
    private javax.swing.JButton buttonPunts;
    /**
    * Checkbox actiu
    */
    private javax.swing.JCheckBox checkBoxActiu;
    /**
    * Label actiu
    */
    private javax.swing.JLabel labelActiu;
    /**
    * label codi postal
    */
    private javax.swing.JLabel labelCP;
    /**
    * label carrer
    */
    private javax.swing.JLabel labelCarrer;
    /**
    * label descripció
    */
    private javax.swing.JLabel labelDescripcio;
    /**
    * label horari
    */
    private javax.swing.JLabel labelHorari;
    /**
    * label imatge
    */
    private javax.swing.JLabel labelImatge;
    /**
    * Label per contenir la imatge seleccionada
    */
    private javax.swing.JLabel labelImatgeSeleccionada;
    /**
    * label latitud
    */
    private javax.swing.JLabel labelLatitud;
    /**
    * label longitud
    */
    private javax.swing.JLabel labelLongitud;
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
    * Test area per la descripció del punt de recollida
    */
    private javax.swing.JTextArea textAreaDescripcio;
    /**
    * Text Field codi postal
    */
    private javax.swing.JTextField textFieldCP;
    /**
    * Text Field carrer
    */
    private javax.swing.JTextField textFieldCarrer;
    /**
    * Text Field horari
    */
    private javax.swing.JTextField textFieldHorari;
    /**
    * Text Field latitud
    */
    private javax.swing.JTextField textFieldLatitud;
    /**
    * Text Field longitud
    */
    private javax.swing.JTextField textFieldLongitud;
    /**
    * Text Field nom punt de recollida
    */
    private javax.swing.JTextField textFieldNom;
    /**
    * Text Field població
    */
    private javax.swing.JTextField textFieldPoblacio;
    // End of variables declaration//GEN-END:variables
}