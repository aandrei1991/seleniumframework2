Steps for running locally the TaaS Automation Project

-

Create the Github account 

Access the following URL:

https://github.com/join

You may follow those steps from the below URL to create the Github account:

https://www.wikihow.com/Create-an-Account-on-GitHub 

-

Ask for access on the repository

The URL location for the TaaS Automation repository:

https://github.com/LeonardoDancu/taas-automation.git

You will notice that you will not have access to this project.

You need to send your Git email / username to Leonardo Stefan Dancu (chat on InCrys Microsoft Teams or on InCrys email: leonardo.dancu@incrys.com) in order to have access at the TaaS project (this repository will be moved later on to InCrys's internal infrastructure). 

-

Install Git on your local machine

You may follow those steps from the below URL to install Git locally:

https://github.com/git-guides/install-git 

EXTRA

Here you can find some tips about using Git:

https://www.simplilearn.com/tutorials/git-tutorial/git-installation-on-windows 

-

Setup the environment on your local machine

1.Oracle Java SE Development Kit 16 

https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html  

Here you have the explained steps in order to do this:

https://www.freecodecamp.org/news/how-to-install-java-on-windows/ 

2.Google Chrome Browser 

https://support.google.com/chrome/answer/95346?hl=en&co=GENIE.Platform%3DDesktop#zippy=%2Cwindows 

3. ChromeDriver 

https://chromedriver.chromium.org/home
 
There you have the download section.

You may download it everywhere (Download directory by default), in further steps you will find out what to do with this webdriver.

Check you Google Chrome browser version. 

You need to download the same stable version for your Chrome Web Driver.

https://www.google.com/chrome/update/ 

Topic about this subject:

https://stackoverflow.com/questions/41133391/which-chromedriver-version-is-compatible-with-which-chrome-browser-version 

Other method, using a package manager:

https://www.kenst.com/installing-chromedriver-on-windows/ 

4.JetBrains IntelliJ IDEA Community Edition 

https://www.jetbrains.com/idea/download/#section=windows 

Here you have the explained steps in order to do this:

https://www.jetbrains.com/help/idea/installation-guide.html#standalone 

At Installation Options, you may choose Create Desktop Shortcut & Update PATH Variable checkboxes.

After the installment, when opening for the first time the IDE, it can appear the option to import or not the settings. Choose do not import settings.

-

Clone repository 

From IntelliJ - Import from VCS option

Version control: Git

URL: https://github.com/LeonardoDancu/taas-automation.git 

Directory: browse for a location in your local directory

Login via Github account. Authorize JetBrains.

Trust the Project.


From Terminal option

Navigate to the location where you want to clone / download the project 

Run the following command to bring the project on your local directory
 
git clone https://github.com/LeonardoDancu/taas-automation.git  

Tutorials for cloning the repository

https://www.jetbrains.com/help/idea/cloning-repository.html 

https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository 

https://git-scm.com/book/en/v2/Git-Basics-Getting-a-Git-Repository 

Others

Support for password authentication was removed on August 13, 2021. Please use a personal access token instead

https://stackoverflow.com/questions/68775869/message-support-for-password-authentication-was-removed-please-use-a-personal  

Error 500 / Session not created
https://arstech.net/this-version-of-chromedriver-only-supports-chrome-version/ 

-
Running process

Then, after the repo is cloned, the project will stare to resolve automatically the dependencies.

A notification to install some plugins like Cucumber for Java / Gherkin might appear. Install them. Then Restart to activate the plugin updates.

-
Project Structure

`src/main/java/com/incrys/cucumber/librarybase/config`

composed by files that are reading from properties / configuration files

`src/main/java/com/incrys/cucumber/librarybase/core`

Page Object Manager file is composed by all the management pages of the platform in test.

Web Driver Manager file reads and configure the webdriver.

Utils Manager file consists in methods used in the whole project.

Test Context file is an aggregator of the management files.

`src/main/java/com/incrys/cucumber/librarybase/pageobjectmodel`

Page files composed with the web element and the locators.


`src/test/java/com/incrys/cucumber/stepfile`

Step files with the method used in order to do the steps for an automated run.

`src/test/java/com/incrys/cucumber/testrunner`

Test runner file with the scope of running all the feature files after the Cucumber configuration.

`src/test/java/com/incrys/cucumber/featurefile`

Feature files are the ones with the step methods created in step files.

`target/cucumber-reports/report.html`

This HTML file can be opened with any browsers installed on the machine. 
The report is resulted when the test runner file is run.

`taas-automation/pom.xml`

The POM file contains all the dependencies for the Maven project.


How to run the tests

In order to do that, you can run the Test Runner file and all the scenarios from the feature files will be run; then, the Cucumber report can be observed.

Another possibility would be to run scenario by scenario from each feature file.

Another one would be to set tags for a specific scenario from a feature file and set them to be run in the Test Runner file from the Cucumber options annotation.

Errors that might appear

For all mentioned above, it might display an error after pressing the Run button:

The SDK is not specified for module taaas-automation.

Press on Configure.

It will open a window from this path: File - Project Structure - Project Settings - Project.

You may choose the SDK already installed on your machine. 

You may need at least version 16 in order to function for its specific language level (preffered to choose the same language level as the JDK version).

-

An error from taas-automation/pom.xml can appear due to the current JDK you have set.
Open the POM file and notice that a property for the Maven Compiler is set like this:

<properties>
    <maven.compiler.source>1.X</maven.compiler.source>
    <maven.compiler.target>1.X</maven.compiler.target>
</properties>

Change the version (1.X) with the one corresponding to your JDK, for example 17 if you have JDK version 17:

<properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
</properties>

Useful example:

https://simply-how.com/getting-started-with-java-17#section-3 

-

Maven Settings XML issue
 
After the project is imported, IntelliJ will prompt you to autoimport the maven dependencies. 

In case the dependencies are not retrieved, consider verifying the settings.xml file which is located in the .m2 directory. 

Configure the jdk using file> project structure. Have the project point to jdk 16 (or your current version).
 
Run the tests. Navigate to:
 
taas-automation -> src -> test -> java -> com -> incrys -> cucumber -> testrunner -> TestRunner.java 

Press Shift F10 (on Windows) or click on the Run TestRunner button to trigger the test execution.


-

Chromedriver version

Error: SessionNotCreatedException: Could not start a new session. Response code 500.

This is appearing just because the ChromeDriver version is not the same as the Chrome browser.

Follow the steps explained in the Setup section

https://chromedriver.chromium.org/home

-


