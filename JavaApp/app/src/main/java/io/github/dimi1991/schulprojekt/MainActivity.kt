package io.github.dimi1991.schulprojekt

import android.os.Bundle
import android.util.AttributeSet
import android.util.Xml
import android.view.Menu
import android.view.MenuItem
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import io.github.dimi1991.schulprojekt.Model.Device
import kotlinx.android.synthetic.main.activity_main.*
import org.xmlpull.v1.XmlPullParser


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

    private fun appendToTable(devices: List<Device>){
        for(dev in devices){
           /* var row = TableRow(this.applicationContext)
            row.layoutParams.height = TableRow.LayoutParams.MATCH_PARENT
            row.layoutParams.width = TableRow.LayoutParams.MATCH_PARENT

            /*
            <TextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:padding="10"
                        android:text="Nächste Wartung"
                        android:textAppearance="@style/TextAppearance.AppCompat.Large" />
             */
            val parser: XmlPullParser = resources.getXml(@attr.)
            val attributes = Xml.asAttributeSet(parser)
            var attributeSet = AttributeSet.let()
            var textTemplate = TextView(this.applicationContext)
            textTemplate.layout.width = 3
*/
        }
    }
}
