package testes;

import ambiente.Terreno;
import carroceria.CarroceriaTurbo;
import controladores.ControladorRoboXYZ;
import org.junit.Test;
import robos.Robo;
import robos.RoboXYZ;
import sondas.SondaPerfuracaoRapida;

import static org.junit.Assert.assertEquals;

public class TesteAndarParaFrente {

    @Test
    public void testAndarParaFrente() {
        // Criando um robô XYZ com posição inicial e controle
        Robo robo = new RoboXYZ("RoboXYZ", 1, 1);
        robo.setControladorUtilizado(new ControladorRoboXYZ());
        robo.setSonda(new SondaPerfuracaoRapida(robo));
        robo.setCarroceria(new CarroceriaTurbo(robo));

        // Definindo a posição do robô no terreno (ajuste conforme necessário)
        Terreno terreno = new Terreno(5, 5);

        // Chamando o método para andar para frente
        robo.getControladorUtilizado().andarParaFrente(robo, terreno);

        // Verificando se a posição do robô foi atualizada corretamente (ajuste conforme necessário)
        assertEquals(2, robo.getPosicaoAtualX());
        assertEquals(1, robo.getPosicaoAtualY());
    }
}
