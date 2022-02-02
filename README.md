
# Diconium Test Automation Framework README.md

**Prerequisites**

1) Access to Git repository https://git.diconium.com/030-projects/test-automation-framework
2) Java (jdk) 1.8 or higher: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
3) Maven 3.3 or higher: https://maven.apache.org/download.cgi
4) IntelliJ (or any other IDE) : https://www.jetbrains.com/idea/download/
5) Docker Installation : https://confluence.diconium.com/pages/viewpage.action?spaceKey=U030&title=QAOB+-+Docker+Installation

**Installation Details of IntelliJ:**

1) IntelliJ installation Guide ( Windows) : https://www.youtube.com/watch?v=m2BYGocvows
2) IntelliJ installation Guide ( Mac) : https://www.youtube.com/watch?v=4ej49_eEOcM


**Steps to establish connection to the Test Automation Framework Utils:**

1) Download the settings.xml file from https://git.diconium.com/030-projects/test-automation-framework/blob/master/settings.xml
2) Copy this file to your maven root folder
    MAC - right click finder -> go to folder -> ~/.m2/
              Windows - C:\Users\{username}\.m2


**Steps to get the Test Automation Framework Template:**

1) Clone the project from https://git.diconium.com/030-projects/test-automation-framework
2) Launch and open the project 'diconium-test-automation-framework' in IntelliJ editor


**Install Lombok Plugin:**

1) Help > Find Action >Search for "Plugins"
2) Search for "lombok" in the plugins popup
3) Click search in repository(In case it is not listed)
4) Search and select "Lombok Plugin" in the results
5) Click Install and click accept in the popup
6) Click Restart IntelliJ and click OK


**Create maven run configuration:**

1) Click run -> Edit configuration
2) Create/add configuration
3) Name the configuration
4) Enter 'clean install site -DsuiteFile=web_regression.xml -DenvConfig=test -DremoteExecution=false' in the command line field
5) Click apply and save it
6) Repeat above steps to create another maven configuration with command line as 'clean install site -DsuiteFile=api_regression.xml -DtestDataConfig=sampleData -DenvConfig=test'


**Access Allure reports: (after maven run)**

1) Trigger either of the above mentioned maven runs
2) Open site within target folder in IntelliJ
3) Right click 'allure-maven-plugin.html' and select open in new browser
4) Reports will be opened
