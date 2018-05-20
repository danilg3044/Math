pipeline {
  agent any
  stages {
    stage('Compile') {
      parallel {
        stage('Compile') {
          steps {
            build 'Math Compile'
          }
        }
        stage('Unit Tests') {
          steps {
            build 'Math Unit Tests'
          }
        }
        stage('Integration Tests') {
          steps {
            build(job: 'Math Integration Tests', propagate: true)
          }
        }
      }
    }
    stage('Package') {
      steps {
        build 'Math package'
      }
    }
  }
}