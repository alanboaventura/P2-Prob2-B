package p2.prob2.b;

import org.junit.Before;
import org.junit.Test;

public class Teste {

    public Teste() {
    }

    ContaCorrente contaCorrente1;
    ContaCorrente contaCorrente2;

    @Before
    public void setUp() {
        ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica("Teste 1", "334", "777", "999");
        ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica("Teste 2", "221", "888", "556", "1.1.1.1");

        contaCorrente1 = new ContaCorrente(clientePessoaFisica, 3331, 22578, true, true, true, true, true, false);
        contaCorrente1.depositar(500);
        clientePessoaFisica.addConta(contaCorrente1);
        contaCorrente2 = new ContaCorrente(clientePessoaJuridica, 3565, 22388, true, true, true, true, true, true);
        contaCorrente2.depositar(500);
        clientePessoaJuridica.addConta(contaCorrente2);
        
        ServicoBaixaInvestimento servicoBaixaInvestimento1 = new ServicoBaixaInvestimento(contaCorrente1);
        ServicoFluxoCaixa servicoFluxoCaixa1 = new ServicoFluxoCaixa(contaCorrente1);
        ServicoNotificacoes servicoNotificacoes1 = new ServicoNotificacoes(contaCorrente1);

        ServicoBaixaInvestimento servicoBaixaInvestimento2 = new ServicoBaixaInvestimento(contaCorrente2);
        ServicoFluxoCaixa servicoFluxoCaixa2 = new ServicoFluxoCaixa(contaCorrente2);
        ServicoNotificacoes servicoNotificacoes2 = new ServicoNotificacoes(contaCorrente2);
    }

    @Test
    public void saque() {
        contaCorrente1.sacar(50);
        // TODO Dever de casa, e fazer pras demais operações também.
    }
}
