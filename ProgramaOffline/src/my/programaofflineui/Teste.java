
import java.util.ArrayList;  
import java.util.List;  
  
import com.thoughtworks.xstream.XStream;  
  
public class Teste {  
    public static class Pessoa {  
        private String nome;  
        public void setNome(String nome){
            this.nome=nome;
        }
        public String getNome(){
            return this.nome;
        }
    }

    
    
    public static void main(String[] args) {  
        // Criando um objeto XStream          
        XStream xstream = new XStream();  
  
        // Criando alguns dados  
        Pessoa vinci = new Pessoa();  
        vinci.setNome("Vinci Pegoretti Amorim");  
        List contatos = new ArrayList(1);  
        contatos.add(vinci);  
  
        // Passando os dados de Objetos Java para XML  
        String contatosEmXML = xstream.toXML(contatos);  
  
        System.out.println("\nContatos em XML:");  
        System.out.println(contatosEmXML);  
  
        // Passando os dados de XML para Objetos Java  
        List amigos = (List) xstream.fromXML(contatosEmXML);  
        Pessoa amigo = (Pessoa) amigos.get(0);  
  
        System.out.println("\nAmigo como Objeto Java:");  
        System.out.println("Nome: " + amigo.getNome());  
        
    }  
}