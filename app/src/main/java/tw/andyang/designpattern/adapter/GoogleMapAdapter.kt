package tw.andyang.designpattern.adapter

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class GoogleMapAdapter(private val mapFragment: SupportMapFragment) : MapAdapter {

    private lateinit var googleMap: GoogleMap

    override var onMapReadyCallBack: () -> Unit = {}

    override fun initMap() {
        mapFragment.getMapAsync {
            googleMap = it
            onMapReadyCallBack.invoke()
        }
    }

    override fun moveCamera(lat: Double, lng: Double, zoomLevel: Double) {
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.fromLatLngZoom(LatLng(lat, lng), zoomLevel.toFloat())))
    }

}