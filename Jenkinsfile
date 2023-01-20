pipeline {
    agent any
    stages {
        stage('Clone Repositories') {
            steps {
                git url: 'https://github.com/UO276840/MultiSonarQubeProjects.git', branch: 'master'
                git url: 'https://github.com/UO276840/SonarQubeProject.git', branch: 'master'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarserver') {
                    bat 'mvn clean install sonar:sonar'
                }
            }
        }
    }
}

