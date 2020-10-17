package com.example.roomy2k

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.roomy2k.ui.billDetail.BillDetailFragment
import com.example.roomy2k.ui.choreDetail.ChoreDetailFragment
import com.example.roomy2k.ui.home.HomeFragment
import timber.log.Timber


class HomeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home_detail)

        val activityStartReason : String = intent.getStringExtra( resources.getString( R.string.intent_activity_start_reason ) )
        Timber.i( activityStartReason )



        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()


        if( activityStartReason.equals( resources.getString( R.string.intent_activity_start_reason_detail_bill ) ) ){
            Timber.i( "add bill detail fragment to activity")

            val billName : String = intent.getStringExtra( resources.getString( R.string.intent_activity_start_bill_name ) )
            Timber.i( "bill name: " + billName )

            val mFragmentBillDetail = BillDetailFragment()
            val bundle = Bundle().apply {
                putString( resources.getString( R.string.intent_activity_start_bill_name ), billName )
            }

            mFragmentBillDetail.arguments = bundle
            fragmentTransaction.add( R.id.home_detail_container, mFragmentBillDetail )

        } else if ( activityStartReason.equals( resources.getString( R.string.intent_activity_start_reason_detail_chore ) ) ){
            Timber.i( "add chore detail fragment to activity" )

            val mFragmentChoreDetail = ChoreDetailFragment()
            fragmentTransaction.add( R.id.home_detail_container, mFragmentChoreDetail )

        } else if ( activityStartReason.equals( resources.getString( R.string.intent_activity_start_reason_detail_shared ) ) ){
            Timber.i( "add shared detail fragment to activity" )
        } else {
            Timber.i( "placeholder" )
        }

        fragmentTransaction.commit()

    } //end onCreate

}