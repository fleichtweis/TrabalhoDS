/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.programaofflineui;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
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
    public int    idEntrada;
    public String cpfProf;
    public int tamanhoAluno=1;
    List raiz = new ArrayList(1);                    
    List <Turmas> turmazin = new ArrayList(1);
    List <Aluno> alunozin = new ArrayList(tamanhoAluno);                    
    List <Testes> testezin = new ArrayList(1);
    
    public CadastroAlunosUI() {
        initComponents();
        importarXML();
    }
    public CadastroAlunosUI(String cpfProfessor){
        initComponents();
        importarXML();
        this.cpfProf=cpfProfessor;
    }
    
    //@XStreamAlias("listaXML")
    public static class listaXML{
        @XStreamAlias("professor")
	private String professorCPF;    
        
	private Collection<Turmas> turmas = new ArrayList<Turmas>();
	private Collection<Testes> testes = new ArrayList<Testes>();

	public String getCpf(){
		return this.professorCPF;
	}
	public void setCpf(String cpf){
		this.professorCPF = cpf;
	}
	
	public Collection<Turmas> getTurmas(){
		return turmas;
	}
	public void setTurmas(Collection<Turmas> turma){
		turmas=turma;
	}
	
	public Collection<Testes> getTestes(){
		return testes;
	}
	public void setTestes(Collection<Testes> teste){
		testes=teste;
	}
    }
    //@XStreamAlias("Turmas")
    public static class Turmas{
	private int idTurma;
      //  @XStreamImplicit(itemFieldName = "alunosTurmas")  
	private Collection<Aluno> alunosTurmas = new ArrayList<Aluno>();
	
	public int getIdTurma(){
		return this.idTurma;
	}
	public void setIdTurma(int IdTurma){
		this.idTurma = IdTurma;
	}
	public Collection<Aluno> getAlunos(){
		return alunosTurmas;
	}
	public void setAlunos(Collection<Aluno> aluno){
		alunosTurmas = aluno;
	}
    }    
    //@XStreamAlias("Aluno")
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
    //@XStreamAlias("Testes")
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
        jButton2 = new javax.swing.JButton();

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

        jButton2.setText("Cadastrar Teste >>");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
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
        String mostra;
        String nomeArquivo = "Arquivo.xml"; //Nome do arquivo, pode ser absoluto, ou pastas /dir/teste.xml
        String idXML,nomeXML,cpfXML,rgXML,nomePaiXML,nomeMaeXML,sexoXML;
        File arq = new File(nomeArquivo);
        
        if(arq.exists()){
            try{ //tentando ler o arquivo
                //Abrindo arquivo para leitura
                FileReader reader = new FileReader(nomeArquivo);
                //leitor do arquivo texto (ponteiro)
                BufferedReader leitor = new BufferedReader(reader);

                leitor.readLine(); //<?xml version
                leitor.readLine(); //<list
                leitor.readLine(); //<Lista
                leitor.readLine(); //<turmas class
                leitor.readLine(); //<turma
                leitor.readLine(); //<id turma
                leitor.readLine(); //<alunos turmas class
                while(true){
                    mostra = leitor.readLine(); //<aluno>
                    if (mostra != "<aluno>"){ //Acabou alunos na turma, verifica se tem outra turma.
                        leitor.readLine(); //</turma>
                        mostra = leitor.readLine(); //<turma>
                        if (mostra != "<turma>"){ //Nao existe outra turma, logo nao tem aluno.
                            break;
                        }
                        leitor.readLine(); //<idTurma
                        leitor.readLine(); //<alunosTurmas class
                        leitor.readLine(); //<aluno>
                    }
                    idXML = leitor.readLine(); //<id>01</id>
                    nomeXML = leitor.readLine();
                    rgXML = leitor.readLine();
                    cpfXML = leitor.readLine();
                    sexoXML = leitor.readLine();
                    nomePaiXML = leitor.readLine();
                    nomeMaeXML = leitor.readLine();
                    idXML=idXML.substring(idXML.indexOf(">")+1,idXML.indexOf("/")-1); //pegando entre as tags
                    nomeXML=nomeXML.substring(nomeXML.indexOf(">")+1,nomeXML.indexOf("/")-1);
                    rgXML=rgXML.substring(rgXML.indexOf(">")+1,rgXML.indexOf("/")-1);
                    cpfXML=cpfXML.substring(cpfXML.indexOf(">")+1,cpfXML.indexOf("/")-1);
                    sexoXML=sexoXML.substring(sexoXML.indexOf(">")+1,sexoXML.indexOf("/")-1);
                    nomePaiXML=nomePaiXML.substring(nomePaiXML.indexOf(">")+1,nomePaiXML.indexOf("/")-1);
                    nomeMaeXML=nomeMaeXML.substring(nomeMaeXML.indexOf(">")+1,nomeMaeXML.indexOf("/")-1);
                    leitor.readLine(); //</aluno>
                    
                    //Colocar na tabela
                    DefaultTableModel modeloTabelaXML = (DefaultTableModel)jTable1.getModel();  
                    modeloTabelaXML.addRow( new String [] {"", ""+nomeXML,""} );
                }
            }catch(Exception erro){}
        }    
    }
    
    private static void salvarArquivo(String documento, String file) {
        File path = new File("C:\\devmedia\\GitHub\\TrabalhoDS\\ProgramaOffline\\" + file);
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.println(
            "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?>"
            );          
            writer.println(documento);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
    
    private void bttCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttCadastrarMouseClicked
        if(evt.getSource() == bttCadastrar){
            String nomeArquivo = "Arquivo.xml";
            File arq = new File(nomeArquivo);
            XStream xstream = new XStream();
            listaXML lista = new listaXML();
            Turmas turma = new  Turmas();
            Testes testes = new Testes();
            Aluno aluno = new Aluno();

            //ALUNO
            aluno.setId(tamanhoAluno);
            aluno.setNome(txtNome.getText());
            aluno.setRg(txtRg.getText());
            aluno.setCpf(txtCpf.getText());
            aluno.setNomePai(txtNomePai.getText());
            aluno.setNomeMae(txtNomeMae.getText());
            aluno.setSexo(cmbSexo.getSelectedItem());
            xstream.alias("aluno", Aluno.class);
            alunozin.add(aluno);
            //Turma
            turma.setIdTurma(1);
            turma.setAlunos(alunozin);
            xstream.alias("turma",Turmas.class);
            turmazin.add(turma);
            //TESTE
            testes.setAbdominal("90");
            testes.setImc("80");
            //...
            testezin.add(testes);
            xstream.alias("teste",Testes.class);

            //ListaRaiz
            lista.setTurmas(turmazin);
            lista.setTestes(testezin);
            raiz.add(lista);
            xstream.alias("Lista",listaXML.class);
            
            String documento = xstream.toXML(raiz);
            salvarArquivo(documento,nomeArquivo);
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            
            DefaultTableModel modeloTabela = (DefaultTableModel)jTable1.getModel();  
            modeloTabela.addRow( new String [] {"", ""+txtNome.getText(),""} );
            txtNome.setText(null);
            txtNomeMae.setText(null);
            txtNomePai.setText(null);
            txtRg.setText(null);
            txtCpf.setText(null);
            cmbSexo.setSelectedItem(null);
            evt.setSource(null);
            tamanhoAluno++;
        }
    }//GEN-LAST:event_bttCadastrarMouseClicked

    private void bttCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCadastrarActionPerformed

    }//GEN-LAST:event_bttCadastrarActionPerformed

    
    
    private void txtDtNascimentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDtNascimentoKeyTyped
        
    }//GEN-LAST:event_txtDtNascimentoKeyTyped

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
            if(evt.getSource() == jButton1){
                dispose();
                TelaPrincipal tela = new TelaPrincipal(cpfProf);
                tela.setVisible(true);
                tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
            }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
            if(evt.getSource() == jButton2){
                dispose();
                CadastroTestes tela = new CadastroTestes(cpfProf,idEntrada);    
                tela.setVisible(true);
                tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
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
