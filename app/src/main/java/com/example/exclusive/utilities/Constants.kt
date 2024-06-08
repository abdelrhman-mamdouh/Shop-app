package com.example.exclusive.utilities

import android.app.Activity
import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.exclusive.R
import com.example.exclusive.data.model.DiscountCode
import com.example.exclusive.data.model.PriceRuleSummary
import com.example.exclusive.databinding.DialogCouponDetailBinding
import com.example.exclusive.databinding.GoToLoginDialogBinding

object Constants {
    const val GOOGLE_KEY: String = "AIzaSyCzL-KKINpE6at4j4zH8qNXAB6eMn8Y0L0"
    const val BASE_URL: String = "https://mad44-android-sv-2.myshopify.com/api/2024-04/graphql.json"
    const val CURRENCY_BASE_URL: String = "https://api.fastforex.io/"
    const val API_KEY: String = "43f6205d2d0b257b652e16f5f7663414"
    const val ACCESS_TOKEN: String = "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"
    const val CURRENCY_API_KEY: String = "8167943cff-63381be909-sellqo"

    fun showAlert(context: Context, title: Int, message: String, icon: Int) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(R.string.app_name) { _, _ -> }
            .setIcon(icon)
            .show()
    }

    fun showCouponDetailDialog(activity: Activity, couponDetail: DiscountCode, priceRuleSummary: PriceRuleSummary, onDismiss: () -> Unit) {
        val binding = DialogCouponDetailBinding.inflate(activity.layoutInflater)
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(binding.root)

        binding.tvCouponCode.text = "Code: ${couponDetail.code}"
        binding.tvDiscountValue.text = priceRuleSummary.value.toString()+"%"
        binding.tvDiscountType.text = priceRuleSummary.valueType
        binding.tvDiscountLimit.text = priceRuleSummary.usageLimit.toString()
        binding.tvDiscountSelection.text = priceRuleSummary.customerSelection
        binding.tvDiscountValid.text = "Valid from : "+priceRuleSummary.startsAt + "  to: " + priceRuleSummary.endsAt


        binding.btnCopyCode.setOnClickListener {
            val clipboard = activity.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Coupon Code", couponDetail.code)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(activity, "Coupon code copied to clipboard", Toast.LENGTH_SHORT).show()
        }

        dialog.setCanceledOnTouchOutside(true)

        dialog.setOnDismissListener {
            onDismiss()
        }

        dialog.show()
    }



    fun playAnimation(view: View, context: Context, animation: Int) {
        view.startAnimation(AnimationUtils.loadAnimation(context, animation))
    }
}