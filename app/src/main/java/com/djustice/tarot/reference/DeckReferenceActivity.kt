package com.djustice.tarot.reference

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.djustice.tarot.databinding.ActivityDeckReferenceBinding

class DeckReferenceActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val v = ActivityDeckReferenceBinding.inflate(layoutInflater)

        v.drArcanaButton.setOnClickListener{
            val intent = Intent(this, DRArcanaActivity::class.java)
            startActivity(intent)
        }

        v.drCupsButton.setOnClickListener{
            val intent = Intent(this, DRCupsActivity::class.java)
            startActivity(intent)
        }

        v.drDisksButton.setOnClickListener{
            val intent = Intent(this, DRDisksActivity::class.java)
            startActivity(intent)
        }

        v.drSwordsButton.setOnClickListener{
            val intent = Intent(this, DRSwordsActivity::class.java)
            startActivity(intent)
        }

        v.drWandsButton.setOnClickListener{
            val intent = Intent(this, DRWandsActivity::class.java)
            startActivity(intent)
        }

        setContentView(v.root)
    }
}