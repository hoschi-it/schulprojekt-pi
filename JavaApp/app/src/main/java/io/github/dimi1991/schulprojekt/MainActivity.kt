package io.github.dimi1991.schulprojekt

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import io.github.dimi1991.schulprojekt.Controller.DataProvider
import io.github.dimi1991.schulprojekt.Model.Device
import io.github.dimi1991.schulprojekt.Model.Location
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.devicelist.*
import kotlinx.coroutines.*
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
        GlobalScope.launch {
            loadTable(true)
        }

    }

    private suspend fun loadTable(isExampleData: Boolean){
        var url = "https://4b3aed5b-8e45-42a4-af81-64863036e153.mock.pstmn.io"
        var provider : DataProvider
        var devices: List<Device>

        if(isExampleData){
            provider = DataProvider(isExampleData = true)
            devices = provider.getAllDevices()
        } else {
            provider  = DataProvider(url)
            val job = GlobalScope.async { provider.getAllDevices() }
            devices = job.await()
        }
        makeRows(devices)
    }

    fun makeRows(devices: List<Device>) {
        for(device in devices) {
            val tvDeviceName = generateTextView(device.Name)
            val tvNextMaintenance = generateTextView(device.NextMaintenanceString())
            val tvCity = generateTextView(device.Location.City)
            var row = TableRow(devicesTable.context)
            row.addView(tvDeviceName)
            row.addView(tvNextMaintenance)
            row.addView(tvCity)

            devicesTable.addView(row, TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT))
        }
    }

    private fun generateTextView(text: String) : TextView {
        var view = TextView(this)
        view.setPadding(10, 10, 10, 10)
        view.text = text
        return view
    }
}
