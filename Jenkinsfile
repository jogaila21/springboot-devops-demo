pipeline {
    agent any
    
    tools {
        maven 'Maven-3.9'
        jdk 'JDK-17'
    }
    
    environment {
        ARTIFACT_NAME = 'demo-app.jar'
        ARTIFACT_PATH = 'target/*.jar'
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building the Spring Boot application...'
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Running unit tests...'
                sh 'mvn test'
            }
        }
        
        stage('Archive Artifacts') {
            steps {
                echo 'Archiving the built JAR file...'
                archiveArtifacts artifacts: "${ARTIFACT_PATH}", fingerprint: true
            }
        }
        
        stage('Display Build Info') {
            steps {
                echo "Build completed successfully!"
                echo "Artifact: ${ARTIFACT_NAME}"
                sh 'ls -lh target/*.jar'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
    }
}