import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

				getAPIreply();
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

				getAPIreply();
			}
		};
	}

	private static void getAPIreply()
	{
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url("https://acobot-brainshop-ai-v1.p.rapidapi.com/get?bid=178&key=" + ChatBot.KEY
						+ "&uid=mashape&msg=" + ChatBot.input.getText())
				.get().addHeader("x-rapidapi-host", "acobot-brainshop-ai-v1.p.rapidapi.com")
				.addHeader("x-rapidapi-key", ChatBot.API).build();
		ChatBot.input.setText("");

		try
		{
			Response response = client.newCall(request).execute();
			String data = response.body().string();
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(data);
			ChatBot.chat.setText(ChatBot.chat.getText().toString() + "\nBot: " + jsonObject.get("cnt").toString());
		}
		catch (IOException | ParseException e)
		{
			ChatBot.chat.setText(e.toString());
		}
	}
}
