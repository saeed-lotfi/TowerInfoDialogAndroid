package com.seedlotfi.towerinfodialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.core.content.ContextCompat
import com.seedlotfi.towerinfodialog.R
import kotlinx.android.synthetic.main.tower_dialog.*

/**
 * Show Dialog
 */
class TowerDialog private constructor() {
    companion object {
        private var mContext: Context? = null
        private var mIsSuccess: Boolean = true
        private var mTitle: String = ""
        private var mMessage: String = ""
        private var mButtonText: String = "Done"
        private var mTitleIsBold = false

        class Builder {

            /**
             * set context
             */
            fun setContext(context: Context): Builder {
                mContext = context
                return this
            }


            /**
             * set custom text to button
             */
            fun setButtonText(text: String): Builder {
                mButtonText = text
                return this
            }

            /**
             * determine the dialog is Success
             */
            fun setIsSuccess(isSuccess: Boolean): Builder {
                mIsSuccess = isSuccess
                return this
            }

            /**
             * set title
             */
            fun setTitle(title: String): Builder {
                mTitle = title
                return this
            }

            /**
             * set message
             */
            fun setMessage(message: String): Builder {
                mMessage = message
                return this
            }

            fun setTileIsBold(titleIsBold: Boolean): Builder {
                mTitleIsBold = titleIsBold
                return this
            }


            /**
             * build the builder
             * @exception NullPointerException mContext is null
             */
            fun build(): TowerDialog {
                if (mContext == null)
                    throw (NullPointerException("context need to show dialog"))
                return TowerDialog()
            }


        }
    }


    /**
     * show the dialog
     */
    fun show(click: () -> Unit) {
        val dialog = getDialog(context = mContext!!)

        /**
         * change the background
         */
        if (!mIsSuccess) {
            dialog.dialog_icon.setBackgroundResource(R.drawable.circular_shape_error)
            dialog.dialog_icon.setImageDrawable(
                ContextCompat.getDrawable(
                    mContext!!,
                    R.drawable.ic_close_white_24dp
                )
            )

            dialog.dialog_button.setBackgroundResource(R.drawable.background_error_button)

        }

        dialog.dialog_action_title.text = mTitle

        if (mMessage != "") {
            dialog.dialog_action_message.visibility = View.VISIBLE
            dialog.dialog_action_message.text = mMessage
        }

        dialog.dialog_button.text = mButtonText

        if (mTitleIsBold)
            dialog.dialog_action_title.typeface = Typeface.DEFAULT_BOLD

        dialog.dialog_button.setOnClickListener {
            dialog.cancel()
            click.invoke()
        }

        dialog.show()
    }

    /**
     * create dialog*/
    private fun getDialog(context: Context): Dialog {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.tower_dialog)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return dialog
    }

}