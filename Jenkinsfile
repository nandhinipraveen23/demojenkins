pipeline {
    agent any

environment{

    PATH = "${env.PATH};C:\\Users\\User\\AppData\\Local\\Programs\\DockerDesktop\\resources\\bin"
    KUBECONFIG = 'C:\\Users\\User\\.kube\\config'
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
        
stage('Kubernetes Check') {
    steps {
        bat 'echo %KUBECONFIG%'
        bat 'kubectl config view'
        bat 'kubectl config current-context'
        bat 'kubectl get nodes'
    }
}
        stage('Deploy Kubernetes') {
    steps {
        bat 'kubectl apply -f src/main/resources/deployment.yaml'
        bat 'kubectl apply -f src/main/resources/service.yaml'
    }
}


    }
}