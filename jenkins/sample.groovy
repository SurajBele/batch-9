pipeline {
    agent {
        label 'node1'
    }
    stages {
        stage('pull') {
            steps {
                git branch: 'main', url: 'https://github.com/SurajBele/studentdata.git'
                echo "pulling successful"
            }
        }
        stage('building') {
            steps {
                sh 'export MAVEN_HOME=/opt/apache-maven-3.9.10
                    export MAVEN_HOME
                    PATH=$PATH:$MAVEN_HOME/bin

                mvn clean package'
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