pipeline {
    agent {
        docker {
            image 'maven:3.6.3-jdk-8-alpine'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    stages {
        stage('Clone Repositories') {
            steps {
                script {
                    git url: 'https://github.com/UO276840/MultiSonarQubeProjects.git', branch: 'master'
                    git url: 'https://github.com/UO276840/SonarQubeProject.git', branch: 'develop'
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'SonarQube Scanner 3.3.0.1492'
                    withSonarQubeEnv('sonarserver') {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }
    }
}
