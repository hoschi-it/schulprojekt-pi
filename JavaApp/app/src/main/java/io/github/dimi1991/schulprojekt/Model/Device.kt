package io.github.dimi1991.schulprojekt.Model

import java.text.SimpleDateFormat
import java.util.*

class Device(
    var Name: String = "",
    private var _nextMaintenance: GregorianCalendar,
    var Location: Location
){

    fun NextMaintenanceString(): String {
        val format = SimpleDateFormat("yyyy-MM-dd")

        val year = _nextMaintenance.get(Calendar.YEAR)
        val month = _nextMaintenance.get(Calendar.MONTH)
        val day = _nextMaintenance.get(Calendar.DAY_OF_MONTH)
        return format.format(_nextMaintenance.time)
    }

}