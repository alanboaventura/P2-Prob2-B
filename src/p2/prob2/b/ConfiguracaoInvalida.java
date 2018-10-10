package p2.prob2.b;

/**
 * Exceção referente a uma configuração inválida de conta corrente.
 */
public class ConfiguracaoInvalida extends IllegalArgumentException {

    public ConfiguracaoInvalida(String msg) {
        super(msg);
    }
}
