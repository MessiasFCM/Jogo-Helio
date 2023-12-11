package robos;

import ambiente.Terreno;
import controladores.ControladorRoboXYZ;

public class RoboXYZ extends Robo {
    public RoboXYZ(String nome, int posicaoInicialX, int posicaoInicialY) {
        super(nome, posicaoInicialX, posicaoInicialY);
        this.setControladorUtilizado(new ControladorRoboXYZ());
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