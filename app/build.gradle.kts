plugins {
    alias(libs.plugins.android.application)
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("org.jetbrains.compose")
}
android {
    namespace = "com.example.investidorapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.investidorapp"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.7.0")) // Your Firebase BOM
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-database-ktx:20.2.1") // Consider using BOM for Firebase libraries too
    implementation("com.google.firebase:firebase-messaging:23.2.1")    // Consider using BOM
    implementation("com.google.firebase:firebase-messaging-ktx:24.1.0") // Consider using BOM


    // Jetpack Compose
    // Ensure this uses the version from libs.versions.toml (which is 2024.04.01)
    implementation(platform(libs.androidx.compose.bom)) // <<<<< THIS IS THE KEY FIX
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3") // Make sure this is compatible with BOM 2024.04.01
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    androidTestImplementation(platform(libs.androidx.compose.bom)) // This correctly uses 2024.04.01

    // Glance for AppWidgets
    implementation("androidx.glance:glance-appwidget:1.1.0")

    implementation("androidx.glance:glance-material3:1.1.0")

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.2") // Check compatibility with BOM 2024.04.01

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3") // Check Kotlin version compatibility

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2") // Check compatibility
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2") // Check compatibility

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling) // Already covered by libs.androidx.ui.tooling if used
    debugImplementation(libs.androidx.ui.test.manifest)
}