package p2.prob2.b;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

/**
 * Esta classe oferece as funcionalidades básicas para atender ao Problema 2.
 *
 * @author marcel
 */
public class ContaCorrente extends Observable {

    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo = 0;
    private final List<Operacao> operacoes = new ArrayList();
    private final ArrayList<String> realizados = new ArrayList();
    private final ServicosContaCorrente servicosContaCorrente;

    public ContaCorrente(Cliente cliente, int numero, int agencia, boolean possuiBaixaDeInvestimento, boolean possuiFluxoDeCaixa, boolean possuiNotificacoesEmOperacoes, boolean aceitaSms, boolean aceitaWhatsapp, boolean aceitaJms, boolean possuiAnaliseInvestimento, boolean possuiOfertaFinanciamento) {
        this.servicosContaCorrente = new ServicosContaCorrente(cliente, possuiBaixaDeInvestimento, possuiFluxoDeCaixa, possuiNotificacoesEmOperacoes, aceitaSms, aceitaWhatsapp, aceitaJms, possuiAnaliseInvestimento, possuiOfertaFinanciamento);
        this.numero = numero;
        this.agencia = agencia;
    }

    public String getChave() {
        return String.valueOf(agencia) + "-" + String.valueOf(numero);
    }

    public void sacar(double valor) {
        if (valor > this.getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque");
        }
        Operacao oper = new Operacao(valor, this.getSaldo(), TipoOperacao.SAIDA, new Date(), this);
        operacoes.add(oper);
        this.saldo -= valor;
        realizados.add("Saque de " + valor + " - " + TipoOperacao.SAIDA);

        setChanged();
        notifyObservers();
    }

    public void depositar(double valor) {
        Operacao oper = new Operacao(valor, this.getSaldo(), TipoOperacao.ENTRADA, new Date(), this);
        operacoes.add(oper);
        this.saldo += valor;
        realizados.add("Depósito de " + valor + " - " + TipoOperacao.ENTRADA);

        setChanged();
        notifyObservers();
    }


    public void transferir(double valor, ContaCorrente destino) {
        if (valor > this.getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }
        destino.receberTransferencia(valor, this);
        Operacao oper = new OperacaoTransferencia(valor, this.getSaldo(), TipoOperacao.SAIDA, new Date(), this, destino);
        operacoes.add(oper);
        this.saldo -= valor;
        realizados.add("Transferencia de " + valor + " para a Conta " + destino + " - " + TipoOperacao.SAIDA);

        setChanged();
        notifyObservers();
    }

    private void receberTransferencia(double valor, ContaCorrente origem) {
        Operacao oper = new OperacaoTransferencia(valor, this.getSaldo(), TipoOperacao.ENTRADA, new Date(), this, origem);
        operacoes.add(oper);
        this.saldo += valor;
        realizados.add("Transferencia recebida de " + origem + " no valor de " + valor + " - " + TipoOperacao.ENTRADA);

        setChanged();
        notifyObservers();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return this.getChave();
    }

    public ServicosContaCorrente getServicosContaCorrente() {
        return servicosContaCorrente;
    }

    public void aderirBaixaInvestimento(boolean opcao) {
        this.servicosContaCorrente.setBaixaDeInvestimento(opcao);
    }

    public void aderirFluxoDeCaixa(boolean opcao) {
        this.servicosContaCorrente.setFluxoDeCaixa(opcao);
    }

    public void aderirNotificacoes(boolean opcao) {
        this.servicosContaCorrente.setNotificacoesEmOperacoes(opcao);
    }

    public Operacao getUltimaOperacao() {
        return operacoes.get(operacoes.size() - 1);
    }

    public String getUltimoRealizado() {
        return realizados.get(realizados.size() - 1);
    }
}
