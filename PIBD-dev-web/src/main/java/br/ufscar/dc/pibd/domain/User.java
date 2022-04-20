package br.ufscar.dc.pibd.domain;

public class User {
    private Long id;
    private String nome;
    private String email;
    private String password;
    private String role;

    public User() {
    }

    public User(Long id, String name, String email, String password, String role) {
        this.setId(id);
        this.setNome(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setRole(role);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
