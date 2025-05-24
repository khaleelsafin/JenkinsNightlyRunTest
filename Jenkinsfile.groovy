pipeline {
    agent any
    
    tools {
        maven 'Maven' // Name of your Maven installation in Jenkins
        jdk 'JDK17'  // Name of your JDK installation in Jenkins
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', 
                url: 'https://github.com/khaleelsafin/JenkinsNightlyRunTest.git'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn test -Dcucumber.filter.tags="@negative"'

            }
            post {
                always {
                    cucumber buildStatus: 'UNSTABLE',
                    fileIncludePattern: '**/cucumber.json',
                    trendsLimit: 10
                }
            }
        }
        
        stage('Archive Results') {
            steps {
                archiveArtifacts artifacts: 'target/**/*', allowEmptyArchive: true
                junit 'target/surefire-reports/**/*.xml'
            }
        }
    }
    
    triggers {
        // cron('0 22 * * *') // Runs at 10 PM every night (adjust for your timezone)
          githubPush()
    }
}