package fr.mokel.login;

import org.apache.wicket.Component;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

import fr.mokel.template.TemplatePage;

public class LoginPage extends TemplatePage {
	public LoginPage() {
		getMenuPanel().setVisible(false);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		visitChildren(new IVisitor<Component, Void>() {
			@Override
			public void component(Component component, IVisit<Void> arg1) {
				if (!component.isStateless())
					System.out.println("Component " + component.getId() + " is not stateless");
				else 
					System.out.println("Component " + component.getId() + " is stateless");
			}
		});
	}
}