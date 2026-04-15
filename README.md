# Online Donation System - Plain Java Maven Project

This is a **plain Java project** using **Maven**, **JUnit 5**, **Docker**, **Kubernetes**, **GitHub**, **Jenkins**, and **GitHub Actions**.

## Project Objective
Ensure donations are processed and recorded accurately.

## Features
- Donation processing logic
- Transaction validation
- JUnit tests
- Maven build automation
- GitHub version control
- CI/CD pipeline files
- Docker containerization
- Kubernetes deployment files

## Project Structure
```text
online-donation-system/
├── src/main/java/com/example/donation/
├── src/test/java/com/example/donation/
├── k8s/
├── .github/workflows/
├── pom.xml
├── Dockerfile
├── Jenkinsfile
└── README.md
```

## Software Needed
Install these first:
- JDK 17
- Maven
- Git
- VS Code
- Docker Desktop
- Kubernetes / Minikube (optional for deployment)
- Jenkins (optional if using Jenkins pipeline)

## Step 1: Open project in VS Code
1. Extract the zip file.
2. Open the folder in VS Code.
3. Open terminal in VS Code.

## Step 2: Build the project using Maven
Run:
```bash
mvn clean package
```

This will:
- compile Java code
- run JUnit tests
- create jar file in `target/`

## Step 3: Run the plain Java program
Run:
```bash
java -jar target/online-donation-system-1.0.0.jar
```

Expected output will show:
- donation records
- generated transaction IDs
- total donations received

## Step 4: Run JUnit tests only
```bash
mvn test
```

## Step 5: Create GitHub repository
1. Go to GitHub.
2. Click **New repository**.
3. Repository name: `online-donation-system`
4. Click **Create repository**.

## Step 6: Push project to GitHub
In VS Code terminal:
```bash
git init
git add .
git commit -m "Initial commit - Online Donation System"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/online-donation-system.git
git push -u origin main
```

If Git asks for username/password:
- use GitHub username
- use GitHub Personal Access Token instead of password

## Step 7: GitHub Actions CI setup
The project already contains:
```text
.github/workflows/ci-cd.yml
```
When you push code to GitHub:
- GitHub Actions starts automatically
- Maven build runs
- tests run
- Docker image build step runs

## Step 8: Jenkins CI/CD setup
Create a **Pipeline project** in Jenkins.

In Jenkins:
1. New Item
2. Enter project name
3. Select **Pipeline**
4. In Pipeline section choose **Pipeline script from SCM**
5. SCM = Git
6. Paste your GitHub repo URL
7. Save
8. Build Now

Jenkins will use the `Jenkinsfile` present in the project.

## Step 9: Docker build and run
First build jar:
```bash
mvn clean package
```

Build docker image:
```bash
docker build -t yourdockerhubusername/online-donation-system:latest .
```

Run container:
```bash
docker run --name donation-app yourdockerhubusername/online-donation-system:latest
```

## Step 10: Push Docker image to Docker Hub
Login:
```bash
docker login
```

Push image:
```bash
docker push yourdockerhubusername/online-donation-system:latest
```

## Step 11: Kubernetes deployment
Edit this file first:
```text
k8s/deployment.yaml
```
Replace:
```text
yourdockerhubusername/online-donation-system:latest
```
with your real Docker Hub username.

Apply files:
```bash
kubectl apply -f k8s/deployment.yaml
kubectl apply -f k8s/service.yaml
kubectl get pods
kubectl get svc
```

## Notes about Kubernetes
This is a **plain Java console application**.
It does **not expose a web page**.
So Kubernetes deployment is mainly for showing container orchestration and deployment setup for your lab/project marks.

## Main Java classes
- `Donation.java` -> stores donation data
- `DonationRecord.java` -> stores processed transaction details
- `DonationService.java` -> business logic and validation
- `DonationApplication.java` -> main class to run project

## Test cases included
- Valid donation processing
- Invalid amount
- Invalid email
- Unsupported payment method
- Total donation calculation

## Example Viva Explanation
**Donation processing logic:**
The system accepts donor details, validates the transaction, generates a transaction ID, stores the donation record, and calculates total donations.

**JUnit testing:**
JUnit tests verify valid and invalid transactions, such as zero amount, wrong email format, and unsupported payment method.

**CI/CD pipeline:**
Pipeline automatically builds the project, runs tests, builds Docker image, and deploys to Kubernetes after code commits.

**Docker and Kubernetes:**
Docker packages the Java app into a container. Kubernetes deploys and manages replicas of that container.
