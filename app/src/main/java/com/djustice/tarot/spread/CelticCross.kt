package com.djustice.tarot.spread

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.djustice.tarot.R
import com.djustice.tarot.card.Card
import com.djustice.tarot.card.CardUtil
import com.djustice.tarot.databinding.ActivityCelticCrossBinding
import kotlin.random.Random
import kotlin.random.nextInt

class CelticCross : Activity() {

    private lateinit var cards: Array<Card>
    private lateinit var cardAnimsFront: Array<AnimatorSet>
    private lateinit var cardAnimsBack: Array<AnimatorSet>
    private lateinit var nums: Array<Int?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = ActivityCelticCrossBinding.inflate(layoutInflater)

        val scale = resources.displayMetrics.scaledDensity
        v.ivC1.cameraDistance = 8000 * scale
        v.ivC1b.cameraDistance = 8000 * scale
        v.ivC2.cameraDistance = 8000 * scale
        v.ivC2b.cameraDistance = 8000 * scale
        v.ivC3.cameraDistance = 8000 * scale
        v.ivC3b.cameraDistance = 8000 * scale
        v.ivC4.cameraDistance = 8000 * scale
        v.ivC4b.cameraDistance = 8000 * scale
        v.ivC5.cameraDistance = 8000 * scale
        v.ivC5b.cameraDistance = 8000 * scale
        v.ivC6.cameraDistance = 8000 * scale
        v.ivC6b.cameraDistance = 8000 * scale
        v.ivC7.cameraDistance = 8000 * scale
        v.ivC7b.cameraDistance = 8000 * scale
        v.ivC8.cameraDistance = 8000 * scale
        v.ivC8b.cameraDistance = 8000 * scale
        v.ivC9.cameraDistance = 8000 * scale
        v.ivC9b.cameraDistance = 8000 * scale
        v.ivC10.cameraDistance = 8000 * scale
        v.ivC10b.cameraDistance = 8000 * scale

        cardAnimsFront = Array<AnimatorSet>(10) { AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet }
        cardAnimsBack = Array<AnimatorSet>(10) { AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet }

        nums = arrayOfNulls<Int?>(10)

        for (i in 0..9) {
            nums[i] = Random.nextInt(0..77)
            if (i > 0 && nums[i] != null) {
                for (y in 0..i) {
                    if (i == y) continue
                    while (nums[i] == nums[y]) {
                        nums[i] = Random.nextInt(0..77)
                    }
                }
            }
        }

        val util = CardUtil(this)
        util.loadCards()

        cards = Array(10) {
            util.cardList[nums[it]!!]
        }

        v.ivC1b.setOnClickListener{
            v.ivC1.setImageDrawable(AppCompatResources.getDrawable(this, cards[0].art))
            cardAnimsFront[0].setTarget(v.ivC1b)
            cardAnimsBack[0].setTarget(v.ivC1)
            cardAnimsFront[0].start()
            cardAnimsBack[0].start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivC1b.visibility = View.GONE
            }, 1000)
        }

        v.ivC1.setOnLongClickListener{
            util.showDetails(this, cards[0])
            return@setOnLongClickListener true
        }

        v.ivC2b.setOnClickListener{
            v.ivC2.setImageDrawable(AppCompatResources.getDrawable(this, cards[1].art))
            cardAnimsFront[1].setTarget(v.ivC2b)
            cardAnimsBack[1].setTarget(v.ivC2)
            cardAnimsFront[1].start()
            cardAnimsBack[1].start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivC2b.visibility = View.GONE
            }, 1000)
        }

        v.ivC2.setOnLongClickListener{
            util.showDetails(this, cards[1])
            return@setOnLongClickListener true
        }

        v.ivC3b.setOnClickListener{
            v.ivC3.setImageDrawable(AppCompatResources.getDrawable(this, cards[2].art))
            cardAnimsFront[2].setTarget(v.ivC3b)
            cardAnimsBack[2].setTarget(v.ivC3)
            cardAnimsFront[2].start()
            cardAnimsBack[2].start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivC3b.visibility = View.GONE
            }, 1000)
        }

        v.ivC3.setOnLongClickListener{
            util.showDetails(this, cards[2])
            return@setOnLongClickListener true
        }

        v.ivC4b.setOnClickListener{
            v.ivC4.setImageDrawable(AppCompatResources.getDrawable(this, cards[3].art))
            cardAnimsFront[3].setTarget(v.ivC4b)
            cardAnimsBack[3].setTarget(v.ivC4)
            cardAnimsFront[3].start()
            cardAnimsBack[3].start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivC4b.visibility = View.GONE
            }, 1000)
        }

        v.ivC4.setOnLongClickListener{
            util.showDetails(this, cards[3])
            return@setOnLongClickListener true
        }

        v.ivC5b.setOnClickListener{
            v.ivC5.setImageDrawable(AppCompatResources.getDrawable(this, cards[4].art))
            cardAnimsFront[4].setTarget(v.ivC5b)
            cardAnimsBack[4].setTarget(v.ivC5)
            cardAnimsFront[4].start()
            cardAnimsBack[4].start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivC5b.visibility = View.GONE
            }, 1000)
        }

        v.ivC5.setOnLongClickListener{
            util.showDetails(this, cards[4])
            return@setOnLongClickListener true
        }

        v.ivC6b.setOnClickListener{
            v.ivC6.setImageDrawable(AppCompatResources.getDrawable(this, cards[5].art))
            cardAnimsFront[5].setTarget(v.ivC6b)
            cardAnimsBack[5].setTarget(v.ivC6)
            cardAnimsFront[5].start()
            cardAnimsBack[5].start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivC6b.visibility = View.GONE
            }, 1000)
        }

        v.ivC6.setOnLongClickListener{
            util.showDetails(this, cards[5])
            return@setOnLongClickListener true
        }

        v.ivC7b.setOnClickListener{
            v.ivC7.setImageDrawable(AppCompatResources.getDrawable(this, cards[6].art))
            cardAnimsFront[6].setTarget(v.ivC7b)
            cardAnimsBack[6].setTarget(v.ivC7)
            cardAnimsFront[6].start()
            cardAnimsBack[6].start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivC7b.visibility = View.GONE
            }, 1000)
        }

        v.ivC7.setOnLongClickListener{
            util.showDetails(this, cards[6])
            return@setOnLongClickListener true
        }

        v.ivC8b.setOnClickListener{
            v.ivC8.setImageDrawable(AppCompatResources.getDrawable(this, cards[7].art))
            cardAnimsFront[7].setTarget(v.ivC8b)
            cardAnimsBack[7].setTarget(v.ivC8)
            cardAnimsFront[7].start()
            cardAnimsBack[7].start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivC8b.visibility = View.GONE
            }, 1000)
        }

        v.ivC8.setOnLongClickListener{
            util.showDetails(this, cards[7])
            return@setOnLongClickListener true
        }

        v.ivC9b.setOnClickListener{
            v.ivC9.setImageDrawable(AppCompatResources.getDrawable(this, cards[8].art))
            cardAnimsFront[8].setTarget(v.ivC9b)
            cardAnimsBack[8].setTarget(v.ivC9)
            cardAnimsFront[8].start()
            cardAnimsBack[8].start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivC9b.visibility = View.GONE
            }, 1000)
        }

        v.ivC9.setOnLongClickListener{
            util.showDetails(this, cards[8])
            return@setOnLongClickListener true
        }

        v.ivC10b.setOnClickListener{
            v.ivC10.setImageDrawable(AppCompatResources.getDrawable(this, cards[9].art))
            cardAnimsFront[9].setTarget(v.ivC10b)
            cardAnimsBack[9].setTarget(v.ivC10)
            cardAnimsFront[9].start()
            cardAnimsBack[9].start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivC10b.visibility = View.GONE
            }, 1000)
        }

        v.ivC10.setOnLongClickListener{
            util.showDetails(this, cards[9])
            return@setOnLongClickListener true
        }

        Toast.makeText(this, "Tap to flip - Hold to read", Toast.LENGTH_SHORT).show()

        setContentView(v.root)
    }
}