package jogabilidade;

import ambiente.Celula;
import ambiente.Terreno;
import carroceria.Carroceria;
import carroceria.CarroceriaFortaleza;
import carroceria.CarroceriaNavegacaoAvancada;
import carroceria.CarroceriaTurbo;
import funcionalidades.ExibirRelatorios;
import lerDados.*;
import funcionalidades.CalcularTempo;
import robos.*;
import sondas.Sonda;
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
        inicializarPartida();
    }

    private void inicializarPartida() {
        CarregarDados dados = new CarregarDados();
        DadosProcessados dadosProcessados = dados.carregarDados();
        LocalDateTime tempoInicial = CalcularTempo.tempoAtual();

        // Variáveis do sistema
        this.configuracaoDados = dadosProcessados.getConfiguracao();
        this.terrenoDados = dadosProcessados.getTerreno();
        this.tempoFinal = tempoInicial.plusMinutes(configuracaoDados.getTempoPartida());

        System.out.printf("========================================%n");
        System.out.printf("========== Relatório Inicial ===========%n");
        System.out.printf("========================================%n%n");

        criarRobos();
    }

    public void criarRobos() {
        ArrayList<Equipe> equipes = new ArrayList<>();
        ExibirRelatorios exibirRelatorios = new ExibirRelatorios();
        Random random = new Random();

        for (Equipe equipe : configuracaoDados.getEquipes()) {
            ArrayList<Robo> robos = new ArrayList<>();
            System.out.printf("===== Equipe: %s =====%n%n", equipe.getNome());
            int contadorTipos = 0;
            for (String tipoRobo : equipe.getTipoRobos()) {
                int posicaoX, posicaoY;
                do {
                    posicaoX = random.nextInt(terrenoDados.getLargura());
                    posicaoY = random.nextInt(terrenoDados.getAltura());
                } while (terrenoDados.getCelula(posicaoX, posicaoY).isRoboPresente());


                terrenoDados.getCelula(posicaoX, posicaoY).setRoboPresente(true);

                Robo robo = criarRobo(tipoRobo, contadorTipos, posicaoX, posicaoY);
                contadorTipos++;

                robos.add(robo);

                exibirRelatorios.exibirRelatoriosRoboIniciais(robo, terrenoDados, tempoFinal);

                int segundos = (int) (10 * getTerrenoDados().getCelula(posicaoX, posicaoY).getRugosidade());
                CalcularTempo.sleep(segundos);
            }
            equipe.setRobos(robos);
            equipes.add(equipe);

            verificarEquipe(equipe);
        }
        configuracaoDados.setEquipes(equipes);
    }

    private Robo criarRobo(String tipoRobo, int contadorTipos, int posicaoX, int posicaoY) {
        String[] tipoECarroceria = tipoRobo.split(" ");
        String tipo = tipoECarroceria[0];
        boolean possuiCarroceria, possuiSonda;
        possuiCarroceria = tipoECarroceria.length > 1 && tipoECarroceria[1].equals("CARROCERIA");
        if(tipoECarroceria.length>2){
            possuiSonda = tipoECarroceria.length > 2 && tipoECarroceria[2].equals("SONDA");
        }else{
            possuiSonda = tipoECarroceria.length > 1 && tipoECarroceria[1].equals("SONDA");
        }

        switch (tipo) {
            case "XYZ":
                return criarRoboXYZ(posicaoX, contadorTipos, posicaoY, possuiCarroceria, possuiSonda);
            case "FTT":
                return criarRoboFTT(posicaoX, contadorTipos, posicaoY, possuiCarroceria, possuiSonda);
            case "V":
                return criarRoboV(posicaoX, contadorTipos, posicaoY, possuiCarroceria, possuiSonda);
            default:
                throw new IllegalArgumentException("Tipo de robô inválido: " + tipo);
        }
    }

    private Robo criarRoboXYZ(int posicaoX, int contadorTipos, int posicaoY, boolean possuiCarroceria, boolean possuiSonda) {
        RoboXYZ robo = new RoboXYZ("RoboXYZ " + contadorTipos, posicaoX, posicaoY);
        robo.setCarroceria(possuiCarroceria ? new CarroceriaTurbo(robo) : new Carroceria("Padrão"));
        robo.setSonda(possuiSonda ? new SondaPerfuracaoRapida(robo) : new Sonda("Padrão"));
        return robo;
    }

    private Robo criarRoboFTT(int posicaoX, int contadorTipos, int posicaoY, boolean possuiCarroceria, boolean possuiSonda) {
        RoboFTT robo = new RoboFTT("RoboFTT " + contadorTipos, posicaoX, posicaoY);
        robo.setCarroceria(possuiCarroceria ? new CarroceriaFortaleza(robo) : new Carroceria("Padrão"));
        robo.setSonda(possuiSonda ? new SondaAltaCapacidade(robo) : new Sonda("Padrão"));
        return robo;
    }

    private Robo criarRoboV(int posicaoX, int contadorTipos, int posicaoY, boolean possuiCarroceria, boolean possuiSonda) {
        RoboV robo = new RoboV("RoboV " + contadorTipos, posicaoX, posicaoY);
        robo.setCarroceria(possuiCarroceria ? new CarroceriaNavegacaoAvancada(robo) : new Carroceria("Padrão"));
        robo.setSonda(possuiSonda ? new SondaPrecisao(robo) : new Sonda("Padrão"));
        return robo;
    }

    private void verificarEquipe(Equipe equipe) {
        int contadorTipoXYZ = countRobosByType(equipe, "XYZ");
        int contadorTipoFTT = countRobosByType(equipe, "FTT");
        int contadorTipoV = countRobosByType(equipe, "V");

        if (contadorTipoXYZ >= 2 && contadorTipoFTT >= 2 && contadorTipoV >= 2) {
            System.out.printf("==> Equipe %s atende aos requisitos.%n%n", equipe.getNome());
        } else {
            System.out.printf("==> Equipe %s não possui o mínimo de 2 robôs de cada tipo.%n%n", equipe.getNome());
        }
    }

    private int countRobosByType(Equipe equipe, String tipo) {
        return (int) equipe.getRobos().stream().filter(robo -> robo.getNome().startsWith("Robo" + tipo)).count();
    }
    public void jogabilidadeRobos(){
        ExibirRelatorios exibirRelatorios = new ExibirRelatorios();

        System.out.printf("========================================%n");
        System.out.printf("======== Relatório Momentâneo ==========%n");
        System.out.printf("========================================%n%n");

        while (CalcularTempo.tempoAtual().isBefore(getTempoFinal())) {
            for (Equipe equipe : configuracaoDados.getEquipes()) {
                System.out.printf("===== Equipe: %s =====%n%n", equipe.getNome());
                for (Robo robo : equipe.getRobos()) {
                    if (CalcularTempo.tempoAtual().isBefore(tempoFinal)) {
                        robo.getControladorUtilizado().andar(robo, terrenoDados);
                        exibirRelatorios.exibirInformacoesRoboMomentaneas(robo, terrenoDados, tempoFinal);
                        CalcularTempo.sleep(1);
                    }
                }
            }
        }
        System.out.printf("==> Tempo de partida encerrado.%n%n");
        finalizarPartida();
    }

    private  void finalizarPartida() {
        Equipe equipeVencedora = null;
        double maiorVolumeHelio = 0;

        System.out.printf("========================================%n");
        System.out.printf("=========== Relatório Final ============%n");
        System.out.printf("========================================%n%n");

        for (Equipe equipe : configuracaoDados.getEquipes()) {
            double volumeTotalHelioEquipe = calcularVolumeTotalHelioEquipe(equipe);
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

    private double calcularVolumeTotalHelioEquipe(Equipe equipe) {
        return equipe.getRobos().stream()
                .mapToDouble(robo -> robo.getVolumeHelioProspectado() + robo.getVolumeHelioProspectadoTotal())
                .sum();
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
