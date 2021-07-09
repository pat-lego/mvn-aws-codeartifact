package com.github.patlego.mvn;

import java.io.File;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.execution.MavenSession;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.slf4j.Logger;

@Component(role = AbstractMavenLifecycleParticipant.class)
public class SimpleExample extends AbstractMavenLifecycleParticipant {

    @Requirement
    private Logger logger;

    @Override
    public void afterProjectsRead( MavenSession session ) {
        logger.info("About to inject the new settings.xml");
        session.getRequest().setGlobalSettingsFile(new File("/Users/patriquelegault/Desktop/newSettings.xml"));
    }
    
}
