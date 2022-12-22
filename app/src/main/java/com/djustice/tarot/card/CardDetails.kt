package com.djustice.tarot.card

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.method.MovementMethod
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.djustice.tarot.R
import com.djustice.tarot.databinding.ActivityCardDetailsBinding
import kotlin.math.abs

class CardDetails : Activity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val v = ActivityCardDetailsBinding.inflate(layoutInflater)

        val set: String? = intent.getStringExtra("set")
        val card: Int = intent.getIntExtra("card", 0)
        val zodiac: Int = intent.getIntExtra("zodiac", 0)
        val zodiac2: Int = intent.getIntExtra("zodiac2", 0)
        val zodiac3: Int = intent.getIntExtra("zodiac3", 0)
        val element: Int = intent.getIntExtra("element", 0)
        val element2: Int = intent.getIntExtra("element2", 0)
        val astro: Int = intent.getIntExtra("astro", 0)
        val astro2: Int = intent.getIntExtra("astro2", 0)
        val uprightText: String? = intent.getStringExtra("uprightText")
        val reversedText: String? = intent.getStringExtra("reversedText")
        val meaningsText: String? = intent.getStringExtra("meaningsText")
        val personalText: String? = intent.getStringExtra("personalMeaningsText")

        val util = CardUtil(this)
        util.loadCards()

        v.ivCard.setOnTouchListener(object : OnSwipeTouchListener(this){
            override fun onSwipeRight() {
                var cardPrev = 0
                if (set == "a") cardPrev = card - 1
                if (set == "c") cardPrev = card - 1 + 21
                if (set == "d") cardPrev = card - 1 + 21 + 14
                if (set == "s") cardPrev = card - 1 + 21 + 14 + 14
                if (set == "w") cardPrev = card - 1 + 21 + 14 + 14 + 14
                if (cardPrev == -1) return
                util.showDetails(v.ivCard.context, util.cardList[cardPrev])
                finish()
            }

            override fun onSwipeLeft() {
                var cardNext = 0
                if (set == "a") cardNext = card + 1
                if (set == "c") cardNext = card + 1 + 21
                if (set == "d") cardNext = card + 1 + 21 + 14
                if (set == "s") cardNext = card + 1 + 21 + 14 + 14
                if (set == "w") cardNext = card + 1 + 21 + 14 + 14 + 14
                if (cardNext == 78) return
                util.showDetails(v.ivCard.context , util.cardList[cardNext])
                finish()
            }
        })

        when (set) {
            "a" -> {
                when (card) {
                    0 -> { v.ivCard.background = loadArt(R.drawable.a_00_fool) }
                    1 -> { v.ivCard.background = loadArt(R.drawable.a_01_magus) }
                    2 -> { v.ivCard.background = loadArt(R.drawable.a_02_priestess) }
                    3 -> { v.ivCard.background = loadArt(R.drawable.a_03_empress) }
                    4 -> { v.ivCard.background = loadArt(R.drawable.a_04_emperor) }
                    5 -> { v.ivCard.background = loadArt(R.drawable.a_05_hierophant) }
                    6 -> { v.ivCard.background = loadArt(R.drawable.a_06_lovers) }
                    7 -> { v.ivCard.background = loadArt(R.drawable.a_07_chariot) }
                    8 -> { v.ivCard.background = loadArt(R.drawable.a_08_adjustment) }
                    9 -> { v.ivCard.background = loadArt(R.drawable.a_09_hermit) }
                    10 -> { v.ivCard.background = loadArt(R.drawable.a_10_fortune) }
                    11 -> { v.ivCard.background = loadArt(R.drawable.a_11_lust) }
                    12 -> { v.ivCard.background = loadArt(R.drawable.a_12_hanged_man) }
                    13 -> { v.ivCard.background = loadArt(R.drawable.a_13_death) }
                    14 -> { v.ivCard.background = loadArt(R.drawable.a_14_art) }
                    15 -> { v.ivCard.background = loadArt(R.drawable.a_15_devil) }
                    16 -> { v.ivCard.background = loadArt(R.drawable.a_16_tower) }
                    17 -> { v.ivCard.background = loadArt(R.drawable.a_17_star) }
                    18 -> { v.ivCard.background = loadArt(R.drawable.a_18_moon) }
                    19 -> { v.ivCard.background = loadArt(R.drawable.a_19_sun) }
                    20 -> { v.ivCard.background = loadArt(R.drawable.a_20_aeon) }
                    21 -> { v.ivCard.background = loadArt(R.drawable.a_21_universe) }
                }
            }
            "c" -> {
                when (card) {
                    0 -> { v.ivCard.background = loadArt(R.drawable.background) }
                    1 -> { v.ivCard.background = loadArt(R.drawable.cups_01) }
                    2 -> { v.ivCard.background = loadArt(R.drawable.cups_02) }
                    3 -> { v.ivCard.background = loadArt(R.drawable.cups_03) }
                    4 -> { v.ivCard.background = loadArt(R.drawable.cups_04) }
                    5 -> { v.ivCard.background = loadArt(R.drawable.cups_05) }
                    6 -> { v.ivCard.background = loadArt(R.drawable.cups_06) }
                    7 -> { v.ivCard.background = loadArt(R.drawable.cups_07) }
                    8 -> { v.ivCard.background = loadArt(R.drawable.cups_08) }
                    9 -> { v.ivCard.background = loadArt(R.drawable.cups_09) }
                    10 -> { v.ivCard.background = loadArt(R.drawable.cups_10) }
                    11 -> { v.ivCard.background = loadArt(R.drawable.cups_princess) }
                    12 -> { v.ivCard.background = loadArt(R.drawable.cups_prince) }
                    13 -> { v.ivCard.background = loadArt(R.drawable.cups_queen) }
                    14 -> { v.ivCard.background = loadArt(R.drawable.cups_knight) }
                }
            }
            "d" -> {
                when (card) {
                    0 -> { v.ivCard.background = loadArt(R.drawable.background) }
                    1 -> { v.ivCard.background = loadArt(R.drawable.disks_01) }
                    2 -> { v.ivCard.background = loadArt(R.drawable.disks_02) }
                    3 -> { v.ivCard.background = loadArt(R.drawable.disks_03) }
                    4 -> { v.ivCard.background = loadArt(R.drawable.disks_04) }
                    5 -> { v.ivCard.background = loadArt(R.drawable.disks_05) }
                    6 -> { v.ivCard.background = loadArt(R.drawable.disks_06) }
                    7 -> { v.ivCard.background = loadArt(R.drawable.disks_07) }
                    8 -> { v.ivCard.background = loadArt(R.drawable.disks_08) }
                    9 -> { v.ivCard.background = loadArt(R.drawable.disks_09) }
                    10 -> { v.ivCard.background = loadArt(R.drawable.disks_10) }
                    11 -> { v.ivCard.background = loadArt(R.drawable.disks_princess) }
                    12 -> { v.ivCard.background = loadArt(R.drawable.disks_prince) }
                    13 -> { v.ivCard.background = loadArt(R.drawable.disks_queen) }
                    14 -> { v.ivCard.background = loadArt(R.drawable.disks_knight) }
                }
            }
            "s" -> {
                when (card) {
                    0 -> { v.ivCard.background = loadArt(R.drawable.background) }
                    1 -> { v.ivCard.background = loadArt(R.drawable.swords_01) }
                    2 -> { v.ivCard.background = loadArt(R.drawable.swords_02) }
                    3 -> { v.ivCard.background = loadArt(R.drawable.swords_03) }
                    4 -> { v.ivCard.background = loadArt(R.drawable.swords_04) }
                    5 -> { v.ivCard.background = loadArt(R.drawable.swords_05) }
                    6 -> { v.ivCard.background = loadArt(R.drawable.swords_06) }
                    7 -> { v.ivCard.background = loadArt(R.drawable.swords_07) }
                    8 -> { v.ivCard.background = loadArt(R.drawable.swords_08) }
                    9 -> { v.ivCard.background = loadArt(R.drawable.swords_09) }
                    10 -> { v.ivCard.background = loadArt(R.drawable.swords_10) }
                    11 -> { v.ivCard.background = loadArt(R.drawable.swords_princess) }
                    12 -> { v.ivCard.background = loadArt(R.drawable.swords_prince) }
                    13 -> { v.ivCard.background = loadArt(R.drawable.swords_queen) }
                    14 -> { v.ivCard.background = loadArt(R.drawable.swords_knight) }
                }
            }
            else -> { // ("wands")
                when (card) {
                    0 -> { v.ivCard.background = loadArt(R.drawable.background) }
                    1 -> { v.ivCard.background = loadArt(R.drawable.wands_01) }
                    2 -> { v.ivCard.background = loadArt(R.drawable.wands_02) }
                    3 -> { v.ivCard.background = loadArt(R.drawable.wands_03) }
                    4 -> { v.ivCard.background = loadArt(R.drawable.wands_04) }
                    5 -> { v.ivCard.background = loadArt(R.drawable.wands_05) }
                    6 -> { v.ivCard.background = loadArt(R.drawable.wands_06) }
                    7 -> { v.ivCard.background = loadArt(R.drawable.wands_07) }
                    8 -> { v.ivCard.background = loadArt(R.drawable.wands_08) }
                    9 -> { v.ivCard.background = loadArt(R.drawable.wands_09) }
                    10 -> { v.ivCard.background = loadArt(R.drawable.wands_10) }
                    11 -> { v.ivCard.background = loadArt(R.drawable.wands_princess) }
                    12 -> { v.ivCard.background = loadArt(R.drawable.wands_prince) }
                    13 -> { v.ivCard.background = loadArt(R.drawable.wands_queen) }
                    14 -> { v.ivCard.background = loadArt(R.drawable.wands_knight) }
                }
            }
        }

        if (zodiac == 0) {
            v.ivZodiac.visibility = GONE
            v.ivZodiac2.visibility = GONE
            v.ivZodiac3.visibility = GONE
        } else {
            v.ivZodiac.visibility = VISIBLE
        }

        when (zodiac) {
            0 -> { }
            1 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_1_aries) }
            2 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_2_taurus) }
            3 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_3_gemini) }
            4 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_4_cancer) }
            5 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_5_leo) }
            6 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_6_virgo) }
            7 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_7_libra) }
            8 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_8_scorpio) }
            9 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_9_sagittarius) }
            10 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_10_capricorn) }
            11 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_11_aquarius) }
            12 -> { v.ivZodiac.background = loadArt(R.drawable.icon_zodiac_12_pisces) }
        }

        if (zodiac2 == 0) {
            v.ivZodiac2.visibility = GONE
            v.ivZodiac3.visibility = GONE
        } else {
            v.ivZodiac2.visibility = VISIBLE
        }

        when (zodiac2) {
            0 -> { }
            1 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_1_aries) }
            2 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_2_taurus) }
            3 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_3_gemini) }
            4 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_4_cancer) }
            5 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_5_leo) }
            6 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_6_virgo) }
            7 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_7_libra) }
            8 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_8_scorpio) }
            9 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_9_sagittarius) }
            10 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_10_capricorn) }
            11 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_11_aquarius) }
            12 -> { v.ivZodiac2.background = loadArt(R.drawable.icon_zodiac_12_pisces) }
        }

        if (zodiac3 == 0) { v.ivZodiac3.visibility = GONE }
        else { v.ivZodiac3.visibility = VISIBLE }

        when (zodiac3) {
            0 -> { }
            1 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_1_aries) }
            2 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_2_taurus) }
            3 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_3_gemini) }
            4 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_4_cancer) }
            5 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_5_leo) }
            6 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_6_virgo) }
            7 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_7_libra) }
            8 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_8_scorpio) }
            9 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_9_sagittarius) }
            10 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_10_capricorn) }
            11 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_11_aquarius) }
            12 -> { v.ivZodiac3.background = loadArt(R.drawable.icon_zodiac_12_pisces) }
        }

        if (element == 0) {
            v.ivElement.visibility = GONE
            v.ivElement2.visibility = GONE
        } else {
            v.ivElement.visibility = VISIBLE
        }

        when (element) {
            0 -> { }
            1 -> { v.ivElement.background = loadArt(R.drawable.icon_element_1_air) }
            2 -> { v.ivElement.background = loadArt(R.drawable.icon_element_2_earth) }
            3 -> { v.ivElement.background = loadArt(R.drawable.icon_element_3_fire) }
            4 -> { v.ivElement.background = loadArt(R.drawable.icon_element_4_water) }
        }

        if (element2 == 0) { v.ivElement2.visibility = GONE }
        else { v.ivElement2.visibility = VISIBLE }

        when (element2) {
            0 -> { }
            1 -> { v.ivElement2.background = loadArt(R.drawable.icon_element_1_air) }
            2 -> { v.ivElement2.background = loadArt(R.drawable.icon_element_2_earth) }
            3 -> { v.ivElement2.background = loadArt(R.drawable.icon_element_3_fire) }
            4 -> { v.ivElement2.background = loadArt(R.drawable.icon_element_4_water) }
        }

        if (astro == 0) {
            v.ivAstro.visibility = GONE
            v.ivAstro2.visibility = GONE
        } else {
            v.ivAstro.visibility = VISIBLE
        }

        when (astro) {
            0 -> { }
            1 -> { v.ivAstro.background = loadArt(R.drawable.icon_astro_1_earth) }
            2 -> { v.ivAstro.background = loadArt(R.drawable.icon_astro_2_jupiter) }
            3 -> { v.ivAstro.background = loadArt(R.drawable.icon_astro_3_mars) }
            4 -> { v.ivAstro.background = loadArt(R.drawable.icon_astro_4_mercury) }
            5 -> { v.ivAstro.background = loadArt(R.drawable.icon_astro_5_moon) }
            6 -> { v.ivAstro.background = loadArt(R.drawable.icon_astro_6_neptune) }
            7 -> { v.ivAstro.background = loadArt(R.drawable.icon_astro_7_pluto) }
            8 -> { v.ivAstro.background = loadArt(R.drawable.icon_astro_8_saturn) }
            9 -> { v.ivAstro.background = loadArt(R.drawable.icon_astro_9_sun) }
            10 -> { v.ivAstro.background = loadArt(R.drawable.icon_astro_10_uranus) }
            11 -> { v.ivAstro.background = loadArt(R.drawable.icon_astro_11_venus) }
        }

        if (astro2 == 0) { v.ivAstro2.visibility = GONE }
        else { v.ivAstro2.visibility = VISIBLE }

        when (astro2) {
            0 -> { }
            1 -> { v.ivAstro2.background = loadArt(R.drawable.icon_astro_1_earth) }
            2 -> { v.ivAstro2.background = loadArt(R.drawable.icon_astro_2_jupiter) }
            3 -> { v.ivAstro2.background = loadArt(R.drawable.icon_astro_3_mars) }
            4 -> { v.ivAstro2.background = loadArt(R.drawable.icon_astro_4_mercury) }
            5 -> { v.ivAstro2.background = loadArt(R.drawable.icon_astro_5_moon) }
            6 -> { v.ivAstro2.background = loadArt(R.drawable.icon_astro_6_neptune) }
            7 -> { v.ivAstro2.background = loadArt(R.drawable.icon_astro_7_pluto) }
            8 -> { v.ivAstro2.background = loadArt(R.drawable.icon_astro_8_saturn) }
            9 -> { v.ivAstro2.background = loadArt(R.drawable.icon_astro_9_sun) }
            10 -> { v.ivAstro2.background = loadArt(R.drawable.icon_astro_10_uranus) }
            11 -> { v.ivAstro2.background = loadArt(R.drawable.icon_astro_11_venus) }
        }

        if (uprightText != "") v.tvUprightKeywords.text = uprightText

        if (reversedText != "") v.tvReversedKeywords.text = reversedText

        if (meaningsText != "") v.tvMeanings.text = meaningsText

        if (personalText != "") v.tvP.text = personalText

        setContentView(v.root)

    }

    private fun loadArt(r: Int) : Drawable? {
        return AppCompatResources.getDrawable(this, r)
    }
}

open class OnSwipeTouchListener(ctx: Context?) : View.OnTouchListener {
    private val gestureDetector: GestureDetector  = GestureDetector(ctx, GestureListener())

    val context = ctx

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        v.performClick()
        return gestureDetector.onTouchEvent(event)
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            val distanceX = e2.x - e1.x
            val distanceY = e2.y - e1.y
            val SWIPE_DISTANCE_THRESHOLD = 40
            val SWIPE_VELOCITY_THRESHOLD = 40
            if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (distanceX > 0) onSwipeRight() else onSwipeLeft()
                    return true
                } else {
                    failedSwipe(distanceX, distanceY)
            }
                return false
        }
    }

    open fun onSwipeRight() {}
    open fun onSwipeLeft() {}
    open fun failedSwipe(dX: Float, dY: Float) { Toast.makeText(context, "--- failed swipe: dX: $dX dY: $dY", Toast.LENGTH_SHORT).show() }
}