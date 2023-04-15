package residueix.residueixapp.puntsrecollida;

import residueix.residueixapp.principal.PantallaPrincipal;
import residueix.residueixapp.principal.PantallaAdvertencia;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;

/**
 * Classe per obrir la pantalla per donar d'alta un tipus de residu
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */
public class PantallaRecollida extends javax.swing.JFrame { 
    
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
     * Imatge del residu.
     */
    private File imatge;
    /**
     * Llistat de punts
     */
    private ArrayList<String[]> llistatResidus = new ArrayList<String[]>();
    /**
     * Llistat de punts
     */
    private ArrayList<String[]> llistatTipusResidus = new ArrayList<String[]>();
    /**
     * id usuari recollida
     */
    private static String idUsuariRecollida;
    /**
     * id punt recollida
     */
    private static String idPuntRecollida;
    /**
     * Control de problemes
     */
    private String problemes;
    
    /**
     * Crea una nova instància de la classe PantallaPrincipal.
     * @param usuari: Usuari loginat a l'aplicació.
     * @param idUsuariRecollida (int) id usuari recollida
     * @param idPuntRecollida (int) id punt recollida
     */
    public PantallaRecollida(Usuari usuari, String idUsuariRecollida, String idPuntRecollida) {
        // Assignació de l'usuari
        this.usuari = usuari;
        this.idUsuariRecollida = idUsuariRecollida;
        this.idPuntRecollida = idPuntRecollida;
        this.problemes = "";
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();
        // Carregar array amb residus i tipus de residus.
        carregarArrays();
        // Carregar el combo de tipus de residus
        carregarTipuResidus();
        // Carregar el combo de residus
        carregarResidus("0");
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
        buttonRecollir = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        labelTotalTitol = new javax.swing.JLabel();
        labelCarreto = new javax.swing.JLabel();
        comboBoxTipus = new javax.swing.JComboBox<>();
        comboBoxResidus = new javax.swing.JComboBox<>();
        textFieldQuantitat = new javax.swing.JTextField();
        labelQuantitat = new javax.swing.JLabel();
        labelNom1 = new javax.swing.JLabel();
        labelNom2 = new javax.swing.JLabel();
        scrollPaneTipusResidu = new javax.swing.JScrollPane();
        jTableCarretó = new javax.swing.JTable();
        panelOpcions = new javax.swing.JPanel();
        buttonLogOut = new javax.swing.JButton();
        buttonTornarPantallaPrincipal1 = new javax.swing.JButton();
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
        labelTitol.setText("Recollida");
        labelTitol.setToolTipText("Recollida");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));

        buttonRecollir.setBackground(new java.awt.Color(51, 204, 0));
        buttonRecollir.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonRecollir.setForeground(new java.awt.Color(255, 255, 255));
        buttonRecollir.setText("Recollir");
        buttonRecollir.setToolTipText("Recollir");
        buttonRecollir.setBorderPainted(false);
        buttonRecollir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonRecollir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRecollirActionPerformed(evt);
            }
        });
        panelContingut.add(buttonRecollir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 690, 150, 30));

        labelTotal.setFont(new java.awt.Font("Sansation", 1, 18)); // NOI18N
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotal.setToolTipText("Total");
        panelContingut.add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 620, 120, 30));

        labelTotalTitol.setFont(new java.awt.Font("Sansation", 1, 18)); // NOI18N
        labelTotalTitol.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalTitol.setText("Total");
        labelTotalTitol.setToolTipText("Total");
        panelContingut.add(labelTotalTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 620, 200, 30));

        labelCarreto.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelCarreto.setText("Carretó de residus");
        labelCarreto.setToolTipText("Carretó de residus");
        panelContingut.add(labelCarreto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 200, 30));

        comboBoxTipus.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        comboBoxTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tots" }));
        comboBoxTipus.setToolTipText("Filtrar per tipus d'usuari");
        comboBoxTipus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboBoxTipus.setOpaque(true);
        comboBoxTipus.setPreferredSize(new java.awt.Dimension(200, 30));
        comboBoxTipus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipusActionPerformed(evt);
            }
        });
        panelContingut.add(comboBoxTipus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        comboBoxResidus.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        comboBoxResidus.setToolTipText("Filtrar per tipus d'usuari");
        comboBoxResidus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboBoxResidus.setOpaque(true);
        comboBoxResidus.setPreferredSize(new java.awt.Dimension(200, 30));
        panelContingut.add(comboBoxResidus, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, -1));

        textFieldQuantitat.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        textFieldQuantitat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldQuantitat.setToolTipText("Email");
        textFieldQuantitat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldQuantitat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFieldQuantitatKeyTyped(evt);
            }
        });
        panelContingut.add(textFieldQuantitat, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 200, 30));

        labelQuantitat.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelQuantitat.setText("Quantitat (unitats o pes en kg)");
        labelQuantitat.setToolTipText("Quantitat (unitats o pes)");
        panelContingut.add(labelQuantitat, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 200, 30));

        labelNom1.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelNom1.setText("Tipus de residus");
        labelNom1.setToolTipText("Tipus de residus");
        panelContingut.add(labelNom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 200, 30));

        labelNom2.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelNom2.setText("Residus");
        labelNom2.setToolTipText("Residus");
        panelContingut.add(labelNom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 200, 30));

        scrollPaneTipusResidu.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneTipusResidu.setBorder(null);
        scrollPaneTipusResidu.setOpaque(false);

        jTableCarretó.setAutoCreateRowSorter(true);
        jTableCarretó.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        jTableCarretó.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableCarretó.setToolTipText("Llistat punts de recollda");
        jTableCarretó.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableCarretó.setRowHeight(28);
        jTableCarretó.setRowMargin(5);
        jTableCarretó.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTableCarretó.setShowGrid(true);
        jTableCarretó.setShowVerticalLines(false);
        scrollPaneTipusResidu.setViewportView(jTableCarretó);

        panelContingut.add(scrollPaneTipusResidu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 700, 350));

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

        buttonTornarPantallaPrincipal1.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornarPantallaPrincipal1.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornarPantallaPrincipal1.setText("Pantalla principal");
        buttonTornarPantallaPrincipal1.setToolTipText("Tornar pantalla principal");
        buttonTornarPantallaPrincipal1.setBorderPainted(false);
        buttonTornarPantallaPrincipal1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornarPantallaPrincipal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarPantallaPrincipal1ActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornarPantallaPrincipal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        panelPrincipal.add(panelOpcions, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 2, 200, 746));

        labelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\fons_general.png")); // NOI18N
        labelPrincipal.setOpaque(true);
        panelPrincipal.add(labelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 996, 746));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void carregarArrays(){
         JSONObject jsonTipus = Api.llistatTipusResidu(usuari);
         if(jsonTipus.getString("codi_error").equals("0")){
            // Agafem les dades del camp llistat
            JSONArray arrayTipus = new JSONArray(jsonTipus.getJSONArray("llistat"));
            // Recorrem l'array per ficar-ho a la taula
            for(int i = 0; i < arrayTipus.length(); i++){
                JSONObject jsonTipusResidu = arrayTipus.getJSONObject(i);
                llistatTipusResidus.add(new String[]{jsonTipusResidu.get("id").toString(),jsonTipusResidu.get("nom").toString()});
            }
        }else{
            // Error en la crida a l'api
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonTipus.get("codi_error").toString() + " - " +jsonTipus.get("error").toString());
            pantallaAdvertencia.setVisible(true);
            problemes += " - " + jsonTipus.get("codi_error").toString() + " - " +jsonTipus.get("error").toString();
        }
         JSONObject jsonResidus = Api.llistatResidus(usuari);
         if(jsonTipus.getString("codi_error").equals("0")){
            // Agafem les dades del camp llistat
            JSONArray arrayResidus = new JSONArray(jsonResidus.getJSONArray("llistat"));
            // Recorrem l'array per ficar-ho a la taula
            for(int i = 0; i < arrayResidus.length(); i++){
                JSONObject jsonResidu = arrayResidus.getJSONObject(i);
                llistatResidus.add(new String[]{jsonResidu.get("id").toString(),jsonResidu.get("nom").toString()});
            }
        }else{
            // Error en la crida a l'api
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonTipus.get("codi_error").toString() + " - " +jsonTipus.get("error").toString());
            pantallaAdvertencia.setVisible(true);
            problemes += " - " + jsonTipus.get("codi_error").toString() + " - " +jsonTipus.get("error").toString();
        }
    }
    
    /**
     * Mètode per carregar el combo de tipus de residus.
     */
    private void carregarTipuResidus(){
        
        // Resetejem el combo
        comboBoxTipus.removeAllItems();
        
        // Omplim el combo
        for(int i = 0; i < llistatTipusResidus.size(); i++){
            comboBoxTipus.addItem(llistatTipusResidus.get(i)[1]);
        }
        
    }
    
    /**
     * Mètode per carregar el combo de residus.
     * @param 
     */
   private void carregarResidus(String idTipus){
       
       // Resetejem el combo
        comboBoxResidus.removeAllItems();
        
        // Omplim el combo
        for(int i = 0; i < llistatResidus.size(); i++){
            if(idTipus.equals("0")){
                comboBoxResidus.addItem(llistatResidus.get(i)[1]);
            }else{
                if(llistatResidus.get(i)[0].equals(idTipus)){
                    comboBoxResidus.addItem(llistatResidus.get(i)[1]);   
                }
            }
        }
       
       
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
     * Mètode utilitzat quan es prem el botó de logout per tancar la sessió.
     * @param evt (ActionEvent) : event al pulsar el botó.
     */
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        // Fem el logout
        Api.logout(usuari);
        System.exit( 0);
    }//GEN-LAST:event_buttonLogOutActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de tornar a la pantalla principal
     * @param evt (ActionEvent) : event al pulsar el botó. 
     */
    private void buttonTornarPantallaPrincipal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarPantallaPrincipal1ActionPerformed
        // Obre la pantalla principal
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(usuari);
        pantallaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonTornarPantallaPrincipal1ActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de recollir
     * @param evt (ActionEvent) : event al pulsar el botó. 
     */
    private void buttonRecollirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRecollirActionPerformed
        

    }//GEN-LAST:event_buttonRecollirActionPerformed

    /**
     * Mètode quan es selecciona un item del combo tipus residus
     * @param evt (ActionEvent) seleccionar un item del combo
     */ 
    private void comboBoxTipusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipusActionPerformed
        if(comboBoxTipus.getSelectedIndex() == 0){
            // tots
            carregarResidus("0");
        }else{
            String[] ee = null;
            for (String[] e : llistatResidus) {
                if (e[0].equals(identificadorBuscado)) {
                    ee = e;
                     break;
                 }
            }
            // Específic
            carregarResidus(ee);
            
        }

    }//GEN-LAST:event_comboBoxTipusActionPerformed

    /**
     * Mètode quan es pulsa una tecla en el camp de quantitat
     * @param evt (KeyEvent) pulsar tecla teclat.
     */
    private void textFieldQuantitatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldQuantitatKeyTyped
        if(textFieldQuantitat.getText().length() >= 10){
            evt.consume();
        }else{
            int key = evt.getKeyChar();
            boolean num = (((key >=48) && (key <= 57)) || (key == 46));
            if(!num){ evt.consume(); }
        }
    }//GEN-LAST:event_textFieldQuantitatKeyTyped

  
 
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
            java.util.logging.Logger.getLogger(PantallaRecollida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaRecollida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaRecollida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaRecollida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PantallaRecollida(usuari,idUsuariRecollida,idPuntRecollida).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per recollir
    */
    private javax.swing.JButton buttonRecollir;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornarPantallaPrincipal1;
    /**
    * Combo box residus
    */
    private javax.swing.JComboBox<String> comboBoxResidus;
    /**
    * Combo box tipus de residus
    */
    private javax.swing.JComboBox<String> comboBoxTipus;
    /**
    * Taula per contenir els residus del carretó
    */
    private javax.swing.JTable jTableCarretó;
    /**
    * label carretó residus
    */
    private javax.swing.JLabel labelCarreto;
    /**
    * label tipus residus
    */
    private javax.swing.JLabel labelNom1;
    /**
    * label residus
    */
    private javax.swing.JLabel labelNom2;
    /**
    * Label per contenir el logo de l'aplicació.
    */
    private javax.swing.JLabel labelPrincipal;
    /**
    * label quantitat
    */
    private javax.swing.JLabel labelQuantitat;
    /**
    * Label per el títol de la pantalla.
    */
    private javax.swing.JLabel labelTitol;
    /**
    * label total quantitat
    */
    private javax.swing.JLabel labelTotal;
    /**
    * label total titol
    */
    private javax.swing.JLabel labelTotalTitol;
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
    * Scroll pane per contenir el jtable
    */
    private javax.swing.JScrollPane scrollPaneTipusResidu;
    /**
    * Text Field quantitat
    */
    private javax.swing.JTextField textFieldQuantitat;
    // End of variables declaration//GEN-END:variables
}