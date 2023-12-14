package carroceria;

import ambiente.Celula;
import ambiente.Terreno;
import funcionalidades.CalcularTempo;
import robos.Robo;

public class Carroceria {
    protected String nome;
    private double cargaTotal = 2.0;

    public Carroceria(String nome) {
        this.nome = nome;
    }

    public void prospeccao(Robo robo, Terreno terreno){
        Celula celulaAtual = terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY());
        double concentracao = celulaAtual.getConcentracaoHelio();
        double volumeProspectado = robo.getVolumeHelioProspectado();
        double cargaTotalEfeitos = cargaTotal * robo.getPorcentagemCarga();

        double totalProspectado = volumeProspectado + concentracao;
        if(totalProspectado >= cargaTotalEfeitos){
            robo.setVolumeHelioProspectado(cargaTotalEfeitos);
            celulaAtual.setConcentracaoHelio(totalProspectado-cargaTotalEfeitos);

            descarregarHelio(robo);
            int segundos = (int) (robo.getTempoDescarga() * robo.getTempoDescarga());
            CalcularTempo.sleep(segundos);
        }else{
            robo.setVolumeHelioProspectado(totalProspectado);
            celulaAtual.setConcentracaoHelio(0);
        }
        int segundos = (int) ((10 * concentracao) * robo.getVelocidadeExtracao());
        CalcularTempo.sleep(segundos);
    }

    public void descarregarHelio(Robo robo) {
        double totalProspectado = robo.getVolumeHelioProspectadoTotal() + robo.getVolumeHelioProspectado();
        robo.setVolumeHelioProspectadoTotal(totalProspectado);
        robo.setVolumeHelioProspectado(0);
        System.out.println("==> " + robo.getNome() + " realizou uma operação de descarga de Hélio-3.");
        System.out.printf("==> Carga total coletada: %.2f%n%n", totalProspectado);
    }
}