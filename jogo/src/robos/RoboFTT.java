package robos;

import ambiente.Terreno;
import controladores.ControladorRoboFTT;
import funcionalidades.CalcularTempo;

public class RoboFTT extends Robo {
    public RoboFTT(String nome, int posicaoInicialX, int posicaoInicialY) {
        super(nome, posicaoInicialX, posicaoInicialY);
        setControladorUtilizado(new ControladorRoboFTT());
        configurarRoboFTT();
    }

    private void configurarRoboFTT() {
        setVelocidadeExtracao(0.6);
        setAgilidadeNaMovimentacao(0.3);
        setCapacidadeCarga(3.0);
        setMutiplicadorErro(1.0);
    }

    @Override
    public void prospeccao(Terreno terreno) {
        super.prospeccao(terreno);
    }

    @Override
    public void descarregarHelio() {
        super.descarregarHelio();
    }
}
