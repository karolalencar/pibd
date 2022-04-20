package br.ufscar.dc.pibd.domain;

public class User {
    private String nome;
    private String email;
    private String password;
    private String papel;

    public User() {
    }

    public User(String name, String email, String password, String role) {
        this.setNome(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setPapel(role);
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

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getPapel() {
        return this.papel;
    }

}
