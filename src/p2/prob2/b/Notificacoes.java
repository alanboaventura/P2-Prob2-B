package p2.prob2.b;

public class Notificacoes extends Observer {

    Notificacoes(ContaCorrente conta){
        this.conta = conta;
        this.conta.add(this);

    }

    @Override
    public void update() {
        System.out.print("\n-\tNotificações via:");
        for (String metodo : this.conta.getMetodosNot())
            System.out.print("\n\t-\t"+metodo);
    }
}
