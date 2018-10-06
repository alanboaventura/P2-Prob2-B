package p2.prob2.b;

public class Analise extends Observer {

    Analise(ContaCorrente conta){
        this.conta = conta;
        this.conta.add(this);
    }

    @Override
    public void update() {
        System.out.print("\n-\tAnalise");
    }
}
