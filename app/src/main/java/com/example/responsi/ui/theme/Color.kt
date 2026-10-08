package com.example.responsi.ui.theme

import androidx.compose.ui.graphics.Color

/*
 * PENJELASAN: File ini mendefinisikan semua warna kustom yang digunakan
 *             dalam aplikasi sebagai konstanta Kotlin.
 * KENAPA DIPISAHKAN: Memisahkan definisi warna dari penggunaannya memudahkan
 *   pemeliharaan — jika ingin ganti warna brand, cukup ubah di sini.
 * SYARAT: b-i (color scheme kustom dalam Material Design 3)
 */

// Warna utama (primary) untuk light mode — ungu elektrik yang kuat dan modern
val PurplePrimary = Color(0xFF4A00E0)
/*
 * PENJELASAN: Color(0xFF4A00E0) menggunakan format ARGB hex 32-bit.
 *   0xFF = alpha penuh (tidak transparan), 4A00E0 = kode warna RGB ungu.
 * Digunakan sebagai: warna teks judul, ikon, border search bar di light mode.
 */

// Warna utama (primary) untuk dark mode — ungu lebih terang agar kontras di latar gelap
val PurpleSecondary = Color(0xFF7E57C2)

// Warna aksen (secondary) — teal/tosca yang kontras dengan ungu
val TealAccent = Color(0xFF03DAC5)
// Digunakan sebagai: warna chip platform di Detail Screen

// Warna background untuk dark mode — hitam penuh
val DarkBg = Color(0xFF000000)

// Warna surface (card, dialog) untuk dark mode — abu gelap
val DarkSurface = Color(0xFF1E1E1E)

// Warna background untuk light mode — abu sangat muda
val LightBg = Color(0xFFF0F0F0)

// Warna surface untuk light mode — putih bersih
val LightSurface = Color(0xFFFFFFFF)

/*
 * PENJELASAN CARA KERJA: Warna-warna di sini tidak langsung dipakai di UI.
 *   Mereka direferensikan di Theme.kt untuk mengisi DarkColorScheme dan LightColorScheme.
 *   UI kemudian mengakses warna melalui MaterialTheme.colorScheme.primary, .background, dll.
 * KENAPA TIDAK HARDCODE WARNA DI UI: Dengan sistem ini, dark/light mode berfungsi
 *   otomatis — composable hanya perlu menulis MaterialTheme.colorScheme.primary,
 *   dan sistem akan memilih warna yang tepat sesuai mode yang aktif.
 * SYARAT: b-i (color kustom Material Design 3)
 */