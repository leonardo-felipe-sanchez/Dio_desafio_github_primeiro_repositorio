package setembro.atividade.program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import setembro.atividade.entities.Emissora;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Emissora> list = new ArrayList<>();
		
		int x =0;
		ArrayList<Integer> acumulo = new ArrayList<>();
		String a;
	
		while(x != -1) {
			
			System.out.print("digite o numero do canal: ");
			Integer canal = sc.nextInt();
			
			System.out.print("digite o nome do canal: ");
			sc.nextLine();
			String nome = sc.nextLine();
		
			Emissora emi = new Emissora(canal, nome);
			
			list.add(emi);
			
			System.out.println("deseja parar?");
			
			a = sc.next();
			
			if(a.equals("Não") || a.equals("NÃO") || a.equals("não")|| a.equals("N") || a.equals("n") || a.equals("Nao")|| a.equals("nao") || a.equals("NAO")) {
			
			} else if(a.equals("SIM") || a.equals("Sim") || a.equals("sim")) {
				break;
			} else {
				System.out.println("parou aqui bobao");
				break;
			
			}
			
		}
		int[] count = new int[list.size()];
		
		while(x != -1) {
			System.out.println("Vote em um canal da emissora: ");
			int votocanal = sc.nextInt();
			Integer pos = position(list, votocanal);
			
			if(pos == null) {
				System.out.println("nao existe!");	
			} else {
				acumulo.add(votocanal);
			}
			
			System.out.println("Deseja continuar? Se sim, digite qualquer numero, se nao, digite -1");
			x = sc.nextInt();
			
		}
		
		
		for (int i = 0; i< list.size(); i++) {
			for (int j = 0 ; j<acumulo.size(); j++) {
				
				if(acumulo.get(j).equals(list.get(i).getCanal())) {
					count[i]++;
		//			System.out.println("pamonhaaa");
				}
			}
		}
		
		System.out.println("Foram " +  acumulo.size()+ " eleitores");
		for (int i = 0; i< list.size(); i++) {
			
			System.out.println("Emissora " + list.get(i).getNome() + " do canal " + list.get(i).getCanal()+ " teve um total de "+ count[i] + " votos, representando "+ ((Double.valueOf(count[i])*100)/acumulo.size()) +"% dos votos totais");
			
		}
		
		
		sc.close();
	}
	
	public static Integer position(List<Emissora> list, int votocanal) {
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getCanal() == votocanal) {
				return i;
			}
		}
		
		return null;
	}
	
}
