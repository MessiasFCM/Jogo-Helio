package testes;

import ambiente.Terreno;
import carroceria.CarroceriaTurbo;
import controladores.ControladorRoboXYZ;
import org.junit.Test;
import robos.Robo;
import robos.RoboXYZ;
import sondas.SondaPerfuracaoRapida;

import static org.junit.Assert.assertEquals;

public class TesteProspeccao {

    @Test
    public void testProspeccao() {
        // Criando um robô XYZ com posição inicial e controle
        Robo robo = new RoboXYZ("RoboXYZ", 1, 1);
        robo.setControladorUtilizado(new ControladorRoboXYZ());
        robo.setSonda(new SondaPerfuracaoRapida(robo));
        robo.setCarroceria(new CarroceriaTurbo(robo));

        // Definindo a posição do robô no terreno (ajuste conforme necessário)
        Terreno terreno = new Terreno(5, 5);
        terreno.getCelula(1,1).setConcentracaoHelio(0.3);

        // Chamando o método de prospecção
        robo.getControladorUtilizado().iniciarProspeccao(robo, terreno);

        // Verificando se a prospecção foi realizada corretamente (ajuste conforme necessário)
        assertEquals(0.3, robo.getVolumeHelioProspectado(), robo.getErroPrecisaoLeitura());
        assertEquals(0, terreno.getCelula(1, 1).getConcentracaoHelio(), 0.001);
    }
}
