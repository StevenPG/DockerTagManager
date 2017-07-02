node {
	stage 'Checkout'
		checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'Gitlab_Creds', url: 'https://gitlab.com/StevenPG/DockerTagManager.git']]])

	stage 'Build Jar'
		sh 'mvn clean install'
}