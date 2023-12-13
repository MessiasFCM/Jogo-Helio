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
        setMutiplicadorErro(0);
    }

    @Override
    public void andarParaFrente(Terreno terreno) {
        super.andarParaFrente(terreno);
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