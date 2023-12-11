package ambiente;

import java.util.Arrays;

public class Celula {
    private double concentracaoHelio;
    private double[] coeficienteErroLeitura;
    private double rugosidade;
    private boolean roboPresente;
    private boolean roboProspectando;

    public Celula() {
        this.concentracaoHelio = 0.0;
        this.coeficienteErroLeitura = new double[]{0.02, 0.02};
        this.rugosidade = 1.0;
        this.roboPresente = false;
        this.roboProspectando = false;
    }

    public double getConcentracaoHelio() {
        return concentracaoHelio;
    }

    public void setConcentracaoHelio(double concentracaoHelio) {
        this.concentracaoHelio = concentracaoHelio;
    }

    public double[] getCoeficienteErroLeitura() {
        return coeficienteErroLeitura;
    }

    public void setCoeficienteErroLeitura(double[] coeficienteErroLeitura) {
        this.coeficienteErroLeitura = coeficienteErroLeitura;
    }

    public double getRugosidade() {
        return rugosidade;
    }

    public void setRugosidade(double rugosidade) {
        this.rugosidade = rugosidade;
    }

    public boolean isRoboPresente() {
        return roboPresente;
    }

    public void setRoboPresente(boolean roboPresente) {
        this.roboPresente = roboPresente;
    }

    public boolean isroboProspectando() {
        return roboProspectando;
    }

    public void setRoboProspectando(boolean roboProspectando) {
        this.roboProspectando = roboProspectando;
    }

    @Override
    public String toString() {
        return "Celula{" +
                "concentracaoHelio=" + concentracaoHelio +
                ", coeficienteErroLeitura=" + Arrays.toString(coeficienteErroLeitura) +
                ", rugosidade=" + rugosidade +
                ", roboPresente=" + roboPresente +
                ", roboProspectando=" + roboProspectando +
                '}';
    }
}