package com.moonsoft.afetapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.moonsoft.afetapp.R

class MapsFragment : Fragment() {
    var mMapView: MapView? = null
    private var googleMap: GoogleMap? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.fragment_maps, container, false)
        mMapView = rootView.findViewById<View>(R.id.mapView) as MapView
        mMapView!!.onCreate(savedInstanceState)
        mMapView!!.onResume()
        try {
            MapsInitializer.initialize(requireContext())
        } catch (e: Exception) {
            e.printStackTrace()
        }
        mMapView!!.getMapAsync { mMap ->
            googleMap = mMap
            with(arguments){
                this?.getDouble(DepremFragment.lat)?.let { lat->
                    this.getDouble(DepremFragment.lng).let { lng->
                        val sydney = LatLng(lat, lng)
                        googleMap!!.addMarker(
                            MarkerOptions().position(sydney).title("Deprem Bölgesi")
                        )
                        val cameraPosition = CameraPosition.Builder().target(sydney).zoom(6f).build()
                        googleMap!!.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
                    }
                }
            }
        }
        return rootView
    }
}