package testes;

import org.junit.Test;
import robos.Robo;
import robos.RoboXYZ;

import static org.junit.Assert.assertEquals;

public class TesteDirecaoParaDireita {

    @Test
    public void testDirecaoParaDireita() {
        // Criando um robô com direção inicial "NORTE"
        Robo robo = new RoboXYZ("RoboXYZ", 1, 1);
        robo.setDirecaoRobo("NORTE");

        // Chamando o método para virar à direita
        robo.getControladorUtilizado().direcaoParaDireita(robo);

        // Verificando se a direção foi alterada corretamente
        assertEquals("LESTE", robo.getDirecaoRobo());

        // Chamando o método para virar à direita
        robo.getControladorUtilizado().direcaoParaDireita(robo);

        // Verificando se a direção foi alterada corretamente
        assertEquals("SUL", robo.getDirecaoRobo());
    }
}
