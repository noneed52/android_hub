@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.test)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.chaesung.test_app"
    compileSdk = 34
    targetProjectPath = ":app"

    defaultConfig {
        minSdk = 30

        testInstrumentationRunner = "com.chaesung.testing.HiltTestRunner"
    }

    buildFeatures {
        aidl = false
        buildConfig = false
        renderScript = false
        shaders = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":app"))
    implementation(project(":core:data"))
    implementation(project(":core:testing"))
    implementation(project(":feature:hub"))

    // Testing
    implementation(libs.androidx.test.core)

    // Hilt and instrumented tests.
    implementation(libs.hilt.android.testing)
    kapt(libs.hilt.android.compiler)

    // Compose
    implementation(libs.androidx.compose.ui.test.junit4)
}