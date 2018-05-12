package tw.andyang.designpattern.adapter

interface MapAdapter {
    var onMapReadyCallBack: () -> Unit
    fun initMap()
    fun moveCamera(lat: Double, lng: Double, zoomLevel: Double)
}