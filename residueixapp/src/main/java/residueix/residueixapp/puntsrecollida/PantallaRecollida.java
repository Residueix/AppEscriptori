package residueix.residueixapp.puntsrecollida;

// imports
import java.awt.Color;
import residueix.residueixapp.principal.PantallaPrincipal;
import residueix.residueixapp.principal.PantallaAdvertencia;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.RenderitzatsTaules;
import residueix.residueixapp.utils.Utils;

/**
 * Classe per obrir la pantalla per donar d'alta un tipus de residu
 * @author Daniel Garcia Ruiz
 * @version 18/04/2023
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
     * Llistat del residus que ha donat el residuent.
     */
    private ArrayList<String[]> carreto = new ArrayList<String[]>();
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
     * Model del jtable
     */
    private DefaultTableModel model;
    /**
     * Total Carreto
     */
    private double totalCarreto;
    
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
        // Carrega model jtable
        carregarModel();
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
        labelTotal = new javax.swing.JLabel();
        labelTotalTitol = new javax.swing.JLabel();
        labelCarreto = new javax.swing.JLabel();
        comboBoxTipus = new javax.swing.JComboBox<>();
        comboBoxResidus = new javax.swing.JComboBox<>();
        textFieldQuantitat = new javax.swing.JTextField();
        labelQuantitat = new javax.swing.JLabel();
        labelTipusResidus = new javax.swing.JLabel();
        buttonTreure = new javax.swing.JButton();
        buttonAfegir = new javax.swing.JButton();
        labelResidus = new javax.swing.JLabel();
        scrollPaneTipusResidu = new javax.swing.JScrollPane();
        jTableCarreto = new javax.swing.JTable();
        buttonValidarRecollida = new javax.swing.JButton();
        panelOpcions = new javax.swing.JPanel();
        buttonAltra = new javax.swing.JButton();
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

        labelTotal.setFont(new java.awt.Font("Sansation", 1, 18)); // NOI18N
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotal.setToolTipText("Total");
        panelContingut.add(labelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 640, 120, 30));

        labelTotalTitol.setFont(new java.awt.Font("Sansation", 1, 18)); // NOI18N
        labelTotalTitol.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalTitol.setText("Total");
        labelTotalTitol.setToolTipText("Total");
        panelContingut.add(labelTotalTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 640, 200, 30));

        labelCarreto.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelCarreto.setText("Carretó de residus");
        labelCarreto.setToolTipText("Carretó de residus");
        panelContingut.add(labelCarreto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 200, 30));

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

        labelTipusResidus.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelTipusResidus.setText("Tipus de residus");
        labelTipusResidus.setToolTipText("Tipus de residus");
        panelContingut.add(labelTipusResidus, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 200, 30));

        buttonTreure.setBackground(new java.awt.Color(51, 102, 255));
        buttonTreure.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTreure.setForeground(new java.awt.Color(255, 255, 255));
        buttonTreure.setText("Treure residu");
        buttonTreure.setToolTipText("Treure residu");
        buttonTreure.setBorderPainted(false);
        buttonTreure.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTreure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTreureActionPerformed(evt);
            }
        });
        panelContingut.add(buttonTreure, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 200, 30));

        buttonAfegir.setBackground(new java.awt.Color(51, 102, 255));
        buttonAfegir.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonAfegir.setForeground(new java.awt.Color(255, 255, 255));
        buttonAfegir.setText("Afegir residu");
        buttonAfegir.setToolTipText("Afegir residu");
        buttonAfegir.setBorderPainted(false);
        buttonAfegir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAfegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAfegirActionPerformed(evt);
            }
        });
        panelContingut.add(buttonAfegir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 200, 30));

        labelResidus.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        labelResidus.setText("Residus");
        labelResidus.setToolTipText("Residus");
        panelContingut.add(labelResidus, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 200, 30));

        scrollPaneTipusResidu.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneTipusResidu.setBorder(null);
        scrollPaneTipusResidu.setOpaque(false);

        jTableCarreto.setAutoCreateRowSorter(true);
        jTableCarreto.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        jTableCarreto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableCarreto.setToolTipText("Llistat punts de recollda");
        jTableCarreto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableCarreto.setRowHeight(28);
        jTableCarreto.setRowMargin(5);
        jTableCarreto.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTableCarreto.setShowGrid(true);
        jTableCarreto.setShowVerticalLines(false);
        scrollPaneTipusResidu.setViewportView(jTableCarreto);

        panelContingut.add(scrollPaneTipusResidu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 700, 350));

        buttonValidarRecollida.setBackground(new java.awt.Color(51, 204, 0));
        buttonValidarRecollida.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonValidarRecollida.setForeground(new java.awt.Color(255, 255, 255));
        buttonValidarRecollida.setText("Validar recollida i pagar saldo");
        buttonValidarRecollida.setToolTipText("Validar recollida i pagar saldo");
        buttonValidarRecollida.setBorderPainted(false);
        buttonValidarRecollida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonValidarRecollida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValidarRecollidaActionPerformed(evt);
            }
        });
        panelContingut.add(buttonValidarRecollida, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 690, 260, 30));

        panelPrincipal.add(panelContingut, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 798, 746));

        panelOpcions.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcions.setOpaque(false);
        panelOpcions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonAltra.setBackground(new java.awt.Color(255, 204, 0));
        buttonAltra.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonAltra.setText("Altra recollida");
        buttonAltra.setToolTipText("Altra recollida");
        buttonAltra.setActionCommand("Altra recollida");
        buttonAltra.setBorderPainted(false);
        buttonAltra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAltra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAltraActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonAltra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 150, 30));

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
    
    /**
     * Mètode per carregar el model del jtable.
     */
    private void carregarModel(){
        // Afegim el model a la taula
        model = new DefaultTableModel(){
             @Override 
             public boolean isCellEditable(int row, int column){
                 return false;
             }
        };
        model.addColumn("Id");
        model.addColumn("Nom");
        model.addColumn("Quantitat");
        model.addColumn("Valor");
        model.addColumn("Total");
        jTableCarreto.setRowSelectionAllowed(true);
        jTableCarreto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableCarreto.setModel(model);
        jTableCarreto.setRowHeight(28);
        jTableCarreto.getTableHeader().setPreferredSize(new java.awt.Dimension(40,40));
        jTableCarreto.getTableHeader().setBackground(new Color(51,102,255));
        jTableCarreto.getTableHeader().setForeground(new Color(255,255,255));
        jTableCarreto.getColumnModel().getColumn(0).setCellRenderer(RenderitzatsTaules.centrat());
        jTableCarreto.getColumnModel().getColumn(0).setMaxWidth(50);
        jTableCarreto.getColumnModel().getColumn(0).setMinWidth(50);
        jTableCarreto.getColumnModel().getColumn(1).setCellRenderer(RenderitzatsTaules.centrat());
        jTableCarreto.getColumnModel().getColumn(2).setCellRenderer(RenderitzatsTaules.centrat());
        jTableCarreto.getColumnModel().getColumn(3).setCellRenderer(RenderitzatsTaules.centrat());
        jTableCarreto.getColumnModel().getColumn(4).setCellRenderer(RenderitzatsTaules.centrat());
        
    }
    
    /**
     * Mètode per carregar les arrays de tipus de residus i residus.
     */
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
                llistatResidus.add(new String[]{jsonResidu.getString("id_residu"),jsonResidu.getString("nom_residu"),jsonResidu.getString("id_tipus_residu"),jsonResidu.getString("valor_residu")});
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
        
        // Afegim sempre el tots
        comboBoxTipus.addItem("Tots");
        
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
                if(llistatResidus.get(i)[2].equals(idTipus)){
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
    private void buttonValidarRecollidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValidarRecollidaActionPerformed
        
        // Enviem les dades del carreto en format json a l'api
        DecimalFormat df = new DecimalFormat("#.####");
        String json = "{";
        json += "\"usuari\":\""+ idUsuariRecollida +"\",";
        json += "\"punt\":\""+ idPuntRecollida +"\",";
        json += "\"total\":\""+ df.format(totalCarreto) +"\",";
        json += "\"llistat\":[";
        int cont = 0;
        for(String[] e : carreto){
            if(cont!=0){ json += ","; }
            json += "{";
            json += "\"id_residu\":\""+ e[0] +"\",";
            json += "\"quantitat\":\""+ df.format(Double.parseDouble(e[1])) +"\",";
            json += "\"valor\":\""+ df.format(Double.parseDouble(e[2])) +"\"";
            json += "}";
            cont++;
        }
        json += "]}";
        
        // Enviem a l'api
        JSONObject enviamentCarreto = Api.recollida(usuari, json);
        if(enviamentCarreto.getString("codi_error").equals("0")){
            // Resetejem
            model.setRowCount(0);
            totalCarreto = 0;
            labelTotal.setText(String.valueOf(totalCarreto));
            carreto.clear();
            carregarTipuResidus();
            carregarResidus("0");
            textFieldQuantitat.setText("");
            // Correcte, mostrem missatge
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(enviamentCarreto.get("descripcio").toString());
            pantallaAdvertencia.setVisible(true);
        }else{
            // Error en la crida a l'api
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(enviamentCarreto.get("codi_error").toString() + " - " +enviamentCarreto.get("error").toString());
            pantallaAdvertencia.setVisible(true);
        }

    }//GEN-LAST:event_buttonValidarRecollidaActionPerformed

    /**
     * Mètode quan es selecciona un item del combo tipus residus
     * @param evt (ActionEvent) seleccionar un item del combo
     */ 
    private void comboBoxTipusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTipusActionPerformed
        
        // Seleccionem el id tipus seleccionat
        if(comboBoxTipus.getSelectedItem()!= null){
            String tipus = comboBoxTipus.getSelectedItem().toString();
            String codi = "0";
            for(String[] e : llistatTipusResidus){
                if(e[1].equals(tipus)){
                    codi = e[0];
                    break;
                }
            }
            
            // Ja tenim el codi (o 0 si no s'ha trobat) i carreguem el combo de residus.
            carregarResidus(codi);  
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
     * Mètode quan es pulsa el botó de afegir residu al carretó
     * @param evt (ActionEvent) pulsar el botó.
     */
    private void buttonAfegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAfegirActionPerformed
        
        // Comprovem que el residu seleccionat i la quantitat son correctes per poder afegir-ho.
        boolean afegir = true;
        String residuSeleccionat = comboBoxResidus.getSelectedItem().toString();
        String quantitatSeleccionada = textFieldQuantitat.getText();
        String valor = "0";
        String codi = "0";
        double total = 0;
        
        for(String[] e : llistatResidus){
            if(e[1].equals(residuSeleccionat)){
                codi = e[0];
                valor = e[3];
                break;
            }
         }
        
        // Comprovem residu
        if(codi.equals("0")){
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia("No i ha un residu seleccionat o no és vàlid.");
            pantallaAdvertencia.setVisible(true);
            afegir = false;
        }
        
        // Comprovem quantitat
        if(!Utils.validarDecimal(quantitatSeleccionada)){
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia("La quantitat informada no és correcta o no és un número vàlid.");
            pantallaAdvertencia.setVisible(true);
            afegir = false;
        }
        
        // Fem el total
        try{    
            total = Double.parseDouble(quantitatSeleccionada) * Double.parseDouble(valor);
        } catch(NumberFormatException ex){
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia("El valor total del residu a posar és erroni.");
            pantallaAdvertencia.setVisible(true);
            afegir = false;
        }
        
        // Si tot és correcte afegim al llistat.
        if(afegir){
            DecimalFormat df = new DecimalFormat("#.####");
            // Afegim el producte al llistat.
            carreto.add(new String[]{codi,quantitatSeleccionada,valor});
            model.addRow(new Object[]{codi,residuSeleccionat,quantitatSeleccionada,valor,df.format(total)});
            totalCarreto += total;
            labelTotal.setText(String.valueOf(df.format(totalCarreto)));
            textFieldQuantitat.setText("");
        }
        
        
    }//GEN-LAST:event_buttonAfegirActionPerformed

    /**
     * Mètode quan es pulsa el botó de treure residu del carretó
     * @param evt (ActionEvent) pulsar el botó.
     */
    private void buttonTreureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTreureActionPerformed
        // Mirem si tenim seleccionat fila del llistat 
        int filaSeleccionada = jTableCarreto.getSelectedRow();
        if(filaSeleccionada != -1){
            
            // Agafem el nom del residu i la quantitat de la fila seleccionada per elimarla de la llista carreto
            String idResidu = jTableCarreto.getModel().getValueAt(filaSeleccionada, 0).toString();
            String quantitatResidu = jTableCarreto.getModel().getValueAt(filaSeleccionada, 2).toString();
            
            // Agafem el valor total de la columna i el restem al total
            totalCarreto -= Double.parseDouble(jTableCarreto.getModel().getValueAt(filaSeleccionada, 4).toString().replace(",", "."));
           
            // Pintem el label
             DecimalFormat df = new DecimalFormat("#.####");
            labelTotal.setText(String.valueOf(df.format(totalCarreto)));
            
            // Treiem l'item de la llista carretó
            for(int i=0; i<carreto.size(); i++) {
                
               if(carreto.get(i)[0].equals(idResidu) && carreto.get(i)[1].equals(quantitatResidu)){
                    carreto.remove(i);
                    break;
                } 
            }
            
            // Eliminem del jtable
            model.removeRow(filaSeleccionada);
            model.fireTableDataChanged();
            
            
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error(16));
            pantallaAdvertencia.setVisible(true);
        }
    }//GEN-LAST:event_buttonTreureActionPerformed

    /**
     * Mètode utilitzat quan es pulsa el botó d'altra recollida
     * @param evt (ActionEvent) pulsar botó
     */
    private void buttonAltraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAltraActionPerformed
        PantallaRecollidaIdentificacio pantallaRecollidaIdentificacio = new PantallaRecollidaIdentificacio(usuari);
        pantallaRecollidaIdentificacio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonAltraActionPerformed

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
    * Botó per afegir residu al carretó
    */
    private javax.swing.JButton buttonAfegir;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonAltra;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornarPantallaPrincipal1;
    /**
    * Botó per treure residu del carretó.
    */
    private javax.swing.JButton buttonTreure;
    /**
    * Botó per recollir
    */
    private javax.swing.JButton buttonValidarRecollida;
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
    private javax.swing.JTable jTableCarreto;
    /**
    * label carretó residus
    */
    private javax.swing.JLabel labelCarreto;
    /**
    * Label per contenir el logo de l'aplicació.
    */
    private javax.swing.JLabel labelPrincipal;
    /**
    * label quantitat
    */
    private javax.swing.JLabel labelQuantitat;
    /**
    * label residus
    */
    private javax.swing.JLabel labelResidus;
    /**
    * label tipus residus
    */
    private javax.swing.JLabel labelTipusResidus;
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