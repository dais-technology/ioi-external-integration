#!/usr/bin/env groovy

@Library('dais-lib@dais-pipeline') _

pipelineWrapper {
    def previousVersion = (fileExists('version.txt') && fileExists('passedPublish')) ? getProjectVersion('version.txt') : ''

    stage('Build and release') {
        backendBuildAndRelease(previousVersion)
    }

    stage('Publish') {
        backendPublish(previousVersion)
    }

    stage('Deploy') {
        deploy()
    }
}
