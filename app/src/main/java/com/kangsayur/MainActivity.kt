package com.kangsayur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kangsayur.fragment.AkunFragment
import com.kangsayur.fragment.BerandaFragment
import com.kangsayur.fragment.KeranjangFragment
import com.kangsayur.fragment.PesananFragment



class MainActivity : AppCompatActivity() {


    private val fragmentBeranda:Fragment = BerandaFragment()
    private val fragmentKeranjang:Fragment = KeranjangFragment()
    private val fragmentPesanan:Fragment = PesananFragment()
    private val fragmentAkun:Fragment = AkunFragment()
    private val fm:FragmentManager = supportFragmentManager
    private var active:Fragment = fragmentBeranda

    private lateinit var menu:Menu
    private lateinit var menuItem:MenuItem
    private lateinit var bottomNavigationView:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fm.beginTransaction().add(R.id.container,fragmentBeranda).show(fragmentBeranda).commit()
        fm.beginTransaction().add(R.id.container,fragmentKeranjang).hide(fragmentKeranjang).commit()
        fm.beginTransaction().add(R.id.container,fragmentPesanan).hide(fragmentPesanan).commit()
        fm.beginTransaction().add(R.id.container,fragmentAkun).hide(fragmentAkun).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true
        bottomNavigationView.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.navigation_beranda ->{
                    pilih(0,fragmentBeranda)
                }
                R.id.navigation_keranjang ->{
                    pilih(1,fragmentKeranjang)
                }
                R.id.navigation_pesanan ->{
                    pilih(2,fragmentPesanan)
                }
                R.id.navigation_akun ->{
                    pilih(3,fragmentAkun)
                }
            }
            false
        }
    }

    fun pilih(int:Int,fragment:Fragment){
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active=fragment
    }
}