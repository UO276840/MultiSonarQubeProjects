pipeline {
    agent any
    stages {
        stage('Clone Repositories') {
            steps {
                script {
                    // Clone the first repository
                    bat 'git clone https://github.com/UO276840/MultiSonarQubeProjects.git'
                    
                    // Clone the second repository
                    bat 'git clone https://github.com/UO276840/SonarQubeProject.git'
                    
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Define SonarQube server connection information
                    def serverUrl = 'http://localhost:9000'
                    def token = 'squ_bd33e4db4ae38df3218b48051dd3ca9b6cc99377'

                    // Analyze the first repository
                    bat 'cd MultiSonarQubeProjects'
                    bat "sonar-scanner -Dsonar.host.url=$serverUrl -Dsonar.login=$token"
                    bat 'cd ..'
                    
                    // Analyze the second repository
                    bat 'cd SonarQubeProject'
                    bat "sonar-scanner -Dsonar.host.url=$serverUrl -Dsonar.login=$token"
                    
                    
                }
            }
        }
    }
}