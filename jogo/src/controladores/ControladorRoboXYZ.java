package controladores;

import ambiente.Terreno;
import robos.Robo;
import robos.RoboXYZ;

public class ControladorRoboXYZ extends Controlador {
    @Override
    public String nomeControlador() {
        return "Controlador XYZ";
    }

    @Override
    public void executarAcao(Robo robo, Terreno terreno) {
        if (robo instanceof RoboXYZ) {
            RoboXYZ roboXYZ = (RoboXYZ) robo;
            // Implemente a lógica de execução para o ControladorRoboXYZ
            // ...
        }
    }
}