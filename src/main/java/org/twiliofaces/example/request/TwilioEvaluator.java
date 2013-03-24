package org.twiliofaces.example.request;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;
import org.twiliofaces.annotations.From;
import org.twiliofaces.annotations.RecordingUrl;
import org.twiliofaces.annotations.TwilioRequestParams;
import org.twiliofaces.example.model.Caller;
import org.twiliofaces.request.TwilioRequestParamsMap;
import org.twiliofaces.service.MemoryService;

@Named
@RequestScoped
public class TwilioEvaluator implements Serializable {

	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(TwilioEvaluator.class);

	@From
	@Inject
	private String from;

	@Inject
	@RecordingUrl
	private String recordingUrl;

	@Inject
	@TwilioRequestParams
	private TwilioRequestParamsMap twilioRequestParamsMap;

	@Inject
	MemoryService memoryService;

	public TwilioEvaluator() {
	}

	public void init(ComponentSystemEvent event) {
		logger.info("twilioRequestParamsMap:" + twilioRequestParamsMap);
	}

	public boolean iKnowYou() {
		if (getFrom() != null && !getFrom().isEmpty()
				&& memoryService.exist(getFrom())) {
			// logger.info("yes!! i know you: " + getFrom() + " - "
			// + getCaller().getNameUrl());
			return true;
		}
		return false;
	}

	public void addNewUser() {
		logger.info("new user: " + getFrom() + " - " + getRecordingUrl());
		memoryService.addCaller(getFrom(), getRecordingUrl());
	}

	public Caller getCaller() {
		logger.info(getFrom() + " - " + getRecordingUrl());
		return memoryService.get(getFrom());
	}

	public String getFrom() {
		return from;
	}

	public String getRecordingUrl() {
		return recordingUrl;
	}

}