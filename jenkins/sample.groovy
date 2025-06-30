pipeline {
    agent {
        label 'node1'
    }
    stages {
        stage('pull') {https://github.com/SurajBele/studentdata.git
            steps {
                git 'https://github.com/SurajBele/studentdata.git'
                echo "pulling successful"
            }
        }
        stage('building') {
            steps {
                sh 'sudo mvn clean package'
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