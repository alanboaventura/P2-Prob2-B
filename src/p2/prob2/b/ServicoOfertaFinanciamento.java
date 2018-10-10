package p2.prob2.b;

import java.text.DateFormat;
import java.util.Observable;
import java.util.Observer;

public class ServicoOfertaFinanciamento implements Observer {

    private Observable contaCorrente;

    public ServicoOfertaFinanciamento(Observable contaCorrente) {
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

            if (servicosContaCorrente.possuiOfertaFinanciamento() && ultimaOperacao.getTipo() == TipoOperacao.SAIDA) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                System.out.println(String.format("[Serviço de oferta de financiamento - Conta %s - %s - %s]", contaCorrente.getChave(), contaCorrente.getCliente().getNome(), DateFormat.getDateInstance().format(ultimaOperacao.getDataHora())));
                System.out.println();
                System.out.println("Saldo ANTERIOR: " + ultimaOperacao.getSaldoAnterior());
                System.out.println();
                System.out.println("Operação realizada:");
                System.out.println(ultimoRealizado);
                System.out.println();
                System.out.println("Saldo ATUAL: " + contaCorrente.getSaldo());
                System.out.println();
                System.out.println("Oferta de financiamento no valor de " + ultimaOperacao.getValor() * 5 + ". Para mais informações fale com o seu gerente.");
                System.out.println("----------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}
