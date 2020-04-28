import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChatBot extends Application
{
	// You may get your own API key on this link:
	// https://rapidapi.com/Acobot/api/brainshop-ai
	static String API = "8754a32491mshf42558e890e4c7fp1a94abjsn6c1f0bc82daf";
	static String KEY = "sX5A2PcYZbsN5EY6";

	static TextArea chat;
	static TextArea input;
	static Button sendButton;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		initializeElements();
		GridPane gridPane = JavaFXHelper.createGridPane();
		JavaFXHelper.addItems(gridPane);
		Scene scene = new Scene(gridPane, 535, 660);
		primaryStage.setTitle("Chat Bot");
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(e -> Platform.exit());
		primaryStage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}

	public static void initializeElements()
	{
		chat = new TextArea();
		input = new TextArea();
		sendButton = new Button("Send");
	}

}
