package com.autos.elbuenconductor.springbatch;

public class TrayectoDTO {
	
	private Long id;
	private String matricula;
	private String kmRecorridos;
	private int nAcelerones;
	private int nFrenazos;
	private String rpmMedias;
	private String inicio;
	private String fin;
	
	public TrayectoDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getKmRecorridos() {
		return kmRecorridos;
	}

	public void setKmRecorridos(String kmRecorridos) {
		this.kmRecorridos = kmRecorridos;
	}

	public int getnAcelerones() {
		return nAcelerones;
	}

	public void setnAcelerones(int nAcelerones) {
		this.nAcelerones = nAcelerones;
	}

	public int getnFrenazos() {
		return nFrenazos;
	}

	public void setnFrenazos(int nFrenazos) {
		this.nFrenazos = nFrenazos;
	}

	public String getRpmMedias() {
		return rpmMedias;
	}

	public void setRpmMedias(String rpmMedias) {
		this.rpmMedias = rpmMedias;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "TrayectoDTO [id=" + id + ", matricula=" + matricula + ", kmRecorridos=" + kmRecorridos
				+ ", nAcelerones=" + nAcelerones + ", nFrenazos=" + nFrenazos + ", rpmMedias=" + rpmMedias + ", inicio="
				+ inicio + ", fin=" + fin + "]";
	}
	
}
