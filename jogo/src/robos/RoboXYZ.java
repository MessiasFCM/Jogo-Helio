package robos;

import ambiente.Terreno;
import controladores.ControladorRoboXYZ;
import funcionalidades.CalcularTempo;

public class RoboXYZ extends Robo {
    public RoboXYZ(String nome, int posicaoInicialX, int posicaoInicialY) {
        super(nome, posicaoInicialX, posicaoInicialY);
        setControladorUtilizado(new ControladorRoboXYZ());
        configurarRoboXYZ();
    }

    private void configurarRoboXYZ() {
        setVelocidadeExtracao(2.0);
        setAgilidadeNaMovimentacao(1.5);
        setPorcentagemCarga(0.5);
        setErroPrecisaoLeitura(1.2);
    }
}