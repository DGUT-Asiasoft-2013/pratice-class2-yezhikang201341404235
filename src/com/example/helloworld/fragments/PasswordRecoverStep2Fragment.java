package com.example.helloworld.fragments;

import com.example.helloworld.R;
import com.example.helloworld.fragments.inputcells.SimpleTextInputCellFragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PasswordRecoverStep2Fragment extends Fragment {
	SimpleTextInputCellFragment fragPassword,fragPasswordRepeat,fragVerify;
	View view;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		if(view==null){
			view = inflater.inflate(R.layout.fragment_password_recover_step2, null);
			fragPassword = (SimpleTextInputCellFragment) getFragmentManager().findFragmentById(R.id.input_password);
			fragPasswordRepeat = (SimpleTextInputCellFragment) getFragmentManager().findFragmentById(R.id.input_password_repeat);
			fragVerify=(SimpleTextInputCellFragment)getFragmentManager().findFragmentById(R.id.input_verify);
			view.findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					onSubmitClicked();
				}
			});
		}
		
		return view;
	}
	@Override
	public void onResume() {
		super.onResume();


		fragPassword.setLabelText("密码");{
			fragPassword.setHintText("请输入新密码");
			fragPassword.setIsPassword(true);	
		}

		fragPasswordRepeat.setLabelText("重复密码");{
			fragPasswordRepeat.setHintText("请再次输入新密码");
			fragPasswordRepeat.setIsPassword(true);	
		}

		fragVerify.setLabelText("验证码");{
			fragVerify.setHintText("请输入验证码");
			fragVerify.setIsPassword(true);
		}

		
	}
	
	public String getText(){
		return fragPassword.getText();
	}
	
	public static interface OnSubmitClickedListener{
		void onSubmitClicked();
	}
	
	OnSubmitClickedListener onSubmitClickedListener;
	
	public void setOnSubmitClickedListener(OnSubmitClickedListener onSubmitClickedListener) {
		this.onSubmitClickedListener = onSubmitClickedListener;
	}
	
	void onSubmitClicked(){
		if(fragPassword.getText().equals(fragPasswordRepeat.getText())){
			if(onSubmitClickedListener!=null){
				onSubmitClickedListener.onSubmitClicked();
			}
		}else{
			new AlertDialog.Builder(getActivity())
			.setMessage("密码不一致")
			.show();
		}
	}
	
}
