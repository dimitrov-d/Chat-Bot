import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ChatBot extends Application
{
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Chat Bot");
		GridPane gridPane = JavaFXHelper.createGridPane();
		JavaFXHelper.addItems(gridPane);
		Scene scene = new Scene(gridPane, 535, 660);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}


	public static void main(String[] args)
	{
		launch(args);
	}

}
