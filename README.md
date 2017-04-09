# EWhereproj
UI test script for eWhere app

For running - 
download the project and open - /srcmain/java/ - for the main test file 

# Environment 
Written in intellij idea using Xcode 8.3 and Appium 1.6.4

Since xcode 8.3 does not support appium version 1.5.3 you would need to download latest beta version 
I recommend this one - https://github.com/appium/appium-desktop/releases/tag/v1.0.0

Since this is beta version tests may be unstable 

# Java Editor 

If you wish to import code to your own java editor you would need to set imports and dependencies according to your environment

However you must set the path for the app on your local environment found in the @Beforeclass -

File app = new File ("/Users/joninow/Desktop/e-Where.app");

should be changed to the local path of where app file is located.

# Some Notes

I ran into an issue where the app starts and hangs on "Loading image" message for a long time . This might make the appium server stuck
since the driver doesnt respond until this message is released. 
I checked on several systems and this issue came up - so it must be an issue with the developers code.

Scroll is unstable in appium beta version 

I was not able to access and verify text
