
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente("venilton","12345");
		Cliente clara = new Cliente("clara","54321");
		
		Banco banco = new Banco();
		banco.adicionarConta(venilton,1);
		banco.adicionarConta(clara,2);

		banco.deposita(venilton,50);
		banco.infoConta(venilton);

		banco.transferencia(venilton,clara,40);

		banco.infoConta(venilton);
		banco.infoConta(clara);

	}

}
