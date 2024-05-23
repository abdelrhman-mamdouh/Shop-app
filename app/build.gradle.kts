plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.apollographql.apollo3") version "4.0.0-beta.6"
}

android {
    namespace = "com.example.exclusive"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.exclusive"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.7")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // SDP (ScalableDP) and SSP (ScalableSP) libraries for handling scalable dimensions and spacing
    implementation("com.intuit.sdp:sdp-android:1.0.6")
    implementation("com.intuit.ssp:ssp-android:1.0.6")

    // Lifecycle components for managing Android lifecycle-aware components
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    // Lifecycle extensions for additional Android lifecycle support
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")


    // Kotlin coroutines for asynchronous programming
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")

    // Room persistence library for database management
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")

    // Google Play services dependency for accessing location services
    implementation ("com.google.android.gms:play-services-location:21.0.0")
    implementation ("com.google.android.gms:play-services-maps:18.0.2")
    implementation ("com.google.android.libraries.places:places:3.3.0")

    // lottie
    implementation("com.airbnb.android:lottie:6.3.0")

    // Glide library
    implementation("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

    // CircleImageView library for displaying circular images
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Gson
    implementation ("com.google.code.gson:gson:2.9.0")

    // okHTTP
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.3"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // RoundedImageView
    implementation ("com.makeramen:roundedimageview:2.3.0")

    //Apollo
    implementation("com.apollographql.apollo3:apollo-runtime:4.0.0-beta.6")

}