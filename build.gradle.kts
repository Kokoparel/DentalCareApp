// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Tentukan plugin yang akan digunakan oleh sub-modul di sini
    // 'apply false' berarti plugin ini tidak diterapkan di root project,
    // tetapi versinya akan tersedia untuk modul lain (seperti :app)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false // Tambahkan ini jika Anda menggunakan Kotlin
}
