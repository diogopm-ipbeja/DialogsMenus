package pt.ipbeja.dialogsmenus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import pt.ipbeja.dialogsmenus.databinding.DialogDemoFragmentBinding

class DialogDemoFragment : Fragment() {

    private lateinit var items: Array<String>
    private lateinit var binding: DialogDemoFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DialogDemoFragmentBinding.inflate(inflater).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        items = resources.getStringArray(R.array.dialog_items)

        binding.basic.setOnClickListener(::onBasicClicked)
        binding.items.setOnClickListener(::onItemsDialogClicked)
        binding.singleChoice.setOnClickListener(::onSingleChoiceDialogClicked)
        binding.multiChoice.setOnClickListener(::onMultiChoiceDialogClicked)
    }

    private fun onBasicClicked(view: View) {
        AlertDialog.Builder(requireContext())
            .setTitle("Basic Dialog")
            .setIcon(R.mipmap.ic_launcher)
            .setMessage("This is a basic dialog with 3 action buttons.")
            .setPositiveButton("Positive") { _, _ -> showSnackBar("Positive clicked") } // OK
            .setNegativeButton("Negative") { _, _ -> showSnackBar("Negative clicked") } // Cancel
            .setNeutralButton("Neutral") { _, _ -> showSnackBar("Neutral clicked") } // Remind me later
            .show()
    }


    private fun onItemsDialogClicked(view: View) {
        AlertDialog.Builder(requireContext())
            .setTitle("Items")
            // .setMessage("A message") // Não podemos usar setMessage neste caso!
            .setItems(items) { _, which ->
                showSnackBar("Selected: ${items[which]}")
            }
            .setNegativeButton("Cancel") { _, _ -> showSnackBar("Cancelled clicked") }
            .show()
    }


    private fun onSingleChoiceDialogClicked(view: View) {
        val default = 0
        var selected: String = items[default]

        AlertDialog.Builder(requireContext())
            .setTitle("Single Choice")
            .setSingleChoiceItems(items, default) { _, which ->
                selected = items[which]
                showSnackBar("Selected: $selected")
            }
            .setPositiveButton("Select") { _, _ -> showSnackBar("Chosen item: $selected") } // OK
            .show()
    }


    private fun onMultiChoiceDialogClicked(view: View) {
        val checkedArray = BooleanArray(items.size) // A Boolean array with the same size as items

        AlertDialog.Builder(requireContext())
            .setTitle("Multi Choice")
            .setMultiChoiceItems(items, checkedArray) { _, which, selected ->
                // We receive [which] item was clicked, and if it was [selected] (Boolean)
                checkedArray[which] = selected
            }
            .setPositiveButton("Finished") { _, _ ->
                val message = if (checkedArray.any { it }) {
                    items
                        .filterIndexed { index, s -> checkedArray[index] }
                        .joinToString(", ")
                } else {
                    "No items selected"
                }


                showSnackBar(message)
            }
            .show()
    }


    private fun showSnackBar(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
    }

}