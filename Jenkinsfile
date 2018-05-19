pipeline {
  agent any
  stages {
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
        build 'Integration Tests'
      }
    }
  }
}