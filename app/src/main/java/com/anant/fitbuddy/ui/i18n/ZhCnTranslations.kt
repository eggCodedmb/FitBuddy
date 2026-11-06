package com.anant.fitbuddy.ui.i18n

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString

/**
 * Simplified Chinese (`zh-CN`) translation dictionary and dynamic pattern rules for FitBuddy.
 */
object ZhCnTranslations {

    fun translate(text: String): String {
        exactMap[text]?.let { return it }
        val trimmed = text.trim()
        if (trimmed != text) {
            exactMap[trimmed]?.let { translated ->
                val leading = text.takeWhile { it.isWhitespace() }
                val trailing = text.takeLastWhile { it.isWhitespace() }
                return leading + translated + trailing
            }
        }
        return translateDynamic(text)
    }

    fun translateAnnotated(text: AnnotatedString): AnnotatedString {
        val raw = text.text
        if (raw == "Crafted with ❤️ by Anant") {
            val anantStyle = text.spanStyles.firstOrNull {
                raw.substring(it.start, it.end) == "Anant"
            }?.item
            return buildAnnotatedString {
                append("用 ❤️ 精心打造 · 作者 ")
                if (anantStyle != null) {
                    pushStyle(anantStyle)
                    append("Anant")
                    pop()
                } else {
                    append("Anant")
                }
            }
        }
        exactMap[raw]?.let { translated ->
            if (text.spanStyles.isEmpty()) return AnnotatedString(translated)
        }
        return text
    }

    private val exactMap: Map<String, String> = buildMap(4000) {
        // --- Language / i18n ---
        put("Language", "语言 / Language")
        put("Internationalization", "国际化语言")
        put("App language", "应用语言")
        put("Choose the display language for FitBuddy. System default follows your device language.", "选择 FitBuddy 的界面显示语言。“系统默认”将跟随设备系统语言。")
        put("Follows device language (Simplified Chinese or English).", "跟随系统语言（支持简体中文或英文）。")
        put("System default", "系统默认")
        put("English", "英文")
        put("简体中文", "简体中文")
        put("Chinese (Simplified)", "简体中文")

        // --- Bottom Bar & Top Navigation ---
        put("Today", "今日")
        put("Yesterday", "昨天")
        put("Week", "周视图")
        put("Progress", "趋势")
        put("Body", "身体")
        put("Settings", "设置")
        put("Log", "记录")
        put("Back", "返回")
        put("Next", "下一步")
        put("Close", "关闭")
        put("Cancel", "取消")
        put("Save", "保存")
        put("Done", "完成")
        put("Delete", "删除")
        put("Edit", "编辑")
        put("Confirm", "确认")
        put("Continue", "继续")
        put("Skip", "跳过")
        put("Retry", "重试")
        put("Clear", "清除")
        put("Reset", "重置")
        put("Copy", "复制")
        put("Share", "分享")
        put("Update", "更新")
        put("Apply", "应用")
        put("Dismiss", "关闭")
        put("Got it", "知道了")
        put("Not now", "暂不")
        put("Yes", "是")
        put("No", "否")
        put("OK", "确定")
        put("Search", "搜索")
        put("All", "全部")
        put("Optional", "选填")
        put("Required", "必填")
        put("Loading…", "加载中…")
        put("Saving…", "保存中…")
        put("Validating…", "验证中…")
        put("Restoring…", "恢复中…")
        put("Uploading…", "上传中…")
        put("Downloading…", "下载中…")

        // --- Greetings & Dashboard ---
        put("Dashboard", "今日总览")
        put("Week history", "本周记录")
        put("Good morning", "早上好")
        put("Good afternoon", "下午好")
        put("Good evening", "晚上好")
        put("What's your name?", "如何称呼你？")
        put("Used for a friendly greeting on your dashboard.", "用于在首页向你展示亲切的问候。")
        put("First name", "名字 / 昵称")
        put("Last name (optional)", "姓氏（选填）")
        put("Last name", "姓氏")
        put("Analyzing meal or workout…", "正在分析饮食或运动…")
        put("Analyzing your entry…", "正在分析记录…")
        put("Calories remaining", "剩余可摄入热量")
        put("Over target", "超出目标")
        put("kcal left", "千卡剩余")
        put("left", "剩余")
        put("eaten", "已摄入")
        put("Exercise", "运动消耗")
        put("This week", "本周")
        put("Calories this week", "本周热量趋势")
        put("Tap a bar for macros · selects that day's log", "点击柱状图查看营养素并切换至当天记录")
        put("Edit meal / foods", "编辑餐食 / 食物")
        put("View / edit exercises", "查看 / 编辑训练动作")
        put("Clone item", "复制记录")
        put("Remove from log", "删除此条记录")
        put("Clone to…", "复制到…")
        put("Today's log", "今日记录")
        put("Pick a date…", "选择日期…")
        put("Save as meal preset", "保存为套餐预设")
        put("Save to food library", "保存到食物库")
        put("Saved to food library", "已保存到食物库")
        put("Edit food", "编辑食物")
        put("Edit workout", "编辑训练")
        put("No entries yet", "暂无记录")
        put("Tap Log to add food or a workout.", "点击下方「记录」添加饮食或训练。")
        put("No entries on this day", "当天暂无记录")
        put("Use Log and pick this date to backfill an entry.", "点击「记录」并选择该日期即可补录。")
        put("CALORIES EATEN", "已摄入热量")
        put("EAT UP TO", "还可摄入")
        put("OVER TARGET", "超出目标")
        put("ON TARGET", "已达标")
        put("DAILY TARGET", "每日目标")
        put("PROTEIN", "蛋白质")
        put("CARBS", "碳水")
        put("FATS", "脂肪")
        put("Protein", "蛋白质")
        put("Carbs", "碳水")
        put("Fats", "脂肪")
        put("Calories", "热量")
        put("Calories eaten", "已摄入热量")
        put("Calories burned", "消耗热量")
        put("Net calories", "净热量")
        put("Remaining", "剩余")
        put("Target", "目标")
        put("Eaten", "已吃")
        put("Burned", "消耗")
        put("MEALS LOGGED", "已记饮食")
        put("ACTIVITY BURNED", "运动消耗")
        put("Today's Log", "今日记录")
        put("Meals", "饮食")
        put("Activity", "运动")
        put("Workouts", "训练")
        put("No meals logged yet", "还没有饮食记录")
        put("Tap + Log to snap a meal photo, scan a barcode, or describe what you ate.", "点击下方「+ 记录」拍照识别餐食、扫描条形码或输入你吃了什么。")
        put("No activity logged yet", "还没有运动记录")
        put("Log a workout or describe your activity to track calories burned.", "记录一次训练或描述你的运动，追踪消耗的热量。")
        put("No logs for this day", "当天没有记录")
        put("No meals logged on this day", "当天未记录饮食")
        put("No activity logged on this day", "当天未记录运动")
        put("Clone to today", "复制到今天")
        put("Save as preset", "存为预设")
        put("Save food", "保存食物")
        put("Log food", "记录食物")
        put("Edit entry", "编辑记录")
        put("Delete entry", "删除记录")
        put("Jump to today", "回到今天")
        put("Select date", "选择日期")
        put("Log date", "记录日期")
        put("AI Offline", "AI 离线")
        put("AI Online", "AI 在线")

        // --- Week / 7-Day History ---
        put("7-Day History", "7天历史记录")
        put("Weekly Summary", "本周汇总")
        put("Avg Calories", "平均热量")
        put("Avg Protein", "平均蛋白质")
        put("Total Burned", "总消耗")
        put("Days Logged", "已记录天数")
        put("Tap a day to view or edit its logs", "点击某一天查看或编辑当天记录")

        // --- Analytics / Progress Screen ---
        put("Weekly", "按周")
        put("Monthly", "按月")
        put("Last 7 days", "最近 7 天")
        put("Last 30 days", "最近 30 天")
        put("Calories Eaten vs Target", "摄入热量 vs 每日目标")
        put("Tap a bar to see that day's calorie & macro breakdown", "点击柱状图查看当天的热量与三大营养素详情")
        put("Tap a point to see that day's calorie & macro breakdown", "点击数据点查看当天的热量与三大营养素详情")
        put("Target line", "目标线")
        put("Body Composition", "身体成分趋势")
        put("Tap a point to inspect that reading", "点击数据点查看当次测量详情")
        put("Log at least 1 body measurement in Profile to see trends.", "在「身体」页面记录至少 1 次身体测量数据后即可查看趋势。")
        put("Weight (kg)", "体重 (kg)")
        put("Body fat (%)", "体脂率 (%)")
        put("Muscle (kg)", "肌肉量 (kg)")
        put("Calories Burned · Last 6 months", "运动消耗热量 · 最近 6 个月")
        put("Weekly totals · tap a point for that week's burned kcal", "每周总计 · 点击数据点查看当周消耗热量")
        put("AI Progress Coach", "AI 进度教练")
        put("Generate insight", "生成 AI 洞察")
        put("Crafting your insight…", "正在生成你的专属洞察…")
        put("Tap Generate insight for a personalised review of your trends.", "点击「生成 AI 洞察」获取针对你近期趋势的个性化分析。")
        put("Nutrition", "营养")
        put("Body Metrics", "身体指标")
        put("7D", "7天")
        put("14D", "14天")
        put("30D", "30天")
        put("90D", "90天")
        put("1Y", "1年")
        put("ALL", "全部")
        put("AI Progress Insight", "AI 趋势洞察")
        put("Generate Insight", "生成洞察")
        put("Regenerate", "重新生成")
        put("Ask Coach", "咨询教练")
        put("Ask follow-up", "继续追问")
        put("Progress Coach", "AI 进度教练")
        put("Clear chat", "清空对话")
        put("Ask about your nutrition, workouts, or body trends…", "询问关于你的营养、训练或身体趋势的问题…")
        put("Send", "发送")
        put("Thinking…", "思考中…")
        put("Analyzing your trends…", "正在分析你的趋势数据…")
        put("Daily Calorie Intake", "每日热量摄入")
        put("Calorie Intake", "热量摄入")
        put("Macro Split", "三大营养素占比")
        put("Daily Macros", "每日营养素")
        put("Workout Calories Burned", "运动热量消耗")
        put("Workout Duration", "运动时长")
        put("Weight Trend", "体重趋势")
        put("Body Fat %", "体脂率 %")
        put("Body Fat", "体脂率")
        put("Muscle Mass", "肌肉量")
        put("BMR", "基础代谢 (BMR)")
        put("No data in this range", "该时间段暂无数据")
        put("Recommendations", "建议")
        put("Body score", "身体评分")

        // --- Body / Profile Screen ---
        put("Body & goals", "身体与目标")
        put("Food library", "食物与套餐库")
        put("Body composition", "身体指标记录")
        put("Log a new reading", "记录新测量数据")
        put("Body fat %", "体脂率 %")
        put("BMR (kcal)", "基础代谢 (kcal)")
        put("Muscle mass (kg)", "肌肉量 (kg)")
        put("Log reading", "保存测量")
        put("Daily targets", "每日营养目标")
        put("Goal mode", "目标模式")
        put("Choose automatically", "自动选择（AI 推荐）")
        put("Body recomposition", "增肌减脂（身体塑形）")
        put("Target weight (kg, optional)", "目标体重（kg，选填）")
        put("Leave blank to let AI suggest a healthy target", "留空则由 AI 建议健康的目标体重")
        put("Recalculate targets with AI", "使用 AI 重新计算目标")
        put("Save manual targets", "保存手动目标")
        put("Daily calories", "每日热量 (kcal)")
        put("Body basics", "基本身体资料")
        put("Age, height, sex, and activity live in Settings → Profile.", "年龄、身高、性别与日常活动量可在「设置 → 个人资料」中修改。")
        put("Reading history", "历史测量记录")
        put("Saved meals", "预设套餐")
        put("Saved foods", "常用食物")
        put("Create meal", "创建套餐")
        put("Create food", "创建食物")
        put("No saved meals yet", "暂无预设套餐")
        put("Build a multi-food meal once (e.g. breakfast plate) and log it in one tap.", "预先组合包含多种食物的一餐（如早餐拼盘），之后即可一键记录。")
        put("Build your first meal", "创建第一个套餐")
        put("No saved foods yet", "暂无常用食物")
        put("Save single dishes or scanned items here for quick logging and meal building.", "将单品菜肴或扫码商品保存在此，方便快速记录或组合套餐。")
        put("Add your first food", "添加第一个常用食物")
        put("Log to today", "记录到今天")
        put("Body & Targets", "身体与目标")
        put("Body Profile", "身体档案")
        put("Daily Targets", "每日营养目标")
        put("Target Weight (kg)", "目标体重 (kg)")
        put("Target weight (kg)", "目标体重 (kg)")
        put("Height (cm)", "身高 (cm)")
        put("Age", "年龄")
        put("Sex", "性别")
        put("Male", "男")
        put("Female", "女")
        put("Other / Prefer not to say", "其他 / 保密")
        put("Prefer not to say", "保密")
        put("Goal", "目标方向")
        put("Fat Loss", "减脂")
        put("Lose Fat", "减脂")
        put("Lose weight", "减脂 / 减重")
        put("Cut", "减脂")
        put("Body Recomposition", "增肌减脂 (塑形)")
        put("Recomp", "增肌减脂")
        put("Maintain", "保持体重")
        put("Maintenance", "保持")
        put("Muscle Gain", "增肌")
        put("Lean Bulk", "干净增肌")
        put("Gain muscle", "增肌")
        put("Bulk", "增肌")
        put("Auto (AI recommended)", "自动（AI 推荐）")
        put("Activity Level", "日常活动量")
        put("Activity level", "日常活动量")
        put("Sedentary", "久坐少动")
        put("Lightly Active", "轻度活动")
        put("Lightly active", "轻度活动")
        put("Moderately Active", "中度活动")
        put("Moderately active", "中度活动")
        put("Very Active", "高度活动")
        put("Very active", "高度活动")
        put("Extra Active", "极高强度")
        put("Extra active", "极高强度")
        put("Desk job, little or no exercise", "办公室工作，几乎不运动")
        put("Light exercise 1–3 days/week", "每周轻度运动 1–3 天")
        put("Moderate exercise 3–5 days/week", "每周中等强度运动 3–5 天")
        put("Hard exercise 6–7 days/week", "每周高强度运动 6–7 天")
        put("Very hard training or physical job", "每天高强度训练或体力劳动")
        put("Save Body Profile", "保存身体档案")
        put("Save Profile", "保存个人资料")
        put("Recalculate with AI", "AI 重新计算目标")
        put("Calculate with AI", "AI 计算目标")
        put("Designing targets…", "正在计算营养目标…")
        put("Save Daily Targets", "保存每日目标")
        put("Save Targets", "保存目标")
        put("Daily Calories (kcal)", "每日热量 (kcal)")
        put("Protein (g)", "蛋白质 (g)")
        put("Carbs (g)", "碳水 (g)")
        put("Fats (g)", "脂肪 (g)")
        put("Measurement History", "历史测量记录")
        put("Recent Measurements", "最近测量记录")
        put("No measurements logged yet", "暂无测量记录")
        put("Latest Reading", "最新读数")
        put("Why these targets?", "目标制定依据")

        // --- Log Hub Sheet & Food/Meal Logging ---
        put("Describe", "文字描述")
        put("Snap a meal", "拍照记餐")
        put("From photos", "相册选图")
        put("Type it loosely", "自然语言输入")
        put("Scan barcode", "扫描条码")
        put("Packaged food", "包装食品")
        put("Saved meal", "预设套餐")
        put("One tap", "一键记录")
        put("Saved food", "常用食物")
        put("From library", "从食物库选择")
        put("Gym or cardio", "力量或有氧")
        put("Food", "食物")
        put("Describe what you ate", "描述你吃了什么")
        put("Describe your workout", "描述你的运动")
        put("AI estimates calories and macros from a quick note.", "只需简单描述，AI 即可估算热量与营养素。")
        put("AI estimates calories burned from your activity and body weight.", "AI 会结合你的活动内容与体重估算消耗的热量。")
        put("What did you eat?", "吃了什么？")
        put("Activity (e.g. 5 km run, leg day)", "运动内容（如：5 公里跑、练腿）")
        put("Duration in minutes (optional)", "运动时长（分钟，选填）")
        put("Estimate & log", "AI 估算并记录")
        put("Log Meal or Activity", "记录饮食或运动")
        put("What did you eat or do?", "你吃了什么，或者做了什么运动？")
        put("Snap a photo, scan a barcode, or describe what you ate or how you trained.", "拍照识别、扫描条形码，或直接输入你的饮食与训练内容。")
        put("Camera", "拍照")
        put("Take Photo", "拍照")
        put("Gallery", "相册")
        put("Photo", "照片")
        put("Barcode", "条形码")
        put("Scan Barcode", "扫码")
        put("Saved Foods", "常用食物")
        put("Saved", "已存食物")
        put("Meal Presets", "套餐预设")
        put("Presets", "预设套餐")
        put("Build Meal", "组合餐食")
        put("Log Workout", "记录训练")
        put("Workout", "训练")
        put("Analyze", "AI 分析")
        put("Analyze & Log", "分析并记录")
        put("Add context (optional)", "补充说明（选填）")
        put("Remove photo", "移除照片")

        // --- Region Pack Hints ---
        put("e.g. 2 rotis with dal and a bowl of curd, or 30 min run", "例如：两碗米饭配番茄炒蛋，或跑步 30 分钟")
        put("e.g. 2 eggs, sourdough toast with avocado, or 30 min run", "例如：两个鸡蛋、全麦吐司配牛油果，或跑步 30 分钟")
        put("e.g. quark with berries, wholegrain bread, or 30 min cycling", "例如：酸奶配莓果、全麦面包，或骑行 30 分钟")
        put("e.g. 3 chicken tacos with beans and rice, or 30 min run", "例如：鸡肉卷配米饭黑豆，或跑步 30 分钟")

        // --- Food & Meal Review / Builder ---
        put("Review food", "确认食物")
        put("Review Food", "确认食物")
        put("Review meal", "确认餐食")
        put("Review Meal", "确认餐食")
        put("Edit meal", "编辑餐食")
        put("Edit Meal", "编辑餐食")
        put("Update meal", "更新餐食")
        put("Save meal", "保存餐食")
        put("Foods", "食物列表")
        put("No foods in this meal. Go back and add at least one food.", "该餐食中还没有食物，请返回并至少添加一项食物。")
        put("Total weight (g)", "总重量 (g)")
        put("Change this to scale every ingredient's weight (and macros) proportionally.", "修改总重量将按比例缩放所有配料的重量与营养素。")
        put("Know the dish but not grams? Estimates a standard home serving.", "知道菜名但不知道克数？可让 AI 估算标准家常份量。")
        put("Build a Meal", "组合一餐")
        put("Dish Name", "食物名称")
        put("Dish name", "食物名称")
        put("Meal Name", "餐食名称")
        put("Meal name", "餐食名称")
        put("Ingredients", "配料明细")
        put("Add Ingredient", "添加配料")
        put("Add ingredient", "添加配料")
        put("Add Food", "添加食物")
        put("Add food", "添加食物")
        put("Grams", "克数 (g)")
        put("Weight (g)", "重量 (g)")
        put("Servings", "份数")
        put("Serving size", "单份重量")
        put("Re-analyze", "重新分析")
        put("Re-analyze with AI", "使用 AI 重新分析")
        put("Estimate standard portion", "估算标准份量")
        put("Log Food", "记录食物")
        put("Log Meal", "记录餐食")
        put("Save Changes", "保存修改")
        put("Saved to presets", "已保存到预设")
        put("Saved to foods", "已保存到常用食物")
        put("No meal presets yet", "暂无套餐预设")
        put("Edit Saved Food", "编辑常用食物")
        put("Scanned Product", "扫码商品")
        put("Scan food barcode", "扫描食品条形码")
        put("Point your camera at a nutrition barcode", "将摄像头对准食品包装上的条形码")
        put("Looking up product…", "正在查询商品营养信息…")
        put("Product not found", "未找到该商品信息")

        // --- Workout Log & Exercise Picker ---
        put("Edit Workout", "编辑训练")
        put("Clone Workout", "复制训练")
        put("Workout Name", "训练名称")
        put("Session name", "训练名称")
        put("Session duration (minutes)", "训练时长（分钟）")
        put("Used to estimate calories burned — not a substitute for logging reps.", "用于估算训练消耗热量。")
        put("Estimating calories…", "正在估算消耗热量…")
        put("Save & Estimate Calories", "保存并估算消耗热量")
        put("Suggest name with AI", "AI 智能命名")
        put("Duration (min)", "时长 (分钟)")
        put("Duration", "时长")
        put("Exercises", "训练动作")
        put("Add Exercise", "添加动作")
        put("Add exercise", "添加动作")
        put("Pick Exercise", "选择动作")
        put("Custom Exercise", "自定义动作")
        put("Search exercises…", "搜索训练动作…")
        put("Sets", "组数")
        put("Reps", "次数")
        put("Weight", "重量")
        put("Distance (km)", "距离 (km)")
        put("Save Workout", "保存训练")
        put("Body Part", "部位")
        put("Equipment", "器械")
        put("Chest", "胸部")
        put("Back", "背部")
        put("Shoulders", "肩部")
        put("Upper Arms", "上臂")
        put("Lower Arms", "前臂")
        put("Upper Legs", "大腿")
        put("Lower Legs", "小腿")
        put("Waist", "腰腹 / 核心")
        put("Cardio", "有氧")
        put("Neck", "颈部")
        put("Full Body", "全身")
        put("Barbell", "杠铃")
        put("Dumbbell", "哑铃")
        put("Machine", "固定器械")
        put("Cable", "绳索")
        put("Bodyweight", "自重")
        put("Body Weight", "自重")
        put("Kettlebell", "壶铃")
        put("Band", "弹力带")
        put("Smith Machine", "史密斯机")
        put("EZ Barbell", "曲杆杠铃")
        put("Other", "其他")

        // --- Settings Screen ---
        put("Updates & support", "更新与支持")
        put("Supporting FitBuddy", "支持 FitBuddy")
        put("Check for Update", "检查更新")
        put("Checking for updates…", "正在检查更新…")
        put("Automatically check on startup", "启动时自动检查更新")
        put("Checks GitHub Releases at most once every 24h", "每 24 小时最多检查一次 GitHub Releases")
        put("Send anonymous crash reports", "发送匿名崩溃报告")
        put("Helps fix bugs via Sentry. No personal or meal data is sent.", "通过 Sentry 帮助修复问题，不会发送任何个人或饮食数据。")
        put("Food & diet region", "饮食习惯区域")
        put("Tunes AI portion defaults, barcode fallbacks, and offline staple foods.", "调整 AI 份量估算默认值、条码回退库与离线常见食物。")
        put("Daily log reminder", "每日记录提醒")
        put("Nudge me if I haven't logged a meal today", "若当天尚未记录饮食，向我发送提醒通知")
        put("Reminder time", "提醒时间")
        put("Change", "修改")
        put("Fires only when today's food log is still empty.", "仅在当天饮食记录为空时触发提醒。")
        put("Themes", "主题外观")
        put("Customise colors, fonts, and loading animations.", "自定义配色方案、字体与加载动画。")
        put("Color theme", "色彩主题")
        put("Use dynamic system colors (Material You)", "使用系统动态配色 (Material You)")
        put("Overrides the theme above with your wallpaper palette (Android 12+)", "使用系统壁纸调色板覆盖上方主题（Android 12+）")
        put("Font", "字体")
        put("Component style", "组件风格")
        put("Loading animations", "加载动画")
        put("Analyzing meal / workout", "分析饮食 / 运动动画")
        put("Shown on the home banner while AI is logging an entry.", "当 AI 正在解析记录时在首页顶部横幅展示。")
        put("Generating AI insight", "生成 AI 洞察动画")
        put("Shown inside the Progress tab's AI Progress Coach card.", "在「趋势」页面的 AI 进度教练卡片中展示。")
        put("UI animations", "界面动画")
        put("Smooth progress bars, calorie ring, and chart transitions", "启用平滑的进度条、热量环与图表过渡动画")
        put("AI Provider", "AI 服务商")
        put("FitBuddy works with OpenRouter, Google Gemini, Ollama (local or Ollama Cloud), or any OpenAI-compatible API.", "FitBuddy 支持 OpenRouter、Google Gemini、Ollama（本地或云端）以及任何兼容 OpenAI 的接口。")
        put("Need help getting an API key?", "需要获取 API 密钥的帮助？")
        put("Provider", "服务商")
        put("Configure AI, appearance, backups, and app preferences.", "配置 AI 模型、外观主题、数据备份与应用偏好（含多语言）。")
        put("AI Configuration", "AI 配置")
        put("Platform", "平台")
        put("API Key", "API 密钥")
        put("API Keys", "API 密钥")
        put("Add API Key", "添加密钥")
        put("Paste API key", "粘贴 API 密钥")
        put("Photo / Vision Model", "图片 / 视觉模型")
        put("Vision Model", "视觉模型")
        put("Text Model", "文本模型")
        put("Text Model (optional)", "文本模型（选填）")
        put("Auto failover", "自动故障切换")
        put("Show paid models", "显示付费模型")
        put("Refresh models", "刷新模型列表")
        put("Save AI Settings", "保存 AI 设置")
        put("Save AI settings", "保存 AI 设置")
        put("Connect with OpenRouter", "连接 OpenRouter")
        put("Continue with OpenRouter", "通过 OpenRouter 登录")
        put("Disconnect", "断开连接")
        put("Connected via OAuth", "已通过 OAuth 连接")
        put("Local Server", "本地服务器")
        put("Ollama Cloud", "Ollama 云端")
        put("Server URL", "服务器地址")
        put("Base URL", "接口地址 (Base URL)")

        put("Profile", "个人资料")
        put("Permanent details used for BMR and calorie calculations.", "用于计算基础代谢 (BMR) 与热量目标的基本资料。")
        put("Save profile", "保存个人资料")

        put("Themes & Appearance", "主题与外观")
        put("Appearance", "外观")
        put("Material You (Dynamic color)", "Material You 动态取色")
        put("Material You", "Material You 动态配色")
        put("Uses your wallpaper colors on Android 12+.", "在 Android 12+ 上跟随系统壁纸自动配色。")
        put("Color Theme", "色彩主题")
        put("Color palette", "配色方案")
        put("App font", "应用字体")
        put("Component Style", "组件风格")
        put("Material", "Material 圆润")
        put("Mako", "Mako 硬朗")
        put("Loading Animations", "加载动画")
        put("Analyzing banner animation", "分析横幅动画")
        put("Insight button animation", "洞察按钮动画")
        put("Random", "随机")
        put("Off", "关闭")

        put("Preferences", "偏好设置")
        put("India", "印度")
        put("North America (US & Canada)", "北美（美国与加拿大）")
        put("Europe", "欧洲")
        put("Latin America", "拉丁美洲")
        put("Day rollover hour", "日期切换时间（跨天小时）")
        put("Day change hour", "跨天时间")
        put("Midnight (12:00 AM)", "午夜 (00:00)")
        put("Auto-check for updates", "自动检查更新")
        put("Check for updates on startup", "启动时自动检查新版本")

        put("Backup", "数据备份")
        put("Backup & Restore", "备份与恢复")
        put("Cloud Backup", "云端备份")
        put("Cloud backup", "云端备份")
        put("Local Backup", "本地备份")
        put("Local backup", "本地备份")
        put("Auto-upload every 12h", "每 12 小时自动上传")
        put("Upload now", "立即上传")
        put("Restore from cloud", "从云端恢复")
        put("Change password", "修改密码")
        put("Export backup", "导出备份")
        put("Import backup", "导入备份")
        put("Export JSON", "导出备份文件")
        put("Import JSON", "导入备份文件")

        put("Privacy & Diagnostics", "隐私与诊断")
        put("Send crash reports", "发送崩溃报告")
        put("Diagnostic logging", "诊断日志")
        put("Export diagnostic log", "导出诊断日志")
        put("Clear diagnostic log", "清空诊断日志")
        put("Support ID", "支持 ID (Support ID)")
        put("Copy Support ID", "复制支持 ID")
        put("Regenerate Support ID", "重新生成支持 ID")

        put("Support FitBuddy", "支持 FitBuddy")
        put("Donate", "捐赠支持")
        put("Supporters Hall of Fame", "支持者名人堂")
        put("View Supporters", "查看支持者")
        put("About", "关于")
        put("Version", "版本")
        put("Check for updates", "检查更新")
        put("Up to date", "已是最新版本")
        put("Source code on GitHub", "GitHub 开源仓库")
        put("Report an issue", "反馈问题")
        put("Developer", "开发者选项")
        put("Developer Tools", "开发者工具")

        // --- Onboarding & Opt-in Screens ---
        put("Welcome to FitBuddy", "欢迎使用 FitBuddy")
        put("AI-powered nutrition & workout tracker", "AI 驱动的饮食与运动健康助手")
        put("Get Started", "开始使用")
        put("Restore from backup", "从备份恢复")
        put("Restore from cloud backup", "从云端备份恢复")
        put("Restore from local file", "从本地文件恢复")
        put("Choose your region", "选择你的饮食区域")
        put("Choose your food region", "选择你的饮食区域")
        put("We use this to personalise calorie estimates, staple foods, and coaching tone for your diet and lifestyle.", "我们会根据你所在的区域个性化估算热量、常见主食以及 AI 教练建议风格。")
        put("Don't see your region? Request another", "没有看到你的区域？申请添加其他区域")
        put("Request another region", "申请添加其他区域")
        put("Tell us which country or region's diet to add next.", "告诉我们你希望接下来支持哪个国家或地区的饮食习惯。")
        put("Region or country", "国家或地区")
        put("Send region request?", "发送区域申请？")
        put("No meals, photos, names, or API keys are ever included.", "绝不会包含任何餐食、照片、姓名或 API 密钥。")
        put("Cloud Backup (Optional)", "云端备份（可选）")
        put("Crash Reporting", "崩溃报告")
        put("Finish Setup", "完成设置")
        put("Validate & Continue", "验证并继续")
        put("How to create an OpenRouter API key", "如何创建 OpenRouter API 密钥")
        put("How to create a Gemini API key", "如何创建 Gemini API 密钥")
        put("Ollama install & setup guide", "Ollama 安装与配置指南")
        put("OpenAI API keys & compatible APIs", "OpenAI API 密钥与兼容接口指南")

        // --- Loading Animation Captions ---
        put("ANALYZING", "分析中")
        put("reading the plate…", "正在识别餐盘食物…")
        put("estimating portions…", "正在估算份量…")
        put("crunching macros…", "正在计算营养素…")
        put("checking micronutrients…", "正在核对营养成分…")
        put("almost ready…", "即将完成…")

        // --- Common Status & Toast Messages ---
        put("Settings saved", "设置已保存")
        put("Profile saved", "个人资料已保存")
        put("Body saved · dashboard recalibrated", "身体档案已保存 · 首页已重新校准")
        put("Manual targets saved · dashboard recalibrated", "手动目标已保存 · 首页已重新校准")
        put("Your science-based targets are ready", "基于科学的营养目标已就绪")
        put("Calculating your science-based targets…", "正在计算科学的营养目标…")
        put("Using default targets — refine anytime in Body", "已使用默认目标 — 可随时在「身体」页面微调")
        put("Notifications not allowed.", "未授予通知权限。")
        put("Copied to clipboard", "已复制到剪贴板")
        put("Support ID copied", "已复制支持 ID")
        put("Cloud backup already up to date", "云端备份已是最新")
        put("Cloud backup password updated", "云端备份密码已更新")
        put("Model cooldowns cleared", "模型冷却状态已清除")
        put("Built-in model defaults applied", "已恢复内置默认模型")

        // --- Activity Levels & Daily Routine ---
        put("Sedentary", "久坐少动")
        put("Mostly seated with little planned exercise", "大部分时间久坐，极少有规划运动")
        put("Light", "轻度活动")
        put("Mostly seated plus light exercise about 1–3 days/week", "大部分时间久坐，每周约 1-3 天轻度运动")
        put("Moderate", "中度活动")
        put("Moderate exercise about 3–5 days/week or an active routine", "每周约 3-5 天中度运动或日常较活跃")
        put("Active", "高度活跃")
        put("Hard exercise about 6–7 days/week or a physical job", "每周约 6-7 天高强度运动或从事体力工作")
        put("Very Active", "极高强度活动")
        put("Very active", "极高强度活动")
        put("A strenuous job plus hard training or frequent two-a-days", "重体力工作且配合高强度训练，或频繁一日双练")
        put("Typical overall activity", "日常总体活动量")
        put(". Include workouts, daily movement, and physical work.", "。包含日常锻炼、走动与体力劳动。")
        put("Activity used", "采用的活动量")
        put("Activity recommendation", "活动量建议")
        put("Apply activity level", "应用活动量等级")
        put("Use current", "使用当前值")

        // --- BMR, Health Targets & Science Recommendations ---
        put("Science-based recommendation", "科学依据推荐")
        put("Health target recommendation", "健康目标推荐")
        put("Weight milestone recommendation", "阶段体重目标推荐")
        put("You're on track", "保持得很好，正在正轨上")
        put("Daily plan", "每日方案")
        put("Your saved nutrition targets remain unchanged.", "你保存的营养目标保持不变。")
        put("Calorie calculation", "热量计算依据")
        put("Mifflin–St Jeor resting estimate, adjusted for the activity level above and your goal.", "基于 Mifflin–St Jeor 公式估算基础静息热量，并根据上述活动水平与健身目标调整。")
        put("Resting estimate", "静息代谢估算")
        put("Activity multiplier", "活动系数")
        put("Estimated maintenance", "预估维持热量")
        put("Goal adjustment", "目标热量微调")
        put("Formula target", "公式理论目标")
        put("Target stability", "目标稳定性保持")
        put("Small differences from your saved target are retained to avoid unnecessary changes.", "为避免频繁变动，与已保存目标的微小差异予以保留。")
        put("Body-trend adjustment", "身体趋势动态微调")
        put("Final daily target", "最终每日目标")
        put("This target was calculated locally from your profile, activity level, and goal.", "此目标已根据你的档案、活动水平与目标在本地完成计算。")
        put("Body trend (optional)", "身体指标趋势（可选）")
        put("The formula target was retained after reviewing the trend.", "综合趋势分析后，维持公式理论目标不变。")
        put("More consistent readings are needed.", "需要更持续稳定的测量数据以供分析。")
        put("No trend adjustment was applied; the profile-based formula remains available without scale history.", "未应用趋势调整；无体脂秤历史记录时仍使用基于档案的科学公式。")
        put("Weight milestone", "阶段体重目标")
        put("No automatic scale-weight change is recommended, so your current weight is used as a maintenance milestone.", "暂不建议自动调整体重，当前体重作为维持目标。")
        put("An initial milestone of up to 5% based on your selected weight-loss goal.", "基于你的减重目标，设定最高约 5% 的初期减重里程碑。")
        put("These are adult planning estimates, not medical advice. Reassess progress regularly and seek professional guidance when needed.", "以上为面向成人的规划参考估值，非医疗建议。请定期评估进度，必要时咨询专业医师。")
        put("Apply recommendations", "应用推荐方案")
        put("Save weight milestone", "保存阶段体重目标")
        put("Discard", "放弃更改")
        put("Loaded FreeScale reading — review and tap Save.", "已读取 FreeScale 体脂秤数据 — 请核对并轻触保存。")
        put("Could not load FreeScale reading", "无法读取 FreeScale 体脂秤数据")
        put("Loading from FreeScale…", "正在从 FreeScale 读取…")
        put("Pull latest from FreeScale", "从 FreeScale 获取最新测量")
        put("Smart-scale metrics (optional)", "智能体脂秤指标（可选）")
        put("Save reading", "保存测量")
        put("FreeScale not installed", "未安装 FreeScale")
        put("Install FreeScale to pull the latest scale reading into this form. Open the FreeScale page to download it, then come back and try again.", "安装 FreeScale 可自动将最新体脂秤数据导入此表单。前往 FreeScale 页面下载安装后即可重试。")
        put("Get FreeScale", "获取 FreeScale")
        put("Delete reading", "删除测量记录")
        put("Enter a valid weight milestone", "请输入有效的阶段体重目标")
        put("Add a current reading before setting a weight milestone", "设定阶段体重目标前，请先添加一条当前体重记录")
        put("A muscle-gain target cannot be below your current weight", "增肌目标体重不能低于当前体重")
        put("A weight-loss target cannot be above your current weight", "减重目标体重不能高于当前体重")
        put("Track composition, set targets, and manage saved foods for meals.", "跟踪身体成分、设定健康目标并管理常用食物。")
        put("Current weight (kg)", "当前体重 (kg)")
        put("Add a reading to update your current weight", "添加测量记录以更新当前体重")
        put("Weight milestone (kg, optional)", "阶段体重目标 (kg，可选)")
        put("Personalized targets set a bounded weight milestone when appropriate; otherwise your current weight is used as a maintenance milestone.", "个性化目标会在合理范围内设定体重里程碑；否则将当前体重作为维持目标。")
        put("Save body data", "保存身体数据")
        put("No saved foods yet — scan barcodes from Log or bookmark foods after AI review.", "暂无常用食物 — 可在记录页扫条码或在 AI 识别后收藏食物。")
        put("No readings yet. Add your weight (and optional smart-scale metrics) to start tracking.", "暂无测量记录。记录你的体重（及可选的体脂秤指标）开始追踪。")
        put("Add a reading", "添加测量记录")
        put("Enter a whole number", "请输入整数")
        put("Must be greater than 0", "必须大于 0")
        put("Cannot be negative", "不能为负数")
        put("Calories (kcal)", "热量 (kcal)")
        put("Manual targets are applied across your dashboard. Personalized target calculation starts fresh from your body data and does not use these values. Consult a qualified health professional before changing health targets.", "手动目标将应用于整个首页仪表盘。个性化目标计算将完全从你的身体数据重新推导，不依赖这些手动值。在调整健康目标前建议咨询专业人士。")
        put("Calculate personalized targets", "计算个性化健康目标")
        put("Targets and safe trend adjustments are calculated on device; AI may choose between those exact options and personalize the explanation.", "健康目标与安全趋势调整全部在设备本地完成计算；AI 仅会在安全方案中选择并提供个性化说明。")
        put("Targets and safe trend adjustments are calculated on device — no AI connection required.", "健康目标与安全趋势调整全部在设备本地完成计算 — 无需连接 AI。")
        put("How these were calculated", "计算依据与原理")
        put("AI coaching note", "AI 指导建议")
        put("Workout logs may not include physical work, daily movement, or unlogged exercise.", "运动记录可能未涵盖体力工作、日常走动或未登记的日常活动。")

        // --- Animations & Waiting Text ---
        put("Chinese flag", "五星红旗")
        put("DNA helix", "DNA 双螺旋")
        put("DNA helix horizontal", "DNA 双螺旋（横向）")
        put("Japan rowing", "日式赛艇")
        put("Solar system", "太阳系行星")
        put("Generating insight…", "正在生成洞察…")
        put("Reading your charts…", "正在读取数据图表…")
        put("Crunching the numbers…", "正在分析计算数据…")
        put("Spotting trends…", "正在发现健康趋势…")
        put("Almost there…", "马上就好…")
        put("Weighing the data…", "正在权衡分析数据…")
        put("Consulting the AI…", "正在向 AI 咨询…")
        put("Mapping your progress…", "正在绘制进度轨迹…")
        put("Calculating targets…", "正在计算健康目标…")
        put("Checking your profile…", "正在检查个人资料…")
        put("Weighing the options…", "正在权衡方案…")
        put("Mapping your goals…", "正在规划健身目标…")
        put("Fine-tuning numbers…", "正在微调数值…")
        put("Updating catalog…", "正在更新动作库…")
        put("Analysing…", "正在分析…")

        // --- Onboarding & Setup ---
        put("Enter your first name", "输入你的名字")
        put("Height", "身高")
        put("Add an API key or continue with OpenRouter sign-in", "添加 API 密钥或通过 OpenRouter 登录继续")
        put("Add an Ollama Cloud API key", "添加 Ollama Cloud API 密钥")
        put("Add an API key", "添加 API 密钥")
        put("Enter your Ollama server URL", "输入 Ollama 服务器地址")
        put("Enter a base URL", "输入 Base URL 地址")
        put("Couldn't validate that API key", "无法验证该 API 密钥")
        put("Enable crash reporting on the previous page to request a custom region.", "请在上一页启用崩溃报告以提交新地区支持请求。")
        put("Enable Send crash reports in Settings to request a custom region.", "请在设置中开启“发送崩溃报告”以提交新地区支持请求。")
        put("Reconnect AI", "重新连接 AI")
        put("Your data was restored, but AI credentials are missing or no longer work. Connect a provider to continue.", "你的数据已恢复，但 AI 凭证丢失或已失效。请连接 AI 服务商后继续。")
        put("Start fresh, or restore a previous backup from the cloud or a local file.", "从头开始，或从云端及本地备份文件恢复历史数据。")
        put("Connect an AI provider first, then tell us about yourself so we can personalise calorie targets, workout estimates, and meal logging.", "首先连接 AI 服务商，接着告诉我们你的个人情况，以便我们为你定制热量目标、运动消耗估算与饮食记录。")
        put("AI setup", "AI 配置")
        put("Enter the Support ID from the device that created the backup.", "请输入创建该备份的原设备支持 ID。")
        put("How do you want to start?", "你希望如何开始？")
        put("Start Fresh", "全新开始")
        put("Restore from local backup", "从本地备份恢复")
        put("Connect an AI", "连接 AI")
        put("FitBuddy needs an LLM to read food photos, freeform text logs, and set your initial calorie targets. Connect a provider to continue.", "FitBuddy 需要大模型来识别食物图片、解析自然语言并定制初始热量目标。请连接服务商继续。")
        put("Create an Ollama Cloud API key", "创建 Ollama Cloud API 密钥")
        put("Use OpenAI or any compatible server (LM Studio, vLLM, LocalAI, Together, Groq, …). The URL defaults to OpenAI; change it for other hosts. Local servers usually need no key.", "使用 OpenAI 或任何兼容服务（LM Studio、vLLM、LocalAI、Together、Groq 等）。默认地址为 OpenAI 官方，其他服务请修改地址。本地服务通常无需密钥。")
        put("API keys (optional)", "API 密钥（选填）")
        put("Your credentials stay on-device and only go to the provider you chose.", "你的密钥仅保存在设备本地，且仅会发送给你选择的服务商。")
        put("About you", "关于你")
        put("Your lifestyle", "生活方式")
        put("We'll calculate adult calorie and macro targets on your device from these details when you open the dashboard. If AI is connected, it can personalize the explanation but not the math.", "进入首页后，应用会根据这些身体信息在本地计算成人的热量与三大营养素目标。连接 AI 后仅会协助生成人性化说明，数学计算严格由本地完成。")
        put("Restore failed", "恢复失败")
        put("Setting up…", "正在配置…")
        put("Save & continue", "保存并继续")
        put("Password required", "需要密码")
        put("This cloud backup is protected by a custom password. Enter it to restore.", "该云端备份受自定义密码保护，请输入密码以恢复。")
        put("This backup is password-protected. Enter the password to restore it.", "该备份受密码保护，请输入密码以导入恢复。")
        put("NEED A HAND?", "需要帮助？")
        put("Onboarding guide", "新手引导指南")
        put("Walk through first-run setup in your browser", "在浏览器中查看首次配置完整说明")
        put("Open", "打开")

        // --- Settings Screen Details ---
        put("Exact alarms not allowed — reminders may be delayed.", "未允许精确闹钟权限 — 提醒可能会有延迟。")
        put("Notifications not allowed — reminder turned off.", "未允许通知权限 — 每日提醒已关闭。")
        put("Unavailable while Show paid models is on — pick one model yourself. Turn paid models off to use Auto failover again.", "显示付费模型时不可用 — 需手动指定单一模型。关闭“付费模型”即可重新启用自动故障转移。")
        put("When on, FitBuddy tries other API keys, then other models on the same platform. When off, only your selected model is used, but other API keys are still tried on failure. Change platform manually if everything fails.", "开启后，FitBuddy 会在请求失败时尝试其他备用密钥及同平台的其他模型。关闭后仅使用指定模型，仅在同模型下轮换密钥。若全部失败可手动切换平台。")
        put("Paid models", "付费模型")
        put("Off (default): free models only. On: also list paid models and turn Auto failover off so you pick one model yourself. Refresh skips reachability checks while paid models are shown.", "关闭（默认）：仅列出免费模型。开启：一并列出付费模型并关闭自动故障转移，需手动指定模型。显示付费模型时刷新将跳过连通性检测。")
        put("Active models", "当前生效模型")
        put("Green lines show the models last used successfully (reset to your dropdown picks when you Save AI Settings). Rate-limited models are skipped until the next UTC midnight, unless you save that model again — Save clears its cooldown so Auto retries your selection.", "绿色标记显示最近一次成功调用的模型（保存 AI 设置时重置为下拉选中的模型）。受速率限制的模型会在 UTC 午夜前被跳过，除非重新保存该模型 — 保存会重置冷却状态以便自动重试。")
        put("Photo model (vision)", "拍照模型 (视觉)")
        put("Photo model (free + vision)", "拍照模型 (免费 + 视觉)")
        put("Text model (free)", "文本模型 (免费)")
        put("Used for typed logs and \"recalculate with AI\" (no photo). Leave blank to reuse the photo model. Order follows the failover ladder.", "用于纯文本饮食记录和“AI 重新计算”（无图片）。留空则复用拍照视觉模型。排序遵循故障转移梯队。")
        put("Get a key from Google AI Studio (aistudio.google.com).", "前往 Google AI Studio (aistudio.google.com) 获取密钥。")
        put("Free Flash plus paid Pro.", "免费 Flash 系列及付费 Pro 系列。")
        put("Free Flash models only.", "仅免费 Flash 模型。")
        put("Dropdown order follows the approved failover ladder. With Auto failover on, failed keys then models rotate on Gemini only.", "下拉菜单顺序遵循推荐的故障转移阶梯。开启自动转移后，仅在 Gemini 平台内轮换失败的密钥与模型。")
        put("Local", "本地")
        put("Cloud", "云端")
        put("Reachable from the phone, e.g. http://192.168.1.10:11434. Use a vision model (llava/gemma) for food photos.", "手机局域网内可访问的地址，如 http://192.168.1.10:11434。识别食物照片请使用视觉模型（如 llava/gemma）。")
        put("Ollama Local", "Ollama 本地服务")
        put("Cloud uses https://ollama.com. Create keys at ollama.com/settings/keys. Gemma models are preferred. Leave text model blank to reuse the photo model.", "云端使用 https://ollama.com。在 ollama.com/settings/keys 生成密钥。推荐 Gemma 模型。文本模型留空即可复用拍照模型。")
        put("Use a vision model (llava/gemma) for food photos. Leave text model blank to reuse the photo model. For LM Studio / vLLM / other OpenAI-compatible hosts, prefer the Custom provider.", "识别食物照片请选择视觉模型（llava/gemma）。文本模型留空即可复用拍照模型。LM Studio、vLLM 或其他 OpenAI 兼容服务请使用“自定义”服务商。")
        put("Works with OpenAI and any OpenAI-compatible API — LM Studio, vLLM, LocalAI, Together, Groq, Azure OpenAI-compatible gateways, and more. Defaults to OpenAI’s official URL; change the Base URL for other hosts.", "支持 OpenAI 官方以及任何兼容接口 — LM Studio、vLLM、LocalAI、Together、Groq、Azure OpenAI 等网关。默认为 OpenAI 官方地址；其他服务请修改 Base URL。")
        put("Official OpenAI is https://api.openai.com. For a local server try http://192.168.x.x:1234 (LM Studio) or :11434 (Ollama’s OpenAI layer). Enter the host only — no /v1 suffix. FitBuddy calls {base}/v1/chat/completions and {base}/v1/models.", "OpenAI 官方地址为 https://api.openai.com。本地服务可尝试 http://192.168.x.x:1234 (LM Studio) 或 :11434 (Ollama OpenAI 兼容层)。仅输入主机与端口，无需 /v1 后缀。FitBuddy 会请求 {base}/v1/chat/completions 与 {base}/v1/models。")
        put("API keys (optional for local servers)", "API 密钥（本地服务选填）")
        put("Paste an OpenAI key for api.openai.com (paid). Local servers often need no key — leave keys empty. Leave text model blank to reuse the photo model.", "访问 api.openai.com（付费）请粘贴 OpenAI 密钥。本地服务通常无需密钥，留空即可。文本模型留空即可复用拍照模型。")
        put("Surface lab", "界面实验室")
        put("Available for supporters", "支持者专属特权")
        put("Use wallpaper-based dynamic colors (Android 12+). Turn off to pick a static FitBuddy or Catppuccin palette.", "使用基于壁纸的动态色彩 (Android 12+)。关闭后可选择静态 FitBuddy 经典或 Catppuccin 调色板。")
        put("FitBuddy follows system light/dark. Catppuccin Latte is light; Frappé, Macchiato, and Mocha are dark.", "FitBuddy 跟随系统深浅色模式。Catppuccin Latte 为浅色；Frappé、Macchiato 与 Mocha 为深色。")
        put("Components", "组件形态")
        put("Material keeps soft rounded corners. Mako uses sharp, flat panels and mixes with any color theme or font.", "Material 风格保留柔和的圆角。Mako 风格采用利落平整的直角面板，可与任意主题色彩或字体混搭。")
        put("Applies app-wide. The Mako font pairs well with Mako components.", "全应用生效。Mako 字体与 Mako 组件风格搭配效果最佳。")
        put("Themes are available exclusively for supporters. Donate to get access.", "个性化主题为支持者专属功能。赞助支持后即可解锁体验。")
        put("Local notification once a day (no Google Play Services). Default time is 8:00 PM.", "每日发送一次本地通知（无需 Google Play 服务）。默认时间为晚上 8:00。")
        put("Exact alarms are off for FitBuddy. Reminders may be delayed until you allow Alarms & reminders in system settings.", "FitBuddy 尚未获取精确闹钟权限。在系统设置中允许“闹钟和提醒”之前，通知提醒可能会延迟到达。")
        put("Allow exact alarms", "允许精确闹钟")
        put("Play wait animations while AI analyses food or generates insights. Off shows a simple spinner.", "在 AI 分析食物或生成洞察时播放等待动画。关闭则显示极简转圈动画。")
        put("Analyzing banner", "识别横幅动画")
        put("Insights button", "洞察按钮动画")
        put("Per-slot wait UI: Random, Off (spinner), or a fixed animation for that slot.", "每个位置可单独设置：随机播放、关闭（极简转圈）或固定动画。")
        put("12AM (midnight)", "午夜 12:00 (0点)")
        put("Day starts at", "每日起始时间")
        put("Logs before this hour count toward the previous day. Useful if you eat late at night.", "在此时间之前的记录将计入前一天。适合经常深夜就餐或夜猫子作息。")
        put("Personalises food log examples, portion units, staples, and coaching.", "根据地区个性化食物范例、份量单位、常见主食与健康指导建议。")
        put("Share a JSON backup anytime. Cloud uploads use your Support ID as the document key — keep that ID safe to restore after reinstalling. Restore from cloud or local file is offered during onboarding (import also in Developer tools).", "随时分享或导出 JSON 备份。云端备份使用你的支持 ID 作为文档凭证 — 请妥善保管此 ID 以便重装后恢复。初次使用引导或开发者工具中均支持导入恢复。")
        put("Share this if you report a bug, and keep it safe for cloud restore.", "反馈问题时可提供此 ID，重装恢复云端备份时也需要它，请妥善保存。")
        put("(generating…)", "(正在生成…)")
        put("Local backups", "本地备份")
        put("Share a JSON backup (Drive, Files, email, etc.).", "分享或导出 JSON 备份（网盘、文件、邮件等）。")
        put("Cloud backup is not available in this build.", "当前编译版本不支持云端备份。")
        put("Cloud backup uploads are disabled in debug builds. You can still pull an existing backup during onboarding with a Support ID. Use a release build to enable uploads.", "调试版本已禁用云端备份上传功能。你仍可在新手引导中使用支持 ID 拉取已有备份。上传需使用正式版构建。")
        put("Enable cloud backup", "启用云端备份")
        put("Unavailable in debug builds.", "调试版不可用。")
        put("Auto-upload on startup", "启动时自动上传备份")
        put("Auto-upload", "自动上传")
        put("Cloud backup off (debug)", "云端备份已关闭 (调试版)")
        put("Change cloud backup password", "更改云端备份密码")
        put("When on, you can upload manually or automatically after you log a meal or workout. Uploads use your Support ID as the cloud document key. Also turns on crash reports (turning crash reports off disables cloud backup).", "开启后，你可以在记录饮食或运动后手动或自动上传。上传使用你的支持 ID 作为凭证。此项需同时开启崩溃报告（关闭崩溃报告会自动停用云备份）。")
        put("When enabled, FitBuddy uploads on app start if the last upload was more than 12 hours ago. Manual Upload now always runs immediately.", "开启后，若距上次上传已超过 12 小时，FitBuddy 会在启动时自动上传。“立即上传”则随时立即执行。")
        put("Cloud backup off", "云端备份已关闭")
        put("Enabled — no upload yet", "已启用 — 暂无上传记录")
        put("Check for updates automatically", "自动检查更新")
        put("Automatic updates", "自动检查更新")
        put("Looks for a newer build on f-droid.org shortly after startup.", "启动后不久将在 f-droid.org 检查是否有新版本。")
        put("Looks for a newer GitHub release shortly after startup.", "启动后不久将在 GitHub 检查是否有新版本发布。")
        put("Checking...", "正在检查…")
        put("Disable crash reports?", "是否停用崩溃报告？")
        put("Turning off crash reports will also disable cloud backup. You can turn either back on later in Settings.", "关闭崩溃报告的同时也会停用云端备份功能。你可以随时在设置中重新开启任意一项。")
        put("Disable both", "全部停用")
        put("Crash reports", "崩溃日志报告")
        put("Cloud backup is on — turning this off will also disable cloud backup. Anonymous stack traces help fix bugs. No meals, photos, names, or API keys. Privacy & deletion: anantdark.github.io/FitBuddy/privacy.html", "云端备份已开启 — 关闭此项将同时停用云端备份。匿名错误堆栈有助于修复系统崩溃。绝不收集就餐、照片、姓名或 API 密钥。隐私条款：anantdark.github.io/FitBuddy/privacy.html")
        put("Anonymous stack traces help fix bugs. No meals, photos, names, or API keys. Your Support ID (under Backup) identifies reports. Turn off anytime. Enabling cloud backup turns this on automatically. Privacy & deletion: anantdark.github.io/FitBuddy/privacy.html", "匿名错误堆栈有助于排查崩溃问题。绝不收集就餐、照片、姓名或 API 密钥。使用备份中的支持 ID 标识报告。可随时关闭。开启云端备份将自动启用此项。隐私条款：anantdark.github.io/FitBuddy/privacy.html")
        put("Diagnostic log", "诊断日志")
        put("Captures AI connection steps (provider, model, HTTP status) so you can share them when something fails. No meals, photos, or API keys. Start logging, reproduce the issue, then stop & export.", "记录 AI 连接过程（服务商、模型、HTTP 状态），以便在调用失败时排查问题。绝不记录饮食、照片或 API 密钥。开启记录后重现问题，再点击停止并导出。")
        put("Off until you start logging", "未开启日志记录")
        put("Stop logging & export", "停止记录并导出")
        put("Start logging", "开始记录诊断日志")
        put("About FitBuddy", "关于 FitBuddy")
        put("AI-powered health tracker with region-aware diets. Log meals and workouts via photo or loose text; the AI estimates calories and macros.", "结合地区饮食习惯的 AI 智能健康追踪器。通过照片或日常语言记录饮食与运动，由 AI 智能估算热量与三大营养素。")
        put("Package", "应用包名")
        put("Created by", "创作者")
        put("Docs", "官方文档")
        put("Privacy & data deletion", "隐私条款与数据删除")
        put("Debug tools. Tap Package 31 times again to hide this card.", "开发者调试工具。再次连续点击包名 31 次可隐藏此卡片。")
        put("Backup & identity", "备份与凭据")
        put("Local import and Support ID. Export is under Backup → Local backups.", "本地文件导入与支持 ID。导出备份请前往“备份 → 本地备份”。")
        put("Import backup JSON", "导入 JSON 备份")
        put("Generate new Support ID", "生成新支持 ID")
        put("New ID for crash reports and future cloud uploads. Existing cloud docs stay under the old ID.", "生成新 ID 用于崩溃报告和未来的云备份。已上传的历史云备份仍保留在旧 ID 下。")
        put("Cloud (Atlas)", "云数据库 (Atlas)")
        put("Database name", "数据库名称")
        put("Collection name", "集合 (Collection) 名称")
        put("Save Atlas db / collection", "保存 Atlas 数据库配置")
        put("Download & restore from cloud", "从云端下载并恢复")
        put("Debug builds restore from cloud only during onboarding (Support ID). Uploads stay off.", "调试版本仅支持在初次启动引导页输入支持 ID 恢复云备份，上传功能已停用。")
        put("Create new cloud chunk", "创建新云端数据分卷")
        put("Freezes tip log rows into the active chunk and appends a new tip (same as size-based rollover). Needs at least one tip log row.", "将当前日志行冻结至活动分卷并追加新标记（类似于按大小轮转）。需要至少一条日志记录。")
        put("AI debugging", "AI 调试选项")
        put("Toggles and tools for the live AI path. Does not change ranking rules.", "用于实机 AI 链路的调试开关与工具，不影响排序规则。")
        put("Force offline AI simulator", "强制使用离线 AI 模拟器")
        put("Force offline AI", "强制离线 AI")
        put("Bypass live API and use the bundled text simulator (photos still need a real provider).", "绕过在线 API 直接使用内置离线文本模拟器（照片识别仍需真实服务商）。")
        put("Show raw AI JSON", "显示 AI 原始 JSON")
        put("Raw AI JSON", "AI 原始 JSON")
        put("After each analysis, show the last raw JSON response.", "每次识别或分析后，展示最近一次返回的原始 JSON 响应。")
        put("Strict clarification", "严格追问模式")
        put("Experimental: prefer asking for portions when counts are ambiguous.", "实验性功能：当数量或份量模糊时，优先向用户追问确认。")
        put("Verbose HTTP logging", "详细 HTTP 网络日志")
        put("Verbose HTTP", "详细 HTTP 日志")
        put("Log full OkHttp request/response bodies (including on release builds). May include API keys in logcat — keep off unless debugging.", "在 Logcat 中输出完整的 OkHttp 请求与响应体（包括正式版）。可能在日志中包含 API 密钥 — 非调试场景请保持关闭。")
        put("Clear model cooldowns", "重置模型冷却时间")
        put("Apply built-in model defaults", "恢复内置默认模型")
        put("Resets OpenRouter / Gemini / Ollama photo and text to app defaults (not OpenAI). Save also clears cooldowns for the active provider’s picks.", "将 OpenRouter、Gemini、Ollama 的拍照和文本模型重置为应用推荐默认值（不含 OpenAI）。保存时也会清除当前选定模型的冷却。")
        put("UI preview", "UI 预览与动效")
        put("Preview themes and loading animations without waiting on AI.", "无需等待 AI 响应即可预览各种主题风格与加载等待动效。")
        put("Experimental surface/token previews for local QA.", "供本地测试验证的实验性面板与样式预览。")
        put("Keep animations visible", "持续显示动效")
        put("Always show the analyzing banner and insight wait animations.", "始终常驻展示识别横幅动画与趋势洞察等待动效。")
        put("Testing", "测试与功能自检")
        put("One-shot checks for update UI, donations, notifications, crash reporting, and onboarding.", "快速单次自检更新弹窗、赞助提醒、通知推送、崩溃上报与引导流程。")
        put("Show test update prompt", "弹出测试更新弹窗")
        put("Fake release dialog for backup-before-update. Download fails on purpose.", "模拟“更新前备份”弹窗交互逻辑，下载故意模拟失败以便排查。")
        put("Show donate reminder notification", "弹出测试赞助通知")
        put("Show donate reminder dialog", "弹出测试赞助对话框")
        put("Show new-donors thank-you", "展示新支持者感谢页面")
        put("Show donors", "展示支持者名单")
        put("Opens the supporters gallery with demo donor cards.", "打开展示赞助者演示卡片的支持者画廊。")
        put("Open donation dialog", "打开赞助页面")
        put("Clear donor last-seen date", "清除支持者已读标记")
        put("Set donor last-seen to latest", "将支持者已读标记设为最新")
        put("Set donor last-seen to 2020-01-01", "将支持者已读标记重置为 2020-01-01")
        put("Clear / old date → thank-you can show again. Latest → mark all current donations seen.", "清除或设为旧日期 → 感谢弹窗可重新展示。设为最新 → 标记全部已有支持者已读。")
        put("Reset donate reminder timers", "重置赞助提醒计时器")
        put("Donate test actions bypass the 3–8 day schedule. Demo thank-you does not change last-seen donors.", "赞助测试操作会跳过 3-8 天的冷却时间。演示感谢不会修改真实的支持者已读标记。")
        put("Preview onboarding flow", "预览初次安装新手引导")
        put("Opens the full first-run UI as a throwaway preview. Does not change profile, AI keys, region, or crash reporting. Force-stop the app to return home, or finish the preview — nothing is saved.", "完整打开首次启动向导进行一次性预览体验。不会更改已有资料、AI 密钥、地区或崩溃报告设置。完成预览或强退后均不保存任何更改。")
        put("Send test notification", "发送测试通知")
        put("FitBuddy Sentry test crash", "FitBuddy 崩溃收集测试异常")
        put("Force test crash", "触发一次测试崩溃")
        put("Restore from cloud?", "是否从云端恢复？")
        put("Enter the Support ID of the backup to restore. This replaces all local FitBuddy data (same as file import).", "输入欲恢复备份的支持 ID。这会替换本地现有的全部 FitBuddy 数据（同本地文件导入）。")
        put("Restore", "恢复")
        put("Update available", "发现新版本")
        put("What's new", "更新内容")
        put("View on f-droid.org", "前往 F-Droid 查看")
        put("View on GitHub", "前往 GitHub 查看")
        put("Back up your data to the cloud before updating.", "建议在更新前将数据同步备份至云端。")
        put("Export a local backup before updating.", "建议在更新前导出本地文件备份。")
        put(" Then opens F-Droid to install the update.", "随后将打开 F-Droid 安装新版本更新。")
        put("Export backup & update", "导出备份并更新")
        put("Skip backup & update", "跳过备份并更新")
        put("Select a model", "选择模型")
        put("Enter your API key first", "请先输入你的 API 密钥")
        put("Enter your Ollama Cloud API key first", "请先输入你的 Ollama Cloud API 密钥")
        put("Enter your Ollama server URL first", "请先输入你的 Ollama 服务器地址")
        put("Enter your custom base URL first", "请先输入你的自定义 Base URL")
        put("Couldn't load models", "无法加载模型列表")
        put("Model id", "模型 ID")
        put("Enter your API key to load models", "输入 API 密钥以加载模型列表")
        put("Enter your Ollama Cloud API key to load models", "输入 Ollama Cloud 密钥以加载模型列表")
        put("Enter your Ollama server URL to load models", "输入 Ollama 地址以加载模型列表")
        put("Pick an image-capable model", "请选择支持图像理解的视觉模型")
        put("Reload models", "重新加载模型")
        put("AI offline (simulator)", "AI 处于离线状态 (模拟器)")
        put("Add a key/server below to enable live analysis", "在下方添加密钥或服务器以开启实时智能分析")
        put("Collapse", "收起")
        put("Expand", "展开")
        put("Supporter exclusive", "支持者专属特权")
        put("Off (spinner)", "关闭（极简转圈）")
        put("Paste multiple keys separated by commas or new lines. Keys are masked and can't be copied after adding.", "可粘贴多个密钥（用逗号或换行分隔）。添加后密钥将脱敏显示且无法直接复制。")
        put("Remove key", "移除密钥")
        put("Add key (paste several)", "添加密钥（支持批量粘贴）")
        put("Password must be at least 8 characters", "密码长度不能少于 8 个字符")
        put("Password must be 128 characters or fewer", "密码长度不能超过 128 个字符")
        put("Passwords do not match", "两次输入的密码不一致")
        put("Your backup is encrypted on this device before it's uploaded — the cloud only ever stores encrypted data.", "备份在离开手机前已在本地完成端到端加密 — 云端只存储不可解密的密文数据。")
        put("Cloud backups are keyed by your Support ID. Copy it now and store it safely — you'll need it to restore after reinstalling.", "云端备份与你的支持 ID 唯一绑定。请立即复制并妥善保管 — 重装后恢复数据全靠它。")
        put("Optionally set a password. Leave blank to use default (Support ID) protection. To request remote deletion later, email fitbuddy31@proton.me with your Support ID (see Privacy in About).", "可选设置自定义密码。留空则使用默认（支持 ID）保护。如需后续请求云端删除数据，请发送邮件至 fitbuddy31@proton.me 并附带支持 ID。")
        put("Password (optional)", "备份密码 (选填)")
        put("Confirm password", "确认密码")
        put("Copy ID & enable", "复制 ID 并开启")
        put("Set a new password to protect your cloud backup. Leave blank to use default (Support ID) protection.", "设置用于保护云端备份的新密码。留空则恢复默认（支持 ID）保护。")
        put("New password", "新密码")

        // --- Exercise Picker & Workouts ---
        put("Choose exercise", "选择动作")
        put("Search or describe a workout", "搜索动作或用一句话描述锻炼")
        put("Clear search", "清空搜索")
        put("Inferring…", "正在 AI 推理…")
        put("Infer with AI", "AI 智能解析")
        put("Connect an AI provider in Settings to infer from text.", "在设置中连接 AI 服务商后即可从文本智能解析动作。")
        put("Favourites", "我的收藏")
        put("Recent", "最近使用")
        put("Most used", "最常用")
        put("All exercises", "全部动作")
        put("Browse all", "浏览全部")
        put("No exercises match those filters.", "没有符合这些筛选条件的动作。")
        put("This removes it from your exercise picker. Already-logged workouts keep their history.", "这会从你的动作选择列表中删除该动作。已记录的运动历史仍然保留。")
        put("Back to list", "返回列表")
        put("Delete custom exercise", "删除自定义动作")
        put("Remove favourite", "取消收藏")
        put("Add favourite", "加入收藏")
        put("How to", "动作要领")
        put("Add to workout", "加入训练")
        put("Use GIF", "使用该动图")
        put("No thanks", "不用了")
        put("Auto-calculated for calorie burn (cardio time + ~3 min per strength set).", "根据热量消耗自动估算时长（有氧时间 + 力量训练每组约 3 分钟）。")
        put("No exercises added yet. Tap below to browse the exercise catalog (with demo GIFs), filter by body part or equipment, or add with AI.", "尚未添加训练动作。轻触下方浏览动作库（含动作示范动图）、按肌群/器械筛选，或使用 AI 智能添加。")
        put("Tap to edit", "轻触以编辑")
        put("Time (sec)", "用时 (秒)")
        put("Hold (sec)", "静力保持 (秒)")
        put("Distance (km, optional)", "距离 (公里，选填)")
        put("Weight (kg, optional)", "负重 (公斤，选填)")

        // --- Reminders & Donation Copy ---
        put("Small log, big clarity", "一笔小记录，健康大清晰")
        put("Got a minute? Log today’s food or a workout so FitBuddy can keep your day honest.", "有空吗？记一笔今天的饮食或运动，让 FitBuddy 帮你真实记录每一天。")
        put("Your future self says thanks", "未来的自己会感谢今天的坚持")
        put("Quick check-in: add what you ate or how you moved — consistency beats perfection.", "随手打个卡：记下吃了什么或做了什么运动 — 贵在坚持，重于完美。")
        put("Thali tracked is progress", "一粥一饭，皆是进步")
        put("Roti, dal, or a walk — log a meal or activity now and stay on top of your goals.", "米饭、家常菜或散步 — 随时记一笔饮食或运动，让目标稳步达成。")
        put("Don’t leave the day blank", "别让今天留白")
        put("Even one entry helps. Log food or exercise before the evening slips away.", "哪怕只记一笔也很有帮助。在夜晚溜走前，随手记下饮食或运动吧。")
        put("Fuel & movement matter", "摄入与消耗同等重要")
        put("Snap a plate or note a workout — FitBuddy is ready when you are.", "拍张餐盘或记录训练 — FitBuddy 随时为你守候。")
        put("Steady beats perfect", "细水长流胜过偶尔完美")
        put("Missed a meal earlier? Log what you can now — food or activity, both count.", "之前漏记了？现在补上也不迟 — 饮食或运动，点滴皆算数。")
        put("Evening check-in", "晚间小结")
        put("How did today go? Log a meal or some movement and keep your streak of awareness going.", "今天过得怎么样？记下一餐或一点运动，延续你的健康好习惯。")
        put("One tap toward your goal", "距离目标，只差轻触一点")
        put("Open FitBuddy and log food or activity — tiny habits compound.", "打开 FitBuddy 记下饮食或运动 — 微小的习惯终将积少成多。")
        put("Kitchen & gym, same story", "厨房与健身房，同样精彩")
        put("Whether it’s dinner or a session, capture it so your macros and burn stay accurate.", "无论是丰盛晚餐还是挥汗训练，随手记下让营养与消耗更加精准。")
        put("You’re building the habit", "好习惯正在养成中")
        put("Log today’s meals or workouts. Future-you will love the clearer dashboard.", "记录今天的饮食与训练，未来的你会爱上这张一目了然的数据看板。")
        put("Progress loves receipts", "点滴进步，皆有迹可循")
        put("Got chai and a snack? Or a walk? Log food or activity — FitBuddy’s listening.", "喝了下午茶吃点心，还是去散了步？随手记一笔 — FitBuddy 随时倾听。")
        put("Keep the chain going", "保持你的健康打卡链")
        put("A quick food or exercise log keeps your Progress chart meaningful. Tap to add one.", "快速记一笔饮食或运动，让趋势图表更有意义。轻触即可添加。")
        put("Honesty over guessing", "真实记录，胜过盲目猜测")
        put("Don’t estimate tomorrow — log what you ate or did today while it’s fresh.", "别等到明天再靠记忆去猜 — 趁着记忆犹新，记下今天的饮食与运动。")
        put("Your body keeps score", "身体不会说谎")
        put("Help FitBuddy keep up: log a meal or an activity in under a minute.", "不到一分钟，记下一餐或一项活动，让 FitBuddy 紧跟你的身体节律。")
        put("Tonight’s nudge", "今晚的小提醒")
        put("Before you wind down, jot a meal or workout. Small logs → smarter insights.", "在准备休息前，随手记下一餐或训练。积累微小记录，解锁更懂你的洞察。")
        put("Still time to show up", "今天还有时间交出一份答卷")
        put("Log food or movement now — every entry makes your targets more useful.", "现在就记下饮食或运动吧 — 每一笔记录都会让你的目标更有参考价值。")
        put("Will pay next week", "下周一定支持")
        put("Not today", "今天先不了")
        put("I'm broke", "钱包告急")
        put("No thanks", "不用了，谢谢")
        put("I don't have money", "囊中羞涩")
        put("Ask me after payday", "发工资后再来问我")
        put("My wallet is on a diet", "钱包正在节食")
        put("Maybe after I hit my protein goal", "等我蛋白质吃够了再说")
        put("Rain check", "下次一定")
        put("Guilt trip declined", "拒绝道德绑架")
        put("Later, macros first", "稍后再说，先算营养素")
        put("Skipping this week", "这周先跳过")
        put("Already paid", "已经赞助过了")
        put("You want more?", "还想要更多？")
        put("I'm on the list (promise)", "我已经在名单上了（保证）")
        put("Paid, add me", "已赞助，快加我进榜")
        put("Check your inbox", "快去查收邮件")
        put("Done and dusted", "搞定收工")
        put("Already tipped", "早就给过小费啦")
        put("Receipt's in the mail", "赞助凭证已发邮箱")
        put("I'll pay", "我来支持")
        put("Let's pay", "赞助支持")
        put("Open the tip jar", "打开赞助打赏箱")
        put("Buy the dev a chai", "请开发者喝杯咖啡")
        put("Tip time", "支持一下")
        put("Fuel the free app", "助力免费开源项目")
        put("Chip in", "慷慨解囊")
        put("Keep FitBuddy free?", "支持 FitBuddy 保持完全免费？")
        put("A small tip goes a long way. Open the app this evening if you can chip in.", "哪怕一杯咖啡的小小支持也能走得很远。如果你愿意赞助，欢迎今晚打开应用支持一下。")
        put("Dev fuel check", "开发者电量监测")
        put("FitBuddy stays free and open source with optional support. No pressure, just a nudge.", "FitBuddy 依靠用户的自愿赞助保持免费且开源。毫无压力，只是温馨提醒。")
        put("Tip jar whisper", "打赏箱的轻声问候")
        put("If FitBuddy helped this week, consider a small donation. We'll ask again tonight in-app.", "如果 FitBuddy 这周帮到了你，不妨考虑小额赞助。今晚我们会在应用内再次提醒。")
        put("Chai money Tuesday", "周二请杯饮品")
        put("Optional support keeps features coming. Open FitBuddy later to tip or snooze.", "自愿支持让新功能源源不断。稍后打开 FitBuddy 可赞助或推迟提醒。")
        put("Still free. Still yours.", "依然免费，依然为你守候。")
        put("Donations are optional. If you're able, tonight's a good time to say thanks.", "赞助全凭自愿。力所能及之时，今晚正是表达心意的好时机。")
        put("Support FitBuddy?", "支持 FitBuddy？")
        put("FitBuddy is free and open source. Optional tips keep the chai (and the features) flowing. No guilt, just an occasional nudge.", "FitBuddy 完全免费且开源。自愿打赏能让开发者保持激情、新功能不断更新。毫无心理负担，仅是偶尔的小问候。")
        put("Get on the donor list", "加入支持者光荣榜")
        put("Email me your name and Support ID so I can add you. Reminders stop once your ID is on the list.", "通过邮件将你的名字和支持 ID 发送给我，我将把你加入支持者名单。录入名单后将永久停止赞助提醒。")
        put("Email developer", "给开发者发送邮件")
        put("FitBuddy Support ID", "FitBuddy 支持 ID")
        put("Copy ID & close", "复制 ID 并关闭")
        put("Thanks to our newest supporter", "感谢我们最新的支持者")
        put("Thanks to our newest supporters", "感谢我们最新的各位支持者")
        put("This person helped keep FitBuddy free and open. Take a moment to celebrate them.", "这位朋友为 FitBuddy 保持免费与开源贡献了力量，让我们向他致以谢意！")
        put("These folks helped keep FitBuddy free and open. Take a moment to celebrate them.", "这些朋友为 FitBuddy 保持免费与开源贡献了力量，让我们向他们致以最真诚的谢意！")
        put("Cheers", "举杯致敬")
        put("Supporters", "支持者光荣榜")
        put("No public supporters yet. Be the first — tip from the heart button.", "暂无公开支持者。轻触心形赞助按钮，成为第一位上榜者吧！")
        put("FitBuddy supporter", "FitBuddy 支持者")
        put("FitBuddy supporters", "FitBuddy 支持者群像")
        put("Tap a row to open their supporter card.", "轻触任意一行打开该支持者的专属卡片。")
        put("Tap a row to open a supporter card. Profiles live on the flip side.", "轻触任意一行打开专属卡片，背面包含支持者寄语与主页。")
        put("Tap for supporter card", "轻触查看支持者卡片")
        put("Demo donor data", "演示支持者数据")
        put("Preview of named donors (and hash-only rows). Thank-you skips hash-only. Tap a row for the trading card.", "展示具名支持者（及仅有哈希的条目）的卡片预览。感谢弹窗会自动跳过匿名哈希条目。轻触任意行查看卡片。")
        put("Where are you?", "你所在的地区")
        put("India · UPI or card", "印度 · UPI 或银行卡")
        put("International · GitHub Sponsors", "全球及国际 · GitHub 赞助")
        put("Donate from India", "印度境内赞助")
        put("Donate internationally", "国际赞助 (GitHub Sponsors)")
        put("Say hi", "打个招呼")
        put("Copy email", "复制邮箱地址")
        put("Show donors", "查看支持者名单")
        put("Payment method", "赞助方式")
        put("International payment", "国际支付")
        put("Sponsor on GitHub", "在 GitHub 上赞助")
        put("GitHub opens only when you tap. FitBuddy does not store payment details.", "仅在你轻触时打开 GitHub 页面。FitBuddy 绝不存储任何支付敏感信息。")
        put("FitBuddy developer email", "FitBuddy 开发者邮箱")
        put("Email copied", "邮箱地址已复制")
        put("Couldn't access the clipboard", "无法访问系统剪贴板")
        put("Couldn't open GitHub Sponsors", "无法打开 GitHub 赞助页面")
        put("OG SUPPORTER", "元老支持者")
        put("GENEROUS", "慷慨支持者")
        put("LEGENDARY", "传奇支持者")
        put("GODLIKE", "神级支持者")
        put("SUPPORTER", "支持者")
        put("OG SUPPORTER CARD", "元老支持者卡")
        put("GENEROUS CARD", "慷慨支持者卡")
        put("LEGENDARY CARD", "传奇支持者卡")
        put("GODLIKE CARD", "神级支持者卡")
        put("SUPPORTER CARD", "支持者卡")
        put("Tap card to flip", "轻触卡片翻转")
        put("RANK CRESTS", "段位徽章")

        // --- Analytics & Custom Charts ---
        put("Previous 30 days", "前 30 天")
        put("Next 30 days", "后 30 天")
        put("Generate an insight from your charts, then ask follow-up questions in a dedicated chat.", "基于你的健康图表生成深度洞察，并在专属对话中随时追问健康细节。")
        put("Connect an AI provider in Settings to enable insights.", "在设置中连接 AI 服务商后即可启用趋势洞察功能。")
        put("Progress insight", "趋势洞察")
        put("Continue chat", "继续对话")
        put("Great alignment with your goal", "与健康目标高度吻合")
        put("Making progress, room to improve", "持续进步中，仍有提升空间")
        put("Trend needs attention", "趋势需要多加关注")
        put("Target (varies)", "目标（变动）")
        put("No log data available yet", "暂无记录数据")
        put("No readings yet", "暂无测量数据")
        put("First reading in range", "统计周期内首次测量")
        put("No calendar days to show", "暂无可显示的日历天数")
        put("Calories burned contribution calendar", "卡路里消耗贡献热力图")
        put("No day selected", "未选中任何日期")
        put("No heatmap day selected", "未选择热力图日期")
        put("Swipe the calendar and tap a square for details", "滑动日历并轻触方块以查看消耗详情")
        put("Less", "较少")
        put("More", "较多")

        // --- Food Review, Meals & Log Hub ---
        put("Wrong item? Rename it (e.g. \"pineapple cake\") and tap ✨ to let AI recompute calories, macros and ingredients.", "食物名称不对？重命名（如“凤梨酥”），然后轻触 ✨ 让 AI 重新计算热量、营养素和配料。")
        put("Ask for portion", "询问份量")
        put("adjust weight or edit macros", "调整重量或编辑营养素")
        put("Total for this meal", "本餐总计")
        put("Macros for this ingredient (from packet label)", "该配料营养成分（来自包装标签）")
        put("Weight (g / unit)", "重量 (克/单位)")
        put("Enter values for ONE unit; quantity multiplies them.", "输入单份/单单位的数值；数量将自动相乘。")
        put("Calories per unit (kcal)", "单份热量 (kcal)")
        put("Meal", "餐次")
        put("Review changes", "核对更改")
        put("Review & save as preset", "核对并保存为预设")
        put("e.g. Breakfast", "例如：丰盛早餐")
        put("Foods in this meal", "本餐包含的食物")
        put("Each food has its own ingredients — like exercises in a workout.", "每种食物包含各自的成分配料 — 类似于一次训练中的各项动作。")
        put("Add saved foods (presets), scan packaged items, create a new food, or enter macros manually.", "添加常用预设食物、扫描包装条码、创建新食物或手动输入营养素。")
        put("Scan", "扫码")
        put("Create new food", "创建新食物")
        put("Add food manually", "手动添加食物")
        put("Edit ingredients", "编辑配料成分")
        put("Calories (1 serving)", "热量 (单份)")
        put("Add a food to this meal. Recently used foods stay on top.", "为本餐添加食物。最近常用的食物优先展示在顶部。")
        put("Tap a food to log it to the day you're viewing. Recently used foods stay on top.", "轻触食物将其直接记录到当前查看的日期。最近常用的食物置顶。")
        put("Edit or delete foods you scan or save as preset. Lists sort by last used.", "编辑或删除你扫描过或保存为预设的食物。列表按最近使用时间排序。")
        put("No saved foods yet. Create one above, scan a barcode from Log, or save a food after AI review.", "暂无常用食物。可在上方创建、在记录页扫条码添加，或在 AI 识别后收藏。")
        put("Pick what you're tracking — food options use AI when configured.", "选择你要追踪的内容 — 食物记录在配置后支持 AI 智能识别。")
        put("Yesterday's Log", "昨日记录")
        put("Previous week", "上一周")
        put("Next week", "下一周")
        put("Previous day", "上一天")
        put("Next day", "下一天")

        // --- Region Selection & Crash Reporting ---
        put("You've already sent a region request from this install.", "本次安装已提交过地区支持请求。")
        put("This sends exactly the following, anonymously:", "这将完全匿名发送以下必要信息：")
        put("Event", "事件")
        put("Region request", "地区支持请求")
        put("Requested region", "请求支持的地区")
        put("Current / selected region", "当前所选地区")
        put("Anonymous Support ID", "匿名支持 ID")
        put("(none yet)", "（暂无）")
        put("App version", "应用版本")
        put("Sending…", "正在发送…")
        put("Request sent — thanks!", "请求已发送，感谢支持！")
        put("Crash reporting isn't available in this build.", "此版本不支持崩溃日志上报。")
        put("Enable crash reporting to send a region request.", "请在设置中开启崩溃报告后再发送地区请求。")
        put("Enter a region name first.", "请先输入地区名称。")
        put("Couldn't send request. Check your connection and try again.", "无法发送请求，请检查网络连接后重试。")
        put("Encrypted backup to FitBuddy’s cloud. Off by default — change anytime in Settings.", "FitBuddy 端到端加密云端备份。默认关闭 — 可随时在设置中修改。")
        put("Crash reports will also be enabled.", "崩溃日志报告也将一并开启。")
        put("Anonymous reports help fix bugs. Off by default — change anytime in Settings.", "匿名错误报告有助于修复崩溃闪退。默认关闭 — 可随时在设置中修改。")

        // --- Toasts, Alerts, Logs & ViewModel ---
        put("You're on the latest version", "当前已是最新版本")
        put("Download started in your browser — install the APK when it finishes", "浏览器已开始下载 — 下载完成后请安装 APK")
        put("Could not open share sheet", "无法调出系统分享面板")
        put("Share FitBuddy backup", "分享 FitBuddy 备份")
        put("Backup timestamp missing or too old; update cancelled", "备份时间戳缺失或过旧，更新已取消")
        put("Choose an app to update", "选择打开更新的应用")
        put("Opened update on the website", "已在浏览器中打开更新页面")
        put("Donor last-seen cleared", "已清除支持者已读标记")
        put("No donation dates found", "未找到赞助日期记录")
        put("Donate reminder timers reset", "赞助提醒计时器已重置")
        put("Onboarding preview — no data will be saved", "新手引导预览模式 — 不会保存任何数据")
        put("Onboarding preview closed — no data changed", "已退出新手引导预览 — 数据未做任何更改")
        put("Crash reports enabled", "已启用崩溃报告")
        put("Crash reports and cloud backup disabled", "已停用崩溃报告和云端备份")
        put("Crash reports disabled", "已停用崩溃报告")
        put("Diagnostic logging on — reproduce the issue, then stop & export", "诊断日志已开启 — 请重现问题后停止并导出")
        put("Diagnostic logging off", "诊断日志已关闭")
        put("Diagnostic logging stopped", "诊断日志已停止")
        put("Share diagnostic log", "分享诊断日志")
        put("Could not load models", "无法加载模型列表")
        put("Couldn't update food", "更新食物失败")
        put("Couldn't look up product", "查询条码商品失败")
        put("Check your connection and try again.", "请检查网络连接并重试。")
        put("Couldn't save food", "保存食物失败")
        put("Couldn't log food", "记录食物失败")
        put("Couldn't recognise that exercise", "未能识别该动作")
        put("Couldn't infer exercises", "AI 解析动作失败")
        put("AI request failed", "AI 请求失败")
        put("Couldn't suggest a name", "未能建议名称")
        put("Reading saved", "测量记录已保存")
        put("Reading removed", "测量记录已移除")
        put("Couldn't log this workout", "记录本次运动失败")
        put("Couldn't clone this workout", "复制本次运动失败")
        put("Couldn't update this workout", "更新本次运动失败")
        put("Couldn't calculate targets", "计算健康目标失败")
        put("Targets applied", "已应用健康目标")
        put("Couldn't generate insight", "生成洞察失败")
        put("Couldn't get a reply", "未能收到回复")
        put("Cloud backup uploads are disabled in debug builds", "调试版本已停用云端备份上传功能")
        put("Log a meal or workout before uploading a cloud backup", "在上传云端备份前，请至少记录一餐饮食或一次运动")
        put("In debug builds, restore from cloud only during onboarding (enter a Support ID).", "调试版本仅支持在引导页输入支持 ID 恢复云备份。")
        put("Cloud backup reset to default (Support ID) protection", "云备份已重置为默认（支持 ID）保护")
        put("Cloud backup is disabled in debug builds", "调试版本已停用云端备份")
        put("Cloud backup enabled with default (Support ID) protection", "云备份已开启并使用默认（支持 ID）保护")
        put("Cloud backup enabled and encrypted", "云备份已开启并启用密码加密")
        put("Preview mode — restore is disabled", "预览模式 — 恢复功能已禁用")
        put("Couldn't restore from cloud", "无法从云端恢复备份")
        put("Couldn't restore from file", "无法从本地文件恢复备份")
        put("New Support ID generated — copy it from Backup settings", "已生成全新支持 ID — 请在备份设置中复制保管")
        put("Couldn't save AI settings", "保存 AI 设置失败")
        put("Item not identified", "未能识别该物品")
        put("Couldn't reach AI", "无法连接 AI 服务")
        put("That looks like an activity, not a food item.", "这看起来像是一项运动，而不是食物。")
        put("Preview mode — OpenRouter sign-in is disabled", "预览模式 — OpenRouter 登录已禁用")
        put("Couldn't start OpenRouter sign-in listener", "无法启动 OpenRouter 登录监听")
        put("OpenRouter sign-in was cancelled or incomplete", "OpenRouter 登录已取消或未完成")
        put("OpenRouter sign-in expired — try Connect again", "OpenRouter 登录已过期 — 请重新点击连接")
        put("Connected with OpenRouter", "已成功连接 OpenRouter")
        put("Couldn't connect OpenRouter", "连接 OpenRouter 失败")
        put("Preview mode — OpenRouter disconnect is disabled", "预览模式 — OpenRouter 断开已禁用")
        put("OpenRouter disconnected", "已断开 OpenRouter 连接")
        put("FitBuddy's automated health targets are for adults 18+", "FitBuddy 自动健康目标仅适用于 18 岁以上成年人")
        put("Enter a valid height between 100 and 250 cm", "请输入 100 到 250 cm 之间的有效身高")
        put("Enter a valid weight between 25 and 400 kg", "请输入 25 到 400 kg 之间的有效体重")
        put("Couldn't save your profile", "保存个人资料失败")
        put("Connect OpenRouter or enter an API key", "请连接 OpenRouter 或输入 API 密钥")
        put("Enter a Gemini API key", "请输入 Gemini API 密钥")
        put("Enter an Ollama Cloud API key", "请输入 Ollama Cloud API 密钥")
        put("Enter your custom server URL", "请输入自定义服务器地址")
        put("Enter an OpenAI API key", "请输入 OpenAI API 密钥")
        put("Complete your profile before saving body data", "保存身体数据前请先完善个人资料")
        put("Couldn't save body data", "保存身体数据失败")
        put("Enter valid daily targets", "请输入有效的每日目标")
        put("Complete your body profile before saving targets", "保存目标前请先完善身体档案")
        put("Couldn't save manual targets", "保存手动目标失败")
        put("No camera app available. Use Gallery instead.", "没有可用的相机应用，请改用相册选图。")
        put("Camera permission not allowed.", "未授予相机权限。")
        put("Choose an app to share the log", "选择用于分享日志的应用")
        put("No diagnostic log yet", "暂无诊断日志")
        put("Developer settings unlocked", "开发者设置已解锁")
        put("Developer settings hidden", "开发者设置已隐藏")
        put("Donate test notification sent", "已发送赞助测试通知")
        put("Couldn't send notification", "发送通知失败")
        put("Test notification sent", "已发送测试通知")
        put("Incorrect password — enter the password you set for this backup", "密码错误 — 请输入你为该备份设置的密码")
        put("Add to meal", "加入本餐")
        put("Log today", "记录到今日")
        put("Copied", "已复制")
        put("Something went wrong", "出了点问题")
        put("Replace all data?", "是否替换全部本地数据？")
        put("Importing this backup will replace your current profile, readings, logs, and custom foods/meals/exercises with the file's contents. Settings (including AI keys) are replaced when the backup includes them. This can't be undone.", "导入此备份将用文件内容覆盖当前全部资料、测量记录、饮食运动日志以及自定义食物/动作。若备份包含设置（包括 AI 密钥）也将一并覆盖。此操作无法撤销。")
        put("Incorrect password", "密码错误")
        put("Replace", "确认替换")
        put("Share backup", "分享备份")
        put("Optionally protect this backup with a password, then choose where to send it.", "可选设置密码保护该备份，随后选择发送目标。")
        put("Enter the password for this cloud backup.", "请输入该云端备份的密码。")
        put("Could not open download link", "无法打开下载链接")
        put("Install & add", "安装并添加")
        put("Keep scanning", "继续扫码")
        put("Describe it", "描述内容")
        put("Food or activity", "饮食或运动")
        put("Quick question", "追问确认")
        put("Your answer", "你的回答")
        put("Good night", "夜深了")
        put("Good morning", "早上好")
        put("Good afternoon", "下午好")
        put("Good evening", "晚上好")
        put("What’s your name?", "怎么称呼你？")
        put("We’ll use your first name in the dashboard greeting.", "我们将使用你的名字在首页向你打招呼。")
    }

    private val loggedFoodRegex = Regex("""^Logged (.+) · (\d+) kcal$""")
    private val updatedFoodRegex = Regex("""^Updated (.+) · (\d+) kcal$""")
    private val loggedWorkoutRegex = Regex("""^Logged (.+) · (\d+) kcal burned$""")
    private val updatedWorkoutRegex = Regex("""^Updated (.+) · (\d+) kcal burned$""")
    private val removedItemRegex = Regex("""^Removed (.+)$""")
    private val savedToFoodLibraryRegex = Regex("""^Saved "(.+)" to food library$""")
    private val savedAsMealPresetRegex = Regex("""^Saved "(.+)" as meal preset$""")
    private val importedRecordsRegex = Regex("""^Imported (\d+) records$""")
    private val restoredCloudRegex = Regex("""^Restored (\d+) records from cloud backup$""")
    private val uploadedCloudRegex = Regex("""^Uploaded (\d+) records to cloud backup$""")
    private val sharingRecordsRegex = Regex("""^Sharing (\d+) records…$""")
    private val greetingNameRegex = Regex("""^(Good morning|Good afternoon|Good evening),\s*(.+)$""")
    private val kcalRemainingRegex = Regex("""^(\d+)\s*kcal\s+left$""", RegexOption.IGNORE_CASE)
    private val kcalOverRegex = Regex("""^(\d+)\s*kcal\s+over$""", RegexOption.IGNORE_CASE)
    private val setsRepsRegex = Regex("""^(\d+)\s*sets\s*×\s*(\d+)\s*reps$""", RegexOption.IGNORE_CASE)
    private val minBurnedRegex = Regex("""^(\d+)\s*min\s*·\s*(\d+)\s*kcal$""")
    private val versionRegex = Regex("""^Version\s+(.+)$""", RegexOption.IGNORE_CASE)
    private val activeModelRegex = Regex("""^Active:\s*(.+)$""")
    private val stepOfRegex = Regex("""^Step\s+(\d+)\s+of\s+(\d+)$""", RegexOption.IGNORE_CASE)
    private val foodsInMealRegex = Regex("""^(\d+)\s+food\(s\)\s+in\s+this\s+meal$""")
    private val servingsWeightIngRegex = Regex("""^([0-9.]+)\s+serving\(s\)\s*·\s*(\d+)\s*g\s*·\s*(\d+)\s+ingredient\(s\)$""")
    private val avgBurnedPerDayRegex = Regex("""^Avg\s+(\d+)\s*kcal\s+burned\s*/\s*day\s*·\s*target\s+adjusted\s+to\s+(\d+)\s*kcal$""")
    private val photoModelDisplayRegex = Regex("""^Photo · (.+)$""")
    private val textModelDisplayRegex = Regex("""^Text · (.+)$""")
    private val installedBuildRegex = Regex("""^Installed (.+) \(build (.+)\)$""")
    private val buildUpdateRegex = Regex("""^Build (.+)  ·  you have (.+)$""")
    private val loggingLinesRegex = Regex("""^Logging… (\d+) lines — stop & export when done$""")
    private val linesFromSessionRegex = Regex("""^(\d+) lines from last session$""")
    private val tapsLeftRegex = Regex("""^(\d+) taps left$""")
    private val tapsToGoRegex = Regex("""^(\d+) taps to go$""")
    private val deleteCustomExerciseRegex = Regex("""^Delete "(.+)"\?$""")
    private val bestMatchGifRegex = Regex("""^Best match: "(.+)" \((.+)\)$""")
    private val useGifForRegex = Regex("""^Use this GIF for "(.+)"\?$""")
    private val estMinSessionRegex = Regex("""^Est\. (.+) min session$""")
    private val setsSecWeightRegex = Regex("""^(\d+) sets × (\d+)s(.*)$""")
    private val setsRepsWeightRegex = Regex("""^(\d+) sets × (\d+) reps(.*)$""")
    private val syncedLatestReadingRegex = Regex("""^Synced from the latest reading \((.+)\)$""")
    private val latestReadingDateRegex = Regex("""^Latest reading · (.+)$""")
    private val measurementDaysSpanRegex = Regex("""^(\d+) measurement days over (\d+) days$""")
    private val weightWeeklyChangeRegex = Regex("""^Weight (.+) kg · (.+)%/week$""")
    private val bodyFatPointsRegex = Regex("""^Body fat (.+) points$""")
    private val muscleMassKgRegex = Regex("""^Muscle (.+) kg$""")
    private val evidenceWorkoutsRegex = Regex("""^Evidence: (\d+) workout days, (\d+) sessions, about (\d+) min/week over (\d+) days\.$""")
    private val proposalSelectedActivityRegex = Regex("""^This proposal uses your selected (.+) level\.$""")
    private val proposalWorkoutActivityRegex = Regex("""^This proposal uses the workout-suggested (.+) level, not your selected (.+) level\. Choose Use current to recalculate before saving\.$""")
    private val savedFoodsCountRegex = Regex("""^(\d+) (?:saved food|saved foods) for meal building\.$""")
    private val noFoodsMatchRegex = Regex("""^No foods match "(.+)"\.$""")
    private val addedExercisesRegex = Regex("""^Added (\d+) exercise\(s\) from your description$""")
    private val loggedBurnedRegex = Regex("""^Logged (.+) · -(\d+) kcal$""")
    private val clonedBurnedRegex = Regex("""^Cloned (.+) · -(\d+) kcal$""")
    private val updatedBurnedRegex = Regex("""^Updated (.+) · -(\d+) kcal$""")
    private val deletedPresetRegex = Regex("""^Deleted meal preset (.+)$""")
    private val deletedFoodRegex = Regex("""^Deleted saved food (.+)$""")
    private val updatedFoodNameRegex = Regex("""^Updated "(.+)"$""")
    private val savedToFoodLibAnyRegex = Regex("""^Saved "(.+)" to (?:your food library|food library)$""")
    private val savedAsPresetAnyRegex = Regex("""^Saved "(.+)" as meal preset$""")
    private val exercisesCountRegex = Regex("""^(\d+) exercises$""")
    private val exercisesFilteredRegex = Regex("""^(\d+) of (\d+)$""")
    private val filtersCountRegex = Regex("""^(\d+) (?:filter|filters)$""")
    private val targetKgRegex = Regex("""^Target · (.+) kg$""")
    private val targetGenericRegex = Regex("""^Target · (.+)$""")
    private val aboveTargetKgRegex = Regex("""^Above target by (.+) kg$""")
    private val belowTargetKgRegex = Regex("""^Below target by (.+) kg$""")
    private val overByKcalRegex = Regex("""^Over by (\d+) kcal$""")
    private val underByKcalRegex = Regex("""^Under by (\d+) kcal$""")
    private val selectedDayBurnedRegex = Regex("""^Selected (.+), (\d+) calories burned$""")
    private val monthCaloriesBurnedRegex = Regex("""^(.+) calories burned$""")
    private val attemptOfRegex = Regex("""^Attempt (\d+) of (\d+)$""")
    private val incorrectPasswordAttemptRegex = Regex("""^Incorrect password \(attempt (\d+) of (\d+)\)$""")
    private val modelsAvailableRegex = Regex("""^(\d+) (.+) models available$""")
    private val noReachableModelsRegex = Regex("""^No reachable (.+) models; type an id above$""")
    private val loadingModelsRegex = Regex("""^Loading (.+) models…$""")
    private val noModelsFoundRegex = Regex("""^No (.+) models found$""")
    private val modelSwitchedRegex = Regex("""^(.+) model unavailable · switched to (.+)$""")
    private val lastUploadOkRegex = Regex("""^Last upload OK · (.+)$""")
    private val lastUploadFailedRegex = Regex("""^Last upload failed · (.+)$""")
    private val donorLastSeenRegex = Regex("""^Donor last-seen set to (.+)$""")
    private val openedUpdateInRegex = Regex("""^Opened update in (.+)$""")
    private val fieldRequiredRangeRegex = Regex("""^(.+) is required \((.+)\)$""")
    private val mustBeBetweenRegex = Regex("""^Must be between (.+) and (.+)$""")
    private val restingFactorDescRegex = Regex("""^([0-9.]+×) resting needs · (.+)$""")
    private val recognizingNameRegex = Regex("""^Recognising "(.+)"…$""")
    private val addCustomNameRegex = Regex("""^Add custom "(.+)"$""")
    private val viewExerciseNameRegex = Regex("""^View (.+)$""")
    private val removeExerciseNameRegex = Regex("""^Remove (.+)$""")
    private val editExerciseNameRegex = Regex("""^Edit (.+)$""")
    private val deleteFoodNamedRegex = Regex("""^Delete (.+)$""")

    private fun translateDynamic(text: String): String {
        greetingNameRegex.matchEntire(text)?.let { m ->
            val greet = translate(m.groupValues[1])
            return "$greet，${m.groupValues[2]}"
        }
        loggedFoodRegex.matchEntire(text)?.let { m ->
            return "已记录 ${m.groupValues[1]} · ${m.groupValues[2]} 千卡"
        }
        updatedFoodRegex.matchEntire(text)?.let { m ->
            return "已更新 ${m.groupValues[1]} · ${m.groupValues[2]} 千卡"
        }
        loggedWorkoutRegex.matchEntire(text)?.let { m ->
            return "已记录 ${m.groupValues[1]} · 消耗 ${m.groupValues[2]} 千卡"
        }
        updatedWorkoutRegex.matchEntire(text)?.let { m ->
            return "已更新 ${m.groupValues[1]} · 消耗 ${m.groupValues[2]} 千卡"
        }
        removedItemRegex.matchEntire(text)?.let { m ->
            return "已移除 ${m.groupValues[1]}"
        }
        savedToFoodLibraryRegex.matchEntire(text)?.let { m ->
            return "已将「${m.groupValues[1]}」保存到食物库"
        }
        savedAsMealPresetRegex.matchEntire(text)?.let { m ->
            return "已将「${m.groupValues[1]}」保存为套餐预设"
        }
        importedRecordsRegex.matchEntire(text)?.let { m ->
            return "已导入 ${m.groupValues[1]} 条记录"
        }
        restoredCloudRegex.matchEntire(text)?.let { m ->
            return "已从云端备份恢复 ${m.groupValues[1]} 条记录"
        }
        uploadedCloudRegex.matchEntire(text)?.let { m ->
            return "已上传 ${m.groupValues[1]} 条记录至云端备份"
        }
        sharingRecordsRegex.matchEntire(text)?.let { m ->
            return "正在分享 ${m.groupValues[1]} 条记录…"
        }
        kcalRemainingRegex.matchEntire(text)?.let { m ->
            return "剩余 ${m.groupValues[1]} kcal"
        }
        kcalOverRegex.matchEntire(text)?.let { m ->
            return "超出 ${m.groupValues[1]} kcal"
        }
        setsRepsRegex.matchEntire(text)?.let { m ->
            return "${m.groupValues[1]} 组 × ${m.groupValues[2]} 次"
        }
        minBurnedRegex.matchEntire(text)?.let { m ->
            return "${m.groupValues[1]} 分钟 · ${m.groupValues[2]} kcal"
        }
        versionRegex.matchEntire(text)?.let { m ->
            return "版本 ${m.groupValues[1]}"
        }
        activeModelRegex.matchEntire(text)?.let { m ->
            return "当前生效：${m.groupValues[1]}"
        }
        stepOfRegex.matchEntire(text)?.let { m ->
            return "第 ${m.groupValues[1]} / ${m.groupValues[2]} 步"
        }
        foodsInMealRegex.matchEntire(text)?.let { m ->
            return "本餐共包含 ${m.groupValues[1]} 项食物"
        }
        servingsWeightIngRegex.matchEntire(text)?.let { m ->
            return "${m.groupValues[1]} 份 · ${m.groupValues[2]} g · ${m.groupValues[3]} 种配料"
        }
        avgBurnedPerDayRegex.matchEntire(text)?.let { m ->
            return "日均消耗 ${m.groupValues[1]} kcal · 每日目标已动态调整为 ${m.groupValues[2]} kcal"
        }
        photoModelDisplayRegex.matchEntire(text)?.let { m ->
            return "拍照识别 · ${m.groupValues[1]}"
        }
        textModelDisplayRegex.matchEntire(text)?.let { m ->
            return "文本分析 · ${m.groupValues[1]}"
        }
        installedBuildRegex.matchEntire(text)?.let { m ->
            return "已安装 ${m.groupValues[1]}（版本代码 ${m.groupValues[2]}）"
        }
        buildUpdateRegex.matchEntire(text)?.let { m ->
            return "新版本 ${m.groupValues[1]} · 当前版本 ${m.groupValues[2]}"
        }
        loggingLinesRegex.matchEntire(text)?.let { m ->
            return "正在记录… 已捕获 ${m.groupValues[1]} 行，完成后停止并导出"
        }
        linesFromSessionRegex.matchEntire(text)?.let { m ->
            return "上次会话记录：${m.groupValues[1]} 行"
        }
        tapsLeftRegex.matchEntire(text)?.let { m ->
            return "还需点击 ${m.groupValues[1]} 次"
        }
        tapsToGoRegex.matchEntire(text)?.let { m ->
            return "还需点击 ${m.groupValues[1]} 次"
        }
        deleteCustomExerciseRegex.matchEntire(text)?.let { m ->
            return "确定删除“${m.groupValues[1]}”吗？"
        }
        bestMatchGifRegex.matchEntire(text)?.let { m ->
            return "最佳匹配：“${m.groupValues[1]}”（${m.groupValues[2]}）"
        }
        useGifForRegex.matchEntire(text)?.let { m ->
            return "是否为“${m.groupValues[1]}”使用此 GIF？"
        }
        estMinSessionRegex.matchEntire(text)?.let { m ->
            return "预计时长约 ${m.groupValues[1]} 分钟"
        }
        setsSecWeightRegex.matchEntire(text)?.let { m ->
            return "${m.groupValues[1]} 组 × ${m.groupValues[2]} 秒${m.groupValues[3]}"
        }
        setsRepsWeightRegex.matchEntire(text)?.let { m ->
            return "${m.groupValues[1]} 组 × ${m.groupValues[2]} 次${m.groupValues[3]}"
        }
        syncedLatestReadingRegex.matchEntire(text)?.let { m ->
            return "同步自最新测量（${m.groupValues[1]}）"
        }
        latestReadingDateRegex.matchEntire(text)?.let { m ->
            return "最新测量 · ${m.groupValues[1]}"
        }
        measurementDaysSpanRegex.matchEntire(text)?.let { m ->
            return "${m.groupValues[2]} 天内测量 ${m.groupValues[1]} 天"
        }
        weightWeeklyChangeRegex.matchEntire(text)?.let { m ->
            return "体重 ${m.groupValues[1]} kg · 每周 ${m.groupValues[2]}%"
        }
        bodyFatPointsRegex.matchEntire(text)?.let { m ->
            return "体脂率 ${m.groupValues[1]} 个百分点"
        }
        muscleMassKgRegex.matchEntire(text)?.let { m ->
            return "肌肉量 ${m.groupValues[1]} kg"
        }
        evidenceWorkoutsRegex.matchEntire(text)?.let { m ->
            return "依据：${m.groupValues[4]} 天内运动 ${m.groupValues[1]} 天，共 ${m.groupValues[2]} 次，每周约 ${m.groupValues[3]} 分钟。"
        }
        proposalSelectedActivityRegex.matchEntire(text)?.let { m ->
            val act = translate(m.groupValues[1])
            return "此方案采用你设定的「$act」活动量。"
        }
        proposalWorkoutActivityRegex.matchEntire(text)?.let { m ->
            val sugg = translate(m.groupValues[1])
            val cur = translate(m.groupValues[2])
            return "此方案采用运动建议的「$sugg」活动量，而非你选定的「$cur」活动量。保存前可选择“使用当前”。"
        }
        savedFoodsCountRegex.matchEntire(text)?.let { m ->
            return "共 ${m.groupValues[1]} 项用于搭配套餐的常用食物。"
        }
        noFoodsMatchRegex.matchEntire(text)?.let { m ->
            return "未找到与“${m.groupValues[1]}”匹配的食物。"
        }
        addedExercisesRegex.matchEntire(text)?.let { m ->
            return "已根据描述添加 ${m.groupValues[1]} 个动作"
        }
        loggedBurnedRegex.matchEntire(text)?.let { m ->
            return "已记录 ${m.groupValues[1]} · 消耗 ${m.groupValues[2]} kcal"
        }
        clonedBurnedRegex.matchEntire(text)?.let { m ->
            return "已复制 ${m.groupValues[1]} · 消耗 ${m.groupValues[2]} kcal"
        }
        updatedBurnedRegex.matchEntire(text)?.let { m ->
            return "已更新 ${m.groupValues[1]} · 消耗 ${m.groupValues[2]} kcal"
        }
        deletedPresetRegex.matchEntire(text)?.let { m ->
            return "已删除套餐预设 ${m.groupValues[1]}"
        }
        deletedFoodRegex.matchEntire(text)?.let { m ->
            return "已删除常用食物 ${m.groupValues[1]}"
        }
        updatedFoodNameRegex.matchEntire(text)?.let { m ->
            return "已更新“${m.groupValues[1]}”"
        }
        savedToFoodLibAnyRegex.matchEntire(text)?.let { m ->
            return "已将“${m.groupValues[1]}”保存到食物库"
        }
        savedAsPresetAnyRegex.matchEntire(text)?.let { m ->
            return "已将“${m.groupValues[1]}”保存为套餐预设"
        }
        exercisesCountRegex.matchEntire(text)?.let { m ->
            return "${m.groupValues[1]} 个动作"
        }
        exercisesFilteredRegex.matchEntire(text)?.let { m ->
            return "${m.groupValues[1]} / ${m.groupValues[2]}"
        }
        filtersCountRegex.matchEntire(text)?.let { m ->
            return "${m.groupValues[1]} 个筛选条件"
        }
        targetKgRegex.matchEntire(text)?.let { m ->
            return "目标 · ${m.groupValues[1]} kg"
        }
        targetGenericRegex.matchEntire(text)?.let { m ->
            return "目标 · ${m.groupValues[1]}"
        }
        aboveTargetKgRegex.matchEntire(text)?.let { m ->
            return "高于目标 ${m.groupValues[1]} kg"
        }
        belowTargetKgRegex.matchEntire(text)?.let { m ->
            return "低于目标 ${m.groupValues[1]} kg"
        }
        overByKcalRegex.matchEntire(text)?.let { m ->
            return "超出 ${m.groupValues[1]} kcal"
        }
        underByKcalRegex.matchEntire(text)?.let { m ->
            return "低于目标 ${m.groupValues[1]} kcal"
        }
        selectedDayBurnedRegex.matchEntire(text)?.let { m ->
            return "选中 ${m.groupValues[1]}，消耗 ${m.groupValues[2]} 千卡"
        }
        monthCaloriesBurnedRegex.matchEntire(text)?.let { m ->
            return "${m.groupValues[1]} 消耗千卡"
        }
        attemptOfRegex.matchEntire(text)?.let { m ->
            return "第 ${m.groupValues[1]} 次尝试（共 ${m.groupValues[2]} 次）"
        }
        incorrectPasswordAttemptRegex.matchEntire(text)?.let { m ->
            return "密码错误（第 ${m.groupValues[1]} / ${m.groupValues[2]} 次尝试）"
        }
        modelsAvailableRegex.matchEntire(text)?.let { m ->
            return "当前有 ${m.groupValues[1]} 个可用 ${m.groupValues[2]} 模型"
        }
        noReachableModelsRegex.matchEntire(text)?.let { m ->
            return "未找到可连接的 ${m.groupValues[1]} 模型，请在上方输入模型 ID"
        }
        loadingModelsRegex.matchEntire(text)?.let { m ->
            return "正在加载 ${m.groupValues[1]} 模型…"
        }
        noModelsFoundRegex.matchEntire(text)?.let { m ->
            return "未找到 ${m.groupValues[1]} 模型"
        }
        modelSwitchedRegex.matchEntire(text)?.let { m ->
            return "${m.groupValues[1]} 模型不可用 · 已自动切换至 ${m.groupValues[2]}"
        }
        lastUploadOkRegex.matchEntire(text)?.let { m ->
            return "上次上传成功 · ${m.groupValues[1]}"
        }
        lastUploadFailedRegex.matchEntire(text)?.let { m ->
            return "上次上传失败 · ${m.groupValues[1]}"
        }
        donorLastSeenRegex.matchEntire(text)?.let { m ->
            return "支持者已读标记设为 ${m.groupValues[1]}"
        }
        openedUpdateInRegex.matchEntire(text)?.let { m ->
            return "已在 ${m.groupValues[1]} 中打开更新页面"
        }
        fieldRequiredRangeRegex.matchEntire(text)?.let { m ->
            return "请填写 ${m.groupValues[1]}（${m.groupValues[2]}）"
        }
        mustBeBetweenRegex.matchEntire(text)?.let { m ->
            return "数值必须在 ${m.groupValues[1]} 至 ${m.groupValues[2]} 之间"
        }
        restingFactorDescRegex.matchEntire(text)?.let { m ->
            val desc = translate(m.groupValues[2])
            return "${m.groupValues[1]} 基础代谢 · $desc"
        }
        recognizingNameRegex.matchEntire(text)?.let { m ->
            return "正在识别“${m.groupValues[1]}”…"
        }
        addCustomNameRegex.matchEntire(text)?.let { m ->
            return "添加自定义“${m.groupValues[1]}”"
        }
        viewExerciseNameRegex.matchEntire(text)?.let { m ->
            return "查看 ${m.groupValues[1]}"
        }
        removeExerciseNameRegex.matchEntire(text)?.let { m ->
            return "移除 ${m.groupValues[1]}"
        }
        editExerciseNameRegex.matchEntire(text)?.let { m ->
            return "编辑 ${m.groupValues[1]}"
        }
        deleteFoodNamedRegex.matchEntire(text)?.let { m ->
            return "删除 ${m.groupValues[1]}"
        }
        if (text.startsWith("Export failed: ")) {
            return "导出失败：${text.removePrefix("Export failed: ")}"
        }
        if (text.startsWith("Import failed: ")) {
            return "导入失败：${text.removePrefix("Import failed: ")}"
        }
        if (text.startsWith("Cloud upload failed: ")) {
            return "云端上传失败：${text.removePrefix("Cloud upload failed: ")}"
        }
        return text
    }
}
