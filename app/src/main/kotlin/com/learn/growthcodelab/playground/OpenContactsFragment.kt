package com.learn.growthcodelab.playground

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.growthcodelab.R
import com.learn.growthcodelab.databinding.FragmentOpenContactsBinding
import com.learn.growthcodelab.fragment.BaseFragment

class OpenContactsFragment : BaseFragment(), View.OnClickListener {

    companion object {
        fun newInstance() = OpenContactsFragment()
    }

    override fun onClick(view: View?) {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = ContactsContract.Contacts.CONTENT_TYPE
        intent.resolveActivity(activity.packageManager)?.let {
            _-> startActivityForResult(intent, 1)
        }
    }

    override fun getLayoutRes() = R.layout.fragment_open_contacts

    override fun bindView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding: FragmentOpenContactsBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.onClickedListener = this
        return binding.root
    }

}