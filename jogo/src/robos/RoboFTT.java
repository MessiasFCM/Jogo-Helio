package robos;

import ambiente.Terreno;
import controladores.ControladorRoboFTT;

public class RoboFTT extends Robo {
    public RoboFTT(String nome, int posicaoInicialX, int posicaoInicialY) {
        super(nome, posicaoInicialX, posicaoInicialY);
        this.setControladorUtilizado(new ControladorRoboFTT());
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
