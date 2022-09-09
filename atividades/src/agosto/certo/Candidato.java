package agosto.certo;

public class Candidato {
	
	public String nome;
	public String sigla;
	public int codigo;

	public int totalvoto;

	Candidato()
	{
		nome = "";
		sigla = "";
		codigo = 0;
		totalvoto = 0;
	}
	
	Candidato(String n, String s, int c)
	{
		nome = n;
		sigla = s;
		codigo = c;
		totalvoto = 0;
	}
	
}
