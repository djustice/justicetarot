package com.djustice.tarot.reference

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.djustice.tarot.R
import com.djustice.tarot.card.CardUtil

class DRArcanaActivity : Activity() {
    private lateinit var a0: Button
    private lateinit var a1: Button
    private lateinit var a2: Button
    private lateinit var a3: Button
    private lateinit var a4: Button
    private lateinit var a5: Button
    private lateinit var a6: Button
    private lateinit var a7: Button
    private lateinit var a8: Button
    private lateinit var a9: Button
    private lateinit var a10: Button
    private lateinit var a11: Button
    private lateinit var a12: Button
    private lateinit var a13: Button
    private lateinit var a14: Button
    private lateinit var a15: Button
    private lateinit var a16: Button
    private lateinit var a17: Button
    private lateinit var a18: Button
    private lateinit var a19: Button
    private lateinit var a20: Button
    private lateinit var a21: Button

    private lateinit var util: CardUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drarcana)

        util = CardUtil(this)
        util.loadCards()

        a0 = findViewById(R.id.DRa00Button)
        a0.setOnClickListener { util.showDetails(this, util.cardList[0]) }
        a1 = findViewById(R.id.DRa01Button)
        a1.setOnClickListener { util.showDetails(this, util.cardList[1]) }
        a2 = findViewById(R.id.DRa02Button)
        a2.setOnClickListener { util.showDetails(this, util.cardList[2]) }
        a3 = findViewById(R.id.DRa03Button)
        a3.setOnClickListener { util.showDetails(this, util.cardList[3]) }
        a4 = findViewById(R.id.DRa04Button)
        a4.setOnClickListener { util.showDetails(this, util.cardList[4]) }
        a5 = findViewById(R.id.DRa05Button)
        a5.setOnClickListener { util.showDetails(this, util.cardList[5]) }
        a6 = findViewById(R.id.DRa06Button)
        a6.setOnClickListener { util.showDetails(this, util.cardList[6]) }
        a7 = findViewById(R.id.DRa07Button)
        a7.setOnClickListener { util.showDetails(this, util.cardList[7]) }
        a8 = findViewById(R.id.DRa08Button)
        a8.setOnClickListener { util.showDetails(this, util.cardList[8]) }
        a9 = findViewById(R.id.DRa09Button)
        a9.setOnClickListener { util.showDetails(this, util.cardList[9]) }
        a10 = findViewById(R.id.DRa10Button)
        a10.setOnClickListener { util.showDetails(this, util.cardList[10]) }
        a11 = findViewById(R.id.DRa11Button)
        a11.setOnClickListener { util.showDetails(this, util.cardList[11]) }
        a12 = findViewById(R.id.DRa12Button)
        a12.setOnClickListener { util.showDetails(this, util.cardList[12]) }
        a13 = findViewById(R.id.DRa13Button)
        a13.setOnClickListener { util.showDetails(this, util.cardList[13]) }
        a14 = findViewById(R.id.DRa14Button)
        a14.setOnClickListener { util.showDetails(this, util.cardList[14]) }
        a15 = findViewById(R.id.DRa15Button)
        a15.setOnClickListener { util.showDetails(this, util.cardList[15]) }
        a16 = findViewById(R.id.DRa16Button)
        a16.setOnClickListener { util.showDetails(this, util.cardList[16]) }
        a17 = findViewById(R.id.DRa17Button)
        a17.setOnClickListener { util.showDetails(this, util.cardList[17]) }
        a18 = findViewById(R.id.DRa18Button)
        a18.setOnClickListener { util.showDetails(this, util.cardList[18]) }
        a19 = findViewById(R.id.DRa19Button)
        a19.setOnClickListener { util.showDetails(this, util.cardList[19]) }
        a20 = findViewById(R.id.DRa20Button)
        a20.setOnClickListener { util.showDetails(this, util.cardList[20]) }
        a21 = findViewById(R.id.DRa21Button)
        a21.setOnClickListener { util.showDetails(this, util.cardList[21]) }

    }
}