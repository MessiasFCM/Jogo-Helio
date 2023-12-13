import funcionalidades.CalcularTempo;
import jogabilidade.Partida;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Partida partida = new Partida();
        partida.inicializarJogo();
        partida.jogabilidadeRobos();
        // partida.finalizarPartida();

        // "tipoRobos": ["XYZ CARROCERIA", "XYZ SONDA", "FFT CARROCERIA", "FFT", "V CARROCERIA SONDA", "V"]
        // "tipoRobos": ["XYZ CARROCERIA", "XYZ SONDA", "XYZ", "FFT CARROCERIA", "FFT", "V CARROCERIA SONDA", "V"]
    }
}
