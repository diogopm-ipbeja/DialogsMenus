package pt.ipbeja.dialogsmenus

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import pt.ipbeja.dialogsmenus.databinding.MainFragmentBinding
import pt.ipbeja.dialogsmenus.databinding.MenuFragmentBinding

class MenuFragment : Fragment() {


    private lateinit var binding: MenuFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = MenuFragmentBinding.inflate(inflater).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.fragment_menu_1 -> {
                Snackbar.make(requireView(), "On Menu Fragment 1 clicked", Snackbar.LENGTH_SHORT).show()
                return true
            }
            R.id.fragment_menu_2 -> {
                Snackbar.make(requireView(), "On Menu Fragment 2 clicked", Snackbar.LENGTH_SHORT)
                    .show()
                return true
            }
            R.id.activity2 -> {
                Snackbar.make(requireView(), "Fragment consumed activity menu event", Snackbar.LENGTH_LONG)
                    .show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}