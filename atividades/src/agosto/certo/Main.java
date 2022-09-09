package agosto.certo;

class Main
{
	public static void main(String args[])
	{
		
		Soma s = new Soma();
		
		Soma ss = new Soma(2,3);
		
		System.out.printf("S = %d \n ", s.add());
		System.out.printf("SS = %d \n ", ss.add());
	}

}
