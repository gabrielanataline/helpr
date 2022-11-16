package org.soulcodeacademy.helpr.domain.dto;

import org.soulcodeacademy.helpr.domain.enums.StatusChamado;

import javax.validation.constraints.NotBlank;

public class ChamadoDTO {
    @NotBlank(message = "titulo é obrigatório")
    private String titulo;

    @NotBlank(message = "descrição é obrigatória")
    private String descricao;

    @NotBlank(message = "idCliente é obrigatório")
    private Integer idCliente;

    private StatusChamado status;

    private Integer idFuncionaio;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

    public Integer getIdFuncionaio() {
        return idFuncionaio;
    }

    public void setIdFuncionaio(Integer idFuncionaio) {
        this.idFuncionaio = idFuncionaio;
    }
}
