plugins {
    alias(libs.plugins.android.application)
    // If you ever migrate to Kotlin: kotlin("kapt") version "1.9.0"
}

android {
    namespace   = "com.example.itubeapp"
    compileSdk  = 35

    defaultConfig {
        applicationId     = "com.example.itubeapp"
        minSdk            = 28
        targetSdk         = 35
        versionCode       = 1
        versionName       = "1.0"

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
    // AndroidX & Material3
    implementation(libs.appcompat)
    implementation("com.google.android.material:material:1.10.0")
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // RecyclerView + CardView
    implementation("androidx.recyclerview:recyclerview:1.3.0")
    implementation("androidx.cardview:cardview:1.0.0")

    // Room (Java annotationProcessor)
    implementation("androidx.room:room-runtime:2.5.1")
    implementation("androidx.room:room-ktx:2.5.1")      // Kotlin extensions (optional)
    annotationProcessor("androidx.room:room-compiler:2.5.1")

    // Android YouTube Player
    implementation("com.pierfrancescosoffritti.androidyoutubeplayer:core:11.1.0")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
