package com.adobe.training.core;
/**
 * Service interface to get the information about the bundle Developer
 * 
 * Example HTL:
 * <h3 data-sly-use.devInfo="DeveloperInfo">Developer Info: ${devInfo.DeveloperInfo}</h3>
 *
 * Example code can be inserted into a HTL component:
 * /apps/trainingproject/components/structure/page/partials/main.html
 * 
 * Example JSP:
 * com.adobe.training.core.services.DeveloperInfo devInfo = sling.getService(com.adobe.training.core.services.DeveloperInfo.class)
 * <h3>Developer Info: <%= devInfo.getDeveloperInfo() %></h3>
 *
 */
public interface DeveloperInfo {
	public String getDeveloperInfo();
}
