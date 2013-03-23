package org.twiliofaces.example.request;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.twiliofaces.annotations.From;

@Named
@RequestScoped
public class TwilioEvaluator {

	public TwilioEvaluator() {
	}

	@From
	@Inject
	private String from;

	public void init(ComponentSystemEvent event) {
		System.out.println("from:" + from);
	}

	public boolean iKnowYou() {
		if (getFrom() != null && getFrom().equals("392")) {
			System.out.println("yes!!");
			return true;
		}
		return false;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

}