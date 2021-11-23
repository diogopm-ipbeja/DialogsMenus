package pt.ipbeja.dialogsmenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.activity -> {
                Toast.makeText(this, "Activity 1 pressed", Toast.LENGTH_SHORT).show()

                // In most cases, we will return true if the event was consumed
                return true
            }
            R.id.activity2 -> {
                Toast.makeText(this, "Activity 2 pressed", Toast.LENGTH_SHORT).show()
                // We can say the event was NOT consumed and pass it down the tree (see below)
                // return false // optional because we're calling super at the end of this function
            }

        }
        // If neither event was consumed, let's pass it down the tree (to fragments)
        return super.onOptionsItemSelected(item)
    }
}