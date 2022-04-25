package br.ufscar.dc.pibd.domain;

public class Passageiro {
    private String cpf;
    private String nome;
    private String cep;
    private Integer num;

    public Passageiro(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Passageiro(String cpf) {
        this.cpf = cpf;
    }

    public Passageiro(String cpf, String cep, Integer num) {
        this.cpf = cpf;
        this.cep = cep;
        this.num = num;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

}
