package com.example.bottomsheetdialogfragment

import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomCalendar() : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottom_dialog, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var bottomDialog : Dialog = super.onCreateDialog(savedInstanceState)

        bottomDialog.setOnShowListener {
            var bottomSheetDialog = it as BottomSheetDialog
            setupRatio(bottomSheetDialog)
        }
        return bottomDialog
    }

    fun setupRatio(bottomSheetDialog : BottomSheetDialog) {
        val bottomSheet : FrameLayout? = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet)
        val behavior  = BottomSheetBehavior.from(bottomSheet as FrameLayout)

        BottomSheetBehavior.from(bottomSheet).skipCollapsed = true

        val lp =  bottomSheet.layoutParams
        // 특정 높이만큼만 띄워주고싶으면 lp 에 계산식 추가
        // ex. 85% 하고싶은경우 lp * 85 * 100
        // https://stackoverflow.com/questions/58651661/how-to-set-max-height-in-bottomsheetdialogfragment
        lp.height = getWindowHeight()
        bottomSheet.layoutParams = lp
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    fun getWindowHeight() : Int {
        var displayMetrics = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }
}