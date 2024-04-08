package com.example.labtest2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.MediaController

import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val resultButton = findViewById<Button>(R.id.result)
        val pointsButton = findViewById<Button>(R.id.points)
        val statsButton = findViewById<Button>(R.id.sats)
        val teamsButton = findViewById<Button>(R.id.teams)

        resultButton.setOnClickListener {
            // Replace with the desired URL
            val url = "https://www.iplt20.com/matches/fixtures"
            openWebsite(url)
        }

        pointsButton.setOnClickListener {
            // Replace with the desired URL
            val url = "https://www.iplt20.com/points-table/2024"
            openWebsite(url)
        }

        statsButton.setOnClickListener {
            // Replace with the desired URL
            val url = "https://www.iplt20.com/stats/2024"
            openWebsite(url)
        }

        teamsButton.setOnClickListener {
            // Replace with the desired URL
            val url = "https://www.iplt20.com/teams"
            openWebsite(url)
        }

        val videoView = findViewById<VideoView>(R.id.videoView)

        val mediaController = MediaController(this)

        val pathOfVideo = Uri.parse("android.resource://$packageName/${R.raw.intro}")

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(pathOfVideo)
        videoView.requestFocus()
        videoView.start()



        val imageView1 = findViewById<ImageView>(R.id.koli)

        imageView1.setOnClickListener {
            // Create and show the BottomSheetFragment
            val bottomSheetFragment = Koli.newInstance()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }

// Set scale type for imageView1 to fitCenter
        imageView1.scaleType = ImageView.ScaleType.FIT_CENTER

        val imageView2 = findViewById<ImageView>(R.id.shikar)

        imageView2.setOnClickListener {
            // Create and show the BottomSheetFragment
            val bottomSheetFragment = Shikar.newInstance()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }

// Set scale type for imageView2 to fitCenter
        imageView2.scaleType = ImageView.ScaleType.FIT_CENTER

        val imageView3 = findViewById<ImageView>(R.id.david)

        imageView3.setOnClickListener {
            // Create and show the BottomSheetFragment
            val bottomSheetFragment = David.newInstance()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }

// Set scale type for imageView3 to fitCenter
        imageView3.scaleType = ImageView.ScaleType.FIT_CENTER

        val imageView4 = findViewById<ImageView>(R.id.kl)

        imageView4.setOnClickListener {
            // Create and show the BottomSheetFragment
            val bottomSheetFragment = Klrahul.newInstance()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
        }

// Set scale type for imageView4 to fitCenter
        imageView4.scaleType = ImageView.ScaleType.FIT_CENTER

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                // Handle menu item 1 click
                openWebsite("https://www.iplt20.com/about/about-us")
                return true
            }
            R.id.action_photo -> {
                // Handle menu item 2 click
                openWebsite("https://www.iplt20.com/photos")
                return true
            }
            // Add cases for other menu items if needed
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
