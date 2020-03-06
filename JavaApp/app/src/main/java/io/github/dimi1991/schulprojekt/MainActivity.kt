package io.github.dimi1991.schulprojekt

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.AttributeSet
import android.util.Xml
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import com.google.android.material.snackbar.Snackbar
import io.github.dimi1991.schulprojekt.Model.Device
import io.github.dimi1991.schulprojekt.Model.Location
import io.github.dimi1991.schulprojekt.View.DeviceTable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.xmlpull.v1.XmlPullParser
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        testTable()
    }

    private fun testTable(){
        label.text = "_"
        var devs = listOf<Device>(
            Device("FritzBox 12340", Date(2020, 20, 2), Location("Buxtehude"))
        )
        MakeRows(devs)
        label.text = label.text.toString() + "-"
    }



    fun MakeRows(devices: List<Device>) {
        setContentView(R.layout.activity_main)
        for(dev in devices) {
            generateRow(dev)
        }
    }

    private fun generateRow(device: Device) {
        val tvDeviceName = generateTextView(device.Name)
        val tvNextMaintenance = generateTextView(device.NextMaintenanceString())
        val tvCity = generateTextView(device.Location.City)
        var row = TableRow(devicesTable.context)
        row.addView(tvDeviceName)
        row.addView(tvNextMaintenance)
        row.addView(tvCity)


        devicesTable.addView(generateTextView("test"), 1)
        devicesTable.addView(row, 2)
    }

    private fun generateTextView(text: String) : TextView {
        var view = TextView(this)
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        view.setPadding(10, 10, 10, 10)
        view.text = text
        return view
    }
}
