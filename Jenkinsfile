node {
	stage ('Checkout') {
		checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'Gitlab_Creds', url: 'https://gitlab.com/StevenPG/DockerTagManager.git']]])
    }
    
    def mvnHome = tool 'M35'
    jdk 'jdk8' 

	stage ('Build Jar') {
		sh "${mvnHome}/bin/mvn clean install"
	}
}