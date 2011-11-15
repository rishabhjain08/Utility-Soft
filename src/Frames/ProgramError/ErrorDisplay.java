
package Frames.ProgramError;

import Frames.ProgressBar;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

public class ErrorDisplay extends javax.swing.JFrame {
    private Troubleshoot action;
    private Report rep;
    private ProgressBar bar;
    private StackTraceElement[] stack=null;
    private List <String>replist;
    public ErrorDisplay(String s){
        initComponents();
        error.setText("Error ID : "+s);
        replist=new LinkedList();
        replist.add(s);
    }
    public void setWarning(String s){
        warning.setText(s);
        warning.setForeground(Color.red);
    }
    public void setStackTraceElement(StackTraceElement[] l){
        stack=l;
    }
    public ErrorDisplay() {
        initComponents();
    }
    public void addAdditionalReporting(String s){
        replist.add(s);
    }
    public void addTroubleshootAction(Troubleshoot t){
        action=t;
    }
    public void addReportAction(Report t){
        rep=t;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        error = new javax.swing.JLabel();
        reportButton = new javax.swing.JButton();
        ignoreButton = new javax.swing.JButton();
        warning = new javax.swing.JLabel();
        troubleshootButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        error.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        reportButton.setText("Report");
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });

        ignoreButton.setText("Ignore");
        ignoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ignoreButtonActionPerformed(evt);
            }
        });

        warning.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        warning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        warning.setText("Please Contact your Service Provider");

        troubleshootButton.setText("Troubleshoot");
        troubleshootButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                troubleshootButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(troubleshootButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ignoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(warning, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
            .addComponent(error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {exitButton, ignoreButton, reportButton, troubleshootButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warning, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(reportButton)
                    .addComponent(troubleshootButton)
                    .addComponent(exitButton)
                    .addComponent(ignoreButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-654)/2, (screenSize.height-156)/2, 654, 156);
    }// </editor-fold>//GEN-END:initComponents

    private void troubleshootButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_troubleshootButtonActionPerformed
        this.troubleshoot();
    }//GEN-LAST:event_troubleshootButtonActionPerformed

    public void troubleshoot(){
        bar=new ProgressBar();
        bar.start();
        TakeTroubleshootAction act=new TakeTroubleshootAction();
        act.setBar(bar);
        act.start();
        dispose();
    }
    private class TakeReportingAction extends Thread{
            ProgressBar bari;
            @Override
            public void run(){
                if(rep!=null)
                    rep.reportAction();
                bari.dispose();
            }
            public void setBar(ProgressBar b){
                bari=b;
            }
    }
    private class TakeTroubleshootAction extends Thread{
            ProgressBar bari;
            @Override
            public void run(){
                if(action!=null)
                    action.doAction();
                bari.dispose();
            }
            public void setBar(ProgressBar b){
                bari=b;
            }
    }
    private void ignoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ignoreButtonActionPerformed
        dispose();
    }//GEN-LAST:event_ignoreButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        this.report();
    }//GEN-LAST:event_reportButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed
    public void report(){
        bar=new ProgressBar();
        bar.start();
        TakeReportingAction act=new TakeReportingAction();
        act.setBar(bar);
        act.start();
        dispose();
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ErrorDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error;
    public javax.swing.JButton exitButton;
    public javax.swing.JButton ignoreButton;
    public javax.swing.JButton reportButton;
    public javax.swing.JButton troubleshootButton;
    public javax.swing.JLabel warning;
    // End of variables declaration//GEN-END:variables

}
