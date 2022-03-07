
package frontend;

/**
 *
 * @author CIROSS
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonIngresoApuestas = new javax.swing.JButton();
        jButtonResultados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuNuevaCarrera = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonIngresoApuestas.setText("Ingreso de Apuestas");
        jButtonIngresoApuestas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresoApuestasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIngresoApuestas, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 112, -1, -1));

        jButtonResultados.setText("Resultados");
        jButtonResultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResultadosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(217, 170, -1, -1));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setEnabled(false);
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -28, 400, 530));

        jMenuBar.setBackground(new java.awt.Color(204, 204, 255));

        jMenuNuevaCarrera.setText("Archivo");

        jMenuItem1.setText("Nueva Carrera");
        jMenuNuevaCarrera.add(jMenuItem1);

        jMenuBar.add(jMenuNuevaCarrera);

        setJMenuBar(jMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIngresoApuestasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresoApuestasActionPerformed
        IngresoApuestas ingreso = new IngresoApuestas();
        ingreso.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonIngresoApuestasActionPerformed

    private void jButtonResultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResultadosActionPerformed
        Resultados result = new Resultados();
        result.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonResultadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIngresoApuestas;
    private javax.swing.JButton jButtonResultados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jMenuNuevaCarrera;
    // End of variables declaration//GEN-END:variables
}