package agosto.certo;

import java.util.Scanner;

public class Eleicao {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Candidato cand1 = new Candidato();
	
		System.out.println("Informe o nome do primeiro candidato");
		cand1.nome = sc.nextLine();
		System.out.println("informa a sigla do partido");;
		cand1.sigla = sc.nextLine();
		
		cand1.codigo = 1;
		
		Candidato cand2 = new Candidato();
		
		System.out.println("Informe o nome do segundo candidato");
		cand2.nome = sc.nextLine();
		
		System.out.println("informa a sigla do partido");;
		cand2.sigla = sc.nextLine();
		
		cand2.codigo = 2;
		

		Candidato cand3 = new Candidato();
		
		
		System.out.println("Informe o nome do terceiro candidato");
		cand3.nome = sc.nextLine();
		
		System.out.println("informa a sigla do partido");;
		cand3.sigla = sc.nextLine();
		
		cand3.codigo = 3;
		
		int votonulo = 0;
		int votobranco =0;
		int qtdevotos = 0;
		
		System.out.println(" Informe seu voto:  ");
		int voto = sc.nextInt();
		
		while (voto !=-1) {
			
			if(voto == 1) {
				cand1.totalvoto++;
			qtdevotos++;
			}
			else if(voto ==2) {
				cand2.totalvoto++;
				qtdevotos++;
			}
			else if(voto == 3)
			{
				cand3.totalvoto++;
			qtdevotos++;
		}
			else if(voto == 0) {
				votonulo++;
			qtdevotos++;
		}
			else if(voto == 9) {
				votobranco++;
				qtdevotos++;
			}
			else {
				System.out.println("voto invalido");
				qtdevotos--;
			}
			System.out.println(" Informe seu voto:  ");
			voto = sc.nextInt();
		}
		
		double porcentagem1 = (Double.valueOf(cand1.totalvoto) * 100) / qtdevotos;
		double porcentagem2 = (Double.valueOf(cand2.totalvoto) * 100) / qtdevotos;
		double porcentagem3 = (Double.valueOf(cand3.totalvoto) * 100) / qtdevotos;
		double porcentagem4 = (Double.valueOf(votonulo) * 100) / qtdevotos;
		double porcentagem5 = (Double.valueOf(votobranco) * 100) / qtdevotos;

		System.out.println(" candidato 1 " + cand1.nome+" votos: "+ cand1.totalvoto);
		System.out.println("porcentagem: "+ porcentagem1+"%");
		
		System.out.println(" candidato 2 " + cand2.nome+" votos: "+ cand2.totalvoto);
		System.out.println("porcentagem: "+ porcentagem2+"%");
		
		System.out.println(" candidato 3 " + cand3.nome+" votos: "+ cand3.totalvoto);
		System.out.println("porcentagem: "+ porcentagem3+"%");

		System.out.println(" nulos: "+ votonulo);
		System.out.println("porcentagem: "+ porcentagem4+"%");
		
		System.out.println(" branco: "+ votobranco);
		System.out.println("porcentagem: "+ porcentagem5+"%");
			
		sc.close();
	}
	
}
