package robos;

import ambiente.Terreno;
import controladores.ControladorRoboXYZ;
import funcionalidades.CalcularTempo;

public class RoboXYZ extends Robo {
    public RoboXYZ(String nome, int posicaoInicialX, int posicaoInicialY) {
        super(nome, posicaoInicialX, posicaoInicialY);
        this.setControladorUtilizado(new ControladorRoboXYZ());
    }

    @Override
    public void andarParaFrente(Terreno terreno) {
//        if(getSonda().podeSondar()){ // Caso sondar, ele não possui um intervalo reduzido
//            int segundos = (int) (1 * terreno.getCelula(getPosicaoAtualX(), getPosicaoAtualX()).getRugosidade());
//            CalcularTempo.sleep(segundos);
//        }else{
//            int segundos = (int) (10 * terreno.getCelula(getPosicaoAtualX(), getPosicaoAtualY()).getRugosidade());
//            CalcularTempo.sleep(segundos);
//        }
    }

    @Override
    public void prospeccao(Terreno terreno) {

    }

    @Override
    public void descarregarHelio() {

    }

}