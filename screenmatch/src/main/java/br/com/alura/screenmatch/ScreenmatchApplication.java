package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Criando um objeto para consumir a API
		ConsumoApi consumoApi = new ConsumoApi();

		/*Criando uma variável para guardar o retorno do método obterDados
		passando como parâmetro a minha URL*/
		String json = consumoApi.obterDados("https://www.omdbapi.com/?t=" +
				"gilmore+girls&apikey=92b5aef3");

		//Imprimindo na tela os dados
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}
}