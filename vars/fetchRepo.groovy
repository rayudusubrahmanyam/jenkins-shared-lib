#!/usr/bin/env groovy

def call( String branchName , String repoURL ){
    git branch: $branchName, credentialsId: 'GitHub', url: $repoURL
}