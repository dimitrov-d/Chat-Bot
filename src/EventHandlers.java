import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public abstract class EventHandlers
{
	public static EventHandler<ActionEvent> onMessageSend()
	{
		return event ->
		{
			String message = ChatBot.input.getText();
			if (!message.trim().equals(""))
			{
				ChatBot.input.setText(message.replace("\n", "").replace("\r", ""));
				ChatBot.chat.setText(ChatBot.chat.getText() + "\nYou: " + ChatBot.input.getText());
			}
		};
	}

	public static EventHandler<KeyEvent> onEnterPressed()
	{
		return event ->
		{
			String message = ChatBot.input.getText();
			if (event.getCode() == KeyCode.ENTER && !message.trim().equals(""))
			{
				ChatBot.input.setText(message.replace("\n", ""));
				ChatBot.chat.setText(ChatBot.chat.getText() + "\nYou: " + ChatBot.input.getText());
			}
		};
	}
}
