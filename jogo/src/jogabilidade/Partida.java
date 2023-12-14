package jogabilidade;

import ambiente.Celula;
import ambiente.Terreno;
import carroceria.CarroceriaFortaleza;
import carroceria.CarroceriaNavegacaoAvancada;
import carroceria.CarroceriaTurbo;
import lerDados.*;
import funcionalidades.CalcularTempo;
import robos.*;
import controladores.*;
import sondas.SondaAltaCapacidade;
import sondas.SondaPerfuracaoRapida;
import sondas.SondaPrecisao;

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

    public void inicializarJogo() {
        ArrayList<Equipe> equipes = new ArrayList<>();
        Random random = new Random();

        System.out.printf("========================================%n");
        System.out.printf("========== Relatório Inicial ===========%n");
        System.out.printf("========================================%n%n");

        for (Equipe equipe : configuracaoDados.getEquipes()) {
            ArrayList<Robo> robos = new ArrayList<>();
            int contadorTipoXYZ = 0, contadorTipoFFT = 0, contadorTipoV = 0;
            System.out.printf("===== Equipe: %s =====%n%n", equipe.getNome());
            for (int contador = 0; contador < equipe.getTipoRobos().size(); contador++) {
                int posicaoX, posicaoY;
                do {
                    posicaoX = random.nextInt(terrenoDados.getLargura());
                    posicaoY = random.nextInt(terrenoDados.getAltura());
                } while (terrenoDados.getCelula(posicaoX, posicaoY).isRoboPresente());

                terrenoDados.getCelula(posicaoX, posicaoY).setRoboPresente(true);

                Robo robo = null;
                boolean possuiCarroceria, possuiSonda;

                String tipoRobo = equipe.getTipoRobos().get(contador);
                String[] tipoECarroceria = tipoRobo.split(" ");
                String tipo = tipoECarroceria[0];
                if(tipoECarroceria.length>2){
                    possuiCarroceria = tipoECarroceria.length > 1 && tipoECarroceria[1].equals("CARROCERIA");
                    possuiSonda = tipoECarroceria.length > 2 && tipoECarroceria[2].equals("SONDA");
                }else{
                    possuiCarroceria = tipoECarroceria.length > 1 && tipoECarroceria[1].equals("CARROCERIA");
                    possuiSonda = tipoECarroceria.length > 1 && tipoECarroceria[1].equals("SONDA");
                }

                
                switch (tipo) {
                    case "XYZ":
                        robo = new RoboXYZ("RoboXYZ " + contador, posicaoX, posicaoY);
                        if(possuiCarroceria){ robo.setCarroceria(new CarroceriaTurbo()); }
                        if(possuiSonda){ robo.setSonda(new SondaPerfuracaoRapida()); }
                        contadorTipoXYZ++;
                        break;
                    case "FTT":
                        robo = new RoboFTT("RoboFTT " + contador, posicaoX, posicaoY);
                        if(possuiCarroceria){ robo.setCarroceria(new CarroceriaFortaleza()); }
                        if(possuiSonda){ robo.setSonda(new SondaAltaCapacidade()); }
                        contadorTipoFFT++;
                        break;
                    case "V":
                        robo = new RoboV("RoboV " + contador, posicaoX, posicaoY);
                        if(possuiCarroceria){ robo.setCarroceria(new CarroceriaNavegacaoAvancada()); }
                        if(possuiSonda){ robo.setSonda(new SondaPrecisao()); }
                        contadorTipoV++;
                        break;
                    default:
                        System.out.println("==> Erro ao definir tipo para robo");
                        break;
                }
                robos.add(robo);

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

                int segundos = (int) (10 * getTerrenoDados().getCelula(posicaoX, posicaoY).getRugosidade());
                CalcularTempo.sleep(segundos);
            }
            equipe.setRobos(robos);
            equipes.add(equipe);

            // Verificação Equipe
            if (contadorTipoXYZ >= 2 && contadorTipoFFT >= 2 && contadorTipoV >= 2) {
                System.out.printf("==> Equipe %s atende aos requisitos.%n", equipe.getNome());
            } else {
                System.out.printf("==> Equipe %s não possui o mínimo de 2 robôs de cada tipo.%n", equipe.getNome());
            }
        }
        configuracaoDados.setEquipes(equipes);
    }

    public void jogabilidadeRobos(){

        System.out.printf("========================================%n");
        System.out.printf("======== Relatório Momentâneo ==========%n");
        System.out.printf("========================================%n%n");

        while (CalcularTempo.tempoAtual().isBefore(getTempoFinal())) {
            for (Equipe equipe : configuracaoDados.getEquipes()) {
                System.out.printf("===== Equipe: %s =====%n%n", equipe.getNome());
                for (Robo robo : equipe.getRobos()) {
                    if (CalcularTempo.tempoAtual().isBefore(getTempoFinal())) {

                        robo.getControladorUtilizado().andar(robo,terrenoDados);

                        System.out.println("=== Informações do Robô ===");
                        System.out.printf("Nome: %s%n", robo.getNome());
                        System.out.printf("Direção: %s%n", robo.getDirecaoRobo());
                        System.out.printf("Coordenada atual: [%d, %d]%n", robo.getPosicaoAtualX(), robo.getPosicaoAtualY());
                        System.out.printf("Volume de Hélio-3 prospectado: %.2f barris%n", robo.getVolumeHelioProspectado());

                        Celula celulaAtual = terrenoDados.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY());
                        System.out.printf("Rugosidade da célula: %.2f%n", celulaAtual.getRugosidade());
                        System.out.printf("Volume de Hélio-3 da célula: %.2f%n", celulaAtual.getConcentracaoHelio());

                        long minutos = CalcularTempo.tempoFaltante(tempoFinal).toMinutes();
                        System.out.printf("Tempo faltante: %02d:%02d%n", minutos, CalcularTempo.tempoFaltante(tempoFinal).minusMinutes(minutos).getSeconds());

                        System.out.println();

                        CalcularTempo.sleep(1);
                    }
                }
            }
        }
        System.out.printf("==> Tempo de partida encerrado.%n");

    }

    public void finalizarPartida() {
        Equipe equipeVencedora = null;
        double maiorVolumeHelio = 0;

        System.out.printf("========================================%n");
        System.out.printf("=========== Relatório Final ============%n");
        System.out.printf("========================================%n%n");

        for (Equipe equipe : configuracaoDados.getEquipes()) {
            double volumeTotalHelioEquipe = 0;
            for (Robo robo : equipe.getRobos()) {
                volumeTotalHelioEquipe += robo.getVolumeHelioProspectado();
            }
            System.out.printf("=====> A equipe %s prospectou %.2f de hélio-3%n", equipe.getNome(), volumeTotalHelioEquipe);
            if (volumeTotalHelioEquipe > maiorVolumeHelio) {
                maiorVolumeHelio = volumeTotalHelioEquipe;
                equipeVencedora = equipe;
            }
        }
        if (equipeVencedora != null) {
            System.out.printf("%n===== A equipe %s venceu a partida! =====%n", equipeVencedora.getNome());
        } else {
            System.out.printf("%n===== A partida terminou em empate =====%n");
        }
    }

    // Métodos get e set + toString

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
