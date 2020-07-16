package com.wiz.wizartrans

import android.database.Observable
import androidx.databinding.ObservableField
import com.wiz.architecture.mvvm.viewmodel.StateViewModel

class SampleFragViewModel : StateViewModel() {
    val name = ObservableField<String>()
}