/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Graphene;

import Axis.Axis;
import Axis.AxisPoint;
import Axis.AxisPoints;
import Functions.InterperateFunction;
import Functions.Points;
import Line.Lines;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author luxformel
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    
    private AxisPoints axisPoints;
    private AxisPoint axisPoint;
    
    public MainFrame() {
        initComponents();
        functionTextField.setText("");
        drawPanel.setTypeOfAxis("Down");
        normalRadioButton.setSelected(true);
        drawPanel.setAxisPoints(axisPoints);
    }
    
    public void updateView(){
        drawPanel.setAxisPoints(axisPoints);
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        axisButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        functionButton = new javax.swing.JButton();
        downRadioButton = new javax.swing.JRadioButton();
        upRadioButton = new javax.swing.JRadioButton();
        normalRadioButton = new javax.swing.JRadioButton();
        drawAxisButton = new javax.swing.JButton();
        functionTextField = new javax.swing.JTextField();
        fromSpinnerX = new javax.swing.JSpinner();
        toSpinnerX = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fromSpinnerY = new javax.swing.JSpinner();
        toSpinnerY = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        drawPanel = new Graphene.DrawPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jExportMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Graphlux");

        functionButton.setText("Show function");
        functionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                functionButtonActionPerformed(evt);
            }
        });

        axisButtonGroup.add(downRadioButton);
        downRadioButton.setText("Down");

        axisButtonGroup.add(upRadioButton);
        upRadioButton.setText("Up");

        axisButtonGroup.add(normalRadioButton);
        normalRadioButton.setText("Normal");

        drawAxisButton.setText("Draw Axis");
        drawAxisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawAxisButtonActionPerformed(evt);
            }
        });

        functionTextField.setText("jTextField1");

        jLabel2.setText("From:");

        jLabel3.setText("To:");

        jLabel4.setText("X");

        jLabel5.setText("To:");

        jLabel6.setText("Y");

        jLabel7.setText("From:");

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 968, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jExportMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jExportMenuItem.setText("Export");
        jExportMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExportMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(jExportMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(functionTextField)
                            .addComponent(functionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(downRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(normalRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(upRadioButton))
                                    .addComponent(drawAxisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fromSpinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(80, 80, 80)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(toSpinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fromSpinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addGap(80, 80, 80)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(toSpinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(drawPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(downRadioButton)
                            .addComponent(normalRadioButton)
                            .addComponent(upRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drawAxisButton)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel4)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fromSpinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toSpinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fromSpinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toSpinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addComponent(functionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(functionButton)
                        .addGap(68, 68, 68)
                        .addComponent(clearButton)
                        .addGap(0, 113, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void functionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_functionButtonActionPerformed
        // TODO add your handling code here:
        Lines.clear();
        Points.clear();
        System.out.println("Hello World!");
        String function = functionTextField.getText();
        int fromX = (int) fromSpinnerX.getValue();
        int toX = (int) toSpinnerX.getValue();
        InterperateFunction.interperate(function, fromX, toX);
        drawPanel.setDrawLines(true);
        updateView();
        System.out.println("number of lines: " + Lines.size());
    }//GEN-LAST:event_functionButtonActionPerformed

    private void drawAxisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawAxisButtonActionPerformed
        // TODO add your handling code here:
        // sets X
        Axis.setFromX((int) fromSpinnerX.getValue());
        Axis.setToX((int) toSpinnerX.getValue());
        Axis.calculateXDistance();
        
        
        // sets Y 
        Axis.setFromY((int) fromSpinnerY.getValue());
        Axis.setToY((int) toSpinnerY.getValue());
        Axis.calculateYDistance();
        
        // draws the appropriate Axis
        if (downRadioButton.isSelected()) {
            drawPanel.setTypeOfAxis("Down");
        }else if (upRadioButton.isSelected()) {
            drawPanel.setTypeOfAxis("Up");
        }else if (normalRadioButton.isSelected()) {
            drawPanel.setTypeOfAxis("Normal");
        }
        updateView();
    }//GEN-LAST:event_drawAxisButtonActionPerformed

    private void jExportMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExportMenuItemActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Save Your function as .png");
        
        int response = fileChooser.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null) {
                // Save button clicked without selecting a file
                String fileName = fileChooser.getSelectedFile().getName();
                File newFile = new File(fileChooser.getCurrentDirectory(), fileName);
                System.out.println("New file: " + newFile.getAbsolutePath());
                
                String path = selectedFile.getAbsolutePath() + ".png";
                ImageGenerator.exportAsPNG(drawPanel, path);
            }   
        }
    }//GEN-LAST:event_jExportMenuItemActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        Lines.clear();
        Points.clear();
        updateView();   
    }//GEN-LAST:event_clearButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup axisButtonGroup;
    private javax.swing.JButton clearButton;
    private javax.swing.JRadioButton downRadioButton;
    private javax.swing.JButton drawAxisButton;
    private Graphene.DrawPanel drawPanel;
    private javax.swing.JSpinner fromSpinnerX;
    private javax.swing.JSpinner fromSpinnerY;
    private javax.swing.JButton functionButton;
    private javax.swing.JTextField functionTextField;
    private javax.swing.JMenuItem jExportMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton normalRadioButton;
    private javax.swing.JSpinner toSpinnerX;
    private javax.swing.JSpinner toSpinnerY;
    private javax.swing.JRadioButton upRadioButton;
    // End of variables declaration//GEN-END:variables
}