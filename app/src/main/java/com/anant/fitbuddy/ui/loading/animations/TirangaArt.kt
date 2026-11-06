package com.anant.fitbuddy.ui.loading.animations

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin

internal val ChinaFlagRed = Color(0xFFDE2910)
internal val ChinaFlagDeepRed = Color(0xFFB81C0A)
internal val ChinaFlagHighlightRed = Color(0xFFF23A22)
internal val ChinaStarGold = Color(0xFFFFDE00)

// Keep legacy color aliases mapped to Chinese flag palette for callers.
internal val TirangaSaffron = ChinaFlagHighlightRed
internal val TirangaFlagWhite = ChinaFlagRed
internal val TirangaIndiaGreen = ChinaFlagDeepRed
internal val TirangaChakraNavy = ChinaStarGold

/**
 * Waving Chinese red silk flag wash with subtle vertical fold shading and a travelling sheen.
 */
internal fun DrawScope.drawTirangaFabric(
    timeMs: Double,
    columns: Int = 72,
    seamWobbleScale: Float = 1f,
) {
    val W = size.width
    val H = size.height
    val t = timeMs
    val cols = columns.coerceAtLeast(8)
    val colW = W / cols + 1f

    for (i in 0 until cols) {
        val x = i * (W / cols)
        val nx = i.toFloat() / cols
        val wave1 = sin(nx * PI * 2.618 - t * 0.0022).toFloat()
        val wave2 = cos(nx * PI * 4.15 - t * 0.0014 + 0.8).toFloat()
        val fold = (wave1 * 0.65f + wave2 * 0.35f) * seamWobbleScale

        val topColor = flowingBandColor(
            base = ChinaFlagRed,
            hueShiftDeg = fold * 2.0f,
            lightness = (1.0f + fold * 0.10f).coerceIn(0.84f, 1.12f)
        )
        val midColor = flowingBandColor(
            base = ChinaFlagRed,
            hueShiftDeg = fold * 1.5f,
            lightness = (0.98f + fold * 0.12f).coerceIn(0.82f, 1.14f)
        )
        val botColor = flowingBandColor(
            base = ChinaFlagDeepRed,
            hueShiftDeg = fold * 1.8f,
            lightness = (0.96f + fold * 0.10f).coerceIn(0.80f, 1.10f)
        )

        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(topColor, midColor, botColor),
                startY = 0f,
                endY = H
            ),
            topLeft = Offset(x, 0f),
            size = Size(colW, H)
        )
    }

    val sheenX = ((t * 0.08) % (W * 1.4) - W * 0.2).toFloat()
    drawRect(
        brush = Brush.horizontalGradient(
            colors = listOf(
                Color.Transparent,
                Color.White.copy(alpha = 0.14f),
                Color.Transparent
            ),
            startX = sheenX,
            endX = sheenX + W * 0.35f
        )
    )
}

/**
 * Insights-button waving Chinese red silk wash.
 */
internal fun DrawScope.drawTirangaInsightFabric(
    timeMs: Double,
    columns: Int = 48,
    seamWobbleScale: Float = 1.35f,
) {
    drawTirangaFabric(timeMs = timeMs, columns = columns, seamWobbleScale = seamWobbleScale)
}

/**
 * Draws the official Five-star Red Flag (五星红旗) golden star canton constellation.
 *
 * When [fullFlagLayout] is true (region flag preview & thumbnail), the 5 stars are positioned
 * in the upper-left canton using the standard 30×20 national flag grid.
 * When false (compact banner/button emblem around [center]), the 5-star emblem is centered
 * around [center] with scale [outerRadius].
 */
internal fun DrawScope.drawChinaFiveStars(
    timeMs: Double,
    fullFlagLayout: Boolean = true,
    center: Offset = Offset(size.width / 2f, size.height / 2f),
    outerRadius: Float = min(size.width, size.height) * 0.18f,
    color: Color = ChinaStarGold
) {
    if (fullFlagLayout) {
        val unitX = size.width / 30f
        val unitY = size.height / 20f
        val unitR = min(unitX, unitY)

        fun waveOffsetY(gridX: Float): Float {
            val nx = gridX / 30f
            return (sin(nx * PI * 2.618 - timeMs * 0.0022) * size.height * 0.018).toFloat()
        }

        val bigCenter = Offset(5f * unitX, 5f * unitY + waveOffsetY(5f))
        val bigR = 3f * unitR
        drawFivePointStar(
            center = bigCenter,
            outerRadius = bigR,
            rotationRad = (-PI / 2.0).toFloat(),
            color = color
        )

        val smallGridCoords = listOf(
            10f to 2f,
            12f to 4f,
            12f to 7f,
            10f to 9f
        )
        val smallR = 1f * unitR
        smallGridCoords.forEach { (gx, gy) ->
            val sc = Offset(gx * unitX, gy * unitY + waveOffsetY(gx))
            val angleToBig = atan2(bigCenter.y - sc.y, bigCenter.x - sc.x)
            drawFivePointStar(
                center = sc,
                outerRadius = smallR,
                rotationRad = angleToBig,
                color = color
            )
        }
    } else {
        // Compact 5-star emblem around [center] for loading banners/buttons.
        val bob = (sin(timeMs * 0.003) * outerRadius * 0.06).toFloat()
        val bigCenter = Offset(center.x - outerRadius * 0.35f, center.y + bob)
        val bigR = outerRadius * 0.68f
        drawFivePointStar(
            center = bigCenter,
            outerRadius = bigR,
            rotationRad = (-PI / 2.0).toFloat(),
            color = color
        )

        val smallOffsets = listOf(
            0.42f to -0.68f,
            0.78f to -0.26f,
            0.78f to 0.26f,
            0.42f to 0.68f
        )
        val smallR = outerRadius * 0.24f
        smallOffsets.forEachIndexed { idx, (dx, dy) ->
            val localWave = (sin(timeMs * 0.003 + (idx + 1) * 0.6) * outerRadius * 0.05).toFloat()
            val sc = Offset(center.x + dx * outerRadius, center.y + dy * outerRadius + localWave)
            val angleToBig = atan2(bigCenter.y - sc.y, bigCenter.x - sc.x)
            drawFivePointStar(
                center = sc,
                outerRadius = smallR,
                rotationRad = angleToBig,
                color = color
            )
        }
    }
}

/**
 * Compatibility entry point used by loading banners/buttons: renders the Chinese 5-star emblem.
 */
internal fun DrawScope.drawSpinningAshokaChakra(
    center: Offset,
    outerRadius: Float,
    timeMs: Double,
    color: Color = ChinaStarGold,
) {
    drawChinaFiveStars(
        timeMs = timeMs,
        fullFlagLayout = false,
        center = center,
        outerRadius = outerRadius,
        color = color
    )
}

internal fun DrawScope.drawFivePointStar(
    center: Offset,
    outerRadius: Float,
    rotationRad: Float,
    color: Color
) {
    // Official regular pentagram inner-to-outer radius ratio: sin(18°) / sin(54°) ≈ 0.381966
    val innerRadius = outerRadius * 0.381966f
    val path = Path().apply {
        for (i in 0 until 10) {
            val r = if (i % 2 == 0) outerRadius else innerRadius
            val angle = rotationRad + i * (PI / 5.0).toFloat()
            val px = center.x + cos(angle) * r
            val py = center.y + sin(angle) * r
            if (i == 0) moveTo(px, py) else lineTo(px, py)
        }
        close()
    }
    drawPath(path = path, color = color, style = Fill)
}

/** Shift a base RGB toward a nearby hue while keeping saturation soft. */
internal fun flowingBandColor(base: Color, hueShiftDeg: Float, lightness: Float): Color {
    val (h, s, l) = rgbToHsl(base.red, base.green, base.blue)
    val nh = (h + hueShiftDeg / 360f).mod(1f)
    val ns = (s * 0.96f).coerceIn(0f, 1f)
    val nl = (l * lightness).coerceIn(0.15f, 0.97f)
    val (r, g, b) = hslToRgb(nh, ns, nl)
    return Color(r, g, b, base.alpha)
}

internal fun lerpColor(a: Color, b: Color, t: Float): Color {
    val u = t.coerceIn(0f, 1f)
    return Color(
        red = a.red + (b.red - a.red) * u,
        green = a.green + (b.green - a.green) * u,
        blue = a.blue + (b.blue - a.blue) * u,
        alpha = a.alpha + (b.alpha - a.alpha) * u
    )
}

private fun rgbToHsl(r: Float, g: Float, b: Float): Triple<Float, Float, Float> {
    val max = maxOf(r, g, b)
    val min = minOf(r, g, b)
    val l = (max + min) / 2f
    if (max == min) return Triple(0f, 0f, l)
    val d = max - min
    val s = if (l > 0.5f) d / (2f - max - min) else d / (max + min)
    val h = when (max) {
        r -> ((g - b) / d + if (g < b) 6f else 0f) / 6f
        g -> ((b - r) / d + 2f) / 6f
        else -> ((r - g) / d + 4f) / 6f
    }
    return Triple(h, s, l)
}

private fun hslToRgb(h: Float, s: Float, l: Float): Triple<Float, Float, Float> {
    if (s == 0f) return Triple(l, l, l)
    fun hue2rgb(p: Float, q: Float, tIn: Float): Float {
        var t = tIn
        if (t < 0f) t += 1f
        if (t > 1f) t -= 1f
        return when {
            t < 1f / 6f -> p + (q - p) * 6f * t
            t < 1f / 2f -> q
            t < 2f / 3f -> p + (q - p) * (2f / 3f - t) * 6f
            else -> p
        }
    }
    val q = if (l < 0.5f) l * (1f + s) else l + s - l * s
    val p = 2f * l - q
    return Triple(
        hue2rgb(p, q, h + 1f / 3f),
        hue2rgb(p, q, h),
        hue2rgb(p, q, h - 1f / 3f)
    )
}
