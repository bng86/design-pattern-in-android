package tw.andyang.designpattern.adapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import tw.andyang.designpattern.R

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        using google map sdk
        val mapAdapter = createGoogleMapAdapter()
//        using mapbox sdk
//        val mapAdapter = createMapBoxAdapter()

        mapAdapter.initMap()
        mapAdapter.onMapReadyCallBack = {
            Toast.makeText(this, "map init ready", Toast.LENGTH_LONG).show()
            mapAdapter.moveCamera(25.031179, 121.528408, 19.0)
        }
    }

    private fun createGoogleMapAdapter(): MapAdapter {
        setContentView(R.layout.activity_google_map)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as com.google.android.gms.maps.SupportMapFragment
        return GoogleMapAdapter(mapFragment)
    }

    private fun createMapBoxAdapter(): MapAdapter {
        setContentView(R.layout.activity_mapbox)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as com.mapbox.mapboxsdk.maps.SupportMapFragment
        return MapBoxAdapter(mapFragment)
    }
}
