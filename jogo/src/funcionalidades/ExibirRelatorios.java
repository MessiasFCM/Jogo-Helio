package funcionalidades;

import ambiente.Celula;
import ambiente.Terreno;
import robos.Robo;

import java.time.LocalDateTime;

public class ExibirRelatorios {
    public void exibirRelatoriosRoboIniciais(Robo robo, Terreno terrenoDados, LocalDateTime tempoFinal) {
        System.out.println("=== Informações do Robô ===");
        System.out.printf("Nome: %s%n", robo.getNome());
        System.out.printf("Direção: %s%n", robo.getDirecaoRobo());
        System.out.printf("Coordenada: [%d, %d]%n", robo.getPosicaoAtualX(), robo.getPosicaoAtualY());
        System.out.printf("Controlador: %s%n", robo.getControladorUtilizado().nomeControlador());
        System.out.printf("Volume de Hélio-3 prospectado: %.2f barris%n", robo.getVolumeHelioProspectado());

        Celula celulaAtual = terrenoDados.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY());
        System.out.printf("Rugosidade da célula: %.2f%n", celulaAtual.getRugosidade());
        System.out.printf("Volume de Hélio-3 da célula: %.2f%n", celulaAtual.getConcentracaoHelio());

        long minutos = CalcularTempo.tempoFaltante(tempoFinal).toMinutes();
        System.out.printf("Tempo faltante: %02d:%02d%n", minutos, CalcularTempo.tempoFaltante(tempoFinal).minusMinutes(minutos).getSeconds());

        System.out.println();
    }

    public void exibirInformacoesRoboMomentaneas(Robo robo, Terreno terrenoDados, LocalDateTime tempoFinal) {
        System.out.println("=== Informações do Robô ===");
        System.out.printf("Nome: %s%n", robo.getNome());
        System.out.printf("Direção: %s%n", robo.getDirecaoRobo());
        System.out.printf("Coordenada atual: [%d, %d]%n", robo.getPosicaoAtualX(), robo.getPosicaoAtualY());
        double totalHelio = robo.getVolumeHelioProspectadoTotal() + robo.getVolumeHelioProspectado();
        System.out.printf("Volume de Hélio-3 total prospectado: %.2f barris%n", totalHelio);
        System.out.printf("Carga de Hélio-3 prospectado: %.2f barris%n", robo.getVolumeHelioProspectado());

        Celula celulaAtual = terrenoDados.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY());
        System.out.printf("Rugosidade da célula: %.2f%n", celulaAtual.getRugosidade());
        System.out.printf("Volume de Hélio-3 da célula: %.2f%n", celulaAtual.getConcentracaoHelio());

        long minutos = CalcularTempo.tempoFaltante(tempoFinal).toMinutes();
        System.out.printf("Tempo faltante: %02d:%02d%n", minutos, CalcularTempo.tempoFaltante(tempoFinal).minusMinutes(minutos).getSeconds());

        System.out.println();
    }
}
