package controladores;

import ambiente.Terreno;
import robos.Robo;
import java.util.Random;

public abstract class Controlador {
    public abstract String nomeControlador();
    public abstract void andar(Robo robo, Terreno terreno);

    public double sensorHelioDisponivel(Robo robo, Terreno terreno) {
        Random geradorAleatorio = new Random();
        double erro = terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getCoeficienteErroLeitura()[0] + geradorAleatorio.nextDouble() * (terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getCoeficienteErroLeitura()[1] - terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getCoeficienteErroLeitura()[0]);
        double concentracaoComErro = robo.getMutiplicadorErro() * terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getConcentracaoHelio() + (terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getConcentracaoHelio() * erro);
        return concentracaoComErro;
    }
    public void iniciarProspeccao(Robo robo, Terreno terreno){
        robo.prospeccao((terreno));
    };
}