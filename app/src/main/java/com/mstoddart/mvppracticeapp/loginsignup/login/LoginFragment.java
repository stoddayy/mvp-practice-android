package com.mstoddart.mvppracticeapp.loginsignup.login;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mstoddart.mvppracticeapp.R;
import com.mstoddart.mvppracticeapp.loginsignup.LoginSignupFragmentInteractionListener;
import com.mstoddart.mvppracticeapp.utils.FieldValidationCallback;


/**
 * Method Order:
 * Lifecycle
 * View setup
 * Contract Methods
 */
public class LoginFragment extends Fragment implements LoginContract.View {

    private LoginSignupFragmentInteractionListener fragListener;
    private Context mContext;

    private LoginContract.Presenter mPresenter;

    private EditText etLoginEmail, etLoginPassword;
    private Button btnLoginConfirm;
    private TextView txtLoginTitle, txtLoginSwitchToSignUp;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        fragListener = (LoginSignupFragmentInteractionListener) context;
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new LoginPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        setupTextViews(rootView);
        setupButtons(rootView);
        setupEditTexts(rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    private void setupTextViews(View view){
        txtLoginTitle = (TextView) view.findViewById(R.id.txt_login_title);
        txtLoginSwitchToSignUp = (TextView) view.findViewById(R.id.txt_login_swith_to_sign_up);

        txtLoginSwitchToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToSignUp();
            }
        });
    }

    private void setupButtons(View view){
        btnLoginConfirm = (Button) view.findViewById(R.id.btn_login_confirm);

        btnLoginConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.validateFields(new FieldValidationCallback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onFail(String errorCode) {

                    }
                });
            }
        });
    }

    private void setupEditTexts(View view){
        etLoginEmail = (EditText) view.findViewById(R.id.et_login_email);
        etLoginPassword = (EditText) view.findViewById(R.id.et_login_password);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        if(presenter !=null){
            mPresenter = presenter;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public EditText getLoginEmailEt() {
        return etLoginEmail;
    }

    @Override
    public EditText getLoginPasswordEt() {
        return etLoginPassword;
    }

    @Override
    public void switchToSignUp() {
        fragListener.setSignupFrag();
    }
}
