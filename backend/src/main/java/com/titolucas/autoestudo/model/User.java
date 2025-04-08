package com.titolucas.autoestudo.model;
import jakarta.persistence.*;

@Entity // Indica que essa classe será uma tabela no banco
@Table(name = "usuarios") // Nome da tabela
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremento
    private Long id;

    @Column(nullable = false) // Campo obrigatório
    private String nome;

    @Column(nullable = false, unique = true) // Não pode repetir e é obrigatório
    private String email;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
