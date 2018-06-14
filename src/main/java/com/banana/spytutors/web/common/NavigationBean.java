package com.banana.spytutors.web.common;


import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean(name="navBean")
@SessionScoped
public class NavigationBean implements Serializable {

  	private static final long serialVersionUID = -191046944601140350L;
  	
	protected String activePage ="views/index.xhtml";
    private String fragment;

    public String getActivePage() {
        return activePage;
    }

    public void processFragment(AjaxBehaviorEvent event){
        setActivePage(fragment.replaceAll("#", ""));
    }
    
    public void setActivePage(String activePage) {
        this.activePage = activePage;
    }
    
    public String getActivePage(String activePage) {
        setActivePage(activePage);
        String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        return viewId;
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }
    
}

