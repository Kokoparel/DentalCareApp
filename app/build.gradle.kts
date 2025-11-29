plugins {
    // Gunakan HANYA SATU dari baris di bawah ini.
    // Jika Anda menggunakan version catalog (libs), gunakan yang ini:
    alias(libs.plugins.android.application)

    // Jika tidak, hapus baris di atas dan gunakan yang ini:
    // id("com.android.application") version "8.X.X" // Ganti 8.X.X dengan versi plugin Anda
}

android {
    namespace = "com.example.dentalcareapp.app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.dentalcareapp"
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
}

dependencies {
    // Gunakan format Version Catalog (jika sudah di-setup di settings.gradle.kts)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Dependensi tambahan yang belum ada di catalog bisa ditambahkan manual
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.cardview:cardview:1.0.0")

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
