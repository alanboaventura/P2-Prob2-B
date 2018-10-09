package p2.prob2.b;

public class ConfiguracoesDeNotificacao {

    public ConfiguracoesDeNotificacao(boolean sms, boolean whatsapp, boolean jms) {
        this.sms = sms;
        this.whatsapp = whatsapp;
        this.jms = jms;
    }

    /**
     * Se <code>TRUE</code> a conta corrente permite notificações via SMS.
     */
    private boolean sms;

    /**
     * Se <code>TRUE</code> a conta corrente permite notificações via WHATSAPP.
     */
    private boolean whatsapp;

    /**
     * Se <code>TRUE</code> a conta corrente permite notificações via JMS.
     */
    private boolean jms;

    public boolean possuiSms() {
        return sms;
    }

    public void setSms(boolean sms) {
        this.sms = sms;
    }

    public boolean possuiWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

    public boolean possuiJms() {
        return jms;
    }

    public void setJms(boolean jms) {
        this.jms = jms;
    }
}
