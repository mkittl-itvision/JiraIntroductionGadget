package com.itvision.jira.plugin.gadget.ao;

import com.atlassian.activeobjects.external.ActiveObjects;

import net.java.ao.Entity;
import net.java.ao.Preload;

@Preload
public interface JiraGadgetResource extends Entity {
	String getUsername();	
	void setUsername(String userName);	

	String getWelcomeText();	
	void setWelcomeText(String welcomeText);
	
	String getIconPath();	
	void setIconPath(String path);	
}
