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
                withSonarQubeEnv(installationName:'sonar-server', credentialsId: 'sonar-token') {
                 sh '''
                    export MAVEN_HOME=/opt/apache-maven-3.9.10
                    export MAVEN_HOME
                    PATH=$PATH:$MAVEN_HOME/bin
                    mvn clean verify sonar:sonar -Dsonar.projectKey=student
                '''
                }
                echo "testing successful"
            }
        }
         stage('QualityGate') {
            steps {
                waitForQualityGate abortPipeline: false, credentialsId: 'sonar-token'
                echo "gate successful"
            }
        }
        stage('Deploy') {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'tomcat-pass', path: '', url: 'http://54.221.176.197:8080/')], contextPath: '/', war: "**/*.war"
                echo "deploy successful"
            }
        }
    }
}