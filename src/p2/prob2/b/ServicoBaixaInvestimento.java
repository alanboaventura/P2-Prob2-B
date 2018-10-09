package p2.prob2.b;

import java.util.Observable;
import java.util.Observer;

public class ServicoBaixaInvestimento implements Observer {

    private Observable contaCorrente;

    public ServicoBaixaInvestimento(Observable contaCorrente) {
        this.contaCorrente = contaCorrente;
        this.contaCorrente.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg1) {
        if (observable instanceof ContaCorrente) {
            ContaCorrente contaCorrente = (ContaCorrente) observable;
            ServicosContaCorrente servicosContaCorrente = contaCorrente.getServicosContaCorrente();

            final Operacao ultimaOperacao = contaCorrente.getUltimaOperacao();
            final String ultimoRealizado = contaCorrente.getUltimoRealizado();

            if (servicosContaCorrente.possuiBaixaDeInvestimento() && ultimaOperacao.getTipo() == TipoOperacao.SAIDA) {
                System.out.println(String.format("[Serviço de baixa de investimento - Conta %s - %s - %s]", contaCorrente.getNumero(), contaCorrente.getCliente().getNome(), ultimaOperacao.getDataHora()));
                System.out.println();
                System.out.println("Saldo ANTERIOR: " + ultimaOperacao.getSaldoAnterior());
                System.out.println();
                System.out.println("Operação realizada:");
                System.out.println(ultimoRealizado);
                System.out.println();
                System.out.println("Saldo ATUAL: " + contaCorrente.getSaldo());
                System.out.println();
                System.out.println();
                System.out.println("Baixa de investimento no valor de " + ultimaOperacao.getValor());
            }
        }
    }
}
