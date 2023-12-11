package robos;

import ambiente.Terreno;
import controladores.ControladorRoboV;

public class RoboV extends Robo {
    public RoboV(String nome, int posicaoInicialX, int posicaoInicialY) {
        super(nome, posicaoInicialX, posicaoInicialY);
        this.setControladorUtilizado(new ControladorRoboV());
    }

    @Override
    public void andarParaFrente(Terreno terreno) {

    }

    @Override
    public void prospeccao(Terreno terreno) {

    }

    @Override
    public boolean movimentoValido(String direcao, Terreno terreno) {
        return false;
    }

    @Override
    public void descarregarHelio() {

    }

}