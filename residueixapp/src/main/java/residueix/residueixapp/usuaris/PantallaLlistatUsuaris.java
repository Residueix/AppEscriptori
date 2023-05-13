package residueix.residueixapp.usuaris;

import residueix.residueixapp.usuaris.PantallaBaixaUsuari;
import residueix.residueixapp.usuaris.PantallaAltaUsuari;
import residueix.residueixapp.usuaris.PantallaModificarUsuari;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.principal.PantallaAdvertencia;
import residueix.residueixapp.principal.PantallaPrincipal;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.Utils;

/**
 * Classe per obrir la pantalla principal de l'aplicació.
 * @author Daniel Garcia Ruiz
 * @version 24/03/2023
 */
public class PantallaLlistatUsuaris extends javax.swing.JFrame {
    
    
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
     * Crea una nova instància de la classe PantallaPrincipal.
     * @param usuari: Usuari loginat a l'aplicació.
     */
    public PantallaLlistatUsuaris(Usuari usuari) {
        // Assignació de l'usuari
        this.usuari = usuari;
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();        
        // Disseny elements
        estilFormulari();
        // Llistat d'usuaris - omplir la taula
        omplirTaula(0,0);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuaris = new javax.swing.JTable();
        comboBoxTipus = new javax.swing.JComboBox<>();
        comboBoxActiu = new javax.swing.JComboBox<>();
        panelOpcions = new javax.swing.JPanel();
        buttonTornar = new javax.swing.JButton();
        buttonTransaccions = new javax.swing.JButton();
        buttonAlta = new javax.swing.JButton();
        buttonLogOut = new javax.swing.JButton();
        buttonModificacio = new javax.swing.JButton();
        buttonBaixa = new javax.swing.JButton();
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
        labelTitol.setText("Llistat d'usuaris");
        labelTitol.setToolTipText("");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setOpaque(false);

        jTableUsuaris.setAutoCreateRowSorter(true);
        jTableUsuaris.setFont(new java.awt.Font("Sansation", 0, 12)); // NOI18N
        jTableUsuaris.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Email", "Tipus", "Nom", "Cognom1", "Cognom2", "Actiu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableUsuaris.setToolTipText("Llistat d'usuaris");
        jTableUsuaris.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableUsuaris.setOpaque(false);
        jTableUsuaris.setRowHeight(28);
        jTableUsuaris.setRowMargin(5);
        jTableUsuaris.setShowGrid(false);
        jScrollPane1.setViewportView(jTableUsuaris);

        panelContingut.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 250, 700, 470));

        comboBoxTipus.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        comboBoxTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tots els tipus d'usuaris", "Tipus 1 - Administradors", "Tipus 2 - Treballadors", "Tipus 3 - Residuents", "Tipus 4 - Adherits" }));
        comboBoxTipus.setToolTipText("Filtrar per tipus d'usuari");
        comboBoxTipus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboBoxTipus.setPreferredSize(new java.awt.Dimension(200, 30));
        comboBoxTipus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTipusActionPerformed(evt);
            }
        });
        panelContingut.add(comboBoxTipus, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));

        comboBoxActiu.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        comboBoxActiu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tots actius i baixes", "Només Actius", "Només Baixes" }));
        comboBoxActiu.setToolTipText("Filtrar per usauris actius/baixa");
        comboBoxActiu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboBoxActiu.setPreferredSize(new java.awt.Dimension(200, 30));
        comboBoxActiu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActiuActionPerformed(evt);
            }
        });
        panelContingut.add(comboBoxActiu, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        panelPrincipal.add(panelContingut, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 798, 746));

        panelOpcions.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcions.setOpaque(false);
        panelOpcions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonTornar.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornar.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornar.setText("Tornar principal");
        buttonTornar.setToolTipText("Tornar a la pantalla principal");
        buttonTornar.setBorderPainted(false);
        buttonTornar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        buttonTransaccions.setBackground(new java.awt.Color(51, 102, 255));
        buttonTransaccions.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTransaccions.setForeground(new java.awt.Color(255, 255, 255));
        buttonTransaccions.setText("Transaccions");
        buttonTransaccions.setToolTipText("Transaccions d'usuari");
        buttonTransaccions.setBorderPainted(false);
        buttonTransaccions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTransaccions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTransaccionsActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTransaccions, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 150, 30));

        buttonAlta.setBackground(new java.awt.Color(51, 102, 255));
        buttonAlta.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonAlta.setForeground(new java.awt.Color(255, 255, 255));
        buttonAlta.setText("Alta");
        buttonAlta.setToolTipText("Alta d'usuari");
        buttonAlta.setBorderPainted(false);
        buttonAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAltaActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 150, 30));

        buttonLogOut.setBackground(new java.awt.Color(153, 0, 0));
        buttonLogOut.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonLogOut.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogOut.setText("Logout");
        buttonLogOut.setToolTipText("Sortir de l'aplicació");
        buttonLogOut.setBorderPainted(false);
        buttonLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogOutActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 150, 30));

        buttonModificacio.setBackground(new java.awt.Color(51, 102, 255));
        buttonModificacio.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonModificacio.setForeground(new java.awt.Color(255, 255, 255));
        buttonModificacio.setText("Modificar");
        buttonModificacio.setToolTipText("Modificació d'usuari");
        buttonModificacio.setBorderPainted(false);
        buttonModificacio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonModificacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificacioActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonModificacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, 30));

        buttonBaixa.setBackground(new java.awt.Color(51, 102, 255));
        buttonBaixa.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonBaixa.setForeground(new java.awt.Color(255, 255, 255));
        buttonBaixa.setText("Baixa");
        buttonBaixa.setToolTipText("Baixa d'usuari");
        buttonBaixa.setBorderPainted(false);
        buttonBaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBaixaActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 150, 30));

        panelPrincipal.add(panelOpcions, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 2, 200, 746));

        labelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\fons_general.png")); // NOI18N
        labelPrincipal.setOpaque(true);
        panelPrincipal.add(labelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 996, 746));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mètode per donar estil a elements del formulari.
     */
    private void estilFormulari(){
        comboBoxTipus.setBackground(new Color(255,255,255,255));
        comboBoxActiu.setBackground(new Color(255,255,255,255));
    }
    
    /**
     * Mètode per gestionar accions en funció de l'usuari
     */
    private void gestioUsuari(){
        // Posem el nom de l'usuari a la part superior
        labelUsuari.setText( usuari.getNom() + " " + usuari.getCognom1() + " " + usuari.getCognom2() );   
        // Tractament de permisos per mostrar opcions disponibles.
        switch(usuari.getTipus()){
            case 1 -> { 
            }
            case 2 -> {
            }
        }
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
     * Mètode per omplir la taula amb les dades dels usuaris.
     * @param llistatUsuaris (JSONArray) json amb el llistat d'usuaris.
     */
    private void omplirTaula(int tipus, int actiu){
        JSONObject jsonObject = (JSONObject) Api.llistatUsuaris(usuari,tipus,actiu);
        
        if(!jsonObject.isEmpty()){
            if(jsonObject.get("codi_error").toString().equals("0")) {
                // Definició del model
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("id");
                model.addColumn("Email");
                model.addColumn("Tipus");
                model.addColumn("Nom");
                model.addColumn("Cognom1");
                model.addColumn("Cognom2");
                model.addColumn("Actiu");
                // Bucle per omplir la taula
                JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("llistat"));
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonUsuari = jsonArray.getJSONObject(i);
                    Object []obj = new Object[7];
                    obj[0] = jsonUsuari.get("id").toString();
                    obj[1] = jsonUsuari.get("email").toString();
                    obj[2] = jsonUsuari.get("tipus").toString();
                    obj[3] = jsonUsuari.get("nom").toString();
                    obj[4] = jsonUsuari.get("cognom1").toString();
                    obj[5] = jsonUsuari.get("cognom2").toString();
                    obj[6] = jsonUsuari.get("actiu").toString();
                    model.addRow(obj);
                }
                // Personalització de la taula
                jTableUsuaris.setModel(model);   
                jTableUsuaris.getTableHeader().setPreferredSize(new java.awt.Dimension(40,40));
                jTableUsuaris.getTableHeader().setBackground(new Color(51,102,255));
                jTableUsuaris.getTableHeader().setForeground(new Color(255,255,255));
                jTableUsuaris.getColumnModel().getColumn(0).setMaxWidth(50);
                jTableUsuaris.getColumnModel().getColumn(2).setMaxWidth(50);
                jTableUsuaris.getColumnModel().getColumn(6).setMaxWidth(50);
                jTableUsuaris.setRowSelectionAllowed(true);
                jTableUsuaris.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                DefaultTableCellRenderer renderTaula = new DefaultTableCellRenderer();
                renderTaula.setHorizontalAlignment(SwingConstants.CENTER);
                jTableUsuaris.getColumnModel().getColumn(1).setCellRenderer(renderTaula);
            }else{
                // Mostrem l'error que ens està enviant.
                PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(jsonObject.get("codi_error").toString() + " - " + jsonObject.get("error").toString());
                pantallaAdvertencia.setVisible(true);
            }
        }else{
            // Mostrem que hi ha hagut un error al sistema
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error(3));
            pantallaAdvertencia.setVisible(true);
        }
        
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
     * Mètode utilitzat quan es prem el botó de tornar a la pantalla principal.
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonTornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarActionPerformed
         PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(usuari);
         pantallaPrincipal.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_buttonTornarActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de logout per tancar la sessió.
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogOutActionPerformed
        // Fem el logout
        Api.logout(usuari);
        System.exit( 0);
    }//GEN-LAST:event_buttonLogOutActionPerformed

    /**
     * Mètode utilitzat quan es canvia de selecció al combo de filtratge.
     * @param evt (AcionEvent) : pulsar el botó.
     */
    private void comboBoxTipusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipusActionPerformed
        omplirTaula(comboBoxTipus.getSelectedIndex(),comboBoxActiu.getSelectedIndex());
    }//GEN-LAST:event_comboBoxTipusActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó d'alta s'usuari.
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAltaActionPerformed
        PantallaAltaUsuari pantallaAltaUsuari = new PantallaAltaUsuari(usuari);
        pantallaAltaUsuari.setVisible(true);
        this.dispose();
                
    }//GEN-LAST:event_buttonAltaActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó baixa d'usari
     * @param evt  (ActionEvent) : Pulsar el botó.
     */
    private void buttonBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBaixaActionPerformed
        // Mirem si tenim seleccionat fila del llistat 
        int filaSeleccionada = jTableUsuaris.getSelectedRow();
        if(filaSeleccionada != -1){
            DefaultTableModel model = (DefaultTableModel) jTableUsuaris.getModel();
            int idUsuari = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());
            PantallaBaixaUsuari pantallaBaixaUsuari = new PantallaBaixaUsuari(usuari,idUsuari);
            pantallaBaixaUsuari.setVisible(true);
            this.dispose();
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia("Has de seleccionar una fila de la taula d'usuaris.");
            pantallaAdvertencia.setVisible(true);
        }
        
    }//GEN-LAST:event_buttonBaixaActionPerformed

    /**
     * Mètode utilitzat quan es canvia de selecció al combo de filtratge per actiu/baixa
     * @param evt (AcionEvent) : pulsar el botó.
     */
    private void comboBoxActiuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActiuActionPerformed
        omplirTaula(comboBoxTipus.getSelectedIndex(),comboBoxActiu.getSelectedIndex());
    }//GEN-LAST:event_comboBoxActiuActionPerformed

    /**
     * Métode utilitzat quan es prem el botó de modificar usuari.
     * @param evt (ActionEvent) : pulsar el botó.
     */
    private void buttonModificacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificacioActionPerformed
        // Mirem si tenim seleccionat fila del llistat 
        int filaSeleccionada = jTableUsuaris.getSelectedRow();
        if(filaSeleccionada != -1){
            DefaultTableModel model = (DefaultTableModel) jTableUsuaris.getModel();
            int idUsuari = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());
            PantallaModificarUsuari pantallaModificarUsuari = new PantallaModificarUsuari(usuari,idUsuari);
            pantallaModificarUsuari.setVisible(true);
            this.dispose();
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error(8));
            pantallaAdvertencia.setVisible(true);
        }
    }//GEN-LAST:event_buttonModificacioActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó de transaccions d'usuari
     * @param evt  (ActionEevent) : pulsar el botó.
     */
    private void buttonTransaccionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTransaccionsActionPerformed
        // Mirem si tenim seleccionat fila del llistat 
        int filaSeleccionada = jTableUsuaris.getSelectedRow();
        if(filaSeleccionada != -1){
            DefaultTableModel model = (DefaultTableModel) jTableUsuaris.getModel();
            int idUsuari = Integer.parseInt(model.getValueAt(filaSeleccionada, 0).toString());
            PantallaTransaccionsUsuari pantallaTransacciosUsuari = new PantallaTransaccionsUsuari(usuari,idUsuari);
            pantallaTransacciosUsuari.setVisible(true);
            this.dispose();
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error(8));
            pantallaAdvertencia.setVisible(true);
        }
    }//GEN-LAST:event_buttonTransaccionsActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaLlistatUsuaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaLlistatUsuaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaLlistatUsuaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaLlistatUsuaris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaLlistatUsuaris(usuari).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per donar d'alta un usuari
    */
    private javax.swing.JButton buttonAlta;
    /**
    * Botó per donar de baixa un usuari.
    */
    private javax.swing.JButton buttonBaixa;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per modificar un usuari.
    */
    private javax.swing.JButton buttonModificacio;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornar;
    /**
    * Botó per veure les transaccions d'un usuari
    */
    private javax.swing.JButton buttonTransaccions;
    /**
    * Combo box amb diferents opcions per filtrar el llistat d'usauris
    */
    private javax.swing.JComboBox<String> comboBoxActiu;
    /**
    * Combo box amb diferents opcions per filtrar el llistat d'usauris
    */
    private javax.swing.JComboBox<String> comboBoxTipus;
    /**
    * Scroll pane per contenir el jtable
    */
    private javax.swing.JScrollPane jScrollPane1;
    /**
    * Taula per contenir als usuaris
    */
    private javax.swing.JTable jTableUsuaris;
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
    // End of variables declaration//GEN-END:variables
}