package controladores;

import ambiente.Terreno;
import robos.Robo;

public abstract class Controlador {
    public Controlador() {
    }
    public abstract String nomeControlador();
    public abstract void executarAcao(Robo robo, Terreno terreno);
}