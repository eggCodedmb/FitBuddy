package com.anant.fitbuddy.ui.i18n

import com.anant.fitbuddy.data.region.ChinaRegionPack
import com.anant.fitbuddy.data.region.EuropeRegionPack
import com.anant.fitbuddy.data.region.LatinAmericaRegionPack
import com.anant.fitbuddy.data.region.UsRegionPack
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
        assertEquals(
            "饮食区域",
            AppI18n.translate("Region", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "北美",
            AppI18n.translate("N.Am", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "拉美",
            AppI18n.translate("LatAm", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "北美",
            AppI18n.translate("North America", AppLanguage.ZH_CN, Locale.US)
        )
    }

    @Test
    fun `translate handles portion hints for all regions`() {
        assertEquals(
            "知道菜名但不知道克数？可让 AI 估算中国家庭标准份量（碗、两、个等）。",
            AppI18n.translate(ChinaRegionPack.askPortionHint, AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "知道菜名但不知道克数？可让 AI 估算北美家庭/餐厅标准份量（杯、盎司、片等）。",
            AppI18n.translate(UsRegionPack.askPortionHint, AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "知道菜名但不知道克数？可让 AI 估算欧洲家庭标准份量（克、毫升、块/片等）。",
            AppI18n.translate(EuropeRegionPack.askPortionHint, AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "知道菜名但不知道克数？可让 AI 估算拉美家庭/街头饮食标准份量（份、杯、盘等）。",
            AppI18n.translate(LatinAmericaRegionPack.askPortionHint, AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "知道菜名但不知道克数？可让 AI 估算标准家常份量。",
            AppI18n.translate(
                "Know the dish but not grams? Estimates a standard home serving.",
                AppLanguage.ZH_CN,
                Locale.US
            )
        )
        assertEquals(
            "知道菜名但不知道克数？可让 AI 估算美国家庭/餐厅标准份量（杯、盎司、片等）。",
            AppI18n.translate(
                "Know the dish but not grams? Estimates a standard US home/restaurant serving (cups, ounces, slices).",
                AppLanguage.ZH_CN,
                Locale.US
            )
        )
        assertEquals(
            "知道菜名但不知道克数？可让 AI 估算标准家常份量（如面饼数量、小碗容量等）。",
            AppI18n.translate(
                "Know the dish but not grams? Estimates a standard home serving (roti counts, katori volumes).",
                AppLanguage.ZH_CN,
                Locale.US
            )
        )
        assertEquals(
            "知道菜名但不知道克数？可让 AI 估算标准家常份量。",
            AppI18n.translate(
                "Know the dish but not grams? Estimates a standard custom serving.",
                AppLanguage.ZH_CN,
                Locale.US
            )
        )
    }

    @Test
    fun `translate handles food log hints for all regions`() {
        assertEquals(
            "例如：“1 碗米饭配西红柿炒鸡蛋”或“牛肉面”",
            AppI18n.translate(ChinaRegionPack.foodLogHint, AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "例如：“芝士汉堡配薯条”或“2 个煎蛋配吐司”",
            AppI18n.translate(UsRegionPack.foodLogHint, AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "例如：“番茄意面”或“2 片面包配奶酪”",
            AppI18n.translate(EuropeRegionPack.foodLogHint, AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "例如：“2 个墨西哥烤肉塔可”或“鸡肉饭配豆子”",
            AppI18n.translate(LatinAmericaRegionPack.foodLogHint, AppLanguage.ZH_CN, Locale.US)
        )
    }

    @Test
    fun `translate handles activity level descriptions with workout hint suffix`() {
        assertEquals(
            "科学依据与原理",
            AppI18n.translate("How these were calculated", AppLanguage.ZH_CN, Locale.US)
        )
        assertEquals(
            "1.2× 基础代谢 · 大部分时间久坐，极少有规划运动。包含日常锻炼、日常走动与体力劳动。",
            AppI18n.translate(
                "1.2× resting needs · Mostly seated with little planned exercise. Include workouts, daily movement, and physical work.",
                AppLanguage.ZH_CN,
                Locale.US
            )
        )
        assertEquals(
            "1.375× 基础代谢 · 大部分时间久坐，每周约 1-3 天轻度运动。包含日常锻炼、日常走动与体力劳动。",
            AppI18n.translate(
                "1.375× resting needs · Mostly seated plus light exercise about 1–3 days/week. Include workouts, daily movement, and physical work.",
                AppLanguage.ZH_CN,
                Locale.US
            )
        )
        assertEquals(
            "1.55× 基础代谢 · 每周约 3-5 天中度运动或日常较活跃。包含日常锻炼、日常走动与体力劳动。",
            AppI18n.translate(
                "1.55× resting needs · Moderate exercise about 3–5 days/week or an active routine. Include workouts, daily movement, and physical work.",
                AppLanguage.ZH_CN,
                Locale.US
            )
        )
        assertEquals(
            "1.725× 基础代谢 · 每周约 6-7 天高强度运动或从事体力工作。包含日常锻炼、日常走动与体力劳动。",
            AppI18n.translate(
                "1.725× resting needs · Hard exercise about 6–7 days/week or a physical job. Include workouts, daily movement, and physical work.",
                AppLanguage.ZH_CN,
                Locale.US
            )
        )
        assertEquals(
            "1.9× 基础代谢 · 重体力工作且配合高强度训练，或频繁一日双练。包含日常锻炼、日常走动与体力劳动。",
            AppI18n.translate(
                "1.9× resting needs · A strenuous job plus hard training or frequent two-a-days. Include workouts, daily movement, and physical work.",
                AppLanguage.ZH_CN,
                Locale.US
            )
        )
    }

    @Test
    fun `translate handles health target science rationale`() {
        val loseWeightRationale = "Evidence-based v3: Mifflin–St Jeor estimates about 1650 kcal at rest and " +
            "2250 kcal/day including your selected activity level. A moderate 15% deficit gives a starting target " +
            "of 1900 kcal/day. Protein is set near 1.6 g/kg of body weight (120 g), with fat near 25% of energy " +
            "and carbohydrates filling the remainder within adult ranges. The 71.3 kg target is an initial " +
            "milestone of up to 5%, not an ideal weight."

        val translatedLoseWeight = AppI18n.translate(loseWeightRationale, AppLanguage.ZH_CN, Locale.US)
        assertEquals(
            "科学依据 v3：Mifflin-St Jeor 公式估算你的静息代谢约为 1650 千卡，结合所选日常活动量，每日维持热量约为 2250 千卡。按 15% 的适度热量缺口，起始目标定为 1900 千卡/天。蛋白质摄入设定为约 1.6 克/公斤体重（120 克），脂肪约占总能量的 25%，碳水化合物在健康推荐范围内补充剩余热量。71.3 公斤目标为初步的阶段性里程碑（最多 5% 减重），并非最终理想体重。",
            translatedLoseWeight
        )

        val midpointSexRationale = "Evidence-based v3: Mifflin–St Jeor estimates about 1500 kcal at rest and " +
            "2050 kcal/day including your selected activity level. Because sex was not set, the midpoint of the " +
            "two Mifflin–St Jeor constants was used. Estimated maintenance gives a starting target of 2050 kcal/day. " +
            "Protein is set near 1.2 g/kg of body weight (84 g), with fat near 25% of energy and carbohydrates " +
            "filling the remainder within adult ranges. Current weight is retained as a maintenance milestone " +
            "unless you set a different one."

        val translatedMidpoint = AppI18n.translate(midpointSexRationale, AppLanguage.ZH_CN, Locale.US)
        assertEquals(
            "科学依据 v3：Mifflin-St Jeor 公式估算你的静息代谢约为 1500 千卡，结合所选日常活动量，每日维持热量约为 2050 千卡。因未设置生理性别，计算采用了两性常数的中位数。按估算的维持热量，起始目标定为 2050 千卡/天。蛋白质摄入设定为约 1.2 克/公斤体重（84 克），脂肪约占总能量的 25%，碳水化合物在健康推荐范围内补充剩余热量。当前体重作为维持目标的阶段性里程碑，你也可以自行调整。",
            translatedMidpoint
        )

        val trendRationale = loseWeightRationale +
            " Trend-adjusted locally with a cautious reduced calorie step from consistent body and nutrition history; reassess after another two to four weeks."
        val translatedTrend = AppI18n.translate(trendRationale, AppLanguage.ZH_CN, Locale.US)
        assertTrue(translatedTrend.contains("根据连续的体重和饮食记录在本地进行了谨慎的小幅下调热量微调；建议在 2 至 4 周后重新评估。"))

        val stableRationale = "Evidence-based v3: Mifflin–St Jeor estimates about 1650 kcal at rest and " +
            "2250 kcal/day including your selected activity level. Your saved targets are already close to the " +
            "calculated starting point, so they were kept stable. The 71.3 kg target is an initial milestone " +
            "of up to 5%, not an ideal weight."
        val translatedStable = AppI18n.translate(stableRationale, AppLanguage.ZH_CN, Locale.US)
        assertTrue(translatedStable.contains("你当前保存的目标与计算出的基准值非常接近，因此保持不变。"))
    }
}
