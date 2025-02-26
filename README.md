# Unit Testing in Android

## What is Unit Testing?
Unit Testing is a testing technique where we test small, individual parts (units) of our code separately. A "unit" can be a function, method, or class. The main goal of unit testing is to ensure that each unit functions correctly in isolation, without any external dependencies.

## Benefits of Unit Testing:
* Detects bugs early in the development process.
* Increases code reliability.
* Provides confidence that new changes will not break existing features.

---

## Tools & Frameworks for Unit Testing in Android
There are several tools and frameworks available for writing unit tests in Android, which help in testing different aspects of the code. Some of the most commonly used frameworks are:

1️⃣ **JUnit** - (Java Unit Testing Framework)  
2️⃣ **Mockito** - (Mocking Framework)  
3️⃣ **Robolectric** - (Android Components Testing Framework)  
4️⃣ **Espresso** - (UI Testing Framework)  

---

### 1. JUnit – Java Unit Testing Framework
**What is it?**  
JUnit is a Java-based testing framework used for writing and running unit tests. It is the most basic and widely used framework for both Android and non-Android applications.

**Features:**  
✔️ Simple and fast unit testing  
✔️ Uses assertions to compare expected vs actual output  
✔️ Provides setup and teardown methods (Before & After test execution)  
✔️ Supports parameterized testing  

#### JUnit Assertions
JUnit provides assertion functions that compare expected and actual values:

| Assertion Function | Purpose |
|--------------------|---------|
| assertEquals(expected, actual) | Checks if both values are equal |
| assertTrue(condition) | Ensures that the condition is true |
| assertFalse(condition) | Ensures that the condition is false |
| assertNotNull(value) | Checks if the value is not null |
| assertNull(value) | Checks if the value is null |

**JUnit Setup:**  
If you want to use JUnit, add the following dependency in `build.gradle`:
```gradle
testImplementation ("junit:junit:4.13.2")
```

---

### 2. Mockito – Mocking Framework
**What is it?**  
Mockito is a powerful mocking framework used to replace dependencies in unit tests. If a class depends on a database or an API, we can create a "Mock" instead of using the actual implementation.

**Features:**  
✔️ Provides fake objects instead of real dependencies  
✔️ Allows customization of dependency behavior  
✔️ Helps verify if method calls are executed correctly  

**Mockito Setup:**  
If you want to use Mockito, add the following dependencies in `build.gradle`:
```gradle
testImplementation ("org.mockito:mockito-core:3.12.4")
testImplementation ("org.mockito:mockito-inline:3.12.4")
```

---

### 3. Robolectric – Android Components Testing Framework
**What is it?**  
Robolectric is a testing framework used for unit testing Android-specific classes without requiring an emulator or physical device.

**Features:**  
✔️ Simulates real Android framework dependencies  
✔️ Enables testing of Activities, Views, SharedPreferences, etc.  
✔️ Faster execution compared to Instrumentation tests  

**Robolectric Setup:**  
If you want to use Robolectric, add the following dependency in `build.gradle`:
```gradle
testImplementation ("org.robolectric:robolectric:4.9")
```

---

### 4. Espresso – UI Testing Framework
**What is it?**  
Espresso is a UI testing framework used for automated UI testing of Android apps. It ensures that UI elements function as expected.

**Features:**  
✔️ Helps test button clicks, text inputs, dialogs, etc.  
✔️ Allows execution of tests on real devices or emulators  
✔️ Can handle asynchronous operations  

**Espresso Setup:**  
To use Espresso, add the following dependency in `build.gradle`:
```gradle
androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
```

---

## Test Coverage Formula
Test Coverage is measured as a percentage (%):

**Test Coverage = (Tested Code (LoC) / Total Code (LoC)) × 100**

Where **LoC** stands for Lines of Code.

For example:
* **Total Code** = 1000 Lines
* **Tested Code** = 750 Lines

**Test Coverage = (750 / 1000) × 100 = 75%**

By using these frameworks, Android developers can ensure their code is reliable, maintainable, and free from unexpected bugs.

