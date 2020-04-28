import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class JavaFXHelper
{
	private JavaFXHelper()
	{
		throw new IllegalStateException("Utility class");
	}

	public static void addItems(GridPane gridPane)
	{
		TextArea chat = ChatBot.chat;
		chat.setText("Bot: Hello!");
		chat.setWrapText(true);
		chat.setEditable(false);
		chat.setPrefHeight(550);
		chat.setPrefWidth(500);
		chat.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, 18));
		gridPane.add(chat, 1, 0);
		GridPane.setHalignment(chat, HPos.CENTER);
		GridPane.setMargin(chat, new Insets(15, 0, 0, 15));

		TextArea input = ChatBot.input;
		input.setPrefHeight(50);
		input.setPrefWidth(30);
		input.setPromptText("Enter your message here");
		input.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, 18));
		input.setOnKeyPressed(onEnterPressed());
		gridPane.add(input, 1, 1);
		GridPane.setMargin(input, new Insets(20, 50, 0, 15));

		Button sendButton = ChatBot.sendButton;
		sendButton.setPrefHeight(63);
		sendButton.setPrefWidth(100);
		sendButton.setOnAction(onMessageSend());
		sendButton.setDefaultButton(true);
		gridPane.add(sendButton, 2, 1);
		GridPane.setMargin(sendButton, new Insets(20, 0, 0, -100));
	}

	public static GridPane createGridPane()
	{
		GridPane gridPane = new GridPane();
		gridPane.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
		return gridPane;
	}

	private static EventHandler<ActionEvent> onMessageSend()
	{
		return event ->
		{
			String message = ChatBot.input.getText();
			if (!message.trim().equals(""))
			{
				ChatBot.input.setText(message.replace("\n", "").replace("\r", ""));
				ChatBot.chat.setText(ChatBot.chat.getText() + "\nYou: " + ChatBot.input.getText());
				ChatBot.input.setText("");
			}
		};
	}

	private static EventHandler<KeyEvent> onEnterPressed()
	{
		return event ->
		{
			String message = ChatBot.input.getText();
			if (event.getCode() == KeyCode.ENTER && !message.trim().equals(""))
			{
				ChatBot.input.setText(message.replace("\n", ""));
				ChatBot.chat.setText(ChatBot.chat.getText() + "\nYou: " + ChatBot.input.getText());
				System.out.println(message);
				ChatBot.input.setText("");
			}
		};
	}
}
