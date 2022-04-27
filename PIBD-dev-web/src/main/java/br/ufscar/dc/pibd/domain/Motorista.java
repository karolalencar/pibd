package br.ufscar.dc.pibd.domain;

import java.time.LocalDate;

public class Motorista {
    private String cpf;
    private String renach;
    private String agenciaBancaria;
    private String contaBancaria;
    private String banco;
    private String rg;
    private String estadoCivil;
    private LocalDate dataNasc;
    private String name;
    private String email;
    private String password;
    private String role;

    public Motorista(String cpf, LocalDate dataNasc, String estadoCivil, String rg) {
        this.setCpf(cpf);
    }

    public Motorista(String cpf) {
        this.setCpf(cpf);
        this.setDataNasc(dataNasc);
        this.setEstadoCivil(estadoCivil);
        this.setRg(rg);
    }

    public Motorista(String cpf, String name, String email, String password, String role, String renach,
            String agenciaBancaria, String contaBancaria, String banco, String rg, String estadoCivil,
            LocalDate dataNasc) {
        this.setCpf(cpf);
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setRole(role);
        this.setRenach(renach);
        this.setAgenciaBancaria(agenciaBancaria);
        this.setContaBancaria(contaBancaria);
        this.setBanco(banco);
        this.setRg(rg);
        this.setEstadoCivil(estadoCivil);
        this.setDataNasc(dataNasc);
    }

    public Motorista(String cpf, String nome) {
        this.cpf = cpf;
        this.name = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
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

    public void setRenach(String renach) {
        this.renach = renach;
    }

    public String getRenach() {
        return this.renach;
    }

    public void setAgenciaBancaria(String agenciaBancaria) {
        this.agenciaBancaria = agenciaBancaria;
    }

    public String getAgenciaBancaria() {
        return this.agenciaBancaria;
    }

    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String getContaBancaria() {
        return this.contaBancaria;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getBanco() {
        return this.banco;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRg() {
        return this.rg;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

}