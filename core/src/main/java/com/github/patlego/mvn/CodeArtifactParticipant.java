package com.github.patlego.mvn;

import java.util.Map;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.MavenExecutionException;
import org.apache.maven.execution.MavenSession;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;

import org.slf4j.Logger;


@Component(role = AbstractMavenLifecycleParticipant.class)
public class CodeArtifactParticipant extends AbstractMavenLifecycleParticipant {

    @Requirement
    private Logger logger;

    @Override
    public void afterProjectsRead(MavenSession session) throws MavenExecutionException {
        logger.info(String.format("%s - About to set the repository tag password to the appropriate value", Constants.EXT_NAME));
        
        logger.info(String.format("Current password is set too - %s", session.getSettings().getServer("aftia-internal").getPassword()));
        session.getSettings().getServer("aftia-internal").setPassword("eyJ2ZXIiOjEsImlzdSI6MTYyNTc2ODYyMSwiZW5jIjoiQTEyOEdDTSIsInRhZyI6ImtMay1pX0lveDBLRHVmU0xxTkFsTmciLCJleHAiOjE2MjU4MTE4MjEsImFsZyI6IkExMjhHQ01LVyIsIml2IjoieS1FaDk3VGs0MlpkMUNqRSJ9.YyEkTFydWoX5IL5XOFRSDw.W_eHA84AQIImGj6W.Kqj_-MOs9jEdxzq2FcBO12LCC9vKAngGKFrOnxH6JoZNr2EJsfBS8O-HwW8lj4QB6OIKQ3heyrHNddVw4a3dwbUh9Qjx2_G9TidZaKH5jHVBm6qQdFOwQ0iRyaKgUCpnvjiOnnB8TeE5AUwUpOYIDTqLSi9dZz5WQEUknvYxlSr2YCEP1vzhC4MknyQuktgsOFqJ5D4f49jIwyXApZdtFNtbGVqkt0s8mYOvqhJYSn3-cTgjlJVzOfWm3jm2nZBYmUdVIxY4Ot-hDf8KkqKNrK-ZKO6awfeLytDCj2bf5CkJjvt1JK6MyyUUnpORAPiOyN2vLL9KWjaxeB3tnBAtlbvOy6mVGb_LB9yazkFZahaUHkLBkIcSW-QYaQ-OGfiXRTcNhGDWQ5O0r-ysg_FUxWjHq2EjCB2s1rlc10EkWVBlpP3KcLwAG7R187lnt_bq_bvlkqrEEo_YziGTt9Qu9g2Y837rCh0c6qEsVTm0BCUHRri_qicwfHhhXT5jUzKun7SC7oc82EWnEW1wRRgKN-0W5lzbNUQxIbb5aMk-AI8ob8zrgvOe4EdOUJ1mHp9QNq8D9sds5Y68OBcuQzOYjSDWFkRQQiLW7QQSsG62hUfpRMC3Xh3_u8nHZ8Km5ZLPOTSDXXcjP0Xwe2vovvKhc2kkTADo8GRUXUypTx_Pd902op_dIXenaekQOA6PHF6-DhNUQOdPL8-xSEksCkS1NUNdfSvVIrqIorOtJAer--rF9YEmF34WTP3AlgtWvEqeCEqPLCf-EkHMNbqR3ZsGXbHtYXmxZuUuMmma34bFu7cGZBwvU5E_dLx3BsUGCeCMGkf8YF_E-E_HJ7x1qEEFdK93lexM4vVkfagCgDAWo6vhM90XvqCR11y5BKpjJygWtYqgPsE_8pCtmRrCC-Y1kMLAbNMOiLlX80WuJ0wf5ZTY5XB-GFw8IILIdA.SR-CNzTHHuc4LcUMbk7hGw");
        logger.info(String.format("Current password is set too - %s", session.getSettings().getServer("aftia-internal").getPassword()));
        logger.info(session.getSettings().getServer("aftia-internal").getUsername());

        session.getSettings().flushProfileMap();
        session.getSettings().flushActiveProxy();
    }

    @Override
    public void afterSessionStart(MavenSession session) throws MavenExecutionException {
        // Do Nothing
    }
}
