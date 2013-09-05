/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.programaofflineui;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JFrame;

/**
 *
 * @author Mohammad
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    private String cpfProf;
    
    public TelaPrincipal() {
        initComponents();
    }
    public TelaPrincipal(String cpfProfessor) {
        initComponents();
        this.cpfProf=cpfProfessor;
    }
    
    public static class listaXML{
        @XStreamAlias("professor")
	private String professorCPF;    
        
	private Collection<CadastroAlunosUI.Turmas> turmas = new ArrayList<CadastroAlunosUI.Turmas>();
	private Collection<CadastroAlunosUI.Testes> testes = new ArrayList<CadastroAlunosUI.Testes>();

	public String getCpf(){
		return this.professorCPF;
	}
	public void setCpf(String cpf){
		this.professorCPF = cpf;
	}
	
	public Collection<CadastroAlunosUI.Turmas> getTurmas(){
		return turmas;
	}
	public void setTurmas(Collection<CadastroAlunosUI.Turmas> turma){
		turmas=turma;
	}
	
	public Collection<CadastroAlunosUI.Testes> getTestes(){
		return testes;
	}
	public void setTestes(Collection<CadastroAlunosUI.Testes> teste){
		testes=teste;
	}
    }
    public static class Turmas{
	private int idTurma;
	private Collection<CadastroAlunosUI.Aluno> alunosTurmas = new ArrayList<CadastroAlunosUI.Aluno>();
	
	public int getIdTurma(){
		return this.idTurma;
	}
	public void setIdTurma(int IdTurma){
		this.idTurma = IdTurma;
	}
	public Collection<CadastroAlunosUI.Aluno> getAlunos(){
		return alunosTurmas;
	}
	public void setAlunos(Collection<CadastroAlunosUI.Aluno> aluno){
		alunosTurmas = aluno;
	}
    }    
    public static class Aluno {
        public int id=0;
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
    public static class Testes{
	private int idAluno;
        //SAUDE
	private String abdominal;
	private String imc;
	private String sentar_e_alcancar;
	private String sentar_e_alcancar_sb;
	private String nove_min_s;
	private String seis_min_s;
        //DESEMPENHO MOTOR
	private String arremeso_medicine_ball;
	private String corrida_20_m;
	private String quadrado;
	private String salto_dist;
	private String nove_min_dm;
	private String seis_min_dm;
        
        public void setIdAluno(int id){
            this.idAluno=id;
        }
        public int getIdAluno(){
            return this.idAluno;
        }        
        //SETTERS SAUDE
        public void setAbdominal(String abdominal){
            this.abdominal=abdominal;
        }
        public void setImc(String imc){
            this.imc=imc;
        }
        public void setSentarAlcancar(String sentaralcancar){
            this.sentar_e_alcancar=sentaralcancar;
        }
        public void setSentarAlcancarSb(String sentaralcancarsb){
            this.sentar_e_alcancar_sb=sentaralcancarsb;
        }
        public void setNoveMin(String novemin){
            this.nove_min_s=novemin;
        }
        public void setSeisMin(String seismin){
            this.seis_min_s=seismin;
        }
	
        //GETTERS SAUDE
        public String getAbdominal(){
            return this.abdominal;
        }
        public String getImc(){
            return this.imc;
        }
        public String getSentarAlcancar(){
            return this.sentar_e_alcancar;
        }
        public String getSentarAlcancarSb(){
            return this.sentar_e_alcancar_sb;
        }
        public String getNoveMin(){
            return this.nove_min_s;
        }
        public String getSeisMin(){
            return this.seis_min_s;
        }
        //SETTERS DESEMPENHO
        public void setArremesso(String arremesso){
            this.arremeso_medicine_ball=arremesso;
        }
        public void setcorrida_20_m(String corrida20m){
            this.corrida_20_m=corrida20m;
        }
        public void setQuadrado(String quadrad){
            this.quadrado=quadrad;
        }
        public void setSalto_dist(String salto){
            this.salto_dist=salto;
        }
        public void setNoveMinDm(String noveDm){
            this.nove_min_dm=noveDm;
        }
        public void setSeisMinDm(String seisDm){
            this.seis_min_dm=seisDm;
        }
        //GETTERS
        public String getArremesso(){
            return this.arremeso_medicine_ball;
        }
        public String getCorrida_20_m(){
            return this.corrida_20_m;
        }
        public String getQuadrado(){
            return this.quadrado;
        }
        public String getSalto_dist(){
            return this.salto_dist;
        }
        public String getNoveMinDm(){
            return this.nove_min_dm;
        }
        public String getSeisMinDm(){
            return this.seis_min_dm;
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

        jPanel1 = new javax.swing.JPanel();
        bttCadastroAluno = new javax.swing.JButton();
        bttCadastroTurma = new javax.swing.JButton();
        bttCadastroTeste = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        bttCadastroAluno.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        bttCadastroAluno.setText("Cadastrar Aluno  ");
        bttCadastroAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttCadastroAlunoMouseClicked(evt);
            }
        });
        bttCadastroAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCadastroAlunoActionPerformed(evt);
            }
        });

        bttCadastroTurma.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        bttCadastroTurma.setText("Cadastrar Turma");
        bttCadastroTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttCadastroTurmaMouseClicked(evt);
            }
        });
        bttCadastroTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCadastroTurmaActionPerformed(evt);
            }
        });

        bttCadastroTeste.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        bttCadastroTeste.setText("Cadastro de Teste");
        bttCadastroTeste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttCadastroTesteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bttCadastroTeste, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttCadastroAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttCadastroTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttCadastroAluno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttCadastroTeste)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttCadastroTurma)
                .addGap(26, 26, 26))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 133, Short.MAX_VALUE)
        );

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttCadastroAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttCadastroAlunoMouseClicked
        if(evt.getSource() == bttCadastroAluno){
            dispose();
            CadastroAlunosUI aluno = new CadastroAlunosUI(this.cpfProf);
            aluno.setVisible(true);
            aluno.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        }
    }//GEN-LAST:event_bttCadastroAlunoMouseClicked

    private void bttCadastroAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCadastroAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttCadastroAlunoActionPerformed

    private void bttCadastroTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttCadastroTurmaMouseClicked
        if(evt.getSource() == bttCadastroTurma){
            dispose();
            CadastroTurma turma = new CadastroTurma();
            turma.setVisible(true);
            turma.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        }
    }//GEN-LAST:event_bttCadastroTurmaMouseClicked

    private void bttCadastroTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCadastroTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bttCadastroTurmaActionPerformed

    private void bttCadastroTesteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttCadastroTesteMouseClicked
        if(evt.getSource() == bttCadastroTeste){
            dispose();
            CadastroTestes teste = new CadastroTestes();
            teste.setVisible(true);
            teste.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        }
    }//GEN-LAST:event_bttCadastroTesteMouseClicked

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttCadastroAluno;
    private javax.swing.JButton bttCadastroTeste;
    private javax.swing.JButton bttCadastroTurma;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
