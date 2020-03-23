package com.example.studentportal

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter(private val portals: List<Portal>) : RecyclerView.Adapter<PortalAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(portal: Portal) {
            itemView.btnPortal.text = "${portal.title}\n${portal.portalUrl}"
            itemView.btnPortal.setOnClickListener {
                val builder = Builder()
                val portalIntent = builder.build()
                portalIntent.launchUrl(itemView.context, Uri.parse(portal.portalUrl))
            }
        }

    }
    /**
     * Creates and returns a ViewHolder object, inflating the layout called item_reminder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount() = portals.size

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: PortalAdapter.ViewHolder, position: Int) {
       ( holder).bind(portals[position])
    }
}