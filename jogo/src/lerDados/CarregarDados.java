package lerDados;

import ambiente.Terreno;
import com.google.gson.Gson;
import jogabilidade.Configuracao;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CarregarDados {
    private File configuracaoFile = new File("jogo/json/configuracao.json");
    private File terrenoFile = new File("jogo/json/terreno.json");

    private Gson gson = new Gson();

    public DadosProcessados carregarDados() {
        if (configuracaoFile.exists() && terrenoFile.exists()) {
            try (FileReader configuracaoReader = new FileReader(configuracaoFile);
                 FileReader terrenoReader = new FileReader(terrenoFile)) {

                Configuracao configuracaoDados = gson.fromJson(configuracaoReader, Configuracao.class);
                Terreno terrenoDados = gson.fromJson(terrenoReader, Terreno.class);

                return new DadosProcessados(configuracaoDados, terrenoDados);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("-> Arquivos de configuração não encontrados.");
        }

        // Retorna null ou outro valor padrão em caso de falha
        return null;
    }
}