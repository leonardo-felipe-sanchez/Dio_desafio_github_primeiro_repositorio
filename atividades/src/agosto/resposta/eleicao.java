package agosto.resposta;

import java.util.Locale;
import java.util.Scanner;

public class eleicao {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("bem vindo a urna eletronica, digite qualquer numero para continuar ou -1 para sair");
		int x = sc.nextInt();
		//int y = sc.nextInt();
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int soma = 0;
		
		while (x!= -1) {
			
			 System.out.println("digite o numero do seu candidato, tem o 1, o 2, e o 3, o zero que é nulo e o nove que é branco");
			 int y = sc.nextInt();
			 
			 if(y == 1 || y == 2 || y == 3 || y == 5|| y == 0 || y == 9){
				 if(y == 1) {
					 a++;
				 } else if(y == 2) {
					 b++;
				 } else if(y == 3) {
					 c++;
				 } else if(y == 0) {
					 d++;
				 } else if(y == 9) {
					 e++;
				 } else {
					 System.out.println("parou");
					 break;
				 }
				 
				 System.out.println("outro eleitor ?");
				 x = sc.nextInt();
				 soma ++;
			
			}
			
			 }
		
		double porcentagem1 = (Double.valueOf(a) * 100) / soma;
		double porcentagem2 = (Double.valueOf(b) * 100) / soma;
		double porcentagem3 = (Double.valueOf(c) * 100) / soma;
		double porcentagem4 = (Double.valueOf(d) * 100) / soma;
		double porcentagem5 = (Double.valueOf(e) * 100) / soma;

		System.out.println(soma);
		System.out.println("candidato numero 1 possui "+ a+" votos");
		System.out.printf("%.2f %", porcentagem1);
		System.out.println(" ");
		System.out.println("candidato numero 2 possui "+ b+" votos");
		System.out.printf("%.2f %", porcentagem2);
		System.out.println(" ");
		System.out.println("candidato numero 3 "+ c+ " votos");
		System.out.printf("%.2f %", porcentagem3);
		System.out.println(" ");
		System.out.println("houveram "+ d + " votos nulos");
		System.out.printf("%.2f %", porcentagem4);
		System.out.println(" ");
		System.out.println("houveram "+ e+ " votos em branco");
		System.out.printf("%.2f %", porcentagem5);
		System.out.println(" ");
		
		sc.close();
			 }
			 
		
	}
	
	
	

