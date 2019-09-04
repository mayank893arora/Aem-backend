package com.adobe.training.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import com.adobe.training.core.DeveloperInfo;
import com.adobe.training.core.services.DeveloperInfoConfiguration;

/**
 * Component implementation of the DeveloperInfo Service. This gets the developer info from the OSGi Configuration
 * There are 4 OSGi Configuration Examples:
 * -Boolean
 * -String
 * -String Array
 * -Dropdown
 */

@Component(service = DeveloperInfo.class, name = "Training DeveloperInfo")

@Designate(ocd = DeveloperInfoConfiguration.class)
public class DeveloperInfoImpl implements DeveloperInfo {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    //local variables to hold OSGi config values
    private boolean showDeveloper;
    private String developerName;
    private String[] developerHobbiesList;
    private String langPreference;

    @Activate
    @Modified
    //http://blogs.adobe.com/experiencedelivers/experience-management/osgi_activate_deactivatesignatures/
    protected void activate(DeveloperInfoConfiguration config) {

        showDeveloper = config.developerinfo_showinfo();
        developerName = config.developerinfo_name();
        developerHobbiesList = config.developerinfo_hobbies();
        langPreference = config.developerinfo_language();
        logger.info("#############Component config saved");
    }

    @Deactivate
    protected void deactivate() {
        logger.info("#############Component (Deactivated) Good-bye " + developerName);
    }

    /**
     * Method used to show how OSGi configurations can be brought into a OSGi component
     **/
    @Override
    public String getDeveloperInfo(){

        String developerHobbies = Arrays.toString(developerHobbiesList);

        if(showDeveloper)

            return "Created by " + developerName + "<br>"
                    + ". Hobbies include: " + developerHobbies
                    + ". Preferred programming language in AEM is " + langPreference;
        return "";
    }

	/*
	 * Method used to show a simple OSGi service/component relationship
	public String getDeveloperInfo(){
		return "Hello! I do not know who my developer is. I am a product of random development!!!";
	}
	*/

}

