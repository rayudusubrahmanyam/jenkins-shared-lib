#!/usr/bin/env groovy
call(){
    sh "docker build -t rayudusubrahmanyam/myapp:$BUILD_NUMBER.0 ."
    withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable:'PASS', usernameVariable: 'USER')])
            {
                sh "echo $PASS | docker login -u $USER --password-stdin"
                sh "docker push rayudusubrahmanyam/myapp:$BUILD_NUMBER.0"
            }
}