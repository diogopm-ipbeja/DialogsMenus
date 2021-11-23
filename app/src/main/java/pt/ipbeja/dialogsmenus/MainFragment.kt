package pt.ipbeja.dialogsmenus

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import pt.ipbeja.dialogsmenus.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) // Important: This flag must be set to enable menus in fragments!
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = MainFragmentBinding.inflate(inflater).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.menuFragmentBtn.setOnClickListener {
            findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToMenuFragment())
        }

        binding.dialogFragmentBtn.setOnClickListener {
            findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToDialogDemoFragment())
        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_fragment, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fragment_menu_1, R.id.fragment_menu_2 -> {
                Snackbar.make(requireView(), item.title, Snackbar.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}