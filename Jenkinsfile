node {
	stage ('Checkout') {
		checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'Gitlab_Creds', url: 'https://gitlab.com/StevenPG/DockerTagManager.git']]])
    }
    
    def mvnHome = tool 'M35'

	stage ('Build Jar') {
		sh "${mvnHome}/bin/mvn clean install"
	}

	stage ('SonarQube') {
		sh "${mvnHome}/bin/mvn sonar:sonar -Dsonar.host.url=http://10.0.75.1:9000"
	}
}