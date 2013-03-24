package org.twiliofaces.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.twiliofaces.example.model.Caller;

@Named
@Singleton
public class MemoryService implements Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, Caller> callers;

	public Map<String, Caller> getCallers() {
		if (callers == null)
			this.callers = new HashMap<String, Caller>();
		return callers;
	}

	public void setCallers(Map<String, Caller> callers) {
		this.callers = callers;
	}

	public void addCaller(String phoneNumber, String nameUrl) {
		getCallers().put(phoneNumber, new Caller(phoneNumber, nameUrl));
	}

	public boolean exist(String phoneNumber) {
		return getCallers().containsKey(phoneNumber);
	}

	public Caller get(String phoneNumber) {
		return getCallers().get(phoneNumber);
	}

	@Produces
	@Named
	public List<Caller> getCallerList() {
		if (getCallers().size() > 0)
			return new ArrayList<Caller>(getCallers().values());
		return new ArrayList<Caller>();
	}
}
