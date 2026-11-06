package com.anant.fitbuddy.data.region

import com.anant.fitbuddy.data.prompts.PromptCatalog

/** China region pack: Chinese home cooking, cafeteria/takeout staples, and portion language. */
object ChinaRegionPack : RegionPack {

    override val region: AppRegion = AppRegion.CHINA
    override val displayName: String = "China"

    val RICE_BOWL = RegionalDish(
        "Steamed white rice (1 bowl)",
        150, 175, 4, 39, 0,
        listOf("rice", "steamed rice", "white rice", "mifan", "米饭", "白米饭", "chawal")
    )
    val ROTI = RegionalDish(
        "Steamed bun (mantou)",
        100, 220, 7, 47, 1,
        listOf("mantou", "steamed bun", "bun", "馒头", "花卷", "roti", "chapati", "phulka")
    )
    val PARATHA = RegionalDish(
        "Scallion pancake (cong you bing)",
        100, 290, 7, 38, 12,
        listOf("scallion pancake", "congyoubing", "bing", "葱油饼", "烙饼", "煎饼", "paratha", "parantha")
    )
    val NAAN = RegionalDish(
        "Pork steamed bun (baozi)",
        100, 230, 9, 32, 7,
        listOf("baozi", "steamed stuffed bun", "肉包", "包子", "小笼包", "naan")
    )
    val BHATURA = RegionalDish(
        "Fried dough stick (youtiao)",
        60, 230, 4, 25, 13,
        listOf("youtiao", "fried dough stick", "油条", "bhatura", "bhature")
    )
    val DAL_KATORI = RegionalDish(
        "Tomato scrambled eggs",
        180, 210, 12, 8, 14,
        listOf("tomato egg", "tomato scrambled eggs", "fanqie chaodan", "番茄炒蛋", "西红柿炒鸡蛋", "dal", "daal")
    )
    val CHOLE_KATORI = RegionalDish(
        "Kung Pao chicken",
        180, 310, 26, 14, 17,
        listOf("kung pao", "gongbao", "stir-fried chicken", "宫保鸡丁", "辣子鸡", "炒鸡肉", "chole", "chana masala")
    )
    val CURD_KATORI = RegionalDish(
        "Unsweetened soy milk (1 cup)",
        250, 85, 7, 4, 4,
        listOf("soy milk", "doujiang", "豆浆", "豆腐脑", "curd", "raita", "dahi", "yogurt")
    )
    val SABZI_DRY = RegionalDish(
        "Stir-fried seasonal greens",
        150, 95, 3, 7, 6,
        listOf("stir-fried greens", "bok choy", "qingcai", "青菜", "炒青菜", "生菜", "油麦菜", "sabzi", "sabji")
    )
    val SAMOSA = RegionalDish(
        "Pork & cabbage dumplings (6 pcs)",
        150, 330, 14, 36, 14,
        listOf("dumplings", "dumpling", "jiaozi", "gyoza", "水饺", "饺子", "煎饺", "锅贴", "samosa")
    )
    val GHEE_TSP = RegionalDish(
        "Cooking oil (1 tsp)",
        5, 45, 0, 0, 5,
        listOf("cooking oil", "oil", "食用油", "植物油", "花生油", "菜籽油", "猪油", "ghee")
    )
    val NOODLE_BOWL = RegionalDish(
        "Wheat noodle soup bowl",
        300, 380, 14, 62, 8,
        listOf("noodles", "noodle", "lamian", "beef noodles", "面条", "汤面", "牛肉面", "拌面")
    )
    val MAPO_TOFU = RegionalDish(
        "Mapo tofu (1 bowl)",
        180, 220, 13, 8, 15,
        listOf("mapo tofu", "tofu", "doufu", "麻婆豆腐", "家常豆腐", "豆腐")
    )

    override val staples: List<RegionalDish> = listOf(
        RICE_BOWL, ROTI, PARATHA, NAAN, BHATURA, DAL_KATORI, CHOLE_KATORI,
        CURD_KATORI, SABZI_DRY, SAMOSA, NOODLE_BOWL, MAPO_TOFU, GHEE_TSP
    )

    override fun promptReferenceTable(): String = """
        Staple reference (typical Chinese home/cafeteria serving; adjust to size/count — priors, not hard law):
        - 1 bowl steamed white rice (米饭) ~${RICE_BOWL.weightG} g → ~${RICE_BOWL.calories} kcal / P${RICE_BOWL.proteinG} C${RICE_BOWL.carbsG} F${RICE_BOWL.fatsG}
        - 1 steamed bun / mantou (馒头) ~${ROTI.weightG} g → ~${ROTI.calories} kcal / P${ROTI.proteinG} C${ROTI.carbsG} F${ROTI.fatsG}
        - 1 pork baozi (肉包) ~${NAAN.weightG} g → ~${NAAN.calories} kcal / P${NAAN.proteinG} C${NAAN.carbsG} F${NAAN.fatsG}
        - 1 fried dough stick / youtiao (油条) ~${BHATURA.weightG} g → ~${BHATURA.calories} kcal / P${BHATURA.proteinG} C${BHATURA.carbsG} F${BHATURA.fatsG}
        - 1 scallion pancake (葱油饼) ~${PARATHA.weightG} g → ~${PARATHA.calories} kcal / P${PARATHA.proteinG} C${PARATHA.carbsG} F${PARATHA.fatsG}
        - 6 pork & cabbage dumplings (水饺 6个) ~${SAMOSA.weightG} g → ~${SAMOSA.calories} kcal / P${SAMOSA.proteinG} C${SAMOSA.carbsG} F${SAMOSA.fatsG}
        - 1 bowl wheat noodles in broth (汤面) ~${NOODLE_BOWL.weightG} g → ~${NOODLE_BOWL.calories} kcal / P${NOODLE_BOWL.proteinG} C${NOODLE_BOWL.carbsG} F${NOODLE_BOWL.fatsG}
        - tomato scrambled eggs (番茄炒蛋) ~${DAL_KATORI.weightG} g → ~${DAL_KATORI.calories} kcal / P${DAL_KATORI.proteinG} C${DAL_KATORI.carbsG} F${DAL_KATORI.fatsG}
        - Kung Pao / stir-fried chicken (宫保鸡丁) ~${CHOLE_KATORI.weightG} g → ~${CHOLE_KATORI.calories} kcal / P${CHOLE_KATORI.proteinG} C${CHOLE_KATORI.carbsG} F${CHOLE_KATORI.fatsG}
        - Mapo tofu (麻婆豆腐) ~${MAPO_TOFU.weightG} g → ~${MAPO_TOFU.calories} kcal / P${MAPO_TOFU.proteinG} C${MAPO_TOFU.carbsG} F${MAPO_TOFU.fatsG}
        - stir-fried seasonal greens (清炒时蔬) ~${SABZI_DRY.weightG} g → ~${SABZI_DRY.calories} kcal / P${SABZI_DRY.proteinG} C${SABZI_DRY.carbsG} F${SABZI_DRY.fatsG}
        - 1 cup unsweetened soy milk (无糖豆浆) ~${CURD_KATORI.weightG} g → ~${CURD_KATORI.calories} kcal / P${CURD_KATORI.proteinG} C${CURD_KATORI.carbsG} F${CURD_KATORI.fatsG}
        - cooking fat: 1 tsp cooking oil (食用油) ~${GHEE_TSP.weightG} g → ~${GHEE_TSP.calories} kcal (all fat)
    """.trimIndent()

    override val analyzeSystemIntro: String
        get() = PromptCatalog.regionText(region, "analyze_system_intro")
    override val targetSystemIntro: String
        get() = PromptCatalog.regionText(region, "target_system_intro")
    override val progressSystemIntro: String
        get() = PromptCatalog.regionText(region, "progress_system_intro")
    override val analyzePromptPriors: String
        get() = PromptCatalog.regionText(region, "analyze_prompt_priors")
    override val targetCoachNotes: String
        get() = PromptCatalog.regionText(region, "target_coach_notes")
    override val progressFoodGuidance: String
        get() = PromptCatalog.regionText(region, "progress_food_guidance")
    override val measurementPromptNotes: String
        get() = PromptCatalog.regionText(region, "measurement_prompt_notes")
    override val askPortionPromptNotes: String
        get() = PromptCatalog.regionText(region, "ask_portion_prompt_notes")

    override val foodLogHint: String =
        "e.g. \"1 bowl of rice with tomato scrambled eggs\" or \"beef noodles\""

    override val askPortionHint: String =
        "Know the dish but not grams? Estimates a standard Chinese home serving " +
            "(bowls, liang, pieces)."

    override val barcodeExample: String = "6901234567890"
}

@Deprecated("Use ChinaRegionPack instead", ReplaceWith("ChinaRegionPack"))
typealias IndiaRegionPack = ChinaRegionPack
