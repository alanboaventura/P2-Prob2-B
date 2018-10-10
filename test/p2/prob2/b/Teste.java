package p2.prob2.b;

import org.testng.annotations.Test;

public class Teste {

    ContaCorrente contaCorrente1;
    ContaCorrente contaCorrente2;

    public void before() {
        ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica("Teste 1", "334", "777", "999");
        ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica("Teste 2", "221", "888", "556", "1.1.1.1");

        contaCorrente1 = new ContaCorrente(clientePessoaFisica, 3331, 22578, true, true, true, true, true, false);
        contaCorrente1.depositar(500);
        clientePessoaFisica.addConta(contaCorrente1);
        contaCorrente2 = new ContaCorrente(clientePessoaJuridica, 3565, 22388, true, true, true, true, true, true);
        contaCorrente2.depositar(500);
        clientePessoaJuridica.addConta(contaCorrente2);
    }

    @Test
    public void testeSaque() {
    }

//    @Test
//    public void testCadastraCliente_PessoaFisica() {
//        System.out.println("");
//        System.out.println("");
//        System.out.println("Cadastra cliente e conta");
//        ClientePessoaFisica grupoB = new ClientePessoaFisica("grupoB", "4002-8922", "1234567890", "1793248650");
//        ContaCorrente conta = new ContaCorrente(3, 0);
//        conta.setCliente(grupoB);
//        System.out.println("Valor inicial da conta de " + grupoB.getNome() + " é de: " + conta.getSaldo());
//    }
//
//    @Test
//    public void testCadastraCliente_PessoaFisica_RealizaOperacoes() {
//        System.out.println("");
//        System.out.println("");
//        System.out.println("Realiza serviços na conta da pessoa física");
//        System.out.println("Cadastra cliente");
//        ClientePessoaFisica grupoB = new ClientePessoaFisica("grupoB", "4002-8922", "1234567890", "1793248650");
//        ContaCorrente conta = new ContaCorrente(3, 0);
//        ContaCorrente conta2 = new ContaCorrente(3, 0);
//        conta.setCliente(grupoB);
//        System.out.println("Valor inicial da conta de " + grupoB.getNome() + " é de: " + conta.getSaldo());
//        System.out.println("Deposita: 100");
//        conta.depositar(100);
//        System.out.println("" + conta.realizado.get(0));
//        System.out.println("Valor na conta é de: " + conta.getSaldo());
//        System.out.println("Saca: 50");
//        conta.sacar(50);
//        System.out.println("" + conta.realizado.get(1));
//        System.out.println("Valor na conta é de: " + conta.getSaldo());
//        System.out.println("Transfere 20 para a conta2");
//        conta.transferir(20, conta2);
//        System.out.println("" + conta.realizado.get(2));
//        System.out.println("Valor na conta2 é de: " + conta2.getSaldo());
//        System.out.println("Valor na conta é de: " + conta.getSaldo());
//    }
//
//
//    @Test
//    public void testCadastraCliente_PessoaJuridica_EscolheServiços() {
//        System.out.println("");
//        System.out.println("");
//        System.out.println("Seleciona serviços da conta de Pessoa Jurídica");
//        ClientePessoaJuridica grupoB = new ClientePessoaJuridica("grupoB", "123321", "99999999", "44444444", "www.servidor.com.br");
//        ContaCorrente conta = new ContaCorrente(5, 6);
//        conta.setCliente(grupoB);
//
//    }
//
//    @Test
//    public void testCadastraCliente_PessoaFisica_EscolheServiços() {
//        System.out.println("");
//        System.out.println("");
//        System.out.println("Seleciona serviços da conta de Pessoa Física");
//        ClientePessoaFisica grupoB = new ClientePessoaFisica("grupoB", "4002-8922", "1234567890", "1793248650");
//        ContaCorrente conta = new ContaCorrente(3, 0);
//        conta.setCliente(grupoB);
//        System.out.println("Valor inicial da conta de " + grupoB.getNome() + " é de: " + conta.getSaldo());
//    }
}