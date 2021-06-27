# NowLoan
An Android Loan App that will help with disbursement of money to ordinary citizens

There are two paths to be taken in the development process.One can use choice one,two or both.
# A.Local Machine Development
1.On Linux, one can use Android Studio + Android SDK.
2.The Machine Should Have Java pre-installed for java development.One can also use Kotlin

# Local Development Advantages
1.Easy insallation.Local development requires primaily the above mentioned tools.They are free and any additional packages can be installed using the Android Studio website.
2.Easy access.Local machine development allows for the individual to access the resources faster since there is little to no limitations.
3.Wide variety of IDEs.Local development gives the developer a wide range of IDEs.In this case, Android Studio is best suited for this type of development.

# Local Development Disadvantages
1.Hardware Constraints.Local Machines especially those with many programs strain alot.Usually, Most machines have very low CPU and GPU processing power especially laptops.
2.Loss of Data.Unless the project is constantly backed up, the developer might loose all their data in case of a disaster on their machine.
3.Slow.Local development is slow because there are many processes that drain the local machine resources.

# B.CloudDevelopment
1.Cloud development will entail the use of a cloud service provider.A free example will be Google Cloudshell which provisions 5GB of storage per aaccount with a code editor and Linux CloudVM.The Cloud VM comes preinstalled with Java but additional packages i.e Android SDK should be installed with various commands that will be detailed later.
2.A Persistent stable internet connection is required.

#Cloud Development Advantages
1.Security.Cloud development is more secure because the development process and the code can't ever be tampered with and also if the machine being used is damaged,The project is already backed up somewhere in a remote server.
2.Faster Development.Cloud development has faster productivity rate compared to a similar project built on the local system bacause the developer has easier access to resources on the cloud rather that always opening up a web browser then closing it to return to local machine then opening it again e.t.c.Also there is easier linking of projects on the cloud than locally.
3.Flexibility.The project can be accessed from any internet connected device by just the developers credentials.
4.Larger community.Cloud Development and computing puts the developer in a global environment where one can join literally any team online with the click of a button.There is also easier collaboration.
5.Platform standard.If two or more developers are provisioned with the same platform,There will be minimal errors since the VM environments were designed the same.
6.Up to date.Cloud development gives one constant up to date resources one can clone into their online VMs.

#Cloud Development Disadvantages
1.Constant Internet connection.One needs a constant internet connection stream to develop even Android apps on the cloud.This can be costly especially in an area with no wifi where one is forced to pay for cellular connections
2.IDEs.In this case, I only get to use one IDE which is Visual Cloud editor for free on Google CloudShell.I do not have access to Android Studio on the cloud unless a developer is able to afford a full VM environment on a cloud service provider i.e AWS,Google Engine,Azure,Alibaba Services e.t.c.


# Install instructions CLoudShell

# install openjdk
sudo apt-get install openjdk-7-jdk

# download android sdk
wget http://dl.google.com/android/android-sdk_r24.2-linux.tgz

tar -xvf android-sdk_r24.2-linux.tgz
cd android-sdk-linux/tools

# install all sdk packages
./android update sdk --no-ui

# set path
vi ~/.zshrc << EOT

export PATH=${PATH}:$HOME/sdk/android-sdk-linux/platform-tools:$HOME/sdk/android-sdk-linux/tools:$HOME/sdk/android-sdk-linux/build-tools/22.0.1/

EOT

source ~/.zshrc

# adb
sudo apt-get install libc6:i386 libstdc++6:i386
# aapt
sudo apt-get install zlib1g:i386
