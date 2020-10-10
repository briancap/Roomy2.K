package com.example.roomy2k

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.roomy2k.ui.billDetail.BillDetailFragment
import com.example.roomy2k.ui.home.HomeFragment


class HomeDetailActivity : AppCompatActivity() {

    val LOG_TAG: String = javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_detail)

        val activityStartReason : String = intent.getStringExtra( resources.getString( R.string.intent_activity_start_reason ) )
        Log.v( LOG_TAG, activityStartReason )



        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()


        if( activityStartReason.equals( resources.getString( R.string.intent_activity_start_reason_detail_bill ) ) ){
            Log.e( LOG_TAG, "add bill detail fragment to activity")

            val billName : String = intent.getStringExtra( resources.getString( R.string.intent_activity_start_bill_name ) )
            Log.v( LOG_TAG, "bill name: " + billName )

            val mFragmentBillDetail = BillDetailFragment()
            val bundle = Bundle().apply {
                putString( resources.getString( R.string.intent_activity_start_bill_name ), billName )
            }

            mFragmentBillDetail.arguments = bundle
            fragmentTransaction.add( R.id.home_detail_container, mFragmentBillDetail )

        } else if ( activityStartReason.equals( resources.getString( R.string.intent_activity_start_reason_detail_chore ) ) ){
            Log.e( LOG_TAG, "add chore detail fragment to activity" )

            val mFragmentChoreDetail = ChoreDetailFragment()
            fragmentTransaction.add( R.id.home_detail_container, mFragmentChoreDetail )

        } else if ( activityStartReason.equals( resources.getString( R.string.intent_activity_start_reason_detail_shared ) ) ){
            Log.e( LOG_TAG, "add shared detail fragment to activity" )
        } else {
            Log.v( LOG_TAG, "placeholder" )
        }

        fragmentTransaction.commit()

    } //end onCreate

}