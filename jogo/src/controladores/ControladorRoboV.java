package controladores;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboV;

public class ControladorRoboV extends Controlador {

    @Override
    public String nomeControlador() {
        return "Controlador V";
    }

    @Override
    public void andar(Robo robo, Terreno terreno) {

    }

    @Override
    public double sensorHelioDisponivel(Robo robo, Terreno terreno) {
        return 0;
    }


}