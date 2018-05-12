package tw.andyang.designpattern.adapter

import com.mapbox.mapboxsdk.camera.CameraUpdateFactory
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapboxMap
import com.mapbox.mapboxsdk.maps.SupportMapFragment

class MapBoxAdapter(private val mapFragment: SupportMapFragment) : MapAdapter {

    private lateinit var mapboxMap: MapboxMap

    override var onMapReadyCallBack: () -> Unit = {}

    override fun initMap() {
        mapFragment.getMapAsync {
            mapboxMap = it
            onMapReadyCallBack.invoke()
        }
    }

    override fun moveCamera(lat: Double, lng: Double, zoomLevel: Double) {
        mapboxMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(lat, lng), zoomLevel))
    }

}
