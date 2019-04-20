
package com;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * 
 */
public class UI extends javax.swing.JFrame {
    
                        String input_file;				
                        String tesseract_install_path = "C:\\Program Files (x86)\\Tesseract-OCR\\tesseract";
			String[] command =
		    {
		        "cmd",
		    };

    /**
     * Creates new form UI
     */
    public UI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        recognise = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        browse.setBackground(new java.awt.Color(51, 153, 255));
        browse.setFont(new java.awt.Font("Comic Sans MS", 2, 24)); // NOI18N
        browse.setText("Browse");
        browse.setToolTipText("click here to browse the image from the system");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 0, 0));
        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setText("Currency Recognizer");
        jLabel1.setAutoscrolls(true);

        recognise.setBackground(new java.awt.Color(51, 153, 255));
        recognise.setFont(new java.awt.Font("Comic Sans MS", 2, 24)); // NOI18N
        recognise.setText("Recognise");
        recognise.setToolTipText("Click here to get the result");
        recognise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recogniseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(browse, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recognise))
                    .addComponent(jLabel1))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browse, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recognise, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        // TODO add your handling code here:
           JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			input_file =selectedFile.getAbsolutePath();			
     }   
    }//GEN-LAST:event_browseActionPerformed

    private void recogniseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recogniseActionPerformed
        // TODO add your handling code here:      
        String filetext="";
        String output_file="";
        Process p;
			try {
				p = Runtime.getRuntime().exec(command);
			        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
		                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
		                PrintWriter stdin = new PrintWriter(p.getOutputStream());
                                if(input_file.contains(".jpg") || input_file.contains(".png")){
		                stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
		        	    stdin.close();
                                    stdin.flush();
                                    System.out.println("output after"+output_file);
		                p.waitFor();
                                filetext = Read_File.read_a_file(output_file+".txt");
                                Currency_Identifier CI = new Currency_Identifier();
                                CI.CICHECK(filetext);    
                                input_file = "";
                                output_file = "";
                                }
                                else{
                                     Currency_Identifier CI = new Currency_Identifier();
                                CI.CICHECK("406");
                                }
		    	} catch (Exception e) {
                            System.err.println("error");
		 		e.printStackTrace();
                                Currency_Identifier CI = new Currency_Identifier();
                                CI.CICHECK("");   
			}
    }//GEN-LAST:event_recogniseActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton recognise;
    // End of variables declaration//GEN-END:variables
}
