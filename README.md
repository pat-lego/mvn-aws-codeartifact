https://github.com/jvanzyl/provisio/blob/master/pom.xml#L184

https://github.com/jvanzyl/provisio/blob/master/provisio-maven-plugin/src/main/java/ca/vanzyl/maven/plugins/provisio/ProvisioningLifecycleParticipant.java

@Component(role = AbstractMavenLifecycleParticipant.class, hint = "mvn-settings-enricher")
public class SettingsRefresher extends AbstractMavenLifecycleParticipant {
    @Override
    public void afterProjectsRead(final MavenSession session) {
        final var settings = session.getSettings();
        final var server = new Server();
        server.setId("sample-injected-server");
        server.setUsername("sample");
        server.setPassphrase("sampl3");
        settings.addServer(server);
    }
}
and create a META-INF/plexus/components.xml with:
<?xml version="1.0" encoding="UTF-8"?>
<component-set>
  <components>
    <component>
      <role>org.apache.maven.AbstractMavenLifecycleParticipant</role>
      <role-hint>mvn-settings-enricher</role-hint>
      <implementation>com.company.SettingsRefresher</implementation>
      <description />
      <isolated-realm>false</isolated-realm>
    </component>
  </components>
</component-set>

https://maven.apache.org/plugins/maven-help-plugin/effective-settings-mojo.html