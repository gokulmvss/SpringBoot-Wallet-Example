The Environment is set up for Java 21.

Setting up on Visual Studio Code (VS Code)
Clone the Repository:

Open a terminal window.

Navigate to the directory where you want to clone the repository.

Run the command:

sh
git clone https://github.com/gokulmvss/SpringBoot-Wallet-Example.git
Open the Project in VS Code:

Launch VS Code.

Click on File > Open Folder... and select the cloned repository folder.

Alternatively, you can use the terminal to navigate to the project directory and run:

sh
code .
Install Extensions:

Install the following VS Code extensions to enhance your Spring Boot development experience:

Spring Boot Extension Pack: This provides Spring Boot support.

Java Extension Pack: This provides Java support.

Build the Project:

Open a terminal in VS Code.

Run the following command to build the project:

sh
./mvnw clean install
For Windows, you may need to use mvnw.cmd instead.

Run the Application:

You can run the application directly from the terminal:

sh
./mvnw spring-boot:run
Or, use the VS Code integrated debug feature to start the application in debug mode.

Setting up on Spring Tool Suite (STS)
Clone the Repository:

Open a terminal window.

Navigate to the directory where you want to clone the repository.

Run the command:

sh
git clone <your-repository-url>
Import the Project into STS:

Launch Spring Tool Suite.

Click on File > Import....

Select Maven > Existing Maven Projects and click Next.

Browse to the cloned repository folder and select it.

Ensure the pom.xml file is checked and click Finish.

Build the Project:

STS will automatically detect the pom.xml file and build the project.

If not, you can right-click on the project in the Project Explorer and select Run As > Maven install.

Run the Application:

Right-click on the project in the Project Explorer.

Select Run As > Spring Boot App.

Alternatively, you can run it from the terminal:

sh
./mvnw spring-boot:run