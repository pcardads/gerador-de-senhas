import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class ProjetoGeradorDeSenhasGUI extends Application {
	
	@Override
	public void start(Stage palco) {
		palco.setTitle("Gerador de Senhas");

		Label labelTamanhoSenha = new Label("Tamanho da senha:");
		TextField campoTamanhoSenha = new TextField();
		campoTamanhoSenha.setText("8"); //sugestao de tamanho da senha

		Label senhaGerada = new Label("Senha gerada:");
		TextField campoSenhaGerada = new TextField();
		campoSenhaGerada.setEditable(false);
		campoSenhaGerada.setStyle("-fx-text-fill: cyan; -fx-background-color: black;");

		Button botaoGerar = new Button("Gerar Senha");
		botaoGerar.setOnAction(e -> {
			int tamanhoSenha = Integer.parseInt(campoTamanhoSenha.getText()); // pega o tamanho desejado da senha
			String senha = ProjetoGeradorDeSenhas.gerarSenha(tamanhoSenha); // gera a senha
			campoSenhaGerada.setText(senha); // mostra a senha gerada para o usuario
		});

		VBox vBox = new VBox(labelTamanhoSenha, campoTamanhoSenha, botaoGerar, senhaGerada, campoSenhaGerada);
		vBox.setSpacing(10);
		vBox.setPadding(new Insets(10));

		Scene cena = new Scene(vBox, 400, 200);
		palco.setScene(cena);
		palco.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
