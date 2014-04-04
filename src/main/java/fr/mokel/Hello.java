package fr.mokel;

import java.util.Date;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class Hello extends WebPage {
	public Hello() {
		IModel<String> messageModel = new Model<String>("Hello World!");
		add(new Label("message", messageModel));
		add(new Label("hour", new MyDateModel()));
		add(new MessageForm("messageInputForm", messageModel));
	}

	private final class MessageForm extends Form {
		public MessageForm(String id, IModel<String> model) {
			super(id);
			add(new TextField<String>("messageInput", model));
		}

		protected void onSubmit() {
			// nothing to do here as the model is automatically updated
			System.out.println("COUCOU!!!! ##############");
		}
	}
	
	class MyDateModel implements IModel<String> {

		@Override
		public void detach() {
			
		}

		@Override
		public String getObject() {
			return new Date().toString();
		}

		@Override
		public void setObject(String object) {
			
		}
		
	}
}