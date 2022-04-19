package br.ufscar.dc.pibd.domain;

public class User {
    private String nome;
    private String email;
    private String password;
    private String role;


    public User() {
    }

    public User( String name, String email, String password, String role) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setRole(role);
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public String getName() {
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

}
