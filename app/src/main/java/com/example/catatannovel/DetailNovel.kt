package com.example.catatannovel

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

@Suppress("DEPRECATION")
class DetailNovel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_novel)

        val novel = intent.getParcelableExtra<Novel>("NOVEL_DATA")
        novel?.let {
            val imgPhoto = findViewById<ImageView>(R.id.img_item_photo)
            val tvName = findViewById<TextView>(R.id.tv_item_name)
            val tvAuthor = findViewById<TextView>(R.id.tv_item_author)
            val tvDescription = findViewById<TextView>(R.id.tv_item_description)
            val btnShareInstagram = findViewById<Button>(R.id.btn_share_instagram)

            Glide.with(this)
                .load(novel.photo)
                .into(imgPhoto)
            tvName.text = novel.name
            tvAuthor.text = novel.author
            tvDescription.text = novel.description

            btnShareInstagram.setOnClickListener {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "image/*"  // Set tipe konten yang akan dibagikan, dalam hal ini gambar
                val imageUri = Uri.parse(novel.photo)  // Ganti dengan URI gambar yang ingin Anda bagikan
                shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri)

                // Menggunakan package name Instagram
                shareIntent.setPackage("com.instagram.android")

                try {
                    startActivity(shareIntent)
                } catch (e: ActivityNotFoundException) {
                    // Handle jika Instagram tidak terinstall
                    Toast.makeText(this, "Instagram tidak terinstall.", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}