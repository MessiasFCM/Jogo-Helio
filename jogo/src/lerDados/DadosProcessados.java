package lerDados;

import ambiente.Terreno;
import jogabilidade.Configuracao;

public class DadosProcessados {
    private final Configuracao configuracao;
    private final Terreno terreno;

    public DadosProcessados(Configuracao configuracao, Terreno terreno) {
        this.configuracao = configuracao;
        this.terreno = terreno;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public Terreno getTerreno() {
        return terreno;
    }
}
