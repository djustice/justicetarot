package com.djustice.tarot.reference

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.djustice.tarot.R
import com.djustice.tarot.card.Card
import com.djustice.tarot.card.CardUtil

class DRCupsActivity : Activity() {

    private lateinit var c1: Button
    private lateinit var c2: Button
    private lateinit var c3: Button
    private lateinit var c4: Button
    private lateinit var c5: Button
    private lateinit var c6: Button
    private lateinit var c7: Button
    private lateinit var c8: Button
    private lateinit var c9: Button
    private lateinit var c10: Button
    private lateinit var c11: Button
    private lateinit var c12: Button
    private lateinit var c13: Button
    private lateinit var c14: Button

    private lateinit var util: CardUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drcups)

        util = CardUtil(this)
        util.loadCards()

        val cupsList: MutableList<Card> = mutableListOf()
        for ( i in 21..35) cupsList.add(util.cardList[i])

        c1 = findViewById(R.id.DRc01Button)
        c1.setOnClickListener { util.showDetails(this, cupsList[1]) }
        c2 = findViewById(R.id.DRc02Button)
        c2.setOnClickListener { util.showDetails(this, cupsList[2]) }
        c3 = findViewById(R.id.DRc03Button)
        c3.setOnClickListener { util.showDetails(this, cupsList[3]) }
        c4 = findViewById(R.id.DRc04Button)
        c4.setOnClickListener { util.showDetails(this, cupsList[4]) }
        c5 = findViewById(R.id.DRc05Button)
        c5.setOnClickListener { util.showDetails(this, cupsList[5]) }
        c6 = findViewById(R.id.DRc06Button)
        c6.setOnClickListener { util.showDetails(this, cupsList[6]) }
        c7 = findViewById(R.id.DRc07Button)
        c7.setOnClickListener { util.showDetails(this, cupsList[7]) }
        c8 = findViewById(R.id.DRc08Button)
        c8.setOnClickListener { util.showDetails(this, cupsList[8]) }
        c9 = findViewById(R.id.DRc09Button)
        c9.setOnClickListener { util.showDetails(this, cupsList[9]) }
        c10 = findViewById(R.id.DRc10Button)
        c10.setOnClickListener { util.showDetails(this, cupsList[10]) }
        c11 = findViewById(R.id.DRc11Button)
        c11.setOnClickListener { util.showDetails(this, cupsList[11]) }
        c12 = findViewById(R.id.DRc12Button)
        c12.setOnClickListener { util.showDetails(this, cupsList[12]) }
        c13 = findViewById(R.id.DRc13Button)
        c13.setOnClickListener { util.showDetails(this, cupsList[13]) }
        c14 = findViewById(R.id.DRc14Button)
        c14.setOnClickListener { util.showDetails(this, cupsList[14]) }
    }
}