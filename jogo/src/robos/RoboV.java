package robos;

import ambiente.Terreno;
import controladores.ControladorRoboV;

public class RoboV extends Robo {

    public RoboV(String nome, int posicaoInicialX, int posicaoInicialY) {
        super(nome, posicaoInicialX, posicaoInicialY);
        setControladorUtilizado(new ControladorRoboV());
        configurarRoboV();
    }

    private void configurarRoboV() {
        setVelocidadeExtracao(1.0);
        setAgilidadeNaMovimentacao(1.0);
        setPorcentagemCarga(1.0);
        setErroPrecisaoLeitura(1.0);
    }
}