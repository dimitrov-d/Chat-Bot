import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
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
		if (netIsAvailable())
			showStartScreen(primaryStage);
		else
			showNoConnectionWarning();
	}

	public static void showStartScreen(Stage primaryStage)
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

	private static boolean netIsAvailable()
	{
		try
		{
			// Custom URL for testing
			final URLConnection connection = new URL("http://www.google.com").openConnection();
			connection.connect();
			connection.getInputStream().close();
			return true;
		}
		catch (MalformedURLException e)
		{
			throw new RuntimeException(e);
		}
		catch (IOException e)
		{
			return false;
		}
	}
	
	private static void showNoConnectionWarning()
	{
		Alert alert = new Alert(AlertType.WARNING, "Please connect to the internet and try again", ButtonType.OK);
		alert.showAndWait();
	}

	public static void initializeElements()
	{
		chat = new TextArea();
		input = new TextArea();
		sendButton = new Button("Send");
	}

}
