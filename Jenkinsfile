pipeline {
  agent any
  stages {
    stage('Compile') {
      steps {
        build 'Math Compile'
        build 'Math Unit Tests'
        build 'Math Integration Tests'
      }
    }
    stage('Package') {
      steps {
        build 'Math package'
      }
    }
  }
}