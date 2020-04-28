import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChatBot extends Application
{

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("Chat Bot");
		GridPane gridPane = createGridPane();
		addItems(gridPane);
		Scene scene = new Scene(gridPane, 600, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> Platform.exit());
	}

	public static void addItems(GridPane gridPane)
	{
		TextArea area = new TextArea();
		area.setText("Bot: Hello!");
		area.setEditable(false);
		area.setPrefWidth(550);
		area.setPrefHeight(550);
		gridPane.add(area, 2, 0);
		GridPane.setHalignment(area, HPos.CENTER);
		GridPane.setMargin(area, new Insets(15, 0, 0, 5));
	}
	

	public GridPane createGridPane()
	{
		GridPane gridPane = new GridPane();
		gridPane.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
		gridPane.setHgap(10);
		gridPane.setVgap(80);
		return gridPane;
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
