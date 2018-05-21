node {
    def app

    stage('Clone repository') {
        checkout scm
    }
    
    stage('Build image') {
        //build job: 'Math Package', parameters: [string(name: 'BRANCH', value: 'master')]
        app = docker.build("mathapp:0.0.1", "MathWebApp")
    }

    stage('Push image') {
        docker.withRegistry('https://hub.docker.com/r/', 'dckr117') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}