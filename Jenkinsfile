

pipeline {
    agent any

    parameters {
        booleanParam(defaultValue: false,
                     description: 'If checked downstream pipeline is also',
                    name: 'build_downstream'
        )
        string(name: 'STATEMENT',
            defaultValue: 'Hello World', description: 'What should I say?'
        )
    }


    tools {
        maven 'maven_3.6.3'
        jdk 'jdk_1.8.0'
    }

    stages {
        stage('Introduction and Pre Checks') {
            steps {
                echo 'This is a minimal pipeline.'
                script {
                    sh 'df -h'
                    sh 'java -version'
                }
            }
        }

        stage('Build Project') {
            steps {
                echo 'This is the build step'
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Build and Unit Test') {

            when {
                expression { ${params.do_unit_tests} == true}
            }
            steps {
                echo "Build and Unit Test"
                sh "mvn -B -nsu clean install"
            }
            post {
                always {
                    junit "**/surefire-reports/*.xml"
                }
            }
        }

        stage('Build Downstream Jobs') {
            when {
                expression { ${params.build_downstream} == true}
            }
            steps {
                echo "build downstream jobs"
                build job: "kurs_0410_001", wait: true
            }
        }


    }
    post {
        failure {
            echo "Build POST  FAILURE action "
        }
        always {
            echo "Build POST action"
        }
    }
}

