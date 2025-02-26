package com.example.mvvmarchitecture

/*

What is Unit Testing?
Unit Testing is a software testing technique in which we test small parts (units) of our code separately. A "unit" can be a function, method, or class. The main goal of unit testing is to ensure that each unit works correctly on its own without relying on external dependencies.

Benefits of Unit Testing:
- Bugs are detected early in the development process.
- Improves the reliability of the code.
- Gives confidence that new changes won’t break existing features.


Unit Testing Tools & Frameworks in Android
There are several tools and frameworks available for writing unit tests in Android, which help test different aspects of the code. Some of the most commonly used frameworks are:

1) JUnit - (Java Unit Testing Framework)
2) Mockito - (Mocking Framework)
3) Robolectric - (Android Components Testing Framework)
4) Espresso - (UI Testing Framework)


1. JUnit – Java Unit Testing Framework
What is it?
JUnit is a Java-based testing framework used to write and run unit tests. It is the most basic and popular framework that works for both Android and non-Android applications.

 Features:
✔️ Simple and fast unit testing.
✔️ Uses assertions to compare expected vs. actual output.
✔️ Provides setup and teardown methods (Before & After test execution).
✔️ Supports parameterized testing.


testImplementation ("junit:junit:4.13.2")

JUnit Assertions:

JUnit provides assertion functions to compare expected and actual values.

Assertion Function	                    Purpose
assertEquals(expected, actual)	    Checks if both values are equal.
assertTrue(condition)	            Ensures that the condition is true.
assertFalse(condition)	            Ensures that the condition is false.
assertNotNull(value)	            Checks if the value is not null.
assertNull(value)	                Checks if the value is null.


2. Mockito – Mocking Framework
   What is it?
Mockito is a powerful mocking framework used to replace dependencies in unit tests. If a class depends on a database or API, we can create a "Mock" instead of using the real implementation.

   Features:
✔️ Provides fake objects instead of real dependencies.
✔️ Allows customizing dependency behavior.
✔️ Verifies whether method calls are executed correctly.


testImplementation ("org.mockito:mockito-core:3.12.4")
testImplementation ("org.mockito:mockito-inline:3.12.4")


3. Robolectric – Android Components Testing Framework
   What is it?
Robolectric is a testing framework that allows unit testing of Android-specific classes without using an emulator or physical device.

   Features:
✔️ Simulates real Android framework dependencies.
✔️ Supports testing of Activities, Views, SharedPreferences, etc.
✔️ Faster execution compared to Instrumentation tests.

testImplementation ("org.robolectric:robolectric:4.9")



4. Espresso – UI Testing Framework
   What is it?
Espresso is a UI testing framework used for automated UI testing of Android apps. It ensures that UI elements function correctly.

   Features:
✔️ Helps test button clicks, text inputs, dialogs, etc.
✔️ Can execute tests on real devices or emulators.
✔️ Handles asynchronous operations efficiently.

androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

Test Coverage Ka Formula
Test Coverage ko percentage (%)

Test Coverage = ( Tested Code (LoC) / Total Code (LoC) ) x 100

LoC (Lines of Code)

Total Code = 1000 Lines
Tested Code = 750 Lines

Test Coverage = (750 / 1000) × 100 = 75%



* */