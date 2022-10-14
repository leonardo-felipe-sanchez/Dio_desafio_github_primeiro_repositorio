package projeto_banco;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main{

	private static Scanner sc;

	public static void main(String[] args) throws ReprovadoException{
		
		boolean loope = true, loopi = true;
		int i = 0, z = 0, x = 0, y = 0;
		sc = new Scanner(System.in);
		List<Cliente> CLI = new ArrayList<>();
		List<Conta> list = new ArrayList<>();
		
		Cliente DonoBanco =  new Cliente();
		DonoBanco.setNome("Mr.beast");
		
		Conta contacorrente = new CC(DonoBanco);
		Conta contapoupanca = new CPO(DonoBanco);
		contacorrente.setSenha("leo");
		contapoupanca.setSenha("leo");
		list.add(contacorrente);
		list.add(contapoupanca);
		
		String senha;
		
		Banco banco = new Banco();
		
		
		while(y != -1) {
try {

	while(loope) {

		try {
x = 0;				
System.out.println("Deseja criar um novo usuario?(nao ou sim)");
String limite = sc.next();
if(limite.equals("nao") || limite.equals("Nao") || limite.equals("não") || limite.equals("Não")|| limite.equals("n") || limite.equals("N")) {
break;
} else if(limite.equals("sim")|| limite.equals("Sim") || limite.equals("SIM") || limite.equals("S") || limite.equals("s")) {
sc.nextLine();
System.out.println("digite o nome do usuario da conta ");
String usu = sc.nextLine();

Cliente cli = new Cliente();

cli.setNome(usu);

CLI.add(cli);
//int a = CLI.size() -1;
z = 0;
while( z != -1) {
System.out.println(" ");
System.out.println("Deseja criar uma nova conta de numero "+ (list.size()+1)+" como conta corrente e "+ (list.size()+2) +" como conta poupança?(nao ou sim)");
limite = sc.next();

if(limite.equals("nao") || limite.equals("Nao") || limite.equals("não") || limite.equals("Não")|| limite.equals("n") || limite.equals("N")) {
z = -1;
} else if(limite.equals("sim")|| limite.equals("Sim") || limite.equals("SIM") || limite.equals("S") || limite.equals("s")) {
System.out.println("Digite a sua senha: ");
 senha = sc.next();

Conta cc = new CC(CLI.get(i));
Conta cpo = new CPO(CLI.get(i));
cc.setSenha(senha);
cpo.setSenha(senha);
list.add(cc);
list.add(cpo);
x++;
} else {

throw new ReprovadoException("opcao invalida");

}

}

//System.out.println(x);

if(x == 0) {
Conta cc = new CC(CLI.get(i));
Conta cpo = new CPO(CLI.get(i));

cc.setSenha("000");
cpo.setSenha("000");
list.add(cc);
list.add(cpo);
list.get(list.size()-1).setSenha("000");

throw new ReprovadoException("Não há conta criada, foi criada uma nova conta para tu, a conta corrente de numero "+ (list.size()-1)+" e aconta poupança de numero "+ (list.size())+" e sua senha é 000 foram criadas para a sua infelicidade");

} else {
System.out.println();

System.out.println("Contas geradas sob o seu nome: ");

	for(int j = 0; j< list.size(); j++) {
	//list.get(j).imprimirExtrato();
		if(list.get(j).clientes.getNome() == usu) {
			list.get(j).imprimirExtrato();
			//System.out.println(list.get(j).getSenha());
			
		}
	}
	//System.out.println(list.get(list.size()-1).getSenha());
}

} else {
throw new ReprovadoException("opção invalida");

}		
i++;
		} catch (ReprovadoException e) {
			System.err.println(e.getMessage());
			System.out.println("");
		} catch (InputMismatchException e) {

		System.err.println("digitou letra no lugar de número");
		}
		
	}
	

		while(loopi) {
			System.out.println("Deseja acessar alguma conta?");
			String limite = sc.next();
			if(limite.equals("nao") || limite.equals("Nao") || limite.equals("não") || limite.equals("Não")|| limite.equals("n") || limite.equals("N")) {
				break;
			} else if(limite.equals("sim")|| limite.equals("Sim") || limite.equals("SIM") || limite.equals("S") || limite.equals("s")) {

System.out.println("digite o numero da conta");
int conta = sc.nextInt();
Integer pos = position(list, conta);
System.out.println("Digite a senha ");
senha = sc.next();

for (int j = 0; j < list.size(); j++) {
	
	banco.cadastrarContas(list.get(j));
	
}
while(loope) {

try {
	if(pos == null) {
		throw new ReprovadoException("usuario nao existe");
	} else
		//System.out.println(list.get(conta-1).getSenha());
		{
		
		if(senha.equals(list.get(conta-1).getSenha())) {

			if(list.get(conta-1).getConta() == 1 || list.get(conta-1).getConta() == 2) {
			try {


				System.out.println("Olá bonitão, o que deseja fazer?");
				System.out.println("digite D para depósito");
				System.out.println("digite R para saque");
				System.out.println("digite V para visualizar as contas alheias");
				System.out.println("digite T para transferência");
				System.out.println("digite S para finalizar");
				System.out.println("digite A para remover a conta");
				
				char menu = sc.next().charAt(0);
				
				if(menu == 'D' || menu =='d') {
					
					System.out.println("digite um valor para depositar");
					Double valor = sc.nextDouble();
					
					list.get(conta-1).depositar(valor);

					list.get(conta-1).imprimirExtrato();
					
				} else if(menu == 'A' || menu == 'a') {
					System.out.println("Digite a conta para remover");
					int c = sc.nextInt();

					Integer pos3 = position(list, c-1);
				
					if(c == conta || c == 1 || c== 2) {
						throw new ReprovadoException("Você está tentando deletar a própria conta, portanto como é o administrador do banco, o pedido foi negado");
					} else {
						if(pos3 == null) {
							throw new ReprovadoException("a conta a ser deletada não existe");
						} else {
							list.remove(c-1);
							
							System.out.println("  _________________________________  ");
							System.out.println(" | Conta | Cliente | Saldo | Senha | ");
							for (int j = 0; j < list.size(); j++) {
								banco.mostrar(j);	
							}
							System.out.println("  ---------------------------------  ");	
						
						}
					}
				}
				
				else if(menu == 'R'|| menu == 'r') {
					
					System.out.println("digite um valor para sacar");
					Double valor = sc.nextDouble();
					
					list.get(conta-1).sacar(valor);

					list.get(conta-1).imprimirExtrato();
					
				} else if(menu == 't'|| menu == 'T') {
					
					System.out.println("digite o numero da conta de quem você quer transferir");
					int T = sc.nextInt();
					
					 Integer pos2 = position(list, T);
					
					 if(T == conta) {
						 throw new ReprovadoException("Você está tentando transefir para a conta em que esta usando");
					 } else {
							if(pos2== null) { 
								throw new ReprovadoException("A conta que seria para transferência não existe");
							}
							else {
								System.out.println("digite um valor para transferir");
								double valor = sc.nextDouble();

								list.get(conta-1).sacar(valor);
								list.get(T-1).depositar(valor);

								list.get(conta-1).imprimirExtrato();
							}
					 }
					 
				} else if(menu == 'V' || menu == 'v') {

					System.out.println("  _________________________________  ");
					System.out.println(" | Conta | Cliente | Saldo | Senha | ");
					for (int j = 0; j < list.size(); j++) {
						banco.mostrar(j);	
					}
					System.out.println("  ---------------------------------  ");	
					
				} else if(menu == 's' || menu == 'S') {
					break;
				} else {
					throw new ReprovadoException("digito errado!");
				}
				
			
				
			} catch (ReprovadoException e) {

				System.err.println(e.getMessage());			
			} catch (InputMismatchException e) {
				System.err.println("Tentou digitar letra no lugar de numero");
				
			} catch(IndexOutOfBoundsException e) {
				System.out.println("usuario nao existe");
			}
				
			} else {
				try {			
					System.out.println("bem vindo, "+ list.get(conta-1).clientes.getNome());
					System.out.println("digite D para deposito, R para saque, T para transferência, V para visualizar valor, A para alterar a senha, S para terminar");
					char menu = sc.next().charAt(0);
					
					if(menu =='A' || menu =='a'){
						System.out.println("digite a senha atual");
						String S = sc.next(), p = list.get(conta-1).getSenha();
						if(S.equals(p)) {
							System.out.println("Digite a nova senha");
							String NoS = sc.next();
							list.get(conta-1).setSenha(NoS);
							S = NoS;
							p = list.get(conta-1).getSenha();
							senha = NoS;
							
							if(conta %2 == 0) {
								System.out.println("A senha da sua conta corrente tambem foi alterada");
								list.get(conta-2).setSenha(NoS);
							} else {
								System.out.println("A senha da sua conta poupanca tambem foi alterada");
								list.get(conta).setSenha(NoS);
							}
							
						}else {
							throw new ReprovadoException("senha invalida");
						}
						
						
					}  else if(menu == 'D' || menu =='d') {
										
						System.out.println("digite um valor para depositar");
						Double valor = sc.nextDouble();
						
						list.get(conta-1).depositar(valor);

						list.get(conta-1).imprimirExtrato();
						
					} else if(menu == 'R'|| menu == 'r') {
						
						System.out.println("digite um valor para sacar");
						Double valor = sc.nextDouble();
						
						list.get(conta-1).sacar(valor);

						list.get(conta-1).imprimirExtrato();
						
					} else if(menu == 't'|| menu == 'T') {
						
						System.out.println("digite o numero da conta de quem você quer transferir");
						int T = sc.nextInt();
						
						 Integer pos2 = position(list, T);
						
						 if(T == conta) {
							 throw new ReprovadoException("Você está tentando transefir para a sua propria conta");
						 } else {
								if(pos2== null) { 
									throw new ReprovadoException("A conta que seria para transferência não existe");
								}
								else {
									System.out.println("digite um valor para transferir");
									double valor = sc.nextDouble();

									list.get(conta-1).sacar(valor);
									list.get(T-1).depositar(valor);

									list.get(conta-1).imprimirExtrato();
								}
						 }
						 
					} else if(menu == 'V' || menu == 'v') {
						
						list.get(conta-1).imprimirExtrato();
					} else if(menu == 's' || menu == 'S') {
						break;
					} else {
						throw new ReprovadoException("digito errado!");
					}
					
				} catch (ReprovadoException e) {

					System.err.println(e.getMessage());
				
				} catch (InputMismatchException e) {
					System.err.println("tentou digitar letra no lugar de numero");
				}
			}
			
		} else {
			throw new ReprovadoException("senha invalida");
		}
		
	}
	
	
} catch (ReprovadoException e) {

	System.err.println(e.getMessage());
	break;
} catch (InputMismatchException e) {

	System.err.println("digitou letra no lugar de número");
	} finally {
	System.out.println(" ");
	
}

}

				} else {

							throw new ReprovadoException("opcao invalida");
														
				}
			}
		
		System.out.println("Deseja parar tudo?(sim, nao)");
		String limite = sc.next();
		if(limite.equals("nao") || limite.equals("Nao") || limite.equals("não") || limite.equals("Não")|| limite.equals("n") || limite.equals("N")) {
			
		} else if(limite.equals("sim")|| limite.equals("Sim") || limite.equals("SIM") || limite.equals("S") || limite.equals("s")) {
			break;
		} else {

			throw new ReprovadoException("opcao invalida");
			
		}
} catch (ReprovadoException e) {
	System.err.println(e.getMessage());
} catch (InputMismatchException e) {

	System.err.println("digitou letra no lugar de número");
	}
		}
		
		sc.close();
	}

	private static Integer position(List<Conta> list, int conta) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getConta()== conta) {
				return i;
			}
		}
		
		return null;
	}

	
} 

class ReprovadoException extends Exception{
	private static final long serialVersionUID = 1L;

	public  ReprovadoException(String msg) {
		super(msg);
	}
}

class Banco {

private String nome;
private List<Conta> contas = new ArrayList<Conta>();

public void cadastrarContas(Conta conta) {
	contas.add(conta);
}

public int qtdeContas() {
	return contas.size();
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}


public void mostrar(int a) {
	System.out.println(" | "+ contas.get(a).getConta()+ " | "+ contas.get(a).clientes.getNome()+" | "+contas.get(a).getSaldo()+" | "+ contas.get(a).getSenha()+" | ");
}

}

class Cliente{


private String nome;

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}
	
}

class Conta implements iConta{


	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int conta;
	protected double saldo;
	protected Cliente clientes;
	protected String senha;

	public Conta() {
		
	}
	
	public Conta(Cliente clientes) {
		this.agencia = AGENCIA_PADRAO;
		this.conta = SEQUENCIAL++;
		this.clientes = clientes;
	}
	

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public void sacar(double valor) throws ReprovadoException{
		// TODO Auto-generated method stub
		
		if(valor>saldo) {
			throw new ReprovadoException("saldo insuficiente");
		} 
	else saldo -= valor;
	}

	@Override
	public void depositar(double valor) throws ReprovadoException{
		// TODO Auto-generated method stub
		if (valor<0) throw new ReprovadoException("valor negativo");
		else saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {

		try {
			this.sacar(valor);
			contaDestino.depositar(valor);
		} catch (ReprovadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Nome: %s", this.clientes.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.conta));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	@Override
	public void imprimirExtrato() {
		// TODO Auto-generated method stub
		
	}
}

class CC extends Conta{

	public CC(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
		
	}
	
}

class CPO extends Conta{

	public CPO(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
		
	}
	
}

interface iConta{
	
	void depositar(double valor) throws ReprovadoException;

	void imprimirExtrato();

	void sacar(double valor) throws ReprovadoException;

	void transferir(double valor, Conta contaDestino);
}