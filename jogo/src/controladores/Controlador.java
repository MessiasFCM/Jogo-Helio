package controladores;

import ambiente.Terreno;
import robos.Robo;
import ambiente.Celula;

public abstract class Controlador {
    public abstract String nomeControlador();
    public abstract void andar(Robo robo, Terreno terreno);

    public double sensorHelioDisponivel(Robo robo, Celula celula) {

        return 0;
    }
    public void iniciarProspeccao(Robo robo, Terreno terreno){
        robo.prospeccao((terreno));
    };

    // Adicione outras funções comuns a todos os controladores, se necessário
}