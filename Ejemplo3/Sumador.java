package Ejemplo3;


public class Sumador {
	public int sumar(int n1, int n2) {
		int resultado = 0;
		for (int i = n1; i <= n2; i++) {
			resultado += i;
		}
		return resultado;
	}

	public static void main(String[] args) {
		Sumador s = new Sumador();
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		//LOS VALORES N1 Y N2 SE PONEN EN RUN>RUN CONFIGURATIONS>ARGUMENTS
		int resultado = s.sumar(n1, n2);
		System.out.println(resultado);
	}
}