/*
 * ParticleSimView.java
 */

package particlesim;

//import com.sun.xml.internal.bind.v2.model.core.ClassInfo;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.clapper.util.classutil.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.DefaultListModel;

/**
 * The application's main frame.
 * @author Sheppe
 */
public class ParticleSimView extends FrameView {
    // Used for running the calculations and drawing routines in a background thread.
    DrawParticles draw;

    // For persisting the user selected particle type.
    String sSelectedParticle = "";

    // For dynamically loading particle classes.
    ClassLoader loader = this.getClass().getClassLoader();
    
    /**
     *
     * @param app
     */
    public ParticleSimView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        /*progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        }
        )*/

        // Call the routine to populate the particle combobox.
        PopulateParticleCombo();
    }

    /**
     *
     */
    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = ParticleSimApp.getApplication().getMainFrame();
            aboutBox = new ParticleSimAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        ParticleSimApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbPType = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jtNumP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlChars = new javax.swing.JList();
        jbRun = new javax.swing.JButton();
        glGraphics = new javax.media.opengl.GLCanvas();
        jElecFieldLabel = new javax.swing.JLabel();
        jtElecFld = new javax.swing.JTextField();
        jcDoLog = new javax.swing.JCheckBox();
        jtPSizeX = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtPSizeY = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPolarizabilityLabel = new javax.swing.JLabel();
        jPolarizabilityParallelLabel = new javax.swing.JLabel();
        jPolarizabilityParallelText = new javax.swing.JTextField();
        jPolarizabilityPerpLabel = new javax.swing.JLabel();
        jPolarizabilityPerpText = new javax.swing.JTextField();
        jMobilityLabel = new javax.swing.JLabel();
        jMobilityParallelLabel = new javax.swing.JLabel();
        jMobilityParallelText = new javax.swing.JTextField();
        jMobilityPerpLabel = new javax.swing.JLabel();
        jMobilityPerpText = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jmRun = new javax.swing.JCheckBoxMenuItem();
        jmLoad = new javax.swing.JMenuItem();
        jmSave = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        jlFps = new javax.swing.JLabel();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(particlesim.ParticleSimApp.class).getContext().getResourceMap(ParticleSimView.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jcbPType.setFont(resourceMap.getFont("jcbPType.font")); // NOI18N
        jcbPType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(particlesim.ParticleSimApp.class).getContext().getActionMap(ParticleSimView.class, this);
        jcbPType.setAction(actionMap.get("ParticleTypeSelected")); // NOI18N
        jcbPType.setEditor(null);
        jcbPType.setName("jcbPType"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jtNumP.setText(resourceMap.getString("jtNumP.text")); // NOI18N
        jtNumP.setName("jtNumP"); // NOI18N
        jtNumP.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jtNumPInputMethodTextChanged(evt);
            }
        });

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jlChars.setName("jlChars"); // NOI18N
        jlChars.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlCharsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jlChars);

        jbRun.setText(resourceMap.getString("jbRun.text")); // NOI18N
        jbRun.setName("jbRun"); // NOI18N
        jbRun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRunMouseClicked(evt);
            }
        });

        glGraphics.setName("glGraphics"); // NOI18N

        jElecFieldLabel.setText(resourceMap.getString("jElecFieldLabel.text")); // NOI18N
        jElecFieldLabel.setName("jElecFieldLabel"); // NOI18N

        jtElecFld.setText(resourceMap.getString("jtElecFld.text")); // NOI18N
        jtElecFld.setName("jtElecFld"); // NOI18N

        jcDoLog.setText(resourceMap.getString("jcDoLog.text")); // NOI18N
        jcDoLog.setToolTipText(resourceMap.getString("jcDoLog.toolTipText")); // NOI18N
        jcDoLog.setName("jcDoLog"); // NOI18N

        jtPSizeX.setText(resourceMap.getString("jtPSizeX.text")); // NOI18N
        jtPSizeX.setName("jtPSizeX"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jtPSizeY.setText(resourceMap.getString("jtPSizeY.text")); // NOI18N
        jtPSizeY.setName("jtPSizeY"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jPolarizabilityLabel.setText(resourceMap.getString("jPolarizabilityLabel.text")); // NOI18N
        jPolarizabilityLabel.setName("jPolarizabilityLabel"); // NOI18N

        jPolarizabilityParallelLabel.setText(resourceMap.getString("jPolarizabilityParallelLabel.text")); // NOI18N
        jPolarizabilityParallelLabel.setName("jPolarizabilityParallelLabel"); // NOI18N

        jPolarizabilityParallelText.setText(resourceMap.getString("jPolarizabilityParallelText.text")); // NOI18N
        jPolarizabilityParallelText.setName("jPolarizabilityParallelText"); // NOI18N

        jPolarizabilityPerpLabel.setText(resourceMap.getString("jPolarizabilityPerpLabel.text")); // NOI18N
        jPolarizabilityPerpLabel.setName("jPolarizabilityPerpLabel"); // NOI18N

        jPolarizabilityPerpText.setText(resourceMap.getString("jPolarizabilityPerpText.text")); // NOI18N
        jPolarizabilityPerpText.setName("jPolarizabilityPerpText"); // NOI18N

        jMobilityLabel.setText(resourceMap.getString("jMobilityLabel.text")); // NOI18N
        jMobilityLabel.setName("jMobilityLabel"); // NOI18N

        jMobilityParallelLabel.setText(resourceMap.getString("jMobilityParallelLabel.text")); // NOI18N
        jMobilityParallelLabel.setName("jMobilityParallelLabel"); // NOI18N

        jMobilityParallelText.setText(resourceMap.getString("jMobilityParallelText.text")); // NOI18N
        jMobilityParallelText.setName("jMobilityParallelText"); // NOI18N

        jMobilityPerpLabel.setText(resourceMap.getString("jMobilityPerpLabel.text")); // NOI18N
        jMobilityPerpLabel.setName("jMobilityPerpLabel"); // NOI18N

        jMobilityPerpText.setText(resourceMap.getString("jMobilityPerpText.text")); // NOI18N
        jMobilityPerpText.setName("jMobilityPerpText"); // NOI18N

        org.jdesktop.layout.GroupLayout mainPanelLayout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup()
                .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jtElecFld, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jElecFieldLabel))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jtNumP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel5))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jtPSizeX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jtPSizeY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPolarizabilityLabel))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPolarizabilityParallelLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPolarizabilityParallelText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPolarizabilityPerpLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPolarizabilityPerpText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                    .add(mainPanelLayout.createSequentialGroup()
                        .add(71, 71, 71)
                        .add(jbRun))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jcDoLog))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel3))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jcbPType, 0, 220, Short.MAX_VALUE))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel1))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jMobilityLabel))
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jMobilityParallelLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jMobilityParallelText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jMobilityPerpLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jMobilityPerpText, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(glGraphics, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 429, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup()
                .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jtNumP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel6)
                            .add(jtPSizeX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel7)
                            .add(jtPSizeY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jElecFieldLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jtElecFld, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPolarizabilityLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jPolarizabilityParallelLabel)
                            .add(jPolarizabilityParallelText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPolarizabilityPerpLabel)
                            .add(jPolarizabilityPerpText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jMobilityLabel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jMobilityParallelLabel)
                            .add(jMobilityParallelText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jMobilityPerpLabel)
                            .add(jMobilityPerpText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(15, 15, 15)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jcbPType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jcDoLog)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbRun))
                    .add(glGraphics, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 448, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jcDoLog.getAccessibleContext().setAccessibleName(resourceMap.getString("jCheckBox1.AccessibleContext.accessibleName")); // NOI18N
        jPolarizabilityLabel.getAccessibleContext().setAccessibleName(resourceMap.getString("jLabel8.AccessibleContext.accessibleName")); // NOI18N

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        jmRun.setText(resourceMap.getString("jmRun.text")); // NOI18N
        jmRun.setName("jmRun"); // NOI18N
        jmRun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmRunMouseClicked(evt);
            }
        });
        fileMenu.add(jmRun);

        jmLoad.setText(resourceMap.getString("jmLoad.text")); // NOI18N
        jmLoad.setName("jmLoad"); // NOI18N
        fileMenu.add(jmLoad);

        jmSave.setText(resourceMap.getString("jmSave.text")); // NOI18N
        jmSave.setName("jmSave"); // NOI18N
        fileMenu.add(jmSave);

        jSeparator1.setName("jSeparator1"); // NOI18N
        fileMenu.add(jSeparator1);

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        exitMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMenuItem_mouseClicked(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        jlFps.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlFps.setText(resourceMap.getString("jlFps.text")); // NOI18N
        jlFps.setName("jlFps"); // NOI18N

        org.jdesktop.layout.GroupLayout statusPanelLayout = new org.jdesktop.layout.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(statusPanelSeparator, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
            .add(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(statusMessageLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 659, Short.MAX_VALUE)
                .add(statusAnimationLabel)
                .addContainerGap())
            .add(statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(statusPanelLayout.createSequentialGroup()
                    .add(0, 328, Short.MAX_VALUE)
                    .add(jlFps)
                    .add(0, 329, Short.MAX_VALUE)))
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(statusPanelLayout.createSequentialGroup()
                .add(statusPanelSeparator, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 9, Short.MAX_VALUE)
                .add(statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(statusMessageLabel)
                    .add(statusAnimationLabel))
                .add(3, 3, 3))
            .add(statusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(statusPanelLayout.createSequentialGroup()
                    .add(0, 0, Short.MAX_VALUE)
                    .add(jlFps)
                    .add(0, 0, Short.MAX_VALUE)))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItem_mouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMenuItem_mouseClicked
        ParticleSimApp.getApplication().exit();
    }//GEN-LAST:event_exitMenuItem_mouseClicked

    private void jlCharsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlCharsValueChanged
        // Update the value in the jtCharMod textbox to reflect the selected item's value.
    }//GEN-LAST:event_jlCharsValueChanged

    private void jbRunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRunMouseClicked
        // Run the particle simulation.
        this.ToggleRunStop();
    }//GEN-LAST:event_jbRunMouseClicked

    private void jtNumPInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jtNumPInputMethodTextChanged
        // Only numeric values are allowed in the jtNumP textbox.
    }//GEN-LAST:event_jtNumPInputMethodTextChanged

    private void jmRunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmRunMouseClicked
        // Run the particle simulation.
        this.ToggleRunStop();
    }//GEN-LAST:event_jmRunMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.media.opengl.GLCanvas glGraphics;
    private javax.swing.JLabel jElecFieldLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jMobilityLabel;
    private javax.swing.JLabel jMobilityParallelLabel;
    private javax.swing.JTextField jMobilityParallelText;
    private javax.swing.JLabel jMobilityPerpLabel;
    private javax.swing.JTextField jMobilityPerpText;
    private javax.swing.JLabel jPolarizabilityLabel;
    private javax.swing.JLabel jPolarizabilityParallelLabel;
    private javax.swing.JTextField jPolarizabilityParallelText;
    private javax.swing.JLabel jPolarizabilityPerpLabel;
    private javax.swing.JTextField jPolarizabilityPerpText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbRun;
    private javax.swing.JCheckBox jcDoLog;
    private javax.swing.JComboBox jcbPType;
    private javax.swing.JList jlChars;
    public javax.swing.JLabel jlFps;
    private javax.swing.JMenuItem jmLoad;
    private javax.swing.JCheckBoxMenuItem jmRun;
    private javax.swing.JMenuItem jmSave;
    private javax.swing.JTextField jtElecFld;
    private javax.swing.JTextField jtNumP;
    private javax.swing.JTextField jtPSizeX;
    private javax.swing.JTextField jtPSizeY;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    /**
     * Parses through the classes in the project and populates the particles
     * combobox with the name of each class that implements the IParticle
     * interface.
     */
    private void PopulateParticleCombo()
    {
        try
        {
            // Populate the combo box with all of the classes that exist, which implement the IParticle interface.
            ClassFinder finder = new ClassFinder();
            finder.addClassPath();

            ClassFilter filter = new SubclassClassFilter(particlesim.IParticle.class);

            Collection<ClassInfo> foundClasses = new ArrayList<ClassInfo>();
            finder.findClasses (foundClasses, filter);

            for (ClassInfo classInfo : foundClasses)
            {
                this.jcbPType.addItem(classInfo.getClassName()); //.substring(classInfo.getClassName().lastIndexOf(".")+1));
            }
        }
        catch(Exception ex)
        {
        }
    }

    /**
     * Executes when the user selects an item in the particles combobox.
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Action
    public void ParticleTypeSelected() throws InstantiationException, IllegalAccessException {
        // Persist the selected value to the sSelectedParticle class variable.
        sSelectedParticle = this.jcbPType.getSelectedItem().toString();

        if(sSelectedParticle.equals("particlesim.ChargedParticle")) {
            this.jMobilityLabel.setVisible(false);
            this.jMobilityParallelLabel.setVisible(false);
            this.jMobilityPerpLabel.setVisible(false);
            this.jMobilityParallelText.setVisible(false);
            this.jMobilityPerpText.setVisible(false);
            this.jPolarizabilityLabel.setVisible(false);
            this.jPolarizabilityParallelLabel.setVisible(false);
            this.jPolarizabilityPerpLabel.setVisible(false);
            this.jPolarizabilityParallelText.setVisible(false);
            this.jPolarizabilityPerpText.setVisible(false);
            this.jtElecFld.setVisible(false);
            this.jElecFieldLabel.setVisible(false);
        }
        else
        {
            this.jMobilityLabel.setVisible(true);
            this.jMobilityParallelLabel.setVisible(true);
            this.jMobilityPerpLabel.setVisible(true);
            this.jMobilityParallelText.setVisible(true);
            this.jMobilityPerpText.setVisible(true);
            this.jPolarizabilityLabel.setVisible(true);
            this.jPolarizabilityParallelLabel.setVisible(true);
            this.jPolarizabilityPerpLabel.setVisible(true);
            this.jPolarizabilityParallelText.setVisible(true);
            this.jPolarizabilityPerpText.setVisible(true);
            this.jtElecFld.setVisible(true);
            this.jElecFieldLabel.setVisible(true);
        }

        // Load and initialize the selected particle type.
        Class p = null;
        try {
            p = Class.forName(sSelectedParticle);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ParticleSimView.class.getName()).log(Level.SEVERE, null, ex);
        }

        IParticle ip = null;
        Class cl = null;
        Object ob = null;
        try {
            // Load the selected particle class and fill the characteristics
            // into the characteristics listbox.
            cl = loader.loadClass(sSelectedParticle);
            ob = cl.newInstance();
            ip = ((IParticle)ob);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ParticleSimView.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultListModel list = new DefaultListModel();
        this.jlChars.setModel(list);

        for(int i=0;i<ip.getCharacteristic().length;i++)
        {
            list.addElement(ip.getCharacteristic()[i].getCharacteristicType().getName());
        }
    }

    /**
     * Creates and initialized an array of particles based on the user's
     * selections and entries. After initializing the array, it creates a
     * background thread and execute the calculation routine associated with
     * the user's selections.
     */
    private void DoRun() throws InstantiationException, IllegalAccessException
    {
        // An array of particles to pass between this and that.
        sSelectedParticle = this.jcbPType.getSelectedItem().toString();
        particlesim.IParticle[] parts = null;

        // Instantiate the Calculate class for the selected particle type
        // and have it create the number particles indicated by the user.
        IParticle ip = null;
        ICalculate ic = null;
        IParticleSize ips = null;

        //Extra value arrays for each particle type
        int[] chargedExtras = new int[0];
        int[] elecFieldExtras = new int[5];

        Class cl = null;
        Object ob = null;
        try {
            // Load the selected particle class and fill the characteristics
            // into the characteristics listbox.
            cl = loader.loadClass(sSelectedParticle);
            ob = cl.newInstance();
            ip = ((IParticle)ob);
            cl = loader.loadClass(ip.getCalcName());
            ob = cl.newInstance();
            ic = ((ICalculate)ob);
            cl = loader.loadClass(ip.getParticleSizeName());
            ob = cl.newInstance();
            ips = ((IParticleSize)ob);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ParticleSimView.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Set the size of the particles based on the user input.
        ips.setParticleSizeX(Integer.parseInt(this.jtPSizeX.getText()));
        ips.setParticleSizeY(Integer.parseInt(this.jtPSizeY.getText()));

        // Initialize the particle array.
        if(sSelectedParticle.equals("particlesim.ChargedParticle")) {
            parts = ic.InitializeParticles(Integer.parseInt(this.jtNumP.getText()), this.glGraphics.getWidth(), this.glGraphics.getHeight(), 0, ips, chargedExtras);
        }
        else if(sSelectedParticle.equals("particlesim.ElecFieldParticle")) {

            elecFieldExtras[0] = Integer.parseInt(this.jtElecFld.getText());
            elecFieldExtras[1] = Integer.parseInt(this.jPolarizabilityParallelText.getText());
            elecFieldExtras[2] = Integer.parseInt(this.jPolarizabilityPerpText.getText());
            elecFieldExtras[3] = Integer.parseInt(this.jMobilityParallelText.getText());
            elecFieldExtras[4] = Integer.parseInt(this.jMobilityPerpText.getText());

            parts = ic.InitializeParticles(Integer.parseInt(this.jtNumP.getText()), this.glGraphics.getWidth(), this.glGraphics.getHeight(), 0, ips, elecFieldExtras);
        }



        // In a new thread, launch the routine that handles the drawing and calculating of forces and positions.
        draw = new DrawParticles(this.glGraphics, parts, this.jcDoLog.isSelected());
        draw.FpsLabel = this.jlFps;

        try {
            /* Uncomment below line to debug the DrawParticles class variable.
             * This is neccessary because threads outside of this one (the EDT)
             * cannot be debugged. Be sure to comment out the draw.execute();
             * line if you do this. */
            //draw.doInBackground();

            // Start the draw/calculation routine in a separate thread. It is
            // done this way because the intense calculations lock up the
            // interface otherwise.
            draw.execute();
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ParticleSimView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Toggles the running state of particle calculations and displays.
     */
    private void ToggleRunStop()
    {
        if(this.jbRun.getText().equals("Run"))
        {
            this.jbRun.setText("Stop");
            try {
                this.DoRun();
            } catch (InstantiationException ex) {
                Logger.getLogger(ParticleSimView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ParticleSimView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            this.jbRun.setText("Run");
            draw.cancel(true);
            draw = null;
        }
    }
}
