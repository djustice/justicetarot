package com.djustice.tarot

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.djustice.tarot.databinding.ActivityMainBinding
import com.djustice.tarot.reference.DeckReferenceActivity
import com.djustice.tarot.spread.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val v = ActivityMainBinding.inflate(layoutInflater)

        v.pivBackground.setMargins(500, 350)
        v.pivBackground.setMultipliers(2.5f, 3.0f)

        v.deckReferenceButton.setOnClickListener{
            val intent = Intent(this, DeckReferenceActivity::class.java)
            startActivity(intent)
        }

        v.singleCardButton.setOnClickListener {
            val intent = Intent(this, SingleCard::class.java)
            startActivity(intent)
        }

        v.twoCardButton.setOnClickListener {
            val intent = Intent(this, TwoCard::class.java)
            startActivity(intent)
        }

        v.pastPresentFutureButton.setOnClickListener {
            val intent = Intent(this, PastPresentFuture::class.java)
            startActivity(intent)
        }

        v.fourCardButton.setOnClickListener {
            val intent = Intent(this, FourCard::class.java)
            startActivity(intent)
        }

        v.relationshipSpreadButton.setOnClickListener {
            val intent = Intent(this, Relationship::class.java)
            startActivity(intent)
        }

        v.celticCrossButton.setOnClickListener {
            val intent = Intent(this, CelticCross::class.java)
            startActivity(intent)
        }

        v.newYearButton.setOnClickListener {
            val intent = Intent(this, NewYear::class.java)
            startActivity(intent)
        }

        v.moonButton.setOnClickListener {
            val intent = Intent(this, Moon::class.java)
            startActivity(intent)
        }

        v.mercuryRetrogradeButton.setOnClickListener {
            val intent = Intent(this, MercuryRetrograde::class.java)
            startActivity(intent)
        }

        setContentView(v.root)
    }
}
