package p2.prob2.b;

import java.text.DateFormat;
import java.util.Observable;
import java.util.Observer;

public class ServicoAnaliseInvestimento implements Observer {

    private Observable contaCorrente;

    public ServicoAnaliseInvestimento(Observable contaCorrente) {
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

            if (servicosContaCorrente.possuiAnaliseInvestimento() && ultimaOperacao.getTipo() == TipoOperacao.ENTRADA) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                System.out.println(String.format("[Serviço de analise de investimento - Conta %s - %s - %s]", contaCorrente.getChave(), contaCorrente.getCliente().getNome(), DateFormat.getDateInstance().format(ultimaOperacao.getDataHora())));
                System.out.println();
                System.out.println("Saldo ANTERIOR: " + ultimaOperacao.getSaldoAnterior());
                System.out.println();
                System.out.println("Operação realizada:");
                System.out.println(ultimoRealizado);
                System.out.println();
                System.out.println("Saldo ATUAL: " + contaCorrente.getSaldo());
                System.out.println();
                System.out.println("Oferta de investimento no valor de " + ultimaOperacao.getValor() / 2 + ". Para mais informações fale com o seu gerente.");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}
