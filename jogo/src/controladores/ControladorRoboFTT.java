package controladores;

import ambiente.Terreno;
import ambiente.Celula;
import robos.Robo;
import java.util.Random;

public class ControladorRoboFTT extends Controlador {

    @Override
    public String nomeControlador() {
        return "Controlador FTT";
    }

    @Override
    public void andar(Robo robo, Terreno terreno) {

    }

//    public int buscaMaiorQuantidadeHelio(Robo robo, Terreno terreno){
//
//        Celula celula = terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY());
//        Random geradorAleatorio = new Random();
//        double maiorQuantidadeHelio = 0;
//
//        if (robo.getDirecaoRobo().equals("NORTE")) {
//                    double erro = terreno.getCelula(robo.getPosicaoAtualX(), robo.getPosicaoAtualY()).getCoeficienteErroLeitura()[0] +
//                            geradorAleatorio.nextDouble() * (terreno.getCelula(robo.getPosicaoAtualX(),
//                                    robo.getPosicaoAtualY()).getCoeficienteErroLeitura()[1] - terreno.getCelula(robo.getPosicaoAtualX(),
//                                    robo.getPosicaoAtualY()).getCoeficienteErroLeitura()[0]);
//                    double concentracaoComErro = robo.getMutiplicadorErro() * terreno.getCelula(robo.getPosicaoAtualX(),
//                            robo.getPosicaoAtualY()).getConcentracaoHelio() + (terreno.getCelula(robo.getPosicaoAtualX(),
//                            robo.getPosicaoAtualY()).getConcentracaoHelio() * erro);
//        } else if (robo.getDirecaoRobo().equals("SUL")) {
//
//        } else if (robo.getDirecaoRobo().equals("LESTE")) {
//
//        } else if (robo.getDirecaoRobo().equals("OESTE")) {
//
//        }
//
//        public int buscaMaiorQuantidadeHelio(Robo robo, Terreno terreno) {
//            int posicaoAtualX = robo.getPosicaoAtualX();
//            int posicaoAtualY = robo.getPosicaoAtualY();
//
//            double maiorQuantidadeHelio = 0;
//
//            for (int i = 0; i < 3; i++) {
//                int direcaoX = 0;
//                int direcaoY = 0;
//
//                switch (robo.getDirecaoRobo()) {
//                    case "NORTE":
//                        direcaoY = -1;
//                        break;
//                    case "SUL":
//                        direcaoY = 1;
//                        break;
//                    case "LESTE":
//                        direcaoX = 1;
//                        break;
//                    case "OESTE":
//                        direcaoX = -1;
//                        break;
//                    default:
//                        System.out.println("Direção inválida");
//                        return -1; // Ou outra ação apropriada para indicar erro
//                }
//
//                int x = posicaoAtualX + direcaoX * (i + 1);
//                int y = posicaoAtualY + direcaoY * (i + 1);
//
//                // Verifique se as coordenadas (x, y) estão dentro dos limites do terreno
//                if (x >= 0 && x < terreno.getLargura() && y >= 0 && y < terreno.getAltura()) {
//                    Celula celula = terreno.getCelula(x, y);
//
//                    // Faça a lógica para comparar a quantidade de Hélio na célula e atualize maiorQuantidadeHelio se necessário
//                    double quantidadeHelio = celula.getConcentracaoHelio();
//                    if (quantidadeHelio > maiorQuantidadeHelio) {
//                        maiorQuantidadeHelio = quantidadeHelio;
//                    }
//                }
//            }
//
//            return maiorQuantidadeHelio;
//        }
//
//        // teste
//
//        int posicaoAtualX = robo.getPosicaoAtualX();
//        int posicaoAtualY = robo.getPosicaoAtualY();
//
//        double maiorQuantidadeHelio = 0;
//
//        for (int i = 0; i < 3; i++) {
//            int direcaoX = 0;
//            int direcaoY = 0;
//
//            switch (robo.getDirecaoRobo()) {
//                case "NORTE":
//                    direcaoY = -1;
//                    break;
//                case "SUL":
//                    direcaoY = 1;
//                    break;
//                case "LESTE":
//                    direcaoX = 1;
//                    break;
//                case "OESTE":
//                    direcaoX = -1;
//                    break;
//                default:
//                    System.out.println("Direção inválida");
//                    return -1; // Ou outra ação apropriada para indicar erro
//            }
//
//            int x = posicaoAtualX + direcaoX * (i + 1);
//            int y = posicaoAtualY + direcaoY * (i + 1);
//
//            // Verifique se as coordenadas (x, y) estão dentro dos limites do terreno
//            if (x >= 0 && x < terreno.getLargura() && y >= 0 && y < terreno.getAltura()) {
//                Celula celula = terreno.getCelula(x, y);
//
//                // Faça a lógica para comparar a quantidade de Hélio na célula e atualize maiorQuantidadeHelio se necessário
//                double quantidadeHelio = celula.getConcentracaoHelio();
//                if (quantidadeHelio > maiorQuantidadeHelio) {
//                    maiorQuantidadeHelio = quantidadeHelio;
//                }
//            }
//        }
//
//        return maiorQuantidadeHelio;
//    }
//    @Override
//    public void andar(Robo robo, Terreno terreno) {
//
//        int seletorLado = buscaMaiorQuantidadeHelio(robo, terreno);
//
//        if (seletorLado == 0) {
//            robo.direcaoParaDireita(robo);
//            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
//                robo.andarParaFrente(terreno);
//                iniciarProspeccao(robo, terreno);
//            } else {
//                andar(robo, terreno);
//            }
//        } else if (seletorLado == 1) {
//            robo.direcaoParaEsquerda(robo);
//            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
//                robo.andarParaFrente(terreno);
//                iniciarProspeccao(robo, terreno);
//            } else {
//                andar(robo, terreno);
//            }
//        } else {
//            if (robo.movimentoValido(robo.getDirecaoRobo(), terreno)) {
//                robo.andarParaFrente(terreno);
//                iniciarProspeccao(robo, terreno);
//            } else {
//                andar(robo, terreno);
//            }
//        }
//    }
}