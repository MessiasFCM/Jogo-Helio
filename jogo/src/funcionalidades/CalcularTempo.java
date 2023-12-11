package funcionalidades;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalcularTempo {
    public static LocalDateTime tempoAtual(){
        return LocalDateTime.now();
    }
    public static Duration tempoFaltante(LocalDateTime tempoFinal){
        Duration diferenca = Duration.between(tempoAtual(), tempoFinal);
        return diferenca;
    }
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
