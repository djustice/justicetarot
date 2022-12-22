package com.djustice.tarot.spread

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.djustice.tarot.R
import com.djustice.tarot.card.Card
import com.djustice.tarot.card.CardUtil
import com.djustice.tarot.databinding.ActivityMercuryRetrogradeBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MercuryRetrograde : Activity() {

    private lateinit var cards: Array<Card>
    private lateinit var cardAnimsFront: Array<AnimatorSet>
    private lateinit var cardAnimsBack: Array<AnimatorSet>
    private lateinit var nums: Array<Int?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = ActivityMercuryRetrogradeBinding.inflate(layoutInflater)

        val scale = resources.displayMetrics.scaledDensity
        v.ivMR1.cameraDistance = 8000 * scale
        v.ivMR1b.cameraDistance = 8000 * scale
        v.ivMR2.cameraDistance = 8000 * scale
        v.ivMR2b.cameraDistance = 8000 * scale
        v.ivMR3.cameraDistance = 8000 * scale
        v.ivMR3b.cameraDistance = 8000 * scale
        v.ivMR4.cameraDistance = 8000 * scale
        v.ivMR4b.cameraDistance = 8000 * scale
        v.ivMR5.cameraDistance = 8000 * scale
        v.ivMR5b.cameraDistance = 8000 * scale
        v.ivMR6.cameraDistance = 8000 * scale
        v.ivMR6b.cameraDistance = 8000 * scale

        cardAnimsFront = Array(6) { AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet }
        cardAnimsBack = Array(6) { AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet }

        nums = arrayOfNulls<Int?>(6)

        for (i in 0..5) {
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

        cards = Array(6) {
            util.cardList[nums[it]!!]
        }

        v.ivMR1b.setOnClickListener{
            v.ivMR1.setImageDrawable(AppCompatResources.getDrawable(this, cards[0].art))
            cardAnimsFront[0].setTarget(v.ivMR1b)
            cardAnimsBack[0].setTarget(v.ivMR1)
            cardAnimsFront[0].start()
            cardAnimsBack[0].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivMR1b.visibility = View.GONE }, 1000)
        }

        v.ivMR1.setOnLongClickListener{
            util.showDetails(this, cards[0])
            return@setOnLongClickListener true
        }

        v.ivMR2b.setOnClickListener{
            v.ivMR2.setImageDrawable(AppCompatResources.getDrawable(this, cards[1].art))
            cardAnimsFront[1].setTarget(v.ivMR2b)
            cardAnimsBack[1].setTarget(v.ivMR2)
            cardAnimsFront[1].start()
            cardAnimsBack[1].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivMR2b.visibility = View.GONE }, 1000)
        }

        v.ivMR2.setOnLongClickListener{
            util.showDetails(this, cards[1])
            return@setOnLongClickListener true
        }

        v.ivMR3b.setOnClickListener{
            v.ivMR3.setImageDrawable(AppCompatResources.getDrawable(this, cards[2].art))
            cardAnimsFront[2].setTarget(v.ivMR3b)
            cardAnimsBack[2].setTarget(v.ivMR3)
            cardAnimsFront[2].start()
            cardAnimsBack[2].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivMR3b.visibility = View.GONE }, 1000)
        }

        v.ivMR3.setOnLongClickListener{
            util.showDetails(this, cards[2])
            return@setOnLongClickListener true
        }

        v.ivMR4b.setOnClickListener{
            v.ivMR4.setImageDrawable(AppCompatResources.getDrawable(this, cards[3].art))
            cardAnimsFront[3].setTarget(v.ivMR4b)
            cardAnimsBack[3].setTarget(v.ivMR4)
            cardAnimsFront[3].start()
            cardAnimsBack[3].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivMR4b.visibility = View.GONE }, 1000)
        }

        v.ivMR4.setOnLongClickListener{
            util.showDetails(this, cards[3])
            return@setOnLongClickListener true
        }

        v.ivMR5b.setOnClickListener{
            v.ivMR5.setImageDrawable(AppCompatResources.getDrawable(this, cards[4].art))
            cardAnimsFront[4].setTarget(v.ivMR5b)
            cardAnimsBack[4].setTarget(v.ivMR5)
            cardAnimsFront[4].start()
            cardAnimsBack[4].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivMR5b.visibility = View.GONE }, 1000)
        }

        v.ivMR5.setOnLongClickListener{
            util.showDetails(this, cards[4])
            return@setOnLongClickListener true
        }

        v.ivMR6b.setOnClickListener{
            v.ivMR6.setImageDrawable(AppCompatResources.getDrawable(this, cards[5].art))
            cardAnimsFront[5].setTarget(v.ivMR6b)
            cardAnimsBack[5].setTarget(v.ivMR6)
            cardAnimsFront[5].start()
            cardAnimsBack[5].start()
            Handler(Looper.getMainLooper()).postDelayed({ v.ivMR6b.visibility = View.GONE }, 1000)
        }

        v.ivMR6.setOnLongClickListener{
            util.showDetails(this, cards[5])
            return@setOnLongClickListener true
        }

        Toast.makeText(this, "Tap to flip - Hold to read", Toast.LENGTH_SHORT).show()

        setContentView(v.root)
    }
}