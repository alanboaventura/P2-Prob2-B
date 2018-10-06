package p2.prob2.b;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        ClientePessoaFisica p1 = new ClientePessoaFisica("P1", "666", "333", "111");
        ContaCorrente c1 = new ContaCorrente(1, 1);
        Notificacoes n = new Notificacoes(c1);
        Baixa b = new Baixa(c1);
        Analise a = new Analise(c1);
        List<String> mets = new ArrayList<String>();

        mets.add("SMS");
        mets.add("WhatsApp");

        c1.setMetodosNot(mets);
        p1.addConta(c1);

        c1.depositar(4);
    }
}
