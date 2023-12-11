import funcionalidades.CalcularTempo;
import jogabilidade.Partida;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Partida partida = new Partida();
        partida.inicializarRobos();
        // partida.jogabilidadeRobos();
        // partida.finalizarPartida();
    }
}
