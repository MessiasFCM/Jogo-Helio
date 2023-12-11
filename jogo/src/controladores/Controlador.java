package controladores;

import ambiente.Terreno;
import robos.Robo;

public abstract class Controlador {
    public abstract String nomeControlador();
    public abstract void iniciarProspeccao(Robo robo, Terreno terreno);
    public abstract void andar(Robo robo, Terreno terreno);
    public abstract double sensorHelioDisponivel(Robo robo, Terreno terreno);
    // Adicione outras funções comuns a todos os controladores, se necessário
}