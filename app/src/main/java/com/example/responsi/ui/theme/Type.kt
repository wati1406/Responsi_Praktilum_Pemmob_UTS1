package com.example.responsi.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/*
 * PENJELASAN: File ini mendefinisikan sistem typography kustom aplikasi.
 *             Typography menentukan tampilan semua teks di seluruh aplikasi
 *             secara konsisten tanpa perlu menentukan font di setiap Text().
 * KENAPA TYPOGRAPHY SISTEM: Jika ukuran font ditentukan hardcode di setiap composable,
 *   mengubah desain teks berarti mengubah ratusan baris. Dengan sistem typography,
 *   cukup ubah di sini dan semua Text() yang memakai style tersebut ikut berubah.
 * SYARAT: b-iii (typography kustom dalam Material Design 3)
 */
val Typography = Typography(
    /*
     * PENJELASAN: bodyLarge adalah gaya teks untuk konten utama — digunakan
     *             untuk teks deskripsi panjang (misal deskripsi game di Detail Screen).
     * Material Design 3 mendefinisikan skala typography hierarkis:
     *   displayLarge/Medium/Small → headlineLarge/Medium/Small → titleLarge/Medium/Small
     *   → bodyLarge/Medium/Small → labelLarge/Medium/Small
     */
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, // menggunakan font sistem default perangkat
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,    // 16sp adalah ukuran body text standar Material Design
        lineHeight = 24.sp,  // jarak antar baris — 1.5x fontSize untuk keterbacaan optimal
        letterSpacing = 0.5.sp // jarak antar huruf — sedikit lebih lebar untuk kejelasan
    )
    /*
     * KENAPA SP (SCALABLE PIXELS): Berbeda dengan dp, sp mengikuti preferensi ukuran
     *   teks pengguna di pengaturan aksesibilitas Android — lebih inklusif.
     * STYLE LAIN (headlineMedium, titleSmall, dll.) menggunakan nilai default
     *   dari Material Design 3 karena kita tidak menimpanya di sini.
     */
)
/*
 * CARA PENGGUNAAN DI UI:
 *   Text(style = MaterialTheme.typography.bodyLarge)   → pakai bodyLarge
 *   Text(style = MaterialTheme.typography.headlineMedium) → pakai headlineMedium (default MD3)
 * Typography direferensikan di Theme.kt: MaterialTheme(typography = Typography, ...)
 */