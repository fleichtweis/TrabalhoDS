/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.programaofflineui;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mohammad
 */
public class CadastroAlunosUI extends javax.swing.JFrame {

    /**
     * Creates new form CadastroAlunosUI
     */
    public CadastroAlunosUI() {
        initComponents();
        importarXML();
    }

    public static class Aluno {
        public int    id=0;
	private String nome;
        private String dtNascimento;
        private String rg;
        private String cpf;
        private String sexo;
	private String nomePai;
        private String nomeMae;
        
        public void setId(int id){
            this.id+=id;
        }
        public void setNome(String nome){
            this.nome=nome;
        }
        public void setSexo(Object sexo){
            this.sexo = sexo.toString();
        }
        public void setDtNascimento(String dtNascimento){
            this.dtNascimento=dtNascimento;
        }
        public void setRg(String rg){
            this.rg=rg;
        }
        public void setCpf(String cpf){
            this.cpf=cpf;
        }
        public void setNomePai(String nomePai){
            this.nomePai=nomePai;
        }
        public void setNomeMae(String nomeMae){
            this.nomeMae = nomeMae;
        }
        public String getNome(){
            return this.nome;
        }
        public int getId(){
            return this.id;
        }
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        bttCadastrar = new javax.swing.JButton();
        txtDtNascimento = new com.toedter.calendar.JDateChooser();
        cmbSexo = new javax.swing.JComboBox();
        txtCpf = new javax.swing.JTextField();
        txtRg = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtNomePai = new javax.swing.JTextField();
        Nome = new javax.swing.JLabel();
        txtNomeMae = new javax.swing.JTextField();
        Sexo = new javax.swing.JLabel();
        Cpf = new javax.swing.JLabel();
        Rg = new javax.swing.JLabel();
        NomePai = new javax.swing.JLabel();
        NomeMae = new javax.swing.JLabel();
        DtNascimento = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        bttCadastrar.setText("Cadastrar");
        bttCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttCadastrarMouseClicked(evt);
            }
        });
        bttCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCadastrarActionPerformed(evt);
            }
        });

        txtDtNascimento.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtDtNascimento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDtNascimentoKeyTyped(evt);
            }
        });

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ","Masculino","Feminino" }));

        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCpfKeyTyped(evt);
            }
        });

        txtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        Nome.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Nome.setText("Nome: ");

        txtNomeMae.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeMaeActionPerformed(evt);
            }
        });

        Sexo.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Sexo.setText("Sexo: ");

        Cpf.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Cpf.setText("CPF: ");

        Rg.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Rg.setText("RG: ");

        NomePai.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        NomePai.setText("Nome do Pai: ");

        NomeMae.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        NomeMae.setText("Nome da Mãe: ");

        DtNascimento.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        DtNascimento.setText("Data de Nascimento: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(NomePai)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(NomeMae)
                                        .addGap(14, 14, 14)
                                        .addComponent(txtNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(DtNascimento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Rg, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(bttCadastrar)))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Rg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(bttCadastrar)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Alunos"));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Turma"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jScrollPane1, org.jdesktop.beansbinding.ELProperty.create("TRUE"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("autoscrolls"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton1.setText("Menu");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgActionPerformed

    private void txtCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyTyped
        char c = evt.getKeyChar();
        String cpfn = Cpf.getText();
        int tamCpf = cpfn.length();
        if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE || tamCpf>10){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCpfKeyTyped

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtNomeMaeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeMaeActionPerformed
        // TODO add your handling code here:
            
    }//GEN-LAST:event_txtNomeMaeActionPerformed

    private void importarXML(){
        String mostra="";
        String nomeArquivo = "Alunos.xml";
        String idXML,nomeXML,cpfXML,rgXML,nomePaiXML,nomeMaeXML,sexoXML;
        File arq = new File(nomeArquivo);
        
        if(arq.exists()){
            try{
                FileReader reader = new FileReader(nomeArquivo);
                //leitor do arquivo texto (ponteiro)
                BufferedReader leitor = new BufferedReader(reader);
                mostra+="id - nome - idade - rg - cpf - sexo - nomePai - nomeMae\n";
                leitor.readLine(); //list
                while(true){
                    leitor.readLine(); //<my.programaofflineui.CadastroAlunosUI_-Aluno>
                    idXML = leitor.readLine();
                    nomeXML = leitor.readLine();
                    rgXML = leitor.readLine();
                    cpfXML = leitor.readLine();
                    sexoXML = leitor.readLine();
                    nomePaiXML = leitor.readLine();
                    nomeMaeXML = leitor.readLine();
                    idXML=idXML.substring(idXML.indexOf(">")+1,idXML.indexOf("/")-1);
                    nomeXML=nomeXML.substring(nomeXML.indexOf(">")+1,nomeXML.indexOf("/")-1);
                    rgXML=rgXML.substring(rgXML.indexOf(">")+1,rgXML.indexOf("/")-1);
                    cpfXML=cpfXML.substring(cpfXML.indexOf(">")+1,cpfXML.indexOf("/")-1);
                    sexoXML=sexoXML.substring(sexoXML.indexOf(">")+1,sexoXML.indexOf("/")-1);
                    nomePaiXML=nomePaiXML.substring(nomePaiXML.indexOf(">")+1,nomePaiXML.indexOf("/")-1);
                    nomeMaeXML=nomeMaeXML.substring(nomeMaeXML.indexOf(">")+1,nomeMaeXML.indexOf("/")-1);
                    leitor.readLine();
                    
                    DefaultTableModel modeloTabelaXML = (DefaultTableModel)jTable1.getModel();  
                    modeloTabelaXML.addRow( new String [] {"", ""+nomeXML,""} );
                
                }
            }catch(Exception erro){}
        }    
    }
    
    private void bttCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttCadastrarMouseClicked
        String nomeArquivo = "Alunos.xml";
        File arq = new File(nomeArquivo);
        
        if(arq.exists()){
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        }else{
            if(evt.getSource() == bttCadastrar){
                XStream xstream = new XStream();
                Aluno aluno = new Aluno();
                List contatos = new ArrayList(1);

                //IMPORTAR E CONTINUAR DO XML
                aluno.setId(1);
                aluno.setNome(txtNome.getText());
                //aluno.setDtNascimento(txtDtNascimento.getCalendar());
                aluno.setRg(txtRg.getText());
                aluno.setCpf(txtCpf.getText());
                aluno.setNomePai(txtNomePai.getText());
                aluno.setNomeMae(txtNomeMae.getText());
                aluno.setSexo(cmbSexo.getSelectedItem());

                contatos.add(aluno);
                String contatosEmXML = xstream.toXML(contatos);
                System.out.println("\nContatos em XML:");  
                System.out.println(contatosEmXML);  

                FileOutputStream gravar;
                try {
                    gravar = new FileOutputStream(nomeArquivo);
                    gravar.write(xstream.toXML(contatos).getBytes());
                    gravar.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
                
                DefaultTableModel modeloTabela = (DefaultTableModel)jTable1.getModel();  
                modeloTabela.addRow( new String [] {"", ""+txtNome.getText(),""} );
                
                txtNome.setText(null);
                txtNomeMae.setText(null);
                txtNomePai.setText(null);
                txtRg.setText(null);
                txtCpf.setText(null);
                cmbSexo.setSelectedItem(null);
            }
        }
        evt.setSource(null);
    }//GEN-LAST:event_bttCadastrarMouseClicked

    private void bttCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCadastrarActionPerformed

    }//GEN-LAST:event_bttCadastrarActionPerformed

    
    
    private void txtDtNascimentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDtNascimentoKeyTyped
        
    }//GEN-LAST:event_txtDtNascimentoKeyTyped

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
            if(evt.getSource() == jButton1){
                dispose();
                TelaPrincipal tela = new TelaPrincipal();
                tela.setVisible(true);
                tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            }

    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(CadastroAlunosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAlunosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAlunosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAlunosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAlunosUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cpf;
    private javax.swing.JLabel DtNascimento;
    private javax.swing.JLabel Nome;
    private javax.swing.JLabel NomeMae;
    private javax.swing.JLabel NomePai;
    private javax.swing.JLabel Rg;
    private javax.swing.JLabel Sexo;
    private javax.swing.JButton bttCadastrar;
    private javax.swing.JComboBox cmbSexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCpf;
    private com.toedter.calendar.JDateChooser txtDtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeMae;
    private javax.swing.JTextField txtNomePai;
    private javax.swing.JTextField txtRg;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
