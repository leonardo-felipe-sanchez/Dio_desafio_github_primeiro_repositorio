package agosto.certo;

public class Soma
{
	//atributos
	int n1;
	int n2;
	
	//construtores
	Soma(int a, int b)
	{
		this.n1 = a;
		this.n2 = b;
	}
		
	Soma()  //default
	{
		n1 = 0;
		n2 = 0;
	}
	
	
	//metodos
	int add()
	{
		return n1 + n2;
	}

}
