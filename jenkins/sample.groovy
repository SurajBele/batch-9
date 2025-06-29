pipeline {
    agent any
    stages {
        stage('pull') {
            steps {
               git 'https://github.com/SurajBele/studentapp.ui.git'
                echo "pulling successful"
            }
        }
        stage('building') {
            steps {
                echo "building successful"
            }
        }
        stage('Test') {
            steps {
                echo "testing successful"
            }
        }
        stage('Deploy') {
            steps {
                echo "deploy successful"
            }
        }
    }
}