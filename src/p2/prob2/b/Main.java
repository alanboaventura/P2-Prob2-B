package p2.prob2.b;

public class Main {

    public static void main(String args[]) {
        ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica("Teste 1", "334", "777", "999");
        ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica("Teste 2", "221", "888", "556", "1.1.1.1");

        ContaCorrente contaCorrente1 = new ContaCorrente(clientePessoaFisica, 3331, 22578, true, true, true, true, true, false);
        clientePessoaFisica.addConta(contaCorrente1);
        ContaCorrente contaCorrente2 = new ContaCorrente(clientePessoaJuridica, 3565, 22388, true, true, true, true, true, true);
        clientePessoaFisica.addConta(contaCorrente2);

        ServicoBaixaInvestimento servicoBaixaInvestimento1 = new ServicoBaixaInvestimento(contaCorrente1);
        ServicoFluxoCaixa servicoFluxoCaixa1 = new ServicoFluxoCaixa(contaCorrente1);
        ServicoNotificacoes servicoNotificacoes1 = new ServicoNotificacoes(contaCorrente1);

        ServicoBaixaInvestimento servicoBaixaInvestimento2 = new ServicoBaixaInvestimento(contaCorrente2);
        ServicoFluxoCaixa servicoFluxoCaixa2 = new ServicoFluxoCaixa(contaCorrente2);
        ServicoNotificacoes servicoNotificacoes2 = new ServicoNotificacoes(contaCorrente2);

        contaCorrente1.depositar(500);
        contaCorrente1.sacar(50);
        contaCorrente1.transferir(100, contaCorrente2);

        contaCorrente2.depositar(500);
        contaCorrente2.sacar(50);
        contaCorrente2.transferir(100, contaCorrente1);
    }
}
