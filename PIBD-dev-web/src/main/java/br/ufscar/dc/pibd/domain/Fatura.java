package br.ufscar.dc.pibd.domain;

import java.util.Date;

public class Fatura {
    private Integer id;
    private String cnpj;
    private Date data_criacao;
    private String situacao;

    public Fatura(Integer id, String cnpj, Date data_criacao, String situacao) {
        this.cnpj = cnpj;
        this.id = id;
        this.data_criacao = data_criacao;
        this.situacao = situacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public Integer getId() {
        return id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
