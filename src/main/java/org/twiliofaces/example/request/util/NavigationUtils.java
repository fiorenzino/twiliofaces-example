package org.twiliofaces.example.request.util;

import java.io.IOException;

import javax.faces.context.FacesContext;

public class NavigationUtils {

	public static void redirect(String to) {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(to);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
