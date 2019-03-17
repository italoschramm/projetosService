package com.italo.projetos.dto;

import java.util.Date;

public class ProjetoDTO {
	
	private Long idProjeto;
	private String nomeProjeto;
	private boolean statusProjeto;
	private Date dataAtivacao; 
	private Date dataDesativacao;
	private Long idEmpresa;
	
	/**
	 * @return the idProjeto
	 */
	public Long getIdProjeto() {
		return idProjeto;
	}
	/**
	 * @param idProjeto the idProjeto to set
	 */
	public void setIdProjeto(Long idProjeto) {
		this.idProjeto = idProjeto;
	}
	/**
	 * @return the nomeProjeto
	 */
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	/**
	 * @param nomeProjeto the nomeProjeto to set
	 */
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	/**
	 * @return the statusProjeto
	 */
	public boolean isStatusProjeto() {
		return statusProjeto;
	}
	/**
	 * @param statusProjeto the statusProjeto to set
	 */
	public void setStatusProjeto(boolean statusProjeto) {
		this.statusProjeto = statusProjeto;
	}
	/**
	 * @return the dataAtivacao
	 */
	public Date getDataAtivacao() {
		return dataAtivacao;
	}
	/**
	 * @param dataAtivacao the dataAtivacao to set
	 */
	public void setDataAtivacao(Date dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}
	/**
	 * @return the dataDesativacao
	 */
	public Date getDataDesativacao() {
		return dataDesativacao;
	}
	/**
	 * @param dataDesativacao the dataDesativacao to set
	 */
	public void setDataDesativacao(Date dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}
	/**
	 * @return the empresa
	 */
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

}
