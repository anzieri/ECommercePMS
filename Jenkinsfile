pipeline {
    agent any

    tools {
            jdk 'JDK25_Manual'
    }

    triggers {
        githubPush()
    }

    environment {
        CREDENTIALS_ID = '0d057ed8-da3d-46a1-9b67-efac9d9a7cbe'
        PROJECT_DIR = 'artifacts_ready'
        REPO_URL = 'https://github.com/anzieri/ECommercePMS'
        BRANCH = 'main'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: "${BRANCH}",
                        credentialsId: "${CREDENTIALS_ID}",
                        url: "${REPO_URL}"
                        echo "Build triggered by GitHub webhook"
            }
        }
        stage('Environment Check') {
                    steps {
                        sh 'java -version'
                        sh 'echo $JAVA_HOME'
                    }
        }

        stage('Build and Test with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Organize Artifacts') {
            steps {

                sh '''
                    mkdir -p ${PROJECT_DIR}
                    cp target/*.jar ${PROJECT_DIR}/
                '''
            }
        }
    }

    post {
        success {
            echo "Build and Tests successful! JAR stored in ${PROJECT_DIR}/"
            archiveArtifacts artifacts: '${PROJECT_DIR}/*.jar', fingerprint: true
        }
        failure {
            echo "Pipeline failed. Check the Jenkins console output to see if a JUnit test failed or if there was a compilation error."
        }
    }
}