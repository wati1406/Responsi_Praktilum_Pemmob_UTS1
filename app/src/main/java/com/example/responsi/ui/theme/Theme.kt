package com.example.responsi.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/*
 * PENJELASAN: DarkColorScheme adalah skema warna untuk dark mode menggunakan
 *             warna kustom yang didefinisikan di Color.kt.
 * KENAPA DARK SCHEME TERPISAH: Material Design 3 membutuhkan dua skema warna
 *   agar tombol, teks, dan background otomatis menyesuaikan saat mode berubah.
 * SYARAT: b-i (color scheme kustom Material Design 3)
 */
private val DarkColorScheme = darkColorScheme(
    primary = PurpleSecondary, // ungu lebih terang agar kontras di latar hitam
    secondary = TealAccent,
    background = DarkBg,       // hitam penuh sebagai background
    surface = DarkSurface      // abu gelap untuk card dan dialog
)

// Skema warna untuk light mode — warna lebih gelap karena latar terang
private val LightColorScheme = lightColorScheme(
    primary = PurplePrimary,   // ungu elektrik yang kuat di latar putih
    secondary = TealAccent,
    background = LightBg,      // abu sangat muda
    surface = LightSurface     // putih bersih untuk card
)

/*
 * PENJELASAN: ResponsiTheme adalah composable tema yang membungkus seluruh UI aplikasi.
 *             Setiap composable di dalam ResponsiTheme dapat mengakses warna, typography,
 *             dan shapes yang didefinisikan di sini melalui MaterialTheme.colorScheme, dll.
 * KENAPA COMPOSABLE THEME: Ini adalah pola CompositionLocal — MaterialTheme menyediakan
 *   nilai-nilai desain ke seluruh pohon composable di bawahnya tanpa perlu meneruskan
 *   parameter secara manual ke setiap composable (prop drilling).
 * SYARAT: b (Material Design 3 — color + typography + shape)
 */
@Composable
fun ResponsiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // ikuti setting dark/light mode sistem
    dynamicColor: Boolean = true,               // gunakan Dynamic Color jika tersedia
    content: @Composable () -> Unit             // CONTOH LAMBDA: konten UI yang dibungkus tema
) {
    val colorScheme = when {
        /*
         * PENJELASAN: Dynamic Color (Material You) adalah fitur Android 12+ yang
         *             menghasilkan skema warna dari wallpaper pengguna secara otomatis.
         * PRIORITAS:
         *   1. Jika Android 12+ dan dynamicColor aktif → pakai warna dari wallpaper
         *   2. Jika dark mode → pakai DarkColorScheme kustom
         *   3. Default → pakai LightColorScheme kustom
         */
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else      -> LightColorScheme
    }

    /*
     * PENJELASAN: SideEffect menjalankan kode non-Compose (side-effect) setelah
     *             setiap recomposition berhasil. Di sini digunakan untuk mengubah
     *             warna status bar agar sesuai dengan background aplikasi.
     * KENAPA SIDEEFFECT: Mengubah status bar color adalah operasi View system
     *   (imperatif), bukan Compose — harus dilakukan di sisi effect.
     */
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb() // warna status bar = background app
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
            // isAppearanceLightStatusBars: ikon status bar putih (dark mode) atau hitam (light mode)
        }
    }

    /*
     * PENJELASAN: MaterialTheme menyediakan sistem desain ke seluruh UI di bawahnya.
     *   - colorScheme: palet warna yang dipilih berdasarkan dark/light/dynamic
     *   - typography: sistem teks dari Type.kt
     *   - content: CONTOH LAMBDA — seluruh UI aplikasi diteruskan sebagai lambda
     * SYARAT: b (Material Design 3 lengkap: color + typography)
     */
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // referensi ke objek Typography dari Type.kt
        content = content        // CONTOH LAMBDA: konten composable dieksekusi di sini
    )
}