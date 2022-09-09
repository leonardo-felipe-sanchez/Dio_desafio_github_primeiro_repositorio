package setembro.atividade.entities;

public class Emissora {

	private Integer canal;
	private String nome;
	
	
	public Emissora() {
		
	}

	public Emissora(Integer canal, String nome) {
		super();
		this.canal = canal;
		this.nome = nome;
	}

	public Integer getCanal() {
		return canal;
	}

	public void setCanal(Integer canal) {
		this.canal = canal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
