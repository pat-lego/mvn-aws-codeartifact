# Maven Code Artifact Update

In order to update the CodeArtifact token simply perform the following

1. Install AWS CLI on your machine
  - https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html
2. Configure it accordingly 
  - https://docs.aws.amazon.com/cli/latest/userguide/cli-configure-files.html
3. Add the server to the settings.xml file
4. Reference the following token `${env.CODEARTIFACT_AUTH_TOKEN}`
5. Create a file called `.mavenrc` under `~/`
6. Add the following code to the file
```
export CODEARTIFACT_AUTH_TOKEN=`aws codeartifact get-authorization-token --domain [domain] --domain-owner [domain_owner] --query authorizationToken --output text`
```

