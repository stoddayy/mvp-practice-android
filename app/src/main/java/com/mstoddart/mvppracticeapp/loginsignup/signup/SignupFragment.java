package com.mstoddart.mvppracticeapp.loginsignup.signup;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mstoddart.mvppracticeapp.R;
import com.mstoddart.mvppracticeapp.data.User;
import com.mstoddart.mvppracticeapp.loginsignup.LoginSignupFragmentInteractionListener;
import com.mstoddart.mvppracticeapp.utils.FieldValidationCallback;

public class SignupFragment extends Fragment implements SignupContract.View {

    private LoginSignupFragmentInteractionListener fragListener;
    private Context mContext;

    SignupContract.Presenter mPresenter;

    private TextView txtSignupTitle;
    private EditText etSignupName, etSignupEmail, etSignupPassword;
    private Button btnSignupConfirm;

    public SignupFragment() {
        // Required empty public constructor
    }

    public static SignupFragment newInstance() {
        SignupFragment fragment = new SignupFragment();
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
        mPresenter = new SignupPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        setupTextViews(view);
        setupEditTexts(view);
        setupButtons(view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    private void setupTextViews(View view){
        txtSignupTitle = (TextView) view.findViewById(R.id.txt_signup_title);
    }

    private void setupEditTexts(View view){
        etSignupName = (EditText) view.findViewById(R.id.et_signup_name);
        etSignupEmail = (EditText) view.findViewById(R.id.et_signup_email);
        etSignupPassword = (EditText) view.findViewById(R.id.et_signup_password);
    }

    private void setupButtons(View view){
        btnSignupConfirm = (Button) view.findViewById(R.id.btn_signup_confirm);

        btnSignupConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.validateSignupFields(etSignupName.getText().toString(), etSignupEmail.getText().toString(), etSignupPassword.getText().toString(), new FieldValidationCallback() {
                    @Override
                    public void onSuccess() {
                        User user = new User(etSignupName.getText().toString(), etSignupEmail.getText().toString(), etSignupPassword.getText().toString());
                        mPresenter.saveUser(user, mContext);
                    }

                    @Override
                    public void onFail(String errorCode) {

                    }
                });
            }
        });
    }

    @Override
    public void setPresenter(SignupContract.Presenter presenter) {
        if (presenter != null) {
            mPresenter = presenter;
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void navigateToPokemonActivity() {
        fragListener.navigateToPokemonActivity();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
