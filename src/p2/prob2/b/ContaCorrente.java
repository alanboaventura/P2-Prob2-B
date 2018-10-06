package p2.prob2.b;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Esta classe oferece as funcionalidades básicas para atender ao Problema 2.
 */

/**
 * @author marcel
 */
public class ContaCorrente {
    private int numero;
    private int agencia;
    private Cliente cliente;
    private double saldo = 0;
    private List<Operacao> operacoes = new ArrayList();
    private List<Observer> observers = new ArrayList<Observer>();
    private List<String> metodosNot = new ArrayList<String>();

    public ContaCorrente(int numero, int agencia) {
        this.setNumero(numero);
        this.setAgencia(agencia);
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
        notifyAllObservers();
    }

    public void depositar(double valor) {
        Operacao oper = new Operacao(valor, this.getSaldo(), TipoOperacao.ENTRADA, new Date(), this);
        operacoes.add(oper);
        this.saldo += valor;
        notifyAllObservers();
    }

    public void transferir(double valor, ContaCorrente destino) {
        if (valor > this.getSaldo()) {
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }
        destino.receberTransferencia(valor, this);
        Operacao oper = new OperacaoTransferencia(valor, this.getSaldo(), TipoOperacao.SAIDA, new Date(), this, destino);
        operacoes.add(oper);
        this.saldo -= valor;
        notifyAllObservers();
    }

    private void receberTransferencia(double valor, ContaCorrente origem) {
        Operacao oper = new OperacaoTransferencia(valor, this.getSaldo(), TipoOperacao.ENTRADA, new Date(), this, origem);
        operacoes.add(oper);
        this.saldo += valor;
        notifyAllObservers();
    }

    public void add(Observer observer){
        this.observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers)
            observer.update();
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

    public List<String> getMetodosNot() {
        return metodosNot;
    }

    public void setMetodosNot(List<String> metodosNot) {
        this.metodosNot = metodosNot;
    }
}
