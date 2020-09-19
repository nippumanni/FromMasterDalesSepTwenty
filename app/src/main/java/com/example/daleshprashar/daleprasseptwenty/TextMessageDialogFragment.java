package com.example.daleshprashar.daleprasseptwenty;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

class TextMessageDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
       super.onCreateDialog(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.dialog_layout,null);
        TextView textViewTitle = contentView.findViewById(R.id.dialogTitle);
        TextView textViewMessage = contentView.findViewById(R.id.dialogMessage);
        Button positiveButton = contentView.findViewById(R.id.dialogButtonPositive);
        Button negativeButton = contentView.findViewById(R.id.dialogButtonNegative);
        textViewTitle.setClickable(false);
// ImageView can be here
        return super.onCreateDialog(savedInstanceState);
        // A custom Dialog can be based on
    }



    public class DialogBuilder
    {
        public DialogBuilder(FragmentActivity  fragmentActivity)
        {

        }
    }
   public void BuildDialog(Context context) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        //dialogBuilder.setView(rootView/Linerlayout);
       final onDialogDismissLisneter dialogDismissListener= new onDialogDismissLisneter() {
           @Override
           public void onDismiss(DialogInterface dialog) {

           }

           @Override
           public void onCancel(DialogInterface dialogInterface) {

           }
       };
       dialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
           @Override
           public void onDismiss(DialogInterface dialogInterface) {
               dialogDismissListener.onDismiss(dialogInterface);           }
       });
    }

   public interface onDialogDismissLisneter
    {
        void onDismiss(DialogInterface dialog);

        void onCancel (DialogInterface dialogInterface);
    }
}
