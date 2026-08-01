pipeline {
    agent any

environment{

PATH="${env.PATH};C:\\Users\\User\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin"
}

    tools {
        maven 'Maven3'
        jdk 'JDK26'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
           
                bat 'mvn clean package -DskipTests'
                
            }
        }
	



	
        stage('Build Docker Image') {
            steps {
                bat 'docker build -t springbootstujen1 .'
            }
        }

        stage('Stop Old Container') {
            steps {
                bat 'docker stop springboot-container || exit 0'
                bat 'docker rm springboot-container || exit 0'
            }
        }

        stage('Run Container') {
            steps {
                bat 'docker run -d -p 8080:8080 --name springboot-container springbootstujen1'
            }
        }
        
        stage('Deploy Kubernetes') {
    steps {
        bat 'kubectl apply -f deployment.yaml'
        bat 'kubectl apply -f service.yaml'
    }
}


    }
}