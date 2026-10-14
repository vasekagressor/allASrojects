plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.vasek.pergaev"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.vasek.pergaev"
        minSdk = 24
        targetSdk = 36
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
}

dependencies {
    // ... твои текущие зависимости ...

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // 🔒 Жёстко фиксируем версии, чтобы Gradle не тянул 1.19.1
    constraints {
        implementation("androidx.core:core:1.13.1") {
            because("1.19.1 требует compileSdk 37 и AGP 9.1.0")
        }
        implementation("androidx.core:core-ktx:1.13.1") {
            because("1.19.1 требует compileSdk 37 и AGP 9.1.0")
        }
    }
}