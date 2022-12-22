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
import com.djustice.tarot.databinding.ActivityFourCardBinding
import kotlin.random.Random

class FourCard : Activity() {

    private lateinit var card1: Card
    private lateinit var card2: Card
    private lateinit var card3: Card
    private lateinit var card4: Card

    private lateinit var card1animf: AnimatorSet
    private lateinit var card1animb: AnimatorSet
    private lateinit var card2animf: AnimatorSet
    private lateinit var card2animb: AnimatorSet
    private lateinit var card3animf: AnimatorSet
    private lateinit var card3animb: AnimatorSet
    private lateinit var card4animf: AnimatorSet
    private lateinit var card4animb: AnimatorSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = ActivityFourCardBinding.inflate(layoutInflater)

        var scale = resources.displayMetrics.scaledDensity
        v.ivFour1.cameraDistance = 8000 * scale
        v.ivFour1b.cameraDistance = 8000 * scale
        v.ivFour2.cameraDistance = 8000 * scale
        v.ivFour2b.cameraDistance = 8000 * scale
        v.ivFour3.cameraDistance = 8000 * scale
        v.ivFour3b.cameraDistance = 8000 * scale
        v.ivFour4.cameraDistance = 8000 * scale
        v.ivFour4b.cameraDistance = 8000 * scale

        card1animf = AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet
        card1animb = AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet
        card2animf = AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet
        card2animb = AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet
        card3animf = AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet
        card3animb = AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet
        card4animf = AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet
        card4animb = AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet

        val num1 = Random.nextInt(0, 77)
        var num2 = Random.nextInt(0, 77)
        var num3 = Random.nextInt(0, 77)
        var num4 = Random.nextInt(0, 77)
        while (num2 == num1) { num2 = Random.nextInt(0,77) }
        while (num3 == num1) { num3 = Random.nextInt(0,77) }
        while (num3 == num2) { num3 = Random.nextInt(0,77) }
        while (num4 == num1) { num4 = Random.nextInt(0,77) }
        while (num4 == num2) { num4 = Random.nextInt(0,77) }
        while (num4 == num3) { num4 = Random.nextInt(0,77) }

        val util = CardUtil(this)
        util.loadCards()

        card1 = util.cardList[num1]
        card2 = util.cardList[num2]
        card3 = util.cardList[num3]
        card4 = util.cardList[num4]

        v.ivFour1b.setOnClickListener{
            v.ivFour1.setImageDrawable(AppCompatResources.getDrawable(this, card1.art))
            card1animf.setTarget(v.ivFour1b)
            card1animb.setTarget(v.ivFour1)
            card1animf.start()
            card1animb.start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivFour1b.visibility = View.GONE
            }, 1000)
        }

        v.ivFour1.setOnLongClickListener{
            util.showDetails(this, card1)
            return@setOnLongClickListener true
        }

        v.ivFour2b.setOnClickListener{
            v.ivFour2.setImageDrawable(AppCompatResources.getDrawable(this, card2.art))
            card2animf.setTarget(v.ivFour2b)
            card2animb.setTarget(v.ivFour2)
            card2animf.start()
            card2animb.start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivFour2b.visibility = View.GONE
            }, 1000)
        }

        v.ivFour2.setOnLongClickListener{
            util.showDetails(this, card2)
            return@setOnLongClickListener true
        }

        v.ivFour3b.setOnClickListener{
            v.ivFour3.setImageDrawable(AppCompatResources.getDrawable(this, card3.art))
            card3animf.setTarget(v.ivFour3b)
            card3animb.setTarget(v.ivFour3)
            card3animf.start()
            card3animb.start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivFour3b.visibility = View.GONE
            }, 1000)
        }

        v.ivFour3.setOnLongClickListener{
            util.showDetails(this, card3)
            return@setOnLongClickListener true
        }

        v.ivFour4b.setOnClickListener{
            v.ivFour4.setImageDrawable(AppCompatResources.getDrawable(this, card4.art))
            card4animf.setTarget(v.ivFour4b)
            card4animb.setTarget(v.ivFour4)
            card4animf.start()
            card4animb.start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivFour4b.visibility = View.GONE
            }, 1000)
        }

        v.ivFour4.setOnLongClickListener{
            util.showDetails(this, card4)
            return@setOnLongClickListener true
        }

        Toast.makeText(this, "Tap to flip - Hold to read", Toast.LENGTH_SHORT).show()

        setContentView(v.root)
    }
}