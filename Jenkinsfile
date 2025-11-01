pipeline {
    agent any

    environment {
        // Jenkins credentials IDs (configure these in Jenkins > Manage Credentials)
        DOCKERHUB_CREDENTIALS = credentials('dockerhub')
        TARGET_SSH = credentials('target-ssh')

        // Change these values to your own
        IMAGE_NAME = "manisshh111/recipe-api"
        TARGET_HOST = "ec2-user@3.80.70.177"
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Cloning repository...'
                git branch: 'master', url: 'https://github.com/manisshh111/recipe_api'
            }
        }

        stage('Setup Java 17 and Maven') {
            steps {
                echo 'Installing Java 17 and Maven (Amazon Linux)...'
                sh '''
                    # Install Amazon Corretto 17 JDK
                    sudo yum install -y java-17-amazon-corretto-devel

                    # Install Maven if not present
                    if ! command -v mvn &> /dev/null; then
                        sudo yum install -y maven
                    fi

                    java -version
                    mvn -v
                '''
            }
        }

        stage('Build JAR') {
            steps {
                echo 'Building JAR with Maven...'
                sh '''
                    mvn clean package -DskipTests
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                sh '''
                    sudo docker build -t $IMAGE_NAME:latest .
                '''
            }
        }

        stage('Push to Docker Hub') {
            steps {
                echo 'Pushing image to Docker Hub...'
                sh '''
                    echo $DOCKERHUB_CREDENTIALS_PSW | sudo docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin
                    sudo docker push $IMAGE_NAME:latest
                '''
            }
        }

        stage('Deploy to Target EC2') {
            steps {
                echo 'Deploying to Target EC2...'
                sshagent (credentials: ['target-ssh']) {
                    sh '''
                        ssh -o StrictHostKeyChecking=no $TARGET_HOST "
                            sudo docker pull $IMAGE_NAME:latest &&
                            sudo docker stop app || true &&
                            sudo docker rm app || true &&
                            sudo docker run -d -p 8084:8084 --name app $IMAGE_NAME:latest
                        "
                    '''
                }
            }
        }
    }

    post {
        success {
            echo 'Deployment successful on Amazon Linux!'
        }
        failure {
            echo 'Deployment failed — check Jenkins console output.'
        }
    }
}
