package p2.prob2.b;

import org.junit.Before;
import org.junit.Test;

public class Teste {

    private ContaCorrente contaCorrente1;
    private ContaCorrente contaCorrente2;

    @Before
    public void setUp() {
        ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica("Teste Testando da Silva Sauro", "334", "777", "999");
        contaCorrente1 = new ContaCorrente(clientePessoaFisica, 3331, 22578, true, true, true, true, true, false, true, true);
        contaCorrente1.depositar(500);
        clientePessoaFisica.addConta(contaCorrente1);

        ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica("Teste Testado de Souza Júnior", "221", "888", "556", "1.1.1.1");
        contaCorrente2 = new ContaCorrente(clientePessoaJuridica, 3565, 22388, true, true, true, true, true, true, true, true);
        contaCorrente2.depositar(500);
        clientePessoaJuridica.addConta(contaCorrente2);

        ServicoBaixaInvestimento servicoBaixaInvestimento1 = new ServicoBaixaInvestimento(contaCorrente1);
        ServicoFluxoCaixa servicoFluxoCaixa1 = new ServicoFluxoCaixa(contaCorrente1);
        ServicoNotificacoes servicoNotificacoes1 = new ServicoNotificacoes(contaCorrente1);
        ServicoAnaliseInvestimento servicoAnaliseInvestimento1 = new ServicoAnaliseInvestimento(contaCorrente1);
        ServicoOfertaFinanciamento servicoOfertaFinanciamento1 = new ServicoOfertaFinanciamento(contaCorrente1);

        ServicoBaixaInvestimento servicoBaixaInvestimento2 = new ServicoBaixaInvestimento(contaCorrente2);
        ServicoFluxoCaixa servicoFluxoCaixa2 = new ServicoFluxoCaixa(contaCorrente2);
        ServicoNotificacoes servicoNotificacoes2 = new ServicoNotificacoes(contaCorrente2);
        ServicoAnaliseInvestimento servicoAnaliseInvestimento2 = new ServicoAnaliseInvestimento(contaCorrente2);
        ServicoOfertaFinanciamento servicoOfertaFinanciamento2 = new ServicoOfertaFinanciamento(contaCorrente2);
    }

    @Test
    public void saque() {
        contaCorrente1.sacar(50);
        contaCorrente2.sacar(75);
    }

    @Test
    public void deposito() {
        contaCorrente1.depositar(450);
        contaCorrente2.depositar(850);
    }

    @Test
    public void transferencia() {
        contaCorrente1.transferir(500, contaCorrente2);
        contaCorrente2.transferir(500, contaCorrente1);
    }
}
