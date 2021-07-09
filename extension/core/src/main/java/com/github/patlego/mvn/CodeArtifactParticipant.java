package com.github.patlego.mvn;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import org.apache.maven.properties.internal.SystemProperties;
import org.apache.maven.settings.DefaultMavenSettingsBuilder;
import org.apache.maven.settings.MavenSettingsBuilder;
import org.apache.maven.settings.Settings;
import org.apache.maven.settings.building.DefaultSettingsBuildingRequest;
import org.apache.maven.settings.building.SettingsBuilder;
import org.apache.maven.settings.building.SettingsBuildingException;
import org.apache.maven.settings.building.SettingsBuildingRequest;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.slf4j.Logger;

@Component(role = MavenSettingsBuilder.class, hint = "newBuilder")
public class CodeArtifactParticipant extends DefaultMavenSettingsBuilder {

    @Requirement
    private Logger logger;

    @Inject
    private SettingsBuilder settingsBuilder;

    @Override
    public Settings buildSettings(File userSettingsFile) throws IOException, XmlPullParserException {
        logger.info("Running the new builder");

        File globalSettingsFile = new File("/Users/patriquelegault/Desktop/newSettings.xml");

        SettingsBuildingRequest request = new DefaultSettingsBuildingRequest();
        request.setUserSettingsFile(userSettingsFile);
        request.setGlobalSettingsFile(globalSettingsFile);
        request.setSystemProperties(SystemProperties.getSystemProperties());
        return build(request);
    }

    private Settings build(SettingsBuildingRequest request) throws IOException, XmlPullParserException {
        try {
            return settingsBuilder.build(request).getEffectiveSettings();
        } catch (SettingsBuildingException e) {
            throw (IOException) new IOException(e.getMessage()).initCause(e);
        }
    }

    // @Override
    // public void afterProjectsRead(MavenSession session) throws
    // MavenExecutionException {
    // try {
    // String settings = new String(
    // "<settings xmlns=\"http://maven.apache.org/SETTINGS/1.0.0\"
    // xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"
    // xsi:schemaLocation=\"http://maven.apache.org/SETTINGS/1.0.0
    // http://maven.apache.org/xsd/settings-1.0.0.xsd\"> <servers> <server>
    // <id>github</id> <username>pat-lego</username>
    // <password>44b2a9141ab5894bcac7e8a30ae1177e661281dd</password> </server>
    // <server> <id>aemfaacs-aftia--aemfaacs</id> <username>aws</username>
    // <password>${env.CODEARTIFACT_AUTH_TOKEN}</password> </server> <server>
    // <id>aftia-first-american</id> <username>aws</username>
    // <password>${env.CODEARTIFACT_AUTH_TOKEN}</password> </server> <server>
    // <id>aftia-optum</id> <username>aws</username>
    // <password>${env.CODEARTIFACT_AUTH_TOKEN}</password> </server> <server>
    // <id>aftia-internal</id> <username>aws</username>
    // <password>eyJ2ZXIiOjEsImlzdSI6MTYyNTgzNjU4MSwiZW5jIjoiQTEyOEdDTSIsInRhZyI6Imxsc0VYcHdoZGdCRGxuVzlkWlZnemciLCJleHAiOjE2MjU4Nzk3ODEsImFsZyI6IkExMjhHQ01LVyIsIml2IjoiM3RzM2VCNEhuNC1qMlRGeiJ9.MlKz9KdTwZrnEXW1ugSA1w.SXIK8n-ELcEvEtfZ.8eAO_X7eMdS-MX5SmAGaXtvR9f9KWis_dO83w_2Mh1ZHsscgootTNQIQRTm6pgLyETEjWBDHhRmnU6SDzB_Dgt85i5S2B5TgBbQGJZOmNYKw9lf6pcXBr7ZwgWJ6ivmIwfmVxwE6oaD-Wb_t9XXqWByaLi70gafGt_Yt_NWt7iTPs8VaD7E12DZaYc9avjh6K1OLX5a49QVINiOmkHlnsisRHfv-gsyp1ig_Hi4HBtr_vVLcn8Jv8grQMW-8yqbbZ6BAkTwJcEXS7wGV7lrjiI_nvJn9zqjaRB3-0iOkTntE2jerGG633mpGdE9hK3s2XJxnvPr-FCTjNDjXwVIzukio2rvzEaIjHOePO6XgWrADCgOMd_YEB2cj0f12ieE6XQWQvgPhG2-3XT5Int4AWWB5YOtC-ckfgUd-ADCETZCfMf_VytNMvqtmMpi2I3xJ-TafeUECEDQof8ZGumRDfBLwud6uvCMTgm4_DiM-6XhAVRqM6eLYq7NDKavDvtBcPcOafpAmCLo4v7U36RbyBlO0i2xDRMSuOiBunPc7NyWa3GYwttT47X4tplJJarAjSX8OuyhfSPRKwzptFh99EOBlbhZT9ECGfhe5wZvh5mx4XlqsOee58X5BBr4ztXOPB5VfkD_6_OA0noGH_6p8xs2L3xZLTbo_zz3SVNL_B0yeJxjg8Ns8Mc1ZRV3CIRnxPmhp0FUjNUFhNU5dDVegzpyFbt_bg9V04i4gWppwuoTkJUiWNJ6QaYiMbaOlJ1R7srVVHplX15tauPXa87AemSjwkSqXPD97KovcAnDsPVpewBpZ1dHS1f-caWt-Z7mdi4fyva9ZcngOgS469ujwjffCoxqczQjpUzV3V07ydor6z4bFXfVuccbCfoLC5J2FZF9Gqe2SqxjNrEQh7xb_n3TtGCl0mS8Kv8fcesBstfRKRWcEYuRK.GaysUo3sH1iti81GQbNwYQ</password>
    // </server> </servers> </settings>");

    // Files.write(Paths.get("/Users/patriquelegault/.m2/settings.xml"),
    // settings.getBytes());
    // } catch (IOException e) {
    // logger.error(e.getMessage(), e);
    // throw new MavenExecutionException(e.getMessage(), e);
    // }

    // }
}
