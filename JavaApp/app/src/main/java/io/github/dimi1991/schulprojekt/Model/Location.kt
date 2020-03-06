package io.github.dimi1991.schulprojekt.Model
import com.google.gson.annotations.SerializedName;

class Location(
    @SerializedName("city")
    var City: String,
    @SerializedName("postal_code")
    var PostalCode: String = "",
    @SerializedName("street")
    var Street: String = "",
    @SerializedName("room_no")
    var RoomNumber: String = ""
)