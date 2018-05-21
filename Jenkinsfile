node {
    def app

	stage('Preparation') { // for display purposes
      mvnHome = tool 'maven'
    }
   
    stage('Clone repository') {
        checkout scm
    }
    
    stage('Build image') {
        //build job: 'Math Package', parameters: [string(name: 'BRANCH', value: 'master')]
        bat(/"${mvnHome}\bin\mvn" -Dmaven.test.skip clean package/)
        app = docker.build("mathapp:0.0.1", "./MathWebApp")
    }

    stage('Push image') {
        //docker.withServer("https://hub.docker.com/", "docker-id") {
            app.push("${env.BUILD_NUMBER}")
            app.push("0.0.1")
        //}
    }
}