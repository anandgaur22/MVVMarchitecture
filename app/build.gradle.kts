plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.mvvmarchitecture"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mvvmarchitecture"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // JUnit for Unit Testing
    testImplementation(libs.junit)


// AndroidX Test Core for LiveData Testing
    testImplementation("androidx.arch.core:core-testing:2.2.0")

// Coroutine Testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

// Mockito Core for Mocking
    testImplementation("org.mockito:mockito-core:5.10.0")
    testImplementation("org.mockito:mockito-inline:4.11.0")

// Mockito for Kotlin
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.2.1")

// Compose UI Testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.7.8")

// Espresso for UI Testing
    androidTestImplementation(libs.androidx.espresso.core)


// AndroidX Test Runner & Rules
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")


    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    // ViewModel and LiveData (Compose Lifecycle)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    //Coil (Image Loading)
    implementation("io.coil-kt:coil-compose:2.5.0")

    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    
    // ByteBuddy with Java 21 support
    testImplementation("net.bytebuddy:byte-buddy:1.14.12")
    testImplementation("net.bytebuddy:byte-buddy-agent:1.14.12")
}