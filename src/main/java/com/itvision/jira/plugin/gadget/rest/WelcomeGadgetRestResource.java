package com.itvision.jira.plugin.gadget.rest;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.atlassian.jira.permission.ProjectPermissions;
import com.atlassian.jira.project.Project;
import com.atlassian.jira.security.PermissionManager;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.jira.user.util.UserUtil;
import com.atlassian.plugins.rest.common.security.AnonymousAllowed;
import com.atlassian.sal.api.user.UserManager;

/**
 * A resource of message.
 */
@Path("/gadgetResource")
public class WelcomeGadgetRestResource {

	private UserManager userManager;
	private UserUtil userUtil;
	private PermissionManager permissionManager;

	public WelcomeGadgetRestResource(UserManager userManager,
			UserUtil userUtil, PermissionManager permissionManager) {
		this.userManager = userManager;
		this.userUtil = userUtil;
		this.permissionManager = permissionManager;
	}

	@GET
	@AnonymousAllowed
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response getGadgetResource(@Context HttpServletRequest request) {
		// the request was automatically injected with @Context, so
		// we can use SAL to extract the username from it
		String userName = userManager.getRemoteUsername(request);

		ApplicationUser user = userUtil.getUserByName(userName);

		Collection<Project> projects = permissionManager.getProjects(
				ProjectPermissions.BROWSE_PROJECTS, user);

		WelcomeGadgetRestResourceModel gadgetPesource;
		Project[] projectArray = projects.toArray(new Project[0]);
		if (projectArray.length > 0) {
			Project actualProject = projectArray[0];
			gadgetPesource = new WelcomeGadgetRestResourceModel(
					actualProject.getName(), actualProject.getDescription(),
					actualProject.getAvatar().getId());
		} else {
			gadgetPesource = new WelcomeGadgetRestResourceModel();
		}

		return Response.ok(gadgetPesource).build();
	}
}