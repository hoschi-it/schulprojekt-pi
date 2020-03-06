package io.github.dimi1991.schulprojekt.Model

import java.util.*

class Device(
    var Name: String = "",
    private var _nextMaintenance: Date,
    var Location: Location
){

    fun NextMaintenanceString(): String {
        return "" + _nextMaintenance.year + "-" + _nextMaintenance.month +
                "-" + _nextMaintenance.day
    }

}