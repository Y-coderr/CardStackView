plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.cardstackview"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.cardstackview"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    //implementation ("com.yuyakaido.android:card-stack-view:2.3.4")
    implementation ("androidx.appcompat:appcompat:1.5.1")
    implementation ("com.google.android.material:material:1.7.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

    // Card Stack View Library
    //implementation ("com.github.yuyakaido:CardStackView:2.3.4")
    //implementation ("com.github.Yalantis:Koloda-Android:v0.0.1-alpha")
    implementation("com.lorentzos.swipecards:library:1.0.9")
}