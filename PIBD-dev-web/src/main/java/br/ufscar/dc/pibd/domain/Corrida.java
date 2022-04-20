package br.ufscar.dc.pibd.domain;
import java.time.LocalDate;

public class Corrida{
    private Integer id;
    private String cpf;
    private String chassi;
    private LocalDate iniciaAs;
    private LocalDate terminaAs;
    private Double valor;
    private String iniciaEm;
    private String terminaEm;
    private Long agendamentoId;
    private Long faturaId;

    public Corrida(Integer id, Double valor, LocalDate iniciaAs, LocalDate terminaAs) {
        this.setId(id);
        this.setValor(valor);
        this.setIniciaAs(iniciaAs);
        this.setTerminaAs(terminaAs);
    }

    public Corrida(String cpf) {
        this.setCpf(cpf);
    }

    public Corrida(Integer id, String cpf, String chassi, LocalDate iniciaAs, LocalDate terminaAs, Double valor, String iniciaEm, String terminaEm, Long agendamentoId, Long faturaId) {
        this.setId(id);
        this.setCpf(cpf);
        this.setChassi(chassi);
        this.setIniciaAs(iniciaAs);
        this.setTerminaAs(terminaAs);
        this.setValor(valor);
        this.setIniciaEm(iniciaEm);
        this.setTerminaEm(terminaEm);
        this.setAgendamentoId(agendamentoId);
        this.setFaturaId(faturaId);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public LocalDate getIniciaAs() {
        return iniciaAs;
    }

    public void setIniciaAs(LocalDate iniciaAs) {
        this.iniciaAs = iniciaAs;
    }

    public void setTerminaAs(LocalDate terminaAs) {
        this.terminaAs = terminaAs;
    }

    public LocalDate getTerminaAs() {
        return terminaAs;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValor() {
        return valor;
    }

    public void setIniciaEm(String iniciaEm) {
        this.iniciaEm = iniciaEm;
    }

    public String getIniciaEm() {
        return iniciaEm;
    }

    public String getTerminaEm() {
        return terminaEm;
    }

    public void setTerminaEm(String terminaEm) {
        this.terminaEm = terminaEm;
    }

    public void setAgendamentoId(Long agendamentoId) {
        this.agendamentoId = agendamentoId;
    }
    public Long getAgendamentoId() {
        return agendamentoId;
    }

    public void setFaturaId(Long faturaId) {
        this.faturaId = faturaId;
    }

    public Long getFaturaId() {
        return faturaId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    
}