package carroceria;

import robos.Robo;
import robos.RoboV;

public class CarroceriaNavegacaoAvancada extends Carroceria{
    public CarroceriaNavegacaoAvancada(Robo robo) {
        super("Navegação Avançada");
        if (robo instanceof RoboV) {
            RoboV roboV = (RoboV) robo;

            // Aumento de 30% na precisão das leituras de concentração
            double novaPrecisaoLeitura = roboV.getErroPrecisaoLeitura() * 0.7;
            roboV.setErroPrecisaoLeitura(novaPrecisaoLeitura);

            // Redução de 25% no tempo de deslocamento entre células não prospectadas
            double novoTempoDeslocamento = roboV.getAgilidadeNaMovimentacao() * 0.75;
            roboV.setAgilidadeNaMovimentacao(novoTempoDeslocamento);
        }
    }
}