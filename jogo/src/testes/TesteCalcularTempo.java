package testes;

import funcionalidades.CalcularTempo;
import org.junit.Test;
import java.time.Duration;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;

public class TesteCalcularTempo {

    @Test
    public void testTempoFaltante() {
        LocalDateTime tempoAtual = LocalDateTime.now();
        LocalDateTime tempoFuturo = tempoAtual.plusMinutes(5);

        Duration diferenca = CalcularTempo.tempoFaltante(tempoFuturo);

        // Verifica se a diferença é aproximadamente 5 minutos (300 segundos)
        assertEquals(300, diferenca.getSeconds(), 1);
    }

    @Test
    public void testSleep() {
        LocalDateTime inicio = LocalDateTime.now();
        int segundos = 3;

        CalcularTempo.sleep(segundos);

        LocalDateTime fim = LocalDateTime.now();
        Duration duracao = Duration.between(inicio, fim);

        // Verifica se o tempo de sono foi aproximadamente 3 segundos
        assertEquals(segundos, duracao.getSeconds(), 1);
    }
}
