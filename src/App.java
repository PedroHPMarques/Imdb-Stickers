import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
    
        // Fazer conexao com http e pegar api dos filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        HttpClient client = HttpClient.newHttpClient();
        URI endereco = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        // pegar só os dados que interessam(Titulo, posters e Rating)
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);
        System.out.println(listaDeFilmes.size());



        //exibir e manipular os dados
        var geradora = new GeradoraDeFigurinha();

        for (int i = 0;i < 10;i++) {
            System.out.println(i);
            Map<String,String> filme = listaDeFilmes.get(i);

            String urlImagem = filme.get("image")
            .replaceAll("(@+)(.*).jpg$","$1.jpg");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "saida/" + titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(titulo);
        }
    }
}
