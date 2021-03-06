# Hook Check Use in an Android App

This [sample Android&trade; app](../README.md#sample_desc) illustrates the use of `HookCheck` and `HookResponse` in _PreEmptive Protection - DashO_.
This project can be imported into Android Studio.
Obfuscation and injection are handled via the [DashO Gradle](../../docs/gradle/index.html) integration.

This sample is preconfigured with a single hook check and three hook responses.

The `HookCheck` was placed on an internal method, `someApplicationLogic()`, called by the `MainActivity` class during startup.
This method returns a boolean value that will be `true` if hooking is detected.
The value from that method is returned by the static `MainActivity.isInitialized()` method that is used as the source for the `HookResponse` instances.

One `HookResponse` was placed on the `doInBackground()` method used when calculating the Fibonacci sequence.

Another `HookResponse` was placed on the `findRnd()` method used when calculating the random number.

Both of those responses use randomness to determine if they should or should not do anything.
There is also a programmatic use of the boolean variable set by the `HookCheck` that shows a message to the user that hooking was detected.

Feel free to reconfigure the probability and/or responses of the `HookResponse` by editing them inside the `project.dox` file or via the DashO UI.

This sample includes a keystore, `keystore.ks`, that is used to sign the release build.

## Setup

See the main [README](../README.md) for the requirements.

>**Note:** When compiling, you may notice a `Warning` regarding `exit` on Android. The `exit` action on Android will only close the `Activity` on the top of the activity stack.

## Run Normal

Compile, obfuscate, and install the application.

1.  Run the command: `gradlew uninstallAll` _(if necessary)_
2.  Run the command: `gradlew installDebug`

Run the application on a device or emulator without a hooking framework.
You will notice it behaves as expected; no errors occur and the app is responsive.

## Run with a Hooking Framework

Compile, obfuscate, and install the application.

1.  Run the command: `gradlew uninstallAll` _(if necessary)_
2.  Run the command: `gradlew installRelease`

Run the application in a hooked environment.
You will notice it does not behave as expected; random errors occur during use.

### Using Frida

For testing you can use [Frida](https://frida.re).
Follow the [Android instructions](https://frida.re/docs/android/) to setup Frida on your device and computer.
Run `frida --no-pause -U -f com.dasho.android.hook`

>**Note:** This is a contrived example where certain protection features of DashO have purposefully turned off for ease of demonstration.
>In a real scenario, those other protections would make it much more difficult to even begin to use hooking.

## How to Add Hook Checking to Your Android Application

Adding basic hook checking is relatively simple.

1.  Decide when during the lifetime of your app you want to make the check.
2.  Add a `HookCheck` with an action to take.

To test it; run the app on a device or emulator with a hooking framework.

If you wish to use `HookResponse`, it is a bit more difficult as you must provide a mechanism for communication between the `HookCheck` and `HookResponse`.
In this sample, that mechanism involves the boolean variable and the `MainActivity.isInitialized()` method.

The hook checks and responses may be added to the code directly as annotations or configured on the Hook Check screen.

## Best Practices

Do not place the `HookCheck` directly in the entry classes.
Hackers investigate those places first.
In this sample the `HookCheck` was placed in an internal class that is called when the application starts up.
In a real application this should be an existing class and not one added for the sole purpose of hook checking.
The `Responses` were added to different methods with different outcomes, randomly deciding if or if not to act on the result of the hook check.
This makes it difficult to track down what is going wrong.

>**Note:** The Android robot is reproduced or modified from work created and shared by Google and used according to terms described in the [Creative Commons 3.0 Attribution License](http://creativecommons.org/licenses/by/3.0/).  
Android is a trademark of Google Inc.  
Gradle is a trademark of Gradle Inc.

Copyright 2018 [PreEmptive Solutions, LLC.](https://www.preemptive.com)
