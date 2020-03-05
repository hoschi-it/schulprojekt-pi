package io.github.dimi1991.schulprojekt.View

import android.content.Context
import android.util.AttributeSet
import android.widget.TableLayout
import android.widget.TableRow
import android.app.Application;
import android.view.View
import io.github.dimi1991.schulprojekt.Model.Device
import io.github.dimi1991.schulprojekt.R
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_devlist.view.*

class DeviceTable : View {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int)
            : super(context, attributeSet, defStyleAttr)


    fun Append(devices: List<Device>){
        for(dev in devices) {
            val row = generateRow(dev)
            devicesTable.addView(row)
        }
    }

    private fun generateRow(device: Device): TableRow{
        var row = emptyRow
        row.visibility = TableRow.VISIBLE

    }
}