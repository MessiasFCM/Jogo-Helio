package controladores;

import ambiente.Terreno;
import robos.Robo;

public class ControladorRoboFTT extends Controlador {

    @Override
    public String nomeControlador() {
        return "Controlador FTT";
    }

    @Override
    public void andar(Robo robo, Terreno terreno) {

        int seletorLado = 0;
        int posicaoAtualX = robo.getPosicaoAtualX();
        int posicaoAtualY = robo.getPosicaoAtualY();
        double maiorQuantidade = sensorHelioDisponivel(robo, celula);

        if()


        if (seletorLado == 0) {
            robo.direcaoParaDireita(robo);
            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
                robo.andarParaFrente(terreno);
                iniciarProspeccao(robo, terreno);
            } else {
                andar(robo, terreno);
            }
        } else if (seletorLado == 1) {
            robo.direcaoParaEsquerda(robo);
            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
                robo.andarParaFrente(terreno);
                iniciarProspeccao(robo, terreno);
            } else {
                andar(robo, terreno);
            }
        } else {
            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
                robo.andarParaFrente(terreno);
                iniciarProspeccao(robo, terreno);
            } else {
                andar(robo, terreno);
            }
        }
    }
}