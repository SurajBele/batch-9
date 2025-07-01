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
                sh '''
                    export MAVEN_HOME=/opt/apache-maven-3.9.10
                    export MAVEN_HOME
                    PATH=$PATH:$MAVEN_HOME/bin
                    mvn -v
                    mvn clean package
                '''
                echo "building successful"
            }
        }
        stage('Test') {
            steps {
                mvn clean verify sonar:sonar \
  -Dsonar.projectKey=student \
  -Dsonar.host.url=http://34.238.154.214:9000 \
  -Dsonar.login=sqp_aa24f4dc29d7db32a8e7b65c3471a4e3a2522801
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