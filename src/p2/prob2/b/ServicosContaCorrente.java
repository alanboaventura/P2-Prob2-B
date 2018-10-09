package p2.prob2.b;

public class ServicosContaCorrente {

    public ServicosContaCorrente(Cliente cliente, boolean baixaDeInvestimento, boolean fluxoDeCaixa, boolean notificacoesEmOperacoes, boolean aceitaSms, boolean aceitaWhatsapp, boolean aceitaJms) {
        this.baixaDeInvestimento = baixaDeInvestimento;
        this.fluxoDeCaixa = fluxoDeCaixa;
        this.notificacoesEmOperacoes = notificacoesEmOperacoes;

        if (notificacoesEmOperacoes) {
            ConfiguracoesDeNotificacao configuracoesDeNotificacao = new ConfiguracoesDeNotificacao(aceitaSms, aceitaWhatsapp, aceitaJms);
            if (configuracoesDeNotificacao.possuiJms() && cliente instanceof ClientePessoaFisica) {
                throw new ConfiguracaoInvalida("Apenas clientes PF (Pessoa física) podem aderir ao envio de notificação via JMS");
            }

            this.configuracoesDeNotificacao = configuracoesDeNotificacao;
        }
    }

    /**
     * Se <code>TRUE</code>, a conta corrente em questão aderiu ao serviço "Baixa automática de investimentos".
     */
    private boolean baixaDeInvestimento;

    /**
     * Se <code>TRUE</code>, a conta corrente em questão aderiu ao serviço "Análise do fluxo de caixa".
     */
    private boolean fluxoDeCaixa;

    /**
     * Se <code>TRUE</code>, a conta corrente em questão aderiu ao serviço "Notificação das operações realizadas (saque, depósito, transferência)".
     */
    private boolean notificacoesEmOperacoes;

    /**
     * Configurações do serviço de notificações.
     */
    private ConfiguracoesDeNotificacao configuracoesDeNotificacao;

    public boolean possuiBaixaDeInvestimento() {
        return baixaDeInvestimento;
    }

    public void setBaixaDeInvestimento(boolean baixaDeInvestimento) {
        this.baixaDeInvestimento = baixaDeInvestimento;
    }

    public boolean possuiFluxoDeCaixa() {
        return fluxoDeCaixa;
    }

    public void setFluxoDeCaixa(boolean fluxoDeCaixa) {
        this.fluxoDeCaixa = fluxoDeCaixa;
    }

    public boolean possuiNotificacoesEmOperacoes() {
        return notificacoesEmOperacoes;
    }

    public void setNotificacoesEmOperacoes(boolean notificacoesEmOperacoes) {
        this.notificacoesEmOperacoes = notificacoesEmOperacoes;
    }

    public ConfiguracoesDeNotificacao getConfiguracoesDeNotificacao() {
        return configuracoesDeNotificacao;
    }

    public void setConfiguracoesDeNotificacao(ConfiguracoesDeNotificacao configuracoesDeNotificacao) {
        this.configuracoesDeNotificacao = configuracoesDeNotificacao;
    }
}
