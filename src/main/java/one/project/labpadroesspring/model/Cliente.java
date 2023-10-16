package one.project.labpadroesspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

//Por estar utilizando uma versão mais nova do Java EE, o pacote correto será o Jakarta ao invés do Javax. O Jakarta contém o javax.
//Criando uma table

@Entity
public class Cliente {
    //Chave primária com valor gerado automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    //Vários clientes poderão estar associados a um mesmo endereco
    @ManyToOne
    private Endereco endereco;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }



}
