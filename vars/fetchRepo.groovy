#!/usr/bin/env groovy

def call( String repoURL ){
    git branch: 'main', credentialsId: 'GitHub', url: $repoURL
}