package com.example.daleshprashar.daleprasseptwenty;

import android.app.Activity;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

class CommonActivity extends AppCompatActivity //implements  WebServiceListener
{
    protected Toolbar myToolbar;

   public void  setContentView(int layoutResId, boolean handleToolBar)
    {
      if (handleToolBar){
        View layout = getLayoutInflater().inflate(layoutResId, null);
        myToolbar = new Toolbar(this);
        ((ViewGroup) layout).addView(myToolbar, 0);
          super.setContentView(layoutResId);
        initToolBar(layout);
      }else
      {
          super.setContentView(layoutResId);
      }
    }

    protected void initToolBar(View layout)
    {
        TypedArray styledAttributes = getTheme().obtainStyledAttributes(
                new int[android.R.attr.actionBarSize]);
        int mActionBarSize =(int) styledAttributes.getDimension(0,0);
        styledAttributes.recycle();

        ViewGroup.LayoutParams toolBarparams = null;
        if (layout   instanceof RelativeLayout) {
            toolBarparams = new RelativeLayout.LayoutParams(
                    androidx.appcompat.widget.Toolbar.LayoutParams.MATCH_PARENT, mActionBarSize);
        }       //else if    same for  LinearLayout, FrameLayout,  CoordinatorLayout

        myToolbar.setLayoutParams(toolBarparams);
        //  .setbackgroundColor(color)  etc.

        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       // generally Arrow or Back image in below
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_launcher_background);
        getSupportActionBar().setTitle("Base toobar");
        }

public static void setCustomTheme(Activity activity)
{
    activity.setTheme(R.style.AppTheme);
}

public void showProgressDialog(String tag)
{
    Fragment fragmentByTag = getSupportFragmentManager().findFragmentByTag(tag);
if (fragmentByTag != null)
{
    DialogFragment dialogFragment = (DialogFragment) fragmentByTag;
    dialogFragment.dismiss();
    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    transaction.remove(fragmentByTag);
    transaction.commit();
    new CoreLoa
}
}



}

