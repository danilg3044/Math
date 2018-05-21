node {
    def app

	stage('Preparation') { // for display purposes
	  javaHome = tool 'JDK'
      mvnHome = tool 'maven'
   }
   
    stage('Clone repository') {
        checkout scm
    }
    
    stage('Build image') {
        //build job: 'Math Package', parameters: [string(name: 'BRANCH', value: 'master')]
        bat("SET JAVA_HOME=${javaHome}")
        bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
        app = docker.build("mathapp:0.0.1", "\"${WORKSPACE}/MathWebApp\"")
    }

    stage('Push image') {
        docker.withRegistry('https://hub.docker.com/r/', 'dckr117') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}