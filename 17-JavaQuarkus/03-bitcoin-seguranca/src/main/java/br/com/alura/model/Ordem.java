package br.com.alura.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double preco;

    private String tipo;

    private LocalDate data;

    private String status;

    // O Bind entre objeto Java e a tabela soh funciona se os atributos
    // de ambos possuirem os mesmos nomes. Quando nao for possivel, eh
    // necessario definir o @Column(name)
    @Column(name = "user_id")
    private Long userId;

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    // Para tratamento de seguranca de usuario logado e userId da ordem:
    public Long getUserId() {
        return userId;
    }

    public Double getPreco() {
        return preco;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

}
