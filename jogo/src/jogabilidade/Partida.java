package jogabilidade;

import ambiente.Terreno;
import lerDados.*;
import funcionalidades.CalcularTempo;
import robos.*;
import controladores.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Partida {
    private Configuracao configuracaoDados;
    private Terreno terrenoDados;
    private LocalDateTime tempoFinal;

    public Partida() {
        CarregarDados dados = new CarregarDados();
        DadosProcessados dadosProcessados = dados.carregarDados();
        LocalDateTime tempoInicial = CalcularTempo.tempoAtual();
        // Variáveis do sistema
        this.configuracaoDados = dadosProcessados.getConfiguracao();
        this.terrenoDados = dadosProcessados.getTerreno();
        this.tempoFinal = tempoInicial.plusMinutes(dadosProcessados.getConfiguracao().getTempoPartida());
    }

    public void inicializarRobos() {
        ArrayList<Equipe> equipes = new ArrayList<>();
        Random random = new Random();

        System.out.printf("Relatório Inicial:%n%n");
        for (Equipe equipe : configuracaoDados.getEquipes()) {
            ArrayList<Robo> robos = new ArrayList<>();
            System.out.printf("-> Equipe %s%n%n", equipe.getNome());
            for (int contador = 0; contador < equipe.getQuantidadeRobos(); contador++) {
                int posicaoX, posicaoY;
                do {
                    posicaoX = random.nextInt(terrenoDados.getLargura());
                    posicaoY = random.nextInt(terrenoDados.getAltura());
                } while (terrenoDados.getCelula(posicaoX, posicaoY).isRoboPresente());

                terrenoDados.getCelula(posicaoX, posicaoY).setRoboPresente(true);

                // Utilizamos a classe específica para cada tipo de robô
                Robo robo = null;
                if(equipe.getTipoRobo().equals("XYZ")){
                    robo = new RoboXYZ("RoboXYZ " + contador, posicaoX, posicaoY);
                }else if(equipe.getTipoRobo().equals("FFT")){
                    robo = new RoboFTT("RoboFTT " + contador, posicaoX, posicaoY);
                }else if(equipe.getTipoRobo().equals("V")){
                    robo = new RoboV("RoboV " + contador, posicaoX, posicaoY);
                }else{
                    System.out.println("-> Erro ao definir tipo para robo");
                }

                if(equipe.getControladorRobo().equals("XYZ")){
                    robo.setControladorUtilizado(new ControladorRoboXYZ());
                }else if(equipe.getControladorRobo().equals("FFT")){
                    robo.setControladorUtilizado(new ControladorRoboFTT());
                }else if(equipe.getControladorRobo().equals("V")){
                    robo.setControladorUtilizado(new ControladorRoboV());
                }else{
                    System.out.println("-> Erro ao definir controlador para robo");
                }

                robos.add(robo);

                System.out.printf("--> Nome: %s%n", robo.getNome());
                System.out.printf("--> Direção: %s%n", robo.getDirecaoRobo());
                System.out.printf("--> Coordenada: [%d, %d]%n", robo.getPosicaoAtualX(), robo.getPosicaoAtualY());
                System.out.printf("--> Controlador sendo utilizado: %s%n", robo.getControladorUtilizado().nomeControlador());
                System.out.printf("--> Volume de hélio-3 prospectado: %.2f barris%n", robo.getVolumeHelioProspectado());
                System.out.printf("--> Rugosidade da célula %.2f%n", terrenoDados.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getRugosidade());
                System.out.printf("--> Volume de hélio-3 da célula: %.2f%n", terrenoDados.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getConcentracaoHelio());
                long minutos = CalcularTempo.tempoFaltante(tempoFinal).toMinutes();
                System.out.printf("--> Tempo faltante: %02d:%02d%n", minutos, CalcularTempo.tempoFaltante(tempoFinal).minusMinutes(minutos).getSeconds());
                System.out.println();

                int segundos = (int) (10 * getTerrenoDados().getCelula(posicaoX, posicaoY).getRugosidade());
                CalcularTempo.sleep(segundos);
            }
            equipe.setRobos(robos);
            equipes.add(equipe);
        }
        configuracaoDados.setEquipes(equipes);
    }


    public void jogabilidadeRobos(){

        System.out.printf("Relatórios Momentâneos:%n%n");

        while (CalcularTempo.tempoAtual().isBefore(getTempoFinal())) {
            for (Equipe equipe : configuracaoDados.getEquipes()) {
                System.out.printf("-> Equipe %s:%n%n", equipe.getNome());
                for (Robo robo : equipe.getRobos()) {
                    if (CalcularTempo.tempoAtual().isBefore(getTempoFinal())) {

                        controlador.seletorControlador(robo, terrenoDados);

                        System.out.printf("--> Nome: %s%n", robo.getNome());
                        System.out.printf("--> Direção: %s%n", robo.getDirecaoRobo());
                        System.out.printf("--> Coordenada atual: [%d, %d]%n", robo.getPosicaoAtualX(), robo.getPosicaoAtualY());
                        System.out.printf("--> Volume de hélio-3 prospectado: %.2f barris%n", robo.getVolumeHelioProspectado());
                        System.out.printf("--> Rugosidade da célula: %.2f%n", terrenoDados.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getRugosidade());
                        System.out.printf("--> Volume de hélio-3 da célula: %.2f%n", controlador.sensorHelioDisponivel(robo, terrenoDados));
                        long minutos = CalcularTempo.tempoFaltante(tempoFinal).toMinutes();
                        System.out.printf("--> Tempo faltante: %02d:%02d%n", minutos, CalcularTempo.tempoFaltante(tempoFinal).minusMinutes(minutos).getSeconds());
                        System.out.println();

                        CalcularTempo.sleep(1);
                    }
                }
            }
        }
        System.out.printf("-> Tempo de partida encerrado.%n");

    }

//    public void finalizarPartida() {
//        Equipe equipeVencedora = null;
//        double maiorVolumeHelio = 0;
//
//        System.out.printf("%nRelatório Final:%n");
//        for (Equipe equipe : configuracaoDados.getEquipes()) {
//            double volumeTotalHelioEquipe = 0;
//            for (Robo robo : equipe.getRobos()) {
//                volumeTotalHelioEquipe += robo.getVolumeHelioProspectado();
//            }
//            System.out.printf("--> A equipe %s prospectou %.2f de hélio-3%n", equipe.getNome(), volumeTotalHelioEquipe);
//            if (volumeTotalHelioEquipe > maiorVolumeHelio) {
//                maiorVolumeHelio = volumeTotalHelioEquipe;
//                equipeVencedora = equipe;
//            }
//        }
//        if (equipeVencedora != null) {
//            System.out.printf("%n-> A equipe %s venceu a partida!%n", equipeVencedora.getNome());
//        } else {
//            System.out.println("%n-> A partida terminou em empate");
//        }
//    }

    public Configuracao getConfiguracaoDados() {
        return configuracaoDados;
    }

    public void setConfiguracaoDados(Configuracao configuracaoDados) {
        this.configuracaoDados = configuracaoDados;
    }

    public Terreno getTerrenoDados() {
        return terrenoDados;
    }

    public void setTerrenoDados(Terreno terrenoDados) {
        this.terrenoDados = terrenoDados;
    }

    public LocalDateTime getTempoFinal() {
        return tempoFinal;
    }

    public void setTempoFinal(LocalDateTime tempoFinal) {
        this.tempoFinal = tempoFinal;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "configuracaoDados=" + configuracaoDados +
                ", terrenoDados=" + terrenoDados +
                ", tempoFinal=" + tempoFinal +
                '}';
    }
}
