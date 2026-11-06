package com.anant.fitbuddy.ui.i18n

import com.anant.fitbuddy.data.settings.AppLanguage
import java.util.Locale
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AppI18nTest {

    @Test
    fun `resolveLanguage resolves SYSTEM against system locale`() {
        assertEquals(
            AppLanguage.ZH_CN,
            AppI18n.resolveLanguage(AppLanguage.SYSTEM, Locale.SIMPLIFIED_CHINESE)
        )
        assertEquals(
            AppLanguage.EN,
            AppI18n.resolveLanguage(AppLanguage.SYSTEM, Locale.US)
        )
        assertEquals(
            AppLanguage.ZH_CN,
            AppI18n.resolveLanguage(AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            AppLanguage.EN,
            AppI18n.resolveLanguage(AppLanguage.EN, Locale.SIMPLIFIED_CHINESE)
        )
    }

    @Test
    fun `isChinese reflects resolved language`() {
        assertTrue(AppI18n.isChinese(AppLanguage.ZH_CN, Locale.US))
        assertFalse(AppI18n.isChinese(AppLanguage.EN, Locale.SIMPLIFIED_CHINESE))
        assertTrue(AppI18n.isChinese(AppLanguage.SYSTEM, Locale.SIMPLIFIED_CHINESE))
        assertFalse(AppI18n.isChinese(AppLanguage.SYSTEM, Locale.US))
    }

    @Test
    fun `translate returns Chinese when ZH_CN is active and English when EN is active`() {
        assertEquals(
            "偏好设置",
            AppI18n.translate("Preferences", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "Preferences",
            AppI18n.translate("Preferences", AppLanguage.EN, Locale.SIMPLIFIED_CHINESE)
        )
        assertEquals(
            "今日总览",
            AppI18n.translate("Dashboard", AppLanguage.SYSTEM, Locale.SIMPLIFIED_CHINESE)
        )
        assertEquals(
            "Dashboard",
            AppI18n.translate("Dashboard", AppLanguage.SYSTEM, Locale.US)
        )
    }

    @Test
    fun `translate handles dynamic patterns in Simplified Chinese`() {
        assertEquals(
            "早上好，Anant",
            AppI18n.translate("Good morning, Anant", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "已记录 Oats · 320 千卡",
            AppI18n.translate("Logged Oats · 320 kcal", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "剩余 450 kcal",
            AppI18n.translate("450 kcal left", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "五星红旗",
            AppI18n.translate("Chinese flag", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "拍照识别 · Gemini 2.5 Flash",
            AppI18n.translate("Photo · Gemini 2.5 Flash", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "已记录 慢跑 · 消耗 250 kcal",
            AppI18n.translate("Logged 慢跑 · -250 kcal", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "大部分时间久坐，极少有规划运动",
            AppI18n.translate("Mostly seated with little planned exercise", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "AI 在线",
            AppI18n.translate("AI online", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "文本模型",
            AppI18n.translate("Text model", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "身体成分分析",
            AppI18n.translate("Body Composition", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "2100 kcal · 目标 2000 kcal",
            AppI18n.translate("2100 kcal · target 2000", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "胸肌与三头肌",
            AppI18n.translate("Chest & Triceps", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "身体评分",
            AppI18n.translate("Body Score", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "改进建议",
            AppI18n.translate("Recommendations", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "周一",
            AppI18n.translate("Mon", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "1月",
            AppI18n.translate("Jan", AppLanguage.ZH_CN, Locale.US)
        )
    }
}
