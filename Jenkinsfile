pipeline {
    stages {
            stage('start') {
                agent {
                    label LabelAgent
                    docker { image 'maven:3.9.0-eclipse-temurin-11' }
                }
                steps {
                    bat 'mvn --version'
                }
            }
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/yashchoube/DockerDemo.git'

                // Run Maven on a Unix agent.
               // sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
    }
}

//stages {
//           stage('Back-end') {
//               agent {
//                   docker { image 'maven:3.9.0-eclipse-temurin-11' }
//               }
//               steps {
//                   sh 'mvn --version'
//               }
//           }
