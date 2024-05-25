import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode

public class Banco {

	private String nome;
	private List<Conta> contas;

	Banco(){
		this.nome="Banco Diferente";
		contas = new ArrayList<>();
	}
	public void adicionarConta(Cliente cliente,Integer tipo){
		if(tipo==1){
			Conta cc = new ContaCorrente(cliente);
			contas.add(cc);
		}else{
			Conta poupanca = new ContaPoupanca(cliente);
			contas.add(poupanca);
		}

	}
	private Conta procuraConta(Cliente c){
		for(Conta conta:contas){
			if(conta.cliente.getCpf().equals(c.getCpf())){
				return conta;
			}
		}
		return null;
	}

	public void deposita(Cliente c,Integer valor){
		int i=0;
		for(Conta conta:contas){
			if(conta.cliente.getCpf().equals(c.getCpf())){
				conta.depositar(valor);
				System.out.println("valor depositado: "+valor);
				i=1;
				break;
			}
		}
		if(i==0)
			System.out.println("conta nao encotrada");
	}

	public void infoConta(Cliente c){
		int i=0;
		for(Conta conta:contas){
			if(conta.cliente.getCpf().equals(c.getCpf())){
				conta.imprimirInfosComuns();
				i=1;
				break;
			}
		}
		if(i==0)
			System.out.println("conta nao encotrada");
	}

	public void transferencia(Cliente c1,Cliente c2,Integer valor){
		Conta aux=this.procuraConta(c1);
		Conta aux2=this.procuraConta(c2);
		if(aux!=null &&aux2!=null && aux.saldo>valor){
			aux.sacar(valor);
			aux2.depositar(valor);
			System.out.println("Transacao realizada!");
		}else{
			System.out.println("Saldo insuficiente!");
		}
	}

}
