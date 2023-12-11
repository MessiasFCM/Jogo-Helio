package ambiente;

import java.util.Arrays;

public class Terreno {
    private int largura;
    private int altura;
    private Celula[][] celulas;

    public Terreno(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        this.celulas = new Celula[largura][altura];

        for (int quantidadePosicaoX = 0; quantidadePosicaoX < largura; quantidadePosicaoX++) {
            for (int quantidadePosicaoY = 0; quantidadePosicaoY < altura; quantidadePosicaoY++) {
                celulas[quantidadePosicaoX][quantidadePosicaoY] = new Celula();
            }
        }
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Celula getCelula(int posicaoX, int posicaoY) {
        return celulas[posicaoX][posicaoY];
    }

    public Celula[][] getCelulas() {
        return celulas;
    }

    public void setCelulas(Celula[][] celulas) {
        this.celulas = celulas;
    }

    public boolean estaDentroDosLimites(int posicaoX, int posicaoY) {
        return posicaoX >= 0 && posicaoX < largura && posicaoY >= 0 && posicaoY < altura;
    }

    @Override
    public String toString() {
        return "Terreno{" +
                "largura=" + largura +
                ", altura=" + altura +
                ", celulas=" + Arrays.deepToString(celulas) +
                '}';
    }
}
