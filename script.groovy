def buildJar() {
    echo "building the application..."
//     sh 'apt-get update'
//     sh 'apt install maven'
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'my-docker', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ajay9948/java-maven-app:2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push ajay9948/java-maven-app:2.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
