package com.djustice.tarot.card

import android.content.Context
import android.content.Intent
import com.djustice.tarot.R

const val NONE: Int = 0

const val Arcana: String = "a"
const val Cups: String ="c"
const val Disks: String = "d"
const val Swords: String = "s"
const val Wands: String = "w"

const val Aries: Int = 1
const val Taurus: Int = 2
const val Gemini: Int = 3
const val Cancer: Int = 4
const val Leo: Int = 5
const val Virgo: Int = 6
const val Libra: Int = 7
const val Scorpio: Int = 8
const val Sagittarius: Int = 9
const val Capricorn: Int = 10
const val Aquarius: Int = 11
const val Pisces: Int = 12

const val Air: Int = 1
const val Earth: Int = 2
const val Fire: Int = 3
const val Water: Int = 4

//const val Earth: Int = 1
const val Jupiter: Int = 2
const val Mars: Int = 3
const val Mercury: Int = 4
const val Moon: Int = 5
const val Neptune: Int = 6
const val Pluto: Int = 7
const val Saturn: Int = 8
const val Sun: Int = 9
const val Uranus: Int = 10
const val Venus: Int = 11

data class Card (
    val set: String = "",
    val number: Int = 0,
    val art: Int = 0,
    val zodiac: Int = 0,
    var zodiac2: Int = 0,
    var zodiac3: Int = 0,
    var element: Int = 0,
    var element2: Int = 0,
    var astrology: Int = 0,
    var astrology2: Int = 0,
    var uprightKeywords: String = "",
    var reversedKeywords: String = "",
    val mText: String = "",
    val pText: String = "")

class CardUtil(private var cxt: Context) {

    var cardList: MutableList<Card> = mutableListOf()

    private lateinit var detailsIntent: Intent

    fun showDetails(cxt: Context, card: Card) {
        detailsIntent = Intent(cxt, CardDetails::class.java)
        detailsIntent.putExtra("set", card.set)
        detailsIntent.putExtra("card", card.number)
        detailsIntent.putExtra("art", card.art)
        detailsIntent.putExtra("zodiac", card.zodiac)
        detailsIntent.putExtra("zodiac2", card.zodiac2)
        detailsIntent.putExtra("zodiac3", card.zodiac3)
        detailsIntent.putExtra("element", card.element)
        detailsIntent.putExtra("element2", card.element2)
        detailsIntent.putExtra("astro", card.astrology)
        detailsIntent.putExtra("astro2", card.astrology2)
        detailsIntent.putExtra("uprightText", card.uprightKeywords.replace(',', '\n'))
        detailsIntent.putExtra("reversedText", card.reversedKeywords.replace(',', '\n'))
        detailsIntent.putExtra("meaningsText", card.mText)
        detailsIntent.putExtra("personalMeaningsText", card.pText)
        cxt.startActivity(detailsIntent)
    }

    fun loadCards() {
        cardList = mutableListOf()
        val a00 = Card(Arcana,0,
            R.drawable.a_00_fool,
            Capricorn, NONE, NONE,
            Air, NONE,
            Uranus, NONE,
            cxt.getString(R.string.a_00_fool_keywords).split("|")[0],
            cxt.getString(R.string.a_00_fool_keywords).split("|")[1],
            cxt.getString(R.string.a_00_fool_meanings),
            cxt.getString(R.string.a_00_fool_p))
        cardList.add(a00)
        val a01 = Card(Arcana, 1,
            R.drawable.a_01_magus,
            Cancer, NONE, NONE,
            Air, NONE,
            Mercury, NONE,
            cxt.getString(R.string.a_01_magus_keywords).split("|")[0],
            cxt.getString(R.string.a_01_magus_keywords).split("|")[1],
            cxt.getString(R.string.a_01_magus_meanings),
            cxt.getString(R.string.a_01_magus_p))
        cardList.add(a01)
        val a02 = Card(Arcana, 2,
            R.drawable.a_02_priestess,
            Leo, NONE, NONE,
            Water, NONE,
            Moon, NONE,
            cxt.getString(R.string.a_02_priestess_keywords).split("|")[0],
            cxt.getString(R.string.a_02_priestess_keywords).split("|")[1],
            cxt.getString(R.string.a_02_priestess_meanings),
            cxt.getString(R.string.a_02_priestess_p))
        cardList.add(a02)
        val a03 = Card(Arcana, 3,
            R.drawable.a_03_empress,
            Aquarius, NONE, NONE,
            Earth, NONE,
            Venus, NONE,
            cxt.getString(R.string.a_03_empress_keywords).split("|")[0],
            cxt.getString(R.string.a_03_empress_keywords).split("|")[1],
            cxt.getString(R.string.a_03_empress_meanings),
            cxt.getString(R.string.a_03_empress_p))
        cardList.add(a03)
        val a04 = Card(Arcana, 4,
            R.drawable.a_04_emperor,
            Aries, NONE, NONE,
            Fire, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_04_emperor_keywords).split("|")[0],
            cxt.getString(R.string.a_04_emperor_keywords).split("|")[1],
            cxt.getString(R.string.a_04_emperor_meanings),
            cxt.getString(R.string.a_04_emperor_p))
        cardList.add(a04)
        val a05 = Card(Arcana, 5,
            R.drawable.a_05_hierophant,
            Taurus, NONE, NONE,
            Earth, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_05_hierophant_keywords).split("|")[0],
            cxt.getString(R.string.a_05_hierophant_keywords).split("|")[1],
            cxt.getString(R.string.a_05_hierophant_meanings),
            cxt.getString(R.string.a_05_hierophant_p))
        cardList.add(a05)
        val a06 = Card(Arcana, 6,
            R.drawable.a_06_lovers,
            Gemini, NONE, NONE,
            Air, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_06_lovers_keywords).split("|")[0],
            cxt.getString(R.string.a_06_lovers_keywords).split("|")[1],
            cxt.getString(R.string.a_06_lovers_meanings),
            cxt.getString(R.string.a_06_lovers_p))
        cardList.add(a06)
        val a07 = Card(Arcana, 7,
            R.drawable.a_07_chariot,
            Cancer, NONE, NONE,
            Water, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_07_chariot_keywords).split("|")[0],
            cxt.getString(R.string.a_07_chariot_keywords).split("|")[1],
            cxt.getString(R.string.a_07_chariot_meanings),
            cxt.getString(R.string.a_07_chariot_p))
        cardList.add(a07)
        val a08 = Card(Arcana, 8,
            R.drawable.a_08_adjustment,
            Leo, NONE, NONE,
            Fire, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_08_adjustment_keywords).split("|")[0],
            cxt.getString(R.string.a_08_adjustment_keywords).split("|")[1],
            cxt.getString(R.string.a_08_adjustment_meanings),
            cxt.getString(R.string.a_08_adjustment_p))
        cardList.add(a08)
        val a09 = Card(Arcana, 9,
            R.drawable.a_09_hermit,
            Virgo, NONE, NONE,
            Earth, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_09_hermit_keywords).split("|")[0],
            cxt.getString(R.string.a_09_hermit_keywords).split("|")[1],
            cxt.getString(R.string.a_09_hermit_meanings),
            cxt.getString(R.string.a_09_hermit_p))
        cardList.add(a09)
        val a10 = Card(Arcana, 10,
            R.drawable.a_10_fortune,
            NONE, NONE, NONE,
            Fire, NONE,
            Jupiter, NONE,
            cxt.getString(R.string.a_10_fortune_keywords).split("|")[0],
            cxt.getString(R.string.a_10_fortune_keywords).split("|")[1],
            cxt.getString(R.string.a_10_fortune_meanings),
            cxt.getString(R.string.a_10_fortune_p))
        cardList.add(a10)
        val a11 = Card(Arcana, 11,
            R.drawable.a_11_lust,
            Leo, NONE, NONE,
            Air, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_11_lust_keywords).split("|")[0],
            cxt.getString(R.string.a_11_lust_keywords).split("|")[1],
            cxt.getString(R.string.a_11_lust_meanings),
            cxt.getString(R.string.a_11_lust_p))
        cardList.add(a11)
        val a12 = Card(Arcana, 12,
            R.drawable.a_12_hanged_man,
            NONE, NONE, NONE,
            Water, NONE,
            Neptune, NONE,
            cxt.getString(R.string.a_12_hanged_man_keywords).split("|")[0],
            cxt.getString(R.string.a_12_hanged_man_keywords).split("|")[1],
            cxt.getString(R.string.a_12_hanged_man_meanings),
            cxt.getString(R.string.a_12_hanged_man_p))
        cardList.add(a12)
        val a13 = Card(Arcana, 13,
            R.drawable.a_13_death,
            Scorpio, NONE, NONE,
            Water, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_13_death_keywords).split("|")[0],
            cxt.getString(R.string.a_13_death_keywords).split("|")[1],
            cxt.getString(R.string.a_13_death_meanings),
            cxt.getString(R.string.a_13_death_p))
        cardList.add(a13)
        val a14 = Card(Arcana, 14,
            R.drawable.a_14_art,
            Sagittarius, NONE, NONE,
            Fire, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_14_art_keywords).split("|")[0],
            cxt.getString(R.string.a_14_art_keywords).split("|")[1],
            cxt.getString(R.string.a_14_art_meanings),
            cxt.getString(R.string.a_14_art_p))
        cardList.add(a14)
        val a15 = Card(Arcana, 15,
            R.drawable.a_15_devil,
            Capricorn, NONE, NONE,
            Earth, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_15_devil_keywords).split("|")[0],
            cxt.getString(R.string.a_15_devil_keywords).split("|")[1],
            cxt.getString(R.string.a_15_devil_meanings),
            cxt.getString(R.string.a_15_devil_p))
        cardList.add(a15)
        val a16 = Card(Arcana, 16,
            R.drawable.a_16_tower,
            NONE, NONE, NONE,
            Fire, NONE,
            Mars, NONE,
            cxt.getString(R.string.a_16_tower_keywords).split("|")[0],
            cxt.getString(R.string.a_16_tower_keywords).split("|")[1],
            cxt.getString(R.string.a_16_tower_meanings),
            cxt.getString(R.string.a_16_tower_p))
        cardList.add(a16)
        val a17 = Card(Arcana, 17,
            R.drawable.a_17_star,
            Aquarius, NONE, NONE,
            Air, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_17_star_keywords).split("|")[0],
            cxt.getString(R.string.a_17_star_keywords).split("|")[1],
            cxt.getString(R.string.a_17_star_meanings),
            cxt.getString(R.string.a_17_star_p))
        cardList.add(a17)
        val a18 = Card(Arcana, 18,
            R.drawable.a_18_moon,
            Pisces, NONE, NONE,
            Water, NONE,
            NONE, NONE,
            cxt.getString(R.string.a_18_moon_keywords).split("|")[0],
            cxt.getString(R.string.a_18_moon_keywords).split("|")[1],
            cxt.getString(R.string.a_18_moon_meanings),
            cxt.getString(R.string.a_18_moon_p))
        cardList.add(a18)
        val a19 = Card(Arcana, 19,
            R.drawable.a_19_sun,
            NONE, NONE, NONE,
            Fire, NONE,
            Sun, NONE,
            cxt.getString(R.string.a_19_sun_keywords).split("|")[0],
            cxt.getString(R.string.a_19_sun_keywords).split("|")[1],
            cxt.getString(R.string.a_19_sun_meanings),
            cxt.getString(R.string.a_19_sun_p))
        cardList.add(a19)
        val a20 = Card(Arcana, 20,
            R.drawable.a_20_aeon,
            NONE, NONE, NONE,
            Fire, NONE,
            Pluto, NONE,
            cxt.getString(R.string.a_20_aeon_keywords).split("|")[0],
            cxt.getString(R.string.a_20_aeon_keywords).split("|")[1],
            cxt.getString(R.string.a_20_aeon_meanings),
            cxt.getString(R.string.a_20_aeon_p))
        cardList.add(a20)
        val a21 = Card(Arcana, 21,
            R.drawable.a_21_universe,
            NONE, NONE, NONE,
            Earth, NONE,
            Saturn, NONE,
            cxt.getString(R.string.a_21_universe_keywords).split("|")[0],
            cxt.getString(R.string.a_21_universe_keywords).split("|")[1],
            cxt.getString(R.string.a_21_universe_meanings),
            cxt.getString(R.string.a_21_universe_p))
        cardList.add(a21)

        val c01 = Card(Cups, 1,
            R.drawable.cups_01,
            Cancer, Scorpio, Pisces,
            Water, NONE,
            NONE,NONE,
            cxt.getString(R.string.cups_01_keywords).split("|")[0],
            cxt.getString(R.string.cups_01_keywords).split("|")[1],
            cxt.getString(R.string.cups_01_meanings),
            cxt.getString(R.string.cups_01_p) )
        cardList.add(c01)
        val c02 = Card(Cups, 2,
            R.drawable.cups_02,
            Cancer, NONE, NONE,
            Water, NONE,
            Venus, NONE,
            cxt.getString(R.string.cups_02_keywords).split("|")[0],
            cxt.getString(R.string.cups_02_keywords).split("|")[1],
            cxt.getString(R.string.cups_02_meanings),
            cxt.getString(R.string.cups_02_p) )
        cardList.add(c02)
        val c03 = Card(Cups, 3,
            R.drawable.cups_03,
            Cancer, NONE, NONE,
            Water, NONE,
            Mercury, NONE,
            cxt.getString(R.string.cups_03_keywords).split("|")[0],
            cxt.getString(R.string.cups_03_keywords).split("|")[1],
            cxt.getString(R.string.cups_03_meanings),
            cxt.getString(R.string.cups_03_p) )
        cardList.add(c03)
        val c04 = Card(Cups, 4,
            R.drawable.cups_04,
            Cancer, NONE, NONE,
            Water, NONE,
            Mars, NONE,
            cxt.getString(R.string.cups_04_keywords).split("|")[0],
            cxt.getString(R.string.cups_04_keywords).split("|")[1],
            cxt.getString(R.string.cups_04_meanings),
            cxt.getString(R.string.cups_04_p) )
        cardList.add(c04)
        val c05 = Card(Cups, 5,
            R.drawable.cups_05,
            Scorpio, NONE, NONE,
            Water, NONE,
            Mars, NONE,
            cxt.getString(R.string.cups_05_keywords).split("|")[0],
            cxt.getString(R.string.cups_05_keywords).split("|")[1],
            cxt.getString(R.string.cups_05_meanings),
            cxt.getString(R.string.cups_05_p) )
        cardList.add(c05)
        val c06 = Card(Cups, 6,
            R.drawable.cups_06,
            Scorpio, NONE, NONE,
            Water, NONE,
            Sun, NONE,
            cxt.getString(R.string.cups_06_keywords).split("|")[0],
            cxt.getString(R.string.cups_06_keywords).split("|")[1],
            cxt.getString(R.string.cups_06_meanings),
            cxt.getString(R.string.cups_06_p) )
        cardList.add(c06)
        val c07 = Card(Cups, 7,
            R.drawable.cups_07,
            Scorpio, NONE, NONE,
            Water, NONE,
            Venus, NONE,
            cxt.getString(R.string.cups_07_keywords).split("|")[0],
            cxt.getString(R.string.cups_07_keywords).split("|")[1],
            cxt.getString(R.string.cups_07_meanings),
            cxt.getString(R.string.cups_07_p) )
        cardList.add(c07)
        val c08 = Card(Cups, 8,
            R.drawable.cups_08,
            Pisces, NONE, NONE,
            Water, NONE,
            Saturn, NONE,
            cxt.getString(R.string.cups_08_keywords).split("|")[0],
            cxt.getString(R.string.cups_08_keywords).split("|")[1],
            cxt.getString(R.string.cups_08_meanings),
            cxt.getString(R.string.cups_08_p) )
        cardList.add(c08)
        val c09 = Card(Cups, 9,
            R.drawable.cups_09,
            Pisces, NONE, NONE,
            Water, NONE,
            Jupiter, NONE,
            cxt.getString(R.string.cups_09_keywords).split("|")[0],
            cxt.getString(R.string.cups_09_keywords).split("|")[1],
            cxt.getString(R.string.cups_09_meanings),
            cxt.getString(R.string.cups_09_p) )
        cardList.add(c09)
        val c10 = Card(Cups, 10,
            R.drawable.cups_10,
            Pisces, NONE, NONE,
            Water, NONE,
            Mars, NONE,
            cxt.getString(R.string.cups_10_keywords).split("|")[0],
            cxt.getString(R.string.cups_10_keywords).split("|")[1],
            cxt.getString(R.string.cups_10_meanings),
            cxt.getString(R.string.cups_10_p) )
        cardList.add(c10)
        val c11 = Card(Cups, 11,
            R.drawable.cups_princess,
            Cancer, Scorpio, Pisces,
            Water, NONE,
            NONE, NONE,
            cxt.getString(R.string.cups_princess_keywords).split("|")[0],
            cxt.getString(R.string.cups_princess_keywords).split("|")[1],
            cxt.getString(R.string.cups_princess_meanings),
            cxt.getString(R.string.cups_princess_p) )
        cardList.add(c11)
        val c12 = Card(Cups, 12,
            R.drawable.cups_prince,
            NONE, NONE, NONE,
            Air, Water,
            NONE, NONE,
            cxt.getString(R.string.cups_prince_keywords).split("|")[0],
            cxt.getString(R.string.cups_prince_keywords).split("|")[1],
            cxt.getString(R.string.cups_prince_meanings),
            cxt.getString(R.string.cups_prince_p) )
        cardList.add(c12)
        val c13 = Card(Cups, 13,
            R.drawable.cups_queen,
            NONE, NONE, NONE,
            Air, Water,
            NONE, NONE,
            cxt.getString(R.string.cups_queen_keywords).split("|")[0],
            cxt.getString(R.string.cups_queen_keywords).split("|")[1],
            cxt.getString(R.string.cups_queen_meanings),
            cxt.getString(R.string.cups_queen_p) )
        cardList.add(c13)
        val c14 = Card(Cups, 14,
            R.drawable.cups_knight,
            NONE, NONE, NONE,
            Air, Water,
            NONE, NONE,
            cxt.getString(R.string.cups_knight_keywords).split("|")[0],
            cxt.getString(R.string.cups_knight_keywords).split("|")[1],
            cxt.getString(R.string.cups_knight_meanings),
            cxt.getString(R.string.cups_knight_p) )
        cardList.add(c14)

        val d01 = Card(Disks, 1,
            R.drawable.disks_01,
            Capricorn, Taurus, Virgo,
            Earth, NONE,
            NONE, NONE,
            cxt.getString(R.string.disks_01_keywords).split("|")[0],
            cxt.getString(R.string.disks_01_keywords).split("|")[1],
            cxt.getString(R.string.disks_01_meanings),
            cxt.getString(R.string.disks_01_p) )
        cardList.add(d01)
        val d02 = Card(Disks, 2,
            R.drawable.disks_02,
            Capricorn, NONE, NONE,
            Earth, NONE,
            Jupiter, NONE,
            cxt.getString(R.string.disks_02_keywords).split("|")[0],
            cxt.getString(R.string.disks_02_keywords).split("|")[1],
            cxt.getString(R.string.disks_02_meanings),
            cxt.getString(R.string.disks_02_p) )
        cardList.add(d02)
        val d03 = Card(Disks, 3,
            R.drawable.disks_03,
            Capricorn, NONE, NONE,
            Earth, NONE,
            Mars, NONE,
            cxt.getString(R.string.disks_03_keywords).split("|")[0],
            cxt.getString(R.string.disks_03_keywords).split("|")[1],
            cxt.getString(R.string.disks_03_meanings),
            cxt.getString(R.string.disks_03_p) )
        cardList.add(d03)
        val d04 = Card(Disks, 4,
            R.drawable.disks_04,
            Capricorn, NONE, NONE,
            Earth, NONE,
            Sun, NONE,
            cxt.getString(R.string.disks_04_keywords).split("|")[0],
            cxt.getString(R.string.disks_04_keywords).split("|")[1],
            cxt.getString(R.string.disks_04_meanings),
            cxt.getString(R.string.disks_04_p) )
        cardList.add(d04)
        val d05 = Card(Disks, 5,
            R.drawable.disks_05,
            Taurus, NONE, NONE,
            Earth, NONE,
            Mercury, NONE,
            cxt.getString(R.string.disks_05_keywords).split("|")[0],
            cxt.getString(R.string.disks_05_keywords).split("|")[1],
            cxt.getString(R.string.disks_05_meanings),
            cxt.getString(R.string.disks_05_p) )
        cardList.add(d05)
        val d06 = Card(Disks, 6,
            R.drawable.disks_06,
            Taurus, NONE, NONE,
            Earth, NONE,
            Moon, NONE,
            cxt.getString(R.string.disks_06_keywords).split("|")[0],
            cxt.getString(R.string.disks_06_keywords).split("|")[1],
            cxt.getString(R.string.disks_06_meanings),
            cxt.getString(R.string.disks_06_p) )
        cardList.add(d06)
        val d07 = Card(Disks, 7,
            R.drawable.disks_07,
            Taurus, NONE, NONE,
            Earth, NONE,
            Saturn, NONE,
            cxt.getString(R.string.disks_07_keywords).split("|")[0],
            cxt.getString(R.string.disks_07_keywords).split("|")[1],
            cxt.getString(R.string.disks_07_meanings),
            cxt.getString(R.string.disks_07_p) )
        cardList.add(d07)
        val d08 = Card(Disks, 8,
            R.drawable.disks_08,
            Virgo, NONE, NONE,
            Earth, NONE,
            Sun, NONE,
            cxt.getString(R.string.disks_08_keywords).split("|")[0],
            cxt.getString(R.string.disks_08_keywords).split("|")[1],
            cxt.getString(R.string.disks_08_meanings),
            cxt.getString(R.string.disks_08_p) )
        cardList.add(d08)
        val d09 = Card(Disks, 9,
            R.drawable.disks_09,
            Virgo, NONE, NONE,
            Earth, NONE,
            Venus, NONE,
            cxt.getString(R.string.disks_09_keywords).split("|")[0],
            cxt.getString(R.string.disks_09_keywords).split("|")[1],
            cxt.getString(R.string.disks_09_meanings),
            cxt.getString(R.string.disks_09_p) )
        cardList.add(d09)
        val d10 = Card(Disks, 10,
            R.drawable.disks_10,
            Virgo, NONE, NONE,
            Earth, NONE,
            Mercury, NONE,
            cxt.getString(R.string.disks_10_keywords).split("|")[0],
            cxt.getString(R.string.disks_10_keywords).split("|")[1],
            cxt.getString(R.string.disks_10_meanings),
            cxt.getString(R.string.disks_10_p) )
        cardList.add(d10)
        val d11 = Card(Disks, 11,
            R.drawable.disks_princess,
            Capricorn, Taurus, Virgo,
            Earth, NONE,
            NONE, NONE,
            cxt.getString(R.string.disks_princess_keywords).split("|")[0],
            cxt.getString(R.string.disks_princess_keywords).split("|")[1],
            cxt.getString(R.string.disks_princess_meanings),
            cxt.getString(R.string.disks_princess_p) )
        cardList.add(d11)
        val d12 = Card(Disks, 12,
            R.drawable.disks_prince,
            NONE, NONE, NONE,
            Fire, Earth,
            NONE, NONE,
            cxt.getString(R.string.disks_prince_keywords).split("|")[0],
            cxt.getString(R.string.disks_prince_keywords).split("|")[1],
            cxt.getString(R.string.disks_prince_meanings),
            cxt.getString(R.string.disks_prince_p) )
        cardList.add(d12)
        val d13 = Card(Disks, 13,
            R.drawable.disks_queen,
            NONE, NONE, NONE,
            Fire, Earth,
            NONE, NONE,
            cxt.getString(R.string.disks_queen_keywords).split("|")[0],
            cxt.getString(R.string.disks_queen_keywords).split("|")[1],
            cxt.getString(R.string.disks_queen_meanings),
            cxt.getString(R.string.disks_queen_p) )
        cardList.add(d13)
        val d14 = Card(Disks, 14,
            R.drawable.disks_knight,
            NONE, NONE, NONE,
            Fire, Earth,
            NONE, NONE,
            cxt.getString(R.string.disks_knight_keywords).split("|")[0],
            cxt.getString(R.string.disks_knight_keywords).split("|")[1],
            cxt.getString(R.string.disks_knight_meanings),
            cxt.getString(R.string.disks_knight_p) )
        cardList.add(d14)

        val s01 = Card(Swords, 1,
            R.drawable.swords_01,
            Libra, Aquarius, Gemini,
            Air,NONE,
            NONE,NONE,
            cxt.getString(R.string.swords_01_keywords).split("|")[0],
            cxt.getString(R.string.swords_01_keywords).split("|")[1],
            cxt.getString(R.string.swords_01_meanings),
            cxt.getString(R.string.swords_01_p) )
        cardList.add(s01)
        val s02 = Card(Swords, 2,
            R.drawable.swords_02,
            Libra, NONE, NONE,
            Air, NONE,
            Moon, NONE,
            cxt.getString(R.string.swords_02_keywords).split("|")[0],
            cxt.getString(R.string.swords_02_keywords).split("|")[1],
            cxt.getString(R.string.swords_02_meanings),
            cxt.getString(R.string.swords_02_p) )
        cardList.add(s02)
        val s03 = Card(Swords, 3,
            R.drawable.swords_03,
            Libra, NONE, NONE,
            Air, NONE,
            Saturn, NONE,
            cxt.getString(R.string.swords_03_keywords).split("|")[0],
            cxt.getString(R.string.swords_03_keywords).split("|")[1],
            cxt.getString(R.string.swords_03_meanings),
            cxt.getString(R.string.swords_03_p) )
        cardList.add(s03)
        val s04 = Card(Swords, 4,
            R.drawable.swords_04,
            Libra, NONE, NONE,
            Air, NONE,
            Jupiter, NONE,
            cxt.getString(R.string.swords_04_keywords).split("|")[0],
            cxt.getString(R.string.swords_04_keywords).split("|")[1],
            cxt.getString(R.string.swords_04_meanings),
            cxt.getString(R.string.swords_04_p) )
        cardList.add(s04)
        val s05 = Card(Swords, 5,
            R.drawable.swords_05,
            Aquarius, NONE, NONE,
            Air, NONE,
            Venus, NONE,
            cxt.getString(R.string.swords_05_keywords).split("|")[0],
            cxt.getString(R.string.swords_05_keywords).split("|")[1],
            cxt.getString(R.string.swords_05_meanings),
            cxt.getString(R.string.swords_05_p) )
        cardList.add(s05)
        val s06 = Card(Swords, 6,
            R.drawable.swords_06,
            Aquarius, NONE, NONE,
            Air, NONE,
            Mercury, NONE,
            cxt.getString(R.string.swords_06_keywords).split("|")[0],
            cxt.getString(R.string.swords_06_keywords).split("|")[1],
            cxt.getString(R.string.swords_06_meanings),
            cxt.getString(R.string.swords_06_p) )
        cardList.add(s06)
        val s07 = Card(Swords, 7,
            R.drawable.swords_07,
            Aquarius, NONE, NONE,
            Air, NONE,
            Moon, NONE,
            cxt.getString(R.string.swords_07_keywords).split("|")[0],
            cxt.getString(R.string.swords_07_keywords).split("|")[1],
            cxt.getString(R.string.swords_07_meanings),
            cxt.getString(R.string.swords_07_p) )
        cardList.add(s07)
        val s08 = Card(Swords, 8,
            R.drawable.swords_08,
            Gemini, NONE, NONE,
            Air, NONE,
            Jupiter, NONE,
            cxt.getString(R.string.swords_08_keywords).split("|")[0],
            cxt.getString(R.string.swords_08_keywords).split("|")[1],
            cxt.getString(R.string.swords_08_meanings),
            cxt.getString(R.string.swords_08_p) )
        cardList.add(s08)
        val s09 = Card(Swords, 9,
            R.drawable.swords_09,
            Gemini, NONE, NONE,
            Air, NONE,
            Mars, NONE,
            cxt.getString(R.string.swords_09_keywords).split("|")[0],
            cxt.getString(R.string.swords_09_keywords).split("|")[1],
            cxt.getString(R.string.swords_09_meanings),
            cxt.getString(R.string.swords_09_p) )
        cardList.add(s09)
        val s10 = Card(Swords, 10,
            R.drawable.swords_10,
            Gemini, NONE, NONE,
            Air, NONE,
            Sun,NONE,
            cxt.getString(R.string.swords_10_keywords).split("|")[0],
            cxt.getString(R.string.swords_10_keywords).split("|")[1],
            cxt.getString(R.string.swords_10_meanings),
            cxt.getString(R.string.swords_10_p) )
        cardList.add(s10)
        val s11 = Card(Swords, 11,
            R.drawable.swords_princess,
            Libra, Aquarius, Gemini,
            Air, NONE,
            NONE, NONE,
            cxt.getString(R.string.swords_princess_keywords).split("|")[0],
            cxt.getString(R.string.swords_princess_keywords).split("|")[1],
            cxt.getString(R.string.swords_princess_meanings),
            cxt.getString(R.string.swords_princess_p) )
        cardList.add(s11)
        val s12 = Card(Swords, 12,
            R.drawable.swords_prince,
            NONE, NONE, NONE,
            Earth, Water,
            NONE, NONE,
            cxt.getString(R.string.swords_prince_keywords).split("|")[0],
            cxt.getString(R.string.swords_prince_keywords).split("|")[1],
            cxt.getString(R.string.swords_prince_meanings),
            cxt.getString(R.string.swords_prince_p) )
        cardList.add(s12)
        val s13 = Card(Swords, 13,
            R.drawable.swords_queen,
            NONE, NONE, NONE,
            Earth, Water,
            NONE, NONE,
            cxt.getString(R.string.swords_queen_keywords).split("|")[0],
            cxt.getString(R.string.swords_queen_keywords).split("|")[1],
            cxt.getString(R.string.swords_queen_meanings),
            cxt.getString(R.string.swords_queen_p) )
        cardList.add(s13)
        val s14 = Card(Swords, 14,
            R.drawable.swords_knight,
            NONE, NONE, NONE,
            Earth, Water,
            NONE, NONE,
            cxt.getString(R.string.swords_knight_keywords).split("|")[0],
            cxt.getString(R.string.swords_knight_keywords).split("|")[1],
            cxt.getString(R.string.swords_knight_meanings),
            cxt.getString(R.string.swords_knight_p) )
        cardList.add(s14)

        val w01 = Card(Wands, 1,
            R.drawable.wands_01,
            Aries, Leo, Sagittarius,
            Fire,NONE,
            NONE, NONE,
            cxt.getString(R.string.wands_01_keywords).split("|")[0],
            cxt.getString(R.string.wands_01_keywords).split("|")[1],
            cxt.getString(R.string.wands_01_meanings),
            cxt.getString(R.string.wands_01_p))
        cardList.add(w01)
        val w02 = Card(Wands, 2,
            R.drawable.wands_02,
            Aries, NONE, NONE,
            Fire, NONE,
            Mars, NONE,
            cxt.getString(R.string.wands_02_keywords).split("|")[0],
            cxt.getString(R.string.wands_02_keywords).split("|")[1],
            cxt.getString(R.string.wands_02_meanings),
            cxt.getString(R.string.wands_02_p))
        cardList.add(w02)
        val w03 = Card(Wands, 3,
            R.drawable.wands_03,
            Aries, NONE, NONE,
            Fire, NONE,
            Sun, NONE,
            cxt.getString(R.string.wands_03_keywords).split("|")[0],
            cxt.getString(R.string.wands_03_keywords).split("|")[1],
            cxt.getString(R.string.wands_03_meanings),
            cxt.getString(R.string.wands_03_p))
        cardList.add(w03)
        val w04 = Card(Wands, 4,
            R.drawable.wands_04,
            Aries, NONE, NONE,
            Fire, NONE,
            Venus, NONE,
            cxt.getString(R.string.wands_04_keywords).split("|")[0],
            cxt.getString(R.string.wands_04_keywords).split("|")[1],
            cxt.getString(R.string.wands_04_meanings),
            cxt.getString(R.string.wands_04_p))
        cardList.add(w04)
        val w05 = Card(Wands, 5,
            R.drawable.wands_05,
            Leo, NONE, NONE,
            Fire, NONE,
            Saturn, NONE,
            cxt.getString(R.string.wands_05_keywords).split("|")[0],
            cxt.getString(R.string.wands_05_keywords).split("|")[1],
            cxt.getString(R.string.wands_05_meanings),
            cxt.getString(R.string.wands_05_p))
        cardList.add(w05)
        val w06 = Card(Wands, 6,
            R.drawable.wands_06,
            Leo, NONE, NONE,
            Fire, NONE,
            Jupiter, NONE,
            cxt.getString(R.string.wands_06_keywords).split("|")[0],
            cxt.getString(R.string.wands_06_keywords).split("|")[1],
            cxt.getString(R.string.wands_06_meanings),
            cxt.getString(R.string.wands_06_p))
        cardList.add(w06)
        val w07 = Card(Wands, 7,
            R.drawable.wands_07,
            Leo, NONE, NONE,
            Fire, NONE,
            Mars, NONE,
            cxt.getString(R.string.wands_07_keywords).split("|")[0],
            cxt.getString(R.string.wands_07_keywords).split("|")[1],
            cxt.getString(R.string.wands_07_meanings),
            cxt.getString(R.string.wands_07_p))
        cardList.add(w07)
        val w08 = Card(Wands, 8,
            R.drawable.wands_08,
            Sagittarius, NONE, NONE,
            Fire, NONE,
            Mercury, NONE,
            cxt.getString(R.string.wands_08_keywords).split("|")[0],
            cxt.getString(R.string.wands_08_keywords).split("|")[1],
            cxt.getString(R.string.wands_08_meanings),
            cxt.getString(R.string.wands_08_p))
        cardList.add(w08)
        val w09 = Card(Wands, 9,
            R.drawable.wands_09,
            Sagittarius, NONE, NONE,
            Fire, NONE,
            Moon, NONE,
            cxt.getString(R.string.wands_09_keywords).split("|")[0],
            cxt.getString(R.string.wands_09_keywords).split("|")[1],
            cxt.getString(R.string.wands_09_meanings),
            cxt.getString(R.string.wands_09_p))
        cardList.add(w09)
        val w10 = Card(Wands, 10,
            R.drawable.wands_10,
            Sagittarius, NONE, NONE,
            Fire, NONE,
            Saturn, NONE,
            cxt.getString(R.string.wands_10_keywords).split("|")[0],
            cxt.getString(R.string.wands_10_keywords).split("|")[1],
            cxt.getString(R.string.wands_10_meanings),
            cxt.getString(R.string.wands_10_p))
        cardList.add(w10)
        val w11 = Card(Wands, 11,
            R.drawable.wands_princess,
            Aries, Leo, Sagittarius,
            Fire, NONE,
            NONE, NONE,
            cxt.getString(R.string.wands_princess_keywords).split("|")[0],
            cxt.getString(R.string.wands_princess_keywords).split("|")[1],
            cxt.getString(R.string.wands_princess_meanings),
            cxt.getString(R.string.wands_princess_p))
        cardList.add(w11)
        val w12 = Card(Wands, 12,
            R.drawable.wands_prince,
            NONE, NONE, NONE,
            Water, Fire,
            NONE, NONE,
            cxt.getString(R.string.wands_prince_keywords).split("|")[0],
            cxt.getString(R.string.wands_prince_keywords).split("|")[1],
            cxt.getString(R.string.wands_prince_meanings),
            cxt.getString(R.string.wands_prince_p))
        cardList.add(w12)
        val w13 = Card(Wands, 13,
            R.drawable.wands_queen,
            NONE, NONE, NONE,
            Water, Fire,
            NONE, NONE,
            cxt.getString(R.string.wands_queen_keywords).split("|")[0],
            cxt.getString(R.string.wands_queen_keywords).split("|")[1],
            cxt.getString(R.string.wands_queen_meanings),
            cxt.getString(R.string.wands_queen_p))
        cardList.add(w13)
        val w14 = Card(Wands, 14,
            R.drawable.wands_knight,
            NONE, NONE, NONE,
            Water, Fire,
            NONE, NONE,
            cxt.getString(R.string.wands_knight_keywords).split("|")[0],
            cxt.getString(R.string.wands_knight_keywords).split("|")[1],
            cxt.getString(R.string.wands_knight_meanings),
            cxt.getString(R.string.wands_knight_p))
        cardList.add(w14)
    }
}