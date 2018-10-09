package p2.prob2.b;

import java.util.Observable;
import java.util.Observer;

public class ServicoNotificacoes implements Observer {

    private Observable contaCorrente;

    public ServicoNotificacoes(Observable contaCorrente) {
        this.contaCorrente = contaCorrente;
        this.contaCorrente.addObserver(this);
    }

    @Override
    public void update(Observable observable, Object arg1) {
        if (observable instanceof ContaCorrente) {
            ContaCorrente contaCorrente = (ContaCorrente) observable;
            ServicosContaCorrente servicosContaCorrente = contaCorrente.getServicosContaCorrente();

            if (servicosContaCorrente.possuiNotificacoesEmOperacoes()) {
                final Operacao ultimaOperacao = contaCorrente.getUltimaOperacao();
                final String ultimoRealizado = contaCorrente.getUltimoRealizado();
                final Cliente cliente = contaCorrente.getCliente();

                System.out.println(String.format("[Serviço de notificações - Conta %s - %s - %s]", contaCorrente.getNumero(), cliente.getNome(), ultimaOperacao.getDataHora()));
                System.out.println();
                System.out.println("Saldo ANTERIOR: " + ultimaOperacao.getSaldoAnterior());
                System.out.println();
                System.out.println("Operação realizada:");
                System.out.println(ultimoRealizado);
                System.out.println();
                System.out.println("Saldo ATUAL: " + contaCorrente.getSaldo());
                System.out.println();
                System.out.println();

                ConfiguracoesDeNotificacao configuracoesDeNotificacao = servicosContaCorrente.getConfiguracoesDeNotificacao();

                if (cliente instanceof ClientePessoaJuridica) {
                    if (configuracoesDeNotificacao.possuiJms()) {
                        System.out.println("Notificação enviada para o servidor JMS " + ((ClientePessoaJuridica) cliente).getServidorJMS());
                    }
                }

                if (configuracoesDeNotificacao.possuiSms()) {
                    System.out.println("Notificação SMS enviada para o número " + cliente.getTelCelular());
                }

                if (configuracoesDeNotificacao.possuiWhatsapp()) {
                    System.out.println("Notificação via WhatsApp enviada para o número " + cliente.getTelCelular());
                }
            }
        }
    }
}
