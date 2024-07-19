pipeline {
    agent any
    tools {
        maven 'Maven' // Ensure this matches the Maven installation name in Jenkins
        jdk 'JDK18'  // Ensure this matches the JDK installation name in Jenkins
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
