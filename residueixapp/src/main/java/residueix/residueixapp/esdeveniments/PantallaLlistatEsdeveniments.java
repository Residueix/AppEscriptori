package residueix.residueixapp.esdeveniments;

// Imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import residueix.residueixapp.principal.PantallaAdvertencia;
import residueix.residueixapp.principal.PantallaPrincipal;
import residueix.residueixapp.models.Usuari;
import residueix.residueixapp.utils.Api;
import residueix.residueixapp.utils.RenderitzatsImatges;
import residueix.residueixapp.utils.RenderitzatsTaules;
import residueix.residueixapp.utils.Utils;


/**
 * Classe per obrir la pantalla del llistat d'esdeveniments
 * @author Daniel Garcia Ruiz
 * @version 12/05/2023
 */
public class PantallaLlistatEsdeveniments extends javax.swing.JFrame {
    
    
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
     * String per contenir els missatges de problemes
     */
    private String problemes;
    /**
     * Arraylist amb totes les dades d'esdeveniments
     */
    private ArrayList<HashMap<String,Object>> llistatEsdeveniments;

    /**
     * Crea una nova instància de la classe PantallaLlistatEsdeveniments
     * @param usuari: Usuari loginat a l'aplicació.
     */
    public PantallaLlistatEsdeveniments(Usuari usuari) {
        // Assignació de l'usuari
        this.usuari = usuari;
        // Inicialització dels components
        initComponents();
        // Centrem pantalla
        centrarPantalla();
        // Accions en funcio de l'usuari
        gestioUsuari();        
        // Recuperar totes les dades necesàries per la gestió d'esdeveniments.
        recuperarDades();
        // Omplir el formulari amb les dades de llistatEsdeveniments
        omplirFormulari("","","");
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
        scrollPaneTipusResidu = new javax.swing.JScrollPane();
        jTablePunts = new javax.swing.JTable();
        comboBoxValors = new javax.swing.JComboBox<>();
        comboBoxActiu = new javax.swing.JComboBox<>();
        comboBoxPoblacions = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        labelFiltres = new javax.swing.JLabel();
        panelOpcions = new javax.swing.JPanel();
        buttonTornarPrincipal = new javax.swing.JButton();
        buttonAlta = new javax.swing.JButton();
        buttonLogOut = new javax.swing.JButton();
        buttonModificacio = new javax.swing.JButton();
        buttonAssistents = new javax.swing.JButton();
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
        labelTitol.setText("Llistat Esdeveniments");
        labelTitol.setToolTipText("");
        panelTitol.add(labelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 600, 30));

        panelContingut.add(panelTitol, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 51, 800, 50));

        scrollPaneTipusResidu.setBackground(new java.awt.Color(255, 255, 255));
        scrollPaneTipusResidu.setBorder(null);
        scrollPaneTipusResidu.setOpaque(false);

        jTablePunts.setAutoCreateRowSorter(true);
        jTablePunts.setFont(new java.awt.Font("Sansation", 0, 14)); // NOI18N
        jTablePunts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePunts.setToolTipText("Llistat punts de recollda");
        jTablePunts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTablePunts.setRowHeight(28);
        jTablePunts.setRowMargin(5);
        jTablePunts.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTablePunts.setShowGrid(true);
        jTablePunts.setShowVerticalLines(false);
        scrollPaneTipusResidu.setViewportView(jTablePunts);

        panelContingut.add(scrollPaneTipusResidu, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 210, 700, 510));

        comboBoxValors.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        comboBoxValors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tots els valors" }));
        comboBoxValors.setToolTipText("Filtrar per tipus d'usuari");
        comboBoxValors.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboBoxValors.setPreferredSize(new java.awt.Dimension(200, 30));
        comboBoxValors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxValorsActionPerformed(evt);
            }
        });
        panelContingut.add(comboBoxValors, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        comboBoxActiu.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        comboBoxActiu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tots els esdeveniments", "Esdeveniments actius", "Esdeveniments de baixa" }));
        comboBoxActiu.setToolTipText("Filtre actiu");
        comboBoxActiu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboBoxActiu.setPreferredSize(new java.awt.Dimension(200, 30));
        comboBoxActiu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActiuActionPerformed(evt);
            }
        });
        panelContingut.add(comboBoxActiu, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, -1, -1));

        comboBoxPoblacions.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        comboBoxPoblacions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Totes les poblacions" }));
        comboBoxPoblacions.setToolTipText("Filtrar per tipus d'usuari");
        comboBoxPoblacions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboBoxPoblacions.setPreferredSize(new java.awt.Dimension(200, 30));
        comboBoxPoblacions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPoblacionsActionPerformed(evt);
            }
        });
        panelContingut.add(comboBoxPoblacions, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));
        panelContingut.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 610, -1));

        labelFiltres.setFont(new java.awt.Font("Sansation", 0, 12)); // NOI18N
        labelFiltres.setText("Filtres");
        panelContingut.add(labelFiltres, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        panelPrincipal.add(panelContingut, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 798, 746));

        panelOpcions.setBackground(new java.awt.Color(255, 255, 255));
        panelOpcions.setOpaque(false);
        panelOpcions.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonTornarPrincipal.setBackground(new java.awt.Color(255, 204, 0));
        buttonTornarPrincipal.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonTornarPrincipal.setText("Pantalla principal");
        buttonTornarPrincipal.setToolTipText("Tornar a la pantalla principal");
        buttonTornarPrincipal.setBorderPainted(false);
        buttonTornarPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonTornarPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTornarPrincipalActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonTornarPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 150, 30));

        buttonAlta.setBackground(new java.awt.Color(51, 102, 255));
        buttonAlta.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonAlta.setForeground(new java.awt.Color(255, 255, 255));
        buttonAlta.setText("Alta");
        buttonAlta.setToolTipText("Alta esdeveniment");
        buttonAlta.setBorderPainted(false);
        buttonAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAltaActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, 150, 30));

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

        buttonModificacio.setBackground(new java.awt.Color(51, 102, 255));
        buttonModificacio.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonModificacio.setForeground(new java.awt.Color(255, 255, 255));
        buttonModificacio.setText("Modificar");
        buttonModificacio.setToolTipText("Modificació esdeveniment");
        buttonModificacio.setBorderPainted(false);
        buttonModificacio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonModificacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificacioActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonModificacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 70, 150, 30));

        buttonAssistents.setBackground(new java.awt.Color(51, 102, 255));
        buttonAssistents.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonAssistents.setForeground(new java.awt.Color(255, 255, 255));
        buttonAssistents.setText("Assistents");
        buttonAssistents.setToolTipText("Assistents");
        buttonAssistents.setBorderPainted(false);
        buttonAssistents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonAssistents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAssistentsActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonAssistents, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 150, 150, 30));

        buttonBaixa.setBackground(new java.awt.Color(51, 102, 255));
        buttonBaixa.setFont(new java.awt.Font("Sansation", 1, 14)); // NOI18N
        buttonBaixa.setForeground(new java.awt.Color(255, 255, 255));
        buttonBaixa.setText("Baixa");
        buttonBaixa.setToolTipText("Baixa esdeveniment");
        buttonBaixa.setBorderPainted(false);
        buttonBaixa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonBaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBaixaActionPerformed(evt);
            }
        });
        panelOpcions.add(buttonBaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 110, 150, 30));

        panelPrincipal.add(panelOpcions, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 2, 200, 746));

        labelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        labelPrincipal.setIcon(new javax.swing.ImageIcon("C:\\Users\\isard\\Downloads\\fons_general.png")); // NOI18N
        labelPrincipal.setOpaque(true);
        panelPrincipal.add(labelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 996, 746));

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
     * Mètode per recuperar dades via api i ficar-les a un arraylist per poder tractar-les posteriorment.
     */
    private void recuperarDades(){
        
        llistatEsdeveniments = new ArrayList();
        
        // Recuperem el llistat d'esdeveniments
        JSONObject jsonEsdeveniments = Api.llistatEsdeveniments();
        
        if(jsonEsdeveniments.getString("codi_error").equals("0")){
            
            JSONArray arrayEsdeveniments = new JSONArray(jsonEsdeveniments.getJSONArray("llistat"));
            
            // Recorrem l'array per ficar-ho a l'arraylist llistatEsdeveniments
            for(int i = 0; i < arrayEsdeveniments.length(); i++){
                
                JSONObject jsonEsdeveniment = arrayEsdeveniments.getJSONObject(i);
               
                HashMap<String,Object> esdeveniment = new HashMap<String,Object>();
                esdeveniment.put("id", jsonEsdeveniment.getString("id"));
                esdeveniment.put("nom", jsonEsdeveniment.getString("nom"));
                esdeveniment.put("descripcio", jsonEsdeveniment.getString("descripcio"));
                esdeveniment.put("imatge", jsonEsdeveniment.getString("imatge"));
                esdeveniment.put("valor", jsonEsdeveniment.getString("valor"));
                esdeveniment.put("idPoblacio", jsonEsdeveniment.getString("idPoblacio"));
                esdeveniment.put("data", jsonEsdeveniment.getString("data"));
                esdeveniment.put("actiu", jsonEsdeveniment.getString("actiu"));
                esdeveniment.put("aforament", jsonEsdeveniment.getString("aforament"));
                esdeveniment.put("nomPoblacio", jsonEsdeveniment.getString("nomPoblacio"));
                esdeveniment.put("idProvincia", jsonEsdeveniment.getString("idProvincia"));
                esdeveniment.put("nomProvincia", jsonEsdeveniment.getString("nomProvincia"));
                llistatEsdeveniments.add(esdeveniment);
                
            }
            
        }else{
            // Hi ha un error posem a null la variable i creem problemes.s
            this.problemes += " - " + jsonEsdeveniments.getString("error") + " ";
        }
        
    }
    
    /**
     * Mètode per omplir la taula amb les dades dels usuaris.
     */
    private void omplirFormulari(String valor, String poblacio, String actiu){
        if(valor.equals("Tots els valors")){ valor = ""; }
        if(poblacio.equals("Totes les poblacions")){ poblacio = ""; }
        if(actiu.equals("Tots els esdeveniments")){ actiu = ""; }
        if(actiu.equals("Tots els esdeveniments")){ actiu = ""; }
        if(actiu.equals("Esdeveniments actius")){ actiu = "1"; }
        if(actiu.equals("Esdeveniments de baixa")){ actiu = "0"; }
        
        // Omplim el combobox de valors
        if(llistatEsdeveniments != null){
            for(int i = 0; i < llistatEsdeveniments.size(); i++){
                HashMap<String,Object> element = llistatEsdeveniments.get(i);
                // Comprovem si en el combobox ja existeix. recorrem i si trobem coincidencia ho indiquem.
                int index = -1;
                for(int x = 0; x < comboBoxValors.getItemCount(); x++){
                    if(comboBoxValors.getItemAt(x).equals(element.get("valor").toString())){
                        index = x;
                        break;
                    }
                }
                if(index==-1){
                 comboBoxValors.addItem(element.get("valor").toString());    
                }
            }
        }
        
        // Omplim el combobox de poblacions
        if(llistatEsdeveniments != null){
            for(int i = 0; i < llistatEsdeveniments.size(); i++){
                HashMap<String,Object> element = llistatEsdeveniments.get(i);
                // Comprovem si en el combobox ja existeix. recorrem i si trobem coincidencia ho indiquem.
                int index = -1;
                for(int x = 0; x < comboBoxPoblacions.getItemCount(); x++){
                    if(comboBoxPoblacions.getItemAt(x).equals(element.get("nomPoblacio").toString())){
                        index = x;
                        break;
                    }
                }
                if(index==-1){
                 comboBoxPoblacions.addItem(element.get("nomPoblacio").toString());    
                }
            }
        }
        
        // Afegim el model a la taula
        DefaultTableModel model = new DefaultTableModel(){
             @Override 
             public boolean isCellEditable(int row, int column){
                 return false;
             }
        };
        model.addColumn("Id");
        model.addColumn("Nom");
        model.addColumn("Data");
        model.addColumn("Imatge");
        jTablePunts.setRowSelectionAllowed(true);
        jTablePunts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTablePunts.setModel(model);
        jTablePunts.setRowHeight(80);
        jTablePunts.getTableHeader().setPreferredSize(new java.awt.Dimension(40,40));
        jTablePunts.getTableHeader().setBackground(new Color(51,102,255));
        jTablePunts.getTableHeader().setForeground(new Color(255,255,255));
        jTablePunts.getColumnModel().getColumn(0).setCellRenderer(RenderitzatsTaules.centrat());
        jTablePunts.getColumnModel().getColumn(0).setMaxWidth(50);
        jTablePunts.getColumnModel().getColumn(0).setMinWidth(50);
        jTablePunts.getColumnModel().getColumn(1).setCellRenderer(RenderitzatsTaules.centrat());
        jTablePunts.getColumnModel().getColumn(2).setCellRenderer(RenderitzatsTaules.centrat());
        //jTablePunts.getColumnModel().getColumn(2).setMaxWidth(50);
        //jTablePunts.getColumnModel().getColumn(2).setMinWidth(50);
        jTablePunts.getColumnModel().getColumn(3).setCellRenderer(new RenderitzatsImatges());
        jTablePunts.getColumnModel().getColumn(3).setMaxWidth(150);
        jTablePunts.getColumnModel().getColumn(3).setMinWidth(150);
        
        // Omplim la taula amb les dades
        if(llistatEsdeveniments != null){
            
           // Definim l'estat en funció delque ens arriba
            String estat = "000";
            switch(valor){
                case  "": switch(poblacio){ case "": switch(actiu){ case "": estat = "000"; break; default: estat = "001"; break; } break; default: switch(actiu){ case "": estat = "010"; break; default: estat = "011"; break; } break; } break;
                default: switch(poblacio){ case "": switch(actiu){ case "": estat = "100"; break; default: estat = "101"; break; } break; default: switch(actiu){ case "": estat = "110"; break; default: estat = "111"; break;  } break; } break;
            }
            
            for(int i = 0; i < llistatEsdeveniments.size(); i++){
                HashMap<String,Object> element = llistatEsdeveniments.get(i);
                
                switch(estat){
                    case "001":
                        if(element.get("actiu").equals(actiu)){
                            model.addRow( new Object[]{
                                element.get("id"),
                                element.get("nom"),
                                element.get("data"),
                                RenderitzatsTaules.cellaImatge((String) element.get("imatge"),4)           
                            });
                        }
                    break;
                    case "010":
                        if(element.get("nomPoblacio").equals(poblacio)){
                            model.addRow( new Object[]{
                                element.get("id"),
                                element.get("nom"),
                                element.get("data"),
                                RenderitzatsTaules.cellaImatge((String) element.get("imatge"),4)           
                            });
                        }
                    break;
                    case "011":
                        if(element.get("nomPoblacio").equals(poblacio)){
                        if(element.get("actiu").equals(actiu)){
                            model.addRow( new Object[]{
                                element.get("id"),
                                element.get("nom"),
                                element.get("data"),
                                RenderitzatsTaules.cellaImatge((String) element.get("imatge"),4)           
                            });
                        }}
                    break;
                    case "100":
                        if(element.get("valor").equals(valor)){
                            model.addRow( new Object[]{
                                element.get("id"),
                                element.get("nom"),
                                element.get("data"),
                                RenderitzatsTaules.cellaImatge((String) element.get("imatge"),4)           
                            });
                        }
                    break;
                    case "101":
                        if(element.get("valor").equals(valor)){
                        if(element.get("actiu").equals(actiu)){
                            model.addRow( new Object[]{
                                element.get("id"),
                                element.get("nom"),
                                element.get("data"),
                                RenderitzatsTaules.cellaImatge((String) element.get("imatge"),4)           
                            });
                        }}
                    break;
                    case "110":
                        if(element.get("valor").equals(valor)){
                        if(element.get("nomPoblacio").equals(poblacio)){
                            model.addRow( new Object[]{
                                element.get("id"),
                                element.get("nom"),
                                element.get("data"),
                                RenderitzatsTaules.cellaImatge((String) element.get("imatge"),4)           
                            });
                        }}
                    break;
                    case "111":
                        if(element.get("valor").equals(valor)){
                        if(element.get("nomPoblacio").equals(poblacio)){
                        if(element.get("actiu").equals(actiu)){
                            model.addRow( new Object[]{
                                element.get("id"),
                                element.get("nom"),
                                element.get("data"),
                                RenderitzatsTaules.cellaImatge((String) element.get("imatge"),4)           
                            });
                        }}}
                    break;
                    case "000":
                    default:
                        model.addRow( new Object[]{
                            element.get("id"),
                            element.get("nom"),
                            element.get("data"),
                            RenderitzatsTaules.cellaImatge((String) element.get("imatge"),4)           
                        });
                    break;
                }
            }
            
        }
        
        
    }
    
    /**
     * Mètode per capturar la x i y del mouse quan el deixem pulsat sobre el frame principal.
     * @param evt MouseEvent: event de deixar pulsat el botó del ratolí.
     */
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Assignem Coordenades del ratolí
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    /**
     * Mètode executat quan movem el mouse amb el formulari pulsat. 
     * @param evt MouseEvent: event quan arroseguem amb el ratolí.
     */
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // Capturem  x i y i assignem la nova localització
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    /**
     * Mètode utilitzat quan es prem el botó de tornar a la pantalla principal.
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonTornarPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTornarPrincipalActionPerformed
        // Obre la pantalla principal
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(usuari);
        pantallaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonTornarPrincipalActionPerformed

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
     * Mètode utilitzat quan es prem el botó d'alta esdeveniment
     * @param evt ActionEvent: Pulsar el botó.
     */
    private void buttonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAltaActionPerformed
        // Obrim la pantalla d'alta tipus residu
        PantallaAltaEsdeveniment pantallaAltaEsdeveniment  = new PantallaAltaEsdeveniment (usuari);
        pantallaAltaEsdeveniment .setVisible(true);
        this.dispose();
                
    }//GEN-LAST:event_buttonAltaActionPerformed

    /**
     * Mètode utilitzat quan es prem el botó baixa d'usari
     * @param evt  (ActionEvent) : Pulsar el botó.
     */
    private void buttonAssistentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAssistentsActionPerformed
        // Mirem si tenim seleccionat fila del llistat 
        int filaSeleccionada = jTablePunts.getSelectedRow();
        if(filaSeleccionada != -1){
            // Agafem el id seleccionat
            int idEsdeveniment = Integer.parseInt(jTablePunts.getModel().getValueAt(filaSeleccionada, 0).toString());
            // Obrim pantalla baixa tipus residu
            PantallaAssistentsEsdeveniment pantallaAssistentsEsdeveniment = new PantallaAssistentsEsdeveniment(usuari,idEsdeveniment);
            pantallaAssistentsEsdeveniment.setVisible(true);
            this.dispose();
        }else{
            // Missatge error (no seleccionada)
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error(19));
            pantallaAdvertencia.setVisible(true);
        }
        
    }//GEN-LAST:event_buttonAssistentsActionPerformed

    /**
     * Métode utilitzat quan es prem el botó de modificar punt de recollida
     * @param evt (ActionEvent) : pulsar el botó.
     */
    private void buttonModificacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificacioActionPerformed
        // Mirem si tenim seleccionat fila del llistat 
        int filaSeleccionada = jTablePunts.getSelectedRow();
        if(filaSeleccionada != -1){
            // Afafem el id seleccionat
            int idEsdeveniment = Integer.parseInt(jTablePunts.getModel().getValueAt(filaSeleccionada, 0).toString());
            PantallaModificarEsdeveniment pantallaModificarEsdeveniment = new PantallaModificarEsdeveniment(usuari,idEsdeveniment);
            pantallaModificarEsdeveniment.setVisible(true);
            this.dispose();
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error(19));
            pantallaAdvertencia.setVisible(true);
        }
    }//GEN-LAST:event_buttonModificacioActionPerformed

    private void buttonBaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBaixaActionPerformed
        // Mirem si tenim seleccionat fila del llistat 
        int filaSeleccionada = jTablePunts.getSelectedRow();
        if(filaSeleccionada != -1){
            // Afafem el id seleccionat
            int idEsdeveniment = Integer.parseInt(jTablePunts.getModel().getValueAt(filaSeleccionada, 0).toString());
            PantallaBaixaEsdeveniment pantallaBaixaEsdeveniment = new PantallaBaixaEsdeveniment(usuari,idEsdeveniment);
            pantallaBaixaEsdeveniment.setVisible(true);
            this.dispose();
        }else{
            PantallaAdvertencia pantallaAdvertencia = new PantallaAdvertencia(Utils.error(19));
            pantallaAdvertencia.setVisible(true);
        }
    }//GEN-LAST:event_buttonBaixaActionPerformed
    
    /**
     * Mètode quan es canvia la selecció del combobox poblacions
     * @param evt (Action event) canviar la selecció.
     */
    private void comboBoxPoblacionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPoblacionsActionPerformed
        omplirFormulari(comboBoxValors.getSelectedItem().toString(),comboBoxPoblacions.getSelectedItem().toString(),comboBoxActiu.getSelectedItem().toString());
    }//GEN-LAST:event_comboBoxPoblacionsActionPerformed

    /**
     * Mètode quan es canvia la selecció del combobox valors
     * @param evt (Action event) canviar la selecció.
     */
    private void comboBoxValorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxValorsActionPerformed
        omplirFormulari(comboBoxValors.getSelectedItem().toString(),comboBoxPoblacions.getSelectedItem().toString(),comboBoxActiu.getSelectedItem().toString());
    }//GEN-LAST:event_comboBoxValorsActionPerformed

    /**
     * Mètode quan es canvia la selecció del combobox actiu
     * @param evt (Action event) canviar la selecció.
     */
    private void comboBoxActiuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActiuActionPerformed
        omplirFormulari(comboBoxValors.getSelectedItem().toString(),comboBoxPoblacions.getSelectedItem().toString(),comboBoxActiu.getSelectedItem().toString());
    }//GEN-LAST:event_comboBoxActiuActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaLlistatEsdeveniments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaLlistatEsdeveniments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaLlistatEsdeveniments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaLlistatEsdeveniments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new PantallaLlistatEsdeveniments(usuari).setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /**
    * Botó per donar d'alta un usuari
    */
    private javax.swing.JButton buttonAlta;
    /**
    * Botó per veure els assistents d'un esdeveniment
    */
    private javax.swing.JButton buttonAssistents;
    /**
    * Botó per donar de baixa un esdeveniment
    */
    private javax.swing.JButton buttonBaixa;
    /**
    * Botó per desloginar-se i sortir de l'aplicació.
    */
    private javax.swing.JButton buttonLogOut;
    /**
    * Botó per modificar un esdeveniment
    */
    private javax.swing.JButton buttonModificacio;
    /**
    * Botó per tornar a la pantalla principal.
    */
    private javax.swing.JButton buttonTornarPrincipal;
    /**
    * Combo box actiu
    */
    private javax.swing.JComboBox<String> comboBoxActiu;
    /**
    * Combo box poblacions
    */
    private javax.swing.JComboBox<String> comboBoxPoblacions;
    /**
    * Combo box valors
    */
    private javax.swing.JComboBox<String> comboBoxValors;
    /**
    * Separador
    */
    private javax.swing.JSeparator jSeparator1;
    /**
    * Taula per contenir els esdeveniments
    */
    private javax.swing.JTable jTablePunts;
    /**
    * Label titol filtres
    */
    private javax.swing.JLabel labelFiltres;
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
    * Scroll pane per contenir el jtable
    */
    private javax.swing.JScrollPane scrollPaneTipusResidu;
    // End of variables declaration//GEN-END:variables
}