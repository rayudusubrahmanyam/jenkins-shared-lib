#!/usr/bin/env groovy
def call(String repoName ){
    sh "docker build -t $repoName ."
    withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable:'PASS', usernameVariable: 'USER')])
            {
                sh "echo $PASS | docker login -u $USER --password-stdin"
                sh "docker push $repoName"
            }
}