pipeline {
    agent any
    stages {
        stage('Clone Repository 1') {
            steps {
                git url: 'https://github.com/UO276840/MultiSonarQubeProjects.git', branch: 'master'
            }
        }
        stage('SonarQube Analysis 1') {
            steps {
                withSonarQubeEnv('sonarserver') {
                    bat 'mvn clean install sonar:sonar'
                }
            }
        }
        stage('Clone Repository 2') {
            steps {
                git url: 'https://github.com/UO276840/SonarQubeProject.git', branch: 'master'
            }
        }
        stage('SonarQube Analysis 2') {
            steps {
                withSonarQubeEnv('sonarserver') {
                    bat 'mvn clean install sonar:sonar'
                }
            }
        }
        stage('Clone Repository 3') {
            steps {
                git url: 'https://github.com/PabloGarciaFernandez/Regresion-Testing---Automated-Test-Enviroment.git', branch: 'master'
            }
        }
        stage('SonarQube Analysis 3') {
            steps {
                withSonarQubeEnv('sonarserver') {
                    bat 'mvn clean install sonar:sonar'
                }
            }
        }
    }
}