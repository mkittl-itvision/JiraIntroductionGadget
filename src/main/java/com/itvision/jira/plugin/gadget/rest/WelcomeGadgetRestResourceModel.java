package com.itvision.jira.plugin.gadget.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import net.jcip.annotations.Immutable;

@XmlRootElement(name = "gadgetResource")
@Immutable
@XmlAccessorType(XmlAccessType.FIELD)
public class WelcomeGadgetRestResourceModel {

	@XmlElement(name = "projectName")
    private String projectName;
    
    @XmlElement(name = "projectDescription")
    private String projectDescription;
    
    @XmlElement(name = "prjectIcon")
    private long projectIcon;

    public WelcomeGadgetRestResourceModel() {
    }

    public WelcomeGadgetRestResourceModel(String projectName,
			String projectDescription, long projectIcon) {
		super();
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectIcon = projectIcon;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public long getProjectIcon() {
		return projectIcon;
	}

	public void setProjectIcon(long projectIcon) {
		this.projectIcon = projectIcon;
	}

}