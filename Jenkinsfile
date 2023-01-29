pipeline {
    agent any
    stages {
        stage('Clone Repository 1') {
            steps {
                git url: 'https://github.com/tensorflow/tensorflow.git', branch: 'master'
            }
        }
        stage('SonarQube Analysis 1') {
            steps {
                def scannerHome = tool 'SonarScanner';                withSonarQubeEnv('sonarserver') {
                    bat "${scannerHome}/bin/sonar-scanner.bat -Dsonar.projectKey=tensorflow.git"                }
            }
        }
        stage('Clone Repository 2') {
            steps {
                git url: 'https://github.com/thedaviddias/Front-End-Checklist.git', branch: 'master'
            }
        }
        stage('SonarQube Analysis 2') {
            steps {
                def scannerHome = tool 'SonarScanner';                withSonarQubeEnv('sonarserver') {
                    bat "${scannerHome}/bin/sonar-scanner.bat -Dsonar.projectKey=Front-End-Checklist.git"                }
            }
        }
        stage('Clone Repository 3') {
            steps {
                git url: 'https://github.com/ant-design/ant-design-pro.git', branch: 'master'
            }
        }
        stage('SonarQube Analysis 3') {
            steps {
                def scannerHome = tool 'SonarScanner';                withSonarQubeEnv('sonarserver') {
                    bat "${scannerHome}/bin/sonar-scanner.bat -Dsonar.projectKey=ant-design-pro.git"                }
            }
        }
    }
}