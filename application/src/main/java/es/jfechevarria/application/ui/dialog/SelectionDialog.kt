package es.jfechevarria.application.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import es.jfechevarria.application.R

object SelectionDialog {
    fun createSelectionDialog(context: Context,
        onOpenUserPage: () -> Unit,
        onOpenProjectPage: () -> Unit): Dialog {
        val builder = AlertDialog.Builder(context)
            .setTitle(context.resources.getString(R.string.action_selection))
            .setItems(R.array.selection_actions_array) { dialog, which ->
                when (which) {
                    0 -> onOpenUserPage()
                    1 -> onOpenProjectPage()
                    else -> {}
                }
                dialog.dismiss()
            }
        return builder.create()
    }
}