/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.programaofflineui;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohammad
 */
public class CadastroTestes extends javax.swing.JFrame {

    private String cpfProf;
    public CadastroTestes() {
        initComponents();
    }
    
    public CadastroTestes(String cpfProfessor) {
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

        m_9_s = new javax.swing.JPanel();
        teste_s = new javax.swing.JLabel();
        avaliacao_s = new javax.swing.JLabel();
        classificacao_s = new javax.swing.JLabel();
        abdominal = new javax.swing.JLabel();
        imc = new javax.swing.JLabel();
        sentar_e_alcancar = new javax.swing.JLabel();
        sentar_e_alcancar_sb = new javax.swing.JLabel();
        nove_min_s = new javax.swing.JLabel();
        seis_min_s = new javax.swing.JLabel();
        txtAbdominal = new javax.swing.JTextField();
        txtIMC = new javax.swing.JTextField();
        txtSentar_e_alcancar = new javax.swing.JTextField();
        txtSentar_e_alcancar_sb = new javax.swing.JTextField();
        txtNove_min_s = new javax.swing.JTextField();
        txtSeis_min_s = new javax.swing.JTextField();
        classAbdominal = new javax.swing.JTextField();
        classIMC = new javax.swing.JTextField();
        classSentar_e_alcancar = new javax.swing.JTextField();
        classSentar_e_alcancar_sb = new javax.swing.JTextField();
        classNove_min_s = new javax.swing.JTextField();
        classSeis_min_s = new javax.swing.JTextField();
        qtde = new javax.swing.JLabel();
        kgm2 = new javax.swing.JLabel();
        cm_sea = new javax.swing.JLabel();
        cm_seasb = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        m_6_s = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        teste_dm = new javax.swing.JLabel();
        avaliacao_dm = new javax.swing.JLabel();
        classificacao_dm = new javax.swing.JLabel();
        arremesso_medicine_ball = new javax.swing.JLabel();
        corrida_20m = new javax.swing.JLabel();
        quadrado = new javax.swing.JLabel();
        salto_dist = new javax.swing.JLabel();
        nove_min_dm = new javax.swing.JLabel();
        seis_min_dm = new javax.swing.JLabel();
        txtArremesso_medicine_ball = new javax.swing.JTextField();
        txtCorrida_20m = new javax.swing.JTextField();
        txtQuadrado = new javax.swing.JTextField();
        txtSalto_dist = new javax.swing.JTextField();
        txtNove_min_dm = new javax.swing.JTextField();
        txtSeis_min_dm = new javax.swing.JTextField();
        m_6_dm = new javax.swing.JLabel();
        m_9_dm = new javax.swing.JLabel();
        cm_sd = new javax.swing.JLabel();
        s_qua = new javax.swing.JLabel();
        s_20m = new javax.swing.JLabel();
        cm_amb = new javax.swing.JLabel();
        classArremesso_medicine_ball = new javax.swing.JTextField();
        classCorrida_20m = new javax.swing.JTextField();
        classQuadrado = new javax.swing.JTextField();
        classtSalto_dist = new javax.swing.JTextField();
        classNove_min_dm = new javax.swing.JTextField();
        classSeis_min_dm = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        bttCadastrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        m_9_s.setBorder(javax.swing.BorderFactory.createTitledBorder("Avaliação Física relaciona à Saúde"));

        teste_s.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        teste_s.setText("Teste");

        avaliacao_s.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        avaliacao_s.setText("Avaliação");

        classificacao_s.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        classificacao_s.setText("Classificação");

        abdominal.setText("Abdominal");

        imc.setText("IMC");

        sentar_e_alcancar.setText("Sentar-e-Alcançar");

        sentar_e_alcancar_sb.setText("Sentar-e-Alcançar(sem banco)");

        nove_min_s.setText("9 minutos");

        seis_min_s.setText("6 minutos");

        txtAbdominal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAbdominalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAbdominalKeyTyped(evt);
            }
        });

        txtIMC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIMCKeyTyped(evt);
            }
        });

        txtSentar_e_alcancar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSentar_e_alcancarKeyTyped(evt);
            }
        });

        txtSentar_e_alcancar_sb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSentar_e_alcancar_sbKeyTyped(evt);
            }
        });

        txtNove_min_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNove_min_sKeyTyped(evt);
            }
        });

        txtSeis_min_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSeis_min_sKeyTyped(evt);
            }
        });

        classAbdominal.setEditable(false);

        classIMC.setEditable(false);

        classSentar_e_alcancar.setEditable(false);

        classSentar_e_alcancar_sb.setEditable(false);

        classNove_min_s.setEditable(false);

        classSeis_min_s.setEditable(false);

        qtde.setText("qtde");

        kgm2.setText("kg/m²");

        cm_sea.setText("cm");

        cm_seasb.setText("cm");

        jLabel14.setText("m");

        m_6_s.setText("m");

        javax.swing.GroupLayout m_9_sLayout = new javax.swing.GroupLayout(m_9_s);
        m_9_s.setLayout(m_9_sLayout);
        m_9_sLayout.setHorizontalGroup(
            m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(m_9_sLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imc)
                    .addComponent(abdominal)
                    .addComponent(sentar_e_alcancar)
                    .addComponent(sentar_e_alcancar_sb)
                    .addComponent(nove_min_s)
                    .addComponent(seis_min_s)
                    .addComponent(teste_s))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(m_9_sLayout.createSequentialGroup()
                        .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAbdominal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSentar_e_alcancar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSentar_e_alcancar_sb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNove_min_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSeis_min_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qtde)
                            .addGroup(m_9_sLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(m_6_s)
                                    .addComponent(cm_seasb)
                                    .addComponent(cm_sea)))
                            .addComponent(kgm2))
                        .addGap(18, 18, 18)
                        .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classAbdominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(classIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(classSentar_e_alcancar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(classSentar_e_alcancar_sb, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(classNove_min_s, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(classSeis_min_s, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(m_9_sLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(avaliacao_s, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classificacao_s, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23))))
        );

        m_9_sLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {classAbdominal, classIMC, classNove_min_s, classSeis_min_s, classSentar_e_alcancar, classSentar_e_alcancar_sb});

        m_9_sLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAbdominal, txtIMC, txtNove_min_s, txtSeis_min_s, txtSentar_e_alcancar, txtSentar_e_alcancar_sb});

        m_9_sLayout.setVerticalGroup(
            m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(m_9_sLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avaliacao_s)
                    .addComponent(classificacao_s)
                    .addComponent(teste_s))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(m_9_sLayout.createSequentialGroup()
                        .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAbdominal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtde)
                            .addComponent(abdominal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kgm2)
                            .addComponent(imc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSentar_e_alcancar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cm_sea)
                            .addComponent(sentar_e_alcancar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSentar_e_alcancar_sb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cm_seasb)
                            .addComponent(sentar_e_alcancar_sb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNove_min_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(nove_min_s))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(m_9_sLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(seis_min_s)
                            .addComponent(txtSeis_min_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(m_9_sLayout.createSequentialGroup()
                        .addComponent(classAbdominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classIMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classSentar_e_alcancar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classSentar_e_alcancar_sb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classNove_min_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(classSeis_min_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(m_9_sLayout.createSequentialGroup()
                        .addComponent(m_6_s)
                        .addGap(3, 3, 3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        m_9_sLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {classAbdominal, classIMC, classNove_min_s, classSeis_min_s, classSentar_e_alcancar, classSentar_e_alcancar_sb});

        m_9_sLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtAbdominal, txtIMC, txtNove_min_s, txtSeis_min_s, txtSentar_e_alcancar, txtSentar_e_alcancar_sb});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Avaliação Física relacionada ao Desempenho Motor "));

        teste_dm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        teste_dm.setText("Teste");

        avaliacao_dm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        avaliacao_dm.setText("Avaliação");

        classificacao_dm.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        classificacao_dm.setText("Classificação");

        arremesso_medicine_ball.setText("Arremesso de Medicine Ball");

        corrida_20m.setText("Corrida de 20 metros");

        quadrado.setText("Quadrado");

        salto_dist.setText("Salto em Distância");

        nove_min_dm.setText("9 minutos");

        seis_min_dm.setText("6 minutos");

        txtArremesso_medicine_ball.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtArremesso_medicine_ballKeyTyped(evt);
            }
        });

        txtCorrida_20m.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorrida_20mKeyTyped(evt);
            }
        });

        txtQuadrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuadradoKeyTyped(evt);
            }
        });

        txtSalto_dist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalto_distKeyTyped(evt);
            }
        });

        txtNove_min_dm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNove_min_dmKeyTyped(evt);
            }
        });

        txtSeis_min_dm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSeis_min_dmKeyTyped(evt);
            }
        });

        m_6_dm.setText("m");

        m_9_dm.setText("m");

        cm_sd.setText("cm");

        s_qua.setText("s");

        s_20m.setText("s");

        cm_amb.setText("cm");

        classArremesso_medicine_ball.setEditable(false);

        classCorrida_20m.setEditable(false);

        classQuadrado.setEditable(false);

        classtSalto_dist.setEditable(false);

        classNove_min_dm.setEditable(false);

        classSeis_min_dm.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(teste_dm)
                        .addGap(114, 114, 114)
                        .addComponent(avaliacao_dm)
                        .addGap(29, 29, 29)
                        .addComponent(classificacao_dm))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arremesso_medicine_ball)
                            .addComponent(corrida_20m)
                            .addComponent(quadrado)
                            .addComponent(salto_dist)
                            .addComponent(nove_min_dm)
                            .addComponent(seis_min_dm))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtArremesso_medicine_ball, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(txtCorrida_20m)
                            .addComponent(txtQuadrado)
                            .addComponent(txtSalto_dist)
                            .addComponent(txtNove_min_dm)
                            .addComponent(txtSeis_min_dm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cm_amb)
                            .addComponent(s_20m)
                            .addComponent(s_qua)
                            .addComponent(cm_sd)
                            .addComponent(m_9_dm)
                            .addComponent(m_6_dm))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classCorrida_20m, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(classArremesso_medicine_ball, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(classQuadrado)
                                .addComponent(classtSalto_dist)
                                .addComponent(classNove_min_dm)
                                .addComponent(classSeis_min_dm, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(teste_dm)
                    .addComponent(avaliacao_dm)
                    .addComponent(classificacao_dm))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cm_amb)
                    .addComponent(txtArremesso_medicine_ball, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arremesso_medicine_ball)
                    .addComponent(classArremesso_medicine_ball, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(corrida_20m)
                    .addComponent(txtCorrida_20m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_20m)
                    .addComponent(classCorrida_20m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(quadrado)
                    .addComponent(txtQuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s_qua)
                    .addComponent(classQuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(salto_dist)
                    .addComponent(txtSalto_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cm_sd)
                    .addComponent(classtSalto_dist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(nove_min_dm)
                    .addComponent(txtNove_min_dm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_9_dm)
                    .addComponent(classNove_min_dm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(seis_min_dm)
                    .addComponent(txtSeis_min_dm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_6_dm)
                    .addComponent(classSeis_min_dm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        bttCadastrar.setText("Cadastrar");
        bttCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttCadastrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(bttCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bttCadastrar)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 96, Short.MAX_VALUE)
        );

        jButton1.setText("Menu");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(m_9_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(m_9_s, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAbdominalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbdominalKeyPressed
        
    }//GEN-LAST:event_txtAbdominalKeyPressed

    private void txtAbdominalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAbdominalKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtAbdominalKeyTyped

    private void txtIMCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIMCKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtIMCKeyTyped

    private void txtSentar_e_alcancar_sbKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSentar_e_alcancar_sbKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSentar_e_alcancar_sbKeyTyped

    private void txtNove_min_sKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNove_min_sKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNove_min_sKeyTyped

    private void txtSeis_min_sKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSeis_min_sKeyTyped
       char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSeis_min_sKeyTyped

    private void txtArremesso_medicine_ballKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArremesso_medicine_ballKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtArremesso_medicine_ballKeyTyped

    private void txtCorrida_20mKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorrida_20mKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCorrida_20mKeyTyped

    private void txtQuadradoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuadradoKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtQuadradoKeyTyped

    private void txtSalto_distKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalto_distKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSalto_distKeyTyped

    private void txtNove_min_dmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNove_min_dmKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNove_min_dmKeyTyped

    private void txtSeis_min_dmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSeis_min_dmKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSeis_min_dmKeyTyped

    private void txtSentar_e_alcancarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSentar_e_alcancarKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit( c ) || c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtSentar_e_alcancarKeyTyped

    private void bttCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttCadastrarMouseClicked
        if(evt.getSource() == bttCadastrar){
            XStream xstream = new XStream();
            List testes = new ArrayList(1);
            Testes teste = new Testes();

            teste.setAbdominal(txtAbdominal.getText());
            teste.setImc(txtIMC.getText());
            teste.setNoveMin(txtNove_min_s.getText());
            teste.setSeisMin(txtSeis_min_s.getText());
            teste.setSentarAlcancar(txtSentar_e_alcancar.getText());
            teste.setSentarAlcancarSb(txtSentar_e_alcancar_sb.getText());
            teste.setArremesso(txtArremesso_medicine_ball.getText());
            teste.setcorrida_20_m(txtCorrida_20m.getText());
            teste.setNoveMinDm(txtNove_min_dm.getText());
            teste.setQuadrado(txtQuadrado.getText());
            teste.setSalto_dist(txtSalto_dist.getText());
            teste.setSeisMinDm(txtSeis_min_dm.getText());
            
            testes.add(teste);
            //CRIAR ARQUIVO
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        }
    }//GEN-LAST:event_bttCadastrarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
            if(evt.getSource()==jButton1){
                dispose();
                TelaPrincipal tela = new TelaPrincipal(this.cpfProf);
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
            java.util.logging.Logger.getLogger(CadastroTestes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTestes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTestes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTestes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroTestes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel abdominal;
    private javax.swing.JLabel arremesso_medicine_ball;
    private javax.swing.JLabel avaliacao_dm;
    private javax.swing.JLabel avaliacao_s;
    private javax.swing.JButton bttCadastrar;
    private javax.swing.JTextField classAbdominal;
    private javax.swing.JTextField classArremesso_medicine_ball;
    private javax.swing.JTextField classCorrida_20m;
    private javax.swing.JTextField classIMC;
    private javax.swing.JTextField classNove_min_dm;
    private javax.swing.JTextField classNove_min_s;
    private javax.swing.JTextField classQuadrado;
    private javax.swing.JTextField classSeis_min_dm;
    private javax.swing.JTextField classSeis_min_s;
    private javax.swing.JTextField classSentar_e_alcancar;
    private javax.swing.JTextField classSentar_e_alcancar_sb;
    private javax.swing.JLabel classificacao_dm;
    private javax.swing.JLabel classificacao_s;
    private javax.swing.JTextField classtSalto_dist;
    private javax.swing.JLabel cm_amb;
    private javax.swing.JLabel cm_sd;
    private javax.swing.JLabel cm_sea;
    private javax.swing.JLabel cm_seasb;
    private javax.swing.JLabel corrida_20m;
    private javax.swing.JLabel imc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel kgm2;
    private javax.swing.JLabel m_6_dm;
    private javax.swing.JLabel m_6_s;
    private javax.swing.JLabel m_9_dm;
    private javax.swing.JPanel m_9_s;
    private javax.swing.JLabel nove_min_dm;
    private javax.swing.JLabel nove_min_s;
    private javax.swing.JLabel qtde;
    private javax.swing.JLabel quadrado;
    private javax.swing.JLabel s_20m;
    private javax.swing.JLabel s_qua;
    private javax.swing.JLabel salto_dist;
    private javax.swing.JLabel seis_min_dm;
    private javax.swing.JLabel seis_min_s;
    private javax.swing.JLabel sentar_e_alcancar;
    private javax.swing.JLabel sentar_e_alcancar_sb;
    private javax.swing.JLabel teste_dm;
    private javax.swing.JLabel teste_s;
    private javax.swing.JTextField txtAbdominal;
    private javax.swing.JTextField txtArremesso_medicine_ball;
    private javax.swing.JTextField txtCorrida_20m;
    private javax.swing.JTextField txtIMC;
    private javax.swing.JTextField txtNove_min_dm;
    private javax.swing.JTextField txtNove_min_s;
    private javax.swing.JTextField txtQuadrado;
    private javax.swing.JTextField txtSalto_dist;
    private javax.swing.JTextField txtSeis_min_dm;
    private javax.swing.JTextField txtSeis_min_s;
    private javax.swing.JTextField txtSentar_e_alcancar;
    private javax.swing.JTextField txtSentar_e_alcancar_sb;
    // End of variables declaration//GEN-END:variables
}
