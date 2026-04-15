stage('Docker Build') {
    steps {
        bat 'docker build -t ragul19a/online-donation-system:latest .'
    }
}

stage('Docker Push') {
    steps {
        withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            bat 'docker login -u %USERNAME% -p %PASSWORD%'
            bat 'docker push ragul19a/online-donation-system:latest'
        }
    }
}