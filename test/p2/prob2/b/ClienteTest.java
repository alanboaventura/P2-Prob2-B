/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho2_GrupoB.Problema2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClienteTest {
    
    @Test
    public void testCadastraCliente_PessoaFisica() {
        System.out.println("");
        System.out.println("");
        System.out.println("Cadastra cliente e conta");
        ClientePessoaFisica grupoB = new ClientePessoaFisica("grupoB", "4002-8922", "1234567890", "1793248650");
        ContaCorrente conta = new ContaCorrente(3, 0);
        conta.setCliente(grupoB);
        System.out.println("Valor inicial da conta de "+grupoB.getNome()+" é de: "+conta.getSaldo());
    }
    
    @Test
    public void testCadastraCliente_PessoaFisica_RealizaOperacoes() {
        System.out.println("");
        System.out.println("");
        System.out.println("Realiza serviços na conta da pessoa física");
        System.out.println("Cadastra cliente");
        ClientePessoaFisica grupoB = new ClientePessoaFisica("grupoB", "4002-8922", "1234567890", "1793248650");
        ContaCorrente conta = new ContaCorrente(3, 0);
        ContaCorrente conta2 = new ContaCorrente(3, 0);
        conta.setCliente(grupoB);
        System.out.println("Valor inicial da conta de "+grupoB.getNome()+" é de: "+conta.getSaldo());
        System.out.println("Deposita: 100");
        conta.depositar(100);
        System.out.println(""+conta.realizado.get(0));
        System.out.println("Valor na conta é de: "+conta.getSaldo());
        System.out.println("Saca: 50");
        conta.sacar(50);
        System.out.println(""+conta.realizado.get(1));
        System.out.println("Valor na conta é de: "+conta.getSaldo());
        System.out.println("Transfere 20 para a conta2");
        conta.transferir(20, conta2);
        System.out.println(""+conta.realizado.get(2));
        System.out.println("Valor na conta2 é de: "+conta2.getSaldo());
        System.out.println("Valor na conta é de: "+conta.getSaldo());
    }    
    
    
    
    @Test
    public void testCadastraCliente_PessoaJuridica_EscolheServiços() {
        System.out.println("");
        System.out.println("");
        System.out.println("Seleciona serviços da conta de Pessoa Jurídica");
        ClientePessoaJuridica grupoB = new ClientePessoaJuridica("grupoB", "123321", "99999999", "44444444", "www.servidor.com.br");
        ContaCorrente conta = new ContaCorrente(5, 6);
        conta.setCliente(grupoB);
        
    }
    
    @Test
    public void testCadastraCliente_PessoaFisica_EscolheServiços() {
        System.out.println("");
        System.out.println("");
        System.out.println("Seleciona serviços da conta de Pessoa Física");
        ClientePessoaFisica grupoB = new ClientePessoaFisica("grupoB", "4002-8922", "1234567890", "1793248650");
        ContaCorrente conta = new ContaCorrente(3, 0);
        conta.setCliente(grupoB);
        System.out.println("Valor inicial da conta de "+grupoB.getNome()+" é de: "+conta.getSaldo());
    }    
    
    
}