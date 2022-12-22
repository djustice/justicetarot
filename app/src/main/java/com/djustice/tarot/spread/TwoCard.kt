package com.djustice.tarot.spread

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.djustice.tarot.databinding.ActivityTwoCardBinding
import android.view.ViewTreeObserver.OnGlobalLayoutListener

import android.view.ViewTreeObserver
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.djustice.tarot.R
import com.djustice.tarot.card.Card
import com.djustice.tarot.card.CardUtil
import kotlin.random.Random


class TwoCard : Activity() {

    private lateinit var card1: Card
    private lateinit var card2: Card

    private lateinit var card1animf: AnimatorSet
    private lateinit var card1animb: AnimatorSet
    private lateinit var card2animf: AnimatorSet
    private lateinit var card2animb: AnimatorSet
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val v = ActivityTwoCardBinding.inflate(layoutInflater)

        var scale = resources.displayMetrics.scaledDensity
        v.ivTwoCard1.cameraDistance = 8000 * scale
        v.ivTwoCard1b.cameraDistance = 8000 * scale
        v.ivTwoCard2.cameraDistance = 8000 * scale
        v.ivTwoCard2b.cameraDistance = 8000 * scale

        card1animf = AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet
        card1animb = AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet
        card2animf = AnimatorInflater.loadAnimator(this, R.animator.flip_front) as AnimatorSet
        card2animb = AnimatorInflater.loadAnimator(this, R.animator.flip_back) as AnimatorSet

        val num1 = Random.nextInt(0, 77)
        var num2 = Random.nextInt(0, 77)
        while (num1 == num2) { num2 = Random.nextInt(0,77) }
        val util = CardUtil(this)
        util.loadCards()
        card1 = util.cardList[num1]
        card2 = util.cardList[num2]

        v.ivTwoCard1b.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.card_back))
        v.ivTwoCard2b.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.card_back))

        v.ivTwoCard1b.setOnClickListener{
            v.ivTwoCard1.setImageDrawable(AppCompatResources.getDrawable(this, card1.art))
            card1animf.setTarget(v.ivTwoCard1b)
            card1animb.setTarget(v.ivTwoCard1)
            card1animf.start()
            card1animb.start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivTwoCard1b.visibility = View.GONE
            }, 1000)
        }

        v.ivTwoCard1.setOnLongClickListener{
            util.showDetails(this, card1)
            return@setOnLongClickListener true
        }

        v.ivTwoCard2b.setOnClickListener{
            v.ivTwoCard2.setImageDrawable(AppCompatResources.getDrawable(this, card2.art))
            card2animf.setTarget(v.ivTwoCard2b)
            card2animb.setTarget(v.ivTwoCard2)
            card2animf.start()
            card2animb.start()
            Handler(Looper.getMainLooper()).postDelayed({
                v.ivTwoCard2b.visibility = View.GONE
            }, 1000)
        }

        v.ivTwoCard2.setOnLongClickListener{
            util.showDetails(this, card2)
            return@setOnLongClickListener true
        }

        Toast.makeText(this, "Tap to flip - Hold to read", Toast.LENGTH_SHORT).show()

        setContentView(v.root)
    }
}