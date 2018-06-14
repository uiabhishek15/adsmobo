package com.banana.spytutors.web.common;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author ANKEM
 *
 */
public class UACompatibleHeaderPhaseListener implements PhaseListener {
    

  private static final long serialVersionUID = -5801653777817161176L;

  public PhaseId getPhaseId() {
      return PhaseId.ANY_PHASE;
  }

  public void beforePhase(PhaseEvent event) {
	  FacesContext facesContext = event.getFacesContext();
	    HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
	    response.addHeader("X-UA-Compatible", "IE=EmulateIE9");
      System.out.println("START PHASE " + event.getPhaseId());
  }

  public void afterPhase(PhaseEvent event) {
      System.out.println("END PHASE " + event.getPhaseId());
  }
}

