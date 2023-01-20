pipeline {
    agent any
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
                        bat "${scannerHome}/bin/sonar-scanner"
                    }
                }
            }
        }
    }
}
